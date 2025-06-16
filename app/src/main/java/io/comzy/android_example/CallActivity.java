package io.comzy.android_example;

import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import io.comzy.videocore.Comzy;


public class CallActivity extends AppCompatActivity {
    private String API_KEY = "key_52abac8e6db09f157337cc795fa065a46eb7084af0b59scae902cadd90f0c699"; // this key is not working please use your own api key
    FrameLayout localview,remoteview;
    TextView remoteUserName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_call);

        String userId = getIntent().getStringExtra("USER_ID");
        String remoteId = getIntent().getStringExtra("REMOTE_ID");

        localview = findViewById(R.id.localVideoView);
        remoteview = findViewById(R.id.remoteVideoView);
        remoteUserName = findViewById(R.id.tvUserName);
        remoteUserName.setText(remoteId);

        Comzy videoCore = Comzy.getInstance(this);
        Comzy.start(CallActivity.this,API_KEY,userId,remoteId);

        localview.addView(videoCore.getLocalVideoView());
        remoteview.addView(videoCore.getRemoteVideoView());
    }
}