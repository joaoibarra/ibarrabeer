package com.joaoibarra.ibarrabeer.feature.product.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.joaoibarra.ibarrabeer.R;
import com.joaoibarra.ibarrabeer.model.Product;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

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
        holder.tvProductName.setText(list.get(position).getProductVariants().get(0).getTitle());
        holder.tvPrice.setText(list.get(position).getProductVariants().get(0).getPriceToString());
        Picasso.get().load(list.get(position).getProductVariants().get(0).getImageUrl()).into(holder.productImageView);
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
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
