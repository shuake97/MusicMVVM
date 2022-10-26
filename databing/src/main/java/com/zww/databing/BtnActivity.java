package com.zww.databing;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class BtnActivity extends AppCompatActivity {
    Button button1,button2;
    ViewGroup myLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_btn);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        myLayout = findViewById(R.id.my_layout);

        // 1.为ViewGroup布局设置监听事件
        myLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TAG","点击了ViewGroup");
            }
        });


        // 2. 为按钮1设置监听事件
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TAG", "点击了button1");
            }
        });

        button1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {  //0:down   1:up    2:move
//                会执行按下View和抬起View，会回调两次onTouch（）
                Log.d("TAG", "执行了onTouch(), 动作是:" + event.getAction());
                return true;   //返回false会执行onTouchEvent()事件 这里调用了perfrmClick()方法，返回true不会执行onTouchEvent方法。
            }
        });

        // 3. 为按钮2设置监听事件
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TAG", "点击了button2");
            }
        });
    }
}