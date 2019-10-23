package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wireWidgets();
        setListeners();
        InputStream JsonFileInput = getResources().openRawResource(R.raw.questions); // getting XML
        String jsonfile = readTextFile(JsonFileInput);

        // create a gson object
        Gson gson = new Gson();
        // read your json file into an array of questions
        Question[] questions =  gson.fromJson(jsonfile, Question[].class);    // Where are your POJO model classes? Quiz & Question?
                // Plain Old Java Object
        // convert your array to a list using the Arrays utility class
        questionsList = Arrays.asList(questions);

        InputStream JsonInputStream = getResources().openRawResource(R.raw.questions); // getting XML

        String jsonText = readTextFile(JsonInputStream);
        textView_question.setText(questionsList.get(questionNumber).getQuestion());
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



    public void wireWidgets(){
        button_true = findViewById(R.id.button_main_true);
        button_false = findViewById(R.id.button_main_false);
        textView_question = findViewById(R.id.textView_main_question);
        textView_points = findViewById(R.id.textView_main_points);
    }

    public void setListeners(){
        button_true.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (questionsList.get(questionNumber).getAnswer()){
                    points++;
                    questionNumber++;
                }
                else{
                    questionNumber++;
                }
                textView_question.setText(questionsList.get(questionNumber).getQuestion());
                textView_points.setText("Points: " + points);

            }
        });
        button_false.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!questionsList.get(questionNumber).getAnswer()){
                    points++;
                    questionNumber++;
                }
                else{
                    questionNumber++;

                }
                textView_question.setText(questionsList.get(questionNumber).getQuestion());
                textView_points.setText("Points: " + points);

            }
        });
    }





}
