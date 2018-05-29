package com.example.binxie.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class CheckBoxActivity extends AppCompatActivity {

    private CheckBox cb_4, cb_5, cb_6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box);

        cb_4 = findViewById(R.id.cb_4);
        cb_4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(CheckBoxActivity.this, isChecked? "小朋友真可爱": "小朋友好可爱", Toast.LENGTH_LONG).show();
            }
        });

        cb_5 = findViewById(R.id.cb_5);

        cb_5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(CheckBoxActivity.this, isChecked? "小朋友真可爱——": "小朋友好可爱——", Toast.LENGTH_LONG).show();
            }
        });

        cb_6 = findViewById(R.id.cb_6);

        cb_6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(CheckBoxActivity.this, isChecked? "小朋友真可爱————": "小朋友好可爱————", Toast.LENGTH_LONG).show();
            }
        });
    }
}
