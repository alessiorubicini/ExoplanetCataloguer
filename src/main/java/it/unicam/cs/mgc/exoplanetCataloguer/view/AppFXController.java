package it.unicam.cs.mgc.exoplanetCataloguer.view;

import it.unicam.cs.mgc.exoplanetCataloguer.controller.Controller;
import javafx.fxml.FXML;
import javafx.event.Event;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * JavaFX Controller for the application.
 */
public class AppFXController {

    private final Controller controller = new Controller();

    @FXML
    private ListView<String> planetsList;

    @FXML
    private TextField planetSearchBar;

    @FXML
    private AnchorPane planetDetailView;

    public void initialize() {
        this.planetDetailView.setVisible(false);
        //this.controller.getAllPlanets();
        // render all the planets on the list
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
        System.out.println(planetSearchBar.getCharacters());
        // SEARCH QUERY ...
    }
}
