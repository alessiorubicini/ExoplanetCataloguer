package it.unicam.cs.mgc.exoplanetCataloguer.model.util;

/**
 * This enumeration holds the web and local ontologies URIs
 */
public enum OntologyURIs {

    XSD("http://www.w3.org/2001/XMLSchema#"),
    FOAF("http://xmlns.com/foaf/0.1/"),
    OWL("http://www.w3.org/2002/07/owl#"),
    RDF("http://www.w3.org/1999/02/22-rdf-syntax-ns#"),
    RDFS("http://www.w3.org/2000/01/rdf-schema#"),
    EXO("https://www.unicam.it/cs/alessiorubicini/exoplanet-ontology#"),
    OM("http://www.ontology-of-units-of-measure.org/resource/om-2/"),
    LOCAL("/owl/exoplanet-ontology.rdf"),
    OM_LOCAL("/owl/om-2.0.rdf");

    private final String URI;

    OntologyURIs(String URI) {
        this.URI = URI;
    }

    public String getURI() {
        return URI;
    }
}
