package com.example.onedream.flightapp.activity;

import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.onedream.flightapp.R;
import com.example.onedream.flightapp.base.BaseActivity;
import com.example.onedream.flightapp.constant.AppLocal;
import com.example.onedream.flightapp.constant.OrderType;
import com.example.onedream.flightapp.intefaces.OnChoiceListener;
import com.example.onedream.flightapp.request.OrderListRequest;
import com.example.onedream.flightapp.utils.MyTextUtil;
import com.example.onedream.flightapp.utils.OrderListFliterUtils;
import com.example.onedream.flightapp.utils.VeDate;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import cn.qqtheme.framework.picker.DatePicker;
import cn.qqtheme.framework.picker.OptionPicker;

public class FilterTicketActivity extends BaseActivity {
    @BindView(R.id.ed_name)
    EditText edName;
    @BindView(R.id.tv_date_type)
    TextView tvDateType;
    @BindView(R.id.tv_date_start)
    TextView tvDateStart;
    @BindView(R.id.tv_date_end)
    TextView tvDateEnd;
    @BindView(R.id.tv_order_status)
    TextView tvOrderStatus;
    @BindView(R.id.tv_pay_status)
    TextView tvPayStatus;
    @BindView(R.id.tv_pay_text)
    TextView tvPayText;
    //    @BindView(R.id.tv_cl_type)
//    TextView tvClType;
    OrderListRequest request = new OrderListRequest();
    String startTime = "";
    String endTime = "";
    private int type = 0;

    @Override
    public int getLayout() {
        return R.layout.acitivity_filter_ticket;
    }

    @Override
    public void initView() {
        type = getIntent().getIntExtra(OrderType.ORDER_TYPE, 0);//订单类型
        initCalendar();
        initFilter();
    }

    private void initFilter() {
        Log.e("-----type---", type + "");
        if (type == 0) {
            OrderListRequest normalRequest = AppLocal.normalRequest;
            setFirstRequest(normalRequest);
        } else if (type == 1) {
            OrderListRequest refundRequest = AppLocal.refundRequest;
            setFirstRequest(refundRequest);
        } else {
            OrderListRequest endoreRequest = AppLocal.endoreRequest;
            setFirstRequest(endoreRequest);
        }
    }

    private void setFirstRequest(OrderListRequest baseRequest) {
        if (baseRequest == null) {
            baseRequest = new OrderListRequest();
            OrderListFliterUtils.setTimeforRequest(baseRequest);
            if (type==1){
                OrderListFliterUtils.setRufundRequest(baseRequest);
            }else {
                OrderListFliterUtils.setNormalRequest(baseRequest);
            }
        }
        tvDateStart.setText(baseRequest.getDateStart());
        tvDateEnd.setText(baseRequest.getDateEnd());
        if (!TextUtils.isEmpty(baseRequest.getName())) {
            edName.setText(baseRequest.getName());
        }else {
            edName.setText("");
        }
        if (TextUtils.isEmpty(baseRequest.getOrderStatus())) {
            tvOrderStatus.setText("全部");
        } else {
            tvOrderStatus.setText(baseRequest.getOrderStatus());
        }

        if (TextUtils.isEmpty(baseRequest.getDateType())) {
            if (type == 1) {
                tvDateType.setText("办理日期");
            } else {
                tvDateType.setText("预订日期");
            }

        } else {
            tvDateType.setText(baseRequest.getDateType());
        }

        if (type==1){
            tvPayText.setText("退款状态");
            if (TextUtils.isEmpty(baseRequest.getTkzt())){
                tvPayStatus.setText("未退");
            }else {
                tvPayStatus.setText(baseRequest.getTkzt());
            }
        }else {
            tvPayText.setText("支付状态");
            if (TextUtils.isEmpty(baseRequest.getZfzt())){
                tvPayStatus.setText("未付");
            }else {
                tvPayStatus.setText(baseRequest.getZfzt());
            }
        }

        setBaseRequest(baseRequest);
    }

    private void setBaseRequest(OrderListRequest baseRequest) {
        if (baseRequest!=null){
            request.setTkzt(baseRequest.getTkzt());
            request.setZfzt(baseRequest.getZfzt());
            request.setStart(baseRequest.getStart());
            request.setCount(baseRequest.getCount());
            request.setDateType(baseRequest.getDateType());
            request.setOrderStatus(baseRequest.getOrderStatus());
            request.setName(baseRequest.getName());
            request.setDateStart(baseRequest.getDateStart());
            request.setDateEnd(baseRequest.getDateEnd());
            request.setSign(baseRequest.getSign());
            request.setUserKey(baseRequest.getUserKey());
        }
    }


    @Override
    protected void onStop() {
        super.onStop();

    }

    @OnClick({R.id.tv_back, R.id.tv_reset, R.id.tv_date_type, R.id.tv_date_start, R.id.tv_date_end,
            R.id.tv_order_status, R.id.tv_cl_type, R.id.btn_search,R.id.tv_pay_status})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_back:
                finish();
                break;
            case R.id.tv_reset:
                resetData();
                break;
            case R.id.tv_date_type:
                initDateType();
                break;
            case R.id.tv_date_start:
                showDatePicker("开始日期", "0", new OnChoiceListener() {
                    @Override
                    public void onOption(String content) {
                        Log.e("-开始日期--", content + "");
                        request.setDateStart(content);
                        tvDateStart.setText(content);
                    }
                });
                break;
            case R.id.tv_date_end:
                showDatePicker("截止日期", "1", new OnChoiceListener() {
                    @Override
                    public void onOption(String content) {
                        Log.e("-截止日期--", content + "");
                        request.setDateEnd(content);
                        tvDateEnd.setText(content);
                    }
                });
                break;
            case R.id.tv_order_status:
                initStatus();
                break;
            case R.id.tv_pay_status:
                initPayStatus();
                break;
            case R.id.tv_cl_type:
//                initAllType();
                break;
            case R.id.btn_search:
                String chooseStartTime = tvDateStart.getText().toString();
                String chooseEndTime = tvDateEnd.getText().toString();
                if (checkDate(chooseStartTime, chooseEndTime)) {
                    doSearch();
                }
                break;
        }
    }
    //支付状态
    private void initPayStatus() {
        List<String> strList = new ArrayList<>();
        if (type==1){
            strList.clear();
            String[] refundStatus = AppLocal.refundStatus;
            for (String s : refundStatus) {
                strList.add(s);
            }
            showOptionDialog("退款状态选择", strList, new OnChoiceListener() {
                @Override
                public void onOption(String content) {
                    tvPayStatus.setText(content);
                    request.setTkzt(content);
                }
            });
        }else {
            strList.clear();
            String[] payStatus = AppLocal.payStatus;
            for (String s : payStatus) {
                strList.add(s);
            }
            showOptionDialog("支付状态选择", strList, new OnChoiceListener() {
                @Override
                public void onOption(String content) {
                    tvPayStatus.setText(content);
                    request.setZfzt(content);
                }
            });
        }
    }

    private void resetData() {
        OrderListFliterUtils.resetData(type);
        initFilter();
    }

    private void doSearch() {
        String name = edName.getText().toString();
        if (!TextUtils.isEmpty(name)) {
            if (request != null) {
                String s = MyTextUtil.replaceBlank(name);
                request.setName(s);
            }
        } else {
            if (request != null) {
                request.setName("");
            }
        }

        if (type == 0) {
            AppLocal.normalRequest = request;
        } else if (type == 1) {
            AppLocal.refundRequest = request;
        } else {
            AppLocal.endoreRequest = request;
        }
        Intent intent = getIntent();
        setResult(RESULT_OK, intent);
        finish();
    }

    /**
     * 校验起始日期不能大于结束日期
     *
     * @return
     */
    public boolean checkDate(String chooseStartDay, String chooseEndDay) {
        long days = VeDate.getDays(chooseStartDay, chooseEndDay);
        if (days > 0) {
            showToast("起始日期不能大于截止日期！");
            return false;
        }
        return true;
    }

    /*
    1:调度日期
    2:预订日期
    3：起飞日期
    * */
    private void initDateType() {
        List<String> strList = new ArrayList<>();
        strList.clear();
        if (type == 1) {
            String[] orderTimeStatusOfRefund = AppLocal.orderTimeStatusOfRefund;
            for (String s : orderTimeStatusOfRefund) {
                strList.add(s);
            }
        } else {
            String[] orderTimeStatus = AppLocal.orderTimeStatus;
            for (String s : orderTimeStatus) {
                strList.add(s);
            }
        }

        showOptionDialog("日期类型选择", strList, new OnChoiceListener() {
            @Override
            public void onOption(String content) {
                request.setDateType(content);
                tvDateType.setText(content);
            }
        });
    }

//    private void initAllType() {
//        List<String> strList = new ArrayList<>();
//        strList.add("不限");
//        strList.add("因公");
//        strList.add("因私");
//        showOptionDialog("差旅类型选择", strList, new OnChoiceListener() {
//            @Override
//            public void onOption(String content) {
//                tvClType.setText(content);
//            }
//        });
//    }


    private void initStatus() {
        List<String> strList = new ArrayList<>();
        strList.clear();
        if (type==0){
            String[] orderStatus = AppLocal.orderStatus;
            for (String s : orderStatus) {
                strList.add(s);
            }
        }else if (type==1){
            String[] orderStatus = AppLocal.orderStatusOfRefund;
            for (String s : orderStatus) {
                strList.add(s);
            }
        }else {
            String[] orderStatus = AppLocal.orderStatusOfEndore;
            for (String s : orderStatus) {
                strList.add(s);
            }
        }


        showOptionDialog("订单状态选择", strList, new OnChoiceListener() {
            @Override
            public void onOption(String content) {
                request.setOrderStatus(content);
                tvOrderStatus.setText(content);
            }
        });
    }


    private void showOptionDialog(String title, List<String> data, OnChoiceListener listener) {
        OptionPicker optionPicker = new OptionPicker(this, data);
        optionPicker.setSelectedIndex(0);
        optionPicker.setTextColor(getResources().getColor(R.color.colorT3));
        optionPicker.setDividerColor(getResources().getColor(R.color.colorLine));
        View view = View.inflate(getActivity(), R.layout.picker_view, null);
        TextView tvSure = view.findViewById(R.id.tv_sure);
        TextView tvCancel = view.findViewById(R.id.tv_cancel);
        TextView tvTitle = view.findViewById(R.id.tv_title);
        tvTitle.setText(title);
        optionPicker.setHeaderView(view);
        optionPicker.show();
        tvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                optionPicker.dismiss();
            }
        });
        tvSure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                optionPicker.dismiss();
                String selectedItem = optionPicker.getSelectedItem();
                listener.onOption(selectedItem);
            }
        });
    }

    //展示日期选择器
    private void showDatePicker(String title, String type, OnChoiceListener listener) {

        DatePicker picker = new DatePicker(getActivity(), DatePicker.YEAR_MONTH_DAY);
        View view = View.inflate(getActivity(), R.layout.picker_view, null);
        TextView tvSure = view.findViewById(R.id.tv_sure);
        TextView tvCancel = view.findViewById(R.id.tv_cancel);
        TextView tvTitle = view.findViewById(R.id.tv_title);
        tvTitle.setText(title);
        picker.setHeaderView(view);
        picker.setRangeStart(year - 1, 1, 1);
        picker.setRangeEnd(year + 1, 12, 30);
        picker.setTextColor(getResources().getColor(R.color.colorT3));
        picker.setDividerColor(getResources().getColor(R.color.colorLine));
        picker.setTextSize(30);
        picker.setSelectedItem(year, month, day);
//        if (type.equals("1")) {
//            picker.setSelectedItem(year, month, day);
//        } else {
//            picker.setSelectedItem(lyear, lmonth, lday);
//        }

        if (request != null) {
            if (type.equals("0")) {
                String dateStart = request.getDateStart();
                if (!TextUtils.isEmpty(dateStart)) {
                    try {
                        String year = dateStart.substring(0, dateStart.indexOf("-"));
                        String month = dateStart.substring(dateStart.indexOf("-") + 1, dateStart.lastIndexOf("-"));
                        String day = dateStart.substring(dateStart.lastIndexOf("-") + 1);
                        if (!TextUtils.isEmpty(year)) {
                            Integer y = Integer.valueOf(year);
                            Integer m = Integer.valueOf(month);
                            Integer d = Integer.valueOf(day);
                            picker.setSelectedItem(y, m, d);
                        }
                    } catch (Exception e) {
                        Log.e("------Exception-----", e.toString() + "");
                    }

                }
            } else {
                String dateEnd = request.getDateEnd();
                if (!TextUtils.isEmpty(dateEnd)) {
                    try {
                        String year = dateEnd.substring(0, dateEnd.indexOf("-"));
                        String month = dateEnd.substring(dateEnd.indexOf("-") + 1, dateEnd.lastIndexOf("-"));
                        String day = dateEnd.substring(dateEnd.lastIndexOf("-") + 1);
                        if (!TextUtils.isEmpty(year)) {
                            Integer y = Integer.valueOf(year);
                            Integer m = Integer.valueOf(month);
                            Integer d = Integer.valueOf(day);
                            picker.setSelectedItem(y, m, d);
                        }
                    } catch (Exception e) {
                        Log.e("------Exception-----", e.toString() + "");
                    }

                }
            }


        }

        tvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                picker.dismiss();
            }
        });
        tvSure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                picker.dismiss();
                String selectedYear = picker.getSelectedYear();
                String selectedMonth = picker.getSelectedMonth();
                String selectedDay = picker.getSelectedDay();
                String date = selectedYear + "-" + selectedMonth + "-" + selectedDay;
                Log.e("-----", date);
                listener.onOption(date);
            }
        });
        picker.show();
    }

    //获取当前时间
    Calendar c;
    int year;
    int month;
    int day;
    //一个月后
    int lyear;
    int lmonth;
    int lday;

    private void initCalendar() {
        c = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH) + 1;
        day = c.get(Calendar.DAY_OF_MONTH);
        endTime = format.format(c.getTime());
        //获取一个月后时间
        c.add(Calendar.MONTH, -1);
        lyear = c.get(Calendar.YEAR);
        lmonth = c.get(Calendar.MONTH) + 1;
        lday = c.get(Calendar.DAY_OF_MONTH);


        startTime = format.format(c.getTime());
        Log.e("--当前时间--", startTime);
        Log.e("--一个月前--", endTime);
    }

}
