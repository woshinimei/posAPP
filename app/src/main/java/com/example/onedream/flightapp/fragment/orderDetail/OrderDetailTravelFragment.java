package com.example.onedream.flightapp.fragment.orderDetail;

import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.onedream.flightapp.R;
import com.example.onedream.flightapp.base.BaseFragment;
import com.example.onedream.flightapp.bean.PassengerInfo;
import com.example.onedream.flightapp.bean.TravelInfo;
import com.example.onedream.flightapp.response.OrderDetailResponse;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

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
        Log.e("--initView---","-----------");
    }

    public void refreshData(OrderDetailResponse response) {
        Log.e("--refreshData---","-----------");
        if (response.isSuccess()) {
            if (response.getDetail() != null) {
                TravelInfo clxx = response.getDetail().getClxx();
                List<PassengerInfo> cjrjh = response.getDetail().getCjrjh();
                if (cjrjh != null) {

                    llLx.removeAllViews();
                    for (PassengerInfo info : cjrjh) {
                        View view = View.inflate(getActivity(), R.layout.item_travel_costcenter_view, null);
                        ViewHolder holder = new ViewHolder(view);
                        holder.tvCbCm.setText(info.getCjrxm() + "");
                        holder.tvCb.setText(info.getCbzxmc() + "");
                        llLx.addView(view);
                    }

                }
                if (clxx != null) {
                    tvNo.setText(clxx.getQysph() + "");
                    tvReson.setText(clxx.getWbyysm() + "");
                    tvThing.setText(clxx.getXmdh() + "");
                    tvXm.setText(clxx.getXmmc());
                }
            }
        }
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
