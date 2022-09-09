package com.example.exampleapp;

import android.app.Notification;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class MainActivity extends AppCompatActivity {

    private NotificationManagerCompat notificationManager;
    private int notifid = 1;

    private Notification createNotif(String msg) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this,"1")
            .setSmallIcon(R.drawable.notif)
            .setContentTitle("App")
            .setContentText(msg)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        return builder.build();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notificationManager = NotificationManagerCompat.from(this);
//        this.createNotificationChannel();
        notificationManager.notify(notifid++, createNotif("Activity has been created"));
    }

    @Override
    protected void onStart() {
        super.onStart();
        notificationManager.notify(notifid++, createNotif("The activity has started!"));
    }

    @Override
    protected void onStop() {
        super.onStop();
        notificationManager.notify(notifid++, createNotif("The app has been closed!"));
    }

    @Override
    protected void onPause() {
        super.onPause();
        notificationManager.notify(notifid++, createNotif("Sent app to recents!"));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        notificationManager.notify(notifid++, createNotif("App closed!"));
    }

    @Override
    protected void onResume() {
        super.onResume();
        notificationManager.notify(notifid++, createNotif("The app resumed!"));
    }
}