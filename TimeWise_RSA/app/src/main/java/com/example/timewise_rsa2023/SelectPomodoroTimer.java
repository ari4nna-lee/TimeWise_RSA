package com.example.timewise_rsa2023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class SelectPomodoroTimer extends AppCompatActivity {

    TextInputEditText numberOfCycles;
    TextView whatisPomodoro;
    Button startTimer;
    TextView backButton;
    TextView studyMinutes;
    TextView breakMinutes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_pomodoro_timer);
        numberOfCycles = findViewById(R.id.number_of_cycles);
        studyMinutes = findViewById(R.id.study_minutes);
        breakMinutes = findViewById(R.id.break_minutes);
        whatisPomodoro = findViewById(R.id.pomodoro_info);
        startTimer = findViewById(R.id.start_pomodoro);
        backButton = findViewById(R.id.back_textview);

        startTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String no_cycles;
                String study_mins;
                String break_mins;
                no_cycles = String.valueOf(numberOfCycles.getText());
                study_mins = String.valueOf(studyMinutes.getText());
                break_mins = String.valueOf(breakMinutes.getText());

                if (TextUtils.isEmpty(no_cycles)) {
                    Toast.makeText(SelectPomodoroTimer.this, "please enter the number of cycles you want to complete", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    Intent intent = new Intent(getApplicationContext(), PomodoroTimer.class);
                    intent.putExtra("numberOfCycles", Integer.parseInt(no_cycles));
                    intent.putExtra("studyMinutes", Integer.parseInt(study_mins));
                    intent.putExtra("breakMinutes", Integer.parseInt(break_mins));
                    startActivity(intent);
                    finish();
                }
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        whatisPomodoro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), PomodoroInfo.class);
                startActivity(intent);
                finish();
            }
        });
    }
}