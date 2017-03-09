package com.jp.meituan.interfaces.view;

/**
 * Created by Administrator on 2017/3/2.
 */

public interface ILoginAcitity {

    void loginSuccess(String token);
    void loginFailure(String errorMsg);
}
