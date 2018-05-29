package com.example.binxie.helloworld;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewActivity extends AppCompatActivity {

    private WebView mWv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        mWv = findViewById(R.id.wv);
//        mWv.loadUrl("file:///android_asset/Myh5.html");

        mWv.setWebViewClient(new MyWebViewClient());
        mWv.setWebChromeClient(new MyWebChromeClient());
        mWv.getSettings().setJavaScriptEnabled(true);
        mWv.loadUrl("https://m.baidu.com");
    }

    class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            view.loadUrl(request.getUrl().toString());
            return super.shouldOverrideUrlLoading(view, request);
        }


        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            Log.d("WebView", "onPageStarted......");
        }


        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            Log.d("WebView", "onPageFinished......");
//            mWv.loadUrl("javascript:alert('小朋友真可爱')");
//            mWv.evaluateJavascript("javascript:alert('小朋友真可爱')", null);
//            mWv.addJavascriptInterface();
        }
    }


    class MyWebChromeClient extends WebChromeClient {
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            super.onProgressChanged(view, newProgress);
        }

        @Override
        public void onReceivedTitle(WebView view, String title) {
            super.onReceivedTitle(view, title);
            setTitle(title);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if(keyCode == KeyEvent.KEYCODE_BACK && mWv.canGoBack()) {
            mWv.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
