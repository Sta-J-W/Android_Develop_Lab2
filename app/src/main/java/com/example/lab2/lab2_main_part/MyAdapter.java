package com.example.lab2.lab2_main_part;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab2.R;

import java.util.ArrayList;
import java.util.List;




public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> implements View.OnClickListener {
    @NonNull
    private List<String> myItems = new ArrayList<>();
    private onRecyclerViewItemClickListener myRVCL;
    private RecyclerView parentRV;

    //定义一个公用方法，可以在Activity中来绑定接口事件
    public void setOnItemClickListener(onRecyclerViewItemClickListener onRecyclerViewItemClickListener) {
        this.myRVCL = onRecyclerViewItemClickListener;
    }

    //重载点击事件，指定点击事件时执行自定义的onItemClick
    @Override
    public void onClick(View view) {
        //此时就用到上面拉出来的那个 rvParent 了
        int position = parentRV.getChildAdapterPosition(view);
        Bundle data = new Bundle();
        data.putString("text", myItems.get(position));
        if (myRVCL != null)
            myRVCL.onItemClick(parentRV, view, position, data);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        parentRV = (RecyclerView) parent;
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycle_2_item,parent,false);
        view.setOnClickListener(this);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position){
        holder.bind(myItems.get(position));
    }

    @Override
    public int getItemCount(){return myItems.size();}

    public void notifyItems(@NonNull List<String> items){
        myItems.clear();
        myItems.addAll(items);
        notifyDataSetChanged();
    }

    public void notifySingle(int index, String str){
        myItems.set(index, str);
        notifyItemChanged(index);
    }

    @Override
    public int getItemViewType(int position)
    {
        return position % 2;
    }


}
