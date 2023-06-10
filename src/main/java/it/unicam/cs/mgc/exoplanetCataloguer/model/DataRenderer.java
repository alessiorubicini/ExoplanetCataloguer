package it.unicam.cs.mgc.exoplanetCataloguer.model;

import javafx.scene.layout.GridPane;

/**
 * Classes implementing this interface are used to render a chunk of data into the UI
 */
public interface DataRenderer {

    /**
     * Renders the given data on the elements in the pane
     * @param data the data to be rendered
     * @param gridPane the pane where to render the data
     */
    void render(AppData data, GridPane gridPane);
}
