package com.example.onedream.flightapp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.onedream.flightapp.R;
import com.example.onedream.flightapp.bean.PayTypeBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RvPayListAdapter extends RecyclerView.Adapter<RvPayListAdapter.ViewHolder> {

    List<PayTypeBean> list;
    Context context;

    public RvPayListAdapter(List<PayTypeBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View layout = LayoutInflater.from(context).inflate(R.layout.item_lv_pay_list, viewGroup, false);
        ViewHolder holder = new ViewHolder(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        PayTypeBean bean = list.get(i);
        viewHolder.tvName.setSelected(bean.isCheck());
        viewHolder.tvName.setText(bean.getName());
        if (i==0){
            viewHolder.ivImg.setImageResource(R.mipmap.icon_pos);
        }else if (i==1){
            viewHolder.ivImg.setImageResource(R.mipmap.icon_alipay);
        }else if (i==2){
            viewHolder.ivImg.setImageResource(R.mipmap.icon_wechat);
        }else if (i==3){
            viewHolder.ivImg.setImageResource(R.mipmap.icon_qrcore);
        }else {
            viewHolder.ivImg.setImageResource(R.mipmap.icon_pay_img);
        }

        viewHolder.tvName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clickListener!=null){
                    clickListener.click(i);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    public interface ItemClickListener {
        void click(int position);
    }

    ItemClickListener clickListener;

    public ItemClickListener getClickListener() {
        return clickListener;
    }

    public void setClickListener(ItemClickListener clickListener) {
        this.clickListener = clickListener;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.iv_img)
        ImageView ivImg;
        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);

        }
    }
}
