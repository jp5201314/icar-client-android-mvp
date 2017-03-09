package com.jp.meituan;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.Toast;

import com.jp.meituan.interfaces.view.ILoginAcitity;
import com.jp.meituan.presenter.LoginPresenter;
import com.jp.meituan.support.Model;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements ILoginAcitity {

    @BindView(R.id.et_phone_num)
    EditText etPhoneNum;
    @BindView(R.id.et_password)
    EditText etPassword;
    private LoginPresenter presenter;
    private String mobile,password;
    private Model model;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        ButterKnife.bind(this);
        model = new Model();
        this.presenter = new LoginPresenter(this,model);
    }

    @OnClick(R.id.btn_login)
    public void btn_login(){
        mobile = etPhoneNum.getText().toString();
        password = etPassword.getText().toString();
        if(TextUtils.isEmpty(mobile)){
            return;
        }
        if(TextUtils.isEmpty(password)){
            return;
        }
        presenter.login(mobile,password);

    }
    @Override
    public void loginSuccess(String token) {
        Toast.makeText(this, " 登陆成功 "+token,Toast.LENGTH_LONG ).show();
    }

    @Override
    public void loginFailure(String errorMsg) {
        Toast.makeText(this, " 登陆失败 "+errorMsg,Toast.LENGTH_LONG ).show();
    }
}
