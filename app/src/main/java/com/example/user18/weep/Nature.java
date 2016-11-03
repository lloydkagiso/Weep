package com.example.user18.weep;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import static com.example.user18.weep.R.id.scores;

public class Nature extends AppCompatActivity {

    TextView viewText;
    Button btnNext;
    RadioGroup rg;
    RadioButton r1, r2,r3;
    ArrayList<String> listQuestions = new ArrayList<>();
    //Random randomQuestion = new Random();
    int score = 0;
    int index = 0;
    String question = "";
    Button  scores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nature);

        viewText = (TextView) findViewById(R.id.viewQuestion);
      //  viewScore = (TextView)findViewById(R.id.score);
        btnNext = (Button)findViewById(R.id.next);
        rg = (RadioGroup)findViewById(R.id.groupRadioButtons);
        r1 = (RadioButton)findViewById(R.id.rb1);
        r2 = (RadioButton)findViewById(R.id.rb2);
        r3 = (RadioButton)findViewById(R.id.rb3);
        scores =(Button) findViewById(R.id.scores);


        /*
        *populating array list with values
         */

        listQuestions.add(getResources().getString(R.string.export));
        listQuestions.add(getResources(). getString(R.string.letterV));
        listQuestions.add(getResources().getString(R.string.nylon));
        listQuestions.add(getResources().getString(R.string.letterQ));



        //Collections.shuffle(listQuestions);
        question = listQuestions.get(index);
        if (question.equals(getResources().getString(R.string.export))) {

            viewText.setText(question);
            r1.setText("Female");
            r2.setText("Male");
            r3.setText("Others");

            rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {

                    if(checkedId == R.id.rb1)
                    {

                        score += 1;
                    }else if(checkedId == R.id.rb2)
                    {

                        score += 0;
                    }else if(checkedId == R.id.rb3)
                    {

                        score += 0;
                    }

                }
            });

            index++;
            scores.setEnabled(false);

        }
    }




    public void buttonNext(View view)
    {
        btnNext.setText("Next");


        if (index < listQuestions.size() ) {

            question = listQuestions.get(index);
            Log.i("Ygritte",question+index);
            if (question.equals(getResources().getString(R.string.letterV))) {

                viewText.setText(question);
                r1.setText("Female");
                r2.setText("Male");
                r3.setText("Others");

                rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {

                        if(checkedId == R.id.rb1)
                        {

                            score += 1;
                        }else if(checkedId == R.id.rb2)
                        {

                            score += 0;
                        }else if(checkedId == R.id.rb3)
                        {

                            score += 0;
                        }

                    }
                });


            } else if (question.equals(getResources().getString(R.string.nylon))) {
                viewText.setText(question);

                r1.setText("South African");
                r2.setText("Zimbabwen");
                r3.setText("American");


                rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {

                        if(checkedId == R.id.rb1)
                        {

                            score += 0;
                        }else if(checkedId == R.id.rb2)
                        {

                            score += 0;
                        }else if(checkedId == R.id.rb3)
                        {

                            score += 1;
                        }

                    }
                });
            } else if (question.equals(getResources().getString(R.string.letterQ))) {
                viewText.setText(question);

                r1.setText("20");
                r2.setText("35");
                r3.setText("40");

                rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {

                        if (checkedId == R.id.rb1) {

                            score += 1;
                        } else if (checkedId == R.id.rb2) {

                            score += 0;
                        } else if (checkedId == R.id.rb3) {

                            score += 0;
                        }

                    }
                });


            }

            index++;
            if (index >= 4){
                scores.setVisibility(View.VISIBLE);
                scores.setEnabled(true);
                btnNext.setVisibility(View.GONE);
            }

        }

       // viewScore.setText(String.valueOf(score));

    }

    public void scoreMethod (View view )
    {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Score Results");
        builder.setMessage("You have obtained " + score);
        builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        AlertDialog alert = builder.create();
        alert.show();

    }
}
