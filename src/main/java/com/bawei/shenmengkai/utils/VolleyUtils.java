package com.bawei.shenmengkai.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bawei.shenmengkai.icontralt.IContralt;
import com.bawei.shenmengkai.myapp.MyApp;

import java.util.HashMap;
import java.util.Map;

/*
* Volley网络框架的Get和Post的封装，
* 判断网络状态的方法
* 单例模式
* */
public class VolleyUtils {
    private VolleyUtils(){

    }
    public static class VolleyHolder{
        public static VolleyUtils utils = new VolleyUtils();
    }
    public static VolleyUtils getInstance(){
        return VolleyHolder.utils;
    }

    public Boolean getNetState(Context context){
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = manager.getActiveNetworkInfo();
        if (info!=null){
            return info.isConnected();
        }
        return false;
    }

    public void getData(String url, final IContralt.ModelCallBack callBack){
        RequestQueue queue = Volley.newRequestQueue(MyApp.context);
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                callBack.onSuccessful(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callBack.onError(error.getMessage());
            }
        });
        queue.add(request);
    }public void postData(String url, final String phone, final String pwd, final IContralt.ModelCallBack callBack){
        RequestQueue queue = Volley.newRequestQueue(MyApp.context);
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                callBack.onSuccessful(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callBack.onError(error.getMessage());
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> map = new HashMap<>();
                map.put("phone",phone);
                map.put("pwd",pwd);
                return map;
            }
        };
        queue.add(request);
    }
}
