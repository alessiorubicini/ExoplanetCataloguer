package it.unicam.cs.mgc.exoplanetCataloguer.controller;

import it.unicam.cs.mgc.exoplanetCataloguer.model.OntologyController;
import it.unicam.cs.mgc.exoplanetCataloguer.model.SelectionQuery;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.util.FileManager;
import org.apache.jena.atlas.json.JsonObject;

import java.util.Iterator;
import java.util.Objects;

/**
 * This class is used to manage the app state
 */
public class Controller {

    OntologyController ontController;

    public Controller() {
        this.ontController = new OntologyController();
    }

    public Iterator<JsonObject> getAllPlanets() {
        return ontController.get(SelectionQuery.PLANETS_LIST);
    }

    public Iterator<JsonObject> getPlanetDetails(String planetName) {
        return ontController.get(SelectionQuery.PLANET_DETAILS, planetName);
    }

}
