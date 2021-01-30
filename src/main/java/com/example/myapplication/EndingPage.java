package com.example.myapplication;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EndingPage extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ending_page);

        TextView yourScoreTextView = (TextView) findViewById(R.id.your_score);
        TextView finalScoreTextView = (TextView) findViewById(R.id.final_score);

        yourScoreTextView.setText("Your score is: \n\n Pet Tappy to play again");
        finalScoreTextView.setText(MainActivity.score + "!");

        Button button2 = (Button) findViewById(R.id.again);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.score = 0;
                openMainActivity();
                //restart timer
                //reset score
            }
        });
    }

    public void openMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}