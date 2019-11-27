package com.bawei.shenmengkai.presenter;

import com.bawei.shenmengkai.base.BasePresenter;
import com.bawei.shenmengkai.icontralt.IContralt;
/*
 * 姓名：沈梦凯
 * 日期：2019／11／27
 * 功能：Presenter层
 * */
public class MyPresenter extends BasePresenter {
    @Override
    public void getData(String url) {
        myModel.getData(url, new IContralt.ModelCallBack() {
            @Override
            public void onSuccessful(String strJson) {
                getV().onSuccessful(strJson);
            }

            @Override
            public void onError(String error) {
                getV().onError(error);
            }
        });
    }
}
