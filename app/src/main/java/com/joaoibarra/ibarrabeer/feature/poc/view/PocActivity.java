package com.joaoibarra.ibarrabeer.feature.poc.view;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.joaoibarra.ibarrabeer.R;
import com.joaoibarra.ibarrabeer.feature.poc.contract.PocContract;
import com.joaoibarra.ibarrabeer.feature.poc.presenter.PocPresenter;
import com.joaoibarra.ibarrabeer.model.PocSearch;
import com.joaoibarra.ibarrabeer.model.constants.Permission;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnTextChanged;

/**
 * Created by joaoibarra on 08/04/18.
 */

public class PocActivity extends AppCompatActivity implements PocContract.View{
    @BindView(R.id.etPocSearch)
    EditText etPocSearch;
    @BindView(R.id.pocRecyclerView)
    RecyclerView pocRecyclerView;

    private PocPresenter pocPresenter;
    private PocAdapter pocAdapter;

    private FusedLocationProviderClient mFusedLocationClient;

    Location lastLocation;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poc);
        ButterKnife.bind(this);

        pocPresenter = new PocPresenter(this);

        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        checkPermission();
        getLastKnownLocation();

        pocRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case Permission.LOCATION: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    getLastKnownLocation();
                }
                return;
            }
        }
    }

    private void getLastKnownLocation() {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            mFusedLocationClient.getLastLocation()
                    .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                        @Override
                        public void onSuccess(Location location) {
                            if (location != null) {
                                lastLocation = location;
                                pocSearch("");
                            }
                        }
                    });
        }
    }

    private void checkPermission(){
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)) {

            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        Permission.LOCATION);
            }
        }
    }

    @OnTextChanged(R.id.etPocSearch)
    public void pocSearch(CharSequence text){
        pocPresenter.getPoc(text, lastLocation);
    }

    @Override
    public void onGetDataSuccess(String message, List<PocSearch> list) {
        pocAdapter = new PocAdapter(getApplicationContext(), list);
        pocRecyclerView.setAdapter(pocAdapter);
    }

    @Override
    public void onGetDataFailure(String message) {

    }
}
