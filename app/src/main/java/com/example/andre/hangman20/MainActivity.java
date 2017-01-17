package com.example.andre.hangman20;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private int strikes=0;
    private int score=0;
    final private int winLimit = 5;
    final private int loseLimit = 5;
    private Dictionary myDictionary = new Dictionary(getApplicationContext(),"words");
    private ArrayList<String> words = myDictionary.getMyWords();
    private String[] word =  createWords(words);
    final private ImageView myMan = (ImageView) findViewById(R.id.imgMan);
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myMan.setImageResource(R.drawable.HangManDefault);

        final TextView LetterOne = (TextView) findViewById(R.id.txtLetterOne);
        final TextView LetterTwo = (TextView) findViewById(R.id.txtLetterTwo);
        final TextView LetterThree = (TextView) findViewById(R.id.txtLetterThree);
        final TextView LetterFour = (TextView) findViewById(R.id.txtLetterFour);
        final TextView LetterFive = (TextView) findViewById(R.id.txtLetterFive);

        final EditText userSubbmit = (EditText) findViewById(R.id.txtSubbmit);
        Button subbmit = (Button) findViewById(R.id.btnSubbmit);
        final Button reset = (Button) findViewById(R.id.btnReset);

        subbmit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String l =  userSubbmit.getText().toString();
                if (l.equals(word[0])) {
                    LetterOne.setText(word[0]);
                    score++;
                }
                else {
                    strikes++;
                    changeMan(strikes);
                }
                if (l.equals(word[1])) {
                    LetterTwo.setText(word[1]);
                    score++;
                }
                else {
                    strikes++;
                    changeMan(strikes);
                }
                if (l.equals(word[2])) {
                    LetterThree.setText(word[2]);
                    score++;
                }
                else {
                    strikes++;
                    changeMan(strikes);
                }
                if (l.equals(word[3])) {
                    LetterFour.setText(word[3]);
                    score++;
                }
                else {
                    strikes++;
                    changeMan(strikes);
                }
                if (l.equals(word[4])) {
                    LetterFive.setText(word[4]);
                    score++;
                }
                else {
                    strikes++;
                    changeMan(strikes);
                }

                if(score>=winLimit)
                    resetGame("win");//win
                if (strikes>=loseLimit)
                    resetGame("lose");//lose

            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                resetGame("lose");
            }
        });


    }
    private String[] createWords(ArrayList<String> myWords){
        String[] usableWord = new String[5];
        String word = myWords.get((int)(Math.random()*myWords.size()));
        for (int i = 0; i<5; i++){
            usableWord[i]=word.substring(i,i++);
        }
        return usableWord;
    }

    private void changeMan(int strike){
        switch (strike){
            case 1 : myMan.setImageResource(R.drawable.HangMan5);
                     break;
            case 2 : myMan.setImageResource(R.drawable.HangMan5);
                    break;
            case 3 : myMan.setImageResource(R.drawable.HangMan5);
                    break;
            case 4 : myMan.setImageResource(R.drawable.HangMan5);
                    break;
            case 5 : myMan.setImageResource(R.drawable.HangMan5);
                    break;
        }
    }

    private void resetGame(String result){
        score=0;
        strikes=0;
        myMan.setImageResource(R.drawable.HangManDefault);

        final TextView LetterOne = (TextView) findViewById(R.id.txtLetterOne);
        final TextView LetterTwo = (TextView) findViewById(R.id.txtLetterTwo);
        final TextView LetterThree = (TextView) findViewById(R.id.txtLetterThree);
        final TextView LetterFour = (TextView) findViewById(R.id.txtLetterFour);
        final TextView LetterFive = (TextView) findViewById(R.id.txtLetterFive);

        if (result.equals("win")) {
            LetterOne.setText("W");
            LetterTwo.setText("I");
            LetterThree.setText("N");
            LetterFour.setText("E");
            LetterFive.setText("R");
        }
        if (result.equals("lose")) {
            LetterOne.setText("L");
            LetterTwo.setText("O");
            LetterThree.setText("S");
            LetterFour.setText("E");
            LetterFive.setText("R");
        }

    }


}
