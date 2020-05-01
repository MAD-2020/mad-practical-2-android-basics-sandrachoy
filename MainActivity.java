package com.example.activity2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button buttonLeft;
    private Button buttonMid;
    private Button buttonRight;
    private List<Button> buttonList = new ArrayList<>();
    private TextView scoring;
    private static final String TAG = "Whack-A-Mole";
    private Integer scoreValue;



    /* Hint
        - The function setNewMole() uses the Random class to generate a random value ranged from 0 to 2.
        - Feel free to modify the function to suit your program.
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonLeft = (Button) findViewById(R.id.Button1);
        buttonMid = (Button) findViewById(R.id.Button2);
        buttonRight = (Button) findViewById(R.id.Button3);
        scoring = (TextView) findViewById(R.id.Score);
        scoreValue = Integer.parseInt(scoring.getText().toString());

        buttonList.add(buttonLeft);
        buttonList.add(buttonMid);
        buttonList.add(buttonRight);

        Log.v(TAG, "Finished Pre-Initialisation!");

    }

    @Override
    protected void onStart(){
        super.onStart();
        setNewMole();
        Log.v(TAG, "Starting GUI!");

        buttonLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v(TAG,"Button Left Clicked!");
                if (buttonLeft.getText().toString() == "*"){

                    scoreValue +=1;
                    scoring.setText(Integer.toString(scoreValue));

                    Log.v(TAG,"Hit, score added!");
                }
                else{
                    scoreValue -=1;
                    scoring.setText(Integer.toString(scoreValue));

                    Log.v(TAG,"Missed, score deducted!");
                }
                reset();
                setNewMole();
            }
        });
        buttonMid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v(TAG,"Button Mid Clicked!");
                if (buttonMid.getText().toString() == "*"){

                    scoreValue +=1;
                    scoring.setText(Integer.toString(scoreValue));
                    Log.v(TAG,"Hit, score added!");
                }
                else{
                    scoreValue -=1;
                    scoring.setText(Integer.toString(scoreValue));

                    Log.v(TAG,"Missed, score deducted!");
                }
                reset();
                setNewMole();
            }
        });
        buttonRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v(TAG,"Button Right Clicked!");
                if (buttonRight.getText().toString() == "*"){

                    scoreValue +=1;
                    scoring.setText(Integer.toString(scoreValue));
                    Log.v(TAG,"Hit, score added!");
                }
                else{
                    scoreValue -=1;
                    scoring.setText(Integer.toString(scoreValue));

                    Log.v(TAG,"Missed, score deducted!");
                }
                reset();
                setNewMole();
            }
        });
    }

    public void setNewMole()
    {
        Random ran = new Random();
        int randomLocation = ran.nextInt(3);

        buttonList.get(randomLocation).setText("*");
    }
    public void reset(){
        buttonLeft.setText("O");
        buttonMid.setText("O");
        buttonRight.setText("O");
    }

}
