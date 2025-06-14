package io.comzy.android_example;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class MainActivity extends AppCompatActivity {
    EditText editTextUserId,editTextRemoteId;
    Button nextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        editTextUserId = findViewById(R.id.editTextUserId);
        editTextRemoteId = findViewById(R.id.editTextRemoteId);
        nextBtn = findViewById(R.id.buttonSubmit);

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userId = editTextUserId.getText().toString().trim();
                String remoteId = editTextRemoteId.getText().toString().trim();

                Intent intent = new Intent(MainActivity.this, CallActivity.class);
                intent.putExtra("USER_ID", userId);
                intent.putExtra("REMOTE_ID", remoteId);
                startActivity(intent);
            }
        });
    }
}