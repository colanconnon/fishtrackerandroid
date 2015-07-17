package com.colanconnon.fishtrackerandroid.Util;

import com.squareup.okhttp.RequestBody;

import org.json.JSONObject;

/**
 * Created by colanconnon on 7/15/15.
 */
public interface HttpRestService {
    JSONObject HttpJsonPostNoAuth(String json, String url);
    JSONObject HttpPostNoAuth(RequestBody formBody, String url);
    JSONObject HttpJsonPostWithAuth(String json, String url, String token);
}
