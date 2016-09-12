package com.example.elderly.simplelauncher;

import android.content.Intent;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.content.ComponentName;

public class HomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void showApps(View v) {
        Intent i = new Intent(this, AppsListActivity.class);
        startActivity(i);
    }

    public void showSettings(View v) {
        startActivityForResult(new Intent(android.provider.Settings.ACTION_SETTINGS), 0);
    }


    public void showCalendar(View v) {
        
    }
}
