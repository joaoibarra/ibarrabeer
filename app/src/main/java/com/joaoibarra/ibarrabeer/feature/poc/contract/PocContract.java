package com.joaoibarra.ibarrabeer.feature.poc.contract;

import android.location.Location;

import com.joaoibarra.ibarrabeer.model.PocResponse;
import com.joaoibarra.ibarrabeer.model.PocSearch;
import com.joaoibarra.ibarrabeer.model.search.SearchPoc;

import java.util.List;

/**
 * Created by joaoibarra on 08/04/18.
 */

public class PocContract {
    public interface Presenter{
        void getPoc(CharSequence searchAddress, Location location);
    }

    public interface View{
        void onGetDataSuccess(String message, List<PocSearch> list);
        void onGetDataFailure(String message);
    }

    public interface Interactor{
        void getPoc(SearchPoc searchPoc);
    }

    public interface OnGetPocResponseListener{
        void onSuccess(String message, PocResponse response);
        void onFailure(String message);
    }
}
