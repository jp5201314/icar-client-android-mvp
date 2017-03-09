package com.jp.meituan.callback;

import com.alibaba.fastjson.JSONObject;

import cn.finalteam.okhttpfinal.JsonHttpRequestCallback;
import okhttp3.Headers;

public class IcarHttpRequestCallBack extends JsonHttpRequestCallback {

    protected boolean autoToastErrorMessage = true;

    public IcarHttpRequestCallBack() {
        this.autoToastErrorMessage = true;
    }

    public IcarHttpRequestCallBack(boolean autoToastErrorMessage) {
        this.autoToastErrorMessage = autoToastErrorMessage;
    }

    @Override
    protected void onSuccess(Headers headers, JSONObject rstJson) {
        int status = rstJson.getInteger("status");

        JSONObject data = null;
        if (rstJson.containsKey("data")) {
            data = rstJson.getJSONObject("data");
        }

        JSONObject statusInfo = null;
        if (rstJson.containsKey("statusInfo")) {
            statusInfo = rstJson.getJSONObject("statusInfo");
        }

        switch (status) {
            case 0:
                onDataSuccess(data);
                break;
            case 10000:
                onDataError(status, statusInfo);
                break;
            case 40000://JWT_TOKEN不存在
            case 40001://JWT_TOKEN不可用
            case 40004://JWT_USER未找到
            case 40005://JWT_TOKEN过期失效
            case 40006://USER_KICKED
                //unAvailableLogin(status);
                break;
            default:
                onDataError(status, statusInfo);
                break;
        }
    }

    protected void onDataSuccess(JSONObject data) {


    }

    protected void onDataError(int status, JSONObject statusInfo) {

    }

}
