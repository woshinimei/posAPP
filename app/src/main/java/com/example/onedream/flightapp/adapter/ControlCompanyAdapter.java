package com.example.onedream.flightapp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.onedream.flightapp.R;
import com.example.onedream.flightapp.bean.ControlBean;
import com.example.onedream.flightapp.intefaces.OnCallBack;
import com.example.onedream.flightapp.model.ControlModel;
import com.example.onedream.flightapp.request.ControlRequest;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ControlCompanyAdapter extends RecyclerView.Adapter<ControlCompanyAdapter.ViewHolder> {
    List<ControlBean> list;
    Context context;
    private  int type=0;
    private String orderNo ="";
    public ControlCompanyAdapter(List<ControlBean> list, Context context,int type,String orderNo) {
        this.list = list;
        this.context = context;
        this.type  = type;
        this.orderNo = orderNo;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_control_company_view, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        ControlBean bean = list.get(i);
        viewHolder.tvCompany.setText(setNullText(bean.getGs()));
        viewHolder.tvMc.setText(setNullText(bean.getMc()));
        viewHolder.tvLxr.setText( setNullText(bean.getLxr()));
        viewHolder.tvBh.setText( setNullText(bean.getBh()));
        viewHolder.tvControl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setControlRequest(bean);
            }
        });
    }

    //开始调度
    private void setControlRequest(ControlBean bean) {
        String mc = bean.getMc();
        String gs = bean.getGs();
        ControlModel model = new ControlModel();
        ControlRequest request = new ControlRequest();
        request.setDdbh(orderNo);
        request.setDsDept(mc);
        request.setDsComp(gs);
        model.getData(context, type, request, new OnCallBack<String>() {
            @Override
            public void onSucess(String s) {

            }

            @Override
            public void onError(String msg) {
                Toast.makeText(context,msg,Toast.LENGTH_SHORT).show();
            }
        });
    }

    public String setNullText(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        } else {
            return str;
        }
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }


    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_control)
        TextView tvControl;
        @BindView(R.id.tv_bh)
        TextView tvBh;
        @BindView(R.id.tv_company)
        TextView tvCompany;
        @BindView(R.id.tv_mc)
        TextView tvMc;
        @BindView(R.id.tv_lxr)
        TextView tvLxr;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }


}
