package it.unicam.cs.mgc.exoplanetCataloguer.model.renders;

import it.unicam.cs.mgc.exoplanetCataloguer.model.ParsedData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

/**
 * This class is used to render the list of planets on the list view.
 */
public class PlanetListRenderer implements DataRenderer<ListView<String>> {

    public void render(ParsedData data, ListView<String> listView) {
        ObservableList<String> items = FXCollections.observableArrayList(data.getAllValues());
        listView.setItems(items);
    }

}
