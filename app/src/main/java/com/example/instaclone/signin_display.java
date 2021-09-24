package com.example.instaclone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

// 가입화면
public class signin_display extends AppCompatActivity {

    private Button telephone,email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin_display);
        telephone = (Button) findViewById(R.id.telephone);
        email = (Button) findViewById(R.id.email);


    }
}