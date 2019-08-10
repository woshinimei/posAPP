package com.example.onedream.flightapp.view;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.onedream.flightapp.R;
import com.example.onedream.flightapp.utils.DisplayUtils;


public class MyDialog extends Dialog {
    View baseView;
    TextView tvContent;
    TextView tvSure;
    TextView tvCancel;

    public MyDialog(Context context) {
        super(context, R.style.mydialog);
        initView();
    }

    public MyDialog(Context context, View layout) {
        super(context, R.style.mydialog);
        setContentView(layout);
       layout.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               dismiss();
           }
       });
    }

    //全屏
    public void showFullScreen() {
        WindowManager.LayoutParams l = getWindow().getAttributes();
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        getWindow().getDecorView().setPadding(0, 0, 0, 0);
        l.width = WindowManager.LayoutParams.MATCH_PARENT;
        l.height = WindowManager.LayoutParams.MATCH_PARENT;
        l.gravity = Gravity.BOTTOM | Gravity.CENTER;
        getWindow().setAttributes(l);
        getWindow().setWindowAnimations(R.style.dialog_anim);
        show();
    }

    public MyDialog(Context context, int themeResId) {
        super(context, themeResId);
        initView();
    }

    private void initView() {
        baseView = getLayoutInflater().inflate(R.layout.dialog_note, null);
        tvContent = baseView.findViewById(R.id.tv_content);
        tvSure = baseView.findViewById(R.id.tv_sure);
        tvCancel = baseView.findViewById(R.id.tv_cancel);

        setContentView(baseView);
    }

    public void setContent(String content) {
        if (!TextUtils.isEmpty(content) && tvContent != null) {
            tvContent.setText(content);
        }
    }

    public void setLeftButtonClickListener(View.OnClickListener onListener) {
        if (tvCancel != null) {
            tvCancel.setOnClickListener(onListener);
        }
    }

    public void setLeftButton(String buttonName) {
        if (tvCancel != null && !TextUtils.isEmpty(buttonName)) {
            tvCancel.setText(buttonName);
        }
    }

    public void setRightButton(String buttonName) {
        if (tvSure != null && !TextUtils.isEmpty(buttonName)) {
            tvSure.setText(buttonName);
        }
    }

    public void setRightButtonClickListener(View.OnClickListener onListener) {
        if (tvSure != null) {
            tvSure.setOnClickListener(onListener);
        }
    }

    public void showPaddingScreen() {
        //获取屏幕宽度
        int widthPixels = getContext().getResources().getDisplayMetrics().widthPixels;
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.width = widthPixels - DisplayUtils.dip2px(getContext(), 50);
        //设置dialog宽度
        getWindow().setAttributes(params);
        show();
    }

//    boolean dis=true;//是否消失标记，true消失（点击即消失），移动为false
//    private PointF last = new PointF();//记录触摸开始时的点，与触摸结束的点击进行比较
//    @Override
//    public boolean onTouch(View v, MotionEvent event) {
//        Log.e("-----","---onTouch--");
//        if(isShowing()){
//            PointF curr = new PointF(event.getX(), event.getY());
//            switch (event.getAction()) {
//                case MotionEvent.ACTION_DOWN:
//                    last.set(curr); //记录触摸开始时的点
//                    break;
//                case MotionEvent.ACTION_MOVE: //计算移动
//                    float deltaX = curr.x - last.x;
//                    float deltaY = curr.y - last.y;
//                    if(Math.abs(deltaX)>10&&Math.abs(deltaY)>10){ //放大计算移动触摸区域，防止点击抖动
//                        dis=false;
//                    }
//                    break;
//                case MotionEvent.ACTION_UP: //触摸结束
//                case MotionEvent.ACTION_POINTER_UP:
//                    if(dis){
//                        dis=true;
//                        dismiss();
//                        return true; //如果消失，没有必要继续传递事件
//                    }else {
//                        dis=true;
//                    }
//                    break;
//            }
//        }
//        return false;
//    }
}
