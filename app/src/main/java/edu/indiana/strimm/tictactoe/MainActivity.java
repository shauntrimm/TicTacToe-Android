package edu.indiana.strimm.tictactoe;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

/*
MainActivity.java
Controls the Home screen
Created By: Shaun Trimm
Created On: 2-25-2020
Last Modified By: Shaun Trimm
Last Modified On: 2-28-2020
Assignment: A290 Final Project Phase 3
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //keeps the title text from showing
        getSupportActionBar().setTitle(null);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       // Handle action bar item clicks here. The action bar will
       // automatically handle clicks on the Home/Up button, so long
       // as you specify a parent activity in AndroidManifest.xml.
       int id = item.getItemId();

      //noinspection SimplifiableIfStatement
       if (id == R.id.action_about) {
           return true;
       }

       return super.onOptionsItemSelected(item);
    }

    //Processes clicks on different buttons in the Home Screen
    public void onClick(View v){
        if(v.getId() == R.id.btnStartGame){
            startActivity(new Intent(this, GameScreenActivity.class));
        }

    }
}
