package com.joaoibarra.ibarrabeer.feature.product.model;

import android.util.Log;

import com.joaoibarra.ibarrabeer.api.BeerApi;
import com.joaoibarra.ibarrabeer.feature.product.contract.ProductListContract;
import com.joaoibarra.ibarrabeer.model.Product;
import com.joaoibarra.ibarrabeer.model.ProductResponse;
import com.joaoibarra.ibarrabeer.model.constants.GraphqlQuery;
import com.joaoibarra.ibarrabeer.model.query.ProductQuery;
import com.joaoibarra.ibarrabeer.model.search.SearchProduct;

import java.util.ArrayList;
import java.util.List;

public class ProductListInteractor implements ProductListContract.Interactor{
    ProductListContract.OnGetProductResponseListener onGetProductResponseListener;
    List<Product> products = new ArrayList<>();
    List<String> productsData = new ArrayList<>();

    public ProductListInteractor(ProductListContract.OnGetProductResponseListener onGetProductResponseListener){
        this.onGetProductResponseListener = onGetProductResponseListener;
    }

    @Override
    public void getProducts(SearchProduct searchProduct) {
        retrofit2.Call<ProductResponse> call = BeerApi.getApi().getProduct(createQuery(searchProduct));
        call.enqueue(new retrofit2.Callback<ProductResponse>() {
            @Override
            public void onResponse(retrofit2.Call<ProductResponse> call, retrofit2.Response<ProductResponse> response) {
                ProductResponse jsonResponse = response.body();
                products = jsonResponse.getData().getPoc().getProducts();
                for(int i=0; i<products.size();i++){
                    productsData.add(products.get(i).getProductVariants().get(0).getTitle());
                }
                Log.d("Data", "Refreshed");
                onGetProductResponseListener.onSuccess("List Size: " + productsData.size(), products);
            }
            @Override
            public void onFailure(retrofit2.Call<ProductResponse> call, Throwable t) {
                Log.v("Error",t.getMessage());
                onGetProductResponseListener.onFailure(t.getMessage());
            }
        });
    }

    private ProductQuery createQuery(SearchProduct searchProduct){
        return new ProductQuery()
                .setOperationName("pocCategorySearch")
                .setQuery(GraphqlQuery.products)
                .setVariables(searchProduct);
    }
}
