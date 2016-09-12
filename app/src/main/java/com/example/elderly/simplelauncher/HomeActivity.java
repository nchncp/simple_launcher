package com.example.elderly.simplelauncher;

import android.app.AlertDialog;
import android.content.Intent;
import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.content.ComponentName;
import android.widget.Button;


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

    public void popupWindow(View v) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        LayoutInflater inflater = ((Activity) this).getLayoutInflater();
        View alertView = inflater.inflate(R.layout.activity_popup, null);
        alertDialog.setView(alertView);
        final AlertDialog show = alertDialog.show();

        Button btnOK = (Button) alertView.findViewById(R.id.btnOK);
        btnOK.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                show.dismiss();
            }
        });
    }



}
