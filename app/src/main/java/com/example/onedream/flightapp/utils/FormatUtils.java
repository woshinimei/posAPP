package com.example.onedream.flightapp.utils;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.widget.TextView;

import com.example.onedream.flightapp.constant.CacheData;

import org.apache.commons.lang.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;


/**
 * 格式化显示
 * @author win7
 *
 */
public class FormatUtils {



	/**
	 * 判断耗时的显示
	 * 
	 * @param time
	 *            MM:NN
	 * @return
	 */
	public static String chekcTimeConsuming(String time) {
		String result = "";
		String[] arrtime = StringUtils.trimToEmpty(time).split(":");
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
		return result;
	}



	/**
	 * 格式化价格显示
	 * @param dou
	 * @return
	 */
	public static String formatPrice(double dou) {
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
	 * 格式化价格显示
	 * @param str
	 * @return
	 */
	public static String formatPrice(String str) {
		if(str==null){
			return "0";
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
	 * 格式化日期显示
	 * 使用场景：
	 * 	1.酒店查询界面
	 * @param str
	 * @return m月d日
	 */
	public static String formatDate(String str) {
		if(StringUtils.isBlank(str)){
			return "";
		}
		String month = str.split("-")[1];
		String day = str.split("-")[2];

		if (month.startsWith("0")) {
			month = month.substring(1, month.length());
		}
		if (day.startsWith("0")) {
			day = day.substring(1, day.length());
		}

		return month + "月" + day + "日";
	}

	public static String formatDate(String year, String month, String day) {
		if (month.length() < 2) {
			month = "0" + month;
		}
		if (day.length() < 2) {
			day = "0" + day;
		}
		return year + "-" + month + "-" + day;
	}



	
	public static void setTextViewCompoundDrawables(TextView tv, int left, int top, int right, int bottom) {
		Drawable imgLeft = null,imgTop = null,imgRight = null,imgBottom = null;
		if(left>0){
			imgLeft = tv.getContext().getResources().getDrawable(left);
			imgLeft.setBounds(0, 0, imgLeft.getMinimumWidth(), imgLeft.getMinimumHeight());
		}
		if(top>0){
			imgTop = tv.getContext().getResources().getDrawable(top);
			imgTop.setBounds(0, 0, imgTop.getMinimumWidth(), imgTop.getMinimumHeight());
		}
		if(right>0){
			imgRight = tv.getContext().getResources().getDrawable(right);
			imgRight.setBounds(0, 0, imgRight.getMinimumWidth(), imgRight.getMinimumHeight());
		}
		if(bottom>0){
			imgBottom = tv.getContext().getResources().getDrawable(bottom);
			imgBottom.setBounds(0, 0, imgBottom.getMinimumWidth(), imgBottom.getMinimumHeight());
		}
		tv.setCompoundDrawables(imgLeft, imgTop, imgRight, imgBottom);
	}

	/**
	 * 格式化 显示 日期
	 * 
	 * @param value
	 *            YYYY-MM-DD
	 * @param isyear
	 *            是否显示 年份
	 * @param isweek
	 *            是否显示 星期
	 * @return
	 */
	public static String formatDateShwo(String value, boolean isyear, boolean isweek) {
		return formatDateShwo(value, "yyyy-MM-dd", isyear, isweek, false,true);
	}

	public static String formatDateShwo(String value, boolean isyear, boolean isweek, boolean isDayFlag) {
		return formatDateShwo(value, "yyyy-MM-dd", isyear, isweek, false,isDayFlag);
	}
	/**
	 * 格式化日期显示
	 * @param value 要格式显示的数据源
	 * @param format 格式化格式，对数据源处理
	 * @param isyear	是否显示年份
	 * @param isweek	是否显示星期
	 * @param istime	是否显示小时和分钟
	 * @param isDayFlag 是否显示日期标识(今天，明天，后天)
	 * @return
	 */
	@SuppressLint("SimpleDateFormat")
	public static String formatDateShwo(String value, String format, boolean isyear, boolean isweek, boolean istime, boolean isDayFlag) {
		//组装结果
		StringBuilder sb = new StringBuilder();
		if(StringUtils.isNotBlank(value)){
			//格式化日期
			SimpleDateFormat sdf=new SimpleDateFormat(format);
			Calendar calendar=Calendar.getInstance();
			try {
				calendar.setTime(sdf.parse(value));
			} catch (Exception e) {
				e.printStackTrace();
			}
			//如果要显示年份
			if (isyear) {
				sb.append(calendar.get(Calendar.YEAR) + "年");
			}
			//默认显示月份和日期
			sb.append((formatT(calendar.get(Calendar.MONTH)+1)) + "月" + formatT(calendar.get(Calendar.DAY_OF_MONTH)) + "日 ");
			if(CacheData.formattime.equals(format)){
				//如果显示标记，考虑长度位置，就不显示周几
				if(isDayFlag){//如果显示日期标识
					if (value.equals(VeDate.getStringDateShort())) {
						sb.append("今天");
					} else if (value.equals(VeDate.getNextDay(
							VeDate.getStringDateShort(), "1"))) {
						sb.append("明天");
					} else if (value.equals(VeDate.getNextDay(
							VeDate.getStringDateShort(), "2"))) {
						sb.append("后天");
					}else{
						//如果显示星期
						if (isweek) {
							sb.append(formatWeek(calendar.get(Calendar.DAY_OF_WEEK)) + " ");

						}
					}
				}else {
					//如果显示星期
					if (isweek) {
						sb.append(formatWeek(calendar.get(Calendar.DAY_OF_WEEK)) + " ");

					}
				}
			}else if(CacheData.formattimeone.equals(format)) {
				String[] split = value.split(" ");
				String time = split[0];

				if(isDayFlag){//如果显示日期标识
					if (time.equals(VeDate.getStringDateShort())) {
						sb.append("今天 ");
					} else if (time.equals(VeDate.getNextDay(
							VeDate.getStringDateShort(), "1"))) {
						sb.append("明天 ");
					} else if (time.equals(VeDate.getNextDay(
							VeDate.getStringDateShort(), "2"))) {
						sb.append("后天 ");

					}else {
						//如果显示星期
						if (isweek) {
							sb.append(formatWeek(calendar.get(Calendar.DAY_OF_WEEK)) + " ");

						}
					}
				}else {
					//如果显示星期
					if (isweek) {
						sb.append(formatWeek(calendar.get(Calendar.DAY_OF_WEEK)) + " ");

					}
				}
			}
//			//如果显示标记，考虑长度位置，就不显示周几
//			if(isDayFlag){//如果显示日期标识
//				if (value.equals(VeDate.getStringDateShort())) {
//					sb.append("今天");
//				} else if (value.equals(VeDate.getNextDay(
//						VeDate.getStringDateShort(), "1"))) {
//					sb.append("明天");
//				} else if (value.equals(VeDate.getNextDay(
//						VeDate.getStringDateShort(), "2"))) {
//					sb.append("后天");
//				}else{
//					//如果显示星期
//					if (isweek) {
//						sb.append(formatWeek(calendar.get(Calendar.DAY_OF_WEEK)) + " ");
//
//					}
//				}
//			}else{
//				//如果显示星期
//				if (isweek) {
//					sb.append(formatWeek(calendar.get(Calendar.DAY_OF_WEEK)) + " ");
//
//				}
//			}
			//如果显示时分
			if(istime){
				sb.append(formatT(calendar.get(Calendar.HOUR_OF_DAY))+":"+formatT(calendar.get(Calendar.MINUTE)));
			}
		}
		return sb.toString();

	}

	/**
	 * 消息列表时间显示
	 * @param value
	 * @return
     */
	public static String formatMessagerDateShwo(String value){
		//组装结果
		StringBuilder sb = new StringBuilder();
		if(StringUtils.isNotBlank(value)) {
			//格式化日期
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			Calendar calendar = Calendar.getInstance();
			try {
				calendar.setTime(sdf.parse(value));
			} catch (Exception e) {
				e.printStackTrace();
			}
			//标记
			String time=VeDate.dateToStr(calendar.getTime());
			if (time.equals(VeDate.getNextDay(VeDate.getStringDateShort(),"-1"))) {
				sb.append("昨天 ");
			}else if (time.equals(VeDate.getStringDateShort())) {
				sb.append("今天 ");
			} else if (time.equals(VeDate.getNextDay(
					VeDate.getStringDateShort(), "1"))) {
				sb.append("明天 ");
			} else if (time.equals(VeDate.getNextDay(
					VeDate.getStringDateShort(), "2"))) {
				sb.append("后天 ");

			}else {
				//如果要显示年份
//				sb.append(calendar.get(Calendar.YEAR) + "年");
				//默认显示月份和日期
				sb.append((formatT(calendar.get(Calendar.MONTH)+1)) + "月" + formatT(calendar.get(Calendar.DAY_OF_MONTH)) + "日 ");
			}
			sb.append(formatT(calendar.get(Calendar.HOUR_OF_DAY))+":"+formatT(calendar.get(Calendar.MINUTE)));
		}
		return sb.toString();
	}
	/**
	 * 格式化日期显示
	 * @param value 要格式显示的数据源
	 * @param format 格式化格式，对数据源处理
	 * @param isyear	是否显示年份
	 * @param isweek	是否显示星期
	 * @param istime	是否显示小时和分钟
	 * @param isDayFlag 是否显示日期标识(今天，明天，后天)
	 * @return
	 */
	@SuppressLint("SimpleDateFormat")
	public static String formatDateShwoafterminute(String value, String format, boolean isyear, boolean isweek, boolean istime, boolean isDayFlag) {
		//组装结果
		StringBuilder sb = new StringBuilder();
		if(StringUtils.isNotBlank(value)){
			//格式化日期
			SimpleDateFormat sdf=new SimpleDateFormat(format);
			Calendar calendar=Calendar.getInstance();
			try {
				calendar.setTime(sdf.parse(value));
			} catch (Exception e) {
				e.printStackTrace();
			}
			//如果要显示年份
			if (isyear) {
				sb.append(calendar.get(Calendar.YEAR) + "年");
			}
			//默认显示月份和日期
			sb.append((formatT(calendar.get(Calendar.MONTH)+1)) + "月" + formatT(calendar.get(Calendar.DAY_OF_MONTH)) + "日 ");
			//如果显示星期
			if (isweek) {
				sb.append(formatWeek(calendar.get(Calendar.DAY_OF_WEEK)) + " ");}

			//如果显示时分
			if(istime){
				sb.append(formatT(calendar.get(Calendar.HOUR_OF_DAY))+":"+formatT(calendar.get(Calendar.MINUTE))+" ");

			}
			if(CacheData.formattime.equals(format)){
				if(isDayFlag){//如果显示日期标识
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

			}else if(CacheData.formattimeone.equals(format)){
				String[] split = value.split(" ");
			 	   String time =   split[0];


				if(isDayFlag){//如果显示日期标识
					if (time.equals(VeDate.getStringDateShort())) {
						sb.append("今天");
					} else if (time.equals(VeDate.getNextDay(
							VeDate.getStringDateShort(), "1"))) {
						sb.append("明天");
					} else if (time.equals(VeDate.getNextDay(
							VeDate.getStringDateShort(), "2"))) {
						sb.append("后天");

					}
				}

			}



		}
		return sb.toString();

	}

	/**
	 * 格式化周显+今天明天后台标示，，
	 * @param date
	 * @return
	 */
	@SuppressLint("SimpleDateFormat")
	public static String formatWeek(String date){
		StringBuilder sb = new StringBuilder();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar=Calendar.getInstance();
		try {
			calendar.setTime(sdf.parse(date));
			sb.append(formatWeek(calendar.get(Calendar.DAY_OF_WEEK)) + " ");
			if (date.equals(VeDate.getStringDateShort())) {
				sb.append("今天");
			} else if (date.equals(VeDate.getNextDay(
					VeDate.getStringDateShort(), "1"))) {
				sb.append("明天");
			} else if (date.equals(VeDate.getNextDay(
					VeDate.getStringDateShort(), "2"))) {
				sb.append("后天");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		return sb.toString();
	}

	/**
	 *  格式化日期显示,如果是今天，明天或者后天不显示日期
	 * @param value yyyy-MM-dd HH:mm
	 * @param isyear
	 * @param isweek
	 * @param istime
	 * @param isDayFlag
     * @return
     */
	public static String formatDateCarShwo(String value, boolean isyear, boolean isweek, boolean istime, boolean isDayFlag) {
		//组装结果
		StringBuilder sb = new StringBuilder();
		if(StringUtils.isNotBlank(value)){
			//格式化日期
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
			String dayValue="";
			Calendar calendar=Calendar.getInstance();
			try {
				calendar.setTime(sdf.parse(value));
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				dayValue=VeDate.dateToStr(VeDate.strToDate(value));
			} catch (Exception e) {
				e.printStackTrace();
			}
			//如果显示标记，考虑长度位置，就不显示周几
			if(isDayFlag&&StringUtils.isNotBlank(dayValue)){//如果显示日期标识
				if (dayValue.equals(VeDate.getStringDateShort())) {
					sb.append("今天 ");
				} else if (dayValue.equals(VeDate.getNextDay(
						VeDate.getStringDateShort(), "1"))) {
					sb.append("明天 ");
				} else if (dayValue.equals(VeDate.getNextDay(
						VeDate.getStringDateShort(), "2"))) {
					sb.append("后天 ");
				}else{
					//如果显示星期
					if (isweek) {
						sb.append(formatWeek(calendar.get(Calendar.DAY_OF_WEEK)) + " ");

					}
				}
			}else{
				//如果要显示年份
				if (isyear) {
					sb.append(calendar.get(Calendar.YEAR) + "年");
				}
				//默认显示月份和日期
				sb.append((formatT(calendar.get(Calendar.MONTH)+1)) + "月" + formatT(calendar.get(Calendar.DAY_OF_MONTH)) + "日 ");

				//如果显示星期
				if (isweek) {
					sb.append(formatWeek(calendar.get(Calendar.DAY_OF_WEEK)) + " ");

				}
			}
			//如果显示时分
			if(istime){
				sb.append(formatT(calendar.get(Calendar.HOUR_OF_DAY))+":"+formatT(calendar.get(Calendar.MINUTE)));
			}
		}
		return sb.toString();

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
	public static String formatWeek(int week) {
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

	/**
	 * 格式化手机号码显示
	 * @param number
	 * @return
     */
	public static String formatPhoneShow(String number){
		StringBuilder result=new StringBuilder();
		if(StringUtils.isNotBlank(number)){
			String number_no_empt=number.replaceAll(" ","");
			result.append(number_no_empt);
			int[] format_index=new int[]{3,8};
			char[] chars=number_no_empt.toCharArray();
				for(int i=0;i<format_index.length;i++){
					for (int j = 0; j < chars.length; j++) {
						if(j==format_index[i]){
							result.insert(j, ' ');
							break; //结束内层循环
						}
					}
				}
		}
		return result.toString();
	}

	/**
	 *
	 * @param number
	 * @return
     */
	public static String formatCardShow(String number){
		StringBuilder result=new StringBuilder();
		if(StringUtils.isNotBlank(number)){
			result.append(number.replaceAll(" ",""));
			int[] format_index=new int[]{6, 15};
			char[] chars=number.replaceAll(" ","").toCharArray();
			for(int i=0;i<format_index.length;i++){
				for (int j = 0; j < chars.length; j++) {
					if(j==format_index[i]){
						result.insert(j, ' ');
					}
				}
			}
		}
		return result.toString();
	}
	/**
	 * 日期格式，补0
	 * @param t
	 * @return
	 */
	private static String formatT(int t){
		String result = "";
		if(t <10){
			result = "0"+ t;
		}else{
			result = "" + t;
		}
		return result;
	}
	/**
	 * 格式化价格显示
	 * @param dou 正对芒果订单合计统一 保留 小数点0  处理
	 * @return
	 */
	public static String formatdingDanTalPrice(double dou) {
		String str = String.valueOf(dou);
		String[] strarr = str.split("\\.");
		if (strarr.length > 1) {
			if (Double.parseDouble(strarr[1]) != 0) {
				return str;
			} else {


				return str;



			}
		} else {
			return str;
		}
	}

	/**
	 * 格式化优惠券有效期数据显示
	 * @param yxq
	 * @return
     */
	public static String formatCouponsDate(String yxq) {
		StringBuffer sb=new StringBuffer();
		if (StringUtils.isNotBlank(yxq)){
			if (yxq.contains("/")){
				String[] arr=yxq.split("/");
				sb.append(arr[1]);
			}else {
				sb.append(yxq);
			}
			sb.append("到期");
		}
		return sb.toString();
	}
}
