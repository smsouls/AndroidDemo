package com.example.binxie.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EditTextViewActivity extends AppCompatActivity {

    private EditText userName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text_view);

        userName = findViewById(R.id.et_1);
        userName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d("edittext", s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    public void Login(View view) {
        Toast.makeText(this, "登陆成功", Toast.LENGTH_LONG).show();
    }
}
