package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class FinishedScreenActivity extends AppCompatActivity {

    public TextView congrats;
    public TextView finalScore;
    public Button playAgain;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finished_screen);
        wireWidgets();
        setListeners();
        Intent lastIntent = getIntent();
        int finalScoreInt = lastIntent.getIntExtra(MainActivity.FINAL_SCORE, 0);
        finalScore.setText(getString(R.string.textView_finalScore) + finalScoreInt);
    }
    public void wireWidgets(){
        congrats = findViewById(R.id.textView_finished_congrats);
        finalScore = findViewById(R.id.textView_finished_finalpoints);
        playAgain = findViewById(R.id.button_finished_playAgain);
    }

    public void setListeners(){
        playAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent targetIntent = new Intent(FinishedScreenActivity.this, StartScreenActivity.class);
                startActivity(targetIntent);
            }
        });
    }
}
