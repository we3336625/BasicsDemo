package com.zx.gesturetest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();

    // 手势检测器
    GestureDetector gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gestureDetector = new GestureDetector(this, listener);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }

    GestureDetector.OnGestureListener listener = new GestureDetector.OnGestureListener() {

        // 触碰事件按下时触发
        @Override
        public boolean onDown(MotionEvent e) {
            Log.i(TAG, "--------->   onDown: ");
            return false;
        }

        // 用户按下，且还未移动和松开时触发
        @Override
        public void onShowPress(MotionEvent e) {
            Log.i(TAG, "---------->  onShowPress: ");
        }

        // 用户轻击时触发
        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            Log.i(TAG, "---------->  onSingleTapUp: ");
            return false;
        }

        // 用户在屏幕上"滚动"时触发
        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            Log.i(TAG, "----------->  onScroll:  distanceX:  " + distanceX + "  distanceY:  " + distanceY);
            return false;
        }

        // 用户长按时触发
        @Override
        public void onLongPress(MotionEvent e) {
            Log.i(TAG, "----------->  onLongPress:  ");
        }

        // 用户在触摸屏上"拖动"时触发
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            Log.i(TAG, "----------->  onFling:   velocityX:  " + velocityX + "   velocityY:  " + velocityY);
            return false;
        }
    };
}
