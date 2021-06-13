package com.example.listviewtest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Notification;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public ArrayList listView_list = new ArrayList<Item>();

    // 设定Meun
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.actionbarmenu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    // 设定Menu中的按钮点击事件
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.NextPage){
            Intent intent = new Intent(MainActivity.this,RecyclerViewActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("This is ListView");
        // 获取ListView实例
        ListView listView = findViewById(R.id.listView);
        initItem_listView();
        //  创建适配器，将list和布局传入到适配器中
        ArrayAdapter adapter = new ListViewAdapter(this,R.layout.listview_item,listView_list);
        //  ListView设置适配器
        listView.setAdapter(adapter);
        //  设定ListView中的点击事件
        listView.setOnItemClickListener((parent, view, position, id) -> {
            Item item = (Item) listView_list.get(position);
            Toast.makeText(MainActivity.this,item.itemName, Toast.LENGTH_SHORT).show();
        });
    }
    public void initItem_listView(){
        for(int i = 0 ;i<1;i++){
            listView_list.add(new Item("饼干",R.drawable.bingan));
            listView_list.add(new Item("碧根果",R.drawable.bigenguo));
            listView_list.add(new Item("牛油果",R.drawable.niuyouguo));
            listView_list.add(new Item("布丁",R.drawable.buding));
            listView_list.add(new Item("草莓",R.drawable.caomei));
            listView_list.add(new Item("披萨",R.drawable.pizza));
            listView_list.add(new Item("热狗",R.drawable.regou));
            listView_list.add(new Item("冰棒",R.drawable.bingbang));
            listView_list.add(new Item("蛋黄酥",R.drawable.danhuangsu));
            listView_list.add(new Item("麻薯",R.drawable.mashu));
            listView_list.add(new Item("开心果",R.drawable.kaixinguo));
            listView_list.add(new Item("柠檬",R.drawable.ningmeng));
            listView_list.add(new Item("巧克力",R.drawable.qiaokeli));
            listView_list.add(new Item("小鱼干",R.drawable.xiaoyugan));
            listView_list.add(new Item("薯条",R.drawable.shutiao));
            listView_list.add(new Item("棒棒糖",R.drawable.bangbangtang));
        }
    }
}