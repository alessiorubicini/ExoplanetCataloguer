package it.unicam.cs.mgc.exoplanetCataloguer.model.queries;

/**
 * Enumerations implementing this interface are used to represent and group SPARQL queries
 */
public interface SparqlQuery {

    /**
     * Returns the SPARQL query as a string
     * @return the SPARQL query as a string
     */
    String getQueryString();

    /**
     * Returns a formatted SPARQL query with the specified arguments.
     * @param args Arguments referenced by the format specifiers in the format string.
     * @return a formatted string containing the SPARQL query
     */
    String getQueryString(Object... args);

    default String getCompleteQuery() {
        return getPrefixes() + this.getQueryString();
    }

    default String getCompleteQuery(Object...args) {
        return getPrefixes() + this.getQueryString(args);
    }

    /**
     * Get the SPARQL prefixes necessary for queries
     * @return a string containing SPARQL prefixes
     */
    static String getPrefixes() {
        return """
                PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>
                PREFIX foaf: <http://xmlns.com/foaf/0.1/>
                PREFIX owl: <http://www.w3.org/2002/07/owl#>
                PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>
                PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>
                PREFIX om: <http://www.ontology-of-units-of-measure.org/resource/om-2/>
                PREFIX exo: <https://www.unicam.it/cs/alessiorubicini/exoplanet-ontology#>
                """;
     }
}
