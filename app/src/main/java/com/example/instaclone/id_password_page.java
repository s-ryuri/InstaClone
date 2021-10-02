package com.example.instaclone;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

public class id_password_page extends AppCompatActivity {

    private CheckBox checkbox_btn;
    private EditText insta_password;
    private Button synchronization_btn,no_synchronization_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.id_password_page);

        checkbox_btn = (CheckBox) findViewById(R.id.checkbox_btn);

        checkbox_btn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    buttonView.setButtonTintList(ColorStateList.valueOf(Color.parseColor("#34BFD6")));
                }
                else{
                    buttonView.setButtonTintList(ColorStateList.valueOf(Color.parseColor("#458EFF")));
                }
            }
        });
        synchronization_btn = (Button) findViewById(R.id.synchronization_btn);
        no_synchronization_btn = (Button) findViewById(R.id.no_synchronization_btn);
        insta_password = (EditText) findViewById(R.id.insta_password);
        insta_password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(s.length() >= 6){
                    synchronization_btn.setEnabled(true);
                    no_synchronization_btn.setEnabled(true);
                    synchronization_btn.setBackgroundColor(Color.parseColor("#458EFF"));
                    no_synchronization_btn.setTextColor(Color.parseColor("#458EFF"));
                }else{
                    synchronization_btn.setEnabled(false);
                    no_synchronization_btn.setEnabled(false);
                    synchronization_btn.setBackgroundColor(Color.parseColor("#59458EFF"));
                    no_synchronization_btn.setTextColor(Color.parseColor("#59458EFF"));
                }
            }
        });
    }
}