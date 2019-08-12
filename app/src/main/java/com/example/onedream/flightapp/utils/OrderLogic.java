package com.example.onedream.flightapp.utils;



import android.text.TextUtils;

import java.util.ArrayList;


/**
 * 订单状态逻辑抽取类
 * Created by huangzixiang on 2017/1/20.
 */

public class OrderLogic {
    public static String[] figltOrderTypeValue=new String[]{"全部","申请中","已订座待支付","已支付待出票","出票中","已支付出票中","已出票待支付","已出票","配送中","已完成","已取消"};
    public static String[] figltOrderTypeCode=new String[]{"","00","10,12","11","20,50","21,51","30","31","40,41","91","70,80"};
    public static String[] figltOrderTypeValueB2G=new String[]{"全部","申请中","已订座待支付","已支付待出票","出票中","已支付出票中","已出票待支付","已出票","配送中","已完成","已取消"};
    public static String[] figltOrderTypeCodeB2G=new String[]{"","00","10,12","11","20,50","21,51","30","31","40,41","91","70,80"};



    public static String[] figltRefundOrderTypeValue=new String[]{"全部","已申请待审核","已审核待确认","待退款","已退款","配送中","已完成","已取消"};
    public static String[] figltRefundOrderTypeCode=new String[]{"","A0","00","10,30,60","11,31,61","40,41","51","70"};

    public static String[] figltRefundOrderTypeValueB2G=new String[]{"全部","待退款","已退款","配送中","已完成","已取消"};
    public static String[] figltRefundOrderTypeCodeB2G=new String[]{"","10,30,60","11,31,61","40,41","51","70"};

    public static String[] figltEndorseOrderTypeValue=new String[]{"全部","待支付","已支付待改签","改签中","已支付改签中","已改签","已改签待支付","配送中","已完成","已取消"};
    public static String[] figltEndorseOrderTypeCode=new String[]{"","10,20","21","30","31","41,51","40,50","60,61","91","80"};


    public static String[] figltEndorseOrderTypeValueB2G=new String[]{"全部","已申请待审核","已审核待确认","待支付","已支付待改签","改签中","已支付改签中","已改签","已改签待支付","配送中","已完成","已取消"};
    public static String[] figltEndorseOrderTypeCodeB2G=new String[]{"","A0","00","10,20","21","30","31","41,51","40,50","60,61","91","80"};

    public static String[] flightDayTypeValue={"预订日期","起飞日期"};  //日期类型选项
    public static String[] flightDayTypeCode={"2","1"};  //日期类型选项对应CODE//预订日期0 ，使用日期1

    public static String[] flightDayStartValue=new String[]{"预订始","起飞始"};
    public static String[] flightDayEndValue=new String[]{"预订止","起飞止"};

    public static String[] flightRefundDayTypeValue={"申请始"};  //日期类型选项
    public static String[] flightRefundDayTypeCode={""};  //日期类型选项对应CODE//预订日期0 ，使用日期1


    public static String[] flightrefundDayStartValue=new String[]{"申请始"};
    public static String[] flightrefundDayEndValue=new String[]{"申请止"};

    public static String[] flightEndorseDayTypeValue={"申请日期","起飞日期"};  //日期类型选项
    public static String[] flightEndorseDayTypeCode={"2","1"};  //日期类型选项对应CODE//预订日期0 ，使用日期1


    public static String[] flightEndorseDayStartValue=new String[]{"申请始","起飞始"};
    public static String[] flightEndorseDayEndValue=new String[]{"申请止","起飞止"};



    public static String[] travelCommonOrderTypeValue=new String[]{"全部","待确认","处理中","已确认","已出团","已回团","已拒单","已取消"};
    public static String[] travelCommonOrderTypeCode=new String[]{"","0","1","2","3","4","5","6"};

    public static String[] travelDayTypeValue={"预订日期","出发日期"};//旅游日期类型选项
    public static String[] travelDayTypeCode={"1","2"};//日期类型选项对应CODE//预订日期0 ，出发日期1

    public static String[] travelDayStartValue=new String[]{"预订起","出发起"};
    public static String[] travelDayEndValue=new String[]{"预订止","出发止"};

    public static String[] travelCustomMadeDayTypeValue={"申请日期"};//旅游日期类型选项
    public static String[] travelCustomMadeDayTypeCode={"1"};//日期类型选项对应CODE//预订日期0 ，出发日期1

    public static String[] travelCustomMadeDayStartValue=new String[]{"申请起"};
    public static String[] travelCustomMadeDayEndValue=new String[]{"申请止"};

    public static String[] travelCustomMadeOrderTypeValue=new String[]{"全部","已提交","已取消","已成团"};
    public static String[] travelCustomMadeOrderTypeCode=new String[]{"","0","2","1"};

    public static String[] travelRefundOrderTypeValue=new String[]{"全部","退团中","已支付","已退团","退团已取消"};
    public static String[] travelRefundOrderTypeCode=new String[]{"","7","9","A","B"};

    public static String[] travelRefundDayTypeValue={"申请日期","出发日期"};//旅游日期类型选项
    public static String[] travelRefundDayTypeCode={"1","2"};//日期类型选项对应CODE//预订日期0 ，出发日期1

    public static String[] travelRefundDayStartValue=new String[]{"申请起","出发起"};
    public static String[] travelRefundDayEndValue=new String[]{"申请止","出发止"};

    public static String[] ticketDayTypeValue={"预订日期","旅游日期"};//门票日期类型选项  预订日期0 ，出发日期1
    public static String[] ticketDayTypeCode={"0","1"};//日期类型选项对应CODE

    public static String[] ticketDayStartValue=new String[]{"预订起","旅游起"};//门票
    public static String[] ticketDayEndValue=new String[]{"预订止","旅游止"};

    public static String[] ticketOrderTypeValue=new String[]{"全部","待处理","出票中","已出票","已取消","已核单","noshow","已完成"};//门票订单状态类型
    public static String[] ticketOrderTypeCode=new String[]{"","8801","8802","8803","8804","8807","8808","8809"};

    public static String[] ticketRefundDayTypeValue={"申请日期","预订日期"};//门票日期条件类型，申请日期0
    public static String[] ticketRefundDayTypeCode={"0","1"};//日期类型选项对应CODE

    public static String[] ticketRefundDayStartValue=new String[]{"申请起","预订起"};//门票
    public static String[] ticketRefundDayEndValue=new String[]{"申请止","预订止"};

    public static String[] ticketRefundOrderTypeValue=new String[]{"全部","待处理","已审核","已取消","已完成"};//门票订单状态类型
    public static String[] ticketRefundOrderTypeCode=new String[]{"","8901","8902","8903","8904"};

    //-------------------------审批列表
    /**
     国内机票订单，国内机票退废单，国内机票改签单，国际机票正常单，国际机票退废单，
     国际机票改签单，酒店订单，酒店退票，火车票订单，火车票退票单，火车票改签单，
     签证旅游订单，借支单报销单，出差申请单，门票订单，机场服务订单，用车订单，费用补录单
     07001,"旅游正常单"
     07002,"旅游退单"
     08001,"门票正常单"
     08002,"门票退单"
     09001,"签证正常单"
     09002,"签证退单"
     10001,"用车正常单"
     10002,"用车退单"
     00001,"其它订单"
     00002,"结算单"
     99001,"出差申请正常单"
     99002,"出差申请变更单"
     99003,"借支单"
     99004,"报销单"
     07003,"旅游单订订单"
     00003,"收付款订单"
     00004,"充值订单"
     05001,"机场服务正常单"
     05002,"机场服务退单"

     */
    public static String[] approvalOrderTypeValue={"全部","国内机票订单","国内机票退废单","国内机票改签单","国际机票正常单"
            ,"国际机票退废单", "国际机票改签单","酒店订单","酒店退票","火车票订单","火车票退票单","火车票改签单",
            "旅游正常单","旅游退单","门票正常单","门票退单","签证正常单","签证退单","用车正常单","用车退单",
            "出差申请正常单","出差申请变更单","差旅费用借支单","日常费用借支单","差旅费用报销单","日常费用报销单","费用补录单","机场服务正常单","机场服务退单"};


    public static String[] approvalOrderTypeCode={"","01001","01002","01003","02001","02002","02003","03001","03002"
            ,"06001","06002","06003","07001","07002","08001","08002","09001","09002","10001","10002"
            ,"99001","99002","99003","99005","99004","99006","00001","05001","05002"};

    public static String[] travelTypeValue={"全部","国内机票订单","国内机票退废单","国内机票改签单","国际机票正常单"
            ,"国际机票退废单", "国际机票改签单","酒店订单","酒店退票","火车票订单","火车票退票单","火车票改签单",
            "旅游正常单","旅游退单","门票正常单","门票退单","签证正常单","签证退单","用车正常单","用车退单"
            ,"机场服务正常单","机场服务退单"};


    public static String[] travelTypeCode={"","01001","01002","01003","02001","02002","02003","03001","03002"
            ,"06001","06002","06003","07001","07002","08001","08002","09001","09002","10001","10002"
            ,"05001","05002"};

//    public static String[] approvalDayTypeValue={"创建日期"};//日期类型选项
//    public static String[] approvalDayTypeCode={"1"};//日期类型选项对应CODE//预订日期0 ，出发日期1

    public static String[] approvalDayStartValue=new String[]{"创建日期始"};
    public static String[] approvalDayEndValue=new String[]{"创建日期始止"};

    //-----------------------------申请单
    public static String[] applyDayTypeValue={"出差日期","申请日期"};
    public static String[] applyDayTypeCode={"1","0"};

    public static String[] applyDayStartValue=new String[]{"申请日期始"};
    public static String[] applyDayEndValue=new String[]{"申请日期止"};

    //单据状态：@"全部",@"未提交",@"审批中",@"审批完成",@"已拒绝",@"已确定",@"已报销",@"无需审批",@"终止"
    public static String[] applyOrderStateValue=new String[]{"全部","未提交","审批中","审批完成","已拒绝","已确定","已报销","无需审批","终止"};
    public static String[] applyOrderStateCode=new String[]{"","1","2","3","4","5","6","7","8"};

    //-----------------------------报销单

    public static String[] reimburseDayStartValue=new String[]{"申请日期始","费用日期始"};
    public static String[] reimburseDayEndValue=new String[]{"申请日期止","费用发生日期止"};

    //单据状态：@"全部",@"未提交",@"审批中",@"审批完成",@"已拒绝",@"已完成",@"已作废",@"无需审批",@"终止"
    public static String[] reimburseOrderStateValue=new String[]{"全部","未提交","审批中","审批完成","已拒绝","已完成","已作废","无需审批","终止"};
    public static String[] reimburseOrderStateCode=new String[]{"","1","2","3","4","5","6","7","8"};

    //-----------------------------借支单
    public static String[] borrowDayTypeValue={"出差日期","申请日期"};
    public static String[] borrowDayTypeCode={"1","0"};//0：申请日期1:出差日期

    //单据状态：@"全部",@"未送审",@"审批中",@"审批完成",@"已拒绝",@"已完成",@"已作废",@"无需审批",@"终止"
    public static String[] borrowOrderStateValue=new String[]{"全部","未送审","审批中","审批完成","已拒绝","已完成","已作废","无需审批","终止"};
    public static String[] borrowOrderStateCode=new String[]{"","1","2","3","4","5","6","7","8"};

    //-----------------------------补录单
    public static String[] supplyDayTypeValue={"不限","费用发生日期","申请日期"};
    public static String[] supplyDayTypeCode={"","1","2"};//1 费用发生日期  2 申请日期




    //是否需要报销	0 不需要  1需要
    public static String[] supplyIsneedReimburseValue={"不限","是","否"};
    public static String[] supplyIsneedReimburseCode={"","1","0"};

    //待报销的列表 1.出行日期 2：预订日期
    public static String[] getReimburseValue={"预订日期","出行日期"};
    public static String[] getReimburseCode={"1","2"};
    public static String[] getReimburseIsneedReimburseValue={"全部","已报销","未报销"};
    public static String[] getReimburseIsneedReimburseCode={"","1","0"};
    public static String[] getReimburseApplydateTypeValue={"申请日期"}; //待报销申请单
    public static String[] getReimburseApplydateTypeCode={"2"};    //

    public static String[] airportServiceOrderdateTypeValue={"预订日期","出行日期"}; //普通订单日期类型中文数组
    public static String[] airportServiceOrderdateTypeCode={"0","1"};    //日期类型代码数组

    public static String[] airportServiceReturnOrderdateTypeValue={"申请日期"}; //普通订单日期类型中文数组
    public static String[] airportServiceReturnOrderdateTypeCode={"1"};    //日期类型代码数组

    public static String[] airportServiceOrderdateStateValue={"全部","待支付","已支付,待确认","处理中","待使用","已使用","已取消"}; //普通订单状态中文数组
    public static String[] airportServiceOrderdateStateCode={"","101","102","103","104","105","106"};    //订单状态代码数组

    public static String[] airportServiceReturnOrderdateStateValue={"全部","未退款","已取消","已退款"}; //退票订单状态中文数组
    public static String[] airportServiceReturnOrderdateStateCode={"","201","202","203"};    //订单状态代码数组

    /**
     * 01001 机票;03001 酒店;06001 火车票;07001 旅游;
     08001 门票;09001 签证;10001 用车;05001 机场服务;
     */
    public static String[] getReimburseTypeValue={"不限","机票","酒店","火车票", "旅游","门票","签证","用车","机场服务"};

    public static String[] getReimburseTypeCode={"","01001","03001","06001","07001","08001","09001","10001","05001"};

    //-----------------------------签证
    public static String[] visaOrderdateTypeValue={"预订日期","旅行日期"}; //普通订单日期类型中文数组
    public static String[] visaOrderdateTypeCode={"1","2"};    //日期类型代码数组

    public static String[] visaOrderStateValue={"不限","待处理","已确定","办理中","已寄回","已出结果","已完成"};    //普通订单状态中文数组
    public static String[] visaOrderStateCode={"","901","902","1","910","2","914"};//普通订单状态代码数组

    public static String[] visaDayStartValue=new String[]{"预订起","旅行起"};
    public static String[] visaDayEndValue=new String[]{"预订止","旅行止"};


    public static String[] visaRefundOrderStateValue={"不限","待处理","已审核","已取消","已完成"};    //退款订单状态中文数组
    public static String[] visaRefundOrderStateCode ={"","9901","9902","9903","9904"};    //退款订单状态代码数组

    public static String[]  visaRefundOrderdateTypeValue={"申请日期","预订日期"};    //退款订单日期类型中文数组
    public static String[] visaRefundOrderdateTypeCode={"1","2"};    //日期类型代码数组

    public static String[] visaRefundDayStartValue=new String[]{"申请起","预订起"};
    public static String[] visaRefundDayEndValue=new String[]{"申请止","预订止"};


    //------------------------------酒店
    public static String[] hotelNomalDayTypeValue={"预订日期","入住日期"};//1为预订日期2为入住日期(默认预订日期)
    public static String[] hotelNomalDayTypeCode={"1","2"};//日期类型选项对应CODE
    public static String[] hotelNomalDayStartValue=new String[]{"预订起","入住起"};
    public static String[] hotelNomalDayEndValue=new String[]{"预订止","入住止"};

    public static String[] hotelNomalOrderTypeValue={"全部","已预订待确认","已确认","已取消","已完成"};
    public static String[] hotelNomalOrderTypeCode={"","1","H3","7","H9"};

    public static String[] hotelRefundDayTypeValue={"申请日期","退款日期"};//1为预订日期2为入住日期(默认预订日期)
    public static String[] hotelRefundDayTypeCode={"1","2"};//日期类型选项对应CODE
    public static String[] hotelRefundDayStartValue=new String[]{"申请起","退款起"};
    public static String[] hotelRefundDayEndValue=new String[]{"申请止","退款止"};

    public static String[] hotelRefundOrderTypeValue={"全部","待审核","已审核待退款","已退款完成","已取消"};
    public static String[] hotelRefundOrderTypeCode={"","0","1","4","5"};

    public static String[] OrderDetialOrderTypeValue={"国内机票正常单","国内机票退废单","国内机票改签单", "国际机票正常单","国际机票退废单","国际机票改签单", "酒店正常单",
                                                        "酒店退单","保险正常单", "保险退单","机场服务正常单", "机场服务退单", "火车票正常单","火车票退票单","火车票改签单",
                                                        "旅游正常单", "旅游退单", "门票正常单", "门票退单","签证正常单","签证退单","用车正常单", "用车退单", "其它订单",
                                                        "结算单","出差申请正常单","出差申请变更单", "借支单","报销单","旅游单订订单","收付款订单", "充值订单"};
    public static String[] OrderDetialOrderTypeCode={"01001","01002","01003","02001","02002", "02003","03001","03002","04001","04002","05001","05002","06001", "06002",
            "06003","07001","07002","08001","08002", "09001","09002", "10001","10002", "00001","00002", "99001","99002", "99003","99004","07003", "00003", "00004"};

    /**
     * 1003401=>身份证 => 1
     * 1003402=>护照 => B
     * 1003407=>港澳通行证 => C
     * 1003404=>军人证
     * 1003405=>回乡证  => C
     * 1003406=>台胞证 =>G
     * 1003417=>国际海员证
     * 1003409=>外国人居留证
     * 1003410=>其他
     * 1003413=>户口簿
     * 1003414=>警官证
     * 1003415=>营业执照
     * 1003411=>士兵证
     * 1003412=>临时身份证
     * 1003416=>台湾通行证 =>G
     */
    //所有证件类型
    public static String[] cardName = {"身份证","护照","港澳通行证","军人证","回乡证","台胞证","外国人居留证","其它","台湾通行证"};     //证件名称
    public static String[] cardCode = {"1003401","1003402","1003407","1003404","1003405","1003406","1003409","1003410","1003416"};  //证件号码
    //机票证件类型(机票没有港澳通行证)
    public static String[] flightCardName = {"身份证","护照","军人证","回乡证","台胞证","外国人居留证","其它","台湾通行证"};     //证件名称
    public static String[] flightCardCode = {"1003401","1003402","1003404","1003405","1003406","1003409","1003410","1003416"};  //证件号码
    //火车票证件类型
    public static String[] trainCardName = {"身份证","护照","回乡证","港澳通行证","台湾通行证","台胞证"};     //证件名称
    public static String[] trainCardCode = {"1","B","C","C","G","G"};  //证件号码
    public static String[] TrainOrderCodeValue ={"1003401","1003402","1003405","1003407","1003416","1003406"};//联系人公用的

    public static String sexValueItems[] = { "男", "女" };
    public static String sexCodeItems[] = { "M", "F" };
    //差旅类型
    public static String[] travelstatus = {"不限","因公","因私"};
    public static String[] travelstatuscodes = {"","1","2"};

    //用车
    public static String[] rentcarNomalDayTypeValue={"预订日期","用车日期"};
    public static String[] rentcarNomalDayTypeCode={"1","2"};

    public static String[] rentcarNomalStarValue={"预订起","用车起"};
    public static String[] rentcarNomalEndValue={"预订止","用车止"};
    public static String[] rentcarNomalOrderTypeValue={"全部","待支付","已支付,待派车","派车中","已派车","已上车","已用车","已取消"};
    public static String[] rentcarNomalOrderTypeCode={"","101","102","103","104","107","105","106"};
    public static String[] rentcarUseCarTypeValue={"不限","即时","预约"};
    public static String[] rentcarUseCarTypeCode={"","0","1"};
    public static String[] rentcarServiceTypeValue={"不限","专快车","接机","送机","接站","送站"};
    public static String[] rentcarServiceTypeCode={"","5","1","2","3","4"};
    //用车退单
    public static String[] rentcarRefundDayTypeValue={"申请日期","用车日期"};
    public static String[] rentcarRefundDayTypeCode={"1","2"};
    public static String[] rentcarRefundStarValue={"申请起","用车起"};
    public static String[] rentcarRefundEndValue={"申请止","用车止"};
    public static String[] rentcarRefundOrderTypeValue={"全部","已申请","已审核","已退款","取消退款"};
    public static String[] rentcarRefundOrderTypeCode={"","201","202","203","204"};

    //火车票正常
    public static String[] trainNomalDayTypeValue={"预订日期","出发日期"};
    public static String[] trainNomalDayTypeCode={"1","2"};
    public static String[] trainNomalStarValue={"预订起","出发起"};
    public static String[] trainNomalEndValue={"预订止","出发止"};
    public static String[] trainNomalOrderTypeValue={ "全部","已申请","等待订座","已订座","等待出票","已出票","等待取消","已取消"};
    public static String[] trainNomalOrderTypeCode={ "","1","2A","2","4A","4","7A","7"};

    //火车票退票
    public static String[] trainReturnDayTypeValue={"申请日期","出发日期"};
    public static String[] trainReturnDayTypeCode={"1","2"};
    public static String[] trainReturnStarValue={"申请起","出发起"};
    public static String[] trainReturnEndValue={"申请止","出发止"};
    public static String[] trainReturnOrderTypeValue={ "全部","申请中","已确定未退款","已完成","已取消"};
    public static String[] trainReturnOrderTypeCode={ "", "1","2","5","6"};

    //火车票改签
    public static String[] trainGqDayTypeValue={"申请日期","出发日期"};
    public static String[] trainGqDayTypeCode={"1","2"};
    public static String[] trainGqStarValue={"申请起","出发起"};
    public static String[] trainGqEndValue={"申请止","出发止"};
    public static String[] trainGqOrderTypeValue={"全部","已申请","已确定","已改签未退款","已取消","已完成"};
    public static String[] trainGqOrderTypeCode={ "","1","3","4","7","9" };

    //-----钱包
    public static String[] walletDateTypeValue={"交易日期"};
    public static String[] walletDateTypeCode={""};

    //收支记录状态
    public static String[] preDepositBillTypeValue={"全部","消费","退款","充值","提现"};
    public static String[] preDepositBillTypeCode={"1","81053405","81053406","81053401","81053403"};

    public static String[] rechargeRecordTypeValue={"全部","成功","失败","处理中","充值退回"};
    public static String[] rechargeRecordTypeCode={"","1","2","3","4"};

    public static String[] cashRegisterTypeValue={"全部","成功","失败","处理中","部分成功"};
    public static String[] cashRegisterTypeCode={"","1","2","3","4"};
    /**
     * 根据订单类型获取对应的code
     * @param code  订单类型的中文名称
     * @return      返回对应的code
     */
    public static String getOrderDetailOrderTypeCode(String code){

        if(!TextUtils.isEmpty(code)) {
            //根据值获取对应的位置
            int position = OrderLogic.getOrderTypPosByCode(OrderLogic.OrderDetialOrderTypeValue, code);
            //根据位置获取code
            String result=OrderLogic.OrderDetialOrderTypeCode[position];
            return result;
        }
        return null;
    }

    /**
     * 获取类型选择配置
     * @param code
     * @return
     */
    public static int getOrderTypPosByCode(String[] orderTypeCode, String code) {
            for(int i=0;i<orderTypeCode.length;i++){
                //如果相等，返回Pos
                if(orderTypeCode[i].equals(code)){
                    return i;
                }
            }

        return 0;
    }

    /**
     * 根据类型Code获取日期类型，Pos
     * @param dateTypeCode
     * @return
     */
    public static int getOrderDatTypePosByCode(String[] dayTypeCode, String dateTypeCode) {
        if(null!=dateTypeCode&&!TextUtils.isEmpty(dateTypeCode))
        for(int i=0;i<dayTypeCode.length;i++){
            //如果相等，返回Pos
            if(dayTypeCode[i].equals(dateTypeCode)){
                return i;
            }
        }

        return 0;
    }

    /**
     * 根据证件Code获取证件名称
     * @param code
     * @return
     */
    public static String getCardNameByCode(String code){
        if(!TextUtils.isEmpty(code)){
            for(int i=0;i<cardCode.length;i++){
                if(cardCode[i].equals(code)){
                    return cardName.length>i?cardName[i]:"";
                }
            }
        }

        return "其他";
    }

    /**
     * 根据证件名称获取证件Code
     * @param name
     * @return
     */
    public static String getCardCodeByName(String name){
        if(!TextUtils.isEmpty(name)){
            for(int i=0;i<cardName.length;i++){
                if(cardName[i].equals(name)){
                    return cardCode.length>i?cardCode[i]:"";
                }
            }
        }

        return "";
    }

//    /**
//     * 从证件集合中取一个用于显示
//     *
//     * @param zjjh
//     * @return
//     */
//    public static ZJDX getShowZjdx(ArrayList<ZJDX> zjjh){
//        if(null!=zjjh&&!zjjh.isEmpty()){
//            //如果有选中的，游戏返回选中的
//            ZJDX check=getShowZjdxByCheck(zjjh);
//            if(null!=check){
//                return check;
//            }
//            //按证件顺序去取
//            for(String code:cardCode){
//                for(ZJDX item:zjjh){
//                    if(null!=item&&code.equals(item.getZjlx())&&StringUtils.isNotBlank(item.getZjhm())){
//                        return item;
//                    }
//                }
//            }
//        }
//        //防止出现空指针,默认是身份证
//        return new ZJDX(cardCode[0]);
//    }

//    /**
//     *
//     * @param zjjh
//     * @param isCanNull 证件号码是否能为空 true能
//     * @return
//     */
//    public static ZJDX getShowZjdx(ArrayList<ZJDX> zjjh, boolean isCanNull){
//        if(null!=zjjh&&!zjjh.isEmpty()){
//            //如果有选中的，游戏返回选中的
//            ZJDX check=getShowZjdxByCheck(zjjh);
//            if(null!=check){
//                return check;
//            }
//            //按证件顺序去取
//            for(String code:cardCode){
//                for(ZJDX item:zjjh){
//                    if(null!=item&&code.equals(item.getZjlx())){
//                        if(isCanNull){ //如果证件号码能为空
//                            return item;
//                        }else {
//                            if(StringUtils.isNotBlank(item.getZjhm())){
//                                return item;
//                            }
//                        }
//                    }
//                }
//            }
//            //如果都为空,取1个元素
//            if(null!=zjjh.get(0)){
//                return zjjh.get(0);
//            }
//        }
//        //防止出现空指针,默认是身份证
//        return new ZJDX(cardCode[0]);
//    }
//
//    public static ZJDX getShowZjdxByCheck(ArrayList<ZJDX> zjjh){
//        if(null!=zjjh){
//            //按证件顺序去取
//                for(ZJDX item:zjjh){
//                    if(null!=item&&item.isCheck()){
//                        return item;
//                    }
//                }
//        }
//        return null;
//    }
//
//
//    private static ZJDX getShowZjdxByCheck(ArrayList<ZJDX> zjjh, ArrayList<GetUsefulCertificateInfo> getUsefulCertificateInfos) {
//        if(null!=zjjh){
//            for (int i = 0; i <getUsefulCertificateInfos.size() ; i++) {
//                GetUsefulCertificateInfo getUsefulCertificateInfo = getUsefulCertificateInfos.get(i);
//                String zjlx = getUsefulCertificateInfo.getZjlx();
//
//                for(ZJDX item:zjjh){
//                    if(null!=item&&zjlx.equals(item.getZjlx())&&item.isCheck()){
//                        return item;
//                    }
//                }
//
//
//            }
//
//
//        }
//
//
//        return null;
//    }
//
//    /**
//     *   从可以使用的 证件集合中取一个用于显示
//     * @param zjjh
//     * @param getUsefulCertificateInfos
//     * @return
//     */
//    public static ZJDX getShowZjdxByUsefulCertificateInfos(ArrayList<ZJDX> zjjh, ArrayList<GetUsefulCertificateInfo> getUsefulCertificateInfos){
//        if(null!=zjjh&&!zjjh.isEmpty()&&getUsefulCertificateInfos!=null&&!getUsefulCertificateInfos.isEmpty()){
//            //按证件顺序去取
//
//            ZJDX check=getShowZjdxByCheck(zjjh,getUsefulCertificateInfos);
//            if(null!=check){
//                return check;
//            }
//
//            for (int i = 0; i <getUsefulCertificateInfos.size() ; i++) {
//                GetUsefulCertificateInfo getUsefulCertificateInfo = getUsefulCertificateInfos.get(i);
//                String zjlx = getUsefulCertificateInfo.getZjlx();
//                for(ZJDX item:zjjh){
//                    if(null!=item&&zjlx.equals(item.getZjlx())&&StringUtils.isNotBlank(item.getZjhm())){
//                        return item;
//                    }
//                }
//
//
//            }
//
//            GetUsefulCertificateInfo getUsefulCertificateInfo = getUsefulCertificateInfos.get(0);
//            ZJDX  dx = new ZJDX();
//            dx.setZjlx(getUsefulCertificateInfo.getZjlx());
//            return dx;
//
//
//        }
//        return null;
//    }
//
//
//    /**
//     * 获取火车票支持的证件集合
//     * @return
//     */
//    public static ArrayList<ZJDX> getTrainZjjh(){
//        ArrayList<ZJDX> zjjh=new ArrayList<>();
//        for(int i=0;i<trainCardName.length;i++){
//            ZJDX zjdx=new ZJDX();
//            zjdx.setZjlx(TrainOrderCodeValue[i]);
//            zjdx.setZjmc(trainCardName[i]);
//            zjjh.add(zjdx);
//        }
//        return zjjh;
//    }
//

    /**
     * 格式化证件类型   用于火车票下单时证件的转换  原因：选择乘车人返回的证件类型与下单需要的证件不一致
     * @param str  将新的改为旧的
     * @return
     */
    public static String formatCardTypeByNew(String str){

        for(int i=0;i<TrainOrderCodeValue.length;i++){
            if(str.equals(TrainOrderCodeValue[i])){//只是为了拿到对应的i
                return trainCardCode[i];
            }
        }
        return "";
    }

    /**
     * 格式化证件类型  将旧的改为新的
     * @param str
     * @return
     */
    public static String formatCardTypeByOld(String str){

        for(int i=0;i<trainCardCode.length;i++){
            if(str.equals(trainCardCode[i])){//只是为了拿到对应的i
                return TrainOrderCodeValue[i];
            }
        }
        return "";
    }


}
