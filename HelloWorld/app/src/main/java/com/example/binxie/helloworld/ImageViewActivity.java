package com.example.binxie.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.module.AppGlideModule;


public class ImageViewActivity extends AppCompatActivity {

    private ImageView iv_4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);
        iv_4 = findViewById(R.id.iv_4);
        Glide.with(ImageViewActivity.this).load("https://www.baidu.com/img/bd_logo1.png").into(iv_4);
//        Glide.with(this).load("https://b-ssl.duitang.com/uploads/item/201504/24/20150424H0605_V8dyk.jpeg").into(iv_4);



    }
}
