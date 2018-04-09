package com.joaoibarra.ibarrabeer.feature.poc.presenter;

import android.location.Location;

import com.joaoibarra.ibarrabeer.feature.poc.contract.PocContract;
import com.joaoibarra.ibarrabeer.feature.poc.model.PocInteractor;
import com.joaoibarra.ibarrabeer.model.PocResponse;
import com.joaoibarra.ibarrabeer.model.search.SearchPoc;
import com.joaoibarra.ibarrabeer.util.DateUtil;

import java.util.List;

/**
 * Created by joaoibarra on 08/04/18.
 */

public class PocPresenter implements PocContract.Presenter, PocContract.OnGetPocResponseListener{
    private PocContract.View pocView;
    private PocInteractor pocInteractor;

    public PocPresenter(PocContract.View pocView){
        this.pocView = pocView;
        pocInteractor = new PocInteractor(this);
    }

    @Override
    public void getPoc(CharSequence searchAddress, Location location) {
        pocInteractor.getPoc(createSearchPoc(searchAddress, location));
    }

    private SearchPoc createSearchPoc(CharSequence searchAddress, Location location){
        /***
         * Aqui é o código para uso dinâmico
         */
        /* return new SearchPoc()
                .setAlgorithm("NEAREST")
                .setLatitude(location.getLatitude())
                .setLongitude(location.getLongitude())
                .setNow(DateUtil.getNow());*/

        /***
         * Aqui é o código para uso mockado
         */
        return new SearchPoc()
                .setAlgorithm("NEAREST")
                .setLatitude(-23.632919)
                .setLongitude(-46.699453)
                .setNow("2017-08-01T20:00:00.000Z");
    }

    @Override
    public void onSuccess(String message, PocResponse response) {
        pocView.onGetDataSuccess(message, response.getData().getPocSearch());
    }

    @Override
    public void onFailure(String message) {
        pocView.onGetDataFailure(message);
    }
}
