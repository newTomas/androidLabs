package com.example.labs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity implements MediaPlayer.OnPreparedListener {
    MediaPlayer mediaPlayer;
    VideoView MyvideoPlayer;
    Button startButton, pauseButton, stopButton;
    Button startSongButton, pauseSongButton, stopSongButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startButton = (Button)findViewById(R.id.start_button);
        startSongButton = (Button)findViewById(R.id.start_button2);
        stopButton = (Button)findViewById(R.id.stop_button);
        stopSongButton = (Button)findViewById(R.id.stop_button2);
        pauseButton = (Button)findViewById(R.id.pause_button);
        pauseSongButton = (Button)findViewById(R.id.pause_button2);
        MyvideoPlayer = (VideoView)findViewById(R.id.videoView);

        mediaPlayer=MediaPlayer.create(this, R.raw.song);
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stopPlay();
            }
        });

        Uri myVideoUri= Uri.parse( "android.resource://" +
        getPackageName() + "/" + R.raw.video);
        MyvideoPlayer.setVideoURI(myVideoUri);
        MediaController mediaController = new MediaController(this);
        MyvideoPlayer.setMediaController(mediaController);
        mediaController.setMediaPlayer(MyvideoPlayer);
    }

    public void onStartClick(View view){
        MyvideoPlayer.start();

        startButton.setEnabled(false);
        startSongButton.setEnabled(false);
        pauseButton.setEnabled(true);
        stopButton.setEnabled(true);
    }

    public void onStopClick(View view){
        MyvideoPlayer.stopPlayback();
        MyvideoPlayer.resume();

        startButton.setEnabled(true);
        startSongButton.setEnabled(true);
        pauseButton.setEnabled(false);
        stopButton.setEnabled(false);
    }

    public void onPauseClick(View view){
        MyvideoPlayer.pause();

        startButton.setEnabled(true);
        pauseButton.setEnabled(false);
    }

    private void stopPlay(){
        mediaPlayer.stop();
        pauseButton.setEnabled(false);
        stopButton.setEnabled(false);
        try {
            mediaPlayer.prepare();
            mediaPlayer.seekTo(0);
            startButton.setEnabled(true);
        }
        catch (Throwable t) {
            Toast.makeText(this, t.getMessage(),
                    Toast.LENGTH_SHORT).show();
        }
    }

    public void onStartSongClick(View view)
    {
        mediaPlayer.start();

        startSongButton.setEnabled(false);
        stopSongButton.setEnabled(true);
        pauseSongButton.setEnabled(true);
        startButton.setEnabled(false);
    }
    public void onPauseSongClick(View view)
    {
        mediaPlayer.pause();

        startSongButton.setEnabled(true);
        pauseSongButton.setEnabled(false);
    }

    public void onStopSongClick(View view)
    {
        stopPlay();

        startSongButton.setEnabled(true);
        stopSongButton.setEnabled(false);
        pauseSongButton.setEnabled(false);
        startButton.setEnabled(true);
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mediaPlayer.isPlaying()) {
            stopPlay();
        }
    }
    @Override
    public void onPrepared(MediaPlayer mp) {
    }
}