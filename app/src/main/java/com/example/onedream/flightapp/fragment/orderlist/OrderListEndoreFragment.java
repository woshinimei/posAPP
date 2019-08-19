package com.example.onedream.flightapp.fragment.orderlist;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.onedream.flightapp.R;
import com.example.onedream.flightapp.adapter.OrderListAdapter;
import com.example.onedream.flightapp.base.BaseFragment;
import com.example.onedream.flightapp.bean.OrderListBean;
import com.example.onedream.flightapp.constant.OrderType;
import com.example.onedream.flightapp.intefaces.OnCallBack;
import com.example.onedream.flightapp.model.OrderListEndoreModel;
import com.example.onedream.flightapp.model.OrderListRefundModel;
import com.example.onedream.flightapp.response.OrderListResponse;
import com.example.onedream.flightapp.utils.GsonUtils;
import com.example.onedream.flightapp.view.RecycleViewDivider;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


/**
 *   订单列表-----改期订单界面
 * */
public class OrderListEndoreFragment extends BaseFragment {
    @BindView(R.id.pull)
    SmartRefreshLayout pull;
    @BindView(R.id.recy)
    RecyclerView recyView;
    @BindView(R.id.tv_error)
    TextView tvError;
    OrderListAdapter adater;
    List<OrderListBean> list = new ArrayList<>();
    boolean isFirst =true;
    @Override
    public int getlayout() {
        return R.layout.fragment_orderlist_endore;
    }

    @Override
    public void initView() {
        initAdater();
    }
    //初始化RecyclerView
    private void initAdater() {
        LinearLayoutManager manger = new LinearLayoutManager(getActivity());
        manger.setOrientation(LinearLayoutManager.VERTICAL);
        recyView.setLayoutManager(manger);
        recyView.addItemDecoration(new RecycleViewDivider(getActivity(),LinearLayoutManager.VERTICAL,10,getResources().getColor(R.color.colorGray)));
        adater = new OrderListAdapter(list,getActivity(),OrderType.ENDORE);
        recyView.setAdapter(adater);
        initPull();
    }

    private void initPull() {
        pull.setRefreshHeader(new ClassicsHeader(getActivity()));

        pull.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshLayout) {
                initData(true);
                pull.finishRefresh(300);//加载时间，必须加这句
            }
        });
//        pull.setEnableLoadmore(false);
//       pull.setOnLoadmoreListener(new OnLoadmoreListener() {
//           @Override
//           public void onLoadmore(RefreshLayout refreshlayout) {
//
//               adater.notifyDataSetChanged();
//               pull.finishLoadmore(1000);
//           }
//       });

    }


    @Override
    public void lazyData() {
        if (isFirst&&(list==null||list.size()==0)){
            initData(true);
        }
    }


    //获取数据
    public void initData(boolean showDialog) {
        isFirst =false;
        OrderListEndoreModel model = new OrderListEndoreModel();
        model.getData(getActivity(),showDialog, new OnCallBack<String>() {
            @Override
            public void onSucess(String s) {
                if (!getActivity().isFinishing()) {
                    OrderListResponse response = GsonUtils.fromJson(s, OrderListResponse.class);
                    List<OrderListBean> orderInfoList = response.getOrderInfoList();
                    if (orderInfoList != null) {
                        tvError.setVisibility(View.GONE);
                        list.clear();
                        list.addAll(orderInfoList);
                        if (totalListener!=null){
                            totalListener.getNum(list.size());
                        }
                        adater.notifyDataSetChanged();
                    }else {
                        tvError.setVisibility(View.VISIBLE);
                    }
                }
            }

            @Override
            public void onError(String msg) {
                if (!getActivity().isFinishing()) {
                    list.clear();
                    adater.notifyDataSetChanged();
                    tvError.setVisibility(View.VISIBLE);
                }
                showToast(msg);
            }
        });
    }
    //获取总数
    public interface OnTotalListener {
        void getNum(int total);
    }

    OrderListNormalFragment.OnTotalListener totalListener;

    public OrderListNormalFragment.OnTotalListener getTotalListener() {
        return totalListener;
    }

    public void setTotalListener(OrderListNormalFragment.OnTotalListener totalListener) {
        this.totalListener = totalListener;
    }
}
