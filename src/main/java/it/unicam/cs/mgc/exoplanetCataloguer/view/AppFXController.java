package it.unicam.cs.mgc.exoplanetCataloguer.view;

import it.unicam.cs.mgc.exoplanetCataloguer.controller.Controller;
import it.unicam.cs.mgc.exoplanetCataloguer.model.util.PropertiesFormatter;
import it.unicam.cs.mgc.exoplanetCataloguer.view.renders.PlanetDetailsRenderer;
import it.unicam.cs.mgc.exoplanetCataloguer.view.renders.PlanetListRenderer;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.event.Event;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

/**
 * JavaFX Controller for the application.
 */
public class AppFXController {

    private final Controller controller = new Controller();
    private final PlanetListRenderer planetListRenderer = new PlanetListRenderer();
    private final PlanetDetailsRenderer planetDetailsRenderer = new PlanetDetailsRenderer();

    @FXML
    private Label ontologyStatus;

    @FXML
    private ListView<String> planetsList;

    @FXML
    private TextField planetSearchBar;

    @FXML
    private GridPane planetDetailView;

    public void initialize() {
        ontologyStatus.setText(this.controller.getOntologyConsistencyStatus());
        planetDetailView.setVisible(false);
        planetListRenderer.render(controller.getAllPlanets(), planetsList);
    }

    @FXML
    private void handleClickOnPlanet(Event event) {
        if(planetDetailView.isVisible()) this.cleanPlanetDetailFields();
        String selectedItem = planetsList.getSelectionModel().getSelectedItem();
        if(selectedItem != null) {
            planetDetailsRenderer.render(controller.getPlanetDetails(selectedItem), planetDetailView);
            this.planetDetailView.setVisible(true);
        }
    }

    @FXML
    private void handleKeyTypedOnSearchBar(Event event) {
        String searchedText = planetSearchBar.getCharacters().toString();
        if(searchedText.isEmpty()) {
            planetListRenderer.render(controller.getAllPlanets(), planetsList);
        } else {
            searchedText = PropertiesFormatter.stringToFirstLetterUpperCase(searchedText);
            planetListRenderer.render(controller.searchPlanet(searchedText), planetsList);
        }
    }

    /**
     * Cleans all the nodes in the planet detail view.
     */
    private void cleanPlanetDetailFields() {
        ObservableList<Node> planetDetails = planetDetailView.getChildren();
        for(Node node: planetDetails) {
            if(node instanceof Label label) {
                label.setText(PropertiesFormatter.camelCaseToSpacedString(node.getId()) + ": ");
            }
            if(node instanceof ImageView imageView) {
                imageView.setImage(null);
            }
        }
    }
}
