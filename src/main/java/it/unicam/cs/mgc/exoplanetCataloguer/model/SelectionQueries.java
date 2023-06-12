package it.unicam.cs.mgc.exoplanetCataloguer.model;

/**
 * A Sparql query to select data from a RDF graph
 */
public enum SelectionQueries implements SPARQLQueries {
    PLANETS_LIST("SELECT ?label ?value WHERE { ?planet rdf:type exo:Planet . BIND(?planet AS ?label) . ?planet rdfs:label ?value . }"),
    PLANET_DETAILS("SELECT ?label (GROUP_CONCAT(?rawValue; SEPARATOR=\", \") AS ?value) ?unitOfMeasure WHERE { ?planet rdf:type exo:Planet . ?planet rdfs:label \"%s\" . ?planet ?property ?range . ?property rdfs:label ?label . FILTER(LANG(?label)=\"en\"). OPTIONAL { ?property rdf:type owl:DatatypeProperty . ?planet ?property ?rawValue } OPTIONAL { ?property rdf:type owl:ObjectProperty . ?range rdfs:label ?rawValue } OPTIONAL { ?property exo:hasUnitOfMeasure ?unit . ?unit om:symbol ?unitOfMeasure . } } GROUP BY ?label ?unitOfMeasure"),
    SEARCH_PLANET("SELECT ?label ?value WHERE { ?planet rdf:type exo:Planet . BIND(?planet AS ?label) . ?planet rdfs:label ?value . FILTER(STRSTARTS(?value, \"%s\")) }"),
    MISSION_DETAILS(""),
    RESEARCHER_DETAILS(""),
    STAR_DETAILS(""),
    TEST("SELECT ?label ?value\n" +
            "WHERE {\n" +
            "  ?planet rdf:type exo:Planet .\n" +
            "  ?planet rdfs:label \"Trappist-1d\" .\n" +
            "  ?planet ?label ?value .\n" +
            "  \n" +
            "}\n");

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
