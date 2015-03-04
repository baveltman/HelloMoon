package apps.baveltman.hellomoon;

import android.content.Context;
import android.media.MediaPlayer;

/**
 * Model for the audio player
 */
public class AudioPlayer {

    private MediaPlayer mPlayer;

    public void stop() {
        if (mPlayer != null) {
            mPlayer.release();
            mPlayer = null;
        }
    }

    public void play(Context c) {
        stop(); //only want to keep one instance of a MediaPlayer around

        mPlayer = MediaPlayer.create(c, R.raw.one_small_step);

        //set an event listener for file completion and stop MediaPlayer after completion
        mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener(){
            public void onCompletion(MediaPlayer mp) {
                stop();
             }
        });

        mPlayer.start();
    }

}
