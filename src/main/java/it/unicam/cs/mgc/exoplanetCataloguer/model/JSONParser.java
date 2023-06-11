package it.unicam.cs.mgc.exoplanetCataloguer.model;

import org.apache.jena.atlas.json.JsonObject;
import org.apache.jena.query.QueryExecution;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * This class is used to pars the result of a SPARQL query to a JSON-like structure.
 */
public class JSONParser implements DataParser {

    public ParsedData parse(QueryExecution queryExecution) {
        Map<String, String> data = new HashMap<>();
        Iterator<JsonObject> json = queryExecution.execJsonItems();
        while (json.hasNext()) {
            JsonObject jsonObject = json.next();
            String key = jsonObject.get("label").toString().replaceAll("\"", "");
            String value = jsonObject.get("value").toString();
            String unitOfMeasure = jsonObject.get("unitOfMeasure").toString();
            if(!unitOfMeasure.isEmpty()) value = value + " " + unitOfMeasure;
            data.put(key, value);
        }
        return new DataAsJSON(data);
    }

}
