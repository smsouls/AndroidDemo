package com.example.binxie.helloworld.listview;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.binxie.helloworld.R;

public class ListViewActivity extends Activity {

    private ListView lv1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        lv1 = findViewById(R.id.lv_1);
        lv1.setAdapter(new MyListAdapter(ListViewActivity.this));
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView <?> parent, View view, int position, long id) {
                Toast.makeText(ListViewActivity.this, "pos:" + position, Toast.LENGTH_LONG).show();
            }
        });

        lv1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView <?> parent, View view, int position, long id) {
                Toast.makeText(ListViewActivity.this, "long pos:" + position, Toast.LENGTH_LONG).show();
                return false;
            }
        });
    }
}
