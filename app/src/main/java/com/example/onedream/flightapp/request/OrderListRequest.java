package com.example.onedream.flightapp.request;

import com.example.onedream.flightapp.network.BaseRequest;

public class OrderListRequest extends BaseRequest {
    private String userKey;//用户唯一标识(必填)
    private String sign;//签名(必填)
    private String name;//乘客姓名
    private String dateType;//日期类型
    private String dateStart;//日期始 格式：yyyy-MM-dd
    private String dateEnd;//日期止  格式：yyyy-MM-dd
    private String orderStatus;//订单状态

    public String getUserKey() {
        return userKey;
    }

    public void setUserKey(String userKey) {
        this.userKey = userKey;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateType() {
        return dateType;
    }

    public void setDateType(String dateType) {
        this.dateType = dateType;
    }

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
}
