package com.example.timewise_rsa2023;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LearningStyleQuiz extends AppCompatActivity implements View.OnClickListener{

    TextView totalQuestionTextView;
    TextView questionTextView;
    Button ansA, ansB;
    Button nextButton;

    int visualScore = 0;
    int auditoryScore = 0;
    int kinestheticScore = 0;

    int totalQuestion = QuestionAnswer.questions.length;
    int currentQuestionIndex = 0;
    String selectedAnswer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learning_style_quiz);

        totalQuestionTextView = findViewById(R.id.question_progress);
        questionTextView = findViewById(R.id.question);
        ansA = findViewById(R.id.ans_a);
        ansB = findViewById(R.id.ans_b);
        nextButton = findViewById(R.id.next);

        ansA.setBackgroundColor(Color.BLUE);
        ansB.setBackgroundColor(Color.BLUE);

        ansA.setOnClickListener(this);
        ansB.setOnClickListener(this);
        nextButton.setOnClickListener(this);

        totalQuestionTextView.setText("Total questions: " + totalQuestion);

        loadNewQuestion();

    }

    @Override
    public void onClick(View view) {

        ansA.setBackgroundColor(Color.BLUE);
        ansB.setBackgroundColor(Color.BLUE);

        Button clickedButton = (Button) view;
        if (clickedButton.getId() == R.id.next) {
            currentQuestionIndex ++;
            loadNewQuestion();
            if (selectedAnswer.equals(QuestionAnswer.yesAnswer)) {
                if (currentQuestionIndex <= 2) {
                    visualScore ++;
                } else if (currentQuestionIndex >= 3 && currentQuestionIndex <= 5) {
                    auditoryScore ++;
                } else if (currentQuestionIndex >= 6 && currentQuestionIndex <= 8) {
                    kinestheticScore ++;
                }
            }
        } else {
            selectedAnswer = clickedButton.getText().toString();
            clickedButton.setBackgroundColor(Color.MAGENTA);
        }
    }
    void loadNewQuestion() {

        if (currentQuestionIndex == totalQuestion) {
            finishQuiz();
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            finish();
            return;
        }

        questionTextView.setText(QuestionAnswer.questions[currentQuestionIndex]);
        ansA.setText(QuestionAnswer.choices[currentQuestionIndex][0]);
        ansB.setText(QuestionAnswer.choices[currentQuestionIndex][1]);
    }
    void finishQuiz() {
        String learning_type = "";
        if (visualScore > auditoryScore && visualScore > kinestheticScore) {
            learning_type = "Visual";
        } else if (auditoryScore > visualScore && auditoryScore > kinestheticScore) {
            learning_type = "Auditory";
        } else if (kinestheticScore > visualScore && kinestheticScore > auditoryScore) {
            learning_type = "Kinesthetic";
        } else {
            learning_type = "Combination Learner";
        }

        new AlertDialog.Builder(this)
                .setMessage("Your learning style is: " + learning_type)
                .setCancelable(true)
                .show();

    }

}