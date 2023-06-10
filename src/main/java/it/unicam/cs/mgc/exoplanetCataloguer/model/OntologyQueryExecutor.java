package it.unicam.cs.mgc.exoplanetCataloguer.model;

import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.rdf.model.Model;

public class OntologyQueryExecutor implements QueryExecutor {

    public QueryExecution perform(SelectionQueries query, Model model) {
        Query queryToPerform = QueryFactory.create(query.getQueryString());
        return QueryExecutionFactory.create(queryToPerform, model);
    }

    public QueryExecution perform(SelectionQueries query, String parameter, Model model) {
        Query queryToPerform = QueryFactory.create(query.getQueryString(parameter));
        return QueryExecutionFactory.create(queryToPerform, model);
    }

    public void perform(UpdateQueries query, Model model) {

    }
}
