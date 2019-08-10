package com.example.onedream.flightapp.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.onedream.flightapp.R;
import com.example.onedream.flightapp.adapter.RvPayListAdapter;
import com.example.onedream.flightapp.base.BaseActivity;
import com.example.onedream.flightapp.bean.PayTypeBean;
import com.example.onedream.flightapp.constant.OrderType;
import com.example.onedream.flightapp.view.RecycleViewDivider;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class PayTypeActivity extends BaseActivity {
    @BindView(R.id.tv_top_price)
    TextView tvTopPrice;
    @BindView(R.id.rv_content)
    RecyclerView rvContent;
    @BindView(R.id.tv_bottom_price)
    TextView tvBottomPrice;
    RvPayListAdapter adapter;
    List<PayTypeBean> list = new ArrayList<>();
    private String ddje ="";//订单金额
    @Override
    public int getLayout() {
        return R.layout.activity_pay_type;
    }

    @Override
    public void initView() {
         ddje = getIntent().getStringExtra(OrderType.ORDER_AMOUNT);//订单金额
        tvBottomPrice.setText(ddje+"");
        tvTopPrice.setText(ddje+"");
        initAdapter();
    }

    private void initAdapter() {
        list.clear();
        list.add(new PayTypeBean("POS支付", true));
        list.add(new PayTypeBean("支付宝扫码支付", false));
        list.add(new PayTypeBean("微信扫码支付", false));
        list.add(new PayTypeBean("预授权支付", false));
        list.add(new PayTypeBean("二维码支付", false));
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        rvContent.addItemDecoration(new RecycleViewDivider(getActivity(),LinearLayoutManager.VERTICAL,1,getResources().getColor(R.color.colorLine)));
        rvContent.setLayoutManager(manager);
        adapter = new RvPayListAdapter(list, getActivity());
        rvContent.setAdapter(adapter);

        adapter.setClickListener(new RvPayListAdapter.ItemClickListener() {
            @Override
            public void click(int position) {
                setCheckAll(position);
                adapter.notifyDataSetChanged();
            }
        });
    }

    private void setCheckAll(int position) {
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                PayTypeBean bean = list.get(i);
                if (i == position) {
                    bean.setCheck(true);
                } else {
                    bean.setCheck(false);
                }
            }
        }
    }




    @OnClick({R.id.tv_back, R.id.ll_bottom})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_back:
                finish();
                break;
            case R.id.ll_bottom:
                if(hasSelectPay()){
                    orderPay();
                }else {
                    showToast("请选择支付方式");
                }
                break;
        }
    }

    //订单支付接口
    private void orderPay() {

    }

    //是否选择了支付方式
    private boolean hasSelectPay() {

        if (list!=null){
            for (PayTypeBean bean : list) {
                if (bean.isCheck()){
                    return true;
                }
            }
        }
        return false;
    }

}
