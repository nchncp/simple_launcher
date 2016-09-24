package com.example.elderly.simplelauncher;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.MediaController;
import android.widget.VideoView;

/**
 * Created by nicha on 9/25/16.
 */

public class TVActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tv_view);

        VideoView videoView = (VideoView) findViewById(R.id.tvView);
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        mediaController.setMediaPlayer(videoView);

        Uri video = Uri.parse("{http://dlab.sit.kmutt.ac.th/el_launcher/tvchannel/1.html}");
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(video);
        videoView.start();

//        WebViw.loadUrl("http://dlab.sit.kmutt.ac.th/el_launcher/tv/1.html");

    }

}
