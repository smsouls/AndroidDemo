package com.example.binxie.helloworld.datastorage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.binxie.helloworld.R;

public class DataStorageActivity extends AppCompatActivity implements View.OnClickListener{


    private Button mBtnsharedpreference,mBtnfile, mBtnefile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_storage);
        mBtnsharedpreference = findViewById(R.id.btn_sharedpreference);
        mBtnsharedpreference.setOnClickListener(DataStorageActivity.this);
        mBtnfile = findViewById(R.id.btn_file);
        mBtnfile.setOnClickListener(DataStorageActivity.this);
        mBtnefile = findViewById(R.id.btn_external_file);
        mBtnefile.setOnClickListener(DataStorageActivity.this);

    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()){
            case R.id.btn_sharedpreference:
                intent = new Intent(DataStorageActivity.this, SharedPreferencesActivity.class);
                break;
            case R.id.btn_file:
                intent = new Intent(DataStorageActivity.this, FileActivity.class);
                break;
            case R.id.btn_external_file:
                intent = new Intent(DataStorageActivity.this, ExternalFileActivity.class);
                break;
        }
        startActivity(intent);
    }
}
