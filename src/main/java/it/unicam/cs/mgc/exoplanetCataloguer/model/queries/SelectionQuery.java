package it.unicam.cs.mgc.exoplanetCataloguer.model.queries;

/**
 * This enumeration is used to represent a SPARQL query that select data from the ontology
 */
public enum SelectionQuery implements SparqlQuery {

    PLANETS_LIST("SELECT ?label ?value WHERE { ?planet rdf:type exo:Planet . BIND(?planet AS ?label) . ?planet rdfs:label ?value . }"),
    PLANET_DETAILS("SELECT ?label ?value WHERE { ?planet rdf:type exo:Planet .  ?planet rdfs:label \"%s\" . ?planet ?label ?value . }"),
    SEARCH_PLANET("SELECT ?label ?value WHERE { ?planet rdf:type exo:Planet . BIND(?planet AS ?label) . ?planet rdfs:label ?value . FILTER(STRSTARTS(?value, \"%s\")) }");

    private final String query;

    SelectionQuery(String query) {
        this.query = query;
    }

    public String getQueryString() {
        return query;
    }

    public String getQueryString(Object... args) {
        return String.format(query, args);
    }
}
