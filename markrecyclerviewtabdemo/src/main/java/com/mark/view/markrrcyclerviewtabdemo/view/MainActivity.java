package com.mark.view.markrrcyclerviewtabdemo.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.mark.view.markrrcyclerviewtabdemo.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
    }

    public void toSticky(View view) {
        startActivity(new Intent(this, StickyRecyclerViewActivity.class));
    }

    public void toStickyGrid(View view) {
        Intent intent = new Intent(this, StickyRecyclerViewActivity.class);
        intent.putExtra("type", "grid");
        startActivity(intent);
    }

    public void toPowerfulSticky(View view) {
        startActivity(new Intent(this, PowerfulStickyRecyclerViewActivity.class));
    }

    public void toPowerfulStickyGrid(View view) {
        Intent intent = new Intent(this, PowerfulStickyRecyclerViewActivity.class);
        intent.putExtra("type", "grid");
        startActivity(intent);
    }

    public void toPowerfulSticky2(View view) {
        startActivity(new Intent(this, BeautifulRecyclerViewActivity.class));
    }
}
