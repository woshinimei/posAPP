package com.example.onedream.flightapp.utils;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.text.method.ReplacementTransformationMethod;
import android.widget.EditText;


import org.apache.commons.lang.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Hashtable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 校验公用方法抽取
 * @author win7
 *
 */
public class CheckColumn {
	/**
	 * 正则校验 数字
	 * @param str
	 * @return true 是数字字符串
	 */
	public static boolean isNumeric(String str) {
		Pattern pattern = Pattern.compile("[0-9]*");
		return pattern.matcher(str).matches();
	}

	/**
	 * 正则校验 数字
	 * @param str
	 * @return true 是数字字符串
	 */
	public static boolean isZipCode(String str) {
		Pattern pattern = Pattern.compile("[0-9]{6}");
		return pattern.matcher(str).matches();
	}
	
	/**
	 * 电话校验
	 * @param str
	 * @return
	 */
	public static boolean checkPhone(String str){
		if (StringUtils.isNotBlank(str)){
			str=str.replaceAll(" ","");
		}
		if(StringUtils.isBlank(StringUtils.trimToEmpty(str))){
			return false;
		}else if(!isDigit(str)){
			return false;
		}else if( str.length() < 8 || str.length() > 11){
			return false;
		}
		return true;
	}

	/**
	 * 校验手机号码
	 * @param mobiles
	 * @return
     */
	public static boolean isMobileNO(String mobiles){
//		Pattern p = Pattern.compile("^(0|86|17951)?(13[0-9]|15[012356789]|17[678]|18[0-9]|14[57])[0-9]{8}$");
		Pattern p = Pattern.compile("^(0|86|17951)?(13[0-9]|14[0-9]|15[0-9]|16[0-9]|17[0-9]|18[0-9]|19[0-9])[0-9]{8}$");
		Matcher m = p.matcher(mobiles);
		return m.matches();
	}

	public static boolean checkName(String str){
		Pattern pattern = Pattern.compile("([\u4E00-\u9FA5]+)|([a-zA-Z]+)");
		Matcher matcher = pattern.matcher(StringUtils.trimToEmpty(str));
		return matcher.matches();
	}

	/**
	 * 检查是否为中文
	 * @param str
	 * @return
     */
	public static boolean checkIsZW(String str){

		char[] chars = str.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			char name =  	chars[i];



			Pattern pattern = Pattern.compile("[\u4e00-\u9fa5]");
			Matcher matcher = pattern.matcher(String.valueOf(name));
			if(!matcher.matches()){
				return false;
			}
		}
		return true;

	}

	/**
	 * 校验英文名称
	 * @param str
	 * @return
	 */
	public static boolean checkEName(String... str){



		for (String string : str) {
			Pattern pattern = Pattern.compile("([a-zA-Z]+)/([a-zA-Z]+)");
			Matcher matcher = pattern.matcher(StringUtils.trimToEmpty(string));
			if(!matcher.matches()){
				return false;
			}
		}
		return true;
	}

	/**
	 * 校验  是否是英文
	 * @param str
	 * @return
	 */
	public static boolean checkIsYw(String str){
		char[] chars = str.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			char name =  	chars[i];
			Pattern pattern = Pattern.compile("[a-zA-Z]");
			Matcher matcher = pattern.matcher(StringUtils.trimToEmpty(String.valueOf(name)));
			if(!matcher.matches()){
				return false;
			}
		}
		return true;


	}

	
	public static String checkEname(String str){
		if(StringUtils.isBlank(str)){
			return "英文名不能为空";
		}else if(str.indexOf("/")<1||str.indexOf("/")>=str.length()){
			return "英文名输入格式不对";
		}
		return "";
	}
	
	public static boolean checkEmail(String str){
		if(!StringUtils.isBlank(str)){
			Pattern pattern = Pattern.compile("((([a-zA-Z0-9]+)@([a-zA-Z0-9]+)\\.([a-zA-Z0-9]+))|(([a-zA-Z0-9]+)@([a-zA-Z0-9]+)\\.([a-zA-Z0-9]+)\\.([a-zA-Z0-9]+)))");
			Matcher matcher = pattern.matcher(StringUtils.trimToEmpty(str));
			return matcher.matches();
		}
		return true;
	}
	/**
	 * 校验身份证
	 * @param str
	 * @return
	 */
	public static String checkSFZ(String str){
		if(StringUtils.isBlank(str)){
			return "证件号码不能为空";
		}else{
			try {
				return IDCardValidate(str.replace(" ",""));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "";
			}
		}
	}
	/**
	 * 判断字符串是否全数字
	 * 
	 * @param validString
	 * @return
	 */
	public static boolean isDigit(String validString) {
		if (validString == null)
			return false;
		byte[] tempbyte = validString.getBytes();
		for (int i = 0; i < validString.length(); i++) {
			// by=tempbyte[i];
			if ((tempbyte[i] < 48) || (tempbyte[i] > 57)) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 密码验证（长度大于等于6，不能是纯数字或纯字母）
	 * 返回false表示验证不通过
	 */
	public static boolean checkPassWord(String pw){
		if(StringUtils.isNotBlank(pw)){
//			String reg="^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]$";//6-20位的数字+字母
			String reg= "[0-9]+[a-zA-Z]+[0-9a-zA-Z]*|[a-zA-Z]+[0-9]+[0-9a-zA-Z]*";
			return pw.matches(reg);
		}else{
			return false;
		}
	}

	/**
	 * 密码验证(必须包含大写字母、小写字母和数字6-20)
	 * 返回false表示验证不通过
	 */
	public static boolean checkStrictPassWord(String pw){
		if(StringUtils.isNotBlank(pw)){
			String reg= "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])[a-zA-Z0-9]{6,20}$";
			return pw.matches(reg);
		}else{
			return false;
		}
	}

	/**
	 * 是否全字母
	 */
	public static boolean isEng(String pw){
		if(StringUtils.isNotBlank(pw)){
			String reg="(?![a-zA-Z]+$)$";//字母
			return pw.matches(reg);
		}else{
			return false;
		}
	}
	
	/**
	 * 验证密码所属等级
	 * @param pw
	 * @return
	 */
	public static int checkPassWordLevel(String pw){
		int level=0;
		if(StringUtils.isNotBlank(pw)){
			
			Pattern p1 = Pattern.compile("[a-z]");
			Matcher m1 = p1.matcher(pw);
			if(m1.find()){
				level ++;
			}
			
			Pattern p2 = Pattern.compile("[0-9]");
			Matcher m2 = p2.matcher(pw);
			if(m2.find()){
				level ++;
			}
			
			Pattern p3 = Pattern.compile("[A-Z]");
			Matcher m3 = p3.matcher(pw);
			
			if(m3.find()){
				level ++;
			}
		}
		return level;
	}

	/**
	 * 是否包含数字
	 * @param src
	 * @return true 包含
     */
	public static boolean hasDigit(String src) {
		Pattern p = Pattern.compile("[0-9]");
		Matcher m = p.matcher(src);
		return m.find();
	}
	public static String distinguish(String src) {
	    StringBuilder result = new StringBuilder();

	    Pattern p;
	    Matcher m;

	    p = Pattern.compile("[\u4e00-\u9fa5]");
	    m = p.matcher(src);
	    if (m.find()) {
	    	result.append("有汉字");
	    }

	    p = Pattern.compile("[a-zA-Z]");
	    m = p.matcher(src);
	    if (m.find()) {
	    	result.append("有字母  ");
	    }

	    p = Pattern.compile("[0-9]");
	    m = p.matcher(src);
	    if (m.find()) {
	    	result.append("有数字  ");
	    }

	    p = Pattern.compile("\\p{Punct}");
	    m = p.matcher(src);
	    if (m.find()) {
	    	result.append("有标点符号  ");
	    }
	    return result.toString();
	}

	/**
	 * 效验订单填写  名字
	 * return  为空的时候代表效验通过  不为空代表效验不通过
	 */
	public static String checkOrderEditName(String src1   ){
		if (TextUtils.isEmpty(src1)){
			return "姓名不能为空";
		}else {
			String src = src1.replaceAll(" ","");
			String replace = src.replace("/", "");

			if(TextUtils.isEmpty(src)){

				return "姓名不能为空";

			}else{
				if(checkIsZW(src)){

				}else if(checkIsYw(replace)){
					int i = src.indexOf("/");
					if(i==0||i==src.length()-1||i==-1){

						return  "英文名格式有误,正确格式:aa/bb";
					}




				}else{

					return "姓名格式有误";
				}



			}

		}

		return null;
	}



	/**
	 * 校验输入框属否为空
	 * 
	 * @param editText
	 * @return
	 */
	public static boolean checkEditTextNull(EditText editText) {
		if ("".equals(editText.getText().toString())) {
			return false;
		}
		return true;
	}

	/**
	 * 台胞证号校验
	 * @param IDStr
	 * @return  true  校验成功  false   校验失败
     */
	public static boolean checkTBZ(String IDStr){
		if(StringUtils.isNotBlank(IDStr)){
			Pattern pattern = Pattern.compile("^[0-9]{8}");
			Matcher matcher = pattern.matcher(StringUtils.trimToEmpty(IDStr));
			return matcher.matches();
		}
		return false;

	}

	/**
	 * 台湾通行证校验
	 * @param IDStr
	 * @return  true  校验成功  false   校验失败
	 */
	public static boolean checkTWTXZ(String IDStr){
		if(StringUtils.isNotBlank(IDStr)){
			Pattern pattern = Pattern.compile("^[a-zA-Z]{1}[0-9]{8}");
			Matcher matcher = pattern.matcher(StringUtils.trimToEmpty(IDStr));
			return matcher.matches();
		}
		return false;

	}


	/**
	 * 身份证校验
	 * @param IDStr
	 * @return
	 * @throws ParseException
	 */
	@SuppressLint("SimpleDateFormat")
	private static String IDCardValidate(String IDStr) throws ParseException {
		@SuppressWarnings("unused")
        String errorInfo = "";// 记录错误信息
		String[] ValCodeArr = { "1", "0", "X", "9", "8", "7", "6", "5", "4",
				"3", "2" };
		String[] Wi = { "7", "9", "10", "5", "8", "4", "2", "1", "6", "3", "7",
				"9", "10", "5", "8", "4", "2" };
		String Ai = "";
		// ================ 号码的长度 15位或18位 ================
		// if (IDStr.length() != 15 && IDStr.length() != 18) {
		// errorInfo = "身份证号码长度应该为15位或18位。";
		// return errorInfo;
		// }
		if (IDStr.length() != 18) {
			errorInfo = "身份证号码长度应该为18位!请认真检查";
			return "身份证输入有误！";
		}
		// =======================(end)========================
		// ================ 数字 除最后以为都为数字 ================
		if (IDStr.length() == 18) {
			Ai = IDStr.substring(0, 17);
		} else if (IDStr.length() == 15) {
			Ai = IDStr.substring(0, 6) + "19" + IDStr.substring(6, 15);
		}
		if (isNumeric(Ai) == false) {
			errorInfo = "身份证号码除最后一位外,都应为数字!请认真检查";
			return "身份证输入有误！";
		}
		// =======================(end)========================
		// ================ 出生年月是否有效 ================
		String strYear = Ai.substring(6, 10);// 年份
		String strMonth = Ai.substring(10, 12);// 月份
		String strDay = Ai.substring(12, 14);// 月份
		if (isDataFormat(strYear + "-" + strMonth + "-" + strDay) == false) {
			errorInfo = "身份证生日无效!请认真检查";
			return "身份证输入有误！";
		}
		GregorianCalendar gc = new GregorianCalendar();
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
		if ((gc.get(Calendar.YEAR) - Integer.parseInt(strYear)) > 150
				|| (gc.getTime().getTime() - s.parse(
						strYear + "-" + strMonth + "-" + strDay).getTime()) < 0) {
			errorInfo = "身份证生日不在有效范围!请认真检查";
			return "身份证输入有误！";
		}
		if (Integer.parseInt(strMonth) > 12 || Integer.parseInt(strMonth) == 0) {
			errorInfo = "身份证月份无效!请认真检查";
			return "身份证输入有误！";
		}
		if (Integer.parseInt(strDay) > 31 || Integer.parseInt(strDay) == 0) {
			errorInfo = "身份证月份无效!请认真检查";
			return "身份证输入有误！";
		}
		// =====================(end)=====================
		// ================ 地区码时候有效 ================
		Hashtable<String,String> h = GetAreaCode();
		if (h.get(Ai.substring(0, 2)) == null) {
			errorInfo = "身份证地区编码错误!请认真检查";
			return "身份证输入有误！";
		}
		// ==============================================
		// ================ 判断最后一位的值 ================
		int TotalmulAiWi = 0;
		for (int i = 0; i < 17; i++) {
			TotalmulAiWi = TotalmulAiWi
					+ Integer.parseInt(String.valueOf(Ai.charAt(i)))
					* Integer.parseInt(Wi[i]);
		}
		int modValue = TotalmulAiWi % 11;
		String strVerifyCode = ValCodeArr[modValue];
		Ai = Ai + strVerifyCode;
		if (IDStr.length() == 18) {
			if (Ai.equals(IDStr) == false) {
				errorInfo = "身份证无效或者不是合法的身份证号码!";
				return "身份证输入有误！";
			}
		} else {
			return "";
		}
		// =====================(end)=====================
		return "";
	}
	/**
	 * 获取省份 代号
	 * @return
	 */
	private static Hashtable<String,String> GetAreaCode() {
		Hashtable<String,String> hashtable = new Hashtable<String,String>();
		hashtable.put("11", "北京");
		hashtable.put("12", "天津");
		hashtable.put("13", "河北");
		hashtable.put("14", "山西");
		hashtable.put("15", "内蒙古");
		hashtable.put("21", "辽宁");
		hashtable.put("22", "吉林");
		hashtable.put("23", "黑龙江");
		hashtable.put("31", "上海");
		hashtable.put("32", "江苏");
		hashtable.put("33", "浙江");
		hashtable.put("34", "安徽");
		hashtable.put("35", "福建");
		hashtable.put("36", "江西");
		hashtable.put("37", "山东");
		hashtable.put("41", "河南");
		hashtable.put("42", "湖北");
		hashtable.put("43", "湖南");
		hashtable.put("44", "广东");
		hashtable.put("45", "广西");
		hashtable.put("46", "海南");
		hashtable.put("50", "重庆");
		hashtable.put("51", "四川");
		hashtable.put("52", "贵州");
		hashtable.put("53", "云南");
		hashtable.put("54", "西藏");
		hashtable.put("61", "陕西");
		hashtable.put("62", "甘肃");
		hashtable.put("63", "青海");
		hashtable.put("64", "宁夏");
		hashtable.put("65", "新疆");
		hashtable.put("71", "台湾");
		hashtable.put("81", "香港");
		hashtable.put("82", "澳门");
		hashtable.put("91", "国外");
		return hashtable;
	}
	/**
	 * 
	 * @param str
	 * @return
	 */
	private static boolean isDataFormat(String str) {
		boolean flag = false;
		// String
		// regxStr="[1-9][0-9]{3}-[0-1][0-2]-((0[1-9])|([12][0-9])|(3[01]))";
		String regxStr = "^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))(\\s(((0?[0-9])|([1-2][0-3]))\\:([0-5]?[0-9])((\\s)|(\\:([0-5]?[0-9])))))?$";
		Pattern pattern1 = Pattern.compile(regxStr);
		Matcher isNo = pattern1.matcher(str);
		if (isNo.matches()) {
			flag = true;
		}
		return flag;
	}

	public static class AllCapTransformationMethod extends
            ReplacementTransformationMethod {

		@Override
		protected char[] getOriginal() {
			char[] aa = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
					'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
					'w', 'x', 'y', 'z' };
			return aa;
		}

		@Override
		protected char[] getReplacement() {
			char[] cc = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
					'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
					'W', 'X', 'Y', 'Z' };
			return cc;
		}

	}

}
