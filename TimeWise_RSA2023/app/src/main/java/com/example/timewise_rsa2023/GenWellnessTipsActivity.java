package com.example.timewise_rsa2023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class GenWellnessTipsActivity extends AppCompatActivity {

    private TextView back_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gen_wellness_tips);
        back_tv = findViewById(R.id.back_textview);

        back_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), StudyResourcesActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}