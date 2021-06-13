package com.example.listviewtest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter  extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private List<Item> list_recyclerview;
    RecyclerViewAdapter(List<Item> list_recyclerview){
        super();
        this.list_recyclerview = list_recyclerview;
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        public View view;
        public ImageView itemImage_recyclerview;
        public TextView itemName_recyclerview;
        ViewHolder(View view){
            super(view);
            this.view = view;
            this.itemImage_recyclerview = view.findViewById(R.id.itemImage_recyclerview);
            this.itemName_recyclerview = view.findViewById(R.id.itemName_recyclerview);
        }
    }

    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item,parent,false);
       ViewHolder viewHolder = new ViewHolder(view);
       viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               int position = viewHolder.getAbsoluteAdapterPosition();
               Item item = (Item) list_recyclerview.get(position);
               Toast.makeText(parent.getContext(),"You Click Item  "+item.itemName, Toast.LENGTH_SHORT).show();
           }
       });
       return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull RecyclerViewAdapter.ViewHolder holder, int position) {
        Item item = list_recyclerview.get(position);
        holder.itemImage_recyclerview.setImageResource(item.itemImageid);
        holder.itemName_recyclerview.setText(item.itemName);
    }

    @Override
    public int getItemCount() {
        return list_recyclerview.size();
    }


}
