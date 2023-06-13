package it.unicam.cs.mgc.exoplanetCataloguer.model;

import it.unicam.cs.mgc.exoplanetCataloguer.model.builders.InferredModelBuilder;
import it.unicam.cs.mgc.exoplanetCataloguer.model.queries.SelectionQuery;
import it.unicam.cs.mgc.exoplanetCataloguer.model.queries.UpdateQuery;
import it.unicam.cs.mgc.exoplanetCataloguer.model.util.OntologyURI;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.rdf.model.*;
import org.apache.jena.reasoner.ReasonerRegistry;

/**
 * This class is used to manage the underlying OWL ontology
 */
public class OntologyController {

    private Model model;
    private final InferredModelBuilder modelBuilder = new InferredModelBuilder();
    private final OntologyQueryExecutor queryExecutor;
    private boolean hasBeenInferred = false;

    public OntologyController() {
        this.queryExecutor = new OntologyQueryExecutor();
        this.model = modelBuilder.buildOntologyModel(OntModelSpec.OWL_DL_MEM, OntologyURI.LOCAL.getURI());
        this.startInference();
    }

    public void startInference() {
        this.model = modelBuilder.buildInferredModel(model, ReasonerRegistry.getOWLReasoner());
        /*CompletableFuture<InfModel> futureInferredModel = modelBuilder.buildInferredModelAsync(model, ReasonerRegistry.getOWLReasoner());
        futureInferredModel.thenAccept(inferredModel -> {
            this.model = inferredModel;
            this.hasBeenInferred = true;
        });*/
    }

    /**
     * Gets data from the ontology model
     * @param query the data
     * @return the data chunk result of the query
     */
    public JSONData get(SelectionQuery query) {
        JSONParser parser = new JSONParser();
        return parser.parse(this.queryExecutor.perform(query, this.model));
    }

    /**
     * Gets data from the ontology model
     * @param query the data
     * @param args the parameter for the query
     * @return the data chunk result of the query
     */
    public JSONData get(SelectionQuery query, Object...args) {
        JSONParser parser = new JSONParser();
        return parser.parse(this.queryExecutor.perform(query, this.model, args));
    }

    /**
     * Posts a data update to the ontology model
     * @param query
     */
    public void post(UpdateQuery query) {
        this.queryExecutor.perform(query, this.model);
    }

    public boolean isConsistent() {

        return true;
    }

    public boolean hasBeenInferred() {
        return hasBeenInferred;
    }
}
