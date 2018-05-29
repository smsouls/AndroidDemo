package com.example.binxie.helloworld;

import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class TextViewActivity extends AppCompatActivity {

    private TextView tv1,tv3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_view);

        tv1 = findViewById(R.id.tv_1);
        tv1.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        tv1.getPaint().setAntiAlias(true);


        tv3 = findViewById(R.id.tv_3);
        tv3.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
        tv3.getPaint().setAntiAlias(true);
    }

}
