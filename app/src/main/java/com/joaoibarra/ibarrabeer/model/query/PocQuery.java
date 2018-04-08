package com.joaoibarra.ibarrabeer.model.query;

import com.joaoibarra.ibarrabeer.model.search.SearchPoc;

/**
 * Created by joaoibarra on 08/04/18.
 */

public class PocQuery {
    String query;
    SearchPoc variables;
    String operationName;

    public String getQuery() {
        return query;
    }

    public PocQuery setQuery(String query) {
        this.query = query;
        return  this;
    }

    public SearchPoc getVariables() {
        return variables;
    }

    public PocQuery setVariables(SearchPoc variables) {
        this.variables = variables;
        return  this;
    }

    public String getOperationName() {
        return operationName;
    }

    public PocQuery setOperationName(String operationName) {
        this.operationName = operationName;
        return  this;
    }
}
