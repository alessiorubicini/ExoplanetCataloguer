package it.unicam.cs.mgc.exoplanetCataloguer.model;

import it.unicam.cs.mgc.exoplanetCataloguer.model.queries.SparqlQuery;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.rdf.model.Model;

/**
 * Classes implementing this interface are used to perform SPARQL query on an ontology RDF model.
 */
public interface QueryExecutor {

    /**
     * Performs a Sparql query on the given model.
     *
     * @param query the query to perform
     * @param model the target of the query
     * @return the query execution
     */
    QueryExecution perform(SparqlQuery query, Model model);

    /**
     * Performs a parameterized Sparql query on the given model.
     *
     * @param query the query to perform
     * @param model the target of the query
     * @param args the arguments for the query
     * @return the query execution
     */
    QueryExecution perform(SparqlQuery query, Model model, Object... args);


}
