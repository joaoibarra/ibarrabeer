package com.joaoibarra.ibarrabeer.feature.poc.model;

import com.joaoibarra.ibarrabeer.api.BeerApi;
import com.joaoibarra.ibarrabeer.feature.poc.contract.PocContract;
import com.joaoibarra.ibarrabeer.model.PocResponse;
import com.joaoibarra.ibarrabeer.model.constants.GraphqlQuery;
import com.joaoibarra.ibarrabeer.model.query.PocQuery;
import com.joaoibarra.ibarrabeer.model.search.SearchPoc;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by joaoibarra on 08/04/18.
 */

public class PocInteractor implements PocContract.Interactor{
    PocContract.OnGetPocResponseListener onGetPocResponseListener;

    public PocInteractor(PocContract.OnGetPocResponseListener onGetPocResponseListener){
        this.onGetPocResponseListener = onGetPocResponseListener;
    }

    @Override
    public void getPoc(SearchPoc searchPoc) {
        retrofit2.Call<PocResponse> call = BeerApi.getApi().getPoc(createQuery(searchPoc));
        call.enqueue(new retrofit2.Callback<PocResponse>(){
            @Override
            public void onResponse(Call<PocResponse> call, Response<PocResponse> response) {
                onGetPocResponseListener.onSuccess("teste", response.body());
            }

            @Override
            public void onFailure(Call<PocResponse> call, Throwable t) {
                onGetPocResponseListener.onFailure("deu ruim teste");
            }
        });
    }

    private PocQuery createQuery(SearchPoc searchPoc){
        return new PocQuery()
                .setOperationName("pocSearchMethod")
                .setQuery(GraphqlQuery.poc)
                .setVariables(searchPoc);
    }
}
