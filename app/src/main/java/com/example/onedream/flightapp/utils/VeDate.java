package com.example.onedream.flightapp.utils;

/**
 日期类
 */

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.regex.Pattern;


/**
 * 目录：
 * GetOneMonthAgoFirstDay() //获取前一个月第一天
 * GetOneMonthAgoLastDay() //获取前一个月最后一天
 * getStringDateShort()//获取当天时间返回String类型
 * FramteDateStyle("2016年8月15日 周一 今天") return "2016-8-15"
 */

public class VeDate {

	private VeDate() {
	}

	/**
	 * 保留小数位并且进行舍入操作，小数位不足补0
	 * 
	 * @param number
	 *            四舍五入的对像
	 * @param cacle
	 *            保留小数位
	 * @param method
	 *            舍入方式 eg：为4 表示4舍5入
	 * @return
	 */
	public static String round2(String number, String cacle, String method) {
		if (!NumberUtils.isNumber(number) || !NumberUtils.isNumber(cacle)) {
			return "0";
		}
		if (NumberUtils.toDouble(number) == 0) {
			return "0";
		}
		if (NumberUtils.toInt(cacle) < 0) {
			return "0";
		}
		int srfs = 4;

		if (NumberUtils.toInt(method) > 0) {
			srfs = NumberUtils.toInt(method);
		}

		number = round(number, "5");
		int icacle = NumberUtils.toInt(cacle);
		double dnumber = NumberUtils.toDouble(number);

		double x = Math.pow(10, icacle);
		dnumber = Arith.mul(dnumber, x);
		int point = String.valueOf(dnumber).indexOf(".");
		if (point > -1) {
			String xs = String.valueOf(dnumber).substring(point + 1, point + 2);
			if (NumberUtils.toInt(xs) > srfs) {
				dnumber = Math.ceil(dnumber);
			} else {
				dnumber = Math.floor(dnumber);
			}
		}
		String val = String.valueOf(Arith.div(dnumber, x));
		// System.out.println(val);
		val = val.replaceAll("\\.{1}0{1,}$", "");
		return val;
	}

	/**
	 * 保留小数位四舍五入，小数位不足补0
	 * 
	 * @param number
	 *            四舍五入的对像
	 * @param cacle
	 *            保留小数位
	 * @return
	 */
	public static String round(String number, String cacle) {
		if (!NumberUtils.isNumber(number) || !NumberUtils.isNumber(cacle)) {
			return "0";
		}
		if (NumberUtils.toDouble(number) == 0) {
			return "0";
		}
		if (NumberUtils.toInt(cacle) < 0) {
			return "0";
		}
		BigDecimal b = new BigDecimal(number);
		BigDecimal one = new BigDecimal("1");
		return b.divide(one, NumberUtils.toInt(cacle), BigDecimal.ROUND_HALF_UP)
				+ "";
	}

	/**
	 * 验证日期格式 yyyy-mm-dd
	 * 
	 * @param strDate
	 * @return [参数说明]
	 * 
	 * @return boolean [返回类型说明]
	 * @exception throws [违例类型] [违例说明]
	 * @see [类、类#方法、类#成员]
	 */
	public static boolean isDate(String strDate) {
		return strDate
				.matches("((((19|20)\\d{2})-(0?[13578]|1[02])-"
						+ "(0?[1-9]|[12]\\d|3[01]))|(((19|20)\\d{2})-(0?[469]|11)-"
						+ "(0?[1-9]|[12]\\d|30))|(((19|20)\\d{2})-0?2-(0?[1-9]|1\\d|2[0-8])))");

	}

	/**
	 * 获取现在时间
	 * 
	 * @return 返回时间类型 yyyy-MM-dd HH:mm:ss
	 */
	public static Date getNowDate() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(currentTime);
		ParsePosition pos = new ParsePosition(8);
		Date currentTime_2 = formatter.parse(dateString, pos);
		return currentTime_2;
	}

	/**
	 * 获得当前时间往后的几分钟
	 * @param minute
	 * @return
     */
	public static String getTimeByMinute(int minute) {

		Calendar calendar = Calendar.getInstance();

		calendar.add(Calendar.MINUTE, minute);

		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calendar.getTime());

	}

	/**
	 * 
	 * @return yyyy-MM-dd 获取现在时间
	 * @return返回短时间格式 yyyy-MM-dd
	 */
	public static Date getNowDateShort() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = formatter.format(currentTime);
		ParsePosition pos = new ParsePosition(8);
		Date currentTime_2 = formatter.parse(dateString, pos);
		return currentTime_2;
	}

	/**
	 * 获取现在时间
	 * 
	 * @return返回字符串格式 yyyy-MM-dd HH:mm:ss
	 */
	public static String getStringDate() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(currentTime);
		return dateString;
	}

	/**
	 * 获取现在时间
	 * 
	 * @return 返回短时间字符串格式yyyy-MM-dd
	 */
	public static String getStringDateShort() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = formatter.format(currentTime);
		return dateString;
	}

	/**
	 * 获取现在时间
	 * 
	 * @return 返回短时间字符串格式yyyy-MM-dd HHmm
	 */
	public static String getStringDateShortmm() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HHmm");
		String dateString = formatter.format(currentTime);
		return dateString;
	}

	/**
	 * 获取时间 小时:分;秒 HH:mm:ss
	 * 
	 * @return
	 */
	public static String getTimeShort() {
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
		Date currentTime = new Date();
		String dateString = formatter.format(currentTime);
		return dateString;
	}

	/**
	 * 获取时间 小时:分 HH:mm
	 * 
	 * @return
	 */
	public static String getTimeHourMin() {
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
		Date currentTime = new Date();
		String dateString = formatter.format(currentTime);
		return dateString;
	}

	/**
	 * 将长时间格式字符串转换为时间 yyyy-MM-dd HH:mm:ss
	 * 
	 * @param strDate
	 * @return
	 */
	public static Date strToDateLong(String strDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		ParsePosition pos = new ParsePosition(0);
		Date strtodate = formatter.parse(strDate, pos);
		return strtodate;
	}


	public static long getTwoHoursMinutes(String sj1, String sj2) {
		SimpleDateFormat myFormatter = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm");
		long day = 0;
		try {
			Date date = myFormatter.parse(sj1);
			Date mydate = myFormatter.parse(sj2);
			day = (date.getTime() - mydate.getTime()) / (60 * 1000);
		} catch (Exception e) {
			return 0;
		}
		return day;
	}
	/**
	 * 获取现在时间
	 * 
	 * @return返回字符串格式 yyyy-MM-dd HH:mm
	 */
	public static String getStringDateMinute() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String dateString = formatter.format(currentTime);
		return dateString;
	}
	/**
	 * 将长时间格式时间转换为字符串 yyyy-MM-dd HH:mm:ss
	 * 
	 * @param dateDate
	 * @return
	 */
	public static String dateToStrLong(Date dateDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(dateDate);
		return dateString;
	}

	/**
	 * 将短时间格式时间转换为字符串 yyyy-MM-dd
	 * 
	 * @param dateDate
	 * @return
	 */
	public static String dateToStr(Date dateDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = formatter.format(dateDate);
		return dateString;
	}

	/**
	 * 将短时间格式字符串转换为时间 yyyy-MM-dd HH:mm:ss
	 * 
	 * @param strDate
	 * @return
	 */
	public static Date strToDate(String strDate) {
//		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//		ParsePosition pos = new ParsePosition(0);
//		Date strtodate = formatter.parse(strDate, pos);
		return strToDate(strDate,"yyyy-MM-dd");
	}

	public static Date strToDate(String strDate, String fromat) {
		SimpleDateFormat formatter = new SimpleDateFormat(fromat);
		ParsePosition pos = new ParsePosition(0);
		Date strtodate = formatter.parse(strDate, pos);
		return strtodate;
	}

	/**
	 * 得到现在时间
	 * 
	 * @return
	 */
	public static Date getNow() {
		Date currentTime = new Date();
		return currentTime;
	}

	/**
	 * 提取一个月中的最后一天
	 * 
	 * @param day
	 * @return
	 */
	public static Date getLastDate(long day) {
		Date date = new Date();
		long date_3_hm = date.getTime() - 3600000 * 34 * day;
		Date date_3_hm_date = new Date(date_3_hm);
		return date_3_hm_date;
	}

	/**
	 * 得到现在时间
	 * 
	 * @return 字符串 yyyyMMdd HHmmss
	 */
	public static String getStringToday() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd HHmmss");
		String dateString = formatter.format(currentTime);
		return dateString;
	}

	/**
	 * 得到现在时间
	 * 
	 * @return 字符串 yyyyMMddHHmmss
	 */
	public static String getStringTodayA() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		String dateString = formatter.format(currentTime);
		return dateString;
	}

	/**
	 * 得到现在小时
	 */
	public static String getHour() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(currentTime);
		String hour;
		hour = dateString.substring(11, 13);
		return hour;
	}

	/**
	 * 得到现在分钟
	 * 
	 * @return
	 */
	public static String getTime() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(currentTime);
		String min;
		min = dateString.substring(14, 16);
		return min;
	}

	/**
	 * 根据用户传入的时间表示格式，返回当前时间的格式 如果是yyyyMMdd，注意字母y不能大写。
	 * 
	 * @param sformat
	 *            yyyyMMddHHmmss
	 * @return
	 */
	public static String getUserDate(String sformat) {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat(sformat);
		String dateString = formatter.format(currentTime);
		return dateString;
	}

	/**
	 * 传入的时间和时间表示格式，将时间转换为指定格式 如果是yyyyMMdd，注意字母y不能大写。
	 * 
	 * @param sformat
	 *            yyyyMMddhhmmss
	 * @return
	 */
	public static String getFormatDate(String sformat, String str) {
		if(StringUtils.isBlank(str)){
			return "";
		}
		SimpleDateFormat formatter = new SimpleDateFormat(sformat);
		Date date = strToDateLong(str);
		if(null!=date){
			String dateString = formatter.format(date);
			return StringUtils.isNotBlank(dateString)?dateString:str;
		}
		return str;
	}

	/**
	 * 传入的时间和时间表示格式，将时间转换为指定格式 如果是yyyyMMdd，注意字母y不能大写。
	 *
	 * @param sformat
	 *            yyyyMMddhh
	 * @return
	 */
	public static String getFormatDatemonthandday(String sformat, String str) {
		if(StringUtils.isBlank(str)){
			return "";
		}
		SimpleDateFormat formatter = new SimpleDateFormat(sformat);
		Date date = strToDate(str);
		if(null!=date){
			String dateString = formatter.format(date);
			return StringUtils.isNotBlank(dateString)?dateString:str;
		}
		return str;
	}



	
	/**
	 * 二个小时时间间的差值,必须保证二个时间都是"HH:MM"的格式，返回字符型的分钟
	 * 第一个时间和第二个时间比较,第一个时间大于第二个时间则返回正的分钟数  小于的话返回负的分钟数
	 */
	public static long getTwoHourDM(String st1, String st2) {
		String[] kk = null;
		String[] jj = null;
		kk = StringUtils.isNotBlank(st1)?st1.split(":"):new String[]{"0","0"};
		jj = StringUtils.isNotBlank(st2)?st2.split(":"):new String[]{"0","0"};
		long y = Long.parseLong(kk[0])*60 + Long.parseLong(kk[1]);
		long u = Long.parseLong(jj[0])*60 + Long.parseLong(jj[1]);
		return y - u;
	}
	

	/**
	 * 二个小时时间间的差值,必须保证二个时间都是"HH:MM"的格式，返回字符型的分钟
	 */
	public static double getTwoHourdouble(String st1, String st2) {
		String[] kk = null;
		String[] jj = null;
		kk = st1.split(":");
		jj = st2.split(":");
		if (Integer.parseInt(kk[0]) < Integer.parseInt(jj[0]))
			return 0;
		else {
			double y = Double.parseDouble(kk[0]) + Double.parseDouble(kk[1])
					/ 60;
			double u = Double.parseDouble(jj[0]) + Double.parseDouble(jj[1])
					/ 60;
			if ((y - u) > 0)
				return y - u ;
			else
				return 0;
		}
	}
	
	
	/**
	 * 二个小时时间间的差值,必须保证二个时间都是"HH:MM"的格式，返回字符型的分钟
	 */
	public static String getTwoHour(String st1, String st2) {
		String[] kk = null;
		String[] jj = null;
		kk = st1.split(":");
		jj = st2.split(":");
		if (Integer.parseInt(kk[0]) < Integer.parseInt(jj[0]))
			return "0";
		else {
			double y = Double.parseDouble(kk[0]) + Double.parseDouble(kk[1])
					/ 60;
			double u = Double.parseDouble(jj[0]) + Double.parseDouble(jj[1])
					/ 60;
			if ((y - u) > 0)
				return y - u + "";
			else
				return "0";
		}
	}
	
	/**
	 * 
	 * @param st1 HH:mm
	 * @param st2 HH:mm
	 * @return HH:mm
	 */
	public static String getTwoHourM(String st1, String st2) {
		String[] kk = null;
		String[] jj = null;
		kk = st1.split(":");
		jj = st2.split(":");
		int s1=Integer.parseInt(kk[0])*60 + Integer.parseInt(kk[1]);
		int s2=Integer.parseInt(jj[0])*60 + Integer.parseInt(jj[1]);
		return s1-s2>60?(s1-s2)/60+":"+(s1-s2)%60:s1-s2+"";
	}

	/**
	 * 二个小时时间间的差值,必须保证二个时间都是"HH:MM"的格式，返回字符型的分钟
	 */
	public static long getTwoHourD(String st1, String st2) {
		String[] kk = null;
		String[] jj = null;
		kk = st1.split(":");
		jj = st2.split(":");
		long y = Long.parseLong(kk[0])*60 + Long.parseLong(kk[1]);
		long u = Long.parseLong(jj[0])*60 + Long.parseLong(jj[1]);
		return Math.abs( y - u);
	}

	/**
	 * 二个小时时间间的差值,必须保证二个时间都是"HH:MM"的格式，
	 */
	public static String getTwoHourS(String st1, String st2) {
		String[] kk = null;
		String[] jj = null;
		kk = st1.split(":");
		jj = st2.split(":");
		
		if( Double.parseDouble(kk[0]) ==  Double.parseDouble(jj[0])){
			return Double.parseDouble(kk[1]) -  Double.parseDouble(jj[1]) + "";
		}else{
			return  Double.parseDouble(kk[0]) -  Double.parseDouble(jj[0]) + "";
		}
		
	}
	/**
	 * 二个小时时间间的差值,必须保证二个时间都是"HH:MM"的格式，返回分钟 VIP
	 */
	public static int getMinutesFromTwoHour(String st1, String st2) {
		String[] kk = st1.split(":");
		String[] jj = st2.split(":");
		if (kk.length != 2 || jj.length != 2) {
			return 0;
		}
		int y = NumberUtils.toInt(kk[0], 0) * 60 + NumberUtils.toInt(kk[1], 0);
		int u = NumberUtils.toInt(jj[0], 0) * 60 + NumberUtils.toInt(jj[1], 0);
		return u - y;

	}

	/**
	 * 得到二个日期间的间隔天数 同一个日期返回0
	 */
	public static String getTwoDay(String sj1, String sj2) {
		SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
		long day = 0;
		try {
			Date date = myFormatter.parse(sj1);
			Date mydate = myFormatter.parse(sj2);
			day = (date.getTime() - mydate.getTime()) / (24 * 60 * 60 * 1000);
		} catch (Exception e) {
			return "0";
		}
		return day + "";
	}


	/**
	 * 得到二个日期间的间隔年数 同一个日期返回0
	 */
	public static String getTwoYear(String sj1, String sj2) {
		SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
		long year = 0;
		try {
			Date date = myFormatter.parse(sj1);
			Date mydate = myFormatter.parse(sj2);
			year = (date.getTime() - mydate.getTime()) / (24 * 60 * 60 * 1000)/365;
		} catch (Exception e) {
			return "";
		}
		return year + "";
	}

	/**
	 * 得到二个日期间的间隔天数 同一个日期返回0
	 */
	public static String getTwoDayTypeMin(String sj1, String sj2) {
		SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		long day = 0;
		try {
			Date date = myFormatter.parse(sj1);
			Date mydate = myFormatter.parse(sj2);
			day = (date.getTime() - mydate.getTime()) / (24 * 60 * 60 * 1000);
		} catch (Exception e) {
			return "";
		}
		return day + "";
	}


	/**
	 * 得到二个日期间的间隔小时 同一个日期返回0
	 */
	public static String getTwoDayTypeHour(String sj1, String sj2) {
		SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		long day = 0;
		try {
			Date date = myFormatter.parse(sj1);
			Date mydate = myFormatter.parse(sj2);
			day = (date.getTime() - mydate.getTime()) / ( 60 * 60 * 1000);
		} catch (Exception e) {
			return "";
		}
		return day + "";
	}


	/**
	 * 得到二个日期间的间隔分钟
	 */
	public static String getTwoMil(String sj1, String sj2) {
		SimpleDateFormat myFormatter = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		long day = 0;
		try {
			Date date = myFormatter.parse(sj1);
			Date mydate = myFormatter.parse(sj2);
			day = (date.getTime() - mydate.getTime()) / (60 * 1000);
		} catch (Exception e) {
			return "";
		}
		return day + "";
	}

	/**
	 * 得到二个日期间的间隔分钟
	 */
	public static String getTwoMin(String sj1, String sj2) {
		SimpleDateFormat myFormatter = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm");
		long day = 0;
		try {
			Date date = myFormatter.parse(sj1);
			Date mydate = myFormatter.parse(sj2);
			day = (date.getTime() - mydate.getTime()) / (60 * 1000);
		} catch (Exception e) {
			return "";
		}
		return day + "";
	}

	/**
	 * 得到二个日期间的间隔分钟
	 */
	public static long getTwoMil_long(String sj1, String sj2) {
		SimpleDateFormat myFormatter = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		long day = 0;
		try {
			Date date = myFormatter.parse(sj1);
			Date mydate = myFormatter.parse(sj2);
			day = (date.getTime() - mydate.getTime()) / (60 * 1000);
		} catch (Exception e) {
			return 0;
		}
		return day;
	}

	/**
	 * 时间前推或后推分钟,其中JJ表示分钟.
	 */
	public static String getPreTime(String sj1, String jj) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String mystartDate = "";
		try {
			Date startDate = format.parse(sj1);
			long Time = (startDate.getTime() / 1000) + Integer.parseInt(jj)
					* 60;
			startDate.setTime(Time * 1000);
			mystartDate = format.format(startDate);
		} catch (Exception e) {
		}
		return mystartDate;
	}

	/**
	 * 时间前推或后推分钟,其中JJ表示分钟.
	 */
	public static String getPreTime(String sj1, int jj) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String mystartDate = "";
		try {
			Date startDate = format.parse(sj1);
			long Time = (startDate.getTime() / 1000) + jj * 60;
			startDate.setTime(Time * 1000);
			mystartDate = format.format(startDate);
		} catch (Exception e) {
		}
		return mystartDate;
	}

	/**
	 * 判断一个给定的日期字符串是否符合给定的格式，并且是有效的日期
	 * 
	 * @param date
	 *            给定的日期字符串
	 * @param format
	 *            要求的日期格式
	 * @return [参数说明]
	 * 
	 * @return boolean 如果符合格式并且是有效的日期返回true 否则返回false
	 * @exception throws [违例类型] [违例说明]
	 * @see [类、类#方法、类#成员]
	 */
	public static boolean isRightDate(String date, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try {
			if (sdf.format(sdf.parse(date)).equalsIgnoreCase(date))
				return true;
			else
				return false;
		} catch (Exception ex) {
			return false;
		}
	}

	/**
	 * 时间前推或后推秒钟,其中JJ表示秒钟.
	 */
	public static String getPreTimesec(String sj1, int jj) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String mystartDate = "";
		try {
			Date startDate = format.parse(sj1);
			long Time = (startDate.getTime() / 1000) + jj;
			startDate.setTime(Time * 1000);
			mystartDate = format.format(startDate);
		} catch (Exception e) {
		}
		return mystartDate;
	}

	/**
	 * 得到一个时间延后或前移几天的时间,nowdate为时间,delay为前移或后延的天数
	 */
	public static String getNextDay(String nowdate, String delay) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String mdate = "";
		Date d = null;
		if (nowdate == null || "".equals(nowdate)) {
			d = new Date();
		} else {
			d = strToDate(nowdate);
		}

		long myTime = (d.getTime() / 1000) + Integer.parseInt(delay) * 24 * 60
				* 60;
		d.setTime(myTime * 1000);
		mdate = format.format(d);
		return mdate;
	}

	// public static float getCurrentTimeMillis(String date){
	// float f=0f;
	// SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	// Date dates=new Date();
	// dates=strToDateLong(date);
	// f=dates.get
	// return 0;
	//
	// }

	/**
	 * 判断是否润年
	 * 
	 * @param ddate
	 * @return
	 */
	public static boolean isLeapYear(String ddate) {

		/**
		 * 详细设计： 1.被400整除是闰年，否则： 2.不能被4整除则不是闰年 3.能被4整除同时不能被100整除则是闰年
		 * 3.能被4整除同时能被100整除则不是闰年
		 */
		Date d = strToDate(ddate);
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(d);
		int year = gc.get(Calendar.YEAR);
		if ((year % 400) == 0)
			return true;
		else if ((year % 4) == 0) {
			if ((year % 100) == 0)
				return false;
			else
				return true;
		} else
			return false;
	}

	/**
	 * 返回美国时间格式 26 Apr 2006
	 * 
	 * @param str
	 * @return
	 */
	public static String getEDate(String str) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		ParsePosition pos = new ParsePosition(0);
		Date strtodate = formatter.parse(str, pos);
		String j = strtodate.toString();
		String[] k = j.split(" ");
		return k[2] + k[1].toUpperCase() + k[5].substring(2, 4);
	}

	/**
	 * 获取一个月的最后一天
	 * 
	 * @param dat
	 * @return
	 */
	public static String getEndDateOfMonth(String dat) {// yyyy-MM-dd
		String str = dat.substring(0, 8);
		String month = dat.substring(5, 7);
		int mon = Integer.parseInt(month);
		if (mon == 1 || mon == 3 || mon == 5 || mon == 7 || mon == 8
				|| mon == 10 || mon == 12) {
			str += "31";
		} else if (mon == 4 || mon == 6 || mon == 9 || mon == 11) {
			str += "30";
		} else {
			if (isLeapYear(dat)) {
				str += "29";
			} else {
				str += "28";
			}
		}
		return str;
	}

	/**
	 * 取得指定月份的第一天
	 *
	 *            String
	 * @return String
	 */
	public static String getMonthBegin(String dat) {
		String str = dat.substring(0, 8);
		return str + "01";
	}

	/**
	 * 判断二个时间是否在同一个周
	 * 
	 * @param startDate
	 * @param endDate2
	 * @return
	 */
	public static boolean isSameWeekDates(Date startDate, Date endDate2) {
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal1.setTime(startDate);
		cal2.setTime(endDate2);
		int subYear = cal1.get(Calendar.YEAR) - cal2.get(Calendar.YEAR);
		if (0 == subYear) {
			if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2
					.get(Calendar.WEEK_OF_YEAR))
				return true;
		} else if (1 == subYear && 11 == cal2.get(Calendar.MONTH)) {
			// 如果12月的最后一周横跨来年第一周的话则最后一周即算做来年的第一周
			if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2
					.get(Calendar.WEEK_OF_YEAR))
				return true;
		} else if (-1 == subYear && 11 == cal1.get(Calendar.MONTH)) {
			if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2
					.get(Calendar.WEEK_OF_YEAR))
				return true;
		}
		return false;
	}

	/**
	 * 产生周序列,即得到当前时间所在的年度是第几周
	 * 
	 * @return
	 */
	public static String getSeqWeek() {
		Calendar c = Calendar.getInstance(Locale.CHINA);
		String week = Integer.toString(c.get(Calendar.WEEK_OF_YEAR));
		if (week.length() == 1)
			week = "0" + week;
		String year = Integer.toString(c.get(Calendar.YEAR));
		return year + week;
	}

	/**
	 * 获得一个日期所在的周的星期几的日期，如要找出2002年2月3日所在周的星期一是几号
	 * 
	 * @param sdate
	 * @param num
	 * @return
	 */
	public static String getWeek(String sdate, String num) {
		// 再转换为时间
		Date dd = VeDate.strToDate(sdate);
		Calendar c = Calendar.getInstance();
		c.setTime(dd);
		if (num.equals("1")) // 返回星期一所在的日期
			c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		else if (num.equals("2")) // 返回星期二所在的日期
			c.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
		else if (num.equals("3")) // 返回星期三所在的日期
			c.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
		else if (num.equals("4")) // 返回星期四所在的日期
			c.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
		else if (num.equals("5")) // 返回星期五所在的日期
			c.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
		else if (num.equals("6")) // 返回星期六所在的日期
			c.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
		else if (num.equals("0")) // 返回星期日所在的日期
			c.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		return new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
	}

	/**
	 * 根据一个日期，返回是星期几的字符串
	 * 
	 * @param sdate
	 * @return
	 */
	public static String getWeek(String sdate) {
		Date date = VeDate.strToDate(sdate);
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return new SimpleDateFormat("EEEE").format(c.getTime());
	}

	/**
	 * 返回英文星期
	 */
	public static String getWeekEn(String sdate) {
		Date date = VeDate.strToDate(sdate);
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return new SimpleDateFormat("EEE", Locale.ENGLISH).format(c.getTime());
	}

	/**
	 * 返回数字星期 星期天是0 星期一是1
	 * 
	 * @param sdate
	 * @return
	 */
	public static int getWeekNum(String sdate) {
		Calendar cal = new GregorianCalendar();
		cal.setTime(strToDate(sdate));
		return cal.get(Calendar.DAY_OF_WEEK) - 1;
	}

	/**
	 * 返回日期的星期
	 * 
	 * @param sdate
	 * @return
	 */
	public static String getWeekXq(String sdate) {
		int w = getWeekNum(sdate);
		String s = "";
		switch (w) {
		case 0:
			s = "星期天";
			break;
		case 1:
			s = "星期一";
			break;
		case 2:
			s = "星期二";
			break;
		case 3:
			s = "星期三";
			break;
		case 4:
			s = "星期四";
			break;
		case 5:
			s = "星期五";
			break;
		case 6:
			s = "星期六";
			break;

		}
		return s;
	}

	/**
	 * 返回日期的周几
	 * 
	 * @param sdate
	 * @return
	 */
	public static String getWeekz(String sdate) {
		int w = getWeekNum(sdate);
		String s = "";
		switch (w) {
		case 0:
			s = "周日";
			break;
		case 1:
			s = "周一";
			break;
		case 2:
			s = "周二";
			break;
		case 3:
			s = "周三";
			break;
		case 4:
			s = "周四";
			break;
		case 5:
			s = "周五";
			break;
		case 6:
			s = "周六";
			break;

		}
		return s;
	}

	/**
	 * 返回日期的周几
	 * 
	 * @param sdate
	 * @return
	 */
	public static String getWeekz1(String sdate) {
		int w = getWeekNum(sdate);
		String s = "";
		switch (w) {
		case 0:
			s = "日";
			break;
		case 1:
			s = "一";
			break;
		case 2:
			s = "二";
			break;
		case 3:
			s = "三";
			break;
		case 4:
			s = "四";
			break;
		case 5:
			s = "五";
			break;
		case 6:
			s = "六";
			break;

		}
		return s;
	}
	
	/**
	 * 将秒转换为XX：XX：XX形式
	 * @param time
	 * @return
	 */
	public static String secToTime(int time) {
		String timeStr = null;
		int hour = 0;
		int minute = 0;
		int second = 0;
		if (time <= 0)
			return "00:00:00";
		else {
			minute = time / 60;
			if (minute < 60) {
				second = time % 60;
				timeStr ="00:" + unitFormat(minute) + ":" + unitFormat(second);
			} else {
				hour = minute / 60;
				if (hour > 99)
					return "99:59:59";
				minute = minute % 60;
				second = time - hour * 3600 - minute * 60;
				timeStr = unitFormat(hour) + ":" + unitFormat(minute) + ":"
						+ unitFormat(second);
			}
		}
		return timeStr;
	}
	
	public static String unitFormat(int i) {
		String retStr = null;
		if (i >= 0 && i < 10)
			retStr = "0" + Integer.toString(i);
		else
			retStr = "" + i;
		return retStr;
	}
	

	/**
	 * 两个时间之间的天数
	 * 
	 * @param startDate
	 * @param endDate2
	 * @return
	 */
	public static long getDays(String startDate, String endDate2) {
		if (startDate == null || startDate.equals(""))
			return 0;
		if (endDate2 == null || endDate2.equals(""))
			return 0;
		// 转换为标准时间
		SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		Date mydate = null;
		try {
			date = myFormatter.parse(startDate);
			mydate = myFormatter.parse(endDate2);
		} catch (Exception e) {
		}
		long day = (date.getTime() - mydate.getTime()) / (24 * 60 * 60 * 1000);
		return day;
	}

	/**
	 * 判断一个日期是否在两个日期之间
	 * 
	 * @param startDate
	 *            起始日期范围
	 * @param endDate
	 *            结束日期范围
	 * @param checkDate
	 *            被判断的日期
	 * 
	 * @return Boolean 在时间段内返回True
	 * @exception throws [违例类型] [违例说明]
	 * @see [类、类#方法、类#成员]
	 */
	public static Boolean checkDateInScope(String startDate, String endDate,
                                           String checkDate) {
		return checkDateInScope(startDate,endDate,checkDate,0);
	}



	/**
	 * 判断一个日期是否在两个日期之间
	 *
	 * @param startDate
	 *            起始日期范围
	 * @param endDate
	 *            结束日期范围
	 * @param checkDate
	 *            被判断的日期
	 *  @param         model
	 *         应用场景 0在两个日期之间 不包含起始时间  1在两个日期之间 包含起始时间
	 * @return Boolean 在时间段内返回True
	 * @exception throws [违例类型] [违例说明]
	 * @see [类、类#方法、类#成员]
	 */
	public static Boolean checkDateInScope(String startDate, String endDate,
                                           String checkDate, int model) {
		if (!"".equals(startDate) && !"".equals(endDate)
				&& !"".equals(checkDate)) {
			// 转换为标准时间
			SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
			Date mystartDate = null;
			Date myendDate = null;
			Date mycheckDate = null;
			try {
				mystartDate = myFormatter.parse(startDate);
				myendDate = myFormatter.parse(endDate);
				mycheckDate = myFormatter.parse(checkDate);
			} catch (Exception e) {
				e.printStackTrace();
			}
			// 在时间段之内返回true
			if(model == 0){
				if (mycheckDate.getTime() > mystartDate.getTime()
						&& mycheckDate.getTime() < myendDate.getTime()) {
					return true;
				}
			}else{
				if (mycheckDate.getTime() >= mystartDate.getTime()
						&& mycheckDate.getTime() <= myendDate.getTime()) {
					return true;
				}
			}


		}

		return false;
	}

	/**
	 * 形成如下的日历 ， 根据传入的一个时间返回一个结构 星期日 星期一 星期二 星期三 星期四 星期五 星期六 下面是当月的各个时间
	 * 此函数返回该日历第一行星期日所在的日期
	 * 
	 * @param sdate
	 * @return
	 */
	public static String getNowMonth(String sdate) {
		// 取该时间所在月的一号
		sdate = sdate.substring(0, 8) + "01";

		// 得到这个月的1号是星期几
		Date date = VeDate.strToDate(sdate);
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int u = c.get(Calendar.DAY_OF_WEEK);
		String newday = VeDate.getNextDay(sdate, (1 - u) + "");
		return newday;
	}

	/** 给定两个时间相差的月数,String版* */
	public static int monthsBetween(String pLatterStr, String pFormerStr) {
		GregorianCalendar vFormer = parse2Cal(pFormerStr);
		GregorianCalendar vLatter = parse2Cal(pLatterStr);
		return monthsBetween(vLatter, vFormer);
	}

	public static int monthsBetween(GregorianCalendar pLatter,
			GregorianCalendar pFormer) {
		GregorianCalendar vFormer = pFormer, vLatter = pLatter;
		boolean vPositive = true;
		if (pFormer.before(pLatter)) {
			vFormer = pFormer;
			vLatter = pLatter;
		} else {
			vFormer = pLatter;
			vLatter = pFormer;
			vPositive = false;
		}

		int vCounter = 0;
		while (vFormer.get(Calendar.YEAR) != vLatter.get(Calendar.YEAR)
				|| vFormer.get(Calendar.MONTH) != vLatter.get(Calendar.MONTH)) {
			vFormer.add(Calendar.MONTH, 1);
			vCounter++;
		}
		if (vPositive)
			return vCounter;
		else
			return -vCounter;
	}

	/** 将字符串格式的日期转换为Calender* */
	public static GregorianCalendar parse2Cal(String pDateStr) {
		StringTokenizer sToken;
		sToken = new StringTokenizer(pDateStr, "-");
		int vYear = Integer.parseInt(sToken.nextToken());
		// GregorianCalendar的月份是从0开始算起的，变态！！
		int vMonth = Integer.parseInt(sToken.nextToken()) - 1;
		int vDayOfMonth = Integer.parseInt(sToken.nextToken());
		return new GregorianCalendar(vYear, vMonth, vDayOfMonth);
	}

	/**
	 * 取得指定日期的下一个月
	 * 
	 * @param dates
	 *            指定日期。
	 * @return 指定日期的下几个月
	 */
	public static String getNextMonth(String dates, int count) {
		Date date = strToDate(dates);
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(date);
		gc.add(Calendar.MONTH, count);

		return dateToStrLong(gc.getTime());
	}

	/**
	 * 取得指定日期的下一个月
	 * 
	 * @param dates
	 *            指定日期。
	 * @return 指定日期的下几个月
	 */
	public static String getNextMonthShort(String dates, int count) {
		Date date = strToDate(dates);
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(date);
		gc.add(Calendar.MONTH, count);

		return dateToStr(gc.getTime());
	}

	
	/**
	 * 几年前的今天
	 * @param dates
	 * @param count
	 * @return
	 */
	public static String getDayForPreYear(String dates, int count){
		Date date = strToDate(dates);
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(date);
		gc.add(Calendar.YEAR, count);

		return dateToStr(gc.getTime());
	}
	
	/**
	 * 毫秒转为时分秒
	 * 
	 * @param l
	 * @return
	 */
	public static String formatLongToTimeStr(Long l) {
		long hour = 0;
		long minute = 0;
		long second = 0;

		second = l / 1000;

		if (second > 60) {
			minute = second / 60;
			second = second % 60;
		}
		if (minute > 60) {
			hour = minute / 60;
			minute = minute % 60;
		}

		if (hour == 0 && minute == 0) {
			return second + "秒";
		}
		String s = "";
		if (hour != 0) {
			s = hour + "时";
		}
		return (s + minute + "分" + second + "秒");
	}

	/**
	 * 分转为时分秒
	 * 
	 * @param l
	 * @return
	 */
	public static String formatminuteToTimeStr(Long l) {
		long hour = 0;
		long minute = 0;

		if (l > 60) {
			hour = l / 60;
			minute = l % 60;
		} else {
			minute = l;
		}

		String s = "";
		if (hour != 0) {
			s = hour + "小时";
		}
		return (s + minute + "分");
	}


	/**
	 * 分转为时分秒
	 *
	 * @param l
	 * @return
	 */
	public static String formatminuteToTime(Long l) {
		long hour = 0;
		long minute = 0;

		if (l > 60) {
			hour = l / 60;
			minute = l % 60;
		} else {
			minute = l;
		}

		String s = "";
		if (hour != 0) {
			s = hour + "h";
		}
		return (s + minute + "m");
	}
	/**
	 * 取得数据库主键 生成格式为yyyymmddhhmmss+k位随机数
	 * 
	 * 表示是取几位随机数，可以自己定
	 */

	private static String randString = "";

	/**
	 * 保证一次产生10000个随机数内无重复 平均一秒钟能产生250个随机数
	 */
	public synchronized static String getNo(int k) {
		if (randString.length() > 20000) {
			randString = "";
			System.out.println("清理randString");
		}
		String rno = getNoNo(k);
		while (randString.indexOf(rno + ",") >= 0) {
			rno = getNoNo(k);
		}
		randString += rno + ",";
		return rno;
	}

	private static String getNoNo(int k) {
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return getUserDate("yyMMddHHmmss") + RandomStringUtils.randomNumeric(k);
	}

	/**
	 * 返回一个随机数
	 * 
	 * @param i
	 * @return
	 */
	public static String getRandom(int i) {
		Random jjj = new Random();

		if (i == 0)
			return "";
		String jj = "";
		for (int k = 0; k < i; k++) {
			jj = jj + jjj.nextInt(9);
		}
		return jj;
	}

	/*******************************************************************************************************************
	 * 求下个月的10号
	 ******************************************************************************************************************/
	public static String getNextMonthDay(String sdate, int m) {
		int year = Integer.parseInt(sdate.substring(0, 4));
		int month = Integer.parseInt(sdate.substring(5, 7));
		month = month + m;
		if (month < 0) {
			month = month + 12;
			year = year - 1;
		} else if (month > 12) {
			month = month - 12;
			year = year + 1;
		} else if (month == 0) {
			year = year - 1;
			month = 12;
		}
		String smonth = "";
		if (month < 10)
			smonth = "0" + month;
		else
			smonth = "" + month;
		return year + "-" + smonth + "-10";
	}

	public static String getNumToStr(int k, String le) {
		String kk = k + "";
		String ks = k + "";
		if (kk.length() < le.length()) {
			for (int i = 0; i < (le.length() - ks.length()); i++) {
				kk = "0" + kk;
			}
		}
		return kk;
	}

	/**
	 * 获得本周的最后一天 本周最后一天为星期天 付平 2007-05-31
	 */
	@SuppressWarnings("static-access")
	public static String getWeekLastDate(String newdate) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calBegin = new GregorianCalendar();
		calBegin.setTime(strToDate(newdate));
		calBegin.add(calBegin.DATE,
				(7 - calBegin.get(calBegin.DAY_OF_WEEK)) + 1);
		String WeekLastDate = format.format(calBegin.getTime());
		return WeekLastDate;
	}

	/**
	 * 获得下周的最后一天 李球龙 2007-05-31
	 */
	@SuppressWarnings("static-access")
	public static String getEndWeekDate() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calBegin = new GregorianCalendar();
		calBegin.setTime(new Date());
		calBegin.add(calBegin.DATE,
				(7 - calBegin.get(calBegin.DAY_OF_WEEK)) + 8);
		String endWeekDate = format.format(calBegin.getTime());

		return endWeekDate;
	}

	/**
	 * 传入一个时间,获得下一季度的最后一天 李球龙 2007-05-31
	 */
	public static String getEndQuarter(String date) {// yyyy-mm-dd
		String yy = date.substring(0, 4);
		String month = date.substring(5, 7);
		String dd = date.substring(8);
		if ("01".equals(month) || "02".equals(month) || "03".equals(month)) {
			month = "06";
		} else if ("04".equals(month) || "05".equals(month)
				|| "06".equals(month)) {
			month = "09";
		} else if ("07".equals(month) || "08".equals(month)
				|| "09".equals(month)) {
			month = "12";
		} else if ("10".equals(month) || "11".equals(month)
				|| "12".equals(month)) {
			month = "03";
			Integer year = Integer.parseInt(yy);
			year += 1;
			yy = year.toString();
		}
		String ymd = yy + "-" + month + "-" + dd;

		return getEndDateOfMonth(ymd);
	}

	/**
	 * 传入当前客户的结算方式,得到当前时间的下一个帐期结束时间
	 * 
	 * @param sJsfs
	 * @return String
	 */
	public static String getZkJsrq(String sJsfs) {
		String tempStringDateShort = "";
		if ("105601".equals(sJsfs)) {
			tempStringDateShort = VeDate.getStringDateShort();
		} else if ("105602".equals(sJsfs)) {
			tempStringDateShort = VeDate.getEndWeekDate();
		} else if ("105603".equals(sJsfs)) {
			tempStringDateShort = VeDate.getEndDateOfMonth(VeDate
					.getNextMonthDay(VeDate.getStringDateShort(), 1));
		} else if ("105604".equals(sJsfs)) {
			tempStringDateShort = VeDate.getEndQuarter(VeDate
					.getStringDateShort());
		}
		return tempStringDateShort;
	}

	/**
	 * 取当前的时间偏移时间的时分秒 与endTime成对使用
	 * 
	 * @param date
	 *            当前时间
	 * @param unionMinute
	 * @return String 格式_HH:mm:ss.0000 _代表空格
	 */
	public static String stratTime(Calendar date, int unionMinute) {
		SimpleDateFormat formatter = new SimpleDateFormat(" HH:mm:ss");
		date.add(Calendar.MINUTE, unionMinute);
		return formatter.format(date.getTime()) + ".0000";
	}

	/**
	 * 取当前的时间的时分秒 与endTime成对使用
	 * 
	 * @param date
	 *            当前时间
	 * @return String 格式_HH:mm:ss.999999 _代表空格
	 */
	public static String endTime(Calendar date) {
		SimpleDateFormat formatter = new SimpleDateFormat(" HH:mm:ss");
		return formatter.format(date.getTime()) + ".999999";
	}

	/**
	 * 获得指定月的天数
	 */
	public static int getMonthDay(String dat) {
		String month = dat.substring(5, 7);
		int monthDay = 0;
		int mon = Integer.parseInt(month);
		if (mon == 1 || mon == 3 || mon == 5 || mon == 7 || mon == 8
				|| mon == 10 || mon == 12) {
			monthDay = 31;
		} else if (mon == 4 || mon == 6 || mon == 9 || mon == 11) {
			monthDay = 30;
		} else {
			if (isLeapYear(dat)) {
				monthDay = 29;
			} else {
				monthDay = 28;
			}
		}
		return monthDay;
	}

	/**
	 * 得到指定月的周数
	 */
	public static int getMonthWeek(String year, String month) {
		String getFirst = year + "-" + month + "-01";
		int monthDay = getMonthDay(getFirst); // 这个月有几天
		int firstWeek = getWeekNum(getFirst); // 第一天星期几
		int firsWeekDay = 6 - firstWeek + 1; // 第二周开始日期
		int i = firsWeekDay;
		int monthWeek = 1; // 一个月有几周
		while (i < monthDay) {
			i = i + 7;
			monthWeek++;
		}
		return monthWeek;
	}

	/**
	 * 根据日期得到是这个月的第几周
	 */
	public static int getWeekByDay(String sdate) {
		String getFirst = getMonthBegin(sdate);
		int firstWeek = getWeekNum(getFirst); // 第一天星期几
		int firsWeekDay = 7 - firstWeek; // 第一周有几天

		int td = Integer.valueOf(sdate.substring(8, 10)); // 这天是这个月的第几天

		if (td - firsWeekDay <= 0) {
			return 1;
		} else {
			int a = td - firsWeekDay;
			a = a / 7 + (a % 7 == 0 ? 0 : 1);
			return a + 1;
		}
	}

	/**
	 * 得到指定年月周的日期
	 */
	public static String[] getWeekDat(String year, String month, int week) {
		String[] re = new String[2];
		String firstDay = year + "-" + month + "-01";
		int monthDay = getMonthDay(firstDay);
		int firstWeekEnd = 6 - getWeekNum(firstDay) + 1;

		if (week == 1) {
			re[0] = firstDay;
			re[1] = year + "-" + month + "-0" + firstWeekEnd;
		} else {
			int startWeek = firstWeekEnd + 1 + (week - 2) * 7;
			int endWeek = startWeek + 6; // 第几天
			String start = startWeek + "";
			if (start.length() <= 1) {
				start = "0" + start;
			}
			if (endWeek > monthDay) {
				endWeek = monthDay;
			}
			String end = endWeek + "";
			if (end.length() <= 1) {
				end = "0" + end;
			}
			re[0] = year + "-" + month + "-" + start;
			re[1] = year + "-" + month + "-" + end;
		}
		return re;
	}

	/**
	 * 把一位月日时分秒格式化为2位
	 * 
	 * @param date
	 * @return
	 */
	public static String fmtDate(String date) {
		if (StringUtils.isBlank(date)) {
			return "";
		}
		String str = "";
		String[] yyhh = date.split(" ");
		if (yyhh.length > 0) {// yyyy-mm-dd
			String[] yymmddsz = yyhh[0].split("-");
			for (String s : yymmddsz) {
				if (s.length() == 1) {
					s = "0" + s;
				}
				if ("".equals(str)) {
					str = s;
				} else {
					str += "-" + s;
				}
			}
		}

		if (yyhh.length > 1) {// hh:mm:ss
			str += " ";
			String[] hhmmsssz = yyhh[1].split(":");
			for (int i = 0; i < hhmmsssz.length; i++) {
				String s = hhmmsssz[i];
				if (s.length() == 1) {
					s = "0" + s;
				}
				if (i == 0) {
					str += s;
				} else {
					str += ":" + s;
				}
			}
		}
		return str;
	}

	/**
	 * 2个日期间所跨的周数
	 */
	public static int twoDayWeeks(String ksrq, String jsrq) {
		int allDate = NumberUtils.toInt(VeDate.getTwoDay(jsrq, ksrq)) + 1;
		String sd = ksrq;
		int count = 1;
		for (int i = 1; i < allDate; i++) {
			String d = VeDate.getNextDay(ksrq, i + "");
			if (!VeDate.isSameWeekDates(strToDate(sd), strToDate(d))) {
				count++;
			}
			sd = d;
		}
		return count;
	}

	/**
	 * 用于返回指定日期格式的日期增加指定天数的日期
	 * 
	 * @param appDate
	 *            指定日期
	 * @param format
	 *            指定日期格式yyyy-MM-dd
	 * @param days
	 *            指定天数
	 * @return 指定日期格式的日期增加指定天数的日期
	 */
	public static String getFutureDay(String appDate, String format, int days) {
		String future = "";
		try {
			Calendar calendar = GregorianCalendar.getInstance();
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
			Date date = simpleDateFormat.parse(appDate);
			calendar.setTime(date);
			calendar.add(Calendar.DATE, days);
			date = calendar.getTime();
			future = simpleDateFormat.format(date);
		} catch (Exception e) {
		}
		return future;
	}

	/**
	 * Calendar 转换为字符日期
	 */
	public static String getDateByCalendar(Calendar calendar) {
		String future = "";
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date date = calendar.getTime();
			future = format.format(date);
		} catch (Exception e) {
		}
		return future;
	}

	/**
	 * 格式化成yyyy-MM-dd
	 */
	public static String format(String dateStr) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String date = "";
		Date d = null;
		try {
			d = strToDate(dateStr);
			date = format.format(d);
		} catch (Exception e) {
			date = "";
		}
		if (StringUtils.isEmpty(date) && dateStr.indexOf("-") == -1
				&& dateStr.indexOf("/") == -1 && dateStr.length() >= 8) {
			String year = dateStr.substring(0, 4);
			String monty = dateStr.substring(4, 6);
			String day = dateStr.substring(6, 8);
			dateStr = year + "-" + monty + "-" + day;
			d = strToDate(dateStr);
			date = format.format(d);
		}
		return date;
	}


	public static String formatDate(String dateStr, boolean isYear) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String date = "";
		Date d = null;
		try {
			d = strToDate(dateStr);
			date = format.format(d);
		} catch (Exception e) {
			date = "";
		}
		if (StringUtils.isEmpty(date) && dateStr.indexOf("-") == -1
				&& dateStr.indexOf("/") == -1 && dateStr.length() >= 8) {
			String year = dateStr.substring(0, 4);
			String monty = dateStr.substring(4, 6);
			String day = dateStr.substring(6, 8);
			if (isYear) {
				dateStr = year + "-" + monty + "-" + day;
			}else {
				dateStr = monty + "-" + day;
			}
			d = strToDate(dateStr);
			date = format.format(d);
		}
		return date;
	}


	/**
	 * 获取大写字母随机数
	 * 
	 * @param j
	 * @return [参数说明]
	 * 
	 * @return String [返回类型说明]
	 * @exception throws [违例类型] [违例说明]
	 * @see [类、类#方法、类#成员]
	 */
	public static String getStrRandom(int j) {
		String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		char[] c = s.toCharArray();
		Random random = new Random();
		String ss = "";
		for (int i = 0; i < j; i++) {
			ss = ss + c[random.nextInt(c.length)];
		}
		return ss;
	}

	public static void main(String[] args) {
		System.out.println(VeDate.getUserDate("yyyyMMddHH"));
	}

	// 两点之间的距离
	public static Double getDistatce(double lat1, double lat2, double lon1,
                                     double lon2) {
		double R = 6371;
		double distance = 0.0;
		double dLat = (lat2 - lat1) * Math.PI / 180;
		double dLon = (lon2 - lon1) * Math.PI / 180;
		double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
				+ Math.cos(lat1 * Math.PI / 180)
				* Math.cos(lat2 * Math.PI / 180) * Math.sin(dLon / 2)
				* Math.sin(dLon / 2);
		distance = (2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a))) * R;
		return Arith.round(distance, 2);
	}

	/**
	 * 
	 * @param date
	 *            YYYY-MM-DD
	 * @return
	 */
	public static String getYear(String date) {
		try {
			String temp[] = date.split("-");
			return temp[0].charAt(0) == '0' ? temp[0].charAt(1) + "" : temp[0];
		} catch (Exception e) {
			return "";
		}
	}
	

	/**
	 * 
	 * @param count
	 *           从今年算起，向前或向后算count年
	 * @return
	 */
	public static String[] getYears(int count) {
		Calendar calendar = Calendar.getInstance();
		try {
			List<String> years = new ArrayList<String>();
			calendar.add(Calendar.YEAR , -1);
			if(count  < 0){
				calendar.add(Calendar.YEAR , count);
			}
			for (int i = 0; i <= Math.abs(count); i++) {
				calendar.add(Calendar.YEAR, 1);
				years.add(calendar.get(Calendar.YEAR)+"");
			}
			
			return (String[])years.toArray(new String[years.size()]);
		} catch (Exception e) {
			return new String[]{calendar.get(calendar.YEAR)+ ""};
		}
	}
	
	public static String getHotelDate(String in_date_value, boolean isyear) {
		String hotelDate = getHotelDate(in_date_value, isyear,true, true);

		return hotelDate;
	}
	public static String getHotelDate(String in_date_value, boolean isyear, boolean isweek, boolean istoday) {
		StringBuffer sb = new StringBuffer();
		if(StringUtils.isNotBlank(in_date_value)){
			String temp[] = in_date_value.split("-");
			/*String yeary = temp[0].charAt(0) == '0' ? temp[0].charAt(1) + ""
					: temp[0];
			String month = temp[1].charAt(0) == '0' ? temp[1].charAt(1) + ""
					: temp[1];
			String day = temp[2].charAt(0) == '0' ? temp[2].charAt(1) + ""
					: temp[2];*/
			String yeary = temp[0].charAt(0) == '0' ? temp[0].charAt(1) + ""
					: temp[0];
			String month = temp[1];
			String day =  temp[2];

			if (isyear) {
				sb.append(yeary + "年" + month + "月" + day + "日 ");
			} else {
				sb.append(month + "月" + day + "日 ");
			}
			if(isweek){
				sb.append(DateUtils.getWeekz(in_date_value) + " ");
			}

			if(istoday){
				if (in_date_value.equals(DateUtils.getStringDateShort())) {
					sb.append("今天");
				} else if (in_date_value.equals(DateUtils.getNextDay(
						DateUtils.getStringDateShort(), "1"))) {
					sb.append("明天");
				} else if (in_date_value.equals(DateUtils.getNextDay(
						DateUtils.getStringDateShort(), "2"))) {
					sb.append("后天");
				}

			}


		}
		return sb.toString();
	}

	/**
	 * 返回 2月3日周六  2月3日今天  2月3日周一  2月3日周....
	 * @param in_date_value
     * @return
     */
	public static String getRentcarHotelDate(String in_date_value, boolean isyear) {
		StringBuffer sb = new StringBuffer();
		if(StringUtils.isNotBlank(in_date_value)) {
			String temp[] = in_date_value.split("-");
			String yeary = temp[0].charAt(0) == '0' ? temp[0].charAt(1) + ""
					: temp[0];
			String month = temp[1];
			String day = temp[2];

			if (isyear) {
				sb.append(yeary + "年" + month + "月" + day + "日 ");
			} else {
				sb.append(month + "月" + day + "日 ");
			}

			if (in_date_value.equals(DateUtils.getStringDateShort())) {
				sb.append("今天 ");
			} else {
				sb.append(DateUtils.getWeekz(in_date_value));
			}

		}
		return sb.toString();
	}
	public static String getCalenderDate(String in_date_value, boolean isyear) {
		StringBuffer sb = new StringBuffer();
		if(StringUtils.isNotBlank(in_date_value)){
			String temp[] = in_date_value.split("-");
			/*String yeary = temp[0].charAt(0) == '0' ? temp[0].charAt(1) + ""
					: temp[0];
			String month = temp[1].charAt(0) == '0' ? temp[1].charAt(1) + ""
					: temp[1];
			String day = temp[2].charAt(0) == '0' ? temp[2].charAt(1) + ""
					: temp[2];*/
			String yeary = temp[0].charAt(0) == '0' ? temp[0].charAt(1) + ""
					: temp[0];
			String month = temp[1];
			String day =  temp[2];

			if (isyear) {
				sb.append(yeary + "年" + month + "月" + day + "日 ");
			} else {
				sb.append(month + "月" + day + "日 ");
			}
			sb.append(getWeekDay(in_date_value));
		}
		return sb.toString();
	}

	public static String getTrainChooseDate(String in_date_value, boolean isyear) {
		StringBuffer sb = new StringBuffer();
		if(StringUtils.isNotBlank(in_date_value)){
			String temp[] = in_date_value.split("-");
			/*String yeary = temp[0].charAt(0) == '0' ? temp[0].charAt(1) + ""
					: temp[0];
			String month = temp[1].charAt(0) == '0' ? temp[1].charAt(1) + ""
					: temp[1];
			String day = temp[2].charAt(0) == '0' ? temp[2].charAt(1) + ""
					: temp[2];*/
			String yeary = temp[0].charAt(0) == '0' ? temp[0].charAt(1) + ""
					: temp[0];
			String month = temp[1];
			String day =  temp[2];

			if (isyear) {
				sb.append(yeary + "年" + month + "月" + day + "日 ");
			} else {
				sb.append(month + "月" + day + "日 ");
			}
			sb.append(getWeekXq(in_date_value));
		}
		return sb.toString();
	}
	/**
	 * 返回   02-12  后天
	 * @param in_date_value
	 * @param isyear
     * @return
     */
	public static String getTrainDate(String in_date_value, boolean isyear) {
		String trainDate = getTrainDate(in_date_value, isyear, true);

		return trainDate;
	}


	public static String getTrainDate(String in_date_value, boolean isyear, boolean istoday) {
		StringBuffer sb = new StringBuffer();
		if(StringUtils.isNotBlank(in_date_value)){
			sb.append(getFormateHotelDate(in_date_value,isyear));
			if(istoday){
				sb.append(getWeekDay(in_date_value));
			}


		}
		return sb.toString();
	}

	/**
	 * 获取  周几、今天、明天
	 * @return
     */
	public static String getWeekDay(String in_date_value){
		if (in_date_value.equals(DateUtils.getStringDateShort())) {
			return "今天";
		} else if (in_date_value.equals(DateUtils.getNextDay(
				DateUtils.getStringDateShort(), "1"))) {
			return "明天";
		} else if (in_date_value.equals(DateUtils.getNextDay(
				DateUtils.getStringDateShort(), "2"))) {
			return "后天";
		}else{
			return DateUtils.getWeekz(in_date_value) ;
		}
	}

	/**
	 * 获取日期
	 * @param in_date_value
	 * @return
     */
	public static String getDay(String in_date_value){
		if (in_date_value.equals(DateUtils.getStringDateShort())) {
			return "今天";
		} else if (in_date_value.equals(DateUtils.getNextDay(
				DateUtils.getStringDateShort(), "1"))) {
			return "明天";
		} else if (in_date_value.equals(DateUtils.getNextDay(
				DateUtils.getStringDateShort(), "2"))) {
			return "后天";
		}else{
			return "";
		}
	}
	/**
	 *
	 * @param in_date_value
	 * @param isyear
     * @return 返回-月-日  -年-月-日格式
     */
	public static String getFormateHotelDate(String in_date_value, boolean isyear) {
		StringBuffer sb = new StringBuffer();
		if(StringUtils.isNotBlank(in_date_value)) {
			String temp[] = in_date_value.split("-");
			String yeary = temp[0].charAt(0) == '0' ? temp[0].charAt(1) + ""
					: temp[0];
			String month = temp[1];
			String day = temp[2];
			if (isyear) {
				sb.append(yeary + "年" + month + "月" + day + "日 ");
			} else {
				sb.append(month + "月" + day + "日 ");
			}
		}
		return sb.toString();
	}

	/**
	 *
	 * @param date
	 * @return 返回07:00
	 */
	public static String getHHmm(String date) {
		StringBuffer sb = new StringBuffer();
		if(StringUtils.isNotBlank(date)) {
			if (date.length()>10){
				sb.append(date.substring(11));
			}else {
				sb.append("");
			}
		}
		return sb.toString();
	}

	/**
	 * 判断历史时间是否是今天或昨天，如果是今天，则返回今天;如果是昨天，则返回昨天;都不是则返回null；
	 * @param in_date_value 当前日期  格式 yyyy-MM-dd
	 * @return
     */
	public static String getHistoryDate(String in_date_value){
		if(StringUtils.isNotBlank(in_date_value)){
			if (in_date_value.equals(DateUtils.getStringDateShort())) {
				return "今天";
			} else if (in_date_value.equals(DateUtils.getNextDay(
					DateUtils.getStringDateShort(), "-1"))) {
				return "昨天";
			}
		}
		return null;
	}

	public static String getHotelDateF(String ntdt, boolean year) {
		// TODO Auto-generated method stub
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = formatter.format(ntdt);
		return getHotelDate(dateString, year);
	}
	public static Object travelApprovalFormatDate(String ntdt, String lvdt) {
		return getHotelDateF(ntdt, false)+"至"+getHotelDateF(lvdt, false);
	}
	
	/**
	 * 判断date2 是否大于等于date1
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static boolean CheckDates(String date1, String date2) {
		if (date1 == null || date1.equals(""))
			return false;
		if (date2 == null || date2.equals(""))
			return false;
		// 转换为标准时间
		SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		Date mydate = null;
		try {
			date = myFormatter.parse(date1);
			mydate = myFormatter.parse(date2);
		} catch (Exception e) {
		}
		// "dt1 在dt2前"
		if (date.getTime() <= mydate.getTime()) {
			return true;
		} else {
			return false;
		}
	}
	/**
	 * 
	 * @param s 2014-10-10
	 * @return 2014年10月10日
	 */
	public static String FramatInDate(String s){
		String[] in =s.split("-");
		StringBuilder builder=new StringBuilder();
		String str =builder.append(in[0]).append("年").append(in[1]).append("月").append(in[2]).append("日").toString();
		return str;
	}
	/**
	 * 获取前一个月第一天
	 * @return
	 */
	public static String GetOneMonthAgoFirstDay(){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		//获取前月的第一天
		//获取当前日期 
		Calendar cal_1=Calendar.getInstance();
		cal_1.add(Calendar.MONTH, -1);
		//设置为1号,当前日期既为本月第一天 
		cal_1.set(Calendar.DAY_OF_MONTH,1);
		String firstDay = format.format(cal_1.getTime());
		System.out.println("-----1------firstDay:"+firstDay);
		return firstDay;
	}
	/**
	 * 获取前一个月最后一天
	 * @return
	 */
	public static String GetOneMonthAgoLastDay(){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cale = Calendar.getInstance();
		//设置为1号,当前日期既为本月第一天 
		cale.set(Calendar.DAY_OF_MONTH,0);
		String lastDay = format.format(cale.getTime());
		System.out.println("-----2------lastDay:"+lastDay);
		return lastDay;
	}
	//2016年8月15日 周一 今天
	/**
	 * 
	 * @param str  2016年8月15日 周一 今天
	 * @return 2016-08-15 
	 */
	public static String FramteDateStyle(String str){
		if (StringUtils.isEmpty(str)) {
			return "";
		}
		StringBuilder sbd = new StringBuilder();
		String sub =  str.substring(0, 10);
		Pattern pattern = Pattern.compile("[\\u4E00-\\u9FBF]+");
		for (int i = 0; i < sub.length(); i++) {
			if (pattern.matcher(String.valueOf(sub.charAt(i))).find()) {
				
					sbd.append("-");
					
			}else {
				sbd.append(String.valueOf(sub.charAt(i)));
			}
		}
		StringBuilder sber = new StringBuilder();
		String si[]=sbd.toString().split("-");
		String sme;
		if (1==si[1].length()) {
			sme ="0"+si[1];
		}else {
			sme=si[1];
		}
		sber.append(si[0]+"-").append(sme+"-").append(si[2]);
		
		return sber.toString();
	}

	/**
	 * 获取去年1月1号或明年1月1号
	 * @param count  1  -1
	 * @return
	 */
	public static String getBeforeyearAndAfteryear(int count){

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		if (count < 0){
			calendar.add(Calendar.YEAR, -1);

		}else {
			calendar.add(Calendar.YEAR, 1);
		}

		String date = formatter.format(calendar.getTime());
		StringBuilder sber = new StringBuilder();
		return sber.append(date).append("-").append("01").append("-").append("01").toString();

	}

	/**
	 * 比较两个时间大小，时间格式yyyy-MM-dd
	 * @param s1  开始时间
	 * @param s2  结束时间
	 * @return
	 */
	public static boolean compareTime(String s1, String s2){
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		//获取Calendar实例
		Calendar currentTime = Calendar.getInstance();
		Calendar compareTime = Calendar.getInstance();
		try {
			//把字符串转成日期类型
			currentTime.setTime(df.parse(s1));
			compareTime.setTime(df.parse(s2));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		//利用Calendar的方法比较大小
		return currentTime.compareTo(compareTime) > 0 ? true : false;

	}

	public static String getBeforeOrNextTime(int num){
		SimpleDateFormat sdf =  new SimpleDateFormat("yyyy-MM-dd");
		Date nowDate = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(nowDate);

		//往前推或者往后推n个月
		calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH)+num);
		Date updateDate2 = calendar.getTime();

		return sdf.format(updateDate2);

	}

	/**
	 * 获取当年1月1号
	 * @return
	 */
	public static String getNowYearMonthDate(){

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		String date = formatter.format(calendar.getTime());
		StringBuilder sber = new StringBuilder();
		return sber.append(date).append("-").append("01").append("-").append("01").toString();

	}
}
