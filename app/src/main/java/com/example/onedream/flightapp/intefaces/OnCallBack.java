package com.example.onedream.flightapp.intefaces;

public interface OnCallBack<T> {
    void onSucess(T t);
    void onError(String msg);
}
