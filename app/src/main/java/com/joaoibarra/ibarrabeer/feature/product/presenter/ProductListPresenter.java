package com.joaoibarra.ibarrabeer.feature.product.presenter;

import com.joaoibarra.ibarrabeer.feature.product.contract.ProductListContract;
import com.joaoibarra.ibarrabeer.feature.product.model.ProductListInteractor;
import com.joaoibarra.ibarrabeer.model.PocSearch;
import com.joaoibarra.ibarrabeer.model.Product;
import com.joaoibarra.ibarrabeer.model.search.SearchProduct;

import java.util.List;

public class ProductListPresenter implements ProductListContract.Presenter,
        ProductListContract.OnGetProductResponseListener{
    private ProductListContract.View productListView;
    private ProductListInteractor productListInteractor;

    public ProductListPresenter(ProductListContract.View productListView){
        this.productListView = productListView;
        productListInteractor = new ProductListInteractor(this);
    }
    @Override
    public void getProducts(PocSearch pocSearch, String search, int categoryId) {
        productListInteractor.getProducts(createSearchPoc(pocSearch.getId(), search, categoryId));
    }

    @Override
    public void onSuccess(String message, List<Product> list) {
        productListView.onGetDataSuccess(message, list);
    }

    @Override
    public void onFailure(String message) {

    }

    private SearchProduct createSearchPoc(String pocId, String search, int categoryId){

        return new SearchProduct()
                .setId(pocId)
                .setSearch(search)
                .setCategoryId(categoryId);
    }
}
