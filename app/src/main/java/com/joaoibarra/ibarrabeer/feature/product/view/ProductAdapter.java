package com.joaoibarra.ibarrabeer.feature.product.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.joaoibarra.ibarrabeer.R;
import com.joaoibarra.ibarrabeer.model.Product;
import com.joaoibarra.ibarrabeer.model.ProductVariant;
import com.squareup.picasso.Picasso;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {
    private Context context;
    private List<Product> list = new ArrayList<>();
    public ProductAdapter(Context context, List<Product> list){
        this.context = context;
        this.list = list;
    }
    @Override
    public ProductAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item,parent,false);
        ViewHolder myViewHolder = new ViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(ProductAdapter.ViewHolder holder, int position) {
        holder.position = position;
        ProductVariant productVariant = list.get(position).getProductVariants().get(0);
        if(productVariant != null) {
            String title[] = productVariant.getTitle().split("(\\|)|(-)");
            holder.tvProductName.setText(title[0]);
            if(title.length > 1) {
                holder.tvDescription.setText(title[1]);
            }
            holder.tvPrice.setText(productVariant.getPriceToString());
            if (productVariant.getImageUrl() != null &&
                    !productVariant.getImageUrl().equalsIgnoreCase("")) {
                Picasso.get().load(productVariant.getImageUrl()).into(holder.productImageView);
            }
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.productImageView)
        ImageView productImageView;

        @BindView(R.id.tvTitle)
        TextView tvProductName;

        @BindView(R.id.tvPrice)
        TextView tvPrice;

        @BindView(R.id.tvDescription)
        TextView tvDescription;

        int position;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @OnClick(R.id.cardView)
        public void cardViewClick(){
            EventBus.getDefault().postSticky(list.get(position));
            Intent intent = new Intent(context, ProductActivity.class);
            Pair<View, String> p1 = Pair.create((View) productImageView, "productImage");
            Pair<View, String> p2 = Pair.create((View) tvProductName, "productTitle");
            Activity activity = (Activity) context;
            ActivityOptionsCompat options = ActivityOptionsCompat.
                    makeSceneTransitionAnimation(activity,p1, p2);
            context.startActivity(intent, options.toBundle());
        }
    }
}
