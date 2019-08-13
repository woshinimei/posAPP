package com.example.onedream.flightapp.bean;

public class OrderListBean {

    /**
     * orderNo : 190808000049
     * issueResult : 08-08 10:34
     * orderStatus : 1
     * department : 深航工贸总部
     * flight : SZXWUX
     * flightNo : ZH9801
     * takeOffTime : 2019-10-31 07:05
     * orderPirce : 1100.0
     */

    private String orderNo;//订单编号
    private String issueResult;//预订时间
    private String orderStatus;//订单状态   //0：申请中1：已订座2：已调度3：已出票4：配送中5：部分出票7：客户消8：已取消9：完成
    private String department;//当前所属部门
    private String flight;//航程
    private String flightNo;//航班号
    private String takeOffTime;//起飞时间
    private String orderPirce;//订单金额
    private String cfcity;//出发城市
    private String ddcity;//到达城市

    public String getCfcity() {
        return cfcity;
    }

    public void setCfcity(String cfcity) {
        this.cfcity = cfcity;
    }

    public String getDdcity() {
        return ddcity;
    }

    public void setDdcity(String ddcity) {
        this.ddcity = ddcity;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getIssueResult() {
        return issueResult;
    }

    public void setIssueResult(String issueResult) {
        this.issueResult = issueResult;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getFlight() {
        return flight;
    }

    public void setFlight(String flight) {
        this.flight = flight;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public String getTakeOffTime() {
        return takeOffTime;
    }

    public void setTakeOffTime(String takeOffTime) {
        this.takeOffTime = takeOffTime;
    }

    public String getOrderPirce() {
        return orderPirce;
    }

    public void setOrderPirce(String orderPirce) {
        this.orderPirce = orderPirce;
    }
}
