package com.example.instaclone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class email_verify extends AppCompatActivity {
    private TextView email_remember;
    private Button next_btn;
    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.email_verify);

        email_remember = (TextView) findViewById(R.id.email_remember);
        Intent intent = getIntent();
        String str = intent.getStringExtra("str");
        email_remember.setText(str);

        next_btn = (Button)findViewById(R.id.next_btn);
        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(email_verify.this,id_password_page.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });
    }
}