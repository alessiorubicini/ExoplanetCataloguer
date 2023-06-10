package it.unicam.cs.mgc.exoplanetCataloguer.model;

import com.github.jsonldjava.utils.Obj;

/**
 * A Sparql query to select data from a RDF graph
 */
public enum SelectionQuery implements SPARQLQuery {
    PLANETS_LIST(""),
    PLANET_DETAILS(""),
    MISSION_DETAILS(""),
    RESEARCHER_DETAILS(""),
    STAR_DETAILS("");

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
