package com.example.onedream.flightapp.view;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.onedream.flightapp.R;
import com.example.onedream.flightapp.activity.WebActivity;
import com.example.onedream.flightapp.adapter.CouponDetailAdater;
import com.example.onedream.flightapp.bean.CouponDetailBean;
import com.example.onedream.flightapp.bean.OrderDetail;
import com.example.onedream.flightapp.bean.PassengerInfo;
import com.example.onedream.flightapp.utils.DisplayUtils;

import java.util.List;

public class CouponView {
    //礼包信息(退票订单，改签订单)
    public static View addCouponDetailView(Activity activity,OrderDetail orderDetail, int position) {
        View view = View.inflate(activity,R.layout.coupon_detail_base_view,null);
        LinearLayout llCoupon =view.findViewById(R.id.ll_coupon);
        List<PassengerInfo> cjrjh = orderDetail.getCjrjh();
        boolean hasCoupon =false;//是否有礼包信息
        if (cjrjh != null && cjrjh.size() > 0) {
            llCoupon.removeAllViews();
            for (int i = 0; i < cjrjh.size(); i++) {
                boolean showTitle =false;//是否展示姓名
                PassengerInfo info = cjrjh.get(i);
                String cjrxm = (i + 1) + " " + info.getCjrxm();//姓名
                List<CouponDetailBean> couponList;
                List<CouponDetailBean> activeCouponList;
                List<CouponDetailBean> directCouponList;
                if (position == 0) {//原航程
                    couponList = info.getCouponList();//原溢价礼包
                    activeCouponList = info.getActiveCouponList();//原活动礼包
                    directCouponList = info.getDirectCouponList();//原直加礼包
                } else {//新航程
                    couponList = info.getTgqCouponList();//新航程溢价礼包
                    activeCouponList = info.getTgqActiveCouponList();//新航程活动礼包
                    directCouponList = info.getTgqDirectCouponList();//新航程直加礼包
                }
                if (couponList != null || activeCouponList != null || directCouponList != null) {
                    showTitle =true;
                    hasCoupon =true;
                }
                if (showTitle){
                    View itemView = View.inflate(activity,R.layout.item_coupon_name_view,null);
                    TextView tvName = itemView.findViewById(R.id.tv_name);
                    tvName.setText(cjrxm);
                    llCoupon.addView(itemView);
                }
                if (couponList != null) {
                    View itemView = addItemCouponView(activity, couponList);
                    llCoupon.addView(itemView);
                }
                if (activeCouponList != null) {
                    View itemView = addItemCouponView(activity, activeCouponList);
                    llCoupon.addView(itemView);
                }
                if (directCouponList != null) {
                    View itemView = addItemCouponView(activity, directCouponList);
                    llCoupon.addView(itemView);
                }
            }

        }
        if (!hasCoupon){//如果没有礼包信息置空
            view =null;
        }
        return view;
    }

    public static View addItemCouponView(Activity activity,List<CouponDetailBean> couponList) {
        View itemView = View.inflate(activity, R.layout.item_coupon_detail_view, null);
        LinearLayout llTitle = itemView.findViewById(R.id.ll_title);
        TextView tvTitle = itemView.findViewById(R.id.tv_title);
        RecyclerView recyview = itemView.findViewById(R.id.recyview);
        CouponDetailBean bean = couponList.get(0);
        String couponPackageName = bean.getCoupon_package_name();
        if (!TextUtils.isEmpty(couponPackageName)) {
            tvTitle.setText(couponPackageName);
        }
        llTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CouponDetailBean bean = couponList.get(0);
                String url = bean.getCoupon_package_info_url();
                Intent intent = new Intent(activity, WebActivity.class);
                intent.putExtra("url", url);
                intent.putExtra("name", bean.getCoupon_package_name() + "");
                activity.startActivity(intent);
            }
        });
        LinearLayoutManager manager = new LinearLayoutManager(activity);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyview.setLayoutManager(manager);
        int widthPixels = activity.getResources().getDisplayMetrics().widthPixels - DisplayUtils.dip2px(activity, 20);
        CouponDetailAdater actAdater = new CouponDetailAdater(activity, couponList, widthPixels);
        recyview.setAdapter(actAdater);
        return itemView;
    }
}
