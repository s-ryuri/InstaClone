package com.example.instaclone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class email_verify extends AppCompatActivity {
    private TextView email_remember;
    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.email_verify);

        email_remember = (TextView) findViewById(R.id.email_remember);
        Intent intent = getIntent();
        String str = intent.getStringExtra("str");

        email_remember.setText(str);
    }
}