package com.example.onedream.flightapp.config;

import android.app.Activity;
import android.app.Application;

import org.xutils.x;

import java.util.HashSet;
import java.util.Set;


/**
 * Created by Administrator on 2018/4/15/015.
 */

public class MyApp extends Application {
    public static MyApp instance;

    public static MyApp getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        //xutils 初始化
        x.Ext.init(this);
    }


    private Set<Activity> set = new HashSet<>();

    public void addActivity(Activity act) {
        set.add(act);
    }

    public void exit() {
        for (Activity activity1 : set) {
            if (activity1 != null) {
                activity1.finish();
            }
        }

    }
}
