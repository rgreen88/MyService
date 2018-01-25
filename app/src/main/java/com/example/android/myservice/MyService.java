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


    final class MyThreadClass implements Runnable{

        int service_id;
        MyThreadClass(int service_id){

            this.service_id = service_id;
        }

        //new thread (not UI)
        @Override
        public void run() {

            int i = 0;
            synchronized (this){

                while (i < 10){

                    try {
                        wait(1500);
                        i++;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }

                stopSelf(service_id); //id used to stop current thread service

            }

        }
    }

    //Service lifecycle
    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Toast.makeText(this, "Service Started...", Toast.LENGTH_LONG).show();

        //example of long service causing ANR on Main UI Thread and why a thread is useful to prevent ANRs
        //creating separate thread for this service prevents overload on UI Thread
        // this will be commented out to leave as an example and move the active code to new thread
//        int i = 0;
//        synchronized (this){
//
//            while (i < 10){
//
//                try {
//                    wait(1500);
//                    i++;
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//
//            }
//
//            stopSelf();
//
//        }


        //Starting newly created Thread
        Thread thread = new Thread(new MyThreadClass(startId));
        thread.start();// .start() is in Thread class

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
