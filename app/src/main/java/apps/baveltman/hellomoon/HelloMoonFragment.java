package apps.baveltman.hellomoon;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Fragment to act as the controller for fragment_hello_moon ui
 */
public class HelloMoonFragment extends Fragment {

    private Button mPlayButton;
    private Button mStopButton;
    private AudioPlayer mPlayer;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        mPlayer = new AudioPlayer();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_hello_moon, parent, false);
        mPlayButton = (Button)v.findViewById(R.id.hellomoon_playButton);
        mStopButton = (Button)v.findViewById(R.id.hellomoon_stopButton);
        bindEventListeners();
        return v;
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        mPlayer.stop();
    }

    /**
     * event listeners for actions on the
     * ui elements in this fragment
     */
    private void bindEventListeners() {

        mPlayButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mPlayer.play(getActivity());
            }
        });

        mStopButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mPlayer.stop();
            }
        });
    }


}
