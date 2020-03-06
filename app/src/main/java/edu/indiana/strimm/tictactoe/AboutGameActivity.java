package edu.indiana.strimm.tictactoe;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

/*
AboutGameActivity.java
Controls the About screen Activity
Created By: Shaun Trimm
Created On: 2-29-2020
Last Modified By: Shaun Trimm
Last Modified On: 3-3-2020
Assignment: A290 Final Project Phase 3
 */

public class AboutGameActivity extends AppCompatActivity{
    Toolbar toolbar;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_screen_toolbar);
        toolbar = findViewById(R.id.tlbrAbout);
        setSupportActionBar(toolbar);
        //Adds the back arrow to the toolbar
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        //Adds an onClick method for the back arrow
        toolbar.setNavigationOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                finish();
            }
        });

        //keeps the title text from showing
        getSupportActionBar().setTitle(null);

    }

}
