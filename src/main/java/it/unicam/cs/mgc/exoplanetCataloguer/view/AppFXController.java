package it.unicam.cs.mgc.exoplanetCataloguer.view;

import it.unicam.cs.mgc.exoplanetCataloguer.controller.Controller;
import it.unicam.cs.mgc.exoplanetCataloguer.model.renders.DataRenderer;
import it.unicam.cs.mgc.exoplanetCataloguer.model.renders.PlanetListRenderer;
import javafx.fxml.FXML;
import javafx.event.Event;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * JavaFX Controller for the application.
 */
public class AppFXController {

    private final Controller controller = new Controller();

    @FXML
    private Label ontologyStatus;

    @FXML
    private Label inferredModelStatus;

    @FXML
    private ListView<String> planetsList;

    @FXML
    private TextField planetSearchBar;

    @FXML
    private AnchorPane planetDetailView;

    public void initialize() {
        ontologyStatus.setText(this.controller.getOntologyStatus());
        inferredModelStatus.setText(controller.isInferredModelReady());
        planetDetailView.setVisible(false);
        DataRenderer<ListView<String>> renderer = new PlanetListRenderer();
        renderer.render(controller.getAllPlanets(), planetsList);
    }

    @FXML
    private void handleClickOnPlanet(Event event) {
        String selectedItem = planetsList.getSelectionModel().getSelectedItem();
        System.out.println("Clicked planet: " + selectedItem);

        // QUERY DETAILS

        // AND SHOW VIEW
        // render all the properties
        this.planetDetailView.setVisible(true);
    }

    @FXML
    private void handleKeyTypedOnSearchBar(Event event) {
        String searchedText = planetSearchBar.getCharacters().toString();
        if(!searchedText.isEmpty()) {
            System.out.println("Searching " + searchedText);
            DataRenderer<ListView<String>> renderer = new PlanetListRenderer();
            renderer.render(controller.searchPlanet(searchedText), planetsList);
        }
    }
}
