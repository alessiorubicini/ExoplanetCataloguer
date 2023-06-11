package it.unicam.cs.mgc.exoplanetCataloguer.model;

import org.apache.jena.query.QueryExecution;

/**
 * Classes implementing this interface are used to parse the data obtained from a SPARQL query
 * into a specific format
 */
public interface DataParser {

    /**
     * Parses the result from a SPARQL query execution to a chunk of data
     * @param queryExecution the SPARQL query execution
     * @return the data chunk from the query result
     */
    ParsedData parse(QueryExecution queryExecution);

}
