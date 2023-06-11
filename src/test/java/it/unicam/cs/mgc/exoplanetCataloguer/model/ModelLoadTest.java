package it.unicam.cs.mgc.exoplanetCataloguer.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * This classed is used to test the loading of the ontology model.
 */
@Disabled
public class ModelLoadTest {

    protected OntologyController controller;

    @BeforeEach
    @Test
    public void setUp() {
        controller = new OntologyController();
        assertNotNull(controller);
    }

}
