package com.example.onedream.flightapp.fragment.orderDetail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.onedream.flightapp.R;
import com.example.onedream.flightapp.base.BaseFragment;
import com.example.onedream.flightapp.bean.JbInfo;
import com.example.onedream.flightapp.response.OrderDetailResponse;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class OrderDetailApprovalFragment extends BaseFragment {
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_status)
    TextView tvStatus;
    @BindView(R.id.tv_result)
    TextView tvResult;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.tv_adress)
    TextView tvAdress;


    @Override
    public int getlayout() {
        return R.layout.fragment_order_detail_approval;
    }

    @Override
    public void initView() {

    }

    public void refreshData(OrderDetailResponse response) {
        if (response.isSuccess()){
            JbInfo jbxx = response.getJbxx();
            if (jbxx!=null){

            }
        }
    }


}
