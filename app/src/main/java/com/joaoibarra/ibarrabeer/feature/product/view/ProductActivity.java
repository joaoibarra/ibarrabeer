package com.joaoibarra.ibarrabeer.feature.product.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.joaoibarra.ibarrabeer.R;
import com.joaoibarra.ibarrabeer.model.Product;
import com.squareup.picasso.Picasso;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProductActivity extends AppCompatActivity{
    @BindView(R.id.productImageView)
    ImageView productImageView;

    @BindView(R.id.tvTitle)
    TextView tvTitle;

    @BindView(R.id.tvSubTitle)
    TextView tvSubTitle;

    @BindView(R.id.tvDescriptionTitle)
    TextView tvDescriptionTitle;

    @BindView(R.id.tvDescription)
    TextView tvDescription;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        ButterKnife.bind(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getString(R.string.product_detail));
    }

    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void setProduct(Product product) {
        if(product.getProductVariants().get(0).getImageUrl() != null &&
                !product.getProductVariants().get(0).getImageUrl().equalsIgnoreCase("")) {
            Picasso.get().load(product.getProductVariants().get(0).getImageUrl()).into(productImageView);
        }
        tvTitle.setText(product.getProductVariants().get(0).getTitle());
        tvSubTitle.setText(product.getProductVariants().get(0).getPriceToString());
        tvDescription.setText(product.getProductVariants().get(0).getDescription());
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
    public boolean onSupportNavigateUp(){
        onBackPressed();
        return true;
    }
}
