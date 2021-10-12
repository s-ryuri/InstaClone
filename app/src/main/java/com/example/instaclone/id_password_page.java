package com.example.instaclone;

import static java.lang.Thread.sleep;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import java.util.HashMap;

public class id_password_page extends AppCompatActivity {

    private CheckBox checkbox_btn;
    private EditText insta_password,insta_id;
    private Button synchronization_btn,no_synchronization_btn;
    // 일단 no 누르면 다음으로 넘어가게
    private DatabaseReference mDatabase;

    Integer numcnt = 0;
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
        insta_id = (EditText) findViewById(R.id.insta_id);

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

        mDatabase = FirebaseDatabase.getInstance().getReference();
        readUser();

        no_synchronization_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getUserName = insta_id.getText().toString();
                String getUserPassword = insta_password.getText().toString();
                numcnt++;
                HashMap result = new HashMap<>();
                result.put("id",getUserName);
                result.put("password",getUserPassword);

                writeNewUser(Integer.toString(numcnt),getUserName,getUserPassword);
                try {
                    sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(id_password_page.this,Maindisplay.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });

    }
    private void writeNewUser(String userId, String name, String password) {
        User user = new User(name, password);

        mDatabase.child("users").child(userId).setValue(user)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        // Write was successful!
                        Toast.makeText(id_password_page.this, "저장을 완료했습니다.", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        // Write failed
                        Toast.makeText(id_password_page.this, "저장을 실패했습니다.", Toast.LENGTH_SHORT).show();
                    }
                });

    }

    private void readUser(){
        mDatabase.child("users").child("1").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // Get Post object and use the values to update the UI
                if(dataSnapshot.getValue(User.class) != null){
                    User post = dataSnapshot.getValue(User.class);
                    Log.w("FireBaseData", "getData" + post.toString());
                } else {
                    Toast.makeText(id_password_page.this, "데이터 없음...", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.w("FireBaseData", "loadPost:onCancelled", databaseError.toException());
            }
        });
    }

}