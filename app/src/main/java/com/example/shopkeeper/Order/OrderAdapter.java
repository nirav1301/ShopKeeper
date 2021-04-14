package com.example.shopkeeper.Order;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shopkeeper.HomeScreen.recadapter;
import com.example.shopkeeper.R;
import com.example.shopkeeper.Remote.AndroidVersion;

import java.util.ArrayList;
import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.viewHolder> implements Filterable {
    private ArrayList<AndroidVersion> android;
    private ArrayList<AndroidVersion> androidList;

    public OrderAdapter(ArrayList<AndroidVersion> android) {
        this.android = android;
        androidList = new ArrayList<>(androidList);
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

    @Override
    public Filter getFilter() {
        return androidFilter;
    }
    private Filter androidFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<AndroidVersion> filteredList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(androidList);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();
                for (AndroidVersion item : androidList) {
                    if (item.getName().toLowerCase().contains(filterPattern)) {
                        filteredList.add(item);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;
        }
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            android.clear();
            android.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };

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

