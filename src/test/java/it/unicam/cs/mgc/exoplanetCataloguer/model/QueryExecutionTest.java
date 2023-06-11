package it.unicam.cs.mgc.exoplanetCataloguer.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;

/**
 * Testing the
 */

public class QueryExecutionTest  {

    private OntologyController ontology;

    @BeforeEach
    @Test
    public void setUp() {
        ontology = new OntologyController();
        assertNotNull(ontology);
    }

    @Test
    public void queryAllPlanets() {
        JSONData data = ontology.get(SelectionQueries.PLANETS_LIST);
        Collection<String> planets = data.getAllValues();
        assertTrue(planets.size() != 0);
    }

    @Test
    @Disabled
    public void queryPlanetDetails() {

    }

}
