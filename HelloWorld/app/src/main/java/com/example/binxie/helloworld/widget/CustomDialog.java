package com.example.binxie.helloworld.widget;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.binxie.helloworld.R;

public class CustomDialog extends Dialog implements View.OnClickListener{

    private TextView mTitle, mMessage, mCancel, mConfirm;

    private String title,message, cancel, confirm;

    private IOnCancelListener iOnCancelListener;
    private IOnConfirmListener iOnConfirmListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public CustomDialog setTitle(String title) {
        this.title = title;
        return this;
    }

    public CustomDialog setMessage(String message) {
        this.message = message;
        return this;
    }

    public CustomDialog setCancel(String cancel, IOnCancelListener iOnCancelListener) {
        this.cancel = cancel;
        this.iOnCancelListener = iOnCancelListener;
        return this;
    }

    public CustomDialog setConfirm(String confirm, IOnConfirmListener iOnConfirmListener) {
        this.confirm = confirm;
        this.iOnConfirmListener = iOnConfirmListener;
        return this;
    }


    public CustomDialog(@NonNull Context context) {
        super(context);
        setContentView(R.layout.layout_custom_dialog);
        //设置宽度
        WindowManager windowManager = getWindow().getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
        Point size = new Point();
        display.getSize(size);
        layoutParams.width = (int) (size.x * 0.8);
        getWindow().setAttributes(layoutParams);

        mTitle = findViewById(R.id.tv_title);
        mMessage = findViewById(R.id.tv_message);
        mCancel = findViewById(R.id.tv_cancel);
        mConfirm = findViewById(R.id.tv_confirm);

        mCancel.setOnClickListener(this);
        mConfirm.setOnClickListener(this);

        if (!TextUtils.isEmpty(title)) {
            mTitle.setText(title);
        }

        if (!TextUtils.isEmpty(message)) {
            mMessage.setText(message);
        }

        if (!TextUtils.isEmpty(cancel)) {
            mCancel.setText(cancel);
        }

        if (!TextUtils.isEmpty(confirm)) {
            mConfirm.setText(confirm);
        }


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.tv_cancel:
                if(iOnCancelListener != null) {
                    iOnCancelListener.onCancel(this);
                }
                dismiss();
                break;
            case R.id.tv_confirm:
                if(iOnConfirmListener != null) {
                    iOnConfirmListener.onConfirm(this);
                }
                dismiss();
                break;
        }
    }


    public interface IOnCancelListener {
        void onCancel(CustomDialog customDialog);
    }

    public interface IOnConfirmListener {
        void onConfirm(CustomDialog customDialog);
    }
}
