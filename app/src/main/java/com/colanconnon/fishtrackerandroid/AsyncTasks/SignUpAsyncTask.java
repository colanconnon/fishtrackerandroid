package com.colanconnon.fishtrackerandroid.AsyncTasks;

import android.os.AsyncTask;

import com.colanconnon.fishtrackerandroid.Util.HttpRestService;
import com.colanconnon.fishtrackerandroid.Util.HttpRestServices;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by colanconnon on 7/17/15.
 */
public class SignUpAsyncTask extends AsyncTask<Void,Void,JSONObject> {
    private String email;
    private String password;
    private String confirmPassword;
    private HttpRestService httpRestService;
    private final static String url = "http://fishtracker.azurewebsites.net/api/AccountApi/SignUp/";

    @Override
    protected void onPostExecute(JSONObject jsonObject) {
        super.onPostExecute(jsonObject);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected JSONObject doInBackground(Void... params) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("Email", email);
            jsonObject.put("Password", password);
            jsonObject.put("ConfirmPassword", confirmPassword);
            return httpRestService.HttpJsonPostNoAuth(jsonObject.toString(), url);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public SignUpAsyncTask(String email, String password, String confirmPassword) {
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
        httpRestService = new HttpRestServices();
    }
}
