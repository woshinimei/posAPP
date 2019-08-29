package com.example.onedream.flightapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.onedream.flightapp.R;
import com.example.onedream.flightapp.activity.OrderDetailActivity;
import com.example.onedream.flightapp.bean.OrderListBean;
import com.example.onedream.flightapp.constant.AppLocal;
import com.example.onedream.flightapp.constant.OrderType;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OrderListAdapter extends RecyclerView.Adapter<OrderListAdapter.MyViewHolder> {

    List<OrderListBean> list;
    Context context;
    int type = 0;//   0:普通订单      1 ：退废单    2:改签单

    public OrderListAdapter(List<OrderListBean> list, Context context, int type) {
        this.list = list;
        this.context = context;
        this.type = type;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_order_list, viewGroup, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int i) {
        OrderListBean bean = list.get(i);
        holder.tvPrice.setText(bean.getOrderPirce());
        String status = setNullText(bean.getOrderStatus());
        String content = "";
        int statusColor = R.color.colorT9;
        String[] orderStatus;
        String[] orderStatusType;
        if (type == 0) {
            orderStatus = AppLocal.orderStatus;
            orderStatusType = AppLocal.orderStatusType;
        } else if (type == 1) {
            orderStatus = AppLocal.orderStatusOfRefund;
            orderStatusType = AppLocal.orderStatusTypeOfRefund;
        } else {
            orderStatus = AppLocal.orderStatusOfEndore;
            orderStatusType = AppLocal.orderStatusTypeOfEndore;
        }
        if (orderStatus!=null&&orderStatusType!=null) {
            for (int k = 0; k < orderStatusType.length; k++) {
                if (status.equals(orderStatusType[k])) {
                    content = orderStatus[k];
                    if (content.contains("完成")) {
                        statusColor = R.color.colorBlue;
                    } else {
                        statusColor = R.color.colorT9;
                    }
                }
            }
        }
        String zfzt = bean.getZfzt();
        if (!content.equals("已取消") && !TextUtils.isEmpty(zfzt)) {
            content = content + "-" + zfzt;
        }
        holder.tvName.setText(setNullText(bean.getName()));
        holder.tvCity.setText(setNullText(bean.getCfcity()) + "-" + setNullText(bean.getDdcity()));
        holder.tvStatus.setText(content);
        holder.tvPrice.setText(setNullText(bean.getOrderPirce()));
        holder.tvTime.setText(setNullText(bean.getTakeOffTime()) + "     起飞");
        holder.tvStatus.setTextColor(context.getResources().getColor(statusColor));
        holder.llContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, OrderDetailActivity.class);
                intent.putExtra(OrderType.ORDER_TYPE, type);
                String orderNo = bean.getOrderNo();
                intent.putExtra(OrderType.ORDER_NO, orderNo);
                intent.putExtra(OrderType.ORDER_STATUS, status);
                context.startActivity(intent);

            }
        });
    }

    private String setNullText(String content) {
        if (TextUtils.isEmpty(content)) {
            return "";
        } else {
            return content;
        }
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_img)
        ImageView ivImg;
        @BindView(R.id.tv_city)
        TextView tvCity;
        @BindView(R.id.tv_price)
        TextView tvPrice;
        @BindView(R.id.tv_status)
        TextView tvStatus;
        @BindView(R.id.tv_time)
        TextView tvTime;
        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.ll_content)
        LinearLayout llContent;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


}
