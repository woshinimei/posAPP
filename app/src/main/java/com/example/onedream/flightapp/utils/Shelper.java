package com.example.onedream.flightapp.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.onedream.flightapp.constant.AppLocal;

/**
 * 本地缓存工具类
 * */
public class Shelper {
    SharedPreferences sp;
    Context context;

    public Shelper(Context context, String name) {
        this.context = context;
        sp = context.getSharedPreferences(name, Context.MODE_PRIVATE);
    }
    public Shelper(Context context) {
        this.context = context;
        sp = context.getSharedPreferences(AppLocal.USER, Context.MODE_PRIVATE);
    }

    public void save(Contanvlues... values) {
        SharedPreferences.Editor edit = sp.edit();
        for (Contanvlues value : values) {
            if (value.vlaues instanceof String) {
                edit.putString(value.key, (String) value.vlaues);
            } else if (value.vlaues instanceof Integer) {
                edit.putInt(value.key, Integer.parseInt(value.vlaues.toString()));
            } else if (value.vlaues instanceof Boolean) {
                edit.putBoolean(value.key, Boolean.parseBoolean(value.vlaues.toString()));
            }
        }
        edit.commit();
    }

    public int getInt(String key) {
        return sp.getInt(key, -1);
    }

    public int getInt(String key, int defVlues) {
        return sp.getInt(key, defVlues);
    }

    public String getString(String key) {
        return sp.getString(key, null);
    }

    public String getString(String key, String defVlues) {
        return sp.getString(key, defVlues);
    }

    public Boolean getBoolean(String key) {
        return sp.getBoolean(key, false);
    }

    public Boolean getBoolean(String key, Boolean defVlues) {
        return sp.getBoolean(key, defVlues);
    }

    public void clear() {
        sp.edit().clear().commit();
    }

    public static class Contanvlues {
        String key;
        Object vlaues;

        public Contanvlues(String key, Object vlaues) {
            this.key = key;
            this.vlaues = vlaues;
        }


    }
}
