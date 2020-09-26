package com.example.absoluteprotector;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toolbar;

public class CheckForUpdates extends AppCompatActivity {
    ImageView back_button;
    Toolbar toolbar;
    Button checkLatestVersion;
    TextView CurrentAppVersion, appDownloadLink, applicationAvailability,date,time;
    ProgressBar progressbar;
    LinearLayout ll_downloadlink;
    String version;
    int verCode;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_for_updates);
        back_button=findViewById(R.id.back_button);
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
//        toolbar = findViewById(R.id.toolbar);
//
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
date=findViewById(R.id.date);
time=findViewById(R.id.time);
        progressbar = findViewById(R.id.progressbar);
        checkLatestVersion = findViewById(R.id.checkLatestVersion);
        CurrentAppVersion = findViewById(R.id.CurrentAppVersion);
        appDownloadLink = findViewById(R.id.appDownloadLink);
        ll_downloadlink = findViewById(R.id.ll_downloadlink);
        applicationAvailability = findViewById(R.id.applicationAvailability);

        try {
            PackageInfo pInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
            version = pInfo.versionName;
            verCode = pInfo.versionCode;
            CurrentAppVersion.setText("Current App Version \n" + version);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }


    }


}



