package it.unicam.cs.mgc.exoplanetCataloguer.model;

import java.util.HashMap;
import java.util.Map;

/**
 * This class is used to structure and expose the parsed JSON data from a SPARQL query.
 */
public class JSONData implements ParsedData {

    Map<String, String> data;

    public JSONData() {
        this.data = new HashMap<>();
    }

    public JSONData(Map<String, String> data) {
        this.data = data;
    }

    public String getProperty(String property) {
        return this.data.get(property);
    }
}