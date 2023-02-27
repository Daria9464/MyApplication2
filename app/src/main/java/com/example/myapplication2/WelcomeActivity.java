package com.example.myapplication2;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class WelcomeActivity extends AppCompatActivity {

    private TextView messageTextView;
    private EditText usernameEditText;
    private Button unlockButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        messageTextView = findViewById(R.id.welcome_text);
        usernameEditText = findViewById(R.id.username_editText);
        unlockButton = findViewById(R.id.unlock_button);

        unlockButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString();
                Intent intent = new Intent(WelcomeActivity.this, AccessControlActivity.class);
                intent.putExtra("username", username);
                startActivityForResult(intent, 1);
            }
        });

        messageTextView.setText("Welcome to the App! The App is LOCKED!");
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                boolean isUnlocked = data.getBooleanExtra("isUnlocked", false);
                if (isUnlocked) {
                    messageTextView.setText("The App is Unlocked.");
                } else {
                    messageTextView.setText("Welcome to the App! The App is STILL LOCKED!");
                }
            }
        }
    }
}
