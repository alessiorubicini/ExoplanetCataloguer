package it.unicam.cs.mgc.exoplanetCataloguer.model;

import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.rdf.model.*;
import org.apache.jena.reasoner.Reasoner;
import org.apache.jena.reasoner.ReasonerRegistry;
import org.apache.jena.reasoner.ValidityReport;
import org.apache.jena.util.FileManager;

import java.util.Iterator;
import java.util.Objects;

/**
 * This class is used to manage the underlying OWL ontology
 */
public class OntologyController {

    private InfModel ontologyModel;
    private final OntologyQueryExecutor queryExecutor;

    public OntologyController() {
        this.ontologyModel = this.buildAndLoadOWLDLModel();
        this.queryExecutor = new OntologyQueryExecutor();
    }

    /**
     * Builds an inferred model with OWL rules inference engine and loads the ontology RDF file
     */
    public InfModel buildAndLoadOWLDLModel() {
        OntModel model = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM_RULE_INF);
        FileManager fileManager = FileManager.getInternal();
        model.read(fileManager.open(Objects.requireNonNull(getClass().getResource("/owl/exoplanet-ontology.rdf")).toString()), null);
        Reasoner reasoner = ReasonerRegistry.getOWLReasoner().bindSchema(model);
        return ModelFactory.createInfModel(reasoner, model);
    }

    /**
     * Gets data from the ontology model
     * @param query the data
     * @return the data chunk result of the query
     */
    public ParsedData get(SelectionQueries query) {
        JSONParser parser = new JSONParser();
        return parser.parse(this.queryExecutor.perform(query, this.ontologyModel));
    }

    /**
     * Gets data from the ontology model
     * @param query the data
     * @param args the parameter for the query
     * @return the data chunk result of the query
     */
    public ParsedData get(SelectionQueries query, Object...args) {
        JSONParser parser = new JSONParser();
        return parser.parse(this.queryExecutor.perform(query, this.ontologyModel, args));
    }

    /**
     * Posts a data update to the ontology model
     * @param query
     */
    public void post(UpdateQueries query) {
        this.queryExecutor.perform(query, this.ontologyModel);
    }

    /**
     * Checks if the model is valid and consistent
     * @return true if it's valid
     */
    public boolean isOntologyConsistent() {
        ValidityReport validity = this.ontologyModel.validate();
        for (Iterator<ValidityReport.Report> iter = validity.getReports(); iter.hasNext(); ) {
            ValidityReport.Report report = iter.next();
            System.out.println(report);
        }
        return validity.isValid();
    }

    /**
     * Checks if the given statement has been correctly inferred
     * @param subject the subject of the statement
     * @param predicate the predicate of the statement
     * @param object the object of the statement
     * @return true if the statement has been inferred
     */
    public boolean isCorrectlyInferred(Resource subject, Property predicate, Resource object) {
        return this.ontologyModel.contains(subject, predicate, object);
    }

}
