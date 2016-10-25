package com.example.elderly.simplelauncher;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by nicha on 9/27/16.
 */

public class LiveChannelsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.live_channels);
    }

    public void showChannel3(View v) {
        Intent i = new Intent(this, LiveTV3.class);
        startActivity(i);
    }

    public void showChannel5(View v) {
        Intent i = new Intent(this, LiveTV5.class);
        startActivity(i);
    }

    public void showChannelThairath(View v) {
        Intent i = new Intent(this, LiveThairath.class);
        startActivity(i);
    }

    public void showChannelAmarin(View v) {
        Intent i = new Intent(this, LiveAmarin.class);
        startActivity(i);
    }

    public void showChannelNow(View v) {
        Intent i = new Intent(this, LiveNow.class);
        startActivity(i);
    }

    public void showChannelNew(View v) {
        Intent i = new Intent(this, LiveNew.class);
        startActivity(i);
    }

    public void showChannelBright(View v) {
        Intent i = new Intent(this, LiveBright.class);
        startActivity(i);
    }
}
