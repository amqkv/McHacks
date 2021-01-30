package com.example.myapplication;

import android.animation.ObjectAnimator;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.Button;
import android.widget.TextView;
import android.os.CountDownTimer;

public class MainActivity extends AppCompatActivity {

    static public int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int time = 15000;
        TextView timerTextView = (TextView) findViewById(R.id.timer);
        Button button = (Button) findViewById(R.id.clicker);
        Button speechBtn = (Button) findViewById(R.id.bubble);
        TextView scoreTextView = (TextView) findViewById(R.id.score);
        TextView scoreLabelTextView = (TextView) findViewById(R.id.score_label);

        speechBtn.setText("PET ME!");
        timerTextView.setText(""+time/1000);

        // Animator
        ObjectAnimator animator = ObjectAnimator.ofFloat(button, "translationY", -30f, 0f);
        animator.setDuration(100);
        animator.setInterpolator(new BounceInterpolator());

        // creating timer object
        CountDownTimer timer = new CountDownTimer(time, 1000){
            @Override
            public void onTick(long millisUntilFinished) {
                timerTextView.setText(""+millisUntilFinished/1000);
            }

            @Override
            public void onFinish() {
                openActivity2();
            }
        };
        timer.cancel();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            // onclick event
            public void onClick(View v) {
                animator.start();
                if (score == 0) {
                    // countdown starts
                    timer.start();
                    speechBtn.setText("U w U");
                    scoreLabelTextView.setText("Your score");
                }
                score++;
                scoreTextView.setText("" + score);
            }
        });
    }

    public void openActivity2() {
        Intent intent = new Intent(this, EndingPage.class);
        startActivity(intent);
    }

}