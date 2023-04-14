package com.example.timewise_rsa2023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BeginQuiz extends AppCompatActivity {

    Button buttonBeginQuiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_begin_quiz);
        buttonBeginQuiz = findViewById(R.id.beginQuiz);

        buttonBeginQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LearningStyleQuiz.class);
                startActivity(intent);
                finish();
            }
        });
    }
}