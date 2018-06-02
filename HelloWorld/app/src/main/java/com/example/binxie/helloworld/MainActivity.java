package com.example.binxie.helloworld;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.binxie.helloworld.fragment.ContainerActivity;

public class MainActivity extends AppCompatActivity {


    private Button mBtnUI, mBtnLifeCycle, mBtnFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnUI = findViewById(R.id.btn_ui);
        mBtnLifeCycle = findViewById(R.id.btn_lifecycle);
        mBtnFragment = findViewById(R.id.btn_fragment);

        OnClick onClick = new OnClick();
        mBtnUI.setOnClickListener(onClick);
        mBtnLifeCycle.setOnClickListener(onClick);
        mBtnFragment.setOnClickListener(onClick);

    }

    class OnClick implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()) {
                case R.id.btn_ui:
                    intent = new Intent(MainActivity.this, UIActivity.class);
                    break;
                case R.id.btn_lifecycle:
                    intent = new Intent(MainActivity.this, FunctionActivity.class);
                    break;
                case R.id.btn_fragment:
                    intent = new Intent(MainActivity.this, ContainerActivity.class);
                    break;
            }

            startActivity(intent);
        }
    }
}
