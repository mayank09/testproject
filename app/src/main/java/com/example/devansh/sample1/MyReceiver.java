package com.example.devansh.sample1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyReceiver extends BroadcastReceiver {
    public MyReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        if (intent.getAction().equals("YouWillNeverKillMe")) {
            context.startService(new Intent(context.getApplicationContext(), LaunchService.class));
        }

        if (intent.getAction().equals(Intent.ACTION_SCREEN_ON))
        {
            Log.d("###########", "screen on");
            Intent intent1 = new Intent(context, MainActivity.class);
            intent1.addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
            intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent1);
        } else if (intent.getAction().equals(Intent.ACTION_SCREEN_OFF)) {
            Log.d("###########", "screen off");

        }

    }
}
