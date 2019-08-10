package com.example.onedream.flightapp.activity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

import com.example.onedream.flightapp.R;
import com.example.onedream.flightapp.adapter.VpFragmentAdapter;
import com.example.onedream.flightapp.base.BaseActivity;
import com.example.onedream.flightapp.fragment.orderlist.OrderListEndoreFragment;
import com.example.onedream.flightapp.fragment.orderlist.OrderListNormalFragment;
import com.example.onedream.flightapp.fragment.orderlist.OrderListRefundFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class OrderListActivity extends BaseActivity {
    @BindView(R.id.line)
    View line;
    @BindView(R.id.rg)
    RadioGroup rg;
    @BindView(R.id.vp)
    ViewPager vp;
    VpFragmentAdapter vpAdater;
    List<Fragment> fragList= new ArrayList<>();
    OrderListNormalFragment normalFragment = new OrderListNormalFragment();
    OrderListRefundFragment refundFragment = new OrderListRefundFragment();
    OrderListEndoreFragment endoreFragment = new OrderListEndoreFragment();

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
        vpAdater = new VpFragmentAdapter(getSupportFragmentManager(),fragList);
        vp.setAdapter(vpAdater);
        vp.setCurrentItem(0);
        vp.setOffscreenPageLimit(3);
        rg.check(rg.getChildAt(0).getId());
        initLine();
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
                int leftMargin = (int) (width*(i+v));
                LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) line.getLayoutParams();
                params.leftMargin =leftMargin;
                line.setLayoutParams(params);
            }

            @Override
            public void onPageSelected(int i) {
                    rg.check(rg.getChildAt(i).getId());
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
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
    }
    //初始化下划线
    int width=0;
    private void initLine() {
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) line.getLayoutParams();
        int widthPixels = getResources().getDisplayMetrics().widthPixels;
         width = widthPixels / fragList.size();
        params.width =width;
        line.setLayoutParams(params);
    }


    @OnClick({R.id.tv_back,R.id.tv_filter})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_back:
                finish();
                break;
            case R.id.tv_filter:
                startActivity(new Intent(getActivity(),FilterTicketActivity.class));
                break;

        }
    }
}
