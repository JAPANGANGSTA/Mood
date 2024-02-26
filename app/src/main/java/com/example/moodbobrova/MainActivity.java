package com.example.moodbobrova;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView resultTextView, mainTextView;
    private Random random;
    private ImageView moodImageView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button generateButton = findViewById(R.id.generate_button);
        resultTextView = findViewById(R.id.result_text_view);
        mainTextView = findViewById(R.id.main_text_view);
        moodImageView = findViewById(R.id.mood_image_view);
        random = new Random();

        generateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateRandomNumber();
            }
        });
    }

    private void generateRandomNumber() {
        int generatedNumber = random.nextInt(100) + 1;
        resultTextView.setText(generatedNumber + " %");
        printMood(generatedNumber);
    }

    private void printMood(int generatedNumber) {
        if (generatedNumber <= 30) {
            mainTextView.setText("Feeling down, hang in there!");
            moodImageView.setImageResource(R.drawable.sad_image);
        } else if (generatedNumber <= 70) {
            mainTextView.setText("Keep it up, you're doing great!");
            moodImageView.setImageResource(R.drawable.happy_image);
        } else {
            mainTextView.setText("You're on fire, unstoppable!");
            moodImageView.setImageResource(R.drawable.superb_image);
        }
        moodImageView.setVisibility(View.VISIBLE);
        showToastMessage();
    }

    private void showToastMessage() {
        Toast.makeText(this, "Tap again for a new mood", Toast.LENGTH_SHORT).show();
    }
}
