package com.example.binxie.helloworld.gridview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.binxie.helloworld.R;

public class GridViewActivity extends AppCompatActivity {

    GridView mGv = null;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);
        mGv = findViewById(R.id.gv1);
        mGv.setAdapter(new MyGridViewAdapter(GridViewActivity.this));
        mGv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView <?> parent, View view, int position, long id) {
                Toast.makeText(GridViewActivity.this, "小朋友真可爱 pos:" + position, Toast.LENGTH_LONG).show();
            }
        });

        mGv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView <?> parent, View view, int position, long id) {
                Toast.makeText(GridViewActivity.this, "Long 小朋友真可爱 pos:" + position, Toast.LENGTH_LONG).show();
                return true;
            }
        });

    }
}

