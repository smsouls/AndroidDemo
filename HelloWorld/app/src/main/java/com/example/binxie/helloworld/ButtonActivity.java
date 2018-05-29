package com.example.binxie.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ButtonActivity extends AppCompatActivity {

    private Button btn1;
    private TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);
        btn1 = findViewById(R.id.btn_2);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ButtonActivity.this, "小妹妹真可爱", Toast.LENGTH_LONG).show();
            }
        });

        tv1 = findViewById(R.id.tv_1);
        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ButtonActivity.this, "我真的是真可爱", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void showToast(View v) {
        Toast.makeText(this, "小朋友真可爱", Toast.LENGTH_LONG).show();


    }
}
