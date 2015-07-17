package com.colanconnon.fishtrackerandroid.Util;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

/**
 * Created by colanconnon on 7/15/15.
 */
public class HttpRestServices implements HttpRestService {
    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");

    OkHttpClient client = new OkHttpClient();

    @Override
    public JSONObject HttpJsonPostNoAuth(String json, String url){
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .addHeader("Content-Type", "Application/Json")
                .url(url)
                .post(body)
                .build();
        try{
            Response response = client.newCall(request).execute();
            return new JSONObject(response.body().string());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public JSONObject HttpJsonPostWithAuth(String json, String url, String token) {
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .addHeader("Authorization","Bearer " + token)
                .addHeader("Content-Type", "Application/Json")
                .url(url)
                .post(body)
                .build();
        try{
            Response response = client.newCall(request).execute();
            return new JSONObject(response.body().string());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public JSONObject HttpPostNoAuth(RequestBody formBody, String url) {
        Request request = new Request.Builder()
                .url(url)
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .post(formBody)
                .build();
        try{
            Response response = client.newCall(request).execute();
            return new JSONObject(response.body().string());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  null;
    }
}
