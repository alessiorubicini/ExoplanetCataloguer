package it.unicam.cs.mgc.exoplanetCataloguer.model;

/**
 * A Sparql query to select data from a RDF graph
 */
public enum SelectionQueries implements SPARQLQueries {
    PLANETS_LIST("JSON { 'label': ?label, 'value':?value } WHERE { ?planet rdf:type exo:Planet . BIND(?planet AS ?label) . ?planet rdfs:label ?value . }"),
    PLANET_DETAILS(""),
    SEARCH_PLANET("JSON { 'label':?label, 'value':?value } WHERE { ?planet rdf:type exo:Planet . BIND(?planet AS ?label) . ?planet rdfs:label ?value . FILTER(CONTAINS(?value, \"%s\")) }"),
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
