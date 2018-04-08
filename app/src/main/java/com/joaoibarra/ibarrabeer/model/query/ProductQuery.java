package com.joaoibarra.ibarrabeer.model.query;

import com.joaoibarra.ibarrabeer.model.search.SearchProduct;

/**
 * Created by joaoibarra on 08/04/18.
 */

public class ProductQuery {
    String query;
    SearchProduct variables;
    String operationName;

    public String getQuery() {
        return query;
    }

    public ProductQuery setQuery(String query) {
        this.query = query;
        return  this;
    }

    public SearchProduct getVariables() {
        return variables;
    }

    public ProductQuery setVariables(SearchProduct variables) {
        this.variables = variables;
        return  this;
    }

    public String getOperationName() {
        return operationName;
    }

    public ProductQuery setOperationName(String operationName) {
        this.operationName = operationName;
        return  this;
    }
}
