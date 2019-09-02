package com.example.onedream.flightapp.adapter;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.onedream.flightapp.R;
import com.example.onedream.flightapp.activity.WebActivity;
import com.example.onedream.flightapp.bean.CouponBean;
import com.example.onedream.flightapp.utils.MyTextUtil;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.List;

import butterknife.BindView;


public class CouponAdater extends RecyclerView.Adapter<CouponAdater.MyHoldel> {
    Context content;
    List<CouponBean> list;
    int width = 100;

    public CouponAdater(Context content, List<CouponBean> list, int width) {
        this.content = content;
        this.list = list;
        if (width > 0) {
            this.width = width;
        }
    }

    @Override
    public MyHoldel onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(content).inflate(R.layout.item_flight_coupon_view, parent, false);
        MyHoldel holdel = new MyHoldel(view);
        return holdel;
    }

    @Override
    public void onBindViewHolder(MyHoldel holder, int position) {
        CouponBean bean = list.get(position);
        String couponName = bean.getCouponName();
        String activeIcon = bean.getActiveIcon();
        String couponNum = bean.getCouponNum();
        if (!TextUtils.isEmpty(couponNum)&&!couponNum.equals("1")){
            holder.tvName.setText(couponName + "x"+couponNum+"张");
        }else {
            holder.tvName.setText(couponName + "");
        }
        Glide.with(content).load(activeIcon).error(R.mipmap.icon_zj_qian).into(holder.iv);
        holder.tvName.setText(couponName + "");
        String status = MyTextUtil.clearNullText(bean.getStatus());
        if (!TextUtils.isEmpty(status) && (status.equals("1")||status.equals("2"))) {
            holder.ivUser.setVisibility(View.VISIBLE);
        }else {
            holder.ivUser.setVisibility(View.GONE);
        }
        final String url = bean.getDetailH5Url();
        holder.llitem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(content, WebActivity.class);
                intent.putExtra("url", url);
                intent.putExtra("name", "卡券详情");
                content.startActivity(intent);
            }
        });
        if (list != null) {
            if (list.size() >= 4) {
                //均分为4列
                ViewGroup.LayoutParams params = holder.llitem. getLayoutParams();
                params.width = width / 4;
                holder.llitem.setLayoutParams(params);
            } else{
                ViewGroup.LayoutParams params = holder.llitem. getLayoutParams();
                params.width = width / list.size();
                holder.llitem.setLayoutParams(params);
            }
        }
    }

    private String setNullText(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        return "";
    }
    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    public static class MyHoldel extends RecyclerView.ViewHolder {
        @ViewInject(R.id.iv_content)
        ImageView iv;
        @ViewInject(R.id.tv_name)
        TextView tvName;
        @ViewInject(R.id.ll_item)
        LinearLayout llitem;
        @ViewInject(R.id.iv_used)
        ImageView ivUser;

        public MyHoldel(View itemView) {
            super(itemView);
            x.view().inject(this, itemView);
        }
    }
}
