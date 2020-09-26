package com.example.absoluteprotector;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;


public class TermsConditions extends AppCompatActivity {
    WebView loadwebview;
    ProgressBar progressBar;
    TextView titleText;
    ImageView back_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms_conditions);
        String AppName = getIntent().getStringExtra("AppName");
        String URL = getIntent().getStringExtra("Url");
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        back_button = findViewById(R.id.back_button);
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        progressBar = findViewById(R.id.progressbar);
        loadwebview = findViewById(R.id.loadwebview);
        titleText = findViewById(R.id.toolbar_title);
        titleText.setText(AppName);
        back_button=findViewById(R.id.back_button);
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        loadwebview.setWebViewClient(new WebViewClient());
        loadwebview.getSettings().setJavaScriptEnabled(true);
        loadwebview.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {
                progressBar.setProgress(progress);
                if (progress == 100) {
                    progressBar.setVisibility(View.GONE);
                } else {
                    progressBar.setVisibility(View.VISIBLE);
                }
            }
        });
        loadwebview.loadUrl("http://absolutestoreindia.com/terms/Absolute-Term&Condition.html");
    }

    @Override
    public void onBackPressed() {
        if (loadwebview.canGoBack()) {
            loadwebview.goBack();
        } else {
            finish();
        }
    }
}