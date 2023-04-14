package com.example.timewise_rsa2023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PomodoroInfo extends AppCompatActivity {

    private TextView back_tv;
    Button goToTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pomodoro_info);
        back_tv = findViewById(R.id.back_textview);
        goToTimer = findViewById(R.id.go_to_timer);

        back_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), StudyResourcesActivity.class);
                startActivity(intent);
                finish();
            }
        });

        goToTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SelectPomodoroTimer.class);
                startActivity(intent);
                finish();
            }
        });
    }
}