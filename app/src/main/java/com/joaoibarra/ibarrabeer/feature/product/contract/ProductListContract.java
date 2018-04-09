package com.joaoibarra.ibarrabeer.feature.product.contract;

import com.joaoibarra.ibarrabeer.model.PocSearch;
import com.joaoibarra.ibarrabeer.model.Product;
import com.joaoibarra.ibarrabeer.model.search.SearchProduct;

import java.util.List;

public class ProductListContract {
    public interface View{
        void onGetDataSuccess(String message, List<Product> list);
        void onGetDataFailure(String message);
    }
    public interface Presenter{
        void getProducts(PocSearch pocSearch, String search, int categoryId);
    }
    public interface Interactor{
        void getProducts(SearchProduct searchProduct);

    }
    public interface OnGetProductResponseListener{
        void onSuccess(String message, List<Product> list);
        void onFailure(String message);
    }
}
