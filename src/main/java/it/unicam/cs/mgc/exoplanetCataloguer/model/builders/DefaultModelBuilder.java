package it.unicam.cs.mgc.exoplanetCataloguer.model.builders;

import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.util.FileManager;

import java.util.Objects;

/**
 * This class is used to create default RDF models.
 */
public class DefaultModelBuilder implements ModelBuilder {

    FileManager fileManager = FileManager.getInternal();

    public Model buildDefaultModel() {
        return ModelFactory.createDefaultModel();
    }

    public Model buildDefaultModel(String...filenames) {
        Model model = ModelFactory.createDefaultModel();
        for(String filename: filenames) {
            model.read(fileManager.open(Objects.requireNonNull(getClass().getResource(filename)).toString()), null);
        }
        return model;
    }

    public Model buildOntologyModel(OntModelSpec modelSpecification) {
        return ModelFactory.createOntologyModel(modelSpecification);
    }

    public Model buildOntologyModel(OntModelSpec modelSpecification, String...filenames) {
        Model model = ModelFactory.createOntologyModel(modelSpecification);
        for(String filename: filenames) {
            model.read(fileManager.open(Objects.requireNonNull(getClass().getResource(filename)).toString()), null);
        }
        return model;
    }
}
