package it.unicam.cs.mgc.exoplanetCataloguer.controller;

import it.unicam.cs.mgc.exoplanetCataloguer.model.AppData;
import it.unicam.cs.mgc.exoplanetCataloguer.model.OntologyController;
import it.unicam.cs.mgc.exoplanetCataloguer.model.SelectionQueries;

/**
 * This class is used to manage the app state
 */
public class Controller {

    OntologyController ontController;

    public Controller() {
        this.ontController = new OntologyController();
    }

    public AppData getAllPlanets() {
        return ontController.get(SelectionQueries.PLANETS_LIST);
    }

    public AppData getPlanetDetails(String planetName) {
        return ontController.get(SelectionQueries.PLANET_DETAILS, planetName);
    }

}
