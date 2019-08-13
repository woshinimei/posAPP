package com.example.onedream.flightapp.utils;

import org.apache.commons.lang.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 界面 显示 处理
 * @author win7
 *
 */
public abstract  class Operation{
	/**
	 * 控制支付按钮显示
	 * @param orderStu 订单状态
	 * @param payStu 支付状态
	 * @return true显示
	 */
	public abstract boolean canPay(String orderStu, String payStu);
	/**
	 * 控制取消按钮显示
	 * @param orderStu 订单状态
	 * @param payStu 支付状态
	 * @return true显示
	 */
	public abstract boolean canCancel(String orderStu, String payStu);
	/**
	 * 判断耗时的显示
	 * 
	 * @param time
	 *            MM:NN
	 * @return
	 */
	public String chekcTimeConsuming(String time) {
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
	 * 
	 * 1-------周日
	 * 2-------周一 
	 * 3-------周二
	 * 4-------周三 
	 * 5-------周四 
	 * 6-------周五
	 * 7-------周六
	 * @param week
	 * @return
	 */
	public String formatWeek(int week) {
		StringBuilder sb = new StringBuilder();
		if (1 == week) {
			sb.append("周日");
		} else if (2 == week) {
			sb.append("周一");
		} else if (3 == week) {
			sb.append("周二");
		} else if (4 == week) {
			sb.append("周三");
		} else if (5 == week) {
			sb.append("周四");
		} else if (6 == week) {
			sb.append("周五");
		} else if (7 == week) {
			sb.append("周六");
		}
		return sb.toString();
	}
	public String formatDate(String year, String month, String day) {
		if (month.length() < 2) {
			month = "0" + month;
		}
		if (day.length() < 2) {
			day = "0" + day;
		}
		return year + "-" + month + "-" + day;
	}
	/**
	 * 
//	 * @param data	yyyy-MM-dd
	 * @return
	 */
	public String formatWeek(String date){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		StringBuilder sb=new StringBuilder();
		try {
			Calendar cal=Calendar.getInstance();
			cal.setTime(sdf.parse(date));
			sb.append(formatWeek(cal.get(Calendar.DAY_OF_WEEK)));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sb.toString();
	}
	
	/**
	 * 
	 * @param date YYYY-MM-DD
	 * @return	 
	 */
	public String formatFlightDate(String date){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		StringBuilder sb=new StringBuilder();
		try {
			Calendar cal=Calendar.getInstance();
			cal.setTime(sdf.parse(date));
			sb.append(date);
			sb.append(formatWeek(cal.get(Calendar.DAY_OF_WEEK)));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sb.toString();
	}
	
	/**
	 * 格式化日期显示
	 * @param value
	 * @param format
	 * @param isyear true 显示
	 * @param isweek true 显示
	 * @param istime true显示HH:mm
	 * @return
	 */
	public String formatDateShwo(String value, String format, boolean isyear,
                                 boolean isweek, boolean istime) {
		StringBuilder sb = new StringBuilder();
		if(StringUtils.isNotBlank(value)){
			SimpleDateFormat sdf=new SimpleDateFormat(format);
			Calendar calendar=Calendar.getInstance();
			try {
				calendar.setTime(sdf.parse(value));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (isyear) {
				sb.append(calendar.get(Calendar.YEAR) + "年");
			} 
			sb.append((formatT(calendar.get(Calendar.MONTH)+1)) + "月" + formatT(calendar.get(Calendar.DAY_OF_MONTH)) + "日 ");
			if(istime){
				sb.append(formatT(calendar.get(Calendar.HOUR_OF_DAY))+":"+formatT(calendar.get(Calendar.MINUTE))+" ");
			}
			
			if (isweek) {
				sb.append(formatWeek(calendar.get(Calendar.DAY_OF_WEEK)) + " ");
				if (value.equals(VeDate.getStringDateShort())) {
					sb.append("今天");
				} else if (value.equals(VeDate.getNextDay(
						VeDate.getStringDateShort(), "1"))) {
					sb.append("明天");
				} else if (value.equals(VeDate.getNextDay(
						VeDate.getStringDateShort(), "2"))) {
					sb.append("后天");
				}
			}
		}
		return sb.toString();
	}
	/**
	 * 格式化日期显示
	 * @param value
	 * @param format
	 * @param isyear true 显示
	 * @param isweek true 显示
	 * @param istime true显示HH:mm
	 * @return
	 */
	public String formatDateShwo(String value, String format, boolean isyear,
                                 boolean isweek, boolean istime, boolean isformatemonth) {
		StringBuilder sb = new StringBuilder();
		if(StringUtils.isNotBlank(value)){
			SimpleDateFormat sdf=new SimpleDateFormat(format);
			Calendar calendar=Calendar.getInstance();
			try {
				calendar.setTime(sdf.parse(value));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (isyear) {
				sb.append(calendar.get(Calendar.YEAR) + "年");
			} 
			if(isformatemonth){
				
				sb.append((formatT(calendar.get(Calendar.MONTH)+1)) + "月" + formatT(calendar.get(Calendar.DAY_OF_MONTH)) + "日 ");
			}else{
				int month = calendar.get(Calendar.MONTH)+1;
				String result = month+"";
				sb.append(result + "月" + formatT(calendar.get(Calendar.DAY_OF_MONTH)) + "日 ");
			}
			if(istime){
				sb.append(formatT(calendar.get(Calendar.HOUR_OF_DAY))+":"+formatT(calendar.get(Calendar.MINUTE))+" ");
			}
			
			if (isweek) {
				sb.append(formatWeek(calendar.get(Calendar.DAY_OF_WEEK)) + " ");
				if (value.equals(VeDate.getStringDateShort())) {
					sb.append("今天");
				} else if (value.equals(VeDate.getNextDay(
						VeDate.getStringDateShort(), "1"))) {
					sb.append("明天");
				} else if (value.equals(VeDate.getNextDay(
						VeDate.getStringDateShort(), "2"))) {
					sb.append("后天");
				}
			}
		}
		return sb.toString();
	}
	
	
	/**
	 * 格式化日期显示
	 * @param value
	 * @param format
	 * @param isyear true 显示
	 * @param  istoday true 显示 今天明天 或者后天
	 * @param isweek true 显示
	 * @param istime true显示HH:mm
	 * @return
	 */
	public String formatDateShwo(String value, String format, boolean isyear, boolean istoday,
                                 boolean isweek, boolean istime, boolean isformatmonth) {
		StringBuilder sb = new StringBuilder();
		if(StringUtils.isNotBlank(value)){
			SimpleDateFormat sdf=new SimpleDateFormat(format);
			Calendar calendar=Calendar.getInstance();
			try {
				calendar.setTime(sdf.parse(value));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (isyear) {
				sb.append(calendar.get(Calendar.YEAR) + "年");
			} 
			
			if(isformatmonth){
				int month = calendar.get(Calendar.MONTH)+1;
				
				String result = month+"";
			
					
				
				sb.append(result + "月" + formatT(calendar.get(Calendar.DAY_OF_MONTH)) + "日 ");
			}else{
				
				sb.append((formatT(calendar.get(Calendar.MONTH)+1)) + "月" + formatT(calendar.get(Calendar.DAY_OF_MONTH)) + "日 ");
			}
			
			
			if (isweek) {
				if(istoday){
					if (value.equals(VeDate.getStringDateShort())) {
						sb.append("今天");
					} else if (value.equals(VeDate.getNextDay(
							VeDate.getStringDateShort(), "1"))) {
						sb.append("明天");
					} else if (value.equals(VeDate.getNextDay(
							VeDate.getStringDateShort(), "2"))) {
						sb.append("后天");
					}
					
				}
				sb.append(formatWeek(calendar.get(Calendar.DAY_OF_WEEK)) + " ");
			}
			if(istime){
				sb.append(formatT(calendar.get(Calendar.HOUR_OF_DAY))+":"+formatT(calendar.get(Calendar.MINUTE))+" ");
			}
			
		}
		return sb.toString();
	}
	private String formatT(int t){
		String result = "";
		if(t <10){
			result = "0"+ t;
		}else{
			result = "" + t;
		}
		return result;
	}
	
	/**
	 * 去掉小数部分的0
	 * @param dou
	 * @return
	 */
	public static String formatZero(double dou) {
		String str = String.valueOf(dou);
		String[] strarr = str.split("\\.");
		if (strarr.length > 1) {
			if (Double.parseDouble(strarr[1]) != 0) {
				return str;
			} else {
				return strarr[0];
			}
		} else {
			return str;
		}
	}
	/**
	 * 去掉小数部分的0
	 * @param str
	 * @return
	 */
	public String formatZero(String str) {
		if(StringUtils.isBlank(str)){
			return "";
		}
		String[] strarr = str.split("\\.");
		if (strarr.length > 1) {
			if (Double.parseDouble(strarr[1]) != 0) {
				return str;
			} else {
				return strarr[0];
			}
		} else {
			return str;
		}
	}
	/**
	 * map 转 xml
	 * @param map
	 * @return
	 */
	public String mapToXML(Map map) {
		if (map == null) {
			return "";
		}
		String str = "<Data>";
		Set set = map.keySet();
		Iterator i = set.iterator();
		while (i.hasNext()) {
			String key = i.next().toString();
			str += "<" + key + ">";
			str += map.get(key).toString();
			str += "</" + key + ">";
		}
		str += "</Data>";
		return str;
	}
	
	/**
	 * 校验 订单 是否有效
	 * 
	 * @param day
	 *            日期 格式为：YYYY-MM-DD
	 * @param time
	 *            格式为： HH:MM
	 * @return ture 有效
	 */
	protected static  boolean checkOrderTime(String day, String time) {
		if (StringUtils.isNotBlank(day)) {
			try {
				String destance = VeDate.getTwoDay(day,
						VeDate.getStringDateShort());
				if (StringUtils.isNotBlank(destance)) {
					double poor = Double.parseDouble(StringUtils
							.trimToEmpty(destance));
					if (poor > 0) {
						return true;
					} else if (poor == 0) {
						double poor2 = VeDate.getTwoHourD(time,
								VeDate.getTimeHourMin());
						if (poor2 > 0) {
							return true;
						}
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				return true;
			}
		}
		return false;
	}
	/**
	 * 
	 * @param staue
	 * @return
	 */
	public static String getPayStaue(String staue){
		if("1".equals(staue)){//后台工作人员调度到相应部门处理
			return "已支付";
		}else if("0".equals(staue)){//退改专员调度到相应部门处理。
			return "未支付";
		}
		return staue;
	}
	
	/**
	 * 行程单  配送 状态
	 * @param status
	 * @return
	 */
	public static String get_delivery_status(String status){
		if("0".equals(status)){
			return "待送未送";
		}else if("1".equals(status)){
			return "自取未取";
		}else if("2".equals(status)){
			return "待送送中";
		}else if("3".equals(status)){
			return "部分配送";
		}else if("4".equals(status)){
			return "完成配送";
		}else if("5".equals(status)){
			return "自取已取";
		}else if("6".equals(status)){
			return "自办未通知";
		}else if("7".equals(status)){
			return "自办已通知";
		}
		return "";
	}
	/**
	 * 行程单  配送 类型
	 * @param type
	 * @return
	 */
	public static String get_delivery_type(String type){
		if("4".equals(type)){
			return "机场自取";
		}else if("1".equals(type)){
			return "无需配送";
		}else if("2".equals(type)){
			return "市内配送";
		}else if("3".equals(type)){
			return "市内自取";
		}
		return "";
	}
	public String getFlyTime(String flyTime) {
		if(flyTime != null){
			String[] s = flyTime.split(":");
			if(s.length == 2 ){
				int hour = 0;
				int minute = 0;
				try {
					hour = Integer.parseInt(s[0]);
					minute = Integer.parseInt(s[1]);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				if(0==hour && 0==minute){
					return "";
				}else if(0==minute){
					return "飞行: "+s[0]+"小时";
				}else if(0==hour){
					return "飞行: "+s[1]+"分钟";
				}
				return "飞行: "+hour+"小时"+minute+"分钟";
			}
		}
		return flyTime;
	}

}
