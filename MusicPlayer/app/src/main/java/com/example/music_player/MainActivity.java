package com.example.music_player;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button play,pause,stop;

    MediaPlayer mediaplayer;
    int pauseCurrentPosition;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        play=(Button)findViewById(R.id.btn_play);
        pause=(Button)findViewById(R.id.btn_pause);
        stop=(Button)findViewById(R.id.btn_stop);


        play.setOnClickListener(this);
        pause.setOnClickListener(this);
        stop.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {



        switch (view.getId())
        {

            case R.id.btn_play:
                if (mediaplayer==null)
                {
                    mediaplayer=MediaPlayer.create(getApplicationContext(),R.raw.music)
                    mediaplayer.start();

                }
                else if (mediaplayer.isPlaying())
                {
                    mediaplayer.seekTo(pauseCurrentPosition);
                    mediaplayer.start();

                }



                break;

            case R.id.btn_pause:
                if(mediaplayer!=null)
                {
                    mediaplayer.pause();
                    pauseCurrentPosition=mediaplayer.getCurrentPosition();
                }
                break;

                case R.id.btn_stop:
                    if(stop!=null)
                    {
                        mediaplayer.stop();

                        mediaplayer=null;


                    }
            break;

        }
    }
}
