package com.example.testapppjava;

import android.view.KeyEvent;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    // URLを指定
    static final String URL = "https://mj-news.net/news/mleague/20190320110964";
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Web Viewの初期設定
        webView = findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient()); // WebViewを設定する
        webView.getSettings().setJavaScriptEnabled(true); // JavaScriptを有効にする
        webView.loadUrl(URL); // URLを読み込む
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent e){
        if(keyCode == KeyEvent.KEYCODE_BACK){ // 戻るボタンがタップされた時
            if(webView != null && webView.canGoBack()){ // WebViewがNULLでなく、閲覧履歴があるなら
                webView.goBack(); // 一つ前のウェブページを表示する
            }
            return true;
        }else{
            return super.onKeyDown(keyCode, e);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();// バックグラウンドからフォアグランドに戻った時など
        if(webView != null){ // WebViewが空でなければ
            String url = webView.getUrl(); // 現在のウェブページを
            webView.loadUrl(url); // 再表示する
        }
    }
}
