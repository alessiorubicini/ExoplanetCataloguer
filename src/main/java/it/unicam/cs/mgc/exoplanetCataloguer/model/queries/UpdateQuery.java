package it.unicam.cs.mgc.exoplanetCataloguer.model.queries;

/**
 * This enumeration is used to represent update queries to add, modify or delete data
 */
public enum UpdateQuery implements SparqlQuery {

    INSERT_PLANET(""),
    INSERT_STAR("");

    private final String query;

    UpdateQuery(String query) {
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
