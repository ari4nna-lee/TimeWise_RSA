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

public class LearningStrategiesActivity extends AppCompatActivity {

    private TextView back_tv;
    private LinearLayout layout;
    private LinearLayout layout_two;
    private LinearLayout layout_three;
    private LinearLayout layout_four;
    private LinearLayout layout_five;

    private TextView detailsText;
    private TextView detailsTextTwo;
    private TextView detailsTextThree;
    private TextView detailsTextFour;
    private TextView detailsTextFive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learning_strategies);

        back_tv = findViewById(R.id.back_textview);
        layout = findViewById(R.id.layout);
        layout_two = findViewById(R.id.layout_2);
        layout_three = findViewById(R.id.layout_three);
        layout_four = findViewById(R.id.layout_4);
        layout_five = findViewById(R.id.layout_5);

        detailsText = findViewById(R.id.retrieval_details);
        detailsTextTwo = findViewById(R.id.ac_details);
        detailsTextThree = findViewById(R.id.sp_details);
        detailsTextFour = findViewById(R.id.pq_details);
        detailsTextFive = findViewById(R.id.fm_details);

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

    public void expandThree(View view) {
        int v = (detailsTextThree.getVisibility() == View.GONE)? View.VISIBLE: View.GONE;

        TransitionManager.beginDelayedTransition(layout_three, new AutoTransition());
        detailsTextThree.setVisibility(v);
    }

    public void expandFour(View view) {
        int v = (detailsTextFour.getVisibility() == View.GONE)? View.VISIBLE: View.GONE;

        TransitionManager.beginDelayedTransition(layout_four, new AutoTransition());
        detailsTextFour.setVisibility(v);
    }

    public void expandFive(View view) {
        int v = (detailsTextFive.getVisibility() == View.GONE)? View.VISIBLE: View.GONE;

        TransitionManager.beginDelayedTransition(layout_five, new AutoTransition());
        detailsTextFive.setVisibility(v);
    }
}