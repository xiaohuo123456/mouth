package com.bawei.shenmengkai;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
/*
* 姓名：沈梦凯
* 日期：2019／11／27
* 功能：js交互
* */
public class JsWebActivity extends AppCompatActivity {
    private WebView webView;
    private Button button;
    @SuppressLint("JavascriptInterface")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.js_layout);
        webView = findViewById(R.id.webview);
        button = findViewById(R.id.change);
        webView.loadUrl("file:///android_asset/info.html");
        Intent intent = getIntent();
        String str = intent.getStringExtra("str");
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.post(new Runnable() {
                    @Override
                    public void run() {
                        webView.loadUrl("javascript:changeNum('20')");
                    }
                });
            }
        });
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                webView.loadUrl("file:///android_asset/info.html");
                return true;
            }
        });
        webView.addJavascriptInterface(new JsClass(),"android");
    }
    class JsClass{
        @JavascriptInterface
        public void changeNum(String s){
            webView.post(new Runnable() {
                @Override
                public void run() {
                    webView.loadUrl("javascript:changeNum(20)");
                }
            });
        }
        @JavascriptInterface
        public void buyNow(String id){
            Log.e("aaaa", "buyNow: "+id );
            Toast.makeText(JsWebActivity.this,"aaaa",Toast.LENGTH_SHORT).show();
        }
    }
}
