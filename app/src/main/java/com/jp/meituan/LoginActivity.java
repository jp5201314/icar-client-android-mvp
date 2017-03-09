package com.jp.meituan;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.jp.meituan.interfaces.view.ILogin;
import com.jp.meituan.presenter.LoginPresenter;
import com.jp.meituan.support.model.LoginO;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements ILogin {

    @BindView(R.id.ibt_back)
    ImageButton ibtBack;
    @BindView(R.id.ibt_more)
    ImageButton ibtMore;
    @BindView(R.id.et_phone_num)
    EditText etPhoneNum;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.btn_login)
    Button btnLogin;

    private LoginPresenter presenter;
//    private RequestParams params;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        ButterKnife.bind(this);
        Log.i("FSLog","onCreate");
        this.presenter = new LoginPresenter(this,new LoginO());
    }



    @OnClick(R.id.btn_login)
    public void login(){
        String mobile = etPhoneNum.getText().toString();
        String password = etPassword.getText().toString();
        if(TextUtils.isEmpty(mobile)){
            return;
        }
        if(TextUtils.isEmpty(password)){
            return;
        }
        // Todo: valid params
        presenter.login(mobile, password);

    }

    @Override
    public void loginSuccess(String str) {
        Toast.makeText( this, "登录成功" + str, Toast.LENGTH_LONG).show();
    }

    @Override
    public void loginFailure(String str) {
        Toast.makeText( this,"登录失败"+str, Toast.LENGTH_LONG).show();
        etPhoneNum.setText("");
        etPassword.setText("");
    }
}
