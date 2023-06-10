package it.unicam.cs.mgc.exoplanetCataloguer.model;

import org.apache.jena.query.QueryExecution;

/**
 * Classes implementing this interface are used to parse the data obtained from a SPARQL query
 * into a specific format
 */
public interface DataParser {

    /**
     * Parses data from a SPARQL query execution to app data
     * @param queryExecution
     * @return the query result in a specific format
     */
    AppData parse(QueryExecution queryExecution);

}
