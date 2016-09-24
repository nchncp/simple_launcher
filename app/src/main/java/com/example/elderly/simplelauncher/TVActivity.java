package com.example.elderly.simplelauncher;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

/**
 * Created by nicha on 9/25/16.
 */

public class TVActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tv_view);

        WebView WebViw = (WebView) findViewById(R.id.tvView);
        WebViw.getSettings().setJavaScriptEnabled(true);
        WebViw.loadUrl("http://www.yimhd.com/tv_online/one-hd.php");

    }

}
