package com.example.onedream.flightapp.utils;



import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

public class GsonUtils {
    public static <T> T fromJson(String json,Class<T> tClass){
        Object t =null;
            try {
                JSONObject jsonObject = new JSONObject(json);
                String res = jsonObject.getString("res");
                Gson gson = new Gson();
                 t = gson.fromJson(res, tClass);
            } catch (JSONException e) {
                e.printStackTrace();
            }

        return (T)t;
    }
    public static <T> String getJson(T bean){
        Gson gson = new Gson();
        String json =gson.toJson(bean);
        return json;
    }
}
