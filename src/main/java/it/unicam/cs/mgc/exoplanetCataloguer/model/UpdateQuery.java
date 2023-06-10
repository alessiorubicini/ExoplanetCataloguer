package it.unicam.cs.mgc.exoplanetCataloguer.model;

public enum UpdateQuery implements SPARQLQuery {
    INSERT_PLANET(""),
    INSERT_STAR(""),
    INSERT_RESEARCHER("");

    private final String query;

    UpdateQuery(String query) {
        this.query = query;
    }

    public String getQueryString() {
        return query;
    }
}
