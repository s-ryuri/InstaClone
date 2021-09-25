package com.example.instaclone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class telephone_verify extends AppCompatActivity {

    private TextView telephone_remember;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.telephone_verify);

        telephone_remember = (TextView) findViewById(R.id.telephone_remember);
        Intent intent = getIntent();
        String str = intent.getStringExtra("tele_str");
        telephone_remember.setText(str);
    }
}