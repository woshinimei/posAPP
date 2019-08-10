package com.example.onedream.flightapp.response;

import com.example.onedream.flightapp.bean.ControlBean;
import com.example.onedream.flightapp.network.BaseResponse;

import java.util.List;

public class ControlCompanyResponse extends BaseResponse {
    private List<ControlBean> deptInfoList;//调度部门一览

    public List<ControlBean> getDeptInfoList() {
        return deptInfoList;
    }

    public void setDeptInfoList(List<ControlBean> deptInfoList) {
        this.deptInfoList = deptInfoList;
    }
}
