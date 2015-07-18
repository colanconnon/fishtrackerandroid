package com.colanconnon.fishtrackerandroid.AsyncTasks;

import android.content.Context;
import android.os.AsyncTask;

import com.colanconnon.fishtrackerandroid.Util.HttpRestService;
import com.colanconnon.fishtrackerandroid.Util.HttpRestServices;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.RequestBody;

import org.json.JSONObject;

/**
 * Created by colanconnon on 7/15/15.
 */
public class LoginAsyncTask extends AsyncTask<Void,Void,JSONObject> {
    private final String url = "http://fishtracker.azurewebsites.net/Authenticate";
    private HttpRestService httpRestService;
    private String username;
    private String password;

    public LoginAsyncTask(String username, String password){
        this.username = username;
        this.password = password;
        httpRestService = new HttpRestServices();
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
        RequestBody formBody = new FormEncodingBuilder()
                .add("username", username)
                .add("password", password)
                .add("grant_type", "password")
                .build();
        JSONObject json = httpRestService.HttpPostNoAuth(formBody, url);
        return json;
    }
}
