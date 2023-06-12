package it.unicam.cs.mgc.exoplanetCataloguer.view.renders;

import it.unicam.cs.mgc.exoplanetCataloguer.model.ParsedData;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.util.Objects;

/**
 * This class is used to render the details of a planet on the labels inside the specified pane
 */
public class PlanetDetailsRenderer implements DataRenderer<Pane> {

    public void render(ParsedData data, Pane pane) {
        ObservableList<Node> planetDetails = pane.getChildren();
        for(Node node: planetDetails) {
            if(node.getId().equals("planetImage")) {
                this.renderPlanetImage(node, data.getProperty("image url"));
            } else {
                this.renderDataOnLabel(node, data);
            }
        }
    }

    private void renderDataOnLabel(Node node, ParsedData data) {

    }

    private void renderPlanetImage(Node node, String url) {
        ImageView planetImageView = (ImageView) node;
        Image planetImage = new Image(url, true);
        planetImageView.setImage(planetImage);
    }

}
