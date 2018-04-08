package com.joaoibarra.ibarrabeer.api;

import com.joaoibarra.ibarrabeer.model.PocResponse;
import com.joaoibarra.ibarrabeer.model.ProductResponse;
import com.joaoibarra.ibarrabeer.model.query.PocQuery;
import com.joaoibarra.ibarrabeer.model.query.ProductQuery;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by joaoibarra on 08/04/18.
 */

public interface Api {
    @POST("/dev/public/graphql")
    Call<PocResponse> getPoc(@Body PocQuery searchPoc);

    @POST("/dev/public/graphql")
    Call<ProductResponse> getProduct(@Body ProductQuery searchProduct);
}
