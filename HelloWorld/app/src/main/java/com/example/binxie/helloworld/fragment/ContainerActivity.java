package com.example.binxie.helloworld.fragment;

import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.binxie.helloworld.R;

public class ContainerActivity extends AppCompatActivity implements AFragment.IOMessageClick{

    private Button mBtn1;
    private AFragment aFragment;
    private BFragment bFragment;
    private TextView mTv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);

        //实例化AFragment
        aFragment = AFragment.newInstance("小朋友真可爱");
        bFragment = new BFragment();
        mBtn1 = findViewById(R.id.btn_change);
        mTv1 = findViewById(R.id.tv_title);
        //把AFragemnt添加到Activity中,记得调用commit
        getFragmentManager().beginTransaction().add(R.id.fl_container, aFragment, "a").commitAllowingStateLoss();


//        mBtn1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                if(bFragment == null) {
//                    bFragment = new BFragment();
//                }
//                getFragmentManager().beginTransaction().replace(R.id.fl_container, bFragment).commitAllowingStateLoss();
//            }
//        });
    }

    public void setData(String text){
        mTv1.setText(text);
    }

    @Override
    public void onClick(String text) {
        mTv1.setText(text);
    }
}
