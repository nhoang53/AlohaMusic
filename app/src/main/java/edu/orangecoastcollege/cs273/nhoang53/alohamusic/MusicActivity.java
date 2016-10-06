package edu.orangecoastcollege.cs273.nhoang53.alohamusic;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;


public class MusicActivity extends AppCompatActivity {

    private MediaPlayer ukuleleMP;
    private MediaPlayer ipuMP;
    private VideoView hulaVideoView;

    private Button ukulaeleButton;
    private Button ipuButton;
    private Button hulaButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        ukulaeleButton = (Button) findViewById(R.id.ukuleleButton);
        ipuButton = (Button) findViewById(R.id.ipuButton);
        hulaButton = (Button) findViewById(R.id.hulaButton);
        hulaVideoView = (VideoView) findViewById(R.id.hulaVideoView);

        // Associate the media player object with the raw files
        ukuleleMP = MediaPlayer.create(this, R.raw.ukulele);
        ipuMP = MediaPlayer.create(this, R.raw.ipu);

        // Associate the media player object with the hula video
        hulaVideoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.hula)); // convert string to Uri
        hulaVideoView.setMediaController(new MediaController(this));

    }

    public void playMedia(View view)
    {
        // Determine which button is clicked:
        switch (view.getId())
        {
            case R.id.ukuleleButton:
                if(ukuleleMP.isPlaying()){
                    ukuleleMP.pause();
                    ukulaeleButton.setText(R.string.ukulele_button_play_text);
                    // show the other two buttons (ipu and hula)
                    ipuButton.setVisibility(View.VISIBLE);
                    hulaButton.setVisibility(View.VISIBLE);
                }
                else{
                    ukuleleMP.start();
                    ukulaeleButton.setText(R.string.ukulele_button_pause_text);
                    // Hide the other two buttons (ipu and hula)
                    ipuButton.setVisibility(View.INVISIBLE);
                    hulaButton.setVisibility(View.INVISIBLE);
                }

                break;

            case R.id.ipuButton:
                if(ipuMP.isPlaying()){
                    ipuMP.pause();
                    ipuButton.setText(R.string.ipu_button_play_text);

                    ukulaeleButton.setVisibility(View.VISIBLE);
                    hulaButton.setVisibility(View.VISIBLE);
                }
                else
                {
                    ipuMP.start();
                    ipuButton.setText(R.string.ipu_button_pause_text);

                    ukulaeleButton.setVisibility(View.INVISIBLE);
                    hulaButton.setVisibility(View.INVISIBLE);
                }

                break;

            case R.id.hulaButton:
                if(hulaVideoView.isPlaying()){
                    hulaVideoView.pause();
                    hulaButton.setText(R.string.hula_button_watch_text);

                    ukulaeleButton.setVisibility(View.VISIBLE);
                    ipuButton.setVisibility(View.VISIBLE);
                }
                else
                {
                    hulaVideoView.start();
                    hulaButton.setText(R.string.ipu_button_pause_text);

                    ukulaeleButton.setVisibility(View.INVISIBLE);
                    ipuButton.setVisibility(View.INVISIBLE);
                }

                break;

        }
    }
}
