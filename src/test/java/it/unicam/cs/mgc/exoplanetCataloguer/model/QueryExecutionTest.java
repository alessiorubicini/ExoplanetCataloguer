package it.unicam.cs.mgc.exoplanetCataloguer.model;

import it.unicam.cs.mgc.exoplanetCataloguer.model.queries.SelectionQuery;
import jdk.swing.interop.SwingInterOpUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

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
        ParsedData data = ontology.get(SelectionQuery.PLANETS_LIST);
        Collection<String> planets = data.getAllValues();
        assertEquals(4, planets.size());
    }

    @Test
    public void querySearchedPlanets() {
        ParsedData data = ontology.get(SelectionQuery.SEARCH_PLANET, "Trapp");
        Collection<String> planets = data.getAllValues();
        assertEquals(2, planets.size());
    }

    @Test
    public void queryPlanetDetails() {
        ParsedData data = ontology.get(SelectionQuery.PLANET_DETAILS, "Trappist-1d");
        assertFalse(data.getAllValues().isEmpty());
        for(String value: data.getAllValues()) {
            System.out.println(value);
        }
    }

}
