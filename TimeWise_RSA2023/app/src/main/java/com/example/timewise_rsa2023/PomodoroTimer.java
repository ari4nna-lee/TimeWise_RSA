package com.example.timewise_rsa2023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class PomodoroTimer extends AppCompatActivity {

    private int roundCount;
    private int studyMinutes;
    private int breakMinutes;

    private CountDownTimer restTimer;
    private CountDownTimer studyTimer;
    private CountDownTimer breakTimer;
    ImageView ivStop;

    TextView numberRounds;
    TextView status;
    TextView tvTimer;
    TextView tvRestart;
    ProgressBar progressBar;

    private int mRound = 1;

    private boolean isStudying = true;

    private boolean isStop = false;

    private MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pomodoro_timer);
        numberRounds = findViewById(R.id.no_of_cycles);
        status = findViewById(R.id.tv_status);
        progressBar = findViewById(R.id.progress_bar);
        tvTimer = findViewById(R.id.countdown_timer);
        ivStop = findViewById(R.id.timer_stop);
        tvRestart = findViewById(R.id.restart_timer_tv);
        Intent intent = getIntent();
        roundCount = intent.getIntExtra("numberOfCycles", 1);
        studyMinutes = intent.getIntExtra("studyMinutes", 0) * 60 * 1000;
        breakMinutes = intent.getIntExtra("breakMinutes", 0) * 60 * 1000;

        numberRounds.setText(mRound + "/" + roundCount);
        setRestTimer();
        tvRestart.setVisibility(View.INVISIBLE);
        ivStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetOrStart();
            }
        });
    }

    private void setRestTimer() {
        tvRestart.setVisibility(View.INVISIBLE);
        status.setText("starting soon");
        progressBar.setProgress(0);
        progressBar.setMax(10);
        restTimer = new CountDownTimer(10500,1000) {
            @Override
            public void onTick(long l) {
                int currentProgress = 0;
                progressBar.setProgress(Math.toIntExact(l / 1000));
                tvTimer.setText(Long.toString(l / 1000));
            }
            @Override
            public void onFinish() {
                if (isStudying) {
                    setupStudyView();
                } else {
                    setUpBreakView();
                }
            }
        }.start();

    }
    private void setStudyTimer() {
        tvRestart.setVisibility(View.INVISIBLE);
        studyTimer = new CountDownTimer(Long.valueOf(studyMinutes), 1000) { //TODO change time to actual times 1500500
            @Override
            public void onTick(long l) {
                progressBar.setProgress(Math.toIntExact(l / 1000));
                tvTimer.setText(createTimeLabels(Math.toIntExact(l / 1000)));
            }

            @Override
            public void onFinish() {
                if (mRound < roundCount) {
                    isStudying = false;
                    setRestTimer();
                    mRound++;
                } else {
                    clearAttribute();
                    status.setText("You have finished all your study rounds!");
                }
            }
        }.start();
    }

    private void setBreakTimer() {
        tvRestart.setVisibility(View.INVISIBLE);
        breakTimer = new CountDownTimer(Long.valueOf(breakMinutes), 1000) { //TODO change time to actual times 300500
            @Override
            public void onTick(long l) {
                progressBar.setProgress(Math.toIntExact(l / 1000));
                tvTimer.setText(createTimeLabels(Math.toIntExact(l / 1000)));
            }

            @Override
            public void onFinish() {
                isStudying = true;
                setRestTimer();
            }
        }.start();
    }

    private void setupStudyView() {
        tvRestart.setVisibility(View.INVISIBLE);
        numberRounds.setText(mRound + "/" + roundCount);
        status.setText("study time");
        progressBar.setMax(studyMinutes / 1000); //TODO change time to actual times 1500500

        if (studyTimer != null) {
            studyTimer = null;
        }
        setStudyTimer();
    }
    private void setUpBreakView() {
        tvRestart.setVisibility(View.INVISIBLE);
        status.setText("break time!");
        progressBar.setMax(breakMinutes / 1000); // TODO change time to actual

        if (breakTimer != null) {
            breakTimer = null;
        }
        setBreakTimer();
    }

    private void clearAttribute() {
        status.setText("press play button to restart timer");
        tvRestart.setVisibility(View.VISIBLE);
        ivStop.setImageResource(R.drawable.ic_play);
        progressBar.setProgress(0);
        tvTimer.setText("0");
        mRound = 1;
        numberRounds.setText(mRound + "/" + roundCount);
        if (restTimer != null) {
            restTimer.cancel();
        }
        if (studyTimer != null) {
            studyTimer.cancel();
        }
        if (breakTimer != null) {
            breakTimer.cancel();
        }
        restTimer = null;
        studyTimer = null;
        breakTimer = null;
        isStop = true;

        tvRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                tvRestart.setVisibility(View.INVISIBLE);
                finish();
            }
        });
    }

    private String createTimeLabels(int time) {
        tvRestart.setVisibility(View.INVISIBLE);
        String timeLabel = "";
        int minutes = time / 60;
        int seconds = time % 60;

        if (minutes < 10) {
            timeLabel = timeLabel + "0";
        }
        timeLabel = timeLabel + "" + minutes + ":";
        if (seconds < 10) {
            timeLabel = timeLabel + "0";
        }
        timeLabel += seconds;
        return timeLabel;
    }

    private void resetOrStart() {
        if (isStop) {
            ivStop.setImageResource(R.drawable.ic_stop);
            setRestTimer();
            isStop = false;
        } else {
            clearAttribute();
        }
    }

}