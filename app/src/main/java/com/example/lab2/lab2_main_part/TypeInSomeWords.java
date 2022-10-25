package com.example.lab2.lab2_main_part;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.lab2.R;


public class TypeInSomeWords extends AppCompatActivity {
    String TAG = "TypeSomeWords";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type_in_some_words);
        TextView title = findViewById(R.id.title_type_in_some_words);
        String t = title.getText().toString();
        t = t + getIntent().getStringExtra("extra");
        title.setText(t);
        Button exit = findViewById(R.id.quit_type_in_some_words);

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setReturnValue();
                finish();
            }
        });
    }

    private void setReturnValue(){
        Intent backintent = new Intent();
        EditText edt = findViewById(R.id.et_type_in_some_words);
        backintent.putExtra("return value", edt.getText().toString());
        int index = getIntent().getIntExtra("index", -1);
        backintent.putExtra("index", index);
        Log.i("onActivityResult", "rv: "+edt.getText().toString()+" idx:"+index);
        setResult(RESULT_OK, backintent);
    }

    @Override
    public void onBackPressed() {
        setReturnValue();
        super.onBackPressed();
    }

    @Override
    protected void onStop() {
        Log.i(TAG, "onStop!");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.i(TAG, "onDestroy!");
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        Log.i(TAG, "onPause!");

        super.onPause();
    }
}