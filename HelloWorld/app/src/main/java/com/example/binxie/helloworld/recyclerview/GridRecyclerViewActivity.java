package com.example.binxie.helloworld.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.binxie.helloworld.R;

public class GridRecyclerViewActivity extends AppCompatActivity {

    private RecyclerView mGvGrid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_recycler_view);

        mGvGrid = findViewById(R.id.rv_grid);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(GridRecyclerViewActivity.this, 4);
        mGvGrid.setLayoutManager(gridLayoutManager);
        mGvGrid.setAdapter(new GridAdapter(GridRecyclerViewActivity.this, new GridAdapter.OnItemClickListener() {
            @Override
            public void onClick(int pos) {
                Toast.makeText(GridRecyclerViewActivity.this, "小朋友 pos:" + pos, Toast.LENGTH_LONG).show();
            }
        }));
    }
}
