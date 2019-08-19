package com.example.onedream.flightapp.activity;

import android.content.Intent;
import android.os.Bundle;
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
    @BindView(R.id.tv_cl_type)
    TextView tvClType;
    OrderListRequest request;
    String startTime ="";
    String endTime ="";
    @Override
    public int getLayout() {
        return R.layout.acitivity_filter_ticket;
    }

    @Override
    public void initView() {
        initCalendar();
        initFirstShow();
    }

    private void initFirstShow() {
        if (AppLocal.listRequest!=null){

        }
        tvDateStart.setText(startTime);
        tvDateEnd.setText(endTime);
        edName.setText("");
        tvClType.setText("不限");
        tvOrderStatus.setText("全部");
        tvDateType.setText("调度日期");
        request = new OrderListRequest();
        request.setDateStart(startTime);
        request.setDateEnd(endTime);
    }

    @Override
    protected void onStop() {
        super.onStop();

    }

    @OnClick({R.id.tv_back, R.id.tv_reset, R.id.tv_date_type, R.id.tv_date_start, R.id.tv_date_end, R.id.tv_order_status, R.id.tv_cl_type, R.id.btn_search})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_back:
                finish();
                break;
            case R.id.tv_reset:
                initFirstShow();
                break;
            case R.id.tv_date_type:
                initDateType();
                break;
            case R.id.tv_date_start:
                showDatePicker("开始日期", "0",new OnChoiceListener() {
                    @Override
                    public void onOption(String content) {
                        Log.e("-开始日期--",content+"");
                        request.setDateStart(content);
                        tvDateStart.setText(content);
                    }
                });
                break;
            case R.id.tv_date_end:
                showDatePicker("截止日期","1", new OnChoiceListener() {
                    @Override
                    public void onOption(String content) {
                        Log.e("-截止日期--",content+"");
                        request.setDateEnd(content);
                        tvDateEnd.setText(content);
                    }
                });
                break;
            case R.id.tv_order_status:
                initStatus();
                break;
            case R.id.tv_cl_type:
                initAllType();
                break;
            case R.id.btn_search:
                doSearch();

                break;
        }
    }

    private void doSearch() {
        AppLocal.listRequest =request;
        Intent intent = getIntent();
        setResult(RESULT_OK,intent);
        finish();
    }

    /*
    1:调度日期
    2:预订日期
    3：起飞日期
    * */
    private void initDateType() {
        List<String> strList = new ArrayList<>();
        strList.clear();
        strList.add("调度日期");
        strList.add("预订日期");
        strList.add("起飞日期");
        showOptionDialog("日期类型选择", strList, new OnChoiceListener() {
            @Override
            public void onOption(String content) {
                request.setDateType(content);
                tvDateType.setText(content);
            }
        });
    }

    private void initAllType() {
        List<String> strList = new ArrayList<>();
        strList.add("不限");
        strList.add("因公");
        strList.add("因私");
        showOptionDialog("差旅类型选择", strList, new OnChoiceListener() {
            @Override
            public void onOption(String content) {
                tvClType.setText(content);
            }
        });
    }

    /*
    * 0：申请中
    1：已订座
    2：已调度
    3：已出票
    4：配送中
    5：部分出票
    7：客户消
    8：已取消
    9：完成
    * */
    private void initStatus() {
        List<String> strList = new ArrayList<>();
        strList.clear();
        strList.add("全部");
        strList.add("申请中");
        strList.add("已订座");
        strList.add("已调度");
        strList.add("已出票");
        strList.add("配送中");
        strList.add("部分出票");
        strList.add("客户消");
        strList.add("已取消");
        strList.add("完成");
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
    private void showDatePicker(String title,String type,OnChoiceListener listener) {

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
        if (type.equals("1")) {
            picker.setSelectedItem(year, month, day);
        }else {
            picker.setSelectedItem(lyear, lmonth, lday);
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
        SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd");
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH) + 1;
        day = c.get(Calendar.DAY_OF_MONTH);
        endTime = format.format(c.getTime());
        //获取一个月后时间
        c.add(Calendar.MONTH,-1);
        lyear  = c.get(Calendar.YEAR);
        lmonth = c.get(Calendar.MONTH) + 1;
        lday = c.get(Calendar.DAY_OF_MONTH);



        startTime =format.format(c.getTime());
        Log.e("--当前时间--",startTime);
        Log.e("--一个月前--",endTime);
    }

}
