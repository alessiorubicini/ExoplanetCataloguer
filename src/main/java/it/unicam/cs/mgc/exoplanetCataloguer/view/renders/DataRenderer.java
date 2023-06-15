package it.unicam.cs.mgc.exoplanetCataloguer.view.renders;

import it.unicam.cs.mgc.exoplanetCataloguer.model.ParsedData;
import javafx.scene.Node;

/**
 * Classes implementing this interface are used to render parsed data into the UI.
 * @param <T> type representing the FX node to render the data into
 */
public interface DataRenderer<T extends Node> {

    /**
     * Renders the given data on the specified FX node
     * @param data the data to render
     * @param node the FX node to render the data into
     */
    void render(ParsedData data, T node);

}
