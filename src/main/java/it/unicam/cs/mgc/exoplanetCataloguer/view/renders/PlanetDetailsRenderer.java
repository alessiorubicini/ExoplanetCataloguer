package it.unicam.cs.mgc.exoplanetCataloguer.view.renders;

import it.unicam.cs.mgc.exoplanetCataloguer.model.ParsedData;
import it.unicam.cs.mgc.exoplanetCataloguer.model.util.StringFormatter;
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
            if(node.getId().equals("comment")) {
                this.renderDataOnLabel(node, data);
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
        String propertyName = StringFormatter.camelCaseToSpacedString(label.getId());
        String property = data.getProperty(propertyName);
        if(property != null) {
            if(propertyName.equals("label") || propertyName.equals("comment")) {
                label.setText(property);
            } else {
                label.setText(propertyName + ": " + property);
            }
        }
    }

    private void renderPlanetImage(Node node, String url) {
        ImageView planetImageView = (ImageView) node;
        Image planetImage = new Image(url, true);
        planetImageView.setPreserveRatio(true);
        planetImageView.setFitWidth(280);
        planetImageView.setFitHeight(280);
        planetImageView.setImage(planetImage);
    }

}
