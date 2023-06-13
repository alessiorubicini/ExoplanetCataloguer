package it.unicam.cs.mgc.exoplanetCataloguer.model;

import it.unicam.cs.mgc.exoplanetCataloguer.model.queries.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.rdf.model.Model;

public class OntologyQueryExecutor implements QueryExecutor {

    public QueryExecution perform(Query query, Model model) {
        org.apache.jena.query.Query queryToPerform = QueryFactory.create(query.getCompleteQuery());
        return QueryExecutionFactory.create(queryToPerform, model);
    }

    public QueryExecution perform(Query query, Model model, Object...args) {
        org.apache.jena.query.Query queryToPerform = QueryFactory.create(query.getCompleteQuery(args));
        return QueryExecutionFactory.create(queryToPerform, model);
    }

}
