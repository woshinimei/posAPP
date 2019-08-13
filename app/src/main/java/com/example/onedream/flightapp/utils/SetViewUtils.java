package com.example.onedream.flightapp.utils;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.onedream.flightapp.config.MyApp;

import org.apache.commons.lang.StringUtils;
import org.xutils.common.Callback;
import org.xutils.ex.HttpException;
import org.xutils.http.RequestParams;
import org.xutils.image.ImageOptions;
import org.xutils.x;

import java.io.File;
import java.lang.reflect.Field;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import cn.qqtheme.framework.picker.DatePicker;



public class SetViewUtils {

	private static String[] months = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
	private static String[] days = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"};

	/**
	 * @param tv
	 * @param value
	 * @return
	 */
	public static boolean setView(TextView tv, String value) {
		return setView(tv, value, "");
	}

	public static boolean setHint(TextView tv, String value) {
		return setHint(tv, value, "");
	}

	public static boolean setView(TextView tv, String value, String defaults) {
		if (null == tv) {
			return false;
		}
		//防止接口，返回null字符串
		tv.setText(StringUtils.isNotBlank(value) && !"null".equals(value) ? value : defaults);
		return true;
	}

	/**
	 * @param iv
	 * @param resId
	 * @return
	 */
	public static boolean setView(ImageView iv, int resId) {
		if (null == iv) {
			return false;
		}
		iv.setImageResource(resId);
		return true;
	}

	public static boolean setHint(TextView tv, String value, String defaults) {
		if (null == tv) {
			return false;
		}
		tv.setHint(StringUtils.isNotBlank(value) ? value : defaults);
		return true;
	}

	/**
	 * @param view
	 * @param ishow
	 */
	public static void setVisible(View view, boolean ishow) {
		if (null == view) {
			return;
		}
		if (ishow) {
			view.setVisibility(View.VISIBLE);
		} else {
			view.setVisibility(View.GONE);
		}
	}



	/**
	 * @param view
	 * @param flag View.VISIBLE,  View.GONE, View.INVISIBLE
	 */
	public static void setVisible(View view, int flag) {
		if (null == view) {
			return;
		}
		view.setVisibility(flag);
	}


	public static void setTextViewCompoundDrawables(TextView tv, int left,
													int top, int right, int bottom) {
		Drawable imgLeft = null, imgTop = null, imgRight = null, imgBottom = null;
		if (left > 0) {
			imgLeft = tv.getContext().getResources().getDrawable(left);
			imgLeft.setBounds(0, 0, imgLeft.getMinimumWidth(),
					imgLeft.getMinimumHeight());
		}
		if (top > 0) {
			imgTop = tv.getContext().getResources().getDrawable(top);
			imgTop.setBounds(0, 0, imgTop.getMinimumWidth(),
					imgTop.getMinimumHeight());
		}
		if (right > 0) {
			imgRight = tv.getContext().getResources().getDrawable(right);
			imgRight.setBounds(0, 0, imgRight.getMinimumWidth(),
					imgRight.getMinimumHeight());
		}
		if (bottom > 0) {
			imgBottom = tv.getContext().getResources().getDrawable(bottom);
			imgBottom.setBounds(0, 0, imgBottom.getMinimumWidth(),
					imgBottom.getMinimumHeight());
		}
		tv.setCompoundDrawables(imgLeft, imgTop, imgRight, imgBottom);
	}
	/**
	 * 设置航空公司图片
	 * @param activity
	 * @param view
	 * @param flightNo 航班号
	 */
	public static void set_img_icon_flight(Activity activity,ImageView view,String flightNo){
		if(null==activity||null==view||StringUtils.isBlank(flightNo)){

			return;
		}
		String imgName = "air_line_" + flightNo.toLowerCase().replace("*","").substring(0,2);
		int imgId =getResourceName(imgName);
		view.setImageBitmap(imgId == 0 ? null: BitmapFactory.decodeResource(activity.getResources(), imgId));

/*
		Glide.with(activity).load(imgId)
				.diskCacheStrategy(DiskCacheStrategy.ALL).into(view);*/
	}
	/**
	 * 获取图片名称获取图片的资源id的方法
	 * int imgId = getResourceName("air_line_mu");
	 * Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(),imgId);
	 * @param imageName
	 * @return
	 */
	public static int getResourceName(String imageName) {
		int resId;
		try {
			resId = MyApp.getInstance().getResources().getIdentifier(imageName.toLowerCase(), "mipmap",MyApp.getInstance().getPackageName());
		} catch (Exception e) {
			e.printStackTrace();
			resId = 0;
		}
		return resId;
	}
}