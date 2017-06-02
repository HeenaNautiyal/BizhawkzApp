package com.bizhawkz.bizhawkzapplication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.URLUtil;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Affiliate extends AppCompatActivity {
    Toolbar toolbar;
    WebView webView;
    ProgressDialog pb;
    String url;
    SwipeRefreshLayout mySwipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affiliate);
        mySwipeRefreshLayout = (SwipeRefreshLayout) this.findViewById(R.id.swipeContainer);
        webView = (WebView) findViewById(R.id.web_home);
        initToolBar();


        pb = new ProgressDialog(Affiliate.this);
        pb.setMessage("Please wait while Loading...");
        pb.show();
        pb.setCancelable(false);


        url = "http://www.bizhawkz.com/";
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                webView.loadUrl("javascript:document.getElementById(\"menu-item-25\").setAttribute(\"style\",\"display:none;\");");
                webView.loadUrl("javascript:(function() { " +
                        "document.getElementsByClassName('menu_wrapper')[0].style.display='none'; })()");
                pb.dismiss();
                mySwipeRefreshLayout.setRefreshing(false);
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if( URLUtil.isNetworkUrl(url) ) {
                    return false;
                }

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity( intent );
                return true;
            }
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
               /* Intent it = new Intent(Home.this, Network.class);
                startActivity(it);}*/
            }
        });
        webView.loadUrl(url);
        mySwipeRefreshLayout.setOnRefreshListener(
                new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {
                        pb = new ProgressDialog(Affiliate.this);
                        pb.setMessage("Please wait while Loading...");
                        pb.show();
                        pb.setCancelable(false);
                        webView.reload();
                    }
                }
        );
    }

    private void initToolBar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Affiliate");
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);

        toolbar.setNavigationIcon(R.drawable.back2_icon);
        toolbar.setNavigationOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent It = new Intent(Affiliate.this, MainActivity.class);
                        startActivity(It);
                    }
                });
    }

    public void onResume() {
        super.onResume();
    }

    @Override
    public void onBackPressed() {

        if (webView.canGoBack()) {
            pb.show();
            webView.goBack();
        } else {
            super.onBackPressed();
        }

    }
    }
