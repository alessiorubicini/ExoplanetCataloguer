package it.unicam.cs.mgc.exoplanetCataloguer.model;

import org.apache.jena.atlas.json.JsonObject;
import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.rdf.model.Model;

import java.util.Iterator;

public class OntologyQueryExecutor implements SPARQLQueryExecutor{

    public Iterator<JsonObject> perform(SelectionQuery query, Model model) {
        Query queryToPerform = QueryFactory.create(query.getQueryString());
        QueryExecution queryExecution = QueryExecutionFactory.create(queryToPerform, model);
        return queryExecution.execJsonItems();
    }

    public Iterator<JsonObject> perform(SelectionQuery query, String parameter, Model model) {
        Query queryToPerform = QueryFactory.create(query.getQueryString(parameter));
        QueryExecution queryExecution = QueryExecutionFactory.create(queryToPerform, model);
        return queryExecution.execJsonItems();
    }

    public void perform(UpdateQuery query, Model model) {

    }
}
