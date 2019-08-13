package com.example.onedream.flightapp.fragment.orderDetail;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.onedream.flightapp.R;
import com.example.onedream.flightapp.activity.WebActivity;
import com.example.onedream.flightapp.adapter.CouponAdater;
import com.example.onedream.flightapp.base.BaseFragment;
import com.example.onedream.flightapp.bean.CouponBean;
import com.example.onedream.flightapp.bean.HbInfo;
import com.example.onedream.flightapp.bean.JbInfo;
import com.example.onedream.flightapp.bean.OrderDetail;
import com.example.onedream.flightapp.bean.PassengerInfo;
import com.example.onedream.flightapp.bean.PayInfo;
import com.example.onedream.flightapp.constant.CacheData;
import com.example.onedream.flightapp.constant.OrderType;
import com.example.onedream.flightapp.utils.DisplayUtils;
import com.example.onedream.flightapp.utils.FlightUtils;
import com.example.onedream.flightapp.utils.OrderLogic;
import com.example.onedream.flightapp.utils.SetViewUtils;
import com.example.onedream.flightapp.utils.VeDate;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import org.apache.commons.lang.StringUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OrderDetailBaseFragment extends BaseFragment {
    @BindView(R.id.pull)
    SmartRefreshLayout pull;
    @BindView(R.id.tv_order_no)
    TextView tvOrderNo;
    @BindView(R.id.tv_order_status)
    TextView tvOrderStatus;
    @BindView(R.id.tv_order_time_str)
    TextView tvOrderTimeStr;
    @BindView(R.id.tv_order_time)
    TextView tvOrderTime;
    @BindView(R.id.ll_hb)
    LinearLayout llHb;
    @BindView(R.id.ll_passenger)
    LinearLayout llPassenger;
    @BindView(R.id.ll_lianxi)
    LinearLayout llLianxi;
    @BindView(R.id.ll_coupon)
    LinearLayout llCoupon;

    @BindView(R.id.tv_hc_title)
    TextView tvHcTitle;
    @BindView(R.id.tv_passenger_title)
    TextView tvPassengerTitle;
    @BindView(R.id.tv_concact_title)
    TextView tvConcactTitle;
    @BindView(R.id.tv_pay_info)
    TextView tvPayInfo;
    @BindView(R.id.ll_pay_info)
    LinearLayout llPayInfo;
    private String orderNo;
    private int type = 0;


    @Override
    public int getlayout() {
        return R.layout.fragment_order_detail_base;
    }

    @Override
    public void initView() {
        orderNo = getActivity().getIntent().getStringExtra(OrderType.ORDER_NO);
        type = getActivity().getIntent().getIntExtra(OrderType.ORDER_TYPE, 0);
        initPull();
    }

    @Override
    public void lazyData() {

    }

    private void initPull() {
        pull.setRefreshHeader(new ClassicsHeader(getActivity()));

        pull.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshLayout) {
                if (getDataListener() != null) {
                    getDataListener().getData();
                }
                pull.finishRefresh(500);//加载时间，必须加这句
            }
        });
    }

    public void refreshData(OrderDetail orderDetail) {

        //基本信息
        if (orderDetail != null) {
            JbInfo jbxx = orderDetail.getJbxx();
            if (jbxx != null) {
                //订单信息
                tvOrderNo.setText(orderNo + "");
                tvOrderStatus.setText(jbxx.getDdzt() + "|" + jbxx.getSpzt());
                if (type == 0) {
                    tvOrderTimeStr.setText("预定时间：");
                    tvOrderTime.setText(jbxx.getYdsj() + "");
                } else {
                    tvOrderTimeStr.setText("申请时间：");
                    tvOrderTime.setText(jbxx.getSqsj() + "");
                }
                //联系人信息
                llLianxi.removeAllViews();
                View view = View.inflate(getActivity(), R.layout.item_base_contact_view, null);
                LxViewHolder holder = new LxViewHolder(view);
                holder.tvName.setText(jbxx.getLxrxm() + "");
                holder.tvPhone.setText(jbxx.getLxrdh() + "");
                llLianxi.addView(view);
            }
            //添加航班列表
            List<HbInfo> hdjh = orderDetail.getHdjh();
            if (hdjh != null && hdjh.size() > 0) {
                tvHcTitle.setVisibility(View.VISIBLE);
                llHb.removeAllViews();
                for (HbInfo bean : hdjh) {
                    View view = View.inflate(getActivity(), R.layout.item_base_airtravel_view, null);
                    HbViewHolder holder = new HbViewHolder(view);
                    setLogo(holder.iconHk, bean.getHbh());
                    setDateWeek(holder.tvStartTimeWeek, bean.getCfsj());
                    setDateWeek(holder.tvEndTimeWeek, bean.getDdsj());
                    setHBTop(holder, bean);
                    holder.tvHkName.setText(bean.getHkgs() + "");
                    holder.tvHkhbh.setText(bean.getHbh() + "");
                    holder.tvTimeStart.setText(bean.getCfsj().split(" ")[1] + "");
                    holder.tvTimeEnd.setText(bean.getDdsj().split(" ")[1] + "");
                    holder.tvStartAdress.setText(bean.getCfcity() + bean.getCfjc() + bean.getCfhzl() + "");
                    holder.tvEndAdress.setText(bean.getDdcity() + bean.getDdjc() + bean.getDdhzl() + "");
                    llHb.addView(view);
                }
            } else {
                tvHcTitle.setVisibility(View.GONE);
            }
            //添加乘机人列表
            List<PassengerInfo> cjrjh = orderDetail.getCjrjh();
            if (cjrjh != null && cjrjh.size() > 0) {
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
            } else {
                tvPassengerTitle.setVisibility(View.GONE);
            }
            //添加支付信息
            List<PayInfo> zfxxjh = orderDetail.getZfxxjh();
            if (zfxxjh != null && zfxxjh.size() > 0) {
                llPayInfo.removeAllViews();
                tvPayInfo.setVisibility(View.VISIBLE);
                for (PayInfo bean : zfxxjh) {
                    View view = View.inflate(getActivity(), R.layout.item_pay_info, null);
                    PayViewHolder holder = new PayViewHolder(view);
                    holder.tvType.setText(bean.getZffs() + "");
                    holder.tvAmount.setText(bean.getZfje() + "");
                    holder.tvTime.setText(bean.getZfsj() + "");
                    llPayInfo.addView(view);
                }
            } else {
                tvPayInfo.setVisibility(View.GONE);
            }

            //添加礼包信息
            List<CouponBean> couponList = orderDetail.getCoupon();
            if (couponList != null && couponList.size() > 0) {
                llCoupon.removeAllViews();
                View view = View.inflate(getActivity(), R.layout.item_coupon_view, null);
                CouponViewHolder holder = new CouponViewHolder(view);
                CouponBean bean = couponList.get(0);
                String couponPackageName = bean.getCouponPackageName();
                if (!TextUtils.isEmpty(couponPackageName)) {
                   holder.tvTitle.setText(couponPackageName);
                }
                holder.llTitle.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        CouponBean bean = couponList.get(0);
                        String url = bean.getCouponPackageInfoUrl();
                        Intent intent = new Intent(getActivity(), WebActivity.class);
                        intent.putExtra("url", url);
                        intent.putExtra("name",bean.getCouponPackageName()+"");
                        startActivity(intent);
                    }
                });
                LinearLayoutManager manager = new LinearLayoutManager(getActivity());
                manager.setOrientation(LinearLayoutManager.HORIZONTAL);
                holder.recyview.setLayoutManager(manager);
                int widthPixels = getActivity().getResources().getDisplayMetrics().widthPixels - DisplayUtils.dip2px(getActivity(), 20);
                CouponAdater actAdater = new CouponAdater(getActivity(), couponList, widthPixels);
                holder.recyview.setAdapter(actAdater);
                llCoupon.addView(view);
            }
        }

    }

    private void setHBTop(HbViewHolder holder, HbInfo bean) {
        String cwbh = bean.getCwbh();
        if (!TextUtils.isEmpty(cwbh)) {
            holder.tvCang.setVisibility(View.VISIBLE);
            SetViewUtils.setView(holder.tvCang, cwbh + "舱");
        } else {
            holder.tvCang.setVisibility(View.GONE);
        }
        String jx = TextUtils.isEmpty(bean.getJx()) ? "" : bean.getJx();
        SetViewUtils.setView(holder.tvJx,
                "机型：" + jx);
    }

    private void setDateWeek(TextView tvStartTime, String cfsj) {
        SetViewUtils.setView(tvStartTime,
                FlightUtils.getInstance().formatDateShwo(cfsj.split(" ")[0], CacheData.formattime, false, true, false, false));
    }

    private void setStartTime(TextView tvStartTime, String cfsj) {
        try {
            SetViewUtils.setView(tvStartTime,
                    VeDate.getYear(cfsj.substring(0, 4))
                            + "年");
        } catch (Exception ption) {

        }
    }

    //设置航班logo
    private void setLogo(ImageView iconHk, String hbh) {
        if (StringUtils.isNotBlank(hbh)) {
            String airstr = hbh.replace("*", "")
                    .substring(0, 2);
            String xiaoxie = airstr.toLowerCase();
            SetViewUtils.set_img_icon_flight(getActivity(), iconHk, xiaoxie);  //航空公司图片设置
        }
    }


    static class HbViewHolder {
        @BindView(R.id.icon_hk)
        ImageView iconHk;
        @BindView(R.id.tv_hk_name)
        TextView tvHkName;
        @BindView(R.id.tv_hk_hbh)
        TextView tvHkhbh;
        @BindView(R.id.tv_start_time_week)
        TextView tvStartTimeWeek;
        @BindView(R.id.tv_end_time_week)
        TextView tvEndTimeWeek;
        @BindView(R.id.tv_time_start)
        TextView tvTimeStart;
        @BindView(R.id.tv_time_end)
        TextView tvTimeEnd;
        @BindView(R.id.tv_start_adress)
        TextView tvStartAdress;
        @BindView(R.id.tv_end_adress)
        TextView tvEndAdress;
        @BindView(R.id.tv_hk_jx)
        TextView tvJx;
        @BindView(R.id.tv_hk_chang)
        TextView tvCang;

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

    static class PayViewHolder {
        @BindView(R.id.tv_type)
        TextView tvType;
        @BindView(R.id.tv_amount)
        TextView tvAmount;
        @BindView(R.id.tv_time)
        TextView tvTime;

        PayViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

    static class CouponViewHolder {
        @BindView(R.id.tv_head_title)
        TextView tvHeadTitle;
        @BindView(R.id.iv_up)
        ImageView ivUp;
        @BindView(R.id.ll_top)
        LinearLayout llTop;
        @BindView(R.id.tv_title)
        TextView tvTitle;
        @BindView(R.id.iv_img)
        ImageView ivImg;
        @BindView(R.id.ll_title)
        LinearLayout llTitle;
        @BindView(R.id.recyview)
        RecyclerView recyview;
        @BindView(R.id.ll_bottom)
        LinearLayout llBottom;
        @BindView(R.id.ll_content)
        LinearLayout llContent;

        CouponViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
