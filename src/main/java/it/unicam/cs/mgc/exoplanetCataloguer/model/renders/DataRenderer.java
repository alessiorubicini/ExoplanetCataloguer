package it.unicam.cs.mgc.exoplanetCataloguer.model.renders;

import it.unicam.cs.mgc.exoplanetCataloguer.model.ParsedData;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

/**
 * Classes implementing this interface are used to render parsed data into the UI.
 */
public interface DataRenderer {

    /**
     * Renders the given data on the elements in the pane
     * @param data the data to be rendered
     * @param pane the FX pane where to render the data
     */
    void render(ParsedData data, Pane pane);
}
