package com.jp.meituan.presenter;

import com.jp.meituan.interfaces.view.ILogin;
import com.jp.meituan.interfaces.model.LoginM;
import com.jp.meituan.interfaces.presenter.Logined;

/**
 * Created by Administrator on 2017/2/28.
 */

public class LoginPresenter implements Logined {
    private  ILogin iLogin;
    private LoginM loginM;

    public LoginPresenter(ILogin iLogin, LoginM loginM){
        this.iLogin = iLogin;
        this.loginM = loginM;
    }

    public void login(String mobile, String password)
    {
        this.loginM.login(mobile, password, this);
    }

    @Override
    public void loginedSuccess(String token) {
        this.iLogin.loginSuccess(token);
    }

    @Override
    public void loginedFailed(String message) {
        this.iLogin.loginFailure(message);
    }

}
