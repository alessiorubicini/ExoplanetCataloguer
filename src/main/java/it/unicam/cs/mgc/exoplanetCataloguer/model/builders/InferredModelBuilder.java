package it.unicam.cs.mgc.exoplanetCataloguer.model.builders;

import org.apache.jena.rdf.model.*;
import org.apache.jena.reasoner.Reasoner;
import org.apache.jena.reasoner.ReasonerRegistry;
import org.apache.jena.reasoner.ValidityReport;

import java.util.concurrent.CompletableFuture;

public class InferredModelBuilder extends DefaultModelBuilder {

    /**
     * Creates an inferred model.
     * @param model the input model.
     * @param reasoner the reasoner to use for inference.
     * @return A inferred model.
     */
    public InfModel buildInferredModel(Model model, Reasoner reasoner) {
        reasoner.bindSchema(model);
        return ModelFactory.createInfModel(reasoner, model);
    }

    /**
     * Creates an inferred model asynchronously.
     *
     * @param model    the input model.
     * @param reasoner the reasoner to use for inference
     * @return A CompletableFuture representing the asynchronous operation.
     */
    public CompletableFuture<InfModel> buildInferredModelAsync(Model model, Reasoner reasoner) {
        CompletableFuture<InfModel> future = new CompletableFuture<>();

        Thread thread = new Thread(() -> {
            try {
                reasoner.bindSchema(model);
                InfModel inferredModel = ModelFactory.createInfModel(reasoner, model);
                future.complete(inferredModel);
            } catch (Exception e) {
                future.completeExceptionally(e);
            }
        });

        thread.start();

        return future;
    }

    /**
     * Checks if the model is valid and consistent
     * @return true if it's valid
     */
    public static boolean isModelConsistent(InfModel model) {
        ValidityReport validity = model.validate();
        return validity.isValid();
    }

    /**
     * Checks if the given statement has been correctly inferred on the model
     * @param subject the subject of the statement
     * @param predicate the predicate of the statement
     * @param object the object of the statement
     * @return true if the statement has been inferred
     */
    public static boolean isCorrectlyInferred(Resource subject, Property predicate, Resource object, InfModel model) {
        return model.contains(subject, predicate, object);
    }

}
