package com.devforfun.droidconnyc2016_avd;

import android.graphics.drawable.AnimatedStateListDrawable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.os.Bundle;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private boolean isPlaying;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView icProfile = (ImageView) findViewById(R.id.ic_profile);
        final AnimatedVectorDrawable avdProfile = (AnimatedVectorDrawable) icProfile.getDrawable();
        icProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                avdProfile.start();
            }
        });

        final AnimatedVectorDrawable icPlayToStop = (AnimatedVectorDrawable) ResourcesCompat.getDrawable(getResources(), R.drawable.avd_play_to_stop, getTheme());
        final AnimatedVectorDrawable icStopToPlay = (AnimatedVectorDrawable) ResourcesCompat.getDrawable(getResources(), R.drawable.avd_stop_to_play, getTheme());

        final ImageView icPlayStop = (ImageView) findViewById(R.id.ic_play_stop);
        icPlayStop.setImageDrawable(icPlayToStop);

        icPlayStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isPlaying) {
                    icPlayStop.setImageDrawable(icPlayToStop);
                    icPlayToStop.start();
                    isPlaying = true;
                } else {
                    icPlayStop.setImageDrawable(icStopToPlay);
                    icStopToPlay.start();
                    isPlaying = false;
                }

            }
        });


    }
}
