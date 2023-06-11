package it.unicam.cs.mgc.exoplanetCataloguer.model;

import org.apache.jena.query.QueryExecution;
import org.apache.jena.rdf.model.Model;

/**
 * Classes implementing this interface are used to perform SPARQL query on a ontology RDF model.
 */
public interface QueryExecutor {

    /**
     * Performs a Sparql selection query on the given model
     * @param query the query to perform
     * @param model the target of the query
     * @return an iterator over a JSON collection of ontology statements
     */
    QueryExecution perform(SelectionQueries query, Model model);

    /**
     * Performs a Sparql selection query that takes parameters on the given model
     * @param query the query to perform
     * @param model the target of the query
     * @param args the arguments for the query
     * @return an iterator over a JSON collection of ontology statements
     */
    QueryExecution perform(SelectionQueries query, Model model, Object... args);

    /**
     * Performs a Sparql update query on the given model
     * @param query the query to perform
     * @param model the target of the query
     */
    void perform(UpdateQueries query, Model model);

}
