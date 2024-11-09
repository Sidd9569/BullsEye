package com.example.stockmarket;

import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;
import android.net.Uri;
import androidx.appcompat.app.AppCompatActivity;

public class VideoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        VideoView videoView = findViewById(R.id.videoView);

        // Set up the URI for the video
        Uri videoUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.how_to_trade);
        videoView.setVideoURI(videoUri);

        // Add a MediaController for play, pause, and seek controls
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);

        // Start the video
        videoView.start();
    }
}

