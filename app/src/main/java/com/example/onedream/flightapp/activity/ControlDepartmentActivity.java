package com.example.onedream.flightapp.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.onedream.flightapp.R;
import com.example.onedream.flightapp.adapter.ControlCompanyAdapter;
import com.example.onedream.flightapp.base.BaseActivity;
import com.example.onedream.flightapp.bean.ControlBean;
import com.example.onedream.flightapp.constant.OrderType;
import com.example.onedream.flightapp.intefaces.OnCallBack;
import com.example.onedream.flightapp.model.ControlCompanyModel;
import com.example.onedream.flightapp.response.ControlCompanyResponse;
import com.example.onedream.flightapp.utils.GsonUtils;
import com.example.onedream.flightapp.view.RecycleViewDivider;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 调度部门一览
 */
public class ControlDepartmentActivity extends BaseActivity {

    @BindView(R.id.tv_back)
    TextView tvBack;
    @BindView(R.id.rl_top)
    RelativeLayout rlTop;
    @BindView(R.id.recy)
    RecyclerView recy;
    @BindView(R.id.pull)
    SmartRefreshLayout pull;
    String orderNo;
    List<ControlBean> list = new ArrayList<>();
    ControlCompanyAdapter adapter;

    @Override
    public int getLayout() {
        return R.layout.activity_control_department_list;
    }

    @Override
    public void initView() {
        orderNo = getIntent().getStringExtra(OrderType.ORDER_NO);
        initAdapter();
        initPull();

    }

    private void initAdapter() {
        if (adapter == null) {
            LinearLayoutManager manager = new LinearLayoutManager(getActivity());
            manager.setOrientation(LinearLayoutManager.VERTICAL);
            recy.addItemDecoration(new RecycleViewDivider(getActivity(), LinearLayoutManager.VERTICAL, 1, getResources().getColor(R.color.colorLine)));
            recy.setLayoutManager(manager);
            adapter = new ControlCompanyAdapter(list, getActivity());
            recy.setAdapter(adapter);
        }
    }

    private void initPull() {
        pull.setRefreshHeader(new ClassicsHeader(getActivity()));

        pull.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshLayout) {
                initData();
//                adater.notifyDataSetChanged();
                pull.finishRefresh(1000);//加载时间，必须加这句
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

    //初始化数据
    private void initData() {
        ControlCompanyModel model = new ControlCompanyModel();
        model.getData(getActivity(), new OnCallBack<String>() {
            @Override
            public void onSucess(String s) {
                ControlCompanyResponse response = GsonUtils.fromJson(s, ControlCompanyResponse.class);
                List<ControlBean> deptInfoList = response.getDeptInfoList();
                if (deptInfoList != null) {
                    list.clear();
                    list.addAll(deptInfoList);
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onError(String msg) {
                showToast(msg);
            }
        });
    }

    @OnClick(R.id.tv_back)
    public void onViewClicked() {
        finish();
    }


}
