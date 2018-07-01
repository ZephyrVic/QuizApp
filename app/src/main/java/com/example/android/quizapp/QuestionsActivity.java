package com.example.android.quizapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class QuestionsActivity extends AppCompatActivity {

    int currentQuestion;
    int currentScore = 0;
    float percent;
    String totalScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
        questVisibility(1);
    }

    /* Method gets the value of the chosen answer and compares with the correct answer.
    /The respective input types (RadioGroup, EditText and CheckBox) are extracted and compared in different manners.
     */
    public void showQuestion(View view) {

        if (currentQuestion == 2) {
            RadioGroup question1 = (RadioGroup) findViewById(R.id.quest_1_options);
            if (question1.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "Select an option", Toast.LENGTH_SHORT).show();
            } else {
                int question1Answer = question1.getCheckedRadioButtonId();
                String Q1Value = ((RadioButton) findViewById(question1Answer)).getText().toString();
                if (Q1Value.equals(getString(R.string._11))) {
                    setScore( 5);
                }
                questVisibility(currentQuestion);
            }
        }

        if (currentQuestion == 3) {
            RadioGroup question2 = (RadioGroup) findViewById(R.id.quest_2_options);
            if (question2.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "Select an option", Toast.LENGTH_SHORT).show();
            } else {
                int question2Answer = question2.getCheckedRadioButtonId();
                String Q2Value = ((RadioButton) findViewById(question2Answer)).getText().toString();
                if (Q2Value.equals(getString(R.string.RQ2option3))) {
                    setScore(5);
                }
                questVisibility(currentQuestion);
            }
        }
        if (currentQuestion == 4) {
            RadioGroup question3 = (RadioGroup) findViewById(R.id.quest_3_options);
            if (question3.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "Select an option", Toast.LENGTH_SHORT).show();
            } else {
                int question3Answer = question3.getCheckedRadioButtonId();
                String Q3Value = ((RadioButton) findViewById(question3Answer)).getText().toString();
                if (Q3Value.equals(getString(R.string.RQ3option3))) {
                    setScore(5);
                }
                questVisibility(currentQuestion);
            }
        }
        if (currentQuestion == 5) {
            CheckBox option1 = findViewById(R.id.q4_correct1);
            CheckBox option2 = findViewById(R.id.q4_correct2);
            CheckBox option3 = findViewById(R.id.q4_wrong);
            CheckBox option4 = findViewById(R.id.q4_correct3);
            if (option1.isChecked() && option2.isChecked() && option4.isChecked() && !option3.isChecked()) {
                setScore(6);
                questVisibility(currentQuestion);
            } else if (!option1.isChecked() && !option2.isChecked() && !option3.isChecked() && !option4.isChecked()) {
                Toast.makeText(this, "Select at least 1 option", Toast.LENGTH_SHORT).show();
            } else questVisibility(currentQuestion);
        }
        if (currentQuestion == 6) {
            EditText question5 = findViewById(R.id.quest5Input);
            String quest5Ans = question5.getText().toString();
            if (quest5Ans.equals("")) {
                Toast.makeText(this, "Input a Year", Toast.LENGTH_SHORT).show();
            } else {
                if (quest5Ans.equals("2013")) {
                    setScore(7);
                }
                questVisibility(currentQuestion);
            }
        }
        if (currentQuestion == 7) {
            RadioGroup question6 = (RadioGroup) findViewById(R.id.quest_6_options);
            if (question6.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "Select an option", Toast.LENGTH_SHORT).show();
            } else {
                int question6Answer = question6.getCheckedRadioButtonId();
                String Q6Value = ((RadioButton) findViewById(question6Answer)).getText().toString();
                if (Q6Value.equals(getString(R.string.RQ6option2))) {
                    setScore(5);
                }
                questVisibility(currentQuestion);
            }
        }

        if (currentQuestion == 8) {
            EditText question7 = findViewById(R.id.quest7Input);
            String quest7Ans = question7.getText().toString();
            if (quest7Ans.equals("")) {
                Toast.makeText(this, "Input number", Toast.LENGTH_SHORT).show();
            } else {
                if (quest7Ans.equals("2")) {
                    setScore(3);
                }
                questVisibility(currentQuestion);
            }
        }
        if (currentQuestion == 9) {
            RadioGroup question8 = (RadioGroup) findViewById(R.id.quest_8_options);
            if (question8.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "Select an option", Toast.LENGTH_SHORT).show();
            } else {
                int question8Answer = question8.getCheckedRadioButtonId();
                String Q8Value = ((RadioButton) findViewById(question8Answer)).getText().toString();
                if (Q8Value.equals(getString(R.string.q8option4))) {
                    setScore(5);
                }
                questVisibility(currentQuestion);
            }
        }
        if (currentQuestion == 10) {
            RadioGroup question9 = (RadioGroup) findViewById(R.id.quest_9_options);
            if (question9.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "Select an option", Toast.LENGTH_SHORT).show();
            } else {
                int question9Answer = question9.getCheckedRadioButtonId();
                String Q9Value = ((RadioButton) findViewById(question9Answer)).getText().toString();
                if (Q9Value.equals("KWh")) {
                    setScore(5);
                }
                questVisibility(currentQuestion);
            }
        }
        if (currentQuestion == 11) {
            CheckBox option1 = findViewById(R.id.q10_wrong1);
            CheckBox option2 = findViewById(R.id.q10_correct);
            CheckBox option3 = findViewById(R.id.q10_wrong2);
            CheckBox option4 = findViewById(R.id.q10_wrong3);
            if (option1.isChecked() && !option2.isChecked() && option3.isChecked() && option4.isChecked()) {
                setScore(4);
                launchScorePage();
            } else if (!option1.isChecked() && !option2.isChecked() && !option3.isChecked() && !option4.isChecked()) {
                Toast.makeText(this, "Select at least 1 option", Toast.LENGTH_SHORT).show();
            } else launchScorePage();
        }

    }

    //This method determines the question that is displayed.
    public void questVisibility(int quest) {
        View quest1View = findViewById(R.id.Question_1);
        View quest2View = findViewById(R.id.Question_2);
        View quest3View = findViewById(R.id.Question_3);
        View quest4View = findViewById(R.id.Question_4);
        View quest5View = findViewById(R.id.Question_5);
        View quest6View = findViewById(R.id.Question_6);
        View quest7View = findViewById(R.id.Question_7);
        View quest8View = findViewById(R.id.Question_8);
        View quest9View = findViewById(R.id.Question_9);
        View quest10View = findViewById(R.id.Question_10);
        if (quest == 1) {
            quest2View.setVisibility(View.GONE);
            quest3View.setVisibility(View.GONE);
            quest4View.setVisibility(View.GONE);
            quest5View.setVisibility(View.GONE);
            quest6View.setVisibility(View.GONE);
            quest7View.setVisibility(View.GONE);
            quest8View.setVisibility(View.GONE);
            quest9View.setVisibility(View.GONE);
            quest10View.setVisibility(View.GONE);
            currentQuestion = 2;
        }
        if (quest == 2) {
            quest1View.setVisibility(View.GONE);
            quest2View.setVisibility(View.VISIBLE);
            currentQuestion = 3;
        }
        if (quest == 3) {
            quest1View.setVisibility(View.GONE);
            quest2View.setVisibility(View.GONE);
            quest3View.setVisibility(View.VISIBLE);
            currentQuestion = 4;
        }
        if (quest == 4) {
            quest1View.setVisibility(View.GONE);
            quest2View.setVisibility(View.GONE);
            quest3View.setVisibility(View.GONE);
            quest4View.setVisibility(View.VISIBLE);
            currentQuestion = 5;
        }
        if (quest == 5) {
            quest1View.setVisibility(View.GONE);
            quest2View.setVisibility(View.GONE);
            quest3View.setVisibility(View.GONE);
            quest4View.setVisibility(View.GONE);
            quest5View.setVisibility(View.VISIBLE);
            currentQuestion = 6;
        }
        if (quest == 6) {
            quest1View.setVisibility(View.GONE);
            quest2View.setVisibility(View.GONE);
            quest3View.setVisibility(View.GONE);
            quest4View.setVisibility(View.GONE);
            quest5View.setVisibility(View.GONE);
            quest6View.setVisibility(View.VISIBLE);
            currentQuestion = 7;

        }
        if (quest == 7) {
            quest1View.setVisibility(View.GONE);
            quest2View.setVisibility(View.GONE);
            quest3View.setVisibility(View.GONE);
            quest4View.setVisibility(View.GONE);
            quest5View.setVisibility(View.GONE);
            quest6View.setVisibility(View.GONE);
            quest7View.setVisibility(View.VISIBLE);
            currentQuestion = 8;

        }
        if (quest == 8) {
            quest1View.setVisibility(View.GONE);
            quest2View.setVisibility(View.GONE);
            quest3View.setVisibility(View.GONE);
            quest4View.setVisibility(View.GONE);
            quest5View.setVisibility(View.GONE);
            quest6View.setVisibility(View.GONE);
            quest7View.setVisibility(View.GONE);
            quest8View.setVisibility(View.VISIBLE);
            currentQuestion = 9;

        }
        if (quest == 9) {
            quest1View.setVisibility(View.GONE);
            quest2View.setVisibility(View.GONE);
            quest3View.setVisibility(View.GONE);
            quest4View.setVisibility(View.GONE);
            quest5View.setVisibility(View.GONE);
            quest6View.setVisibility(View.GONE);
            quest7View.setVisibility(View.GONE);
            quest8View.setVisibility(View.GONE);
            quest9View.setVisibility(View.VISIBLE);
            currentQuestion = 10;

        }
        if (quest == 10) {
            quest1View.setVisibility(View.GONE);
            quest2View.setVisibility(View.GONE);
            quest3View.setVisibility(View.GONE);
            quest4View.setVisibility(View.GONE);
            quest5View.setVisibility(View.GONE);
            quest6View.setVisibility(View.GONE);
            quest7View.setVisibility(View.GONE);
            quest8View.setVisibility(View.GONE);
            quest9View.setVisibility(View.GONE);
            quest10View.setVisibility(View.VISIBLE);
            currentQuestion = 11;

        }
    }

    /*This method updates the score whenever the answer is correct.
    /it also calculates the percentage
    /@param points: this is the input variable for the score for each question
     */
    public void setScore(int points){
        currentScore += points;

        percent = (currentScore * 100) / 50;

        totalScore = percent + "%";
    }

    /* Method creates an intent to open the Score activity
    /it gets the value of the profile variable
    /it also creates an intent to pass both the score and profile values to the score activity
     */
    public void launchScorePage(){
        currentQuestion = 0;
        String profile = getIntent().getStringExtra("profile");
        Intent intent = new Intent(this, Score.class);
        intent.putExtra("Score" , totalScore );
        intent.putExtra("profile", profile);
        startActivity(intent);
    }
}
