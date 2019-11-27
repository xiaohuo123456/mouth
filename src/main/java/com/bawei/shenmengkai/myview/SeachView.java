package com.bawei.shenmengkai.myview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.bawei.shenmengkai.R;

public class SeachView extends ViewGroup {
    private EditText editText;
    private Button button;
    public SeachView(final Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.seach_layout,this);
        editText = findViewById(R.id.edit_seach);
        button = findViewById(R.id.btn_seach);
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = editText.getText().toString();
                clickCallBack.onclickCallBack(str);
            }
        });
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }

    public interface onClickCallBack{
        void onclickCallBack(String string);
    }
    public static onClickCallBack clickCallBack;

    public static void getClickCallBack(onClickCallBack clickCallBack1){
        clickCallBack = clickCallBack1;
    }

}
