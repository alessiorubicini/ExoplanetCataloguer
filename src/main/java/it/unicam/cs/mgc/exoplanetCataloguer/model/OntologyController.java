package it.unicam.cs.mgc.exoplanetCataloguer.model;

import it.unicam.cs.mgc.exoplanetCataloguer.model.builders.InferredModelBuilder;
import it.unicam.cs.mgc.exoplanetCataloguer.model.util.OntologyURIs;
import org.apache.jena.rdf.model.*;
import org.apache.jena.reasoner.ReasonerRegistry;

import java.util.concurrent.CompletableFuture;

/**
 * This class is used to manage the underlying OWL ontology
 */
public class OntologyController {

    private Model model;
    private final InferredModelBuilder modelBuilder = new InferredModelBuilder();
    private final OntologyQueryExecutor queryExecutor;
    private boolean inferredModelReady = false;

    public OntologyController() {
        this.queryExecutor = new OntologyQueryExecutor();
        this.model = modelBuilder.buildDefaultModel(OntologyURIs.LOCAL.getURI());
        CompletableFuture<InfModel> futureInferredModel = modelBuilder.buildInferredModelAsync(model, ReasonerRegistry.getOWLReasoner());
        futureInferredModel.thenAccept(inferredModel -> {
            this.model = inferredModel;
            this.inferredModelReady = true;
        });
    }

    /**
     * Gets data from the ontology model
     * @param query the data
     * @return the data chunk result of the query
     */
    public JSONData get(SelectionQueries query) {
        JSONParser parser = new JSONParser();
        return parser.parse(this.queryExecutor.perform(query, this.model));
    }

    /**
     * Gets data from the ontology model
     * @param query the data
     * @param args the parameter for the query
     * @return the data chunk result of the query
     */
    public JSONData get(SelectionQueries query, Object...args) {
        JSONParser parser = new JSONParser();
        return parser.parse(this.queryExecutor.perform(query, this.model, args));
    }

    /**
     * Posts a data update to the ontology model
     * @param query
     */
    public void post(UpdateQueries query) {
        this.queryExecutor.perform(query, this.model);
    }

    public boolean isConsistent() {

        return true;
    }

    public boolean isInferredModelReady() {
        return inferredModelReady;
    }
}
