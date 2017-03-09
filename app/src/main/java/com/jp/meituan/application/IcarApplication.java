package com.jp.meituan.application;

import android.app.Application;

import cn.finalteam.okhttpfinal.OkHttpFinal;
import cn.finalteam.okhttpfinal.OkHttpFinalConfiguration;

/**
 * Created by Administrator on 2017/3/2.
 */

public class IcarApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        initOkHttpFinal();
    }

    /**
     * 初始化OkHttpFinal
     */
    private void initOkHttpFinal() {
        OkHttpFinalConfiguration.Builder builder = new OkHttpFinalConfiguration.Builder();
        builder.setDebug(true);
        OkHttpFinal.getInstance().init(builder.build());
        OkHttpFinal.getInstance().updateCommonHeader("Accept", "application/json");
    }
}
