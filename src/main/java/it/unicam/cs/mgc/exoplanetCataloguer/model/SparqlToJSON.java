package it.unicam.cs.mgc.exoplanetCataloguer.model;

import org.apache.jena.atlas.json.JsonObject;
import org.apache.jena.query.QueryExecution;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class SparqlToJSON implements DataParser {

    public AppData parse(QueryExecution queryExecution) {
        Map<String, String> data = new HashMap<>();
        Iterator<JsonObject> json = queryExecution.execJsonItems();
        while (json.hasNext()) {
            JsonObject jsonObject = json.next();
            String key = jsonObject.get("propertyLabel").toString().replaceAll("\"", "");
            String value = jsonObject.get("value").toString();
            data.put(key, value);
        }
        return new DataAsJSON(data);
    }

}
