package com.bizhawkz.bizhawkzapplication;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;

public class ContactUs extends AppCompatActivity {
    String result = null;
    InputStream is = null;
    ProgressDialog pDialog;
    Spinner s1, s2, s3;
    String first, second, third;
    String sp1[] = {"When would you like to start", "Immediatly",
            "Within 30 days", "30-60 days", "60-90 days"};
    String sp2[] = {"Your monthly marketing budget", "$500-$900",
            "$900-$1200", "$1200-$3000"};
    String sp3[] = {"Best time to call?", "8AM", "9AM", "10AM", "11AM",
            "12PM", "1PM", "2PM", "3PM", "4PM", "5PM", "6PM", "7PM", "8PM",
            "9PM", "10PM"};
    ArrayAdapter<String> arr;
    EditText name, email, mobile, skype, message;
    CheckBox chk1, chk2, chk3, chk4, chk5, chk6, chk7, chk8, chk9, chk10;
    Button btn_submit;
    String emailPattern = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    JsonParser perser = new JsonParser();

    StringBuilder result1;
    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
            .permitAll().build();


    String name1, mobile1, email1, skype1, message1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
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

                                                  String check = "";
                                                  result1 = new StringBuilder();

                                                  if (chk1.isChecked()) {
                                                      check += chk1.getText().toString() + ",";
                                                  }

                                                  if (chk2.isChecked()) {
                                                      check += chk2.getText().toString() + ",";
                                                  }
                                                  if (chk3.isChecked()) {
                                                      check += chk3.getText().toString() + ",";
                                                  }
                                                  if (chk4.isChecked()) {
                                                      check += chk4.getText().toString() + ",";
                                                  }
                                                  if (chk5.isChecked()) {
                                                      check += chk5.getText().toString() + ",";
                                                  }
                                                  if (chk6.isChecked()) {
                                                      check += chk6.getText().toString() + ",";
                                                  }
                                                  if (chk7.isChecked()) {
                                                      check += chk7.getText().toString() + ",";
                                                  }
                                                  if (chk8.isChecked()) {
                                                      check += chk8.getText().toString() + ",";
                                                  }
                                                  if (chk9.isChecked()) {
                                                      check += chk9.getText().toString() + ",";
                                                  }
                                                  if (chk10.isChecked()) {
                                                      check += chk10.getText().toString() + ",";
                                                  }

                                                  result1.append("" + check);

                                                  StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                                                          .permitAll().build();


                                                  String name1 = name.getText().toString();
                                                  String mobile1 = mobile.getText().toString();
                                                  String email1 = email.getText().toString();
                                                  String skype1 = skype.getText().toString();
                                                  String message1 = message.getText().toString();
                                                  if (name1.equals("") || mobile1.equals("")
                                                          || email1.equals("") || message1.equals("")) {
                                                      Toast.makeText(getApplicationContext(),
                                                              "All fields required", Toast.LENGTH_SHORT)
                                                              .show();

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
                                      }

        );
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

            try {
                // Building Parameters
                ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();

                nameValuePairs.add(new BasicNameValuePair("firstname",
                        name1));
                nameValuePairs.add(new BasicNameValuePair(
                        "mobile_phone", mobile1));
                nameValuePairs.add(new BasicNameValuePair("skype",
                        skype1));
                nameValuePairs.add(new BasicNameValuePair("comment",
                        message1));
                nameValuePairs.add(new BasicNameValuePair("useremail",
                        email1));
                nameValuePairs.add(new BasicNameValuePair("prjecttime",
                        first));
                nameValuePairs.add(new BasicNameValuePair("budget",
                        second));
                nameValuePairs.add(new BasicNameValuePair("q_time",
                        third));
                nameValuePairs.add(new BasicNameValuePair("services",
                        "" + result1));
                String url = "http://www.bizhawkz.com/msite/insert.php?page=2";
                Log.e("Url ", "" + url);
                JSONObject json = perser.getJSONFromUrl(url, nameValuePairs);
                Log.e("Exc",""+json);


                int w = json.getInt("udata");
                if (w == 1) {
                   /* Toast toast = Toast.makeText(getApplicationContext(),
                            "Your form submitted successfully", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();*/
                    Intent i = new Intent(ContactUs.this,
                            MainActivity.class);
                    startActivity(i);

                    finish();
                    return"Your form submitted successfully,we will contact you shortly";

                } if(w==2) {
                    return "Try Again";
                }


            } catch (Exception e) {
                e.printStackTrace();
                Log.e("Exception", "" + e.toString());
                return "Exception occured";
            }

            return null;
        }

        /**
         * After completing background task Dismiss the progress dialog
         **/
        protected void onPostExecute(String file_url) {
            // dismiss the dialog once product deleted
            pDialog.dismiss();
            if (file_url != null) {
                Toast tv = Toast.makeText(getApplicationContext(), file_url,
                        Toast.LENGTH_SHORT);
                tv.setGravity(Gravity.CENTER, 0, 0);
                tv.show();

            }
        }
    }
}
