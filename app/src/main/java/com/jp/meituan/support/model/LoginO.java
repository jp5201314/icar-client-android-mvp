package com.jp.meituan.support.model;

import com.alibaba.fastjson.JSONObject;
import com.jp.meituan.api.Api;
import com.jp.meituan.interfaces.model.LoginM;
import com.jp.meituan.interfaces.presenter.Logined;
import com.jp.meituan.okhttpfinal.IcarHttpRequestCallBack;

import cn.finalteam.okhttpfinal.HttpRequest;
import cn.finalteam.okhttpfinal.RequestParams;

/**
 * Created by Administrator on 2017/3/2.
 */

public class LoginO implements LoginM {
    @Override
    public void login(String mobile, String password, final Logined logined) {
        RequestParams requestParams = new RequestParams();
        requestParams.addFormDataPart("mobile", mobile);
        requestParams.addFormDataPart("password", password);
        HttpRequest.post(Api.LOGIN, requestParams, new IcarHttpRequestCallBack(){
            @Override
            protected void onDataSuccess(JSONObject data) {
                super.onDataSuccess(data);
                String token = data.getString("token");
                logined.loginedSuccess(token);
            }

            @Override
            protected void onDataError(int status, JSONObject statusInfo) {
                super.onDataError(status, statusInfo);
                String msg = statusInfo.getString("message");
                logined.loginedFailed(msg);
            }
        });
    }
}
