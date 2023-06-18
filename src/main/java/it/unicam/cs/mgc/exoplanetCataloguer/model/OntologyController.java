package it.unicam.cs.mgc.exoplanetCataloguer.model;

import it.unicam.cs.mgc.exoplanetCataloguer.model.builders.InferredModelBuilder;
import it.unicam.cs.mgc.exoplanetCataloguer.model.queries.SelectionQuery;
import it.unicam.cs.mgc.exoplanetCataloguer.model.queries.UpdateQuery;
import it.unicam.cs.mgc.exoplanetCataloguer.model.util.OntologyURI;
import openllet.jena.PelletReasonerFactory;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.rdf.model.*;

/**
 * This class is used to manage the underlying app ontology.
 */
public class OntologyController {

    private Model model;
    private final InferredModelBuilder modelBuilder = new InferredModelBuilder();
    private final OntologyQueryExecutor queryExecutor = new OntologyQueryExecutor();

    public OntologyController() {
        this.model = modelBuilder.buildOntologyModel(OntModelSpec.OWL_DL_MEM, OntologyURI.LOCAL.getURI());
        this.startInference();
    }

    /**
     * Starts inference on the RDF model replacing it with a new inferred model.
     */
    public void startInference() {
        this.model = modelBuilder.buildInferredModel(model, PelletReasonerFactory.THE_SPEC.getReasoner());
    }

    /**
     * Gets data from the ontology model.
     *
     * @param query the data
     * @return the data chunk result of the query
     */
    public ParsedData get(SelectionQuery query) {
        JSONParser parser = new JSONParser();
        QueryExecution queryExecution = queryExecutor.perform(query, this.model);
        return parser.parse(queryExecution);
    }

    /**
     * Gets data from the ontology model passing some arguments.
     *
     * @param query the data
     * @param args the parameter for the query
     * @return the data chunk result of the query
     */
    public ParsedData get(SelectionQuery query, Object...args) {
        JSONParser parser = new JSONParser();
        QueryExecution queryExecution = queryExecutor.perform(query, this.model, args);
        return parser.parse(queryExecution);
    }

    /**
     * Posts a data update to the ontology model.
     *
     * @param query the SPARQL update query
     */
    public void post(UpdateQuery query) {
        queryExecutor.perform(query, this.model);
    }

    /**
     * Checks if the built inferred model is consistent.
     *
     * @return true if the model is consistent
     */
    public boolean isConsistent() {
        if(this.model instanceof InfModel) {
            return InferredModelBuilder.isModelConsistent((InfModel) model);
        }
        return false;
    }

}
