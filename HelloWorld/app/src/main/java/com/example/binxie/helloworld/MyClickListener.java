package com.example.binxie.helloworld;

import android.app.Activity;
import android.view.View;

import com.example.binxie.helloworld.util.ToastUtil;

public class MyClickListener implements View.OnClickListener {

    private Activity activity;

    public MyClickListener(Activity activity){
        this.activity = activity;
    }


    @Override
    public void onClick(View v) {
        ToastUtil.showMsg(activity, "通过外部类实现事件的监听");

    }
}
