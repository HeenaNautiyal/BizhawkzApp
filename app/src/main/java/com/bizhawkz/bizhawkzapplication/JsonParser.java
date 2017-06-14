package com.bizhawkz.bizhawkzapplication;

import android.os.StrictMode;
import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by heena on 6/6/2017.
 */

public class JsonParser {
    String result = null;
    InputStream is = null;
    JSONObject json_data;
    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
            .permitAll().build();


    public JSONObject getJSONFromUrl(String url,
                                     ArrayList<NameValuePair> nameValuePairs) {
        // Making HTTP request
        StrictMode.setThreadPolicy(policy);
        String SetServerString = "";
        // http post
        try {
            HttpClient httpclient = new DefaultHttpClient();
            HttpGet httpget = new HttpGet(url+"?"+URLEncodedUtils.format(nameValuePairs, "utf-8"));
            HttpResponse response = httpclient.execute(httpget);
            HttpEntity entity = response.getEntity();
            is = entity.getContent();
            // Log.e("log_tag", "connection success ");
        }
        catch (Exception e) {
            // Log.e("log_tag", "Error in http connection "+e.toString());
        }
        // convert response to string
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    is, "iso-8859-1"), 8);
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            is.close();

            result = sb.toString();
            Log.e("log_tag", "Error34" + result);

        } catch (Exception e) {
            // Log.e("log_tag", "Error converting result "+e.toString());
        }

        try {
            json_data = new JSONObject(result);

        }

        catch (JSONException e) {
            Log.e("log_tag", "Error parsing data " + e.toString());

        }
        return json_data;
    }
}
