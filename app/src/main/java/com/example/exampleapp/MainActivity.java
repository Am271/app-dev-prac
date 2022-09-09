package com.example.exampleapp;

import android.app.Notification;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class MainActivity extends AppCompatActivity {
    // Manifest includes a permission to post notifications
    private NotificationManagerCompat notificationManager; // Manager to issue notifications
    // it can only be initialised after the onCreate function runs
    private int notifid = 1; // a unique notification id for each notification

    private Notification createNotif(String msg) { // user defined method to create a simple notification
        // the builder takes the context and a channel id as parameters, channel id is relevant in android 8.0+
        // here I have used channel id as 1
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this,"1")
            .setSmallIcon(R.drawable.notif)
            .setContentTitle("App")
            .setContentText(msg)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        // the builder uses icon, notification title, notification text and its priority in this case
        // more properties can be added
        return builder.build(); // returns a Notification object
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) { // Method is run when the app is run from launcher
        super.onCreate(savedInstanceState);
        // set the activity layout
        setContentView(R.layout.activity_main);
        // initialise the notification manager
        notificationManager = NotificationManagerCompat.from(this);
//        this.createNotificationChannel();

        // display a notification
        notificationManager.notify(notifid++, createNotif("Activity has been created"));
        // increment the notifid so it stays unique
    }

    @Override
    protected void onStart() { // run after onCreate method is run
        super.onStart();
        notificationManager.notify(notifid++, createNotif("The activity has started!"));
    }

    @Override
    protected void onStop() { // run when the app is closed
        super.onStop();
        notificationManager.notify(notifid++, createNotif("The app has been closed!"));
    }

    @Override
    protected void onPause() { // run when the app is paused, i.e. other app is opened
        super.onPause();
        notificationManager.notify(notifid++, createNotif("Sent app to recents!"));
    }

    @Override
    protected void onDestroy() { // run when the app is closed ( back button usually closes it )
        super.onDestroy(); // finish the activity
        notificationManager.notify(notifid++, createNotif("App closed!"));
    }

    @Override
    protected void onResume() { // run when the app is resumed from recents or switched to from another app
        super.onResume(); // user returns to the activity
        // run after onStart is called
        notificationManager.notify(notifid++, createNotif("The app resumed!"));
    }
}