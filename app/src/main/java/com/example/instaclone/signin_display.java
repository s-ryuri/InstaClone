package com.example.instaclone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.TextView;

// 가입화면
public class signin_display extends AppCompatActivity {

    private Button telephone,email,email_next,telephone_next;
    private TabHost tabHost1;
    private EditText email_edittext,telephone_edittext1;
    private String str,tele_str;
    private TextView gotologin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin_display);
        TabHost tabHost1 = (TabHost) findViewById(R.id.tabHost1) ;
        tabHost1.setup() ;

        // 첫 번째 Tab. (탭 표시 텍스트:"TAB 1"), (페이지 뷰:"content1")
        TabHost.TabSpec ts1 = tabHost1.newTabSpec("Tab Spec 1") ;
        ts1.setContent(R.id.전화번호) ;
        ts1.setIndicator("전화번호") ;
        tabHost1.addTab(ts1)  ;

        // 두 번째 Tab. (탭 표시 텍스트:"TAB 2"), (페이지 뷰:"content2")
        TabHost.TabSpec ts2 = tabHost1.newTabSpec("Tab Spec 2") ;
        ts2.setContent(R.id.이메일) ;
        ts2.setIndicator("이메일") ;
        tabHost1.addTab(ts2) ;

        email_next = (Button) findViewById(R.id.email_next);
        email_edittext = (EditText) findViewById(R.id.email_edittext);
        gotologin = (TextView) findViewById(R.id.gotologin);
        email_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 여기를 누르면 인증 코드 입력 화면으로 가고
                // 여기서 edittext 한 값을 다음 화면으로 넘겨줘야됨
                str = email_edittext.getText().toString();
                Intent intent = new Intent(signin_display.this,email_verify.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                intent.putExtra("str",str);
                startActivity(intent);
            }
        });

        telephone_next = (Button) findViewById(R.id.telephone_next);
        telephone_edittext1 = (EditText) findViewById(R.id.telephone_edittext1);

        telephone_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tele_str = telephone_edittext1.getText().toString();
                Intent intent = new Intent(signin_display.this,telephone_verify.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                intent.putExtra("tele_str",tele_str);
                startActivity(intent);
            }
        });

        gotologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(signin_display.this,logindisplay.class);
                intent.addFlags(intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });

    }
}