package io.comzy.android_example;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import io.comzy.videocore.Comzy;


public class CallActivity extends AppCompatActivity {
    private String API_KEY = "YOUR_API_KEY"; // this key is not working please use your own api key
    FrameLayout localview,remoteview;
    TextView remoteUserName;
    ImageButton muteBtn,endCall,btnCam;

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

        muteBtn = findViewById(R.id.btnMute);
        endCall = findViewById(R.id.btnEndCall);
        btnCam = findViewById(R.id.btnCam);


        remoteUserName.setText(remoteId);

        Comzy comzy = Comzy.getInstance(this);
        Comzy.start(CallActivity.this,API_KEY,userId,remoteId);

        localview.addView(comzy.getLocalVideoView());
        remoteview.addView(comzy.getRemoteVideoView());

        muteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comzy.toggleMute();
            }
        });

        btnCam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comzy.toggleCamera();
            }
        });

        endCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comzy.endCall();
            }
        });
    }
}