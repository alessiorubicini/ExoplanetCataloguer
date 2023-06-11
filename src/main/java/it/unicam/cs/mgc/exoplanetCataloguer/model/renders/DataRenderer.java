package it.unicam.cs.mgc.exoplanetCataloguer.model.renders;

import it.unicam.cs.mgc.exoplanetCataloguer.model.ParsedData;
import javafx.scene.Node;

/**
 * Classes implementing this interface are used to render parsed data into the UI.
 * @param <T> type representing the FX element
 */
public interface DataRenderer<T extends Node> {

    /**
     * Renders the given data on the elements in the pane
     * @param data the data to be rendered
     * @param control the FX element where to render the data
     */
    void render(ParsedData data, T control);
}
