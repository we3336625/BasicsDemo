package com.zx.fragmenttest;

import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.zx.fragmenttest.Fragment.FragmentTest;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment, new FragmentTest());
        transaction.addToBackStack(null);
        transaction.commit();

        Log.i("test", "activity---->onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("test", "activity---->onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("test", "activity---->onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("test", "activity---->onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("test", "activity---->onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("test", "activity---->onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("test", "activity---->onDestroy");
    }
}
