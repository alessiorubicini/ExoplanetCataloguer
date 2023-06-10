package it.unicam.cs.mgc.exoplanetCataloguer.view;

import it.unicam.cs.mgc.exoplanetCataloguer.controller.Controller;
import javafx.fxml.FXML;
import javafx.event.Event;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 * JavaFX Controller for the application.
 */
public class AppFXController {

    private final Controller controller = new Controller();

    @FXML
    private ListView<String> planetsList;

    @FXML
    private TextField planetsSearchBar;

    public void initialize() {
    }

    @FXML
    private void handleClickOnPlanet(Event event) {
        String selectedItem = planetsList.getSelectionModel().getSelectedItem();
        System.out.println("Clicked planet: " + selectedItem);

        // QUERY DETAILS

        // AND SHOW VIEW
    }

    @FXML
    private void handleKeyTypedOnSearchBar(Event event) {
        System.out.println(planetsSearchBar.getCharacters());
        // SEARCH QUERY ...
    }
}
