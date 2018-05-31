package com.example.binxie.helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.binxie.helloworld.gridview.GridViewActivity;
import com.example.binxie.helloworld.listview.ListViewActivity;
import com.example.binxie.helloworld.recyclerview.RecycleViewActivity;

public class UIActivity extends AppCompatActivity {

    private Button btn, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10, btn11, btn12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui);
        btn = (Button) findViewById(R.id.btn);

        btn1 = findViewById(R.id.btn_1);

        btn2 = findViewById(R.id.btn_2);

        btn3 = findViewById(R.id.btn_3);

        btn4 = findViewById(R.id.btn_4);

        btn5 = findViewById(R.id.btn_5);

        btn6 = findViewById(R.id.btn_6);

        btn7 = findViewById(R.id.btn_7);

        btn8 = findViewById(R.id.btn_8);

        btn9 = findViewById(R.id.btn_9);

        btn10 = findViewById(R.id.btn_10);

        btn11 = findViewById(R.id.btn_11);

        btn12 = findViewById(R.id.btn_12);

        setListener();
    }

    private void setListener() {
        Onclick onClick = new Onclick();
        btn.setOnClickListener(onClick);
        btn1.setOnClickListener(onClick);
        btn2.setOnClickListener(onClick);
        btn3.setOnClickListener(onClick);
        btn4.setOnClickListener(onClick);
        btn5.setOnClickListener(onClick);
        btn6.setOnClickListener(onClick);
        btn7.setOnClickListener(onClick);
        btn8.setOnClickListener(onClick);
        btn9.setOnClickListener(onClick);
        btn10.setOnClickListener(onClick);
        btn11.setOnClickListener(onClick);
        btn12.setOnClickListener(onClick);
    }

    private class Onclick implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()) {
                case R.id.btn:
                    intent = new Intent(UIActivity.this, TextViewActivity.class);
                    break;
                case  R.id.btn_1:
                    intent = new Intent(UIActivity.this, ButtonActivity.class);
                    break;
                case R.id.btn_2:
                    intent = new Intent(UIActivity.this, EditTextViewActivity.class);
                    break;
                case R.id.btn_3:
                    intent = new Intent(UIActivity.this, RadioButtonActivity.class);
                    break;
                case R.id.btn_4:
                    intent = new Intent(UIActivity.this, CheckBoxActivity.class);
                    break;
                case R.id.btn_5:
                    intent = new Intent(UIActivity.this, ImageViewActivity.class);
                    break;
                case R.id.btn_6:
                    intent = new Intent(UIActivity.this, ListViewActivity.class);
                    break;
                case R.id.btn_7:
                    intent = new Intent(UIActivity.this, GridViewActivity.class);
                    break;
                case R.id.btn_8:
                    intent = new Intent(UIActivity.this, RecycleViewActivity.class);
                    break;
                case R.id.btn_9:
                    intent = new Intent(UIActivity.this, WebViewActivity.class);
                    break;
                case R.id.btn_10:
                    intent = new Intent(UIActivity.this, ToastActivity.class);
                    break;
                case R.id.btn_11:
                    intent = new Intent(UIActivity.this, DialogActivity.class);
                    break;
                case R.id.btn_12:
                    intent = new Intent(UIActivity.this, ProgressActivity.class);
                    break;
            }
            startActivity(intent);

        }
    }


}
