package it.unicam.cs.mgc.exoplanetCataloguer.model;

import it.unicam.cs.mgc.exoplanetCataloguer.model.queries.SparqlQuery;
import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.rdf.model.Model;

/**
 * This class is used to perform SPARQL queries on the underlying application ontology
 */
public class OntologyQueryExecutor implements QueryExecutor {

    public QueryExecution perform(SparqlQuery query, Model model) {
        Query queryToPerform = QueryFactory.create(query.getCompleteQuery());
        return QueryExecutionFactory.create(queryToPerform, model);
    }

    public QueryExecution perform(SparqlQuery query, Model model, Object...args) {
        Query queryToPerform = QueryFactory.create(query.getCompleteQuery(args));
        return QueryExecutionFactory.create(queryToPerform, model);
    }

}
