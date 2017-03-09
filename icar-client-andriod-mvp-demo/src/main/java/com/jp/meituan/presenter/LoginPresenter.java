package com.jp.meituan.presenter;

import com.jp.meituan.LoginActivity;
import com.jp.meituan.interfaces.model.IModel;
import com.jp.meituan.interfaces.presenter.ILoginPresenter;
import com.jp.meituan.interfaces.view.ILoginAcitity;
import com.jp.meituan.support.Model;

/**
 * Created by Administrator on 2017/3/2.
 */

public class LoginPresenter implements ILoginPresenter {
    private IModel iModel;
    private ILoginAcitity iLoginAcitity;

    public  LoginPresenter(ILoginAcitity iLoginAcitity,IModel iModel) {
        this.iLoginAcitity = iLoginAcitity;
        this.iModel = iModel;
    }


    public void login(String mobile, String password) {
        this.iModel.login(mobile, password, this);
    }

    @Override
    public void loginedSucess(String token) {
        iLoginAcitity.loginSuccess(token);
    }

    @Override
    public void loginedFailure(String errorMsg) {
        iLoginAcitity.loginFailure(errorMsg);
    }
}
