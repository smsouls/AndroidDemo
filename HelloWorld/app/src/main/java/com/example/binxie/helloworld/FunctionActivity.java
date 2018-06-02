package com.example.binxie.helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.binxie.helloworld.jump.AActivity;

public class FunctionActivity extends AppCompatActivity {


    private Button mBtn1, mBtn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_function);

        mBtn1 = findViewById(R.id.btn_1);
        mBtn2 = findViewById(R.id.btn_2);


        OnClick onClick = new OnClick();
        mBtn1.setOnClickListener(onClick);
        mBtn2.setOnClickListener(onClick);

    }


    class OnClick implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()) {
                case R.id.btn_1:
                    intent = new Intent(FunctionActivity.this, LifeCycleActivity.class);
                    break;

                case R.id.btn_2:
                    intent = new Intent(FunctionActivity.this, AActivity.class);
                    break;

            }
            startActivity(intent);
        }
    }
}
