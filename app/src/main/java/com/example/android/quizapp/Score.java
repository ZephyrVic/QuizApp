package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Score extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        displayProfile();
    }


    public void displayProfile(){

        String Score = getIntent().getStringExtra("Score");
        String Profile = getIntent().getStringExtra("profile");

        TextView profileText = (TextView) findViewById(R.id.profile);
        profileText.setText(Profile);
        TextView scoreDisplay = (TextView) findViewById(R.id.finalScore);
        scoreDisplay.setText(Score);

    }
}
