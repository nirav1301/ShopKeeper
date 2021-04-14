package com.example.shopkeeper;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ItemViewHolder> {
    private List<CountryModel> mCountryModel;
    private List<CountryModel> mOriginalCountryModel;

    public RVAdapter(List<CountryModel> mCountryModel) {
        this.mCountryModel = mCountryModel;
        this.mOriginalCountryModel = mCountryModel;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_row, viewGroup, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder itemViewHolder, int i) {
        final CountryModel model = mCountryModel.get(i);
        itemViewHolder.bind(model);
    }

    @Override
    public int getItemCount() {
        return mCountryModel.size();
    }
    public void setFilter(List<CountryModel> countryModels){
        mCountryModel = new ArrayList<>();
        mCountryModel.addAll(countryModels);
        notifyDataSetChanged();
    }


    public class ItemViewHolder extends RecyclerView.ViewHolder {
        public TextView name_TextView;
        public TextView iso_TextView;

        public ItemViewHolder(View itemView) {
            super(itemView);
            itemView.setClickable(true);
            name_TextView = (TextView) itemView.findViewById(R.id.country_name);
            iso_TextView = (TextView) itemView.findViewById(R.id.country_iso);
        }

        public void bind(CountryModel countryModel) {
            name_TextView.setText(countryModel.getName());
            iso_TextView.setText(countryModel.getIsocode());
        }

    }
}
