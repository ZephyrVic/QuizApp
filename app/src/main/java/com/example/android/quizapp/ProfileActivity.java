package com.example.android.quizapp;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class ProfileActivity extends AppCompatActivity {
    //Variables to store user inputs and radio button values
    String nameInput;
    String countryInput;
    String stateInput;
    String gender;
    String ageGroup;
    String profileSummary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
    }

    public void getProfileDetails(View view){
        EditText name_text_Input = (EditText) findViewById(R.id.name_text_input);
        nameInput = name_text_Input.getText().toString();
        EditText country_text_Input = (EditText) findViewById(R.id.country_text_input);
        countryInput = country_text_Input.getText().toString();
        EditText state_text_Input = (EditText) findViewById(R.id.state_text_input);
        stateInput = state_text_Input.getText().toString();
        startQuiz(nameInput);
    }

    /*verification is done by this method to confirm if compulsory inputs (name, age group and gender) are given
    /The inputs are then combined and stored in the variables for use later in the Score activity
     */
    public void startQuiz(String name ){
        RadioGroup genderRadioButton = (RadioGroup) findViewById(R.id.gender_radio_group);
        RadioGroup ageRadioButton = (RadioGroup) findViewById(R.id.age_radio_group);
        if (name.equals("")){
            Toast.makeText(this,"No Name Input", Toast.LENGTH_SHORT).show();
        }

        else if (genderRadioButton.getCheckedRadioButtonId() == -1){
            Toast.makeText(this,"Select Gender", Toast.LENGTH_SHORT).show();
        }
        else if (ageRadioButton.getCheckedRadioButtonId() == -1){
            Toast.makeText(this,"Select Age Group", Toast.LENGTH_SHORT).show();
        }
        else {
            //Extracting the gender and age selections.
            ageGroup = ((RadioButton)findViewById(ageRadioButton.getCheckedRadioButtonId())).getText().toString();
            gender = ((RadioButton)findViewById(genderRadioButton.getCheckedRadioButtonId())).getText().toString();

            //Combining the various profile inputs to make a full Text of the profile
            profileSummary = getString(R.string.profName) + " " + nameInput + "\n";
            profileSummary += getString(R.string.profileCountry) + " " + countryInput + "\n";
            profileSummary += getString(R.string.profileState) +" " + stateInput +"\n";
            profileSummary += getString(R.string.profileAge) +" " + gender + "\n";
            profileSummary += getString(R.string.profileAge_1)+ " " + ageGroup;
            openQuestions();
        }

    }
    //this method opens the questions activity
    public void openQuestions(){
        Toast.makeText(this, "ALL QUESTIONS ARE COMPULSORY",Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, QuestionsActivity.class);
        intent.putExtra("profile" , profileSummary );
        startActivity(intent);
    }

}
