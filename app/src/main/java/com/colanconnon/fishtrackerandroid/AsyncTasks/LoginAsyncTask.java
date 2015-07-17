package com.colanconnon.fishtrackerandroid.AsyncTasks;

import android.content.Context;
import android.os.AsyncTask;

import org.json.JSONObject;

/**
 * Created by colanconnon on 7/15/15.
 */
public class LoginAsyncTask extends AsyncTask<Void,Void,JSONObject> {
    private Context context;
    private String url;

    public LoginAsyncTask(Context context){
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(JSONObject jsonObject) {
        super.onPostExecute(jsonObject);
    }

    @Override
    protected JSONObject doInBackground(Void... params) {
        return null;
    }
}
