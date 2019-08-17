package com.example.webviewtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WebView webView =(WebView)findViewById(R.id.web_view);
        //通过findViewById()的方法，获取WebView的实例
        webView.getSettings().setJavaScriptEnabled(true);
        //getSettings()方法可以设置一些浏览器的属性，调用setJavaScriptEnabled()方法是为了让WebView支持JavaScript脚本
        webView.setWebViewClient(new WebViewClient());
        //当需要从一个网页跳转到另一个网页时，让目标网页在WebView中显示，而不是打开系统浏览器
        webView.loadUrl("http://www.baidu.com");
        //将网址传入，即可显示相应网址内容
    }
}
