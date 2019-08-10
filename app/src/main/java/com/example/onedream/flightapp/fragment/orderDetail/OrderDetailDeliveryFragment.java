package com.example.onedream.flightapp.fragment.orderDetail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.onedream.flightapp.R;
import com.example.onedream.flightapp.base.BaseFragment;
import com.example.onedream.flightapp.bean.DeliveryAndInvoiceInfo;
import com.example.onedream.flightapp.response.OrderDetailResponse;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class OrderDetailDeliveryFragment extends BaseFragment {
    @BindView(R.id.tv_type)
    TextView tvType;
    @BindView(R.id.tv_get_name)
    TextView tvGetName;
    @BindView(R.id.tv_phone)
    TextView tvPhone;
    @BindView(R.id.tv_adress)
    TextView tvAdress;
    @BindView(R.id.tv_send_count)
    TextView tvSendCount;
    @BindView(R.id.tv_company)
    TextView tvCompany;


    @Override
    public int getlayout() {
        return R.layout.fragment_order_detail_delivery;
    }

    @Override
    public void initView() {

    }

    public void refreshData(OrderDetailResponse response) {
        if (response.isSuccess()){
            DeliveryAndInvoiceInfo info = response.getFppsxx();
            if (info!=null){
               tvGetName.setText(info.getSjr()+"");
               tvAdress.setText(info.getSjdz()+"");
               tvPhone.setText(info.getSjrdh()+"");
               tvType.setText(info.getPsfs()+"");
                tvCompany.setText(info.getKd()+"");
                tvSendCount.setText(info.getYjpsf()+"");
            }
        }
    }


}
