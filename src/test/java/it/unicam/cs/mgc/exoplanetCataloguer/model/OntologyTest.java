package it.unicam.cs.mgc.exoplanetCataloguer.model;

import it.unicam.cs.mgc.exoplanetCataloguer.model.util.OntologyURIs;
import org.apache.jena.assembler.Mode;
import org.apache.jena.rdf.model.InfModel;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
/*
@Disabled
public class OntologyTest extends ModelLoadTest {

    private InfModel testModel;

    @BeforeEach
    @Test
    public void setUp() {
        controller = new OntologyController();
        InfModel model = controller.buildAndLoadOWLDLModel();
        this.testModel = model;
        assertNotNull(model);
    }

    @Test
    public void testIsOntologyConsistent() {
        boolean isConsistent = controller.isOntologyConsistent();
        assertTrue(isConsistent);
    }

    @Test
    public void testIsCorrectlyInferred() {
        Resource subject = testModel.getResource(OntologyURIs.OWL + "Thing");
        Property predicate = testModel.getProperty(OntologyURIs.RDFS + "subClassOf");
        Resource object = testModel.getResource(OntologyURIs.OWL + "Thing");

        //boolean isInferred = controller.isCorrectlyInferred(subject, predicate, object);
        //assertTrue(isInferred);
    }
}*/
