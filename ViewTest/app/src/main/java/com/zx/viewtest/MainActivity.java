package com.zx.viewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.zx.viewtest.view.ArcView;
import com.zx.viewtest.view.RectView;
import com.zx.viewtest.view.TopBar;

public class MainActivity extends AppCompatActivity {
    float sweepValue = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TopBar topBar = (TopBar) findViewById(R.id.topBar);

        topBar.setTopOnClickListener(new TopBar.TopOnClickListener() {
            @Override
            public void onRightClick() {
                Toast.makeText(MainActivity.this, "right click", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLeftClick() {
                Toast.makeText(MainActivity.this, "left click", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTitleClick() {
                Toast.makeText(MainActivity.this, "title click", Toast.LENGTH_SHORT).show();
            }
        });
        topBar.setVisible(TopBar.RIGHT_BUTTON_VISIBLE, false);

//
//        final ArcView arcView = (ArcView) findViewById(R.id.arcView);
//        arcView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "ArcView", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//
//        final RectView rectView = (RectView) findViewById(R.id.rectView);
//        rectView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "RectView", Toast.LENGTH_SHORT).show();
//            }
//        });
    }
}
