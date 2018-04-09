package com.joaoibarra.ibarrabeer.feature.product.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.joaoibarra.ibarrabeer.R;
import com.joaoibarra.ibarrabeer.feature.product.contract.ProductListContract;
import com.joaoibarra.ibarrabeer.feature.product.presenter.ProductListPresenter;
import com.joaoibarra.ibarrabeer.model.PocSearch;
import com.joaoibarra.ibarrabeer.model.Product;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProductListActivity extends AppCompatActivity implements ProductListContract.View{
    @BindView(R.id.productRecyclerView)
    RecyclerView productRecyclerView;

    ProductListPresenter productListPresenter;
    ProductAdapter productAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);
        ButterKnife.bind(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        productListPresenter = new ProductListPresenter(this);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        productRecyclerView.setLayoutManager(mLayoutManager);
    }

    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void setPocSearch(PocSearch pocSearch) {
        getSupportActionBar().setTitle(pocSearch.getAddress().getAddress1() + ", " + pocSearch.getAddress().getNumber() + ", " + pocSearch.getAddress().getCity());
        productListPresenter.getProducts(pocSearch, "", 0);
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }

    @Override
    public void onGetDataSuccess(String message, List<Product> list) {
        productAdapter = new ProductAdapter(this, list);
        productRecyclerView.setAdapter(productAdapter);
    }

    @Override
    public void onGetDataFailure(String message) {

    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
