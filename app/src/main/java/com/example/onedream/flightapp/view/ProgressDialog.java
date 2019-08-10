package com.example.onedream.flightapp.view;

import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

import com.example.onedream.flightapp.R;

public class ProgressDialog extends Dialog {
    private ObjectAnimator ob;
    private View baseView;
    public ProgressDialog( Context context) {
        super(context, R.style.mydialog);
        initView();
    }

    private void initView() {
        baseView = getLayoutInflater().inflate(R.layout.dialog_progress_view,null);
        ImageView img =baseView.findViewById(R.id.loading_img);
        startAnimator(img);
        setContentView(baseView);
    }
    private void startAnimator(ImageView img){
        ob = ObjectAnimator.ofFloat(img, "rotation", 0, 360);
        ob.setRepeatCount(-1);
        ob.setInterpolator(new LinearInterpolator());
        ob.setDuration(2000);
        ob.start();
    }

    @Override
    public void dismiss() {
        if (ob!=null){
            ob.end();
        }
        super.dismiss();
    }
}
