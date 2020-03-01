package edu.indiana.strimm.tictactoe;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_about_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //If the About icon is clicked
        if (id == R.id.itmAboutBackArrow) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
