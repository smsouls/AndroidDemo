package com.example.binxie.helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.binxie.helloworld.util.ToastUtil;

public class EventActivity extends AppCompatActivity implements View.OnClickListener {


    //只会执行最后一个设置的监听器
    private Button mBtn1, mBtn2, mBtn3, mBtn4, mBtn5, mBtn6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        mBtn1 = findViewById(R.id.btn_1);
        mBtn2 = findViewById(R.id.btn_2);
        mBtn3 = findViewById(R.id.btn_3);
        mBtn4 = findViewById(R.id.btn_4);
        mBtn5 = findViewById(R.id.btn_my);
        mBtn6 = findViewById(R.id.btn_handler);

//只会执行最后一个设置的监听器
        mBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.showMsg(EventActivity.this, "通过匿名类响应事件");
            }
        });
        //通过内部类
        OnClick onClick = new OnClick();
        mBtn1.setOnClickListener(onClick);

        mBtn3.setOnClickListener(EventActivity.this);

        mBtn4.setOnClickListener(new MyClickListener(EventActivity.this));
        //只会执行最后一个设置的监听器

        //监听由于回调
        mBtn5.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (v.getId()){
                    case R.id.btn_my:
                        Log.d("Listener", "----onTouch----");
                        break;
                }
                return false;
            }
        });

        mBtn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Listener", "----onClick----");
            }
        });

        mBtn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EventActivity.this, HandlerActivity.class);
                startActivity(intent);
            }
        });
    }

    public void show(View view) {
        switch (view.getId()) {
            case R.id.btn_5:
                ToastUtil.showMsg(EventActivity.this, "通过xml配置触发事件");
                break;
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_3:
                ToastUtil.showMsg(EventActivity.this, "通过事件源所在的类响应事件");
                break;
        }
    }

    class OnClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_1:
                    ToastUtil.showMsg(EventActivity.this, "通过内部类响应事件");
                    break;
//                case R.id.btn_1:
//                    break;
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                Log.d("EventActivity", "----onTouchEvent----");
        }

        return false;
    }
}
