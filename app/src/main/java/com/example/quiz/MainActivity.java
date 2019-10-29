package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.google.gson.Gson;

import org.w3c.dom.Text;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public Button button_true;
    public Button button_false;
    public TextView textView_question;
    public TextView textView_points;
    public List<Question> questionsList;
    int questionNumber = 0;
    int points = 0;
    public static final String FINAL_SCORE = "finalScore";
    public TextView textView_questionNumber;
    public ConstraintLayout mainConstraintLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wireWidgets();
        setListeners();
        InputStream JsonFileInput = getResources().openRawResource(R.raw.questions); // getting XML
        String jsonfile = readTextFile(JsonFileInput);
        Gson gson = new Gson();
        Question[] questions = gson.fromJson(jsonfile, Question[].class);    // Where are your POJO model classes? Quiz & Question?
        questionsList = Arrays.asList(questions);
        InputStream JsonInputStream = getResources().openRawResource(R.raw.questions); // getting XML
        textView_question.setText(questionsList.get(questionNumber).getQuestion());
        textView_points.setText(getString(R.string.points) + points);
        textView_questionNumber.setText("Question: " + (questionNumber + 1));
        int r = (int)(Math.random() * 256);
        int g = (int)(Math.random() * 256);
        int bl = (int)(Math.random() * 256);
        int color = Color.rgb(r, g, bl);
        mainConstraintLayout.setBackgroundColor(color);
    }
    public String readTextFile(InputStream inputStream) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        byte buf[] = new byte[1024];
        int len;
        try {
            while ((len = inputStream.read(buf)) != -1) {
                outputStream.write(buf, 0, len);
            }
            outputStream.close();
            inputStream.close();
        } catch (IOException e) {

        }
        return outputStream.toString();
    }
    public void wireWidgets() {
        button_true = findViewById(R.id.button_main_true);
        button_false = findViewById(R.id.button_main_false);
        textView_question = findViewById(R.id.textView_main_question);
        textView_points = findViewById(R.id.textView_main_points);
        textView_questionNumber = findViewById(R.id.textView_main_questionNumber);
        mainConstraintLayout = findViewById(R.id.ConstraintLayout_main_layout);
    }
    public void setListeners() {
        button_true.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (questionsList.get(questionNumber).getAnswer()) {
                    points++;
                    if (questionNumber < 10) {
                        questionNumber++;
                        textView_questionNumber.setText("Question: " + (questionNumber + 1));
                        int r = (int)(Math.random() * 256);
                        int g = (int)(Math.random() * 256);
                        int bl = (int)(Math.random() * 256);
                        int color = Color.rgb(r, g, bl);
                        mainConstraintLayout.setBackgroundColor(color);
                    } else {
                        int extra_points = points;
                        Intent targetIntent = new Intent(MainActivity.this, FinishedScreenActivity.class);
                        targetIntent.putExtra(FINAL_SCORE, extra_points);
                        startActivity(targetIntent);
                    }
                } else {
                    if (questionNumber < 10) {
                        questionNumber++;
                        textView_questionNumber.setText("Question: " + (questionNumber + 1));
                        int r = (int)(Math.random() * 256);
                        int g = (int)(Math.random() * 256);
                        int bl = (int)(Math.random() * 256);
                        int color = Color.rgb(r, g, bl);
                        mainConstraintLayout.setBackgroundColor(color);
                    } else {
                        int extra_points = points;
                        Intent targetIntent = new Intent(MainActivity.this, FinishedScreenActivity.class);
                        targetIntent.putExtra(FINAL_SCORE, extra_points);
                        startActivity(targetIntent);
                    }
                }
                textView_question.setText(questionsList.get(questionNumber).getQuestion());
                textView_points.setText(getString(R.string.points) + points);
            }
        });
        button_false.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!questionsList.get(questionNumber).getAnswer()) {
                    points++;
                    if (questionNumber < 10) {
                        questionNumber++;
                        textView_questionNumber.setText("Question: " + (questionNumber + 1));
                        int r = (int)(Math.random() * 256);
                        int g = (int)(Math.random() * 256);
                        int bl = (int)(Math.random() * 256);
                        int color = Color.rgb(r, g, bl);
                        mainConstraintLayout.setBackgroundColor(color);
                    } else {
                        int extra_points = points;
                        Intent targetIntent = new Intent(MainActivity.this, FinishedScreenActivity.class);
                        targetIntent.putExtra(FINAL_SCORE, extra_points);
                        startActivity(targetIntent);
                    }
                } else {
                    if (questionNumber < 12) {
                        questionNumber++;
                        textView_questionNumber.setText("Question: " + (questionNumber + 1));
                        int r = (int)(Math.random() * 256);
                        int g = (int)(Math.random() * 256);
                        int bl = (int)(Math.random() * 256);
                        int color = Color.rgb(r, g, bl);
                        mainConstraintLayout.setBackgroundColor(color);
                    } else {
                        int extra_points = points;
                        Intent targetIntent = new Intent(MainActivity.this, FinishedScreenActivity.class);
                        targetIntent.putExtra(FINAL_SCORE, extra_points);
                        startActivity(targetIntent);
                    }
                }
                textView_question.setText(questionsList.get(questionNumber).getQuestion());
                textView_points.setText(getString(R.string.points) + points);
            }
        });
    }
}
