package com.example.elderly.simplelauncher;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.IntRange;

import com.devbrackets.android.exomedia.core.video.scale.ScaleType;
import com.devbrackets.android.exomedia.listener.OnBufferUpdateListener;
import com.devbrackets.android.exomedia.listener.OnCompletionListener;
import com.devbrackets.android.exomedia.listener.OnErrorListener;
import com.devbrackets.android.exomedia.listener.OnPreparedListener;
import com.devbrackets.android.exomedia.ui.widget.EMVideoView;

/**
 * Created by nicha on 10/25/16.
 */
public class LiveBright extends Activity implements OnPreparedListener {
    private static boolean isRunning;

    EMVideoView youtubePlayerView;


    private int flowerCount = 0;

    private String path;

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_live);

        path = "http://iam.brighttv.co.th/BrightTV/smil:live.smil/playlist.m3u8";
        youtubePlayerView = (EMVideoView) findViewById(R.id.youtubePlayerView);
        youtubePlayerView.setOnPreparedListener(this);
        youtubePlayerView.setVideoURI(Uri.parse(path));
        youtubePlayerView.setScaleType(ScaleType.CENTER_CROP);
        youtubePlayerView.setOnCompletionListener(new OnCompletionListener() {
            @Override
            public void onCompletion() {
                youtubePlayerView.seekTo(0);
                youtubePlayerView.start();
            }
        });
        youtubePlayerView.setOnErrorListener(new OnErrorListener() {
            @Override
            public boolean onError() {
                youtubePlayerView.seekTo(0);
                youtubePlayerView.start();
                return false;
            }
        });
        youtubePlayerView.setOnBufferUpdateListener(new OnBufferUpdateListener() {
            @Override
            public void onBufferingUpdate(@IntRange(from = 0L, to = 100L) int percent) {
                //Log.e("PERCENT", "BUFFERING " +percent);
            }
        });

    }

    @Override
    public void onPrepared() {
        //Starts the video playback as soon as it is ready
        youtubePlayerView.start();
    }


    @Override
    public void onResume() {
        super.onResume();
        youtubePlayerView.start();
        isRunning = true;
    }

    @Override
    protected void onStart() {
        super.onStart();
        isRunning = true;
    }

    @Override
    public void onPause() {
        super.onPause();
        youtubePlayerView.pause();
        isRunning = false;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        isRunning = false;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        isRunning = false;
    }
}
