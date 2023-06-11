package it.unicam.cs.mgc.exoplanetCataloguer.model;

import it.unicam.cs.mgc.exoplanetCataloguer.model.util.OntologyURIs;
import org.apache.jena.rdf.model.InfModel;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OntologyTest {

    private OntologyController ontologyController;
    private InfModel testModel;

    @BeforeEach
    @Test
    public void setUp() {
        ontologyController = new OntologyController();
        InfModel model = ontologyController.buildAndLoadOWLDLModel();
        this.testModel = model;
        assertNotNull(model);
    }

    @Test
    public void testIsOntologyConsistent() {
        boolean isConsistent = ontologyController.isOntologyConsistent();
        assertTrue(isConsistent);
    }

    @Test
    @Disabled
    public void testIsCorrectlyInferred() {
        Resource subject = testModel.getResource(OntologyURIs.OWL + "Thing");
        Property predicate = testModel.getProperty(OntologyURIs.RDFS + "subClassOf");
        Resource object = testModel.getResource(OntologyURIs.OWL + "Thing");

        boolean isInferred = ontologyController.isCorrectlyInferred(subject, predicate, object);
        assertTrue(isInferred);
    }
}
