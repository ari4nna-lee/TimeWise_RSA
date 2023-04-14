package com.example.timewise_rsa2023;

import com.example.timewise_rsa2023.LearningStyleQuiz;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class StudyResourcesActivity extends AppCompatActivity {

    private TextView back_tv;
    CardView readingStrategies;
    CardView learningTechniques;
    CardView noteMethods;
    CardView genWellness;
    CardView learningQuizResults;
    CardView pomodoroInfo;
    String learningType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_resources);
        back_tv = findViewById(R.id.back_textview);
        readingStrategies = findViewById(R.id.card_view_1);
        learningTechniques = findViewById(R.id.card_view_2);
        noteMethods = findViewById(R.id.card_view_3);
        genWellness = findViewById(R.id.card_view_4);
        learningQuizResults = findViewById(R.id.learning_type_card);
        pomodoroInfo = findViewById(R.id.pomodoro_info);
        Intent intent = getIntent();
        learningType = intent.getStringExtra("learningStyle");

        back_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        readingStrategies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ReadingStrategiesActivity.class);
                startActivity(intent);
                finish();
            }
        });

        learningTechniques.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LearningStrategiesActivity.class);
                startActivity(intent);
                finish();
            }
        });

        noteMethods.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), NoteMethodsActivity.class);
                startActivity(intent);
                finish();
            }
        });

        genWellness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), GenWellnessTipsActivity.class);
                startActivity(intent);
                finish();
            }
        });

        learningQuizResults.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (learningType == "Visual") {
                    Intent intent = new Intent(getApplicationContext(), VisualLearnerInfo.class);
                    startActivity(intent);
                    finish();
                } else if (learningType == "Auditory") {
                    Intent intent = new Intent(getApplicationContext(), AuditoryLearnerInfo.class);
                    startActivity(intent);
                    finish();
                } else if (learningType == "Kinesthetic") {
                    Intent intent = new Intent(getApplicationContext(), KinestheticLearnerInfo.class);
                    startActivity(intent);
                    finish();
                }
            }
        });

        pomodoroInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), PomodoroInfo.class);
                startActivity(intent);
                finish();
            }
        });
    }
}