package com.example.onedream.flightapp.utils;

import android.text.TextUtils;

import org.apache.commons.lang.StringUtils;

import java.util.List;


public class FlightUtils extends Operation{

	private static FlightUtils flightUtil;

	/**
	 * 获取实例
	 * @return
	 */
	public static synchronized FlightUtils getInstance() {
		// TODO Auto-generated method stub
		if(null==flightUtil)flightUtil=new FlightUtils();
		return flightUtil;
	}

	//*********************************************显示数据处理*********************************************
	/**
	 * 座位显示
	 * @param str
	 * @return
	 */
	public String fromatSeatNum(String str) {
		if ("A".equals(str)) {
			return "充足";
		} else if ("0".equals(str)) {
			return "无座位";
		} else {
			return str + "张";
		}
	}




	/**
	 * 根据编号 获取证件类型名称
	 *
	 * @param code
	 * @return
	 */
	public String fromatCardType(String code) {
		StringBuilder sb = new StringBuilder();
		if ("P".equals(code)) {
			sb.append("护照");
		} else {
			sb.append("身份证");
		}
		return sb.toString();

	}

	/**
	 * 根据编号 获取证件类型名称
	 *
	 * @param code
	 * @return
	 */
	public String fromatFlightCardType(String code) {

		if ("PP".equals(code)) {
			return "护照";
		} else if("NI".equals(code)){
			return "身份证";

		}else if("ID".equals(code)){
			return "其他";
		}else if("TN".equals(code)){
			return "票号";
		}else {
			return code;

		}

	}	/**
		 * 餐食
		 * @param code
		 * "B", "C", "D", "M","S", "L", "O"
		 * "早餐", "快餐", "正餐","餐食", "小吃", "午餐", "冷食餐"
		 * @return
		 */
		public String fromatEatString(String code){
			StringBuilder sb = new StringBuilder();
			if("B".equals(code)){
				sb.append("早餐");
			}else if("C".equals(code)){
				sb.append("快餐");
			}else if("D".equals(code)){
				sb.append("正餐");
			}else if("M".equals(code)){
				sb.append("餐食");
			}else if("S".equals(code)){
				sb.append("小吃");
			}else if("L".equals(code)){
				sb.append("午餐");
			}else if("O".equals(code)){
				sb.append("冷食餐");
			}else if(TextUtils.isEmpty(code)){
				sb.append("无餐");
			}
			return sb.toString();
		}

	/**
	 * 控制折扣的显示
	 *
	 * @param discount
	 *            需为 大于1 的整数 如 25 则返回2.5折
	 * @return
	 */
	public static String controrDiscountShow(double discount) {
		if (-1 == discount) {
			return "会员价";
		} else if (discount == 0) {
			return "";
		} else if (discount < 100 && discount > 0) {
			return formatZero(Arith.round(discount / 10, 1)) + "折";
		} else if (discount == 100) {
			return "全价";
		} else if (discount > 100) {
			return "全价" + formatZero(Arith.round(discount / 100, 1)) + "倍";
		}
		return "";
	}

	/**
	 * 获取航班动态状态
	 * "未起飞", "待起飞","飞行中", "已到达", "已取消","延误"
	 * "0", "1", "2", "3","4","A"
	 * @return
	 */
	public String formatFlightScheduleState(String code){
		StringBuilder sb=new StringBuilder();
		if("0".equals(code)){
			sb.append("未起飞");
		}else if("1".equals(code)){
			sb.append("待起飞");
		}else if("2".equals(code)){
			sb.append("飞行中");
		}else if("3".equals(code)){
			sb.append("已到达");
		}else if("4".equals(code)){
			sb.append("已取消");
		}else if("A".equals(code)){
			sb.append("延误");
		}
		return sb.toString();
	}

	/**
	 * 检查机票订单是否过期
	 *
	 * @param state 订单状态
	 * @param date	日期 格式为：YYYY-MM-DD
	 * @param time	 格式为： HH:MM
	 * @return true=过期
	 */
	public boolean checkFlightOrderTime(String state, String date, String time) {
		if ("1".equals(state) || "2".equals(state) || "0".equals(state)
				|| "A".equals(state)) {
			return checkOrderTime(date, time);
		}
		return true;
	}
	/**
	 * 获取航班动态状态和颜色值
	 * @param flight_status
	 * @param delayed_status
	 * @return
	 */
	public String getFlightScheduleState(String flight_status,
                                         String delayed_status) {
		 if ("0".equals(flight_status)) {
			return "未起飞#666666";
		} else if ("1".equals(flight_status)) {
			return "待起飞#3076D4";
		} else if ("2".equals(flight_status)) {
			return "飞行中#3076D4";
		} else if ("3".equals(flight_status)) {
			return "已到达#666666";
		} else if ("4".equals(flight_status)) {
			return "已取消#CA4848";
		}
		return "#666666";
	}
	//**************************************************订单***********************************************

	/**
	 * 机票普通订单状态
	 * "机位申请中","已订座待支付","已支付出票中","已支付出票中","已出票","订单已取消","订单已取消"
     * "0","1","2","5","3","7","8"
	 *
	 **/
	public String getFlightOrderState(String orderState){
		if ("0".equals(orderState)) {
			return "机位申请中";//
		} else if ("1".equals(orderState)) {
			return "已订座待支付";
		}else if ("2".equals(orderState)) {
			return "已支付出票中";
		} else if ("3".equals(orderState)) {
			return "已出票";
		} else if("5".equals(orderState)){
			return "已支付出票中";
		}else if("7".equals(orderState)){
			return "已取消";
		}else if("8".equals(orderState)){
			return "已取消";
		}else{
			return "";
		}
	}
	/**
	 * 获取退票订单状态
	 * 退废状态：退票状态:1.已申请3已确认待退票5已退票9已退票7已取消
	 * @param orderState
	 * @return
	 */
	public String getFlightReturnOrderState(String orderState) {
		//退票修改后 c端 1申请中 2A等待办理  2 已确认未退款  3 已完成 4 已取消
		if ("1".equals(orderState)) {
			return "已申请";// 如在前端预订，B2C,B2G,B2B 均不会出现此状态。
		} else if ("3".equals(orderState)) {//
			return "已确认待退款";
		}else if("4".equals(orderState)){
			return"已确认待退款";
		}else if ("5".equals(orderState)) {//二审
			return "已完成";
		}else if("6".equals(orderState)){
			return"已确认待退款";
		} else if ("7".equals(orderState)) {//客户或后台工作人员取消
			return "客户消";
		} else if("8".equals(orderState)){
			return "系统消";
		}else{
			return orderState;
		}
	}

    // 深圳航空G+X+S对接 start
    /**
     * 根据 舱位名称代码 prt 获取获取舱位名称
     * 1.特惠
     * 2.特价 3.经济舱  4.明珠舱 5.公务舱 6.头等舱
     *
     * @return
     */
    public String getFlightCabName(String prt) {
        if ("1001".equals(prt)) {
            return "特惠";
        } else if ("2001".equals(prt)) {
            return "特价";
        } else if ("3001".equals(prt)) {
            return "经济";
        } else if ("3002".equals(prt)) {
            return "超值服务";
        } else if ("4001".equals(prt)) {
            return "明珠";
        } else if ("4002".equals(prt)) {
            return "舒适经济";
        } else if ("5001".equals(prt)) {
            return "公务";
        } else if ("6001".equals(prt)) {
            return "头等";
        }else if ("7001".equals(prt)) {
			return "";
		} else {
            return "";
        }

    }
    // 深圳航空G+X+S对接 end

	/**
	 * 转换 机票改签  订单状态
	 * 1已申请 2 已支付待改签 3 改签中 4 已改签 7 已取消 8 已取消
	 * @param staue 接口返回 状态编号
	 * @return
	 */
	public String getFlightEndorseOrderStaue(String staue){
		if("1".equals(staue)){//客人/预订员/分销申请退票。
			return "已申请";
		}else if("2".equals(staue)){//客人支付，准备改签。
			return "已支付待改签";
		}else if("3".equals(staue)){//自动改签或手动改签开始，锁单。
			return "改签中";
		}else if("4".equals(staue)){//自动改签或手动改签完成。
			return "已改签";
		}else if("7".equals(staue)){//客人在C端取消改签单
			return "已取消";
		}else if("8".equals(staue)){//后台工作人员取消。
			return "已取消";
		}
		return staue;
	}

	/**
	 * 正常单 控制退票 、改签按钮显示
	 * @param orderStu  订单状态
	 * @param payStu   支付状态
	 * @param rti   退费说明
	 * @return
	 */
	public boolean checkEndroseRefun(String orderStu, String payStu, String rti){
		if ("3".equals(orderStu)&& "1".equals(payStu)&&StringUtils.isBlank(rti)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean canPay(String orderStu, String payStu) {
		// TODO Auto-generated method stub
		if ("1".equals(orderStu)||"3".equals(orderStu)) {
				if("0".equals(payStu)){
					return true;
				}
		}
		return false;
	}

	@Override
	public boolean canCancel(String orderStu, String payStu) {
		// TODO Auto-generated method stub
		if ("0".equals(orderStu)
				|| "1".equals(orderStu)) {
			if ("0".equals(payStu)) {
				return true;
			}
		}
		return false;
	}
	public static String formatPrice(double dou){
		String str = String.valueOf(dou);
		String[] strarr = str.split("\\.");
		if(strarr.length>1){
			if(Double.parseDouble(strarr[1]) != 0){
				return str;
			}else{
				return strarr[0];
			}
		}else{
			return str;
		}
	}




	public String contror_discount_show(String dct) {

		return null;
	}

	/**
              根据可选航班的航班状态去返回不同的字段供显示
	 * @return
	 */
	public String getCheckInFlightCodeName(String flightcheckincode){
		if("0".equals(flightcheckincode)){
			return "该航班在线值机不可办理";
		}else if("1".equals(flightcheckincode)){
			return "该航班在线值机已开放";

		}else if("2".equals(flightcheckincode)){
			return "该航班在线值机已办理";
		}else if("3".equals(flightcheckincode)){
			return "该航班在线值机未到办理时间";

		}else {
			return flightcheckincode;
		}


	}
	public String getCheckInListStatusName(String statuscode){
		 if("1".equals(statuscode)){
			return "未办理";
		}else if("2".equals(statuscode)){

			return "已办理";
		}else if("4".equals(statuscode)){
			return "办理失败";
		}else if("3".equals(statuscode)){
			return "已取消";
		}else if("5".equals(statuscode)){
			return "已作废";
		}else{
			return statuscode;

			}



	}
	/**
	 * 判断耗时的显示
	 *
	 * @param time
	 *            MM:NN
	 * @return
	 */
	public String chekc_time_consuming(String time) {
		String result = "";
		String[] arrtime = StringUtils.trimToEmpty(time).split(":");
		if(null!=arrtime&&2==arrtime.length){
			if (Integer.parseInt(arrtime[0]) > 0) {
				if ("0".equals(arrtime[0].charAt(0) + "")) {
					arrtime[0] = arrtime[0].substring(1, arrtime[0].length());
				}
				result = arrtime[0] + "小时";
			}
			if (Integer.parseInt(arrtime[1]) > 0) {
				if ("0".equals(arrtime[1].charAt(0) + "")) {
					arrtime[1] = arrtime[1].substring(1, arrtime[1].length());
				}
				result = result + arrtime[1] + "分钟";
			}
		}
		return result.length()>0?result:time;
	}

	/**
	 * 判断是筛选 还是关闭筛选
	 * @param screenResaultList
	 * @return
	 */
	public boolean booleanIsIfFilter(List<String> screenResaultList) {
		if(screenResaultList!=null&&!screenResaultList.isEmpty()){
			for (int i = 0; i < screenResaultList.size(); i++) {
				String screenresault = screenResaultList.get(i);
				if(!TextUtils.isEmpty(screenresault.trim())){
					return true;
				}

			}
			return false;
		}else{
			return false;
		}

	}

	public String getFlightInternationalCabName(String cwdj) {
		if("0".equals(cwdj)){
		   return "经济舱";
		}else if("1".equals(cwdj)){

			return   "头等舱";
		}else if("2".equals(cwdj)){

			return "公务舱";
		}


		return "";
	}
}
