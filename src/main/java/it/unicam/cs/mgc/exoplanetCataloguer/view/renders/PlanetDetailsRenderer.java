package it.unicam.cs.mgc.exoplanetCataloguer.view.renders;

import it.unicam.cs.mgc.exoplanetCataloguer.model.ParsedData;
import it.unicam.cs.mgc.exoplanetCataloguer.model.util.StringCases;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * This class is used to render the details of a planet on the labels inside the specified pane
 */
public class PlanetDetailsRenderer implements DataRenderer<Pane> {

    public void render(ParsedData data, Pane pane) {
        ObservableList<Node> planetDetails = pane.getChildren();
        for(Node node: planetDetails) {
            if(node.getId().equals("planetImage")) {
                this.renderPlanetImage(node, data.getProperty("image url"));
            }
            if(node.getId().equals("planetDetailLabels")) {
                this.renderDataInVBox(node, data);
            }
        }
    }

    private void renderDataInVBox(Node node, ParsedData data) {
        VBox vbox = (VBox) node;
        ObservableList<Node> labels = vbox.getChildren();
        for(Node label: labels) {
            if(label instanceof Label) {
                this.renderDataOnLabel(label, data);
            }
        }
    }

    private void renderDataOnLabel(Node node, ParsedData data) {
        Label label = (Label) node;
        String property = StringCases.camelCaseToSpacedString(label.getId());
        label.setText(property + ": " + data.getProperty(property));
    }

    private void renderPlanetImage(Node node, String url) {
        ImageView planetImageView = (ImageView) node;
        planetImageView.setPreserveRatio(true);
        Image planetImage = new Image(url, true);
        planetImageView.setFitWidth(300);
        planetImageView.setFitHeight(300);
        planetImageView.setImage(planetImage);
    }

}
