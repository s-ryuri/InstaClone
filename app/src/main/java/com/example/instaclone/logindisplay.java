package com.example.instaclone;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class logindisplay extends AppCompatActivity {
    private Button btn_login,facebooklogin,signin,btn_language;
    private EditText instaid,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logindisplay);
        btn_login = (Button) findViewById(R.id.btn_login);
        facebooklogin = (Button) findViewById(R.id.facebooklogin);
        signin = (Button) findViewById(R.id.signin);

        password = (EditText) findViewById(R.id.password);
        instaid = (EditText) findViewById(R.id.instaid);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //이걸 누르면 메인 화면 으로
                String name = instaid.getText().toString();
                String str = password.getText().toString();
                if(str.equals("12345")){
                    Intent intent = new Intent(logindisplay.this,Maindisplay.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
                }else{
                    AlertDialog.Builder ad = new AlertDialog.Builder(logindisplay.this);
                    ad.setIcon(R.drawable.instagram);
                    ad.setTitle(name + "님의 비밀번호가 잘못되었습니다.");
                    ad.setMessage("입력된 비밀번호가 올바르지 않습니다. 다시 시도하세요.");
                    ad.setPositiveButton("다시 시도", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    ad.show();
                }

            }
        });
        //페이스북 화면으로
        facebooklogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent facebookintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/"));
                startActivity(facebookintent);
            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(logindisplay.this,signin_display.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });

        btn_language = (Button) findViewById(R.id.btn_language);
        btn_language.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(logindisplay.this,scroll_language.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });
    }
}