package it.unicam.cs.mgc.exoplanetCataloguer.view.renders;

import it.unicam.cs.mgc.exoplanetCataloguer.model.ParsedData;
import javafx.scene.Node;

/**
 * Classes implementing this interface are used to render parsed data into the UI.
 * @param <T> type representing the FX element
 */
public interface DataRenderer<T extends Node> {

    /**
     * Renders the given data on the given FX node
     * @param data the data to render
     * @param node the FX element to render the data to
     */
    void render(ParsedData data, T node);
}
