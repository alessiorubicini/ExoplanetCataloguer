package it.unicam.cs.mgc.exoplanetCataloguer.model;

import it.unicam.cs.mgc.exoplanetCataloguer.model.queries.SelectionQuery;
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
        JSONData data = ontology.get(SelectionQuery.PLANETS_LIST);
        Collection<String> planets = data.getAllValues();
        assertEquals(4, planets.size());
    }

    @Test
    public void querySearchedPlanets() {
        JSONData data = ontology.get(SelectionQuery.SEARCH_PLANET, "Trapp");
        Collection<String> planets = data.getAllValues();
        assertEquals(2, planets.size());
    }

    @Test
    public void queryPlanetDetails() {
        JSONData data = ontology.get(SelectionQuery.PLANET_DETAILS, "Trappist-1d");
        assertFalse(data.getAllValues().isEmpty());
        Iterator<Map.Entry<String, String>> iterator = data.iterator();
        while(iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            System.out.println(entry.getKey() + ":  " + entry.getValue());
        }
    }

}
