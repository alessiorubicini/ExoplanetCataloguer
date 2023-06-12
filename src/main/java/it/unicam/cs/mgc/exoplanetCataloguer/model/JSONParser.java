package it.unicam.cs.mgc.exoplanetCataloguer.model;

import org.apache.jena.atlas.json.JsonObject;
import org.apache.jena.atlas.json.JsonValue;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.RDFNode;

import java.util.*;

/**
 * This class is used to pars the result of a SPARQL query to a JSON-like structure.
 */
public class JSONParser implements DataParser {

    public JSONData parse(QueryExecution queryExecution) {
        Map<String, String> data = new HashMap<>();
        ResultSet results = queryExecution.execSelect() ;
        while(results.hasNext()) {
            QuerySolution statement = results.nextSolution();
            String label = this.parseNodeToString(statement.get("label"));
            String value = this.parseNodeToString(statement.get("value"));
            String unitOfMeasure = this.parseNodeToString(statement.get("unitOfMeasure"));
            if(!unitOfMeasure.isEmpty()) {
                value = value + unitOfMeasure;
            }
            data.put(label, value);
        }
        return new JSONData(data);
    }

    /**
     * Local utility function to correctly parse a RDF node to a string
     * @param node the RDF node to parse
     * @return a string representing the value of the node. An empty string if the node is null.
     */
    private String parseNodeToString(RDFNode node) {
        if(node == null) {
             return "";
        } else if(node.isResource()) {
            return node.asResource().getURI().toString();
        } else {
            return node.asLiteral().getString();
        }
    }

}
