package com.example.shopkeeper.Order;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shopkeeper.HomeScreen.recadapter;
import com.example.shopkeeper.R;
import com.example.shopkeeper.Remote.AndroidVersion;

import java.util.ArrayList;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.viewHolder> {
    private ArrayList<AndroidVersion> android;

    public OrderAdapter(ArrayList<AndroidVersion> android) {
        this.android = android;
    }
    @NonNull
    @Override
    public OrderAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_row, viewGroup, false);
        return new viewHolder(view);

    }
    @Override
    public void onBindViewHolder(@NonNull OrderAdapter.viewHolder holder, int i) {
        holder.tv_name.setText(android.get(i).getName());
        holder.tv_version.setText(android.get(i).getVer());
        holder.tv_api_level.setText(android.get(i).getApi());

    }

    @Override
    public int getItemCount() {
        return android.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        private TextView tv_name,tv_version,tv_api_level;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            tv_name = (TextView)itemView.findViewById(R.id.tv_name);
            tv_version = (TextView)itemView.findViewById(R.id.tv_version);
            tv_api_level = (TextView)itemView.findViewById(R.id.tv_api_level);
        }
    }
}

