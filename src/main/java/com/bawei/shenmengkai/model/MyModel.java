package com.bawei.shenmengkai.model;

import com.bawei.shenmengkai.icontralt.IContralt;
import com.bawei.shenmengkai.utils.VolleyUtils;

/*
 * 姓名：沈梦凯
 * 日期：2019／11／27
 * 功能：Model层获取网络数据
 * */
public class MyModel {
    public void getData(String url, final IContralt.ModelCallBack callBack){
        VolleyUtils.getInstance().getData(url, new IContralt.ModelCallBack() {
            @Override
            public void onSuccessful(String strJson) {
                callBack.onSuccessful(strJson);
            }

            @Override
            public void onError(String error) {
                callBack.onError(error);
            }
        });
    }
}
