package com.jp.meituan.interfaces.model;

import com.jp.meituan.interfaces.presenter.Logined;

/**
 * Created by Administrator on 2017/3/2.
 */

public interface LoginM {

    /**
     * 用户登录
     *
     * @param mobile
     * @param password
     */
    public void login(String mobile, String password, Logined logined);
}
