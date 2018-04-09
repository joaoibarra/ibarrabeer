package com.joaoibarra.ibarrabeer.model.search;

/**
 * Created by joaoibarra on 08/04/18.
 */

public class SearchProduct {
    String id;
    String search;
    int categoryId;

    public String getId() {
        return id;
    }

    public SearchProduct setId(String id) {
        this.id = id;
        return this;
    }

    public String getSearch() {
        return search;
    }

    public SearchProduct setSearch(String search) {
        this.search = search;
        return this;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public SearchProduct setCategoryId(int categoryId) {
        this.categoryId = categoryId;
        return this;
    }
}
