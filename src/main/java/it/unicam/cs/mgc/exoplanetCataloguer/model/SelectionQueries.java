package it.unicam.cs.mgc.exoplanetCataloguer.model;

/**
 * This enumeration holds all the SPARQL query to select data from the ontology
 */
public enum SelectionQueries implements SPARQLQueries {
    PLANETS_LIST("SELECT ?label ?value WHERE { ?planet rdf:type exo:Planet . BIND(?planet AS ?label) . ?planet rdfs:label ?value . }"),
    PLANET_DETAILS("SELECT ?label ?value WHERE { ?planet rdf:type exo:Planet .  ?planet rdfs:label \"%s\" . ?planet ?label ?value . }"),
    SEARCH_PLANET("SELECT ?label ?value WHERE { ?planet rdf:type exo:Planet . BIND(?planet AS ?label) . ?planet rdfs:label ?value . FILTER(STRSTARTS(?value, \"%s\")) }"),
    MISSION_DETAILS(""),
    RESEARCHER_DETAILS(""),
    STAR_DETAILS("");

    private final String query;

    SelectionQueries(String query) {
        this.query = query;
    }

    public String getQueryString() {
        return query;
    }

    public String getQueryString(Object... args) {
        return String.format(query, args);
    }
}
