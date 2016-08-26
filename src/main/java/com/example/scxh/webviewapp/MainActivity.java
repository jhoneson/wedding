package com.example.scxh.webviewapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
    private WebView mWebView;

    private interface MyJavaScriptInterface{
        void showToast();
        String htmlToNativeToJs();
        String showbaidu();
        String  showSina();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mWebView = (WebView) findViewById(R.id.web_view);
        setJavascriptInterface();
        loadData();
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        });
    }

    /**
     * 设置javaScript与android原生应用交互接口
     */
    public void setJavascriptInterface() {
        //第一步 设置javascript 可用
        mWebView.getSettings().setJavaScriptEnabled(true);

        //第三步 添加javaScript交互接口到webview
        MyJavaScriptInterface myJavaScriptInterface = new MyJavaScriptInterface() {
            @JavascriptInterface
            @Override
            public void showToast() {
                startActivity(new Intent(MainActivity.this, LoginActivity.class));

            }
            @JavascriptInterface
            @Override
            public String htmlToNativeToJs() {
                return "http://it.warmtel.com";
            }
            @JavascriptInterface
            @Override
            public String showbaidu() {
             return "http://www.baidu.com";
            }
            @JavascriptInterface
            @Override
            public String showSina() {
                return "http://www.sina.com";
            }
        };
        /**
         * WebView.addJavascriptInterface(Object,String)方法
         * Object 交互接口对象
         * String 交互接口名称
         */

        mWebView.addJavascriptInterface(myJavaScriptInterface, "MyJavaScriptInterface");
    }
    public void loadData(){
      mWebView.loadUrl("http://192.168.5.3/webroot/wedding.html");
    }
    /*
     *设置返回页面
     */
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK && mWebView.canGoBack()) {
            mWebView.goBack();// 返回前一个页面
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
