package com.example.onedream.flightapp.activity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.onedream.flightapp.R;
import com.example.onedream.flightapp.adapter.RvPayListAdapter;
import com.example.onedream.flightapp.base.BaseActivity;
import com.example.onedream.flightapp.bean.AliPayInfo;
import com.example.onedream.flightapp.bean.PayTypeBean;
import com.example.onedream.flightapp.bean.PosPayInfo;
import com.example.onedream.flightapp.bean.QrCodePayInfo;
import com.example.onedream.flightapp.bean.WechatPayInfo;
import com.example.onedream.flightapp.config.MyApp;
import com.example.onedream.flightapp.constant.OrderType;
import com.example.onedream.flightapp.intefaces.OnCallBack;
import com.example.onedream.flightapp.model.CheckModel;
import com.example.onedream.flightapp.model.PayModel;
import com.example.onedream.flightapp.request.PayRequest;
import com.example.onedream.flightapp.response.CheckResponse;
import com.example.onedream.flightapp.response.PayResponse;
import com.example.onedream.flightapp.utils.GsonUtils;
import com.example.onedream.flightapp.utils.MoneyUtils;
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
    private String ddbh = "";//订单编号
    private int type = 0;//
    //支付类型
    private String[] payType = {"POS支付", "支付宝扫码支付", "微信扫码支付", "二维码支付"};
    //transName 支付调起类型
    private String[] tranNameList = {"消费", "支付宝扫码消费", "微信扫码消费", "二维码消费"};

    @Override
    public int getLayout() {
        return R.layout.activity_pay_type;
    }

    @Override
    public void initView() {
        ddje = getIntent().getStringExtra(OrderType.ORDER_AMOUNT);//订单金额
        ddbh = getIntent().getStringExtra(OrderType.ORDER_NO);//订单编号
        type = getIntent().getIntExtra(OrderType.ORDER_TYPE, 0);

        tvBottomPrice.setText(ddje + "");
        tvTopPrice.setText(ddje + "");
        initAdapter();
    }

    private void initAdapter() {
        list.clear();
        list.add(new PayTypeBean(payType[0], true));
        list.add(new PayTypeBean(payType[1], false));
        list.add(new PayTypeBean(payType[2], false));
        list.add(new PayTypeBean(payType[3], false));
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
                //先校验价格
                checkForPay();
                break;
        }
    }

    //校验价格
    private void checkForPay() {
        CheckModel model = new CheckModel();
        model.checkPayOrRefund(getActivity(), type, ddbh, ddje, new OnCallBack<String>() {
            @Override
            public void onSucess(String s) {
                CheckResponse response = GsonUtils.fromJson(s,CheckResponse.class);
                if (response.isSuccess()){
                    //开始支付
                    payNow();
                }else {
                    showToast(response.getMessage()+"");
                }
            }

            @Override
            public void onError(String msg) {
                showToast(msg);
            }
        });


    }
    //开始支付
    private void payNow(){
        if (hasSelectPay()) {
            //选择支付方式
            int position = chooseItemPay();
            String count = MoneyUtils.changeY2F(ddje);
            Log.e("----12位金额----", count + "");
            Log.e("---position--", position + "");
            String amount = "000000000003";
            goToBankPay(amount, tranNameList[position]);
        } else {
            showToast("请选择支付方式");
        }
    }
    //选择支付方式
    private int chooseItemPay() {
        for (int i = 0; i < list.size(); i++) {
            PayTypeBean bean = list.get(i);
            if (bean.isCheck()) {
                return i;
            }

        }
        return 0;
    }


    private void goToBankPay(String amount, String transName) {
        Log.e("--amount-", amount + "");
        Log.e("--transName-", transName + "");
        if (checkPackInfo("com.boc.smartpos.bankpay")) {
            try {
                Intent intent = new Intent();
//            intent.setComponent(new ComponentName("com.boc.smartpos.bankpay", " com.boc.smartpos.bankpay.ui.MainActivity"));
                intent.setClassName("com.boc.smartpos.bankpay", "com.boc.smartpos.bankpay.ui.MainActivity");
                intent.putExtra("transName", transName);
                intent.putExtra("amount", amount);
                startActivityForResult(intent, 0);
            } catch (Exception e) {
                showToast("跳转失败");
            }

        } else {
            showToast("中国银行app尚未安装");
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
                int position = chooseItemPay();
                //pos机支付成功后请求回调差旅支付接口
                showToast("交易回调");
                payResult(position, data);

                break;
        }
    }

    //回调差旅支付接口
    private void payResult(int position, Intent data) {
        switch (position) {
            case 0://pos支付
                posPay(data);
                break;
            case 1://支付宝支付
                aliPay(data);
                break;
            case 2://微信支付
                wechatPay(data);
                break;
            case 3://二维码支付
                QrCodePay(data);
                break;
        }

    }

    //二维码支付
    private void QrCodePay(Intent data) {
        String amount = data.getStringExtra("amount");
        String traceNo = data.getStringExtra("traceNo");
        String referenceNo = data.getStringExtra("referenceNo");
        String cardNo = data.getStringExtra("cardNo");
        String authorizationCode = data.getStringExtra("authorizationCode");
        String batchNo = data.getStringExtra("batchNo");
        String time = data.getStringExtra("time");
        String date = data.getStringExtra("date");
        String terminalId = data.getStringExtra("terminalId");
        String merchantId = data.getStringExtra("merchantId");
        String merchantName = data.getStringExtra("merchantName");
        String payCodInfo = data.getStringExtra("payCodInfo");
        String unionPayTradeNo = data.getStringExtra("unionPayTradeNo");
        String promotionCode = data.getStringExtra("promotionCode");
        String realAmount = data.getStringExtra("realAmount");
        String promotionAmount = data.getStringExtra("promotionAmount");
        QrCodePayInfo qcInfo = new QrCodePayInfo();
        qcInfo.setAmount(ddje);
        qcInfo.setTraceNo(traceNo);
        qcInfo.setReferenceNo(referenceNo);
        qcInfo.setCardNo(cardNo);
        qcInfo.setAuthorizationCode(authorizationCode);
        qcInfo.setBatchNo(batchNo);
        qcInfo.setTime(time);
        qcInfo.setDate(date);
        qcInfo.setTerminalId(terminalId);
        qcInfo.setMerchantId(merchantId);
        qcInfo.setMerchantName(merchantName);
        qcInfo.setPayCodInfo(payCodInfo);
        qcInfo.setUnionPayTradeNo(unionPayTradeNo);
        qcInfo.setPromotionCode(promotionCode);
        qcInfo.setRealAmount(realAmount);
        qcInfo.setPromotionAmount(promotionAmount);
//        Log.e("---amount--", amount + "");
//        Log.e("---traceNo --", traceNo + "");
//        Log.e("---referenceNo --", referenceNo + "");
//        Log.e("---cardNo --", cardNo + "");
//        Log.e("---type  --", type + "");
//        Log.e("---authorizationCode--", authorizationCode + "");
//        Log.e("---batchNo --", batchNo + "");
//        Log.e("---time --", time + "");
//        Log.e("---date --", date+"");
//        Log.e("---terminalId --",  terminalId+ "");
//        Log.e("---merchantId --",  merchantId+ "");
//        Log.e("---merchantName --",  merchantName+ "");
//        Log.e("---payCodInfo --",  payCodInfo+ "");
//        Log.e("---unionPayTradeNo --",  unionPayTradeNo+ "");
//        Log.e("---promotionCode --",  promotionCode+ "");
//        Log.e("---realAmount --",  realAmount+ "");
//        Log.e("---promotionAmount --",  promotionAmount+ "");
        PayRequest request = new PayRequest();
        request.setDdbh(ddbh);
        request.setPayResult("1");
        request.setPayType("0");
        request.setQrcodePayInfo(qcInfo);
        //回调接口
        orderPay(request);
    }

    //微信支付
    private void wechatPay(Intent data) {
        String amount = data.getStringExtra("amount");
        String traceNo = data.getStringExtra("traceNo");
        String batchNo = data.getStringExtra("batchNo");
        String time = data.getStringExtra("time");
        String date = data.getStringExtra("date");
        String terminalId = data.getStringExtra("terminalId");
        String merchantId = data.getStringExtra("merchantId");
        String merchantName = data.getStringExtra("merchantName");
        String orderNo = data.getStringExtra("orderNo");
        WechatPayInfo weInfo = new WechatPayInfo();
        weInfo.setAmount(ddje);
        weInfo.setTraceNo(traceNo);
        weInfo.setBatchNo(batchNo);
        weInfo.setTime(time);
        weInfo.setDate(date);
        weInfo.setTerminalId(terminalId);
        weInfo.setMerchantId(merchantId);
        weInfo.setMerchantName(merchantName);
        weInfo.setOrderNo(orderNo);
//        Log.e("----orderNo---",orderNo+"");
//        Log.e("---amount--", amount + "");
//        Log.e("---traceNo --", traceNo + "");
//        Log.e("---type  --", type + "");
//        Log.e("---batchNo --", batchNo + "");
//        Log.e("---time --", time + "");
//        Log.e("---date --", date+"");
//        Log.e("---terminalId --",  terminalId+ "");
//        Log.e("---merchantId --",  merchantId+ "");
//        Log.e("---merchantName --",  merchantName+ "");
        PayRequest request = new PayRequest();
        request.setDdbh(ddbh);
        request.setPayResult("1");
        request.setPayType("0");
        request.setWechatPayInfo(weInfo);
        //回调接口
        orderPay(request);
    }

    //支付宝支付
    private void aliPay(Intent data) {
        String amount = data.getStringExtra("amount");
        String traceNo = data.getStringExtra("traceNo");
        String batchNo = data.getStringExtra("batchNo");
        String time = data.getStringExtra("time");
        String date = data.getStringExtra("date");
        String terminalId = data.getStringExtra("terminalId");
        String merchantId = data.getStringExtra("merchantId");
        String merchantName = data.getStringExtra("merchantName");
        String orderNo = data.getStringExtra("orderNo");
        AliPayInfo aliPayInfo = new AliPayInfo();
        aliPayInfo.setAmount(ddje);
        aliPayInfo.setTraceNo(traceNo);
        aliPayInfo.setBatchNo(batchNo);
        aliPayInfo.setTime(time);
        aliPayInfo.setDate(date);
        aliPayInfo.setTerminalId(terminalId);
        aliPayInfo.setMerchantId(merchantId);
        aliPayInfo.setMerchantName(merchantName);
        aliPayInfo.setOrderNo(orderNo);
//        Log.e("---amount--", amount + "");
//        Log.e("---traceNo --", traceNo + "");
//        Log.e("---type  --", type + "");
//        Log.e("---batchNo --", batchNo + "");
//        Log.e("---time --", time + "");
//        Log.e("---date --", date+"");
//        Log.e("---terminalId --",  terminalId+ "");
//        Log.e("---merchantId --",  merchantId+ "");
//        Log.e("---merchantName --",  merchantName+ "");
        PayRequest request = new PayRequest();
        request.setDdbh(ddbh);
        request.setPayResult("1");
        request.setPayType("0");
        request.setAliPayInfo(aliPayInfo);
        //回调接口
        orderPay(request);
    }

    //pos机支付
    private void posPay(Intent data) {
        String amount = data.getStringExtra("amount");
        String traceNo = data.getStringExtra("traceNo");
        String referenceNo = data.getStringExtra("referenceNo");
        String cardNo = data.getStringExtra("cardNo");
        String type = data.getStringExtra("type");
        String issue = data.getStringExtra("issue");
        String batchNo = data.getStringExtra("batchNo");
        String time = data.getStringExtra("time");
        String date = data.getStringExtra("date");
        String terminalId = data.getStringExtra("terminalId");
        String merchantId = data.getStringExtra("merchantId");
        String merchantName = data.getStringExtra("merchantName");
        String authCode = data.getStringExtra("authCode");
        PosPayInfo posInfo = new PosPayInfo();
        posInfo.setAmount(ddje);
        posInfo.setTraceNo(traceNo);
        posInfo.setReferenceNo(referenceNo);
        posInfo.setCardNo(cardNo);
        posInfo.setType(type);
        posInfo.setIssue(issue);
        posInfo.setBatchNo(batchNo);
        posInfo.setTime(time);
        posInfo.setDate(date);
        posInfo.setTerminalId(terminalId);
        posInfo.setMerchantId(merchantId);
        posInfo.setMerchantName(merchantName);
        posInfo.setAuthCode(authCode);
        PayRequest request = new PayRequest();
        request.setDdbh(ddbh);
        request.setPayResult("1");
        request.setPayType("0");
        request.setPosPayInfo(posInfo);
        //回调接口
        orderPay(request);
//        Log.e("---amount--", amount + "");
//        Log.e("---traceNo --", traceNo + "");
//        Log.e("---authCode --", authCode + "");
//        Log.e("---referenceNo --", referenceNo + "");
//        Log.e("---cardNo --", cardNo + "");
//        Log.e("---type  --", type + "");
//        Log.e("---issue   --", issue + "");
//        Log.e("---batchNo --", batchNo + "");
//        Log.e("---time --", time + "");
//        Log.e("---date --", date+"");
//        Log.e("---terminalId --",  terminalId+ "");
//        Log.e("---merchantId --",  merchantId+ "");
//        Log.e("---merchantName --",  merchantName+ "");
    }

    //订单支付接口
    private void orderPay(PayRequest request) {
        PayModel model = new PayModel();
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
}
