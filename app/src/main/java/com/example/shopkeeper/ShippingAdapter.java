package com.example.shopkeeper;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ShippingAdapter extends RecyclerView.Adapter<ShippingAdapter.ShippingViewHolder> {
    private List<ShippingModel> shippingList;

    public ShippingAdapter(List<ShippingModel> shippingList) {
        this.shippingList = shippingList;
    }

    @NonNull
    @Override
    public ShippingAdapter.ShippingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.shipping_list, parent, false);

        return new ShippingAdapter.ShippingViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ShippingAdapter.ShippingViewHolder holder, int position) {
    ShippingModel shippingModel = shippingList.get(position);
    holder.companyname.setText(shippingModel.getCompanyname());
    holder.city.setText(shippingModel.getCity());
    holder.state.setText(shippingModel.getState());
    holder.zipcode.setText(shippingModel.getZipcode());




    }

    @Override
    public int getItemCount() {
        return shippingList.size();
    }
    public class ShippingViewHolder extends RecyclerView.ViewHolder{
        public TextView companyname,city,state,zipcode;

        public ShippingViewHolder(@NonNull View itemView) {
            super(itemView);
            companyname = itemView.findViewById(R.id.txtcname);
            city = itemView.findViewById(R.id.txtccity);
            state = itemView.findViewById(R.id.txtcstate);
            zipcode = itemView.findViewById(R.id.txtczipcode);
        }
    }
}
