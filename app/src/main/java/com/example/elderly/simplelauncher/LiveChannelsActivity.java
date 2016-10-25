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

    public void showChannelBang(View v) {
        Intent i = new Intent(this, LiveBang.class);
        startActivity(i);
    }

}
