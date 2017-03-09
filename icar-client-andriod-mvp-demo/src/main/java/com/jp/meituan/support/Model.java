package com.jp.meituan.support;

import com.alibaba.fastjson.JSONObject;
import com.jp.meituan.api.Api;
import com.jp.meituan.callback.IcarHttpRequestCallBack;
import com.jp.meituan.interfaces.model.IModel;
import com.jp.meituan.interfaces.presenter.ILoginPresenter;

import cn.finalteam.okhttpfinal.HttpRequest;
import cn.finalteam.okhttpfinal.RequestParams;

/**
 * Created by Administrator on 2017/3/2.
 */

public class Model implements IModel{

    RequestParams params = new RequestParams();
    @Override
    public void login(String mobile, String password, final ILoginPresenter presenter) {
        params.addFormDataPart("mobile",mobile);
        params.addFormDataPart("password",password);

        HttpRequest.post(Api.URL,params,new IcarHttpRequestCallBack(){
            @Override
            protected void onDataSuccess(JSONObject data) {
                super.onDataSuccess(data);
                String token = data.getString("token");
                presenter.loginedSucess(token);
            }

            @Override
            protected void onDataError(int status, JSONObject statusInfo) {
                super.onDataError(status, statusInfo);
                String errorMsg = statusInfo.getString("message");
                presenter.loginedFailure(errorMsg);
            }
        });
    }
}
