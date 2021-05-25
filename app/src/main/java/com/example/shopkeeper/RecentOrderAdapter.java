package com.example.shopkeeper;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shopkeeper.recentorder.response.RecentOrderModel;

import java.util.List;

public class RecentOrderAdapter extends RecyclerView.Adapter<RecentOrderAdapter.MyViewHolder> {
    private List<RecentOrderModel> recentOrders;

    public RecentOrderAdapter(List<RecentOrderModel> recentOrders) {
        this.recentOrders = recentOrders;
    }

    @NonNull
    @Override
    public RecentOrderAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recent_order, parent, false);

        return new RecentOrderAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecentOrderAdapter.MyViewHolder holder, int position) {
        RecentOrderModel recentOrder= recentOrders.get(position);
        holder.ordernumber.setText(String.valueOf(recentOrder.getInventoryOrderID()));
        holder.orderstatus.setText(recentOrder.getOrderStatus());
        holder.companyname.setText(recentOrder.getCompanyName());
        holder.ordertime.setText(recentOrder.getDateTimeOrder());
        holder.orderinvoice.setText(String.valueOf(recentOrder.getInvoiceNo()));
        holder.orderamount.setText(String.valueOf(recentOrder.getTotalOrderAmount()));

    }

    @Override
    public int getItemCount() {
        return recentOrders.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView ordernumber;
        private TextView orderstatus;
        private TextView companyname;
        private TextView ordertime;
        private TextView orderinvoice;
        private TextView orderamount;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ordernumber = itemView.findViewById(R.id.txtordernum);
            orderstatus = itemView.findViewById(R.id.txtorderstatus);
            companyname = itemView.findViewById(R.id.txtcompanyname);
            ordertime = itemView.findViewById(R.id.txtordertime);
            orderinvoice = itemView.findViewById(R.id.orderinvoicenum);
            orderamount = itemView.findViewById(R.id.txtorderamount);

        }
    }
}
