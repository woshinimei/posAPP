package com.example.onedream.flightapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.onedream.flightapp.R;
import com.example.onedream.flightapp.adapter.VpFragmentAdapter;
import com.example.onedream.flightapp.base.BaseActivity;
import com.example.onedream.flightapp.constant.OrderType;
import com.example.onedream.flightapp.fragment.orderlist.OrderListEndoreFragment;
import com.example.onedream.flightapp.fragment.orderlist.OrderListNormalFragment;
import com.example.onedream.flightapp.fragment.orderlist.OrderListRefundFragment;
import com.example.onedream.flightapp.request.OrderListRequest;
import com.example.onedream.flightapp.view.MyPopWindow;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class OrderListActivity extends BaseActivity {
    private static final int SEARCHCODE = 10;
    @BindView(R.id.line)
    View line;
    @BindView(R.id.rg)
    RadioGroup rg;
    @BindView(R.id.rb1)
    RadioButton rb1;
    @BindView(R.id.rb2)
    RadioButton rb2;
    @BindView(R.id.rb3)
    RadioButton rb3;
    @BindView(R.id.vp)
    ViewPager vp;
    @BindView(R.id.tv_menu)
    TextView tvMenu;
    VpFragmentAdapter vpAdater;
    List<Fragment> fragList = new ArrayList<>();
    OrderListNormalFragment normalFragment = new OrderListNormalFragment();
    OrderListRefundFragment refundFragment = new OrderListRefundFragment();
    OrderListEndoreFragment endoreFragment = new OrderListEndoreFragment();
    private int type =0;
    @Override
    public int getLayout() {
        return R.layout.activity_hb_order_list;
    }

    @Override
    public void initView() {
        initFragment();
    }

    //初始化vpAdater
    private void initFragment() {
        fragList.add(normalFragment);
        fragList.add(refundFragment);
        fragList.add(endoreFragment);
        vpAdater = new VpFragmentAdapter(getSupportFragmentManager(), fragList);
        vp.setAdapter(vpAdater);
        vp.setCurrentItem(0);
        vp.setOffscreenPageLimit(3);
        rg.check(rg.getChildAt(0).getId());
        initLine();
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
                int leftMargin = (int) (width * (i + v));
                LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) line.getLayoutParams();
                params.leftMargin = leftMargin;
                line.setLayoutParams(params);
            }

            @Override
            public void onPageSelected(int i) {
                rg.check(rg.getChildAt(i).getId());
                type =i;
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb1:
                        vp.setCurrentItem(0);
                        break;
                    case R.id.rb2:
                        vp.setCurrentItem(1);
                        break;
                    case R.id.rb3:
                        vp.setCurrentItem(2);
                        break;
                }
            }
        });
        normalFragment.setTotalListener(new OrderListNormalFragment.OnTotalListener() {
            @Override
            public void getNum(int total) {
                if (rb1!=null) {
                    rb1.setText("普通订单（" + total + ")");
                }
            }
        });
        refundFragment.setTotalListener(new OrderListNormalFragment.OnTotalListener() {
            @Override
            public void getNum(int total) {
                if (rb2!=null){
                    rb2.setText("退票订单（"+total+")");
                }
            }
        });
        endoreFragment.setTotalListener(new OrderListNormalFragment.OnTotalListener() {
            @Override
            public void getNum(int total) {
                if (rb3!=null){
                    rb3.setText("改期订单（"+total+")");
                }
            }
        });
    }

    //初始化下划线
    int width = 0;

    private void initLine() {
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) line.getLayoutParams();
        int widthPixels = getResources().getDisplayMetrics().widthPixels;
        width = widthPixels / fragList.size();
        params.width = width;
        line.setLayoutParams(params);
    }


    @OnClick({R.id.tv_menu, R.id.tv_filter})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_menu:
                showMenuDialog();
                break;
            case R.id.tv_filter:
                Intent intent = new Intent(getActivity(), FilterTicketActivity.class);
                intent.putExtra(OrderType.ORDER_TYPE,type);
                startActivityForResult(intent, SEARCHCODE);
                break;

        }
    }
    MyPopWindow pop;
    //弹出退出选项
    private void showMenuDialog() {
        if (pop==null){
            pop= new MyPopWindow();
            View view = View.inflate(getActivity(),R.layout.pop_menu_view,null);
            TextView tvBackLogin =view.findViewById(R.id.tv_back_login);
            tvBackLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(getActivity(),LoginActivity.class));
                    finish();
                }
            });
            pop.setContentView(view);
            pop.showAsDropDown(tvMenu);

        }else {
            if (pop.isShowing()){
                pop.dismiss();
            }else {
                pop.showAsDropDown(tvMenu);
            }
        }

    }

    @Override
    protected void onStop() {
        super.onStop();
        if (pop!=null&&pop.isShowing()){
            pop.dismiss();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == SEARCHCODE && resultCode == RESULT_OK) {
            int currentItem = vp.getCurrentItem();
            Log.e("-currentItem--",currentItem+"");
            if (currentItem == 0) {
                normalFragment.initData(true);
            } else if (currentItem == 1) {
                refundFragment.initData(true);
            } else {
                endoreFragment.initData(true);
            }
        }
    }
}
