package com.example.listviewtest;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.List;

public class ListViewAdapter  extends ArrayAdapter {
    private Activity activity;
    private int resourceId;
    private List<Item> list_listview;
    public class ViewHolder{
        private ImageView itemImage_listview;
        private TextView itemName_listview;
        ViewHolder(ImageView itemImage_listview,TextView itemName_listview){
            this.itemImage_listview = itemImage_listview;
            this.itemName_listview = itemName_listview;
        }
    }
    ListViewAdapter(Activity activity, int resourceId, List<Item> list_listview){
        super(activity,resourceId,list_listview);
        this.activity=activity;
        this.resourceId=resourceId;
        this.list_listview=list_listview;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view;
        ViewHolder viewHolder;
        if(convertView == null){
            view = LayoutInflater.from(this.getContext()).inflate(resourceId,parent,false);
            ImageView itemImage_listview = view.findViewById(R.id.itemImage_listview);
            TextView itemName_listview = view.findViewById(R.id.itemName_listview);
            viewHolder = new ViewHolder(itemImage_listview,itemName_listview);
            view.setTag(viewHolder);
        }
        else {
            //  使用已加载好的布局
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        Item item = (Item) getItem(position);
        if(item != null){
            viewHolder.itemImage_listview.setImageResource(item.itemImageid);
            viewHolder.itemName_listview.setText(item.itemName);
        }
        return  view;
    }
}
