package com.example.onedream.flightapp.fragment.orderlist;


import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


import com.example.onedream.flightapp.R;
import com.example.onedream.flightapp.adapter.OrderListAdapter;
import com.example.onedream.flightapp.base.BaseFragment;
import com.example.onedream.flightapp.bean.OrderListBean;
import com.example.onedream.flightapp.constant.OrderType;
import com.example.onedream.flightapp.intefaces.OnCallBack;
import com.example.onedream.flightapp.model.OrderListNormalModel;
import com.example.onedream.flightapp.request.OrderListRequest;
import com.example.onedream.flightapp.response.OrderListResponse;
import com.example.onedream.flightapp.utils.GsonUtils;
import com.example.onedream.flightapp.view.RecycleViewDivider;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


/**
 * 订单列表-----普通订单界面
 */
public class OrderListNormalFragment extends BaseFragment {
    @BindView(R.id.pull)
    SmartRefreshLayout pull;
    @BindView(R.id.recy)
    RecyclerView recyView;
    @BindView(R.id.tv_error)
    TextView tvError;
    OrderListAdapter adater;
    List<OrderListBean> list = new ArrayList<>();
    private boolean isFirst = true;
    private  int start =0;
    private int count =30;

    @Override
    public int getlayout() {
        return R.layout.fragment_orderlist_normal;
    }

    @Override
    public void initView() {
        Log.e("---initView----", "----");
        initAdater();
    }

    //初始化RecyclerView
    private void initAdater() {
        LinearLayoutManager manger = new LinearLayoutManager(getActivity());
        manger.setOrientation(LinearLayoutManager.VERTICAL);
        recyView.setLayoutManager(manger);
        initData(true);
        recyView.addItemDecoration(new RecycleViewDivider(getActivity(), LinearLayoutManager.VERTICAL, 10, getResources().getColor(R.color.colorGray)));
        adater = new OrderListAdapter(list, getActivity(), OrderType.NORMAL);
        recyView.setAdapter(adater);
        initPull();
    }

    private void initPull() {
        pull.setRefreshHeader(new ClassicsHeader(getActivity()));

        pull.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshLayout) {
                start =0;
                initData(true);
                adater.notifyDataSetChanged();
                pull.finishRefresh(300);//加载时间，必须加这句
            }
        });
        pull.setEnableLoadmore(true);
       pull.setOnLoadmoreListener(new OnLoadmoreListener() {
           @Override
           public void onLoadmore(RefreshLayout refreshlayout) {
               start+=count;
                initData(true);
               adater.notifyDataSetChanged();
               pull.finishLoadmore(300);
           }
       });

    }


    @Override
    public void lazyData() {
//        if (isFirst && (list == null || list.size() == 0)) {
//            initData(true);
//        }
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e("---onResume-----","-------");
        if (!isFirst) {
            initData(false);
        }else {
            initData(true);
        }
    }

    //获取数据
    public void initData(boolean showDialog) {
        isFirst = false;
        OrderListNormalModel model = new OrderListNormalModel();
        OrderListRequest request  = new OrderListRequest();
        Log.e("--start---",start+"----");
        request.setStart(start);
        request.setCount(count);
        model.getData(getActivity(), showDialog, request,new OnCallBack<String>() {
            @Override
            public void onSucess(String s) {
                if (getActivity()!=null&&!getActivity().isFinishing()) {
                    OrderListResponse response = GsonUtils.fromJson(s, OrderListResponse.class);
                    List<OrderListBean> orderInfoList = response.getOrderInfoList();
                    if (orderInfoList != null) {
                        tvError.setVisibility(View.GONE);
                        if (start==0) {
                            list.clear();
                        }
                        list.addAll(orderInfoList);
                        int size = list.size();
                        if (totalListener!=null){
                            totalListener.getNum(size);
                        }
                        adater.notifyDataSetChanged();
                    } else {
                        if (totalListener!=null){
                            totalListener.getNum(0);
                        }
                        tvError.setVisibility(View.VISIBLE);
                    }
                }
            }

            @Override
            public void onError(String msg) {
                if (getActivity()!=null&&!getActivity().isFinishing()) {
                    list.clear();
                    adater.notifyDataSetChanged();
                    if (totalListener!=null){
                        totalListener.getNum(0);
                    }
                    tvError.setVisibility(View.VISIBLE);
                }
                if (isShowFragment){
                    showToast(msg);
                }
            }
        });
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    //获取总数
    public interface OnTotalListener {
        void getNum(int total);
    }

    OnTotalListener totalListener;

    public OnTotalListener getTotalListener() {
        return totalListener;
    }

    public void setTotalListener(OnTotalListener totalListener) {
        this.totalListener = totalListener;
    }
}
