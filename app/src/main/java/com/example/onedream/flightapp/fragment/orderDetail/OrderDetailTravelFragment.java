package com.example.onedream.flightapp.fragment.orderDetail;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.onedream.flightapp.R;
import com.example.onedream.flightapp.base.BaseFragment;
import com.example.onedream.flightapp.bean.OrderDetail;
import com.example.onedream.flightapp.bean.PassengerInfo;
import com.example.onedream.flightapp.bean.TravelInfo;
import com.example.onedream.flightapp.response.OrderDetailResponse;
import com.example.onedream.flightapp.utils.SetViewUtils;

import org.apache.commons.lang.StringUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class OrderDetailTravelFragment extends BaseFragment {
    @BindView(R.id.ll_lx)
    LinearLayout llLx;
    @BindView(R.id.tv_no)
    TextView tvNo;
    @BindView(R.id.tv_thing)
    TextView tvThing;
    @BindView(R.id.tv_xm)
    TextView tvXm;
    @BindView(R.id.tv_reson)
    TextView tvReson;


    @Override
    public int getlayout() {
        return R.layout.fragment_order_detail_travel;
    }

    @Override
    public void initView() {
        Log.e("--initView---", "-----------");
    }

    public void refreshData(OrderDetail orderDetail) {
        Log.e("--refreshData---", "-----------");
        if (orderDetail != null) {

            TravelInfo clxx = orderDetail.getClxx();
            List<PassengerInfo> cjrjh = orderDetail.getCjrjh();
            if (cjrjh != null) {

                llLx.removeAllViews();
                for (PassengerInfo info : cjrjh) {
                    View view = View.inflate(getActivity(), R.layout.item_travel_costcenter_view, null);
                    ViewHolder holder = new ViewHolder(view);
                    holder.tvCbCm.setText(setNullText(info.getCjrxm()));
                    holder.tvCb.setText(setNullText(info.getCbzxmc()));
                    llLx.addView(view);
                }

            }
            if (clxx != null) {

                tvNo.setText(setNullText(clxx.getQysph()));
                tvReson.setText(setNullText(clxx.getWbyysm()));
                tvThing.setText(setNullText(clxx.getCcsx()));
                tvXm.setText(setNullText(clxx.getXmmc()));
            }
        }

    }

    private String setNullText(String str) {
        if (TextUtils.isEmpty(str)) {
            return "无";
        } else {
            return str;
        }
    }
    @Override
    public void lazyData() {

    }
    static class ViewHolder {
        @BindView(R.id.tv_cb_cm)
        TextView tvCbCm;
        @BindView(R.id.tv_cb)
        TextView tvCb;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
