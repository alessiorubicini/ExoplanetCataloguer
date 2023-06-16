package it.unicam.cs.mgc.exoplanetCataloguer.controller;

import it.unicam.cs.mgc.exoplanetCataloguer.model.ParsedData;
import it.unicam.cs.mgc.exoplanetCataloguer.model.OntologyController;
import it.unicam.cs.mgc.exoplanetCataloguer.model.queries.SelectionQuery;

/**
 * This class is used to manage the app state.
 */
public class Controller {

    private final OntologyController ontology = new OntologyController();

    public String getOntologyStatus() {
        if(ontology.isConsistent()) return "Ontology consistent ✓";
        else return "Inconsistent ontology ｘ";
    }

    /**
     * Returns the list of planets in the ontology.
     *
     * @return data containing the list of planets
     */
    public ParsedData getAllPlanets() {
        return ontology.get(SelectionQuery.PLANETS_LIST);
    }

    /**
     * Returns the details about the given planet.
     *
     * @param planetName the name of the planet
     * @return data containing the planet details
     */
    public ParsedData getPlanetDetails(String planetName) {
        return ontology.get(SelectionQuery.PLANET_DETAILS, planetName);
    }

    /**
     * Filters the planets list by the searched name.
     *
     * @param searchedName the searched name for the planet
     * @return the filtered list of planets.
     */
    public ParsedData searchPlanet(String searchedName) {
        return ontology.get(SelectionQuery.SEARCH_PLANET, searchedName);
    }

}
