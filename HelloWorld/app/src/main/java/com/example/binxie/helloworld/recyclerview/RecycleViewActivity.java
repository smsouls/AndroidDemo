package com.example.binxie.helloworld.recyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.binxie.helloworld.R;
import com.example.binxie.helloworld.gridview.GridViewActivity;

public class RecycleViewActivity extends AppCompatActivity {

    private Button mBtn1,mBtn2,mBtn3,mBtn4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view);

        mBtn1 = findViewById(R.id.btn_1);

        mBtn2 = findViewById(R.id.btn_2);

        mBtn3 = findViewById(R.id.btn_3);

        mBtn4 = findViewById(R.id.btn_4);

        setOnClickListener();

    }

    private void setOnClickListener() {
        mBtn1.setOnClickListener(new OnClick());
        mBtn2.setOnClickListener(new OnClick());
        mBtn3.setOnClickListener(new OnClick());
        mBtn4.setOnClickListener(new OnClick());
    }

    private class OnClick implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()) {
                case R.id.btn_1:
                    intent = new Intent(RecycleViewActivity.this, LinearRecyclerViewActivity.class);
                    break;
                case R.id.btn_2:
                    intent = new Intent(RecycleViewActivity.this, GridRecyclerViewActivity.class);
                    break;
                case R.id.btn_3:
                    intent = new Intent(RecycleViewActivity.this, HorRecyclerViewActivity.class);
                    break;
                case R.id.btn_4:
                    intent = new Intent(RecycleViewActivity.this, PuRecyclerViewActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }
}
