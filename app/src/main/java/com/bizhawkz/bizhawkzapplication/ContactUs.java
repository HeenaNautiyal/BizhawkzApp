package com.bizhawkz.bizhawkzapplication;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.format.Formatter;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class ContactUs extends AppCompatActivity {
    String result = null;
    InputStream is = null;
    Toolbar toolbar;
    ProgressDialog pDialog;
    Spinner s1;
    Spinner s2;
    Spinner s3;String ip;
    String first, second, third,a1,a2,a3,a4,a5,a6,a7,a8,a9,a10;
    String sp1[] = {"   When would you like to start?", "   Immediately",
            "   Within 30 days", "   30-60 days", "   60-90 days"};
    String sp2[] = {"Your monthly marketing budget:", "$500-$900",
            "$900-$1200", "$1200-$3000"};
    String sp3[] = {"Best time to call?", "8AM", "9AM", "10AM", "11AM",
            "12PM", "1PM", "2PM", "3PM", "4PM", "5PM", "6PM", "7PM", "8PM",
            "9PM", "10PM"};
    ArrayAdapter<String> arr;
    EditText name, email, mobile, skype, message;
    CheckBox chk1, chk2, chk3, chk4, chk5, chk6, chk7, chk8, chk9, chk10;
    Button btn_submit;
    String emailPattern = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z]+(\\.[A-Za-z]+)*(\\.[A-Za-z]{2,})$";
    StringBuilder result1;
    String name1, mobile1, email1, skype1, message1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
        initToolBar();

        s1 = (Spinner) findViewById(R.id.s1);

        s2 = (Spinner) findViewById(R.id.s2);

        s3 = (Spinner) findViewById(R.id.s3);

        name = (EditText) findViewById(R.id.connect_name);
        email = (EditText) findViewById(R.id.connect_email);
        mobile = (EditText) findViewById(R.id.mobile);
        skype = (EditText) findViewById(R.id.skype);


        message = (EditText) findViewById(R.id.message);
        chk1 = (CheckBox) findViewById(R.id.chkAndroid1);
        chk2 = (CheckBox) findViewById(R.id.chkAndroid2);
        chk3 = (CheckBox) findViewById(R.id.chkAndroid3);
        chk4 = (CheckBox) findViewById(R.id.chkAndroid4);
        chk5 = (CheckBox) findViewById(R.id.chkAndroid5);
        chk6 = (CheckBox) findViewById(R.id.chkAndroid6);
        chk7 = (CheckBox) findViewById(R.id.chkAndroid7);
        chk8 = (CheckBox) findViewById(R.id.chkAndroid8);
        chk9 = (CheckBox) findViewById(R.id.chkAndroid9);
        chk10 = (CheckBox) findViewById(R.id.chkAndroid10);
        btn_submit = (Button) findViewById(R.id.btn_submit);
        WifiManager wm = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        ip = Formatter.formatIpAddress(wm.getConnectionInfo().getIpAddress());




        arr = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, sp1);
        arr.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s1.setAdapter(arr);
        arr = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, sp2);
        arr.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s2.setAdapter(arr);
        arr = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, sp3);
        arr.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s3.setAdapter(arr);

        s1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                // TODO Auto-generated method stub
                first = parent.getItemAtPosition(position).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });

        s2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                // TODO Auto-generated method stub
                second = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });

        s3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                // TODO Auto-generated method stub
                third = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });

        btn_submit.setOnClickListener(new View.OnClickListener() {

                                          @SuppressLint("NewApi")
                                          @SuppressWarnings("deprecation")
                                          @Override
                                          public void onClick(View v) {
                                              // TODO Auto-generated method stub
                                              ConnectivityManager cn = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
                                              NetworkInfo nf = cn.getActiveNetworkInfo();
                                              if (nf != null && nf.isConnected() == true) {

                                                  result1 = new StringBuilder();

                                                  if (chk1.isChecked()) {
                                                      a1 = "val1";
                                                  }
                                                  else{
                                                      a1="%20";
                                                  }

                                                  if (chk2.isChecked()) {
                                                      a2 ="val2";
                                                  }
                                                  else{
                                                      a2="%20";
                                                  }
                                                  if (chk3.isChecked()) {
                                                      a3 = "val3";
                                                  }
                                                  else{
                                                      a3="%20";
                                                  }
                                                  if (chk4.isChecked()) {
                                                      a4 = "val4";
                                                  } else{
                                                      a4="%20";
                                                  }
                                                  if (chk5.isChecked()) {
                                                      a5 = "val5";
                                                  }
                                                  else{
                                                      a5="%20";
                                                  }
                                                  if (chk6.isChecked()) {
                                                      a6 ="val6";
                                                  }
                                                  else{
                                                      a6="%20";
                                                  }
                                                  if (chk7.isChecked()) {
                                                      a7 = "val7";
                                                  }
                                                  else{
                                                      a7="%20";
                                                  }
                                                  if (chk8.isChecked()) {
                                                      a8 = "val8";
                                                  }
                                                  else{
                                                      a8="%20";
                                                  }
                                                  if (chk9.isChecked()) {
                                                      a9 = "val9";
                                                  }
                                                  else{
                                                      a9="%20";
                                                  }
                                                  if (chk10.isChecked()) {
                                                      a10 ="val10";
                                                  }
                                                  else{
                                                      a10="%20";
                                                  }
                                                  name1 = name.getText().toString();
                                                   mobile1 = mobile.getText().toString();
                                                   email1 = email.getText().toString();
                                                   skype1 = skype.getText().toString();
                                                   message1 = message.getText().toString();

                                                  if (name1.equals("") || mobile1.equals("")
                                                          || email1.equals("") || message1.equals("")) {
                                                      {
                                                          AlertDialog.Builder builder = new AlertDialog.Builder(ContactUs.this);
                                                          TextView myMsg = new TextView(ContactUs.this);
                                                          myMsg.setText("Warning!");
                                                          myMsg.setGravity(Gravity.CENTER_HORIZONTAL);
                                                          myMsg.setTextSize(20);

                                                          myMsg.setTextColor(Color.BLACK);
                                                          builder.setCustomTitle(myMsg);
                                                          builder.setMessage("All fields are mandatory.");
                                                          builder.setPositiveButton("OK",
                                                                  new DialogInterface.OnClickListener() {
                                                                      public void onClick(DialogInterface dialog,
                                                                                          int which) {
                                                                          dialog.cancel();
                                                                      }
                                                                  });
                                                          builder.show();
                                                         }
                                                      } else if (!email1.matches(emailPattern)) {
                                                      Toast.makeText(getApplicationContext(),
                                                              "Enter valid emailId", Toast.LENGTH_SHORT)
                                                              .show();
                                                  } else if (first.equals("When would you like to start")) {
                                                      Toast.makeText(getApplicationContext(),
                                                              "When would you like to start?",
                                                              Toast.LENGTH_SHORT).show();

                                                  } else if (second.equals("Your monthly marketing budget")) {
                                                      Toast.makeText(
                                                              getApplicationContext(),
                                                              "Please tell us your monthly marketing budget?",
                                                              Toast.LENGTH_SHORT).show();

                                                  } else if (third.equals("Best time to call?")) {
                                                      Toast.makeText(getApplicationContext(),
                                                              "Tell us best time to call?",
                                                              Toast.LENGTH_SHORT).show();

                                                  } else {
                                                      new AttemptLogin().execute();
                                                  }
                                              } else {
                                                  Toast.makeText(getApplicationContext(),
                                                          "No Internet Connection", Toast.LENGTH_SHORT)
                                                          .show();
                                              }
                                          }
                                      });}

    private void initToolBar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Contact Us");
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);

        toolbar.setNavigationIcon(R.drawable.back2_icon);
        toolbar.setNavigationOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent It = new Intent(ContactUs.this, MainActivity.class);
                        startActivity(It);
                    }
                });
    }

    class AttemptLogin extends AsyncTask<String, String, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(ContactUs.this);
            pDialog.setMessage("WAIT...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(false);
            pDialog.show();
        }

        @Override
        protected String doInBackground(String... args) {
            // TODO Auto-generated method stub
            // Check for success tag
            HttpClient httpClient = new DefaultHttpClient();
            String url = "http://bizhawkz.com/aPP_MoB_ile/insertdata.php?caseid=2&name="+name1+"&email="+email1+"" +
                    "&phone="+ mobile1+"&s1="+a1.replaceAll(" ", "")+"&s2="+a2.replaceAll(" ", "")+"" +
                    "&s3="+a3.replaceAll(" ", "")+ "&s4="+ a4.replaceAll(" ", "")+"&s5="+a5.replaceAll(" ", "")+"" +
                    "&s6="+a6.replaceAll(" ", "")+ "&s7="+ a7.replaceAll(" ", "")+"&s8="+a8.replaceAll(" ", "")+"" +
                    "&s9="+a9.replaceAll(" ", "")+ "&s10="+ a10.replaceAll(" ", "")+"" +
                    "&comment=" + message1.replaceAll(" ", "%20") + "&skype=" + skype1 + "&prTime=12:00" +
                    "&budgets=" + second.replaceAll(" ", "%20") + "&q_time=" + third.replaceAll(" ", "") + "" +
                    "&ip="+ip+"";
            String SetServerString = "";
            HttpGet httpget = new HttpGet(url);
            ResponseHandler<String> responseHandler = new BasicResponseHandler();
            try {
                SetServerString = httpClient.execute(httpget, responseHandler);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Log.d("Response: ", "> " + SetServerString);
            return SetServerString;
        }

        protected void onPostExecute(String result) {

            try {
                pDialog.dismiss();
                JSONObject jsonResult = new JSONObject(result);
                String message = jsonResult.getString("udata");
                Log.d("Response: ", "> " + message);
                if (message.equals("1")) {

                    AlertDialog.Builder builder = new AlertDialog.Builder(ContactUs.this);
                    TextView myMsg = new TextView(ContactUs.this);
                    myMsg.setText("Congratulations!");
                    myMsg.setGravity(Gravity.CENTER_HORIZONTAL);
                    myMsg.setTextSize(20);
                    myMsg.setTextColor(Color.BLACK);
                    builder.setCustomTitle(myMsg);
                    builder.setMessage("Thank you for contacting us.\n We will get back to you soon. ");
                    builder.setPositiveButton("Continue",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,
                                                    int which) {
                                    Intent it = new Intent(ContactUs.this, MainActivity.class);
                                    startActivity(it);

                                }
                            });
                    builder.show();
                }
            }
                    catch(JSONException e){
                    e.printStackTrace();
                }
            }
        }
}