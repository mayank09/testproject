package com.example.devansh.sample1;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.IBinder;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.util.Log;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;

import static android.R.attr.filter;

public class LaunchService extends Service {
    String push_message = null;

    public LaunchService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        // REGISTER RECEIVER THAT HANDLES SCREEN ON AND SCREEN OFF LOGIC
    }



    @Override
    public int onStartCommand(Intent intent,int flag , int startId) {

       // String myString = intent.getStringExtra("User Id");
      //          AsyncTaskParseJson asyncTaskParseJson = new AsyncTaskParseJson();





      IntentFilter filter = new IntentFilter(Intent.ACTION_SCREEN_ON);
        BroadcastReceiver mReceiver = new MyReceiver();
        registerReceiver(mReceiver, filter);
        Toast.makeText(getApplicationContext()
                , "service started",Toast.LENGTH_SHORT).show();


        //   filter.addAction(Intent.ACTION_SCREEN_OFF);

     /* if(push_message.equals("1")){
            IntentFilter filter = new IntentFilter(Intent.ACTION_SCREEN_ON);
            BroadcastReceiver mReceiver = new MyReceiver();
            registerReceiver(mReceiver, filter);
            Toast.makeText(getApplicationContext()
                    , "service started",Toast.LENGTH_SHORT).show();
        }*/


        Log.e("#########Service","onStartCommand");

        return START_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.e("######service destroy", "service destroy");
       sendBroadcast(new Intent("YouWillNeverKillMe"));
    }
}
