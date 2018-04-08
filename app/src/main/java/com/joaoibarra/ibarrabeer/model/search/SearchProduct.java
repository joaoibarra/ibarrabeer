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

    public void setId(String id) {
        this.id = id;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}
