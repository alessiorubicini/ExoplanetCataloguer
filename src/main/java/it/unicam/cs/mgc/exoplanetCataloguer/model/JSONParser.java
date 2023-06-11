package it.unicam.cs.mgc.exoplanetCataloguer.model;

import org.apache.jena.atlas.json.JsonObject;
import org.apache.jena.atlas.json.JsonValue;
import org.apache.jena.query.QueryExecution;

import java.util.*;

/**
 * This class is used to pars the result of a SPARQL query to a JSON-like structure.
 */
public class JSONParser implements DataParser {

    public JSONData parse(QueryExecution queryExecution) {
        Map<String, String> data = new HashMap<>();
        Iterator<JsonObject> json = queryExecution.execJsonItems();
        while (json.hasNext()) {
            JsonObject jsonObject = json.next();
            String key = jsonObject.get("label").toString().replaceAll("\"", "");
            String value = jsonObject.get("value").toString();
            JsonValue unitOfMeasure = jsonObject.get("unitOfMeasure");
            if(unitOfMeasure != null && !unitOfMeasure.toString().isEmpty()) {
                value = value + " " + unitOfMeasure;
            }
            data.put(key, value);
        }
        return new JSONData(data);
    }

}
