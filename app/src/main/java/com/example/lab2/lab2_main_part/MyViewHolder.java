package com.example.lab2.lab2_main_part;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab2.R;

public class MyViewHolder extends RecyclerView.ViewHolder {
    private TextView myView;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        myView = itemView.findViewById(R.id.text);
    }

    public void bind(String text) {
        myView.setText(text);
    }
}
