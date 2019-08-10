package com.example.onedream.flightapp.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.example.onedream.flightapp.config.MyApp;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/a/m13.
 */

public abstract class BaseActivity extends AppCompatActivity {
    {
        MyApp.getInstance().addActivity(this);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        String simpleName = getClass().getSimpleName();
        Log.e("-----当前活动在----",simpleName+"");
        ButterKnife.bind(this);
        initView();
    }




    public abstract int getLayout();

    public abstract void initView();

    public void showToast(final String msg) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getBaseContext(), msg, Toast.LENGTH_SHORT).show();
            }
        });

    }



    public Activity getActivity() {
        return this;
    }
}
