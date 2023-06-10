package it.unicam.cs.mgc.exoplanetCataloguer.model;

import java.util.HashMap;
import java.util.Map;

public class DataAsJSON implements AppData {

    Map<String, String> data;

    public DataAsJSON() {
        this.data = new HashMap<>();
    }

    public DataAsJSON(Map<String, String> data) {
        this.data = data;
    }

    public String getProperty(String property) {
        return this.data.get(property);
    }
}