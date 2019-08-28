package com.example.onedream.flightapp.fragment.orderDetail;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
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
import com.example.onedream.flightapp.utils.MyTextUtil;
import com.example.onedream.flightapp.utils.OrderLogic;
import com.example.onedream.flightapp.utils.SetViewUtils;
import com.example.onedream.flightapp.view.CouponView;
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
    @BindView(R.id.tv_si)
    TextView tvSi;
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
    @BindView(R.id.tv_error)
    TextView tvError;
    @BindView(R.id.scrollView)
    ScrollView scrollView;
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

            }
        });
    }

    public void refreshData(OrderDetail orderDetail, String status) {
        //基本信息
        if (orderDetail != null) {
            scrollView.setVisibility(View.VISIBLE);
            tvError.setVisibility(View.GONE);
            JbInfo jbxx = orderDetail.getJbxx();
            if (jbxx != null) {
                //订单信息
                tvOrderNo.setText(orderNo + "");
                StringBuilder orderStatus = new StringBuilder();

                if (!TextUtils.isEmpty(status)) {
                    if (type != 1 && status.equals("2")) {
                        orderStatus.append("已调度");
                        orderStatus.append(" | ");
                    }
                    if (type == 1 && status.equals("3")) {
                        orderStatus.append("已调度");
                        orderStatus.append(" | ");
                    }
                }
                if (!TextUtils.isEmpty(jbxx.getDdzt())) {
                    orderStatus.append(jbxx.getDdzt());
                }
                if (!TextUtils.isEmpty(jbxx.getDdzt()) && !TextUtils.isEmpty(jbxx.getSpzt())) {
                    orderStatus.append(" | ");
                }
                if (!TextUtils.isEmpty(jbxx.getSpzt())) {
                    orderStatus.append(jbxx.getSpzt());
                }
                tvOrderStatus.setText(orderStatus);
                String cllx = MyTextUtil.clearNullText(jbxx.getCllx());
                if (cllx.equals("1")) {
                    tvSi.setText("因公");
                } else if (cllx.equals("2")) {
                    tvSi.setText("因私");
                }
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

                for (int i = 0; i < hdjh.size(); i++) {
                    HbInfo bean = hdjh.get(i);
                    View view = View.inflate(getActivity(), R.layout.item_base_airtravel_view, null);
                    HbViewHolder holder = new HbViewHolder(view);
                    setLogo(holder.iconHk, bean.getHbh());
                    setDateWeek(holder.tvStartTimeWeek, bean.getCfsj());
                    setDateWeek(holder.tvEndTimeWeek, bean.getDdsj());
                    setHBTop(holder, bean);
                    String nextDay = bean.getNextDay();
                    if (!TextUtils.isEmpty(nextDay) && nextDay.equals("1")) {
                        holder.tvNextDay.setVisibility(View.VISIBLE);
                    } else {
                        holder.tvNextDay.setVisibility(View.GONE);
                    }
                    holder.tvHkName.setText(MyTextUtil.clearNullText(bean.getHsjc()) + "");
                    holder.tvHkhbh.setText(bean.getHbh() + "");
                    holder.tvTimeStart.setText(bean.getCfsj().split(" ")[1] + "");
                    holder.tvTimeEnd.setText(bean.getDdsj().split(" ")[1] + "");

//                    holder.tvStartAdress.setText(MyTextUtil.clearNullText(bean.getCfcity()) + MyTextUtil.clearNullText(bean.getCfjc()) + MyTextUtil.clearNullText(bean.getCfhzl()));
                    holder.tvStartAdress.setText(MyTextUtil.clearNullText(bean.getCfcity(), bean.getCfjc(), bean.getCfhzl()));
//                    holder.tvEndAdress.setText(MyTextUtil.clearNullText(bean.getDdcity()) + MyTextUtil.clearNullText(bean.getDdjc()) + MyTextUtil.clearNullText(bean.getDdhzl()));
                    holder.tvEndAdress.setText(MyTextUtil.clearNullText(bean.getDdcity(), bean.getDdjc(), bean.getDdhzl()));
                    llHb.addView(view);
                    if (type != 0) {//改签单和退票单的情况调用
                        View couponView = CouponView.addCouponDetailView(getActivity(), orderDetail, i);
                        if (couponView != null) {
                            llHb.addView(couponView);
                        }
                    }
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


                    String cjrlx = bean.getCjrlx();
                    String cjrlxName = "";
                    if ("1".equals(cjrlx)) {
                        cjrlxName = "成人";
                    } else if ("2".equals(cjrlx)) {
                        cjrlxName = "儿童";
                    } else if ("3".equals(cjrlx)) {
                        cjrlxName = "婴儿";
                    }
                    String itp = bean.getZjlx();
                    String cardNameByCode = OrderLogic.getCardNameByCode(itp);
                    holder.tvIdType.setText(cardNameByCode);
                    holder.tvIdcard.setText(bean.getZjhm());
                    if (cjrlx.equals("3")) {
                        holder.tvIdcard.setVisibility(View.GONE);
                        holder.tvIdType.setVisibility(View.GONE);
                    } else {
                        holder.tvIdcard.setVisibility(View.VISIBLE);
                        holder.tvIdType.setVisibility(View.VISIBLE);
                    }
                    holder.tvType.setText(cjrlxName);
                    holder.tvPhone.setText(bean.getCjrsj());
                    if (type!=2){
                        String ph = bean.getPh();
                        if (!TextUtils.isEmpty(ph)){
                            holder.llPh.setVisibility(View.VISIBLE);
                            holder.tvPhNo.setText(ph+"");
                        }else {
                            holder.llPh.setVisibility(View.GONE);
                        }
                    }else {
                        String ph = bean.getYph();
                        if (!TextUtils.isEmpty(ph)){
                            holder.llPh.setVisibility(View.VISIBLE);
                            holder.tvPhNo.setText(ph+"");
                        }else {
                            holder.llPh.setVisibility(View.GONE);
                        }
                    }

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
                    holder.tvType.setText(MyTextUtil.clearNullText(bean.getZffs()));
                    holder.tvAmount.setText("¥" + MyTextUtil.clearNullText(bean.getZfje()));
                    holder.tvTime.setText(MyTextUtil.clearNullText(bean.getZfsj()));
                    llPayInfo.addView(view);
                }
            } else {
                tvPayInfo.setVisibility(View.GONE);
            }

            //添加礼包信息
            if (type == 0) {//其他情况在航班信息添加礼包
                addCouponView(orderDetail);
            }

        } else {
            if (getActivity() != null && !getActivity().isFinishing()) {
                scrollView.setVisibility(View.GONE);
                tvError.setVisibility(View.VISIBLE);
            }
            Log.e("OrderDetailBase--", "--orderdeail   null--");
        }
        if (getActivity() != null) {
            pull.finishRefresh(100);//加载时间，必须加这句
        }
    }


    //礼包信息(普通订单)
    private void addCouponView(OrderDetail orderDetail) {
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
                    intent.putExtra("name", bean.getCouponPackageName() + "");
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
        @BindView(R.id.tv_nextday)
        TextView tvNextDay;

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
        @BindView(R.id.ll_ph)
        LinearLayout llPh;
        @BindView(R.id.tv_ph_no)
        TextView tvPhNo;
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
