package com.example.onedream.flightapp.activity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.onedream.flightapp.R;
import com.example.onedream.flightapp.adapter.DialogPriceDetailAdapter;
import com.example.onedream.flightapp.adapter.OrderDetailTopAdapter;
import com.example.onedream.flightapp.adapter.VpFragmentAdapter;
import com.example.onedream.flightapp.base.BaseActivity;
import com.example.onedream.flightapp.bean.FlightPayInfo;
import com.example.onedream.flightapp.bean.FlightTicketDetailPrice;
import com.example.onedream.flightapp.bean.JbInfo;
import com.example.onedream.flightapp.bean.OrderDetail;
import com.example.onedream.flightapp.bean.PriceItem;
import com.example.onedream.flightapp.bean.PriceInfo;
import com.example.onedream.flightapp.bean.TopBarBean;
import com.example.onedream.flightapp.constant.OrderType;
import com.example.onedream.flightapp.fragment.orderDetail.OrderDetailApprovalFragment;
import com.example.onedream.flightapp.fragment.orderDetail.OrderDetailBaseFragment;
import com.example.onedream.flightapp.fragment.orderDetail.OrderDetailDeliveryFragment;
import com.example.onedream.flightapp.fragment.orderDetail.OrderDetailTravelFragment;
import com.example.onedream.flightapp.intefaces.OnCallBack;
import com.example.onedream.flightapp.model.OrderDetailModel;
import com.example.onedream.flightapp.model.RefundModel;
import com.example.onedream.flightapp.request.RefundRequest;
import com.example.onedream.flightapp.response.OrderDetailResponse;
import com.example.onedream.flightapp.response.RefundResponse;
import com.example.onedream.flightapp.utils.FlightComomLogic;
import com.example.onedream.flightapp.utils.GsonUtils;
import com.example.onedream.flightapp.view.MyDialog;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class OrderDetailActivity extends BaseActivity {
    @BindView(R.id.ll_content)
    LinearLayout llContent;
    @BindView(R.id.recy_top)
    RecyclerView recyTop;
    @BindView(R.id.vp)
    ViewPager vp;
    OrderDetailTopAdapter topAdater;
    VpFragmentAdapter vpAdater;
    List<TopBarBean> topList = new ArrayList<>();
    DialogPriceDetailAdapter priceAdapter;
    List<PriceInfo> priceList = new ArrayList<>();
    String orderNo;
    OrderDetailResponse response;//返回的接口数据
    OrderDetailBaseFragment baseFragment = new OrderDetailBaseFragment();
    OrderDetailDeliveryFragment deliveryFragment = new OrderDetailDeliveryFragment();
    OrderDetailTravelFragment travelFragment = new OrderDetailTravelFragment();
    OrderDetailApprovalFragment approvalFragment = new OrderDetailApprovalFragment();
    @BindView(R.id.tv_back)
    TextView tvBack;
    @BindView(R.id.tv_mingxi)
    TextView tvMingxi;
    @BindView(R.id.tv_cancel)
    TextView tvCancel;
    @BindView(R.id.tv_pay)
    TextView tvPay;
    @BindView(R.id.tv_ddje)
    TextView tvDdje;
    int type =0;
    @Override
    public int getLayout() {
        return R.layout.activity_order_normal_detail;
    }

    @Override
    public void initView() {
        Intent intent = getIntent();
        type = intent.getIntExtra(OrderType.ORDER_TYPE, 0);
        orderNo = intent.getStringExtra(OrderType.ORDER_NO);
        if (type==1){
            tvPay.setText("退款");
        }
        initTopView();
        initVp();
        initData();
    }

    private void initData() {

        OrderDetailModel model = new OrderDetailModel();

        model.getData(type, orderNo, getActivity(), new OnCallBack<String>() {
            @Override
            public void onSucess(String s) {
//                new Handler().postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
                        response = GsonUtils.fromJson(s, OrderDetailResponse.class);
                        baseFragment.refreshData(response);
                        deliveryFragment.refreshData(response);
                        travelFragment.refreshData(response);
                        approvalFragment.refreshData(response);
                        if (response.getDetail()!=null){
                            JbInfo jbxx = response.getDetail().getJbxx();
                            if (jbxx!=null){
                                String sfkzf = jbxx.getZfzt();//是否可支付
                                if (type!=1) {
                                    if (!TextUtils.isEmpty(sfkzf) && sfkzf.equals("未付")) {
                                        tvPay.setVisibility(View.VISIBLE);
                                    } else {
                                        tvPay.setVisibility(View.GONE);
                                    }
                                }
                            }
                        }
                        initBottomPrice();
                        initPriceDetail();
//                    }
//                },1000);

            }

            @Override
            public void onError(String msg) {
                showToast(msg);
            }
        });
    }



    //初始化底部价格数据
    private void initBottomPrice() {
        if (response != null && response.isSuccess()) {
            OrderDetail detail = response.getDetail();
            if (detail!=null) {
                JbInfo jbxx = detail.getJbxx();
                if (jbxx != null) {
                    String ddje = jbxx.getDdje();
                    tvDdje.setText(ddje + "");
                }
            }
        }
    }

    private void initVp() {
        List<Fragment> fragList = new ArrayList<>();
        fragList.clear();
        fragList.add(baseFragment);
        fragList.add(deliveryFragment);
        fragList.add(travelFragment);
        fragList.add(approvalFragment);
        vp.setOffscreenPageLimit(fragList.size());
        vpAdater = new VpFragmentAdapter(getSupportFragmentManager(), fragList);
        vp.setAdapter(vpAdater);
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                topAdater.setAllSelect(false);
                topList.get(i).setSelect(true);
                topAdater.notifyDataSetChanged();
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

    private void initTopView() {
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyTop.setLayoutManager(manager);
        topList.clear();
        topList.add(new TopBarBean("基本信息", true));
        topList.add(new TopBarBean("配送信息", false));
        topList.add(new TopBarBean("差旅信息", false));
        topList.add(new TopBarBean("审批信息", false));
        topAdater = new OrderDetailTopAdapter(topList, getActivity());
        recyTop.setAdapter(topAdater);
        topAdater.setListener(new OrderDetailTopAdapter.OnSelectListener() {
            @Override
            public void selectItem(int pisition) {
                vp.setCurrentItem(pisition);
            }
        });
    }


    @OnClick({R.id.tv_back, R.id.tv_mingxi, R.id.tv_cancel, R.id.tv_pay})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_back:
                finish();
                break;
            case R.id.tv_mingxi:
                showPopPriceDetail();
                break;
            case R.id.tv_cancel:
                showNoteDialog();
                break;
            case R.id.tv_control:
                Intent conIntent = new Intent(getActivity(),ControlDepartmentActivity.class);
                conIntent.putExtra(OrderType.ORDER_NO,orderNo);
                startActivity(conIntent);
                break;
            case R.id.tv_pay:
                if (type!=1){
                    Intent payIntent = new Intent(getActivity(), PayTypeActivity.class);
                    payIntent.putExtra(OrderType.ORDER_TYPE,type);
                    payIntent.putExtra(OrderType.ORDER_NO,orderNo);
                    if (response!=null&&response.getDetail()!=null){
                        FlightPayInfo payInfo = response.getDetail().getGjhcxx();
                        if (payInfo!=null){
                            String ddje = payInfo.getDdje();
                            payIntent.putExtra(OrderType.ORDER_AMOUNT,ddje);
                        }
                    }
                    startActivity(payIntent);
                }else {
                    doRefund();
                }

                break;
        }
    }

    //退废单退款
    private void doRefund() {
        RefundModel model = new RefundModel();
        RefundRequest request = new RefundRequest();
        request.setTkdh(orderNo);
        model.getData(getActivity(), request, new OnCallBack<String>() {
            @Override
            public void onSucess(String s) {
                RefundResponse response = GsonUtils.fromJson(s,RefundResponse.class);
                showToast(response.getMessage()+"");
            }

            @Override
            public void onError(String msg) {
                showToast(msg);
            }
        });
    }


    //初始化价格明细
    private void initPriceDetail() {
        if (response!=null&&response.getDetail()!=null){
            OrderDetail detail = response.getDetail();
            FlightTicketDetailPrice detailPrice = new FlightTicketDetailPrice();
            FlightComomLogic.initDetailPriceInfo(detailPrice,detail);
            ArrayList<PriceInfo> priceInfos = FlightComomLogic.getOrderDetailPriceDatas(detailPrice);
            if (priceInfos!=null&&priceInfos.size()>0){
                priceList.clear();
                priceList.addAll(priceInfos);
            }
        }
    }
    //展示明细
    MyDialog priceDialog;
    private void showPopPriceDetail() {
        View layout = View.inflate(getActivity(), R.layout.pop_price_detail, null);
        ExpandableListView exListView = layout.findViewById(R.id.elv_content);
        LinearLayout llContent = layout.findViewById(R.id.ll_content);
        initPriceAdapter(exListView);
        priceDialog = new MyDialog(getActivity(), layout);
        priceDialog.showFullScreen();
    }

    private void initPriceAdapter(ExpandableListView exListView) {

     priceAdapter = new DialogPriceDetailAdapter(priceList, getActivity());
        exListView.setAdapter(priceAdapter);
        for (int i = 0; i < priceAdapter.getGroupCount(); i++) {
            exListView.expandGroup(i);
        }
    }

    MyDialog dialog;

    private void showNoteDialog() {
        dialog = new MyDialog(getActivity());
        dialog.setContent("是否取消该订单?");
        dialog.setLeftButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.setRightButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.showPaddingScreen();
    }


    @Override
    protected void onStop() {
        super.onStop();
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
        if (priceDialog != null && priceDialog.isShowing()) {
            priceDialog.dismiss();
        }
    }


}
