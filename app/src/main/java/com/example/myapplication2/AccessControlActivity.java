package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AccessControlActivity extends AppCompatActivity {

    private String username;
    private TextView usernameTextView;
    private Button digit1Button;
    private Button digit2Button;
    private Button digit3Button;
    private Button digit4Button;
    private Button submitButton;

    private StringBuilder accessCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_access_control);

        Intent intent = getIntent();
        username = intent.getStringExtra("username");

        usernameTextView = findViewById(R.id.username_textview);
        digit1Button = findViewById(R.id.button_1);
        digit2Button = findViewById(R.id.button_2);
        digit3Button = findViewById(R.id.button_3);
        digit4Button = findViewById(R.id.button_4);
        submitButton = findViewById(R.id.submit_button);

        usernameTextView.setText("Username: " + username);

        accessCode = new StringBuilder();

        digit1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                accessCode.append("1");
            }
        });

        digit2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                accessCode.append("2");
            }
        });

        digit3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                accessCode.append("3");
            }
        });

        digit4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                accessCode.append("4");
            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isUnlocked = accessCode.toString().equals("1234");
                Intent resultIntent = new Intent();
                resultIntent.putExtra("isUnlocked", isUnlocked);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
    }
}
