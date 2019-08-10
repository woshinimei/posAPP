package com.example.onedream.flightapp.fragment.orderDetail;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.onedream.flightapp.R;
import com.example.onedream.flightapp.base.BaseFragment;
import com.example.onedream.flightapp.bean.HbInfo;
import com.example.onedream.flightapp.bean.JbInfo;
import com.example.onedream.flightapp.bean.PassengerInfo;
import com.example.onedream.flightapp.constant.OrderType;
import com.example.onedream.flightapp.response.OrderDetailResponse;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OrderDetailBaseFragment extends BaseFragment {
    @BindView(R.id.tv_order_no)
    TextView tvOrderNo;
    @BindView(R.id.tv_order_status)
    TextView tvOrderStatus;
    @BindView(R.id.tv_order_time)
    TextView tvOrderTime;
    @BindView(R.id.ll_hb)
    LinearLayout llHb;
    @BindView(R.id.ll_passenger)
    LinearLayout llPassenger;
    @BindView(R.id.ll_lianxi)
    LinearLayout llLianxi;
    String orderNo;

    @Override
    public int getlayout() {
        return R.layout.fragment_order_detail_base;
    }

    @Override
    public void initView() {
        orderNo = getActivity().getIntent().getStringExtra(OrderType.ORDER_NO);
    }

    public void refreshData(OrderDetailResponse response) {
        if (response.isSuccess()) {
            //基本信息
            JbInfo jbxx = response.getJbxx();
            if (jbxx != null) {
                //订单信息
                tvOrderNo.setText(orderNo + "");
                tvOrderStatus.setText(jbxx.getDdzt() + "");
                //联系人信息
                llLianxi.removeAllViews();
                View view = View.inflate(getActivity(), R.layout.item_base_contact_view, null);
                LxViewHolder holder = new LxViewHolder(view);
                holder.tvName.setText(jbxx.getLxrxm() + "");
                holder.tvPhone.setText(jbxx.getLxrdh() + "");
                llLianxi.addView(view);
            }
            //添加航班列表
            List<HbInfo> hdjh = response.getHdjh();
            if (hdjh != null && hdjh.size() > 0) {
                llHb.removeAllViews();
                for (HbInfo bean : hdjh) {
                    View view = View.inflate(getActivity(), R.layout.item_base_airtravel_view, null);
                    HbViewHolder holder = new HbViewHolder(view);
                    holder.tvHkName.setText(bean.getHkgs() + "");
                    holder.tvHkhbh.setText(bean.getHbh() + "");
                    holder.tvTimeStart.setText(bean.getCfsj() + "");
                    holder.tvTimeEnd.setText(bean.getDdsj() + "");
                    holder.tvStartAdress.setText(bean.getCfjc()+"");
                    holder.tvEndAdress.setText(bean.getDdjc()+"");
                            llHb.addView(view);
                }
            }
            //添加乘机人列表
            List<PassengerInfo> cjrjh = response.getCjrjh();
            if (cjrjh != null) {
                llPassenger.removeAllViews();
                for (PassengerInfo bean : cjrjh) {
                    View view = View.inflate(getActivity(), R.layout.item_base_passenger_view, null);
                    PasengerViewHolder holder = new PasengerViewHolder(view);
                    holder.tvName.setText(bean.getCjrxm());
                    holder.tvIdcard.setText(bean.getZjhm());
                    holder.tvType.setText(bean.getCjrlx());
                    holder.tvPhone.setText(bean.getCjrsj());
                    llPassenger.addView(view);
                }
            }


        }
    }


    //根据航空二字码获取对应航空公司图标
    private void setHkImg() {
//        String twozima = ticketListingInfo.getAwy();
//        String xiaoxie = twozima.toLowerCase();
//        String iconame = "air_line_"+xiaoxie;
//        getResourceName(iconame);
    }

    /**
     * 获取图片名称获取图片的资源id的方法
     *
     * @param imageName
     * @return
     */
    public int getResourceName(String imageName) {
        int resId;
        try {
            resId = getResources().getIdentifier(imageName.toLowerCase(), "mipmap", getActivity().getPackageName());
        } catch (Exception e) {
            e.printStackTrace();
            resId = 0;
        }
        return resId;
    }


    static class HbViewHolder {
        @BindView(R.id.icon_hk)
        ImageView iconHk;
        @BindView(R.id.tv_hk_name)
        TextView tvHkName;
        @BindView(R.id.tv_hk_hbh)
        TextView tvHkhbh;
        @BindView(R.id.tv_start_time)
        TextView tvStartTime;
        @BindView(R.id.tv_time_start)
        TextView tvTimeStart;
        @BindView(R.id.tv_time_end)
        TextView tvTimeEnd;
        @BindView(R.id.tv_start_adress)
        TextView tvStartAdress;
        @BindView(R.id.tv_end_adress)
        TextView tvEndAdress;

        HbViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

    static class PasengerViewHolder {
        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.tv_type)
        TextView tvType;
        @BindView(R.id.tv_phone)
        TextView tvPhone;
        @BindView(R.id.tv_idcard)
        TextView tvIdcard;

        PasengerViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

    static class LxViewHolder {
        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.tv_phone)
        TextView tvPhone;

        LxViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
