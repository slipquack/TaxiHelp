package com.example.quack_do.taxihelp3;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Quack-Do on 09.10.2017.
 */

public class RentActivity extends MainActivity {

    private WebView mWebView;
    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rent);

        mWebView = (WebView) findViewById(R.id.webview);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.loadUrl("http://slipqufe.beget.tech/assets/rent/index.html");
        mWebView.setWebViewClient(new MyWebViewClient());
        //mWebView.setWebViewClient(new InternalWebViewClient());

    }
    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
    //если "тел:" набирает номер иначе загрузка главной страницы сайта
    private class InternalWebViewClient extends WebViewClient {
        @Override
        public  boolean shouldOverrideUrlLoading(WebView view, String url) {
            if (url.indexOf("tel:") > 0) {
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(url)));
                return true;
            } else {
                view.loadUrl(url);
                return true;
            }
        }
    }
    @Override
    public void onBackPressed() {
        if (mWebView.canGoBack()) {
            mWebView.goBack();
        } else {
            super.onBackPressed();
        }
    }

}
