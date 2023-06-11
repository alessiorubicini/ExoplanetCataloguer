package it.unicam.cs.mgc.exoplanetCataloguer.model.builders;

import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.rdf.model.Model;

/**
 * Classes implementing this interface are used to build RDF models.
 */
public interface ModelBuilder {

    /**
     * Creates a basic RDF model without any specific inference or ontology support.
     * @return the built model
     */
    Model buildDefaultModel();

    /**
     * Creates a basic RDF model from a specific file.
     * @param filename the filename of th efile
     * @return the built model
     */
    Model buildDefaultModel(String filename);

    /**
     * Creates an RDF model that supports ontology reasoning using specified rule-based reasoning and subtyping rules
     * @param modelSpecification the model specification
     * @return the built model
     */
    Model buildOntologyModel(OntModelSpec modelSpecification);

    /**
     * Creates an RDF model that supports ontology reasoning using specified rule-based reasoning and subtyping rules
     * from a specific file.
     * @param modelSpecification the model specification
     * @param filename the name of the file
     * @return the built model
     */
    Model buildOntologyModel(OntModelSpec modelSpecification, String filename);

}
