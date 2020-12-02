package gr.uom.youtube_lecture;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class YoutubeActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {


    private static final String YT_API_KEY = BuildConfig.YoutubeApiKey;
    private static final String VIDEO_1 = "dQw4w9WgXcQ";

    private static final String TAG = "YouTubeActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ConstraintLayout layout = (ConstraintLayout)getLayoutInflater().inflate(R.layout.activity_youtube, null);
        setContentView(layout);

        // create the view for the player
        YouTubePlayerView player = new YouTubePlayerView(this);
        player.setLayoutParams(
                new ConstraintLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT)
        );

        //  add it to the view hierarchy
        layout.addView(player);
        player.initialize(YT_API_KEY, this);


    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        // show success message
        Toast.makeText(this, "YT Player init success!", Toast.LENGTH_SHORT).show();

        youTubePlayer.cueVideo(VIDEO_1);
        youTubePlayer.setPlayerStateChangeListener(stateChangeListener);
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        Toast.makeText(this, "YT Player init error!", Toast.LENGTH_SHORT).show();

    }

    YouTubePlayer.PlayerStateChangeListener stateChangeListener = new YouTubePlayer.PlayerStateChangeListener() {
        @Override
        public void onLoading() {
        Log.i(TAG, "Loading...");
        }

        @Override
        public void onLoaded(String s) {
            Log.i(TAG, "onLoaded...");

        }

        @Override
        public void onAdStarted() {
            Log.i(TAG, "Ad Started...");

        }

        @Override
        public void onVideoStarted() {

        }

        @Override
        public void onVideoEnded() {
            Log.i(TAG, "Video Started...");

        }

        @Override
        public void onError(YouTubePlayer.ErrorReason errorReason) {
            Log.i(TAG, "Error! Reason = " + errorReason.toString());

        }
    };
}