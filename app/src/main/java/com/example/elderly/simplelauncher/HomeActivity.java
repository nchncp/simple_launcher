package com.example.elderly.simplelauncher;

import android.app.AlertDialog;
import android.content.Intent;
import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;


public class HomeActivity extends Activity {

    private String strFullname;
    private String strUserPhoto;
    private String strEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //***** START SharedPreferences *****
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0);
        strFullname = pref.getString("fullname", "Nichapa P");
        strUserPhoto = pref.getString("photo", "http://www.argong.com/image-users/nichapa.jpg");
        strEmail = pref.getString("email", "nchncp@gmail.com");
        //***** END SharedPreferences *****



    }

    public void showApps(View v) {
        Intent i = new Intent(this, AppsListActivity.class);
        startActivity(i);
    }

    public void showSettings(View v) {
        startActivityForResult(new Intent(android.provider.Settings.ACTION_SETTINGS), 0);
    }

    public void showMessages(View v) {

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
