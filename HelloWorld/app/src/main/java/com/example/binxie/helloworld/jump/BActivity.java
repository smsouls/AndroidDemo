package com.example.binxie.helloworld.jump;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.binxie.helloworld.R;

public class BActivity extends AppCompatActivity {

    private TextView mTv1;
    private Button mBtn1, mBtn2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_b);


        Log.d("BActivity", "----onCreate----");
        Log.d("BActivity", "----taskId:" + getTaskId() + "  ,hash:" + hashCode());
        logTaskName();


        mTv1 = findViewById(R.id.tv_1);
        final Bundle bundle = getIntent().getExtras();
        mTv1.setText(bundle.getString("name") + "," + bundle.getInt("number"));

        mBtn1 = findViewById(R.id.btn_finish);
        mBtn2 = findViewById(R.id.btn_to_a);

        mBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                Bundle bundle1 = new Bundle();
                bundle1.putString("title", "小朋友真是可爱");
                intent.putExtras(bundle1);
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });

        mBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BActivity.this, AActivity.class);
                startActivity(intent);
            }
        });


    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d("BActivity", "----onNewIntent----");
        Log.d("BActivity", "----taskId:" + getTaskId() + "  ,hash:" + hashCode());
        logTaskName();
    }

    private void logTaskName() {
        try {
            ActivityInfo info = getPackageManager().getActivityInfo(getComponentName(), PackageManager.GET_META_DATA);
            Log.d("BActivity", "----" + info.taskAffinity);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }
}
