package com.example.android.quizapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Score extends AppCompatActivity {

    String Score;
    String Profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        displayProfile();
    }


    public void displayProfile(){

        Score = getIntent().getStringExtra("Score");
        Profile = getIntent().getStringExtra("profile");

        TextView profileText = (TextView) findViewById(R.id.profile);
        profileText.setText(Profile);
        TextView scoreDisplay = (TextView) findViewById(R.id.finalScore);
        scoreDisplay.setText(Score);

    }
    public void composeEmail (View view){
        String mailBody = Profile + "\n\n";
        mailBody += "I Scored " + Score + " in the Power Sector Trivia";

        Intent sendEmail = new Intent(Intent.ACTION_SENDTO);
        sendEmail.setData(Uri.parse("mailto:"));
        sendEmail.putExtra(Intent.EXTRA_SUBJECT, "MY POWER SECTOR TRIVIA SCORE");
        sendEmail.putExtra(Intent.EXTRA_TEXT, mailBody);
        if (sendEmail.resolveActivity(getPackageManager()) != null){
            startActivity(sendEmail);
        }
    }
    public void restartQuiz (View view){
        Intent profilePage = new Intent(this, ProfileActivity.class);
        startActivity(profilePage);
    }
}
