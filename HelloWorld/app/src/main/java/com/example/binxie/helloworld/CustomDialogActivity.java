package com.example.binxie.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.binxie.helloworld.util.ToastUtil;
import com.example.binxie.helloworld.widget.CustomDialog;

public class CustomDialogActivity extends AppCompatActivity {

    private Button mButtonDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_dialog);
        mButtonDialog = findViewById(R.id.btn_custom_dialog);
        mButtonDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomDialog customDialog = new CustomDialog(CustomDialogActivity.this);
                customDialog.setTitle("提示").setMessage("确认删除选项").setCancel("取消", new CustomDialog.IOnCancelListener() {
                    @Override
                    public void onCancel(CustomDialog customDialog) {
                        ToastUtil.showMsg(CustomDialogActivity.this, "小朋友真的帅");
                    }
                }).setConfirm("确认", new CustomDialog.IOnConfirmListener() {
                    @Override
                    public void onConfirm(CustomDialog customDialog) {
                        ToastUtil.showMsg(CustomDialogActivity.this, "小朋友6666");

                    }
                }).show();
            }
        });
    }
}
