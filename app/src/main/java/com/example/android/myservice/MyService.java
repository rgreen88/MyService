package com.example.android.myservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by rynel on 1/25/2018.
 */

public class MyService extends Service {

    //Service lifecycle


    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Toast.makeText(this, "Service Started...", Toast.LENGTH_LONG).show();
        return START_STICKY; //constant class that comes standard with service

    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {

        Toast.makeText(this, "Service Destroyed...", Toast.LENGTH_SHORT).show();

    }
}
