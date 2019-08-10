package com.example.onedream.flightapp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.onedream.flightapp.R;
import com.example.onedream.flightapp.bean.ControlBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ControlCompanyAdapter extends RecyclerView.Adapter<ControlCompanyAdapter.ViewHolder> {
    List<ControlBean> list;
    Context context;

    public ControlCompanyAdapter(List<ControlBean> list, Context context) {
        this.list = list;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_control_company_view, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return list==null?0:list.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_company)
        TextView tvCompany;
        @BindView(R.id.tv_mc)
        TextView tvMc;
        @BindView(R.id.tv_lxr)
        TextView tvLxr;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
