package com.example.onedream.flightapp.fragment.orderDetail;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.onedream.flightapp.R;
import com.example.onedream.flightapp.base.BaseFragment;
import com.example.onedream.flightapp.bean.DeliveryAndInvoiceInfo;
import com.example.onedream.flightapp.bean.OrderDetail;
import com.example.onedream.flightapp.bean.TravelInfo;
import com.example.onedream.flightapp.response.OrderDetailResponse;
import com.example.onedream.flightapp.utils.ComomLogic;
import com.example.onedream.flightapp.utils.SetViewUtils;

import org.apache.commons.lang.StringUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
/**
 * 订单详情配送信息Fragment
 * 使用场景：
 *  订单详情界面
 */
public class OrderDetailDeliveryFragment extends BaseFragment {
    @BindView(R.id.order_detail_distribution_fragment_rise)
    TextView rise;
    @BindView(R.id.order_detail_distribution_fragment_first_distribution_lly)
    LinearLayout first_distribution_lly;
    @BindView(R.id.order_detail_distribution_fragment_first_split_view)
    View first_split_view;
    @BindView(R.id.order_detail_distribution_fragment_type)
    TextView type;
    @BindView(R.id.order_detail_distribution_fragment_first_type_lly)
    LinearLayout first_type_lly;
    @BindView(R.id.order_detail_distribution_fragment_info)
    TextView info;
    @BindView(R.id.order_detail_distribution_fragment_first_lly)
    LinearLayout first_lly;
    @BindView(R.id.order_detail_distribution_fragment_identification)
    TextView identification;
    @BindView(R.id.order_detail_distribution_fragment_distribution_model)
    TextView distribution_model;
    @BindView(R.id.order_detail_distribution_fragment_recipients)
    TextView recipients;
    @BindView(R.id.order_detail_distribution_fragment_phone)
    TextView phone;
    @BindView(R.id.order_detail_distribution_fragment_address)
    TextView address;
    @BindView(R.id.order_detail_distribution_fragment_price)
    TextView price;
    @BindView(R.id.order_detail_distribution_invoice_layout)
    LinearLayout orderDetailDistributionInvoiceLayout;
    @BindView(R.id.order_detail_distribution_fragment_send_company_tv)
    TextView orderDetailDistributionFragmentSendCompanyTv;
    @BindView(R.id.order_detail_distribution_fragment_send_companynum_tv)
    TextView orderDetailDistributionFragmentSendCompanynumTv;
    @BindView(R.id.order_detail_distribution_fragment_send_address_tv)
    TextView orderDetailDistributionFragmentSendAddressTv;
    @BindView(R.id.order_detail_distribution_fragment_send_tel_tv)
    TextView orderDetailDistributionFragmentSendTelTv;
    @BindView(R.id.order_detail_distribution_fragment_pf)
    LinearLayout orderDetailDistributionFragmentPf;
    @BindView(R.id.order_detail_distribution_fragment_distribution_back_company_tv)
    TextView orderDetailDistributionFragmentDistributionBackCompanyTv;
    @BindView(R.id.order_detail_distribution_fragment_distribution_back_num_tv)
    TextView orderDetailDistributionFragmentDistributionBackNumTv;
    @BindView(R.id.order_detail_distribution_fragment_distribution_back_drress_tv)
    TextView orderDetailDistributionFragmentDistributionBackDrressTv;
    @BindView(R.id.order_detail_distribution_fragment_distribution_back_tel_tv)
    TextView orderDetailDistributionFragmentDistributionBackTelTv;
    @BindView(R.id.order_detail_distribution_fragment_distribution_goback_layout)
    LinearLayout orderDetailDistributionFragmentDistributionGobackLayout;
//    @BindView(R.id.tv_type)
//    TextView tvType;
//    @BindView(R.id.tv_get_name)
//    TextView tvGetName;
//    @BindView(R.id.tv_phone)
//    TextView tvPhone;
//    @BindView(R.id.tv_adress)
//    TextView tvAdress;
//    @BindView(R.id.tv_send_count)
//    TextView tvSendCount;
//    @BindView(R.id.tv_company)
//    TextView tvCompany;
//    @BindView(R.id.tr_type)
//    TableRow trType;
//    @BindView(R.id.line_type)
//    View lineType;
//    @BindView(R.id.tr_company)
//    TableRow trCompany;
//    @BindView(R.id.line_company)
//    View lineCompany;
//    @BindView(R.id.tr_get_name)
//    TableRow trGetName;
//    @BindView(R.id.line_get_name)
//    View lineGetName;
//    @BindView(R.id.tr_phone)
//    TableRow trPhone;
//    @BindView(R.id.line_phone)
//    View linePhone;
//    @BindView(R.id.tr_adress)
//    TableRow trAdress;
//    @BindView(R.id.line_adress)
//    View lineAdress;
//    @BindView(R.id.tr_send_count)
//    TableRow trSendCount;
//    ;


    @Override
    public int getlayout() {
        return R.layout.fragment_order_detail_delivery;
    }

    @Override
    public void initView() {

    }

    public void refreshData(OrderDetail detail) {
            if (detail != null) {
                DeliveryAndInvoiceInfo distribution = detail.getFppsxx();
                if(null!=distribution){
                    SetViewUtils.setVisible(first_distribution_lly,StringUtils.isNotBlank(distribution.getFptt()));
                    SetViewUtils.setView(rise,distribution.getFptt());
                    StringBuilder fplxmc=new StringBuilder();
                    if("1".equals(distribution.getFplx())){
                        fplxmc.append("公司");
                    }else if("2".equals(distribution.getFplx())){
                        fplxmc.append("个人");
                    }else {
                        fplxmc.append(StringUtils.isNotBlank(distribution.getFplx())?distribution.getFplx():"");
                    }
                    SetViewUtils.setVisible(first_type_lly,StringUtils.isNotBlank(fplxmc.toString()));
                    SetViewUtils.setVisible(first_split_view,StringUtils.isNotBlank(distribution.getFptt())&&StringUtils.isNotBlank(fplxmc.toString()));
                    SetViewUtils.setVisible(first_lly,StringUtils.isNotBlank(distribution.getFptt())||StringUtils.isNotBlank(fplxmc.toString()));
                    SetViewUtils.setView(type,fplxmc.toString());
                    SetViewUtils.setView(info,distribution.getFpmx());
                    SetViewUtils.setView(identification,distribution.getNsrsbh());
                    SetViewUtils.setView(recipients,distribution.getSjr());
                    SetViewUtils.setView(address,distribution.getSjdz());
                    SetViewUtils.setView(phone,distribution.getSjrdh());
                    SetViewUtils.setView(distribution_model,distribution.getPsfs());
                    if(StringUtils.isNotBlank(distribution.getYjpsf())){
                        SetViewUtils.setView(price,"¥"+distribution.getYjpsf());
                    }
                }
//                if (info != null) {
//                    if (!MyTextUtil.isEmpty(info.getSjr())) {
//                        tvGetName.setText(info.getSjr() + "");
//                    } else {
//                        trGetName.setVisibility(View.GONE);
//                        lineGetName.setVisibility(View.GONE);
//                    }
//
//                    if (!MyTextUtil.isEmpty(info.getSjdz())) {
//                        tvAdress.setText(info.getSjdz() + "");
//                    } else {
//                        trAdress.setVisibility(View.GONE);
//                        lineAdress.setVisibility(View.GONE);
//                    }
//                    if (!MyTextUtil.isEmpty(info.getSjrdh())) {
//                        tvPhone.setText(info.getSjrdh() + "");
//                    } else {
//                        trPhone.setVisibility(View.GONE);
//                        linePhone.setVisibility(View.GONE);
//                    }
//
//                    if (!MyTextUtil.isEmpty(info.getPsfs())) {
//                        tvType.setText(info.getPsfs() + "");
//                    } else {
//                        trType.setVisibility(View.GONE);
//                        lineType.setVisibility(View.GONE);
//                    }
//                    if (!MyTextUtil.isEmpty(info.getKd())) {
//                        tvCompany.setText(info.getKd() + "");
//                    } else {
//                        trCompany.setVisibility(View.GONE);
//                        lineCompany.setVisibility(View.GONE);
//                    }
//                    if (!MyTextUtil.isEmpty(info.getYjpsf())) {
//                        tvSendCount.setText(info.getYjpsf() + "");
//                    } else {
//                        trSendCount.setVisibility(View.GONE);
//                    }
//
//                }
            }

    }

    @Override
    public void lazyData() {

    }
}
