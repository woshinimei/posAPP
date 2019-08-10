package com.example.onedream.flightapp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.onedream.flightapp.R;
import com.example.onedream.flightapp.bean.TopBarBean;

import java.util.List;

public class OrderDetailTopAdapter extends RecyclerView.Adapter<OrderDetailTopAdapter.ViewHolder> {

    List<TopBarBean> list;
    Context context;

    public OrderDetailTopAdapter(List<TopBarBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_order_detail_top_btn, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        TopBarBean bean = list.get(i);
        viewHolder.tvContent.setText(bean.getName());
        viewHolder.tvContent.setSelected(bean.isSelect());
        if (list != null && list.size() > 0) {
            int width = context.getResources().getDisplayMetrics().widthPixels / list.size();
            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(width, ViewGroup.LayoutParams.WRAP_CONTENT);
            viewHolder.flContent.setLayoutParams(params);
        }
        viewHolder.tvContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAllSelect(false);
                bean.setSelect(true);
                notifyDataSetChanged();
                if (listener!=null){
                    listener.selectItem(i);
                }
            }
        });
    }

    public  void setAllSelect(boolean isSelected) {
        if (list!=null){
            for (TopBarBean bean : list) {
                bean.setSelect(isSelected);
            }
        }
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    public interface OnSelectListener {
        void selectItem(int pisition);
    }

    OnSelectListener listener;

    public OnSelectListener getListener() {
        return listener;
    }

    public void setListener(OnSelectListener listener) {
        this.listener = listener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        FrameLayout flContent;
        TextView tvContent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            flContent = itemView.findViewById(R.id.fl_content);
            tvContent = itemView.findViewById(R.id.tv_content);
        }
    }
}
