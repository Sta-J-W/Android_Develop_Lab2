package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.lab2.lab2_main_part.RecyclerViewInLab2;
import com.example.myapplication1.MainActivity01;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button1 = findViewById(R.id.lab2_button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "To Lab1!", Toast.LENGTH_SHORT).show();
                Intent toLab1 = new Intent(MainActivity.this, MainActivity01.class);
                startActivity(toLab1);
            }
        });

        Button button2 = findViewById(R.id.lab2_button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "To lab2!", Toast.LENGTH_SHORT).show();
                Intent toLab2 = new Intent(MainActivity.this, RecyclerViewInLab2.class);
                startActivity(toLab2);
            }
        });

    }
}