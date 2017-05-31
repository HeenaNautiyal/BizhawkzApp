package com.bizhawkz.bizhawkzapplication;

import android.os.StrictMode;
import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by Heena on 5/29/2017.
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

        // http post
        try {
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost(url);
            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
            HttpResponse response = httpclient.execute(httppost);
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
                // Intent i = new Intent(getBaseContext(),Register2.class);
                // startActivity(i);
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