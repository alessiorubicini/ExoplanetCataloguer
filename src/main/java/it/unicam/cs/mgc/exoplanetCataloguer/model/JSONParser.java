package it.unicam.cs.mgc.exoplanetCataloguer.model;

import it.unicam.cs.mgc.exoplanetCataloguer.model.util.StringFormatter;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.vocabulary.RDFS;

import java.util.*;

/**
 * This class is used to pars the result of a SPARQL query to a JSON-like structure.
 */
public class JSONParser implements DataParser {

    public JSONData parse(QueryExecution queryExecution) {
        Map<String, String> data = new HashMap<>();
        ResultSet results = queryExecution.execSelect();
        while(results.hasNext()) {
            QuerySolution result = results.nextSolution();
            String label = this.parseNodeToString(result.get("label"));
            String value = StringFormatter.removeNullValues(this.parseNodeToString(result.get("value")));
            // Concatenates multiple values of the same property
            if(data.containsKey(label)) {
                data.put(label, data.get(label) + ", " + value);
            } else {
                data.put(label, value);
            }
        }
        return new JSONData(data);
    }

    /**
     * Correctly parse a RDF node to a string
     * @param node the RDF node to parse
     * @return a string representing the node. An empty string if the node is null or nor a resource or a literal
     */
    private String parseNodeToString(RDFNode node) {
        if(node == null) return "";
        if(node.isResource()) {
            Resource resource = node.asResource();
            if(resource.getProperty(RDFS.label) == null) return StringFormatter.removeUriPrefix(resource.getURI());
            else return resource.getProperty(RDFS.label).getString();
        } else if(node.isLiteral()) {
            return node.asLiteral().getString();
        } else {
            return "";
        }
    }

}
