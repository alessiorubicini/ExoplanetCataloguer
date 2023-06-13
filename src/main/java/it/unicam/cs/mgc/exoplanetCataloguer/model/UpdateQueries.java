package it.unicam.cs.mgc.exoplanetCataloguer.model;

/**
 * This enumeration holds all the SPARQL query to update data on the ontology
 */
public enum UpdateQueries implements SPARQLQueries {

    INSERT_PLANET(""),
    INSERT_STAR(""),
    INSERT_RESEARCHER("");

    private final String query;

    UpdateQueries(String query) {
        this.query = query;
    }

    public String getQueryString() {
        return query;
    }

    @Override
    public String getQueryString(Object... args) {
        return String.format(query, args);
    }
}
