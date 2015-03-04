package apps.baveltman.hellomoon;

import android.content.Context;
import android.media.MediaPlayer;

/**
 * Model for the audio player
 */
public class AudioPlayer {

    private MediaPlayer mPlayer;

    /**
     * stops and releases the MediaPlayer
     */
    public void stop() {
        if (playerStarted()) {
            mPlayer.release();
            mPlayer = null;
        }
    }

    /**
     * evaluates if the player exists and has started playing a media file
     * @return
     */
    public boolean isPlaying(){
        return mPlayer != null && mPlayer.isPlaying();
    }

    /**
     * pauses playing of a file in the MediaPlayer
     */
    public void pause(){
        mPlayer.pause();
    }

    /**
     * creates an instance of the player and starts playing
     * @param c
     */
    public void play(Context c) {
        stop(); //only want to keep one instance of a MediaPlayer around

        mPlayer = MediaPlayer.create(c, R.raw.one_small_step);

        //set an event listener for file completion and stop MediaPlayer after completion
        mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mp) {
                stop();
            }
        });

        mPlayer.start();
    }

    /**
     * evaluates whether an instance of the MediaPlayer exists
     * @return
     */
    public boolean playerStarted() {
        return mPlayer != null;
    }

    /**
     * continues playback from a current instance of the MediaPlayer
     * or starts creates a new MediaPlayer and begins play
     * @param c
     */
    public void continuePlayer(Context c){
        if (playerStarted()){
            mPlayer.start();
        } else {
            play(c);
        }
    }
}
