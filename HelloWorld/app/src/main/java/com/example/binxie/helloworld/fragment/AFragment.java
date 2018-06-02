package com.example.binxie.helloworld.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.binxie.helloworld.R;

import java.util.zip.Inflater;

public class AFragment extends Fragment {

    private TextView mTv1;
    private Button mBtnChange, mBtnRest, mBtnMessage;
    private BFragment bFragment;
    private IOMessageClick listener;
//    private Activity mActivity;



    public static AFragment newInstance(String title){
        AFragment aFragment = new AFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        aFragment.setArguments(bundle);
        return aFragment;
    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        Log.d("AFragment", "----onCreateView----");
        View view = inflater.inflate(R.layout.fragment_a, container, false);
        return view;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
        mTv1 = view.findViewById(R.id.tv_1);
        mBtnChange = view.findViewById(R.id.btn_change);
        mBtnRest = view.findViewById(R.id.btn_reset);
        mBtnMessage = view.findViewById(R.id.btn_message);

        mBtnMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                ((ContainerActivity)getActivity()).setData("小朋友真可爱");
                listener.onClick("小朋友真的帅");
            }
        });

        mBtnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bFragment == null){
                    bFragment = new BFragment();
                }

                Fragment fragment = getFragmentManager().findFragmentByTag("a");
                if(fragment != null){
                    getFragmentManager().beginTransaction().hide(fragment).add(R.id.fl_container, bFragment).addToBackStack(null).commitAllowingStateLoss();
                }else {
                    getFragmentManager().beginTransaction().replace(R.id.fl_container, bFragment).addToBackStack(null).commitAllowingStateLoss();
                }
            }
        });


        mBtnRest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTv1.setText("我是新文字");
            }
        });
        if(getArguments() != null){
            mTv1.setText(getArguments().getString("title"));
        }

//        if(getActivity() != null) {
//
//        }else{
//
//        }
    }


    public interface IOMessageClick{
        void onClick(String text);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener = (IOMessageClick) context;
        }catch (ClassCastException e){
            throw new ClassCastException("Activity 必须实现接口");
        }

//        mActivity = (Activity) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ///取消异步
    }
}
