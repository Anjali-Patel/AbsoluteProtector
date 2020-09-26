package com.example.absoluteprotector;

import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;
import pl.droidsonroids.gif.GifImageView;

public class PlayAlarmActivity extends AppCompatActivity {

    GifImageView img;
    TextView textView,img_text;
    Runnable runnable;
ImageView back_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_alarm);
        img = (GifImageView) findViewById(R.id.pager);
        textView=(TextView)findViewById(R.id.textView);
        back_button=findViewById(R.id.back_button);
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        img_text=findViewById(R.id.img_text);
        final Handler handler = new Handler();
      runnable = new Runnable() {

            public void run() {
                img.setImageResource(R.drawable.connected);
                textView.setText("Connected Mobile to Device");
                img_text.setText("Connected Mobile to Your Device");

            }
        };
        handler.postDelayed(runnable, 5000); //for initial delay..

//        img.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                img.setImageResource(R.drawable.connecting);
//                textView.setText("Connecting to Device");
//
//                final Handler handler = new Handler();
//                runnable = new Runnable() {
//
//                    public void run() {
//                        img.setImageResource(R.drawable.not_connected);
//                        textView.setText("Not Connected to Device");
//
//                    }
//                };
//                handler.postDelayed(runnable, 5000);
//                img.setClickable(false);
//
//            }
//        });
//

    }

    }

