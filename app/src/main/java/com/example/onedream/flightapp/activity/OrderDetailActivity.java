package com.example.onedream.flightapp.activity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;

import com.example.onedream.flightapp.R;
import com.example.onedream.flightapp.adapter.DialogPriceDetailAdapter;
import com.example.onedream.flightapp.adapter.OrderDetailTopAdapter;
import com.example.onedream.flightapp.adapter.VpFragmentAdapter;
import com.example.onedream.flightapp.base.BaseActivity;
import com.example.onedream.flightapp.bean.PriceChildInfo;
import com.example.onedream.flightapp.bean.PriceGroupInfo;
import com.example.onedream.flightapp.bean.TopBarBean;
import com.example.onedream.flightapp.constant.OrderType;
import com.example.onedream.flightapp.fragment.orderDetail.OrderDetailApprovalFragment;
import com.example.onedream.flightapp.fragment.orderDetail.OrderDetailBaseFragment;
import com.example.onedream.flightapp.fragment.orderDetail.OrderDetailDeliveryFragment;
import com.example.onedream.flightapp.fragment.orderDetail.OrderDetailTravelFragment;
import com.example.onedream.flightapp.intefaces.OnCallBack;
import com.example.onedream.flightapp.model.OrderDetailModel;
import com.example.onedream.flightapp.response.OrderDetailResponse;
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
    List<PriceGroupInfo> priceList = new ArrayList<>();
    String orderNo;
    OrderDetailBaseFragment baseFragment = new OrderDetailBaseFragment();
    OrderDetailDeliveryFragment deliveryFragment = new OrderDetailDeliveryFragment();
    OrderDetailTravelFragment travelFragment = new OrderDetailTravelFragment();
    OrderDetailApprovalFragment approvalFragment = new OrderDetailApprovalFragment();
    @Override
    public int getLayout() {
        return R.layout.activity_order_normal_detail;
    }

    @Override
    public void initView() {
        initTopView();
        initVp();
        initData();
    }

    private void initData() {
        Intent intent = getIntent();
        int type = intent.getIntExtra(OrderType.ORDER_TYPE, 0);
        orderNo = intent.getStringExtra(OrderType.ORDER_NO);
        OrderDetailModel model = new OrderDetailModel();
        model.getData(type, "", getActivity(), new OnCallBack<String>() {
            @Override
            public void onSucess(String s) {
                OrderDetailResponse response = GsonUtils.fromJson(s, OrderDetailResponse.class);
                baseFragment.refreshData(response);
                deliveryFragment.refreshData(response);
                travelFragment.refreshData(response);
                approvalFragment.refreshData(response);
            }

            @Override
            public void onError(String msg) {
                showToast(msg);
            }
        });
    }

    private void initVp() {
        List<Fragment> fragList = new ArrayList<>();
        fragList.clear();
        fragList.add(baseFragment);
        fragList.add(deliveryFragment);
        fragList.add(travelFragment);
        fragList.add(approvalFragment);
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
            case R.id.tv_pay:
                Intent payIntent = new Intent(getActivity(), PayTypeActivity.class);
                startActivity(payIntent);
                break;
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
        priceList.clear();
        PriceGroupInfo groupInfo = new PriceGroupInfo();
        groupInfo.setTitle("票价");
        groupInfo.setTotalPrice(1050);
        PriceChildInfo childInfo1 = new PriceChildInfo();
        childInfo1.setName("机建");
        childInfo1.setItemPrice(1030);
        PriceChildInfo childInfo2 = new PriceChildInfo();
        childInfo2.setName("优惠券");
        childInfo2.setItemPrice(20);
        List<PriceChildInfo> childList = new ArrayList<>();
        childList.add(childInfo1);
        childList.add(childInfo2);
        childList.add(childInfo2);
        childList.add(childInfo2);
        childList.add(childInfo2);
        groupInfo.setItemlist(childList);
        priceList.add(groupInfo);
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
