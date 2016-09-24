package com.example.elderly.simplelauncher;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by nicha on 9/13/16.
 */
public class MessagesActivity extends Activity {

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_messages);

    }

    public void showUnreadMessages(View v) {
        Intent i = new Intent(this, MessagesUnread.class);
        startActivity(i);
    }

    public void showReadMessages(View v) {
        Intent i = new Intent(this, MessagesRead.class);
        startActivity(i);
    }

}
