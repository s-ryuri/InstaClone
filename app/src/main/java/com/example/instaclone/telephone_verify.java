package com.example.instaclone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class telephone_verify extends AppCompatActivity {

    private TextView telephone_remember;
    private Button telephone_next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.telephone_verify);

        telephone_remember = (TextView) findViewById(R.id.telephone_remember);
        Intent intent = getIntent();
        String str = intent.getStringExtra("tele_str");
        telephone_remember.setText(str);
        telephone_next = (Button) findViewById(R.id.telephone_next);
        telephone_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(telephone_verify.this,id_password_page.class);
                intent.addFlags(intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });
    }
}