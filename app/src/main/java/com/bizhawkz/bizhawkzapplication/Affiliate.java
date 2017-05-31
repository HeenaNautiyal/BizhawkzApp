package com.bizhawkz.bizhawkzapplication;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class Affiliate extends AppCompatActivity {
    WebView web_affiliate;
    ProgressDialog progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affiliate);
        web_affiliate = (WebView) findViewById(R.id.web_affiliate);
        web_affiliate.getSettings().setJavaScriptEnabled(true);
        web_affiliate.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);

        final AlertDialog alertDialog = new AlertDialog.Builder(this).create();

        progressBar = ProgressDialog.show(Affiliate.this, "Wait while page loads completely",
                "Loading...");

        web_affiliate.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView view, String url) {

                view.loadUrl(url);
                return true;
            }

            public void onPageFinished(WebView view, String url) {

                if (progressBar.isShowing()) {
                    progressBar.dismiss();
                }
            }

            @SuppressWarnings("deprecation")
            public void onReceivedError(WebView view, int errorCode,
                                        String description, String failingUrl) {

                Toast.makeText(Affiliate.this, "Oh no! " + description,
                        Toast.LENGTH_SHORT).show();
                alertDialog.setTitle("Error");
                alertDialog.setMessage(description);
                alertDialog.setButton("OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int which) {
                                return;
                            }
                        });
                alertDialog.show();
            }
        });

        web_affiliate.loadUrl("http://www.bizhawkz.com/affiliates/");
    }
}
