package com.bizhawkz.bizhawkzapplication;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView home, about, share, contact, portfolio, affiliate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        home = (ImageView) findViewById(R.id.home);
        about = (ImageView) findViewById(R.id.iv_event);
        share = (ImageView) findViewById(R.id.ivshare);
        contact = (ImageView) findViewById(R.id.iv_contactus);
        affiliate = (ImageView) findViewById(R.id.iv_affiliate);
        portfolio = (ImageView) findViewById(R.id.iv_portfolio);
        home.setOnClickListener(this);
        about.setOnClickListener(this);
        share.setOnClickListener(this);
        contact.setOnClickListener(this);
        portfolio.setOnClickListener(this);
        affiliate.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        if (v == home) {
            ConnectivityManager cn = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo nf = cn.getActiveNetworkInfo();
            if (nf != null && nf.isConnected() == true) {
                Intent intent = new Intent(MainActivity.this, Home.class);
                startActivity(intent);
            } else {
                Toast toast = Toast.makeText(getApplicationContext(), "Check your Internet Connection", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
            }
        }
        if (v == about) {
            ConnectivityManager cn = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo nf = cn.getActiveNetworkInfo();
            if (nf != null && nf.isConnected() == true) {
                Intent intent = new Intent(MainActivity.this, AboutUs.class);
                startActivity(intent);
            } else {
                Toast toast = Toast.makeText(getApplicationContext(), "Check your Internet Connection", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
            }
        }
        if (v == share) {
            Intent sharingIntent = new Intent(Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            String shareBody = "https://play.google.com/store/apps/details?id=com.cadirectory.directory";
            sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "It is finally here! Download  BIZHAWKZ android app\n");
            sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
            startActivity(Intent.createChooser(sharingIntent, "Share via"));


        }
        if (v == contact) {
            ConnectivityManager cn = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo nf = cn.getActiveNetworkInfo();
            if (nf != null && nf.isConnected() == true) {
                Intent intent = new Intent(MainActivity.this, ContactUs.class);
                startActivity(intent);
            } else {
                Toast toast = Toast.makeText(getApplicationContext(), "Check your Internet Connection", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
            }
        }
        if (v == affiliate) {
            ConnectivityManager cn = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo nf = cn.getActiveNetworkInfo();
            if (nf != null && nf.isConnected() == true) {
                Intent intent = new Intent(MainActivity.this, Affiliate.class);
                startActivity(intent);
            } else {
                Toast toast = Toast.makeText(getApplicationContext(), "Check your Internet Connection", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
            }
        }
        if (v == portfolio) {
            ConnectivityManager cn = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo nf = cn.getActiveNetworkInfo();
            if (nf != null && nf.isConnected() == true) {
                Intent intent = new Intent(MainActivity.this, Portfolio.class);
                startActivity(intent);
            } else {
                Toast toast = Toast.makeText(getApplicationContext(), "Check your Internet Connection", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
            }
        }


    }
}
