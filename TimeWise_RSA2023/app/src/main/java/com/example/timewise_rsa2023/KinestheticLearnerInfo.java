package com.example.timewise_rsa2023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class KinestheticLearnerInfo extends AppCompatActivity {

    private TextView returnHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kinesthetic_learner_info);
        returnHome = findViewById(R.id. kine_return);

        returnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), VisualLearnerInfo.class);
                startActivity(intent);
                finish();
            }
        });
    }
}