package it.unicam.cs.mgc.exoplanetCataloguer.model;

import it.unicam.cs.mgc.exoplanetCataloguer.model.builders.DefaultModelBuilder;
import it.unicam.cs.mgc.exoplanetCataloguer.model.util.OntologyURIs;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.rdf.model.Model;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

@Disabled
public class OntologyModelTest {

    private Model model;

    @BeforeEach
    @Test
    public void setUp() {
        DefaultModelBuilder builder = new DefaultModelBuilder();
        model = builder.buildOntologyModel(OntModelSpec.OWL_DL_MEM_TRANS_INF, OntologyURIs.LOCAL.getURI());
        assertNotNull(model);
    }

}
