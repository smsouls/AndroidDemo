package com.example.binxie.helloworld.jump;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.binxie.helloworld.R;
import com.example.binxie.helloworld.util.ToastUtil;

public class AActivity extends AppCompatActivity {


    private Button mBtnj,mBtnl,mBtnj2;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_a);


        mBtnj = findViewById(R.id.btn_jump);
        mBtnl = findViewById(R.id.btn_lanuch);
        mBtnj2 = findViewById(R.id.btn_jump2);

        Log.d("AActivity", "----onCreate----");
        Log.d("AActivity", "----taskId:" + getTaskId() + "  ,hash:" + hashCode());
        logTaskName();
        mBtnj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //1.显示跳转
                Intent intent = new Intent(AActivity.this, BActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("name", "小朋友");
                bundle.putInt("number", 16);
                intent.putExtras(bundle);
                startActivity(intent);
//                startActivityForResult(intent, 0);

                //2.显示跳转
//                Intent intent = new Intent();
//                intent.setClass(AActivity.this, BActivity.class);
//                startActivity(intent);

                //3.显示跳转
//                Intent intent = new Intent();
//                intent.setClassName(AActivity.this, "com.example.binxie.helloworld.jump.BActivity");
//                startActivity(intent);

                //4.显示跳转
//                Intent intent = new Intent();
//                intent.setComponent(new ComponentName(AActivity.this, "com.example.binxie.helloworld.jump.BActivity"));
//                startActivity(intent);

                //5.隐式跳转
//                Intent intent = new Intent();
//                intent.setAction("xiao.peng.you.BActivity");
//                startActivity(intent);
            }
        });

        mBtnj2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AActivity.this, AActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        ToastUtil.showMsg(AActivity.this, data.getExtras().getString("title"));
    }


    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d("AActivity", "----onNewIntent----");
        Log.d("AActivity", "----taskId:" + getTaskId() + "  ,hash:" + hashCode());
        logTaskName();
    }

    private void logTaskName() {
        try {
            ActivityInfo info = getPackageManager().getActivityInfo(getComponentName(), PackageManager.GET_META_DATA);
            Log.d("AActivity", "----" + info.taskAffinity);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }
}
