package com.jp.meituan.interfaces.presenter;

/**
 * Created by Administrator on 2017/3/2.
 */

public interface Logined {
    public void loginedSuccess(String token);

    public void loginedFailed(String message);
}
