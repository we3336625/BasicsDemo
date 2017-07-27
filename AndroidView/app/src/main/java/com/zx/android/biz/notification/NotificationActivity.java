package com.zx.android.biz.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.zx.android.R;
import com.zx.android.biz.view.view_group.frame_layout.scroll_view.ScrollViewActivity;

/**
 * notification 通知
 */
public class NotificationActivity extends AppCompatActivity {

    private NotificationManager notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void send(View view) {
        Intent intent = new Intent(this, ScrollViewActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        Notification notification = new Notification.Builder(this)
                // 点击通知 是否消失，（默认不消失）
                .setAutoCancel(true)
                .setTicker("通知 的 提示消息")
                .setContentTitle("通知 标题")
                .setContentText("通知 内容")
                .setContentIntent(pendingIntent)
                // 图标（必传）
                .setSmallIcon(R.mipmap.ic_launcher_round)
                .setWhen(System.currentTimeMillis())
                // 提示方式
                .setDefaults(Notification.DEFAULT_ALL)
                .build();
        notificationManager.notify(1000, notification);
    }

    public void clean(View view) {
        notificationManager.cancel(1000);
    }
}
