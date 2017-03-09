package com.jp.meituan.interfaces.model;

import com.jp.meituan.interfaces.presenter.ILoginPresenter;

/**
 * Created by Administrator on 2017/3/2.
 */

public interface IModel {

    void login(String mobile,String password,ILoginPresenter presenter);
}
