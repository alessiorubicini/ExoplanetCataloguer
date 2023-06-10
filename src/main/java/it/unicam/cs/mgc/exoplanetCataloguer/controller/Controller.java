package it.unicam.cs.mgc.exoplanetCataloguer.controller;

import it.unicam.cs.mgc.exoplanetCataloguer.model.AppData;
import it.unicam.cs.mgc.exoplanetCataloguer.model.OntologyController;
import it.unicam.cs.mgc.exoplanetCataloguer.model.SelectionQuery;

/**
 * This class is used to manage the app state
 */
public class Controller {

    OntologyController ontController;

    public Controller() {
        this.ontController = new OntologyController();
    }

    public AppData getAllPlanets() {
        return ontController.get(SelectionQuery.PLANETS_LIST);
    }

    public AppData getPlanetDetails(String planetName) {
        return ontController.get(SelectionQuery.PLANET_DETAILS, planetName);
    }

}
