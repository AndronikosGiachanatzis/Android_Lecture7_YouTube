package gr.uom.youtube_lecture;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnPlayVideo = findViewById(R.id.btnPlayVideo);
        btnPlayVideo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // start the youtube activity
        Intent intent = new Intent(this, YoutubeActivity.class);

        if (intent != null)
        {
            startActivity(intent);
        }
    }
}