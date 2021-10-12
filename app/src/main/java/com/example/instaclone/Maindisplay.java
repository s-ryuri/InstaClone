package com.example.instaclone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class Maindisplay extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private FragmentManager fm;
    private FragmentTransaction ft;

    private fragment_home frg_home;
    private fragment_mypage frg_mypage;
    private fragment_reels frg_reels;
    private fragment_search frg_search;
    private fragment_shop frg_shop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maindisplay);

        bottomNavigationView = findViewById(R.id.main_bottomNavi);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.main_home:
                        setFrag(0);
                        break;
                    case R.id.main_search:
                        setFrag(1);
                        break;
                    case R.id.main_reels:
                        setFrag(2);
                        break;
                    case R.id.main_shop:
                        setFrag(3);
                        break;
                    case R.id.main_mypage:
                        setFrag(4);
                        break;
                }
                return true;
            }
        });

        frg_home = new fragment_home();
        frg_search = new fragment_search();
        frg_reels = new fragment_reels();
        frg_shop = new fragment_shop();
        frg_mypage = new fragment_mypage();
        setFrag(0);
    }

    private void setFrag(int number){
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();

        switch(number){
            case 0:
                ft.replace(R.id.main_frame,frg_home);
                ft.commit();
                break;
            case 1:
                ft.replace(R.id.main_frame,frg_search);
                ft.commit();
                break;
            case 2:
                ft.replace(R.id.main_frame,frg_reels);
                ft.commit();
                break;
            case 3:
                ft.replace(R.id.main_frame,frg_shop);
                ft.commit();
                break;
            case 4:
                ft.replace(R.id.main_frame,frg_mypage);
                ft.commit();
                break;
        }
    }
}