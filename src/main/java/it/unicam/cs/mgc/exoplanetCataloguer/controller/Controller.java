package it.unicam.cs.mgc.exoplanetCataloguer.controller;

import it.unicam.cs.mgc.exoplanetCataloguer.model.ParsedData;
import it.unicam.cs.mgc.exoplanetCataloguer.model.OntologyController;
import it.unicam.cs.mgc.exoplanetCataloguer.model.SelectionQueries;

/**
 * This class is used to manage the app state
 */
public class Controller {

    OntologyController ontology;

    public Controller() {
        this.ontology = new OntologyController();
    }

    public String getOntologyStatus() {
        if(ontology.isConsistent()) return "Ontology consistent ✓";
        else return "Inconsistent ontology ╳";
    }

    public String isInferredModelReady() {
        if(ontology.isInferredModelReady()) return "Model inferred ✓";
        else return "Performing inference...";
    }

    /**
     * Gets the list of planets in the ontology.
     * @return data containing the list of planets
     */
    public ParsedData getAllPlanets() {
        return ontology.get(SelectionQueries.PLANETS_LIST);
    }

    /**
     * Gets the details about the given planet.
     * @param planetName the name of the planet
     * @return data containing the details
     */
    public ParsedData getPlanetDetails(String planetName) {
        return ontology.get(SelectionQueries.PLANET_DETAILS, planetName);
    }

    public ParsedData searchPlanet(String planetName) {
        return ontology.get(SelectionQueries.SEARCH_PLANET, planetName);
    }

}
