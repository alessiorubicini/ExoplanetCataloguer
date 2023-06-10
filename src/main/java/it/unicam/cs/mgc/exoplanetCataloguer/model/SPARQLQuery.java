package it.unicam.cs.mgc.exoplanetCataloguer.model;

public interface SPARQLQuery {

    String getQueryString();

    /**
     *
     * @param values
     * @return
     */
    String getQueryString(Object... values);

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
