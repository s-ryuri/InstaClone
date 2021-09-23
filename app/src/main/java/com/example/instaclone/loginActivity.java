package com.example.instaclone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

// 처음 갔을 때 로그인 버튼 클릭 했을 때 로그인 버튼으로 넘어가는 java 파일
public class loginActivity extends AppCompatActivity {
    private Button btn_lauguage, btn_make_id,btn_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        btn_login = (Button) findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(loginActivity.this,logindisplay.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION); //애니메이션 삭제
                startActivity(intent);
            }
        });
    }
}