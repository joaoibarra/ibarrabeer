package com.joaoibarra.ibarrabeer.feature.poc.view;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.joaoibarra.ibarrabeer.R;
import com.joaoibarra.ibarrabeer.model.Address;
import com.joaoibarra.ibarrabeer.model.PocSearch;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PocAdapter extends RecyclerView.Adapter<PocAdapter.ViewHolder>{
    private Context context;
    private List<PocSearch> list;

    public PocAdapter(Context context, List<PocSearch> list){
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public PocAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.poc_item,parent,false);
        ViewHolder myViewHolder = new ViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PocAdapter.ViewHolder holder, int position) {
        Address address = list.get(position).getAddress();
        holder.position = position;
        holder.tvAddress.setText(address.getAddress1() + ", " + address.getNumber() + ", " + address.getCity());
    }

    @Override
    public int getItemCount() {
        return  list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.cardView)
        CardView cardView;

        @BindView(R.id.tvAddress)
        TextView tvAddress;

        int position;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @OnClick(R.id.cardView)
        public void onClickCard(){
            EventBus.getDefault().postSticky(list.get(position));
            //Intent intent = new Intent(this, ProductActivity.class);
        }
    }
}
