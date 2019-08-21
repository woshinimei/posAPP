package com.example.onedream.flightapp.activity;

import android.app.Activity;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.onedream.flightapp.R;
import com.example.onedream.flightapp.adapter.RvPayListAdapter;
import com.example.onedream.flightapp.base.BaseActivity;
import com.example.onedream.flightapp.bean.PayTypeBean;
import com.example.onedream.flightapp.bean.PosPayInfo;
import com.example.onedream.flightapp.config.MyApp;
import com.example.onedream.flightapp.constant.OrderType;
import com.example.onedream.flightapp.intefaces.OnCallBack;
import com.example.onedream.flightapp.model.PayModel;
import com.example.onedream.flightapp.request.PayRequest;
import com.example.onedream.flightapp.response.PayResponse;
import com.example.onedream.flightapp.utils.GsonUtils;
import com.example.onedream.flightapp.view.MyDialog;
import com.example.onedream.flightapp.view.RecycleViewDivider;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
    private String ddje = "";//订单金额
    private String orderNo = "";//订单编号
    private int type = 0;//

    @Override
    public int getLayout() {
        return R.layout.activity_pay_type;
    }

    @Override
    public void initView() {
        ddje = getIntent().getStringExtra(OrderType.ORDER_AMOUNT);//订单金额
        orderNo = getIntent().getStringExtra(OrderType.ORDER_NO);//订单编号
        type = getIntent().getIntExtra(OrderType.ORDER_TYPE, 0);

        tvBottomPrice.setText(ddje + "");
        tvTopPrice.setText(ddje + "");
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
        rvContent.addItemDecoration(new RecycleViewDivider(getActivity(), LinearLayoutManager.VERTICAL, 1, getResources().getColor(R.color.colorLine)));
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
                if (hasSelectPay()) {

                    if (chooseItemPay()) {
                        //跳转银行支付
                        goToBankPay();
                    } else {
                        orderPay();
                    }


                } else {
                    showToast("请选择支付方式");
                }
                break;
        }
    }

    private boolean chooseItemPay() {
        for (PayTypeBean bean : list) {
            if (bean.isCheck() && bean.getName().equals("预授权支付")) {
                return true;
            }
        }
        return false;
    }

    private void goToBankPay() {
        if (checkPackInfo("com.boc.smartpos.bankpay")) {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.boc.smartpos.bankpay", " com.boc.smartpos.bankpay.ui.MainActivity"));
            intent.putExtra("transName", "消费");
            intent.putExtra("amount", "0.01");
            startActivityForResult(intent, 0);
        } else {
            showToast("中行app未安装");
        }
    }

    /**
     * 检查包是否存在
     *
     * @param packname
     * @return
     */
    private boolean checkPackInfo(String packname) {
        PackageInfo packageInfo = null;
        try {
            packageInfo = getPackageManager().getPackageInfo(packname, 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return packageInfo != null;
    }

    //订单支付接口
    private void orderPay() {
        PayModel model = new PayModel();
        PayRequest request = new PayRequest();
        request.setDdbh(orderNo);
        request.setPayResult("0");
        request.setPayType("0");
        PosPayInfo info = new PosPayInfo();
        info.setAmount(ddje + "");
        info.setBatchNo("4234324");
        info.setCardNo("4234322222");
        info.setDate("2019-12-1");
        info.setMerchantId("32132");
        request.setPosPayInfo(info);
        model.getData(getActivity(), type, request, new OnCallBack<String>() {
            @Override
            public void onSucess(String s) {
                PayResponse response = GsonUtils.fromJson(s, PayResponse.class);
                if (response.isSuccess()) {
                    showSuccessDialog();
                }
            }

            @Override
            public void onError(String msg) {
                showToast(msg);
            }
        });
    }

    MyDialog successDialog;

    private void showSuccessDialog() {
        View view = View.inflate(getActivity(), R.layout.pay_success_layout, null);
        TextView tvOrder = view.findViewById(R.id.tv_order);
        tvOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                successDialog.dismiss();
            }
        });
        TextView tvList = view.findViewById(R.id.tv_list);
        tvList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                successDialog.dismiss();
                Set<Activity> set = MyApp.getInstance().getSet();
                if (set != null) {
                    for (int i = 0; i < set.size(); i++) {
                        for (Activity activity : set) {
                            if (!activity.isFinishing() && activity.getClass().equals(OrderDetailActivity.class)) {
                                activity.finish();
                            }
                            if (!activity.isFinishing() && activity.getClass().equals(OrderListActivity.class)) {
                                activity.finish();
                            }
                        }
                    }
                }
                startActivity(new Intent(getActivity(), OrderListActivity.class));

            }
        });

        successDialog = new MyDialog(getActivity(), view);
        successDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                finish();
            }
        });
        successDialog.showPaddingScreen();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (successDialog != null && successDialog.isShowing()) {
            successDialog.dismiss();
        }
    }

    //是否选择了支付方式
    private boolean hasSelectPay() {

        if (list != null) {
            for (PayTypeBean bean : list) {
                if (bean.isCheck()) {
                    return true;
                }
            }
        }
        return false;
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (resultCode) {
            case Activity.RESULT_CANCELED:
                String reason = data.getStringExtra("reason");
                if (reason != null) {
                    showToast(reason);
                }
                break;
            case Activity.RESULT_OK:
                    showToast("交易成功");
                break;
        }
    }
}
