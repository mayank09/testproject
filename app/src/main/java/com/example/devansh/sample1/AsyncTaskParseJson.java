package com.example.devansh.sample1;

import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by DEVansh on 14-10-2016.
 */

public class AsyncTaskParseJson extends AsyncTask<String, String, String> {
    final String TAG = "AsyncTaskParseJson.java";
    public static String isPush;

    // set your json string url here
    String yourJsonStringUrl = "http://192.168.1.3/anu/helloworld.php";

    @Override
    protected void onPreExecute() {}

    @Override
    protected String doInBackground(String... arg0) {

        // instantiate our json parser
        JSONParser jParser = new JSONParser();

        // get json string from url
        String myMessage = jParser.makeServiceCall(yourJsonStringUrl);
        String stringMessage = null;
        try {
            JSONObject jobject = new JSONObject(myMessage);
            stringMessage = jobject.getString("message");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.d("#####", stringMessage);
        isPush = stringMessage;

        return stringMessage;
    }

    @Override
    protected void onPostExecute(String strFromDoInBg) {}
}


