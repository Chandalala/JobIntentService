package com.chandalala.jobintentservice;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.JobIntentService;

public class ExampleJobIntentService extends JobIntentService {

    private static final String TAG = "ExampleJobIntentService";

    //The method below will run as either as intent service or as a job service
    @Override
    protected void onHandleWork(@NonNull Intent intent) {
        //This is where we do our background work
        Log.d(TAG, "onHandleWork: ");

        String input = intent.getStringExtra("inputExtra");

        for (int i = 0; i < 10; i++){
            Log.d(TAG, input+" - " + i);

            if (isStopped()) return; //Stopping the intent service

            SystemClock.sleep(1000);
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: ");

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    @Override
    public boolean onStopCurrentWork() {
        return super.onStopCurrentWork();
    }

    //Call this method from wherever you wana start the job service
    static void enqueueWork(Context context, Intent work){
        enqueueWork(context, ExampleJobIntentService.class, 123, work);
    }
}
