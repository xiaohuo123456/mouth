package com.bawei.shenmengkai.myapp;

import android.app.Application;
import android.content.Context;

/*
 * 姓名：沈梦凯
 * 日期：2019／11／27
 * 功能：提供全局上下文
 * */
public class MyApp extends Application {
    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
    }
}
