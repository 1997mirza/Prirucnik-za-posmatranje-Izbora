package com.creativocentar.prirucnik22;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    private VideoView videoView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View decorView = getWindow().getDecorView();
        if (Build.VERSION.SDK_INT>Build.VERSION_CODES.KITKAT){
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            |View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            |View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            |View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            |View.SYSTEM_UI_FLAG_FULLSCREEN
                            |View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);}



        videoView=(VideoView) findViewById(R.id.videoView);
        videoView.setVideoPath("android.resource://"+getPackageName()+"/"+R.raw.pocetna);
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                if (isFinishing())
                    return;
                Intent homeIntent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(homeIntent);
                finish();
            }
        });
        videoView.start();
    }
}
