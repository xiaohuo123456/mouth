package com.bawei.shenmengkai.myview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
/*
 * 姓名：沈梦凯
 * 日期：2019／11／27
 * 功能：流式布局
 * */
public class MyView extends ViewGroup {
    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int count = getChildCount();
        int space = 10;
        int left = 0;
        int right = 0;
        int top = 0;
        int bottem = 0;
        //循环给每个子view设置好位置
        for (int i = 0; i < count; i++) {
            View child = getChildAt(i);
            child.measure(0,0);
            left = space + right;
            right = left + child.getMeasuredWidth();
            if (right>getWidth()){
                top = space + bottem;
                left = space;

            }
            right = left + child.getMeasuredWidth();
            bottem = top + child.getMeasuredHeight();
            child.layout(left,top,right,bottem);
        }
    }
}
