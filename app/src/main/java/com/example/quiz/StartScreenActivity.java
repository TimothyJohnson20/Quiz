package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StartScreenActivity extends AppCompatActivity {

    public TextView textView_welcome;
    public TextView textView_startToPlay;
    public Button button_startGame;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);
        wireWidgets();
        setListeners();
    }
    private void wireWidgets(){
        textView_welcome = findViewById(R.id.textView_startScreen_welcome);
        textView_startToPlay = findViewById(R.id.textView_startScreen_startToPlay);
        button_startGame = findViewById(R.id.button_startScreen_play);
    }
    private void setListeners(){
        button_startGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent targetIntent = new Intent(StartScreenActivity.this, MainActivity.class);
                startActivity(targetIntent);
            }
        });
    }

}
