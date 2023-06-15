package it.unicam.cs.mgc.exoplanetCataloguer.model.builders;

import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.rdf.model.Model;

/**
 * Classes implementing this interface are used to build RDF models.
 */
public interface ModelBuilder {

    /**
     * Creates a basic RDF model without any specific inference or ontology support.
     *
     * @return the built model
     */
    Model buildDefaultModel();

    /**
     * Creates a basic RDF model loading from specific files.
     *
     * @param filenames the names of the files
     * @return the built model
     */
    Model buildDefaultModel(String...filenames);

    /**
     * Creates an RDF model that supports ontology reasoning using specified rule-based reasoning and subtyping rules.
     *
     * @param modelSpecification the model specification
     * @return the built model
     */
    Model buildOntologyModel(OntModelSpec modelSpecification);

    /**
     * Creates an RDF model that supports ontology reasoning using specified rule-based reasoning and subtyping rules
     * loading from a specific file.
     *
     * @param modelSpecification the model specification
     * @param filenames the names of the files
     * @return the built model
     */
    Model buildOntologyModel(OntModelSpec modelSpecification, String...filenames);



}
