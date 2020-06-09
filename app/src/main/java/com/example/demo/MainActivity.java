package com.example.demo;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.Toolbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recycler_view;
    private MyAdapter adapter;
    private ArrayList<String> mData = new ArrayList<>();
    private Button btn_new;
    private Button btn_skip;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mData.add("胸部肌群");
        mData.add("背部肌群");
        mData.add("腿部肌群");
        mData.add("肩部肌群");
        mData.add("腹部肌群");
        mData.add("有氧訓練:慢跑");
        //mData.add("雞雞");


        // 連結元件
        recycler_view = (RecyclerView) findViewById(R.id.recycler_view);
        // 設置RecyclerView為列表型態
        recycler_view.setLayoutManager(new LinearLayoutManager(this));
        // 設置格線
        //recycler_view.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        // 將資料交給adapter
        adapter = new MyAdapter(mData);
        // 設置adapter給recycler_view
        recycler_view.setAdapter(adapter);

        btn_new = (Button) findViewById(R.id.btn_new);
        btn_new.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 新增一個項目
                //adapter.addItem("New");
                //intent.putExtra(, mData);
                Intent intent = new Intent(MainActivity.this, ExerciseActivity.class);
                //intent.putExtra("data","data");
                startActivityForResult(intent, 99);
            }
        });

        btn_skip = (Button) findViewById(R.id.btn_skip);
        btn_skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.addItemOnLast(mData.get(0));
                adapter.removeItem(0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 99){
            if(resultCode == 88){
                Bundle bundle = data.getExtras();
                String back = bundle.getString("back");
                Toast.makeText(MainActivity.this,back,Toast.LENGTH_SHORT).show();
                adapter.addItem(back);
            }
        }
    }
}
