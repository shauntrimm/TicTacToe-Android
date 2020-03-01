package edu.indiana.strimm.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioButton;

/*
MainActivity.java
Controls the Home screen
Created By: Shaun Trimm
Created On: 2-25-2020
Last Modified By: Shaun Trimm
Last Modified On: 3-1-2020
Assignment: A290 Final Project Phase 3
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    int colorOptionSelected = 0;
    RadioButton  rbtnBlueRedOption;
    RadioButton  rbtnYellowPurpleOption;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.tlbrHome);
        setSupportActionBar(toolbar);

        //keeps the title text from showing
        getSupportActionBar().setTitle(null);

        rbtnBlueRedOption = findViewById(R.id.rbtnBlueRedOption);
        rbtnYellowPurpleOption = findViewById(R.id.rbtnYellowPurpleOption);

        //Sets the radio button for the red and blue color option to be automatically checked
        rbtnBlueRedOption.setChecked(true);

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

      //If the About icon is clicked
       if (id == R.id.itmHomeAbout) {
           startActivity(new Intent(this, AboutGameActivity.class));
       }

       return super.onOptionsItemSelected(item);
    }

    //Processes clicks on different buttons in the Home Screen
    public void onClick(View v){
        //If the button click is the start game button
        if(v.getId() == R.id.btnStartGame){
            Intent startGame = new Intent(this, GameScreenActivity.class);
            startGame.putExtra(GameScreenActivity.COLOR_SCHEME, this.colorOptionSelected);
            startActivity(startGame);
        }

    }

    //Handles radio button selections
    public void onRadioButtonClicked(View v){
        RadioButton rb = (RadioButton) v;
        //If the button click is the Blue Red color option radio button
        if(rb.getId() == R.id.rbtnBlueRedOption){
            //Checks if the other option is checked
            if(rbtnYellowPurpleOption.isChecked()){
                //Unchecks the other option
                rbtnYellowPurpleOption.setChecked(false);
            }
            this.colorOptionSelected = 0;
        }
        //If the button click is the Yellow Purple color option radio button
        else if(rb.getId() == R.id.rbtnYellowPurpleOption){
            //Checks if the other option is checked
            if(rbtnBlueRedOption.isChecked()){
                //Unchecks the other option
                rbtnBlueRedOption.setChecked(false);
            }
            this.colorOptionSelected = 1;
        }
    }
}
