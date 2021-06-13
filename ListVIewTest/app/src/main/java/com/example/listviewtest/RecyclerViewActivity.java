package com.example.listviewtest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;


import java.util.ArrayList;

public class RecyclerViewActivity extends AppCompatActivity {
    public ArrayList recyclerView_list = new ArrayList<Item>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Theme_recyclerView);
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("This is Recyclerview");
        setContentView(R.layout.activity_recycler_view);
        initItem_recyclerView();
        //  创建LinearLayoutManager 实例
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        //  设定显示方向
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        // 获取RecyclerView实例
        RecyclerView recyclerView = findViewById(R.id.recycleView);
        //  设定recyclerView的显示方向
        recyclerView.setLayoutManager(linearLayoutManager);
        //  创建适配器，将需要显示的数据传入到适配器
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(recyclerView_list);
        //  recyclerView设置适配器
        recyclerView.setAdapter(recyclerViewAdapter);
    }
    public void initItem_recyclerView(){
        for(int i = 0 ;i<1;i++) {
            recyclerView_list.add(new Item("Award", R.drawable.award));
            recyclerView_list.add(new Item("Bankcard", R.drawable.bankcard));
            recyclerView_list.add(new Item("Bell", R.drawable.bell));
            recyclerView_list.add(new Item("Briefcase", R.drawable.briefcase));
            recyclerView_list.add(new Item("Building", R.drawable.building));
            recyclerView_list.add(new Item("Calendar", R.drawable.calendar));
            recyclerView_list.add(new Item("Chart", R.drawable.chart));
            recyclerView_list.add(new Item("Clock", R.drawable.clock));
            recyclerView_list.add(new Item("Coin", R.drawable.coin));
            recyclerView_list.add(new Item("Computer", R.drawable.computer));
            recyclerView_list.add(new Item("Delete", R.drawable.delete));
            recyclerView_list.add(new Item("File", R.drawable.file));
            recyclerView_list.add(new Item("Mouse", R.drawable.mouse));
            recyclerView_list.add(new Item("Msg", R.drawable.msg));
            recyclerView_list.add(new Item("Music", R.drawable.music));
            recyclerView_list.add(new Item("Phone", R.drawable.phone));
            recyclerView_list.add(new Item("Photo", R.drawable.photo));
            recyclerView_list.add(new Item("Video", R.drawable.video));
            recyclerView_list.add(new Item("Wallet", R.drawable.wallet));
        }
    }

    //  设定ActionBar上的点击事件
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            RecyclerViewActivity.this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}