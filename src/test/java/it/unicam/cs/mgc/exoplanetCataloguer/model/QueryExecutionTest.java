package it.unicam.cs.mgc.exoplanetCataloguer.model;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;

/**
 * Testing the
 */
@Disabled
public class QueryExecutionTest extends ModelLoadTest {

    @Test
    public void queryAllPlanets() {
        JSONData data = controller.get(SelectionQueries.PLANETS_LIST);
        Collection<String> planets = data.getAllValues();
        assertTrue(planets.size() != 0);
    }

}
