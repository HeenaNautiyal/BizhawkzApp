package com.bizhawkz.bizhawkzapplication;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class AboutUs extends AppCompatActivity {
    WebView web_about;
    ProgressDialog progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        web_about= (WebView) findViewById(R.id.web_about);
        web_about.getSettings().setJavaScriptEnabled(true);
        //  web_about.loadUrl("http://bizhawkz.com/management.html");

		/*
		 * store1.getSettings().setJavaScriptEnabled(true);
		 * store1.loadUrl("https://www.ecogreenhotel.com/store/");
		 */
        web_about.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);

        final AlertDialog alertDialog = new AlertDialog.Builder(this).create();

        progressBar = ProgressDialog.show(AboutUs.this, "Wait while page loads completely",
                "Loading...");

        web_about.setWebViewClient(new WebViewClient() {
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

                Toast.makeText(AboutUs.this, "Oh no! " + description,
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
        web_about.loadUrl("http://www.bizhawkz.com/about-bizhawkz/");
    }
}
