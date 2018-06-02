package com.example.binxie.helloworld;

import android.content.Context;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

public class MyButton extends AppCompatButton {


    public MyButton(Context context) {
        super(context);
    }

    public MyButton(Context context, AttributeSet attrs){
        super(context, attrs);

    }

    public MyButton(Context context, AttributeSet attrs, int defStyleAttr){
        super(context, attrs, defStyleAttr);
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent event) { //所有事件的路口
        Log.d("MyButton", "-----dispatchTouchEvent-----");
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                Log.d("MyButton", "----onTouchEvent----");
                break;
        }
        //表示不再往下传递
        return super.onTouchEvent(event);
    }
}
