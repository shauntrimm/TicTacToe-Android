package edu.indiana.strimm.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.RadioButton;
import java.util.Stack;

/*
GameScreenActivity.java
Controls the Game Screen
Created By: Shaun Trimm
Created On: 2-28-2020
Last Modified By: Shaun Trimm
Last Modified On: 3-1-2020
Assignment: A290 Final Project Phase 3
 */

public class GameScreenActivity extends AppCompatActivity implements View.OnClickListener{

    ImageView[][] images = new ImageView[3][3]; //Stores the image views that hold x's and o's
    int colorStyle; //Stores the value for the color style
    Stack<ImageView> editedImages = new Stack<ImageView>(); //Stores the edited imageviews in the order in which they are edited
    static final String COLOR_SCHEME = "edu.indiana.strimm.tictactoe.color";
    RadioButton rbtnCircleOption;
    RadioButton rbtnXOption;
    int selectedShape; //Stores the value for the selected shape 0 for circle 1 for x


    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_screen_toolbar);
        Toolbar toolbar = findViewById(R.id.tlbrGame);
        setSupportActionBar(toolbar);

        rbtnCircleOption = findViewById(R.id.rbtnCircleOption);
        rbtnXOption = findViewById(R.id.rbtnXOption);

        //Retrieves the extra value passed from MainActivity to determine the color scheme
        colorStyle = this.getIntent().getIntExtra(COLOR_SCHEME, 0);

        //Sets the images for the radio buttons based on color scheme
        if(colorStyle == 0){
            rbtnCircleOption.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.blueredcircle100, 0);
            rbtnXOption.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.blueredx100, 0);

        }
        else if(colorStyle == 1){
            rbtnCircleOption.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.yellowpurplecircle100, 0);
            rbtnXOption.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.yellowpurplex100, 0);
        }

        //keeps the title text from showing
        getSupportActionBar().setTitle(null);

        //Initialize the Circle radio button to be checked by default
        rbtnCircleOption.setChecked(true);
        selectedShape = 0;

        //Initialize images 2d Array
        images[0][0] = findViewById(R.id.imageView);
        images[0][1] = findViewById(R.id.imageView2);
        images[0][2] = findViewById(R.id.imageView3);
        images[1][0] = findViewById(R.id.imageView4);
        images[1][1] = findViewById(R.id.imageView5);
        images[1][2] = findViewById(R.id.imageView6);
        images[2][0] = findViewById(R.id.imageView7);
        images[2][1] = findViewById(R.id.imageView8);
        images[2][2] = findViewById(R.id.imageView9);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_game_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //If the About icon is clicked
        if (id == R.id.itmGameAboutGame) {
            startActivity(new Intent(this, AboutGameActivity.class));
        }
        //If the back arrow is clicked
        else if(id == R.id.itmGameBackArrow){
            super.onBackPressed();
        }
        //If the clear button is pressed
        else if(id == R.id.itmGameClear){
            clearGrid();
        }
        //If the undo button is pressed
        else if(id == R.id.itmGameUndo){
                undo();
        }

        return super.onOptionsItemSelected(item);
    }

    //Processes clicks on image views in the Game Screen
    public void onClick(View v){
        ImageView iV = findViewById(v.getId());
        //Processes clicks to the different image views
        if(iV.getDrawable() == null) {
            if (selectedShape == 0) {
                //draws the shape
                iV.setImageDrawable(rbtnCircleOption.getCompoundDrawables()[2]);
                //adds the ImageView to the edited stack
                editedImages.add(iV);
                selectedShape = 1;
                this.rbtnXOption.setChecked(true);
                this.rbtnCircleOption.setChecked(false);
            } else if (selectedShape == 1) {
                //draws the shape
                iV.setImageDrawable(rbtnXOption.getCompoundDrawables()[2]);
                //adds the ImageView to the edited stack
                editedImages.add(iV);
                selectedShape = 0;
                this.rbtnXOption.setChecked(false);
                this.rbtnCircleOption.setChecked(true);
            }
        }
    }

    //Handles radio button selections in the game screen
    public void onRadioButtonClicked(View v){
        RadioButton rb = findViewById(v.getId());

        if(rb.getId() == R.id.rbtnCircleOption){
            //Checks if the other option is checked
            if(rbtnXOption.isChecked()){
                //Unchecks the other option
                rbtnXOption.setChecked(false);
            }
            this.selectedShape = 0;
        }
        else if(rb.getId() == R.id.rbtnXOption){
            //Checks if the other option is checked
            if(rbtnCircleOption.isChecked()){
                //Unchecks the other option
                rbtnCircleOption.setChecked(false);
            }
            this.selectedShape = 1;
        }
    }

    //Clears all images off of the game grid
    public void clearGrid(){
        for(int i = 0; i < images.length; i++){
            for(int j = 0; j < images[i].length; j++){
                images[i][j].setImageDrawable(null);
            }
        }
    }

    //Undos the last move made by the user
    public void undo(){
        if(!editedImages.isEmpty()){
            editedImages.pop().setImageDrawable(null);
        }
    }

}
