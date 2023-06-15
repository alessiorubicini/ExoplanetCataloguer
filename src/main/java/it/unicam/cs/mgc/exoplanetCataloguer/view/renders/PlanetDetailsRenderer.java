package it.unicam.cs.mgc.exoplanetCataloguer.view.renders;

import it.unicam.cs.mgc.exoplanetCataloguer.model.ParsedData;
import it.unicam.cs.mgc.exoplanetCataloguer.model.util.StringFormatter;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

/**
 * This class is used to render the details of a planet on the labels inside the specified pane
 */
public class PlanetDetailsRenderer implements DataRenderer<GridPane> {

    public void render(ParsedData data, GridPane pane) {
        ObservableList<Node> planetDetails = pane.getChildren();
        for(Node node: planetDetails) {
            if(node instanceof Label || node instanceof ImageView) {
                if(node.getId().equals("planetImage")) {
                    this.renderPlanetImage(node, data.getProperty("image url"));
                } else {
                    this.renderDataOnLabel(node, data);
                }
            }
        }
    }

    /**
     * Renders specific value from data on a single label. The rendered value is given by
     * the property key represented by the label fx id
     * @param node the FX label to rendere the data to
     * @param data the data to render
     */
    private void renderDataOnLabel(Node node, ParsedData data) {
        Label label = (Label) node;
        String propertyName = StringFormatter.camelCaseToSpacedString(label.getId());
        String property = data.getProperty(propertyName);
        if(property != null) {
            if(propertyName.equals("label") || propertyName.equals("comment")) {
                label.setText(property);
            } else {
                if(propertyName.equals("type")) {
                    property = StringFormatter.removeUselessTypes(property);
                }
                label.setText(propertyName + ": " + property);
            }
        }
    }

    /**
     * Renders a planet image into the FX image view from an URL
     * @param node the FX image view to render the image into
     * @param url the url of the image
     */
    private void renderPlanetImage(Node node, String url) {
        ImageView planetImageView = (ImageView) node;
        Image planetImage = new Image(url, true);
        planetImageView.setPreserveRatio(true);
        planetImageView.setFitWidth(280);
        planetImageView.setFitHeight(280);
        planetImageView.setImage(planetImage);
    }

}
