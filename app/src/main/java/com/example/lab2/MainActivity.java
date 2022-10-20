package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplication1.MainActivity01;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button butt1 = findViewById(R.id.lab2_button1);
        butt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "To Lab1!", Toast.LENGTH_SHORT).show();
                Intent toLab1 = new Intent(MainActivity.this, MainActivity01.class);
                startActivity(toLab1);
            }
        });
    }
}