package edu.indiana.strimm.tictactoe;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

/*
AboutGameActivity.java
Controls the About screen Activity
Created By: Shaun Trimm
Created On: 2-29-2020
Last Modified By: Shaun Trimm
Last Modified On: 2-29-2020
Assignment: A290 Final Project Phase 3
 */

public class AboutGameActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_screen_toolbar);
        Toolbar toolbar = findViewById(R.id.tlbrAbout);
        setSupportActionBar(toolbar);

        //keeps the title text from showing
        getSupportActionBar().setTitle(null);

    }
}
