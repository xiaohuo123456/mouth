package com.bawei.shenmengkai.base;

import com.bawei.shenmengkai.icontralt.IContralt;
import com.bawei.shenmengkai.model.MyModel;

public abstract class BasePresenter<V extends IContralt.ViewCallBack> {
    public V v;
    public MyModel myModel;

    public BasePresenter(){
        myModel = new MyModel();
    }
    public void onAttchView(V v){
        this.v = v;
    }
    public void unAttchView(V v){
        if (v!=null){
            v=null;
        }
    }

    public V getV() {
        return v;
    }

    public abstract void getData(String url);
}
