package it.unicam.cs.mgc.exoplanetCataloguer.model;

import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.rdf.model.*;
import org.apache.jena.reasoner.Reasoner;
import org.apache.jena.reasoner.ReasonerRegistry;
import org.apache.jena.reasoner.ValidityReport;
import org.apache.jena.util.FileManager;
import org.apache.jena.atlas.json.JsonObject;

import java.util.Iterator;
import java.util.Objects;

/**
 * This class is used to manage the underlying OWL ontology
 */
public class OntologyController {

    private InfModel ontologyModel;
    private OntologyQueryExecutor queryExecutor;

    public OntologyController() {
        this.buildAndLoadOWLDLModel();
        this.queryExecutor = new OntologyQueryExecutor();
    }

    /**
     * Builds an inferred model with OWL rules inference engine and loads the ontology RDF file
     */
    public void buildAndLoadOWLDLModel() {
        OntModel model = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM_RULE_INF);
        FileManager fileManager = FileManager.getInternal();
        model.read(fileManager.open(Objects.requireNonNull(getClass().getResource("/owl/exoplanets-ontology.rdf")).toString()), null);
        Reasoner reasoner = ReasonerRegistry.getOWLReasoner().bindSchema(this.ontologyModel);
        this.ontologyModel = ModelFactory.createInfModel(reasoner, this.ontologyModel);
    }

    /**
     * Asks data to the ontology model
     * @param query the data
     * @return
     */
    public Iterator<JsonObject> get(SelectionQuery query) {
        return this.queryExecutor.perform(query, this.ontologyModel);
    }

    /**
     * Asks data to the ontology model
     * @param query the data
     * @return
     */
    public Iterator<JsonObject> get(SelectionQuery query, String parameter) {
        return this.queryExecutor.perform(query, parameter, this.ontologyModel);
    }

    /**
     * Posts a data update to the ontology model
     * @param query
     */
    public void post(UpdateQuery query) {
        this.queryExecutor.perform(query, this.ontologyModel);
    }

    /**
     * Checks if the model is valid and consistent
     * @return true if it's valid
     */
    public boolean isOntologyConsistent() {
        ValidityReport validity = this.ontologyModel.validate();
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
