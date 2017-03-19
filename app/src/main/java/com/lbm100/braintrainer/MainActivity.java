package com.lbm100.braintrainer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button button;
    TextView question;
    ArrayList<Integer> answers;
    int locationOfAnswer ;

    public  void onStart(View view) {

        button.setVisibility(View.GONE);
    }

    public  void  chooseAnswer(View view){

        if ( Integer.parseInt(view.getTag().toString()) == locationOfAnswer) {
            Log.i("Answers...","right! ");
        }else {
            Log.i("Answers..."," no right! ");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        question = (TextView) findViewById(R.id.question);

        Button button1 = (Button) findViewById(R.id.answer1);
        Button button2 = (Button) findViewById(R.id.answer2);
        Button button3 = (Button) findViewById(R.id.answer3);
        Button button4 = (Button) findViewById(R.id.answer4);


        Random rand = new Random();

        int a = rand.nextInt(21);
        int b = rand.nextInt(21);

        question.setText(a + " + " + b + " = ");

        locationOfAnswer = rand.nextInt(4);

        int incorrectAnswer ;

        answers = new ArrayList<Integer>();

        for (int i = 0; i < 4; i++) {

            if (i == locationOfAnswer) {
                answers.add(a+b);
            }else {

                incorrectAnswer = rand.nextInt(41);

                while (incorrectAnswer == a+b){
                    incorrectAnswer = rand.nextInt(41);
                }

                answers.add(incorrectAnswer);
            }
        }



        button1.setText(Integer.toString(answers.get(0)));
        button2.setText(Integer.toString(answers.get(1)));
        button3.setText(Integer.toString(answers.get(2)));
        button4.setText(Integer.toString(answers.get(3)));


    }
}
