package com.example.onedream.flightapp.activity;


import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.onedream.flightapp.R;
import com.example.onedream.flightapp.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SearchHbActivity extends BaseActivity {
    @BindView(R.id.ed_no)
    EditText edNo;
    @BindView(R.id.ed_thing)
    EditText edThing;
    @BindView(R.id.tv_personi)
    TextView tvPersoni;
    @BindView(R.id.tv_start_city)
    TextView tvStartCity;
    @BindView(R.id.ll_start_city)
    LinearLayout llStartCity;
    @BindView(R.id.tv_end_city)
    TextView tvEndCity;
    @BindView(R.id.ll_end_city)
    LinearLayout llEndCity;
    @BindView(R.id.tv_date)
    TextView tvDate;
    @BindView(R.id.tv_cangwei)
    TextView tvCangwei;

    @Override
    public int getLayout() {
        return R.layout.activity_flight_search;
    }

    @Override
    public void initView() {

    }






    @OnClick({R.id.tv_back, R.id.ll_person, R.id.ll_start_city, R.id.iv_change_city, R.id.ll_date, R.id.ll_cangwei, R.id.btn_search})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_back:
                finish();
                break;
            case R.id.ll_person:
                break;
            case R.id.ll_start_city:
                break;
            case R.id.iv_change_city:
                break;
            case R.id.ll_date:
                break;
            case R.id.ll_cangwei:
                break;
            case R.id.btn_search:
                break;
        }
    }
}
