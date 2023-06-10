package it.unicam.cs.mgc.exoplanetCataloguer.model;

import org.apache.jena.atlas.json.JsonObject;
import org.apache.jena.rdf.model.Model;

import java.util.Iterator;

/**
 * Classes implementing this interface are used to perform SPARQL query on a ontology RDF model.
 */
public interface SPARQLQueryExecutor {

    /**
     * Performs a Sparql selection query on the given model
     * @param query the query to perform
     * @param model the target of the query
     * @return an iterator over a JSON collection of ontology statements
     */
    Iterator<JsonObject> perform(SelectionQuery query, Model model);

    /**
     * Performs a Sparql selection query on the given model
     * @param query the query to perform
     * @param parameter the parameter for the query
     * @param model the target of the query
     * @return an iterator over a JSON collection of ontology statements
     */
    Iterator<JsonObject> perform(SelectionQuery query, String parameter, Model model);

    /**
     * Performs a Sparql update query on the given model
     * @param query the query to perform
     * @param model the target of the query
     */
    void perform(UpdateQuery query, Model model);

}
