package com.example.lab2.lab2_main_part;

import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

// 声明该接口，以便于在Activity中直接设置view的点击动作。
public interface onRecyclerViewItemClickListener
{
    void onItemClick(RecyclerView parent, View view, int position, Bundle data);
    void onItemLongClick(RecyclerView parent, View view, int position);
}
