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

public class MainActivity extends AppCompatActivity {

    public Button button_true;
    public Button button_false;
    public TextView textView_question;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wireWidgets();
        setListeners();
        InputStream JsonFileInput = getResources().openRawResource(R.raw.questions); // getting XML
        String jsonfile = readTextFile(JsonFileInput);
        textView_question.setText("ABOMINATION");
        // create a gson object
        Gson gson = new Gson();
        // read your json file into an array of questions
        Question[] questions =  gson.fromJson(jsonfile, Question[].class);    // Where are your POJO model classes? Quiz & Question?
                // Plain Old Java Object
        // convert your array to a list using the Arrays utility class
        List<Question> questionList = Arrays.asList(questions);
        // verify that it read everything properly
        Log.d(TAG, "onCreate: " + questionList.toString());
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

    public void Question(){
        boolean answer;
        String question;

    }

    public void Quiz(){

    }

    public void wireWidgets(){
        button_true = findViewById(R.id.button_main_true);
        button_false = findViewById(R.id.button_main_false);
        textView_question = findViewById(R.id.textView_main_question);
    }

    public void setListeners(){
        button_true.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        button_false.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    public void analyzeQuestion(){

    }



}
