package com.example.onedream.flightapp.utils;

/**
 * 日期类
 * 处理日期格式问题
 */

import android.annotation.SuppressLint;
import android.util.Log;

import org.apache.commons.lang.StringUtils;

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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressLint("SimpleDateFormat")
public class DateUtils {

	public DateUtils() {

	}

/**
 * 获取当前时间
 * */
	public static String getNowTime() {
		//获取当前时间
		Calendar c;
		c = Calendar.getInstance();
		SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd");
		String nowTime = format.format(c.getTime());
		Log.e("--当前时间--",nowTime+"");

		return nowTime;
	}
	/**
	 * 获取n天前时间
	 * */
	public static String getBeforeOfTime(int n) {
		//获取当前时间
		Calendar c;
		c = Calendar.getInstance();
		c.add(Calendar.DAY_OF_MONTH,n);
		SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd");
		String nowTime = format.format(c.getTime());
		Log.e("--n天后时间--",nowTime+"");
		return nowTime;
	}
/**
 * 获取n个月前时间
 * */
	public static String[] getBeforeMonthTime(int n) {
		String [] timeArr = {"",""};
		//获取当前时间
		Calendar c;
		c = Calendar.getInstance();
		SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd");
		String endTime = format.format(c.getTime());
		//获取n个月前时间
		c.add(Calendar.MONTH,n);
		String startTime =format.format(c.getTime());
		Log.e("--当前时间--",endTime);
		Log.e("--n个月前--",startTime);
		timeArr[0] = startTime;
		timeArr[1] = endTime;
		return timeArr;
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
	 * @return 返回短时间字符串格式yyyy-MM-dd HH:MM
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
//	 * @param k
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
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
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
	 *            yyyyMMddhhmmss
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
		SimpleDateFormat formatter = new SimpleDateFormat(sformat);
		Date date = strToDateLong(str);
		String dateString = formatter.format(date);
		return dateString;
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
	 * 二个小时时间间的差值,必须保证二个时间都是"HH:MM"的格式，返回整形的分钟
	 */
	public static int getTwoHourInt(String st1, String st2) {
		String[] kk = null;
		String[] jj = null;
		kk = st1.split(":");
		jj = st2.split(":");
		if (Integer.parseInt(kk[0]) < Integer.parseInt(jj[0])) {
			return -1;
		} else {
			double y = Double.parseDouble(kk[0]) * 60
					+ Double.parseDouble(kk[1]);
			double u = Double.parseDouble(jj[0]) * 60
					+ Double.parseDouble(jj[1]);
			Log.e("y----u", "y=" + y + " u=" + u + " y-u=" + (y - u));
			return (int) (y - u);
		}
	}

	/**
	 * 得到二个日期间的间隔天数
	 */
	public static String getTwoDay(String sj1, String sj2) {
		SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
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
	 * 得到二个日期间的间隔分钟
	 */
	public static long getTwoMil(String sj1, String sj2) {
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
	 * 将 80（分钟） 转换为 1小20分钟显示
	 *
	 * @param lon
	 * @return
	 */
	public static String getTime(long lon) {
		String hour = "";
		String min = "";
		if (lon >= 60) {
			hour = String.valueOf(lon / 60) + "小时";
		} else {
			return lon + "分钟";
		}

		if (lon % 60 != 0) {
			min = String.valueOf(lon % 60);
		}

		return hour + min;
	}

	/**
	 * 将 80（分钟） 转换为 1:20显示
	 *
	 * @param lon
	 * @return
	 */
	public static String getTimes(long lon) {
		String hour = "";
		String min = "";
		if (lon >= 60) {
			hour = String.valueOf(lon / 60);
		} else {
			min = String.valueOf(lon);
		}

		if (lon % 60 != 0) {
			min = String.valueOf(lon % 60);
		}

		return hour + ":" + min;
	}

	/**
	 * 时间前推或后推分钟,其中JJ表示分钟.
	 */
	public static String getPreTime(String sj1, String jj) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String mydate1 = "";
		try {
			Date date1 = format.parse(sj1);
			long Time = (date1.getTime() / 1000) + Integer.parseInt(jj) * 60;
			date1.setTime(Time * 1000);
			mydate1 = format.format(date1);
		} catch (Exception e) {
		}
		return mydate1;
	}

	/**
	 * 时间前推或后推秒钟,其中JJ表示秒钟.
	 */
	public static String getPreTimesec(String sj1, int jj) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String mydate1 = "";
		try {
			Date date1 = format.parse(sj1);
			long Time = (date1.getTime() / 1000) + jj;
			date1.setTime(Time * 1000);
			mydate1 = format.format(date1);
		} catch (Exception e) {
		}
		return mydate1;
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
//	 * @param strdate
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
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static boolean isSameWeekDates(Date date1, Date date2) {
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal1.setTime(date1);
		cal2.setTime(date2);
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
		Date dd = DateUtils.strToDate(sdate);
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
		Date date = DateUtils.strToDate(sdate);
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return new SimpleDateFormat("EEEE").format(c.getTime());
	}

	/**
	 * 返回英文星期
	 */
	public static String getWeekEn(String sdate) {
		Date date = DateUtils.strToDate(sdate);
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
	 * 两个时间之间的天数
	 *
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static long getDays(String date1, String date2) {
		if (date1 == null || date1.equals(""))
			return 0;
		if (date2 == null || date2.equals(""))
			return 0;
		// 转换为标准时间
		SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		Date mydate = null;
		try {
			date = myFormatter.parse(date1);
			mydate = myFormatter.parse(date2);
		} catch (Exception e) {
		}
		long day = (date.getTime() - mydate.getTime()) / (24 * 60 * 60 * 1000);
		return day;
	}

	/**
	 * 两个时间之间的天数
	 *
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static boolean getDaysCheckIn(String date1, String date2) {
		if (date1 == null || date1.equals(""))
			return false;
		if (date2 == null || date2.equals(""))
			return false;
		// 转换为标准时间
		SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date date = null;
		Date mydate = null;
		try {
			date = myFormatter.parse(date1);
			mydate = myFormatter.parse(date2);
			Log.d("ssss", date + "----" + mydate);
		} catch (Exception e) {
		}
		// "dt1 在dt2前"
		if (date.getTime() > mydate.getTime()) {
			return false;
		} else if (date.getTime() < mydate.getTime()) {

			return true;
		} else {
			return false;
		}
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
		Date date = DateUtils.strToDate(sdate);
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int u = c.get(Calendar.DAY_OF_WEEK);
		String newday = DateUtils.getNextDay(sdate, (1 - u) + "");
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
//	 * @param date
	 *            指定日期。
	 * @return 指定日期的下几个月
	 */
	public static String getNextMonth(String dates, int count) {
		Date date = strToDate(dates);
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(date);
		gc.add(Calendar.MONTH, count);

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
			s = hour + "时";
		}
		return (s + minute + "分");
	}

	/**
	 * 取得数据库主键 生成格式为yyyymmddhhmmss+k位随机数
	 *
	 * 表示是取几位随机数，可以自己定
	 */

	static List<String> randList = new ArrayList<String>();

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
			tempStringDateShort = DateUtils.getStringDateShort();
		} else if ("105602".equals(sJsfs)) {
			tempStringDateShort = DateUtils.getEndWeekDate();
		} else if ("105603".equals(sJsfs)) {
			tempStringDateShort = DateUtils.getEndDateOfMonth(DateUtils
					.getNextMonthDay(DateUtils.getStringDateShort(), 1));
		} else if ("105604".equals(sJsfs)) {
			tempStringDateShort = DateUtils.getEndQuarter(DateUtils
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
//	 * @param unionMinute
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

		int re = (int) Math.floor((td - firsWeekDay + 1) / 7 + 1);

		return re;
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
	 * 格式化时间.
	 *
	 * @param date
	 *            时间.
	 * @param pattern
	 *            格式
	 * @return
	 */
	public static String formatDate(Date date, String pattern) {
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		return format.format(date);

	}

	/**
	 * 解析时间 .
	 *
	 * @param dateString
	 *            日期字符串 .
	 * @param pattern
	 *            格式.
	 * @return
	 * @throws ParseException
	 */
	public static Date parseDate(String dateString, String pattern)
			throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		return format.parse(dateString);
	}

	/**
	 * 将时间字符串在两种格式之前转换. 例如:
	 * fromatDate('2011-1-1','yyyy-MM-dd','yyyy年MM月dd日')返回2011年1月1日.
	 *
	 * @param date
	 *            时间.
	 * @param fromPattern
	 *            源格式.
	 * @param toPattern
	 *            目标格式.
	 * @return
	 * @throws ParseException
	 */
	public static String formatDate(String date, String fromPattern,
                                    String toPattern) throws ParseException {
		return formatDate(parseDate(date, fromPattern), toPattern);
	}

	public static String formatDate(String date) {
		String str[] = date.split("-");
		if (str[1].length() < 2) {
			str[1] = "0" + str[1];
		}
		if (str[2].length() < 2) {
			str[2] = "0" + str[2];
		}
		return str[0] + "-" + str[1] + "-" + str[2];
	}

	/**
	 * 获取n月前的1号日期
	 *
	 * @param n
	 * @return
	 */
	public static String getPreMonthDate(int n) {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, -n);
		c.set(Calendar.DATE, 1);
		return dateToStr(c.getTime());
	}

	/**
	 * 判断日期格式和范围
	 */
	public static boolean isDateFormat(String date) {
		String rexp = "^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))";
		Pattern pat = Pattern.compile(rexp);
		Matcher mat = pat.matcher(date);
		boolean dateType = mat.matches();
		return dateType;
	}

	/**
	 * 获取两个日期的月差
	 *
	 * @param start
	 * @param end
	 * @return
	 */
	public static int getMonthBetween(Date start, Date end) {
		if (start.after(end)) {
			Date t = start;
			start = end;
			end = t;
		}
		Calendar startCalendar = Calendar.getInstance();
		startCalendar.setTime(start);
		Calendar endCalendar = Calendar.getInstance();
		endCalendar.setTime(end);
		Calendar temp = Calendar.getInstance();
		temp.setTime(end);
		temp.add(Calendar.DATE, 1);

		int year = endCalendar.get(Calendar.YEAR)
				- startCalendar.get(Calendar.YEAR);
		int month = endCalendar.get(Calendar.MONTH)
				- startCalendar.get(Calendar.MONTH);

		if ((startCalendar.get(Calendar.DATE) == 1)
				&& (temp.get(Calendar.DATE) == 1)) {
			return year * 12 + month + 1;
		} else if ((startCalendar.get(Calendar.DATE) != 1)
				&& (temp.get(Calendar.DATE) == 1)) {
			return year * 12 + month;
		} else if ((startCalendar.get(Calendar.DATE) == 1)
				&& (temp.get(Calendar.DATE) != 1)) {
			return year * 12 + month;
		} else {
			return (year * 12 + month - 1) < 0 ? 0 : (year * 12 + month);
		}
	}

	/**
	 * 判断日期是否过期 今天除外
	 *
	 * @param date
	 * @return
	 */
	public static boolean isDateDie(Date date) {
		Calendar c1 = Calendar.getInstance();
		c1.add(Calendar.DAY_OF_MONTH, -1);
		Calendar c2 = Calendar.getInstance();
		c2.setTime(date);
		return c1.compareTo(c2) == 1 ? true : false;
	}

	/**
	 * 获取格式化当前时间
	 *
	 * @param format
	 * @return
	 */
	public static String getFormatNow(String format) {
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		String dateString = formatter.format(new Date());
		return dateString;
	}

	/**
	 * 获取n天前的日期 yyyy-MM-dd
	 *
	 * @param n
	 * @return
	 */
	public static String getYesterdayDate(int n) {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DAY_OF_MONTH, -n);
		return dateToStr(c.getTime());
	}

	/**
	 * 获取今天和某个时间的差(分钟)
	 *
	 * @param time
	 * @return
	 */
	public static int getBetweenTime(String time) {
		Date d1 = getNowDateFormat("yyyy-MM-dd HH:mm");
		Date d2 = getStrToDateFormat(getStringDateShort() + " " + time,
				"yyyy-MM-dd HH:mm");
		long temp = d1.getTime() - d2.getTime();
		return (int) (temp / 1000 / 60);
	}

	public static Date getNowDateFormat(String format) {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		String dateString = formatter.format(currentTime);
		ParsePosition pos = new ParsePosition(0);
		Date currentTime_2 = formatter.parse(dateString, pos);
		return currentTime_2;
	}

	public static Date getStrToDateFormat(String strDate, String format) {
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		ParsePosition pos = new ParsePosition(0);
		return formatter.parse(strDate, pos);
	}

	/**
	 * 判断字符串是否为数字
	 *
	 * @param str
	 * @return
	 */
	public static boolean isNumeric(String str) {
		Pattern pattern = Pattern.compile("[0-9]*");
		Matcher isNum = pattern.matcher(str);
		return isNum.matches();
	}
	/**
	 *  判断date2 是否大于等于date1
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
			Log.d("ssss", date+"----"+mydate);
		} catch (Exception e) {
		}
		//"dt1 在dt2前"
		 if (date.getTime() <= mydate.getTime()) {
			 return true;
		 } else{
			 return false;
		 }
	}
}
