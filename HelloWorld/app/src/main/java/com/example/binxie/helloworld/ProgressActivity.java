package com.example.binxie.helloworld;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.binxie.helloworld.util.ToastUtil;

public class ProgressActivity extends AppCompatActivity {

    private ProgressBar mProBar2;
    private Button mBtnStart,mBtn1,mBtn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);

        mProBar2 = findViewById(R.id.pb2);
        mProBar2.setProgress(30);

        mBtnStart = findViewById(R.id.btn_start);
        mBtnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handler.sendEmptyMessage(0);
            }
        });

        mBtn1 = findViewById(R.id.btn_dialog1);

        mBtn2 = findViewById(R.id.btn_dialog2);


        mBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressDialog progressDialog = new ProgressDialog(ProgressActivity.this);
                progressDialog.setMessage("正在加载");
                progressDialog.setTitle("提示");
                progressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {
                        ToastUtil.showMsg(ProgressActivity.this, "cancel......");
                    }
                });
                progressDialog.setCancelable(false);
                progressDialog.show();

            }
        });


        mBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressDialog progressDialog = new ProgressDialog(ProgressActivity.this);
                progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                progressDialog.setTitle("提示");
                progressDialog.setMessage("正在下载。。。。。");
                progressDialog.setButton(DialogInterface.BUTTON_POSITIVE, "帅", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                progressDialog.show();
            }
        });

    }

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(mProBar2.getProgress() < 100) {
                handler.postDelayed(runnable, 500);

            }else {
                ToastUtil.showMsg(ProgressActivity.this, "小朋友真可爱");
            }
        }
    };

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            mProBar2.setProgress(mProBar2.getProgress() + 5);
            handler.sendEmptyMessage(0);
        }
    };
}
