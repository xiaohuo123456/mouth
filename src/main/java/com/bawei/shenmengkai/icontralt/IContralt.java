package com.bawei.shenmengkai.icontralt;
/*
 * 姓名：沈梦凯
 * 日期：2019／11／27
 * 功能：契约类统一管理接口
 * */
public interface IContralt {
    public interface ModelCallBack{
        void onSuccessful(String strJson);
        void onError(String error);
    }
    public interface ViewCallBack{
        void onSuccessful(String strJson);
        void onError(String error);
    }
}
