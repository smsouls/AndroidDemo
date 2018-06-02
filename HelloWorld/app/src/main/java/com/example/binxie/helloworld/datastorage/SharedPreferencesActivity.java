package com.example.binxie.helloworld.datastorage;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.binxie.helloworld.R;

public class SharedPreferencesActivity extends AppCompatActivity {

    private EditText mEt;
    private Button mBtnsave, mBtnshow;
    private TextView mTv;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);

        mEt = findViewById(R.id.et_name);
        mBtnsave = findViewById(R.id.btn_save);
        mBtnshow = findViewById(R.id.btn_show);
        mTv = findViewById(R.id.tv_show);

        sharedPreferences = this.getSharedPreferences("data", MODE_PRIVATE);
        editor = sharedPreferences.edit();


        mBtnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putString("name", mEt.getText().toString());
                editor.apply();
            }
        });

        mBtnshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTv.setText(sharedPreferences.getString("name", "小朋友真可爱"));
            }
        });
    }
}
