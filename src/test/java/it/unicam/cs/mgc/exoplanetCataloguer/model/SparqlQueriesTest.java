package it.unicam.cs.mgc.exoplanetCataloguer.model;

import it.unicam.cs.mgc.exoplanetCataloguer.model.queries.SelectionQuery;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SparqlQueriesTest {

    @Test
    public void testQueryParameterization() {
        String query = SelectionQuery.SEARCH_PLANET.getQueryString("Trapp");
        String expectedQuery = "SELECT ?label ?value WHERE { ?planet rdf:type exo:Planet . BIND(?planet AS ?label) . ?planet rdfs:label ?value . FILTER(STRSTARTS(?value, \"Trapp\")) }";
        assertEquals(expectedQuery, query);
    }

}
