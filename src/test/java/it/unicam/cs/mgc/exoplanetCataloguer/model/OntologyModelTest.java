package it.unicam.cs.mgc.exoplanetCataloguer.model;

import it.unicam.cs.mgc.exoplanetCataloguer.model.builders.DefaultModelBuilder;
import it.unicam.cs.mgc.exoplanetCataloguer.model.util.OntologyURI;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.vocabulary.RDF;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OntologyModelTest {

    private Model model;

    @BeforeEach
    @Test
    public void setUp() {
        DefaultModelBuilder builder = new DefaultModelBuilder();
        this.model = builder.buildOntologyModel(OntModelSpec.OWL_DL_MEM, OntologyURI.LOCAL.getURI());
        assertNotNull(model);
    }

    @Test
    public void testCorrectStatementPresence() {
        Resource subject = model.getResource(OntologyURI.EXO.getURI() + "Trappist-1d");
        Resource object = model.getResource(OntologyURI.EXO.getURI() + "Planet");
        assertTrue(model.contains(subject, RDF.type, object));
    }

}
