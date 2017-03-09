package com.jp.meituan.interfaces.presenter;

/**
 * Created by Administrator on 2017/3/2.
 */

public interface ILoginPresenter {
    void loginedSucess(String token);
    void loginedFailure(String errorMsg);

}
