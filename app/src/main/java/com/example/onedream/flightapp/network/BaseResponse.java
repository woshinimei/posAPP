package com.example.onedream.flightapp.network;

import android.text.TextUtils;

public class BaseResponse {
    /**
     * res : {"sts":-1,"erc":"999","emg":"系统异常","tme":0,"syst":0}
     */

    /**
     * sts : -1
     * erc : 999
     * emg : 系统异常
     * tme : 0
     * syst : 0
     */
    private String rtnCode;
    private String message;
    private String sts;
    private String erc;
    private String emg;
    private String tme;
    private String syst;

    public String getRtnCode() {
        return rtnCode;
    }

    public void setRtnCode(String rtnCode) {
        this.rtnCode = rtnCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSts() {
        return sts;
    }

    public void setSts(String sts) {
        this.sts = sts;
    }

    public String getErc() {
        return erc;
    }

    public void setErc(String erc) {
        this.erc = erc;
    }

    public String getEmg() {
        return emg;
    }

    public void setEmg(String emg) {
        this.emg = emg;
    }

    public String getTme() {
        return tme;
    }

    public void setTme(String tme) {
        this.tme = tme;
    }

    public String getSyst() {
        return syst;
    }

    public void setSyst(String syst) {
        this.syst = syst;
    }
    public boolean isSuccess(){
        return  !sts.equals("-1")&&(rtnCode.equals("I000")||rtnCode.equals("1000"));
    }

}
