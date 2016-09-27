package com.example.elderly.simplelauncher;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by nicha on 9/13/16.
 */
public class GalleryActivity extends Activity {

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_gallery);

    }

    public void showPhotos(View v) {
        Intent i = new Intent(this, GalleryPhoto.class);
        startActivity(i);
    }

}
