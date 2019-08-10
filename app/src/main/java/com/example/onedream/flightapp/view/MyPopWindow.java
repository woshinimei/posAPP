package com.example.onedream.flightapp.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

import com.example.onedream.flightapp.R;

public class MyPopWindow extends PopupWindow {
    //全屏显示
    public MyPopWindow(Context context) {
        super(context);
        setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
        setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        setTouchable(true);
        setOutsideTouchable(true);
        setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

    }
    //全屏显示
    public MyPopWindow(View contentView) {
        super(contentView);
        setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
        setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        setContentView(contentView);
        //设置触摸
        setTouchable(false);
        //点击popwindow以外的布局让pop消失
        setOutsideTouchable(true);
        //设置焦点
        setFocusable(true);
        //设置动画
        setAnimationStyle(R.style.pop_anim);
        setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        //点击内部消失
        contentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        //返回消失
        contentView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_BACK){
                        dismiss();
                }
                return false;
            }
        });
    }

    //自定义高宽
    public MyPopWindow(int width, int height) {
        super(width, height);
        setTouchable(true);
        setOutsideTouchable(true);
        setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
    }
}
