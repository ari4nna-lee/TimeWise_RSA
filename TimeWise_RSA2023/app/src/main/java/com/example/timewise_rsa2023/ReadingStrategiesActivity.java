package com.example.timewise_rsa2023;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.LayoutTransition;
import android.content.Intent;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ReadingStrategiesActivity extends AppCompatActivity {

    LinearLayout layout;
    TextView back_tv;
    TextView detailsText;
    TextView detailsTextTwo;
    LinearLayout layout_two;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reading_strategies);
        back_tv = findViewById(R.id.back_textview);
        layout = findViewById(R.id.layout);
        layout_two = findViewById(R.id.layout_2);

        detailsText = findViewById(R.id.sq_details);
        detailsTextTwo = findViewById(R.id.thieves_details);

        layout.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);
        layout_two.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);

        back_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), StudyResourcesActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void expand(View view) {
        int v = (detailsText.getVisibility() == View.GONE)? View.VISIBLE: View.GONE;

        TransitionManager.beginDelayedTransition(layout, new AutoTransition());
        detailsText.setVisibility(v);
    }

    public void expandTwo(View view) {
        int v = (detailsTextTwo.getVisibility() == View.GONE)? View.VISIBLE: View.GONE;

        TransitionManager.beginDelayedTransition(layout_two, new AutoTransition());
        detailsTextTwo.setVisibility(v);
    }
}