package com.example.lab2.lab2_main_part;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.lab2.R;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewInLab2 extends AppCompatActivity {

    RecyclerView myRecyclerView;
    MyAdapter myAdapter = new MyAdapter();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_in_lab2);
        myAdapter.setOnItemClickListener(new onRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(RecyclerView parent, View view, int position, Bundle data) {
                Intent intent = new Intent(RecyclerViewInLab2.this, TypeInSomeWords.class);
                intent.putExtra("index", position);
                intent.putExtra("extra", data.getString("text"));
                startActivityForResult(intent, 1);
            }

            @Override
            public void onItemLongClick(RecyclerView parent, View view, int position) {

            }
        });

        myRecyclerView = findViewById(R.id.recyclerView2);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        myRecyclerView.setAdapter(myAdapter);

        List<String> items = new ArrayList<>();
        for (int i = 1; i <=100; ++i){
            items.add("Option: " + i);
        }
        myAdapter.notifyItems(items);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        switch (requestCode){
            case 1:
                Log.i("onActivityResult", "Enter"+resultCode);
                if (resultCode == RESULT_OK){
                    assert data != null;
                    String return_value = data.getStringExtra("return value");
                    Log.i("onActivityResult", return_value);
                    int index = data.getIntExtra("index", -1);
                    if (return_value.equals("")) break;
                    if (index == -1) break;
                    Log.i("onActivityResult", String.valueOf(index));
                    myAdapter.notifySingle(index, return_value);
                }
                break;
            default:
        }
        super.onActivityResult(requestCode, resultCode, data);

    }
}