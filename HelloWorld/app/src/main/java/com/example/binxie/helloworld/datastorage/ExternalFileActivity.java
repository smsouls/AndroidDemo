package com.example.binxie.helloworld.datastorage;

import android.Manifest;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.binxie.helloworld.R;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExternalFileActivity extends AppCompatActivity {

    private EditText mEt;
    private Button mBtnsave, mBtnshow;
    private TextView mTv;
    private final String filename = "test.txt";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_external_file);

        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);

        mEt = findViewById(R.id.et_name);
        mBtnsave = findViewById(R.id.btn_save);
        mBtnshow = findViewById(R.id.btn_show);
        mTv = findViewById(R.id.tv_show);



        mBtnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save(mEt.getText().toString());
            }
        });

        mBtnshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTv.setText(read());
            }
        });
    }


    //存储信息
    private void save(String content){
        FileOutputStream fileOutputStream = null;
        try {
            //创建文件夹
            File dir = new File(Environment.getExternalStorageDirectory(),"xpy");
            if(!dir.exists()){
                dir.mkdir();
            }
            File file = new File(dir, filename);

            if(!file.exists()){
                file.createNewFile();
            }
            fileOutputStream = new FileOutputStream(file);
            Log.d("----", file.getAbsolutePath());
            fileOutputStream.write(content.getBytes());
        }catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //读取信息
    private String read(){

        FileInputStream fileInputStream = null;
        byte[] buff = null;
        try {

            File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() +
                    File.separator + "xpy", filename);
            Log.d("----", file.getAbsolutePath());
            fileInputStream = new FileInputStream(file);
            buff = new byte[1024];
            StringBuilder sb = new StringBuilder("");
            int len = 0;
            while((len = fileInputStream.read(buff)) > 0){
                sb.append(new String(buff, 0, len));
            }
            return sb.toString();
        }catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
