package com.view.mark.markcoderecyclerviewdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.view.mark.markcoderecyclerviewdemo.ui.FirstActivity;
import com.view.mark.markcoderecyclerviewdemo.ui.SecondActivity;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void doTextFloat(View view){
        startActivity(new Intent(this,FirstActivity.class));
    }

    public void doFloat(View view){
        startActivity(new Intent(this,SecondActivity.class));
    }
}
