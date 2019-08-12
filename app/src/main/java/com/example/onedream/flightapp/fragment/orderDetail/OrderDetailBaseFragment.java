package com.example.onedream.flightapp.fragment.orderDetail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.example.onedream.flightapp.utils.OrderLogic;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

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
    @BindView(R.id.tv_hc_title)
    TextView tvHcTitle;
    @BindView(R.id.tv_passenger_title)
    TextView tvPassengerTitle;
    @BindView(R.id.tv_concact_title)
    TextView tvConcactTitle;


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
            if (response.getDetail() != null) {
                JbInfo jbxx = response.getDetail().getJbxx();
                if (jbxx != null) {
                    //订单信息
                    tvOrderNo.setText(orderNo + "");
                    tvOrderStatus.setText(jbxx.getDdzt() + "|" + jbxx.getSpzt());
                    tvOrderTime.setText(jbxx.getYdsj() + "");
                    //联系人信息
                    llLianxi.removeAllViews();
                    View view = View.inflate(getActivity(), R.layout.item_base_contact_view, null);
                    LxViewHolder holder = new LxViewHolder(view);
                    holder.tvName.setText(jbxx.getLxrxm() + "");
                    holder.tvPhone.setText(jbxx.getLxrdh() + "");
                    llLianxi.addView(view);
                }
                //添加航班列表
                List<HbInfo> hdjh = response.getDetail().getHdjh();
                if (hdjh != null && hdjh.size() > 0) {
                    tvHcTitle.setVisibility(View.VISIBLE);
                    llHb.removeAllViews();
                    for (HbInfo bean : hdjh) {
                        View view = View.inflate(getActivity(), R.layout.item_base_airtravel_view, null);
                        HbViewHolder holder = new HbViewHolder(view);
                        holder.tvHkName.setText(bean.getHkgs() + "");
                        holder.tvHkhbh.setText(bean.getHbh() + "");
                        holder.tvTimeStart.setText(bean.getCfsj().split(" ")[1] + "");
                        holder.tvTimeEnd.setText(bean.getDdsj().split(" ")[1] + "");
                        holder.tvStartAdress.setText(bean.getCfjc() + "");
                        holder.tvEndAdress.setText(bean.getDdjc() + "");
                        llHb.addView(view);
                    }
                }else {
                    tvHcTitle.setVisibility(View.GONE);
                }
                //添加乘机人列表
                List<PassengerInfo> cjrjh = response.getDetail().getCjrjh();
                if (cjrjh != null&&cjrjh.size()>0) {
                    tvPassengerTitle.setVisibility(View.VISIBLE);
                    llPassenger.removeAllViews();
                    for (PassengerInfo bean : cjrjh) {
                        View view = View.inflate(getActivity(), R.layout.item_base_passenger_view, null);
                        PasengerViewHolder holder = new PasengerViewHolder(view);
                        holder.tvName.setText(bean.getCjrxm());
                        String itp = bean.getZjlx();
                        String cardNameByCode = OrderLogic.getCardNameByCode(itp);
                        holder.tvIdType.setText(cardNameByCode);
                        holder.tvIdcard.setText(bean.getZjhm());
                        String cjrlx = bean.getCjrlx();
                        String cjrlxName = "";
                        if ("1".equals(cjrlx)) {
                            cjrlxName = "成人";
                        } else if ("2".equals(cjrlx)) {
                            cjrlxName = "儿童";
                        } else if ("3".equals(cjrlx)) {
                            cjrlxName = "婴儿";
                        }
                        holder.tvType.setText(cjrlxName);
                        holder.tvPhone.setText(bean.getCjrsj());
                        llPassenger.addView(view);

                    }
                }else {
                    tvPassengerTitle.setVisibility(View.GONE);
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
        @BindView(R.id.tv_idtype)
        TextView tvIdType;
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
