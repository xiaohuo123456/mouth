package com.bawei.shenmengkai;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.shenmengkai.adapter.MyAdapter;
import com.bawei.shenmengkai.base.BaseActivity;
import com.bawei.shenmengkai.base.BasePresenter;
import com.bawei.shenmengkai.bean.MyBean;
import com.bawei.shenmengkai.icontralt.IContralt;
import com.bawei.shenmengkai.myview.MyView;
import com.bawei.shenmengkai.presenter.MyPresenter;
import com.bawei.shenmengkai.utils.VolleyUtils;
import com.google.gson.Gson;

import java.net.URLEncoder;
import java.util.List;
/*
 * 姓名：沈梦凯
 * 日期：2019／11／27
 * 功能：主页面
 * */
public class MainActivity extends BaseActivity implements IContralt.ViewCallBack {
    String url = "http://172.17.8.100/small/commodity/v1/findCommodityByKeyword?page=1&count=5&keyword=";
    String url1 = "板鞋";
    private RecyclerView recyclerView;
    private MyView myView;
    private EditText editText;
    private Button button;
    @Override
    protected BasePresenter initPresenter() {
        return new MyPresenter();
    }

    @Override
    protected void initData() {
        if (VolleyUtils.getInstance().getNetState(MainActivity.this)){
            String encode = URLEncoder.encode(url1);
            p.getData(url+encode);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String s = editText.getText().toString();
                    toAddView(s);
                }
            });
        }else {
            Toast.makeText(this,"没网",Toast.LENGTH_SHORT).show();
        }

    }

    private void toAddView(String string) {
        TextView textView = new TextView(this);
        textView.setText(string);
        textView.setTextColor(Color.YELLOW);
        textView.setBackgroundColor(Color.BLACK);
        myView.addView(textView);
    }

    @Override
    protected void initView() {
        if (p!=null){
            p.onAttchView(this);
        }
        recyclerView = findViewById(R.id.recycle);
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        myView = findViewById(R.id.myview);
        editText = findViewById(R.id.edittext);
        button = findViewById(R.id.btn);
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void onSuccessful(String strJson) {
        Toast.makeText(this,strJson,Toast.LENGTH_SHORT).show();
        Gson gson = new Gson();
        MyBean myBean = gson.fromJson(strJson, MyBean.class);
        List<MyBean.ResultBean> list = myBean.getResult();
        MyAdapter myAdapter = new MyAdapter(list,this);
        recyclerView.setAdapter(myAdapter);

    }

    @Override
    public void onError(String error) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        p.unAttchView(this);
    }
}
