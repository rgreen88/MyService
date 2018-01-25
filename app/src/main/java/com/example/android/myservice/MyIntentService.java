package com.example.android.myservice;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by rynel on 1/25/2018.
 */

public class MyIntentService extends IntentService{
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * Empty param with String literal used to name the worker thread, important only for debugging.
     */
    public MyIntentService() {
        super("My_Worker_Thread"); //reference for debugging
    }

    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {

        Toast.makeText(this, "Service Started... ", Toast.LENGTH_LONG).show();

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {

        Toast.makeText(this, "Service Destroyed... ", Toast.LENGTH_LONG).show();

        super.onDestroy();
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

        synchronized (this){

            int count = 0;
            while (count < 10){

                try {
                    wait(1500); //15 seconds
                    count++;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        }

    }
}
