package it.unicam.cs.mgc.exoplanetCataloguer.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * This class is used to structure and expose the parsed JSON data from a SPARQL query.
 */
public class JSONData implements ParsedData {

    Map<String, String> data;

    public JSONData(Map<String, String> data) {
        this.data = data;
    }

    public String getProperty(String property) {
        return this.data.get(property);
    }

    public Collection<String> getAllValues() {
        return this.data.values();
    }

    public Iterator<Map.Entry<String, String>> iterator() {
        return this.data.entrySet().iterator();
    }

}