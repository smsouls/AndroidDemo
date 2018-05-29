package com.example.binxie.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.binxie.helloworld.util.ToastUtil;

import static android.view.Gravity.CENTER;

public class ToastActivity extends AppCompatActivity {

    private Button btn1, btn2, btn3, btn4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);

        btn1 = findViewById(R.id.btn_toast_1);
        btn2 = findViewById(R.id.btn_toast_2);
        btn3 = findViewById(R.id.btn_toast_3);
        btn4 = findViewById(R.id.btn_toast_4);

        OnClick onClick = new OnClick();
        btn1.setOnClickListener(onClick);
        btn2.setOnClickListener(onClick);
        btn3.setOnClickListener(onClick);
        btn4.setOnClickListener(onClick);


    }

    class OnClick implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_toast_1:
                    Toast.makeText(getApplicationContext(), "小朋友", Toast.LENGTH_LONG).show();
                    break;
                case R.id.btn_toast_2:
                    Toast toast = Toast.makeText(getApplicationContext(), "小朋友居中显示", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                    break;
                case R.id.btn_toast_3:
                    Toast customToast = new Toast(getApplicationContext());
                    LayoutInflater layoutInflater = LayoutInflater.from(ToastActivity.this);
                    View view = layoutInflater.inflate(R.layout.layout_toast, null);
                    ImageView imageView = view.findViewById(R.id.iv_toast);
                    TextView textView = view.findViewById(R.id.tv_toast);
                    Glide.with(getApplicationContext()).load("https://www.baidu.com/img/bd_logo1.png").into(imageView);
                    textView.setText("小朋友真可爱");
                    customToast.setView(view);
                    customToast.setDuration(Toast.LENGTH_LONG);
                    customToast.show();
                    break;
                case R.id.btn_toast_4:
                    ToastUtil.showMsg(getApplicationContext(), "包装过的toast");
                    break;
            }
        }
    }
}
