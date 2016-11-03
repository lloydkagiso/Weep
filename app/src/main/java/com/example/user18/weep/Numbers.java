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

public class Numbers extends AppCompatActivity {

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
        setContentView(R.layout.activity_numbers);

        viewText = (TextView)findViewById(R.id.viewQuestion);
       // viewScore = (TextView)findViewById(R.id.score);
        btnNext = (Button)findViewById(R.id.next);
        rg = (RadioGroup)findViewById(R.id.groupRadioButtons);
        r1 = (RadioButton)findViewById(R.id.rb1);
        r2 = (RadioButton)findViewById(R.id.rb2);
        r3 = (RadioButton)findViewById(R.id.rb3);
        scores =(Button) findViewById(R.id.scores);


        /*
        *populating array list with values
         */

        listQuestions.add(getResources().getString(R.string.x));
        listQuestions.add(getResources(). getString(R.string.multi));
        listQuestions.add(getResources().getString(R.string.zero));
        listQuestions.add(getResources().getString(R.string.one));


        //Collections.shuffle(listQuestions);
        question = listQuestions.get(index);
        if (question.equals(getResources().getString(R.string.x))) {

            viewText.setText(question);
            r1.setText("5");
            r2.setText("6");
            r3.setText("9");

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
            //scores.setVisibility(View.GONE);
            scores.setEnabled(false);
        }
    }




    public void buttonNext(View view)
    {
        btnNext.setText("Next");


        if (index < listQuestions.size() ) {

            question = listQuestions.get(index);
            Log.i("Ygritte",question+index);
            if (question.equals(getResources().getString(R.string.zero))) {

                viewText.setText(question);
                r1.setText("40");
                r2.setText("20");
                r3.setText("0");

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


            } else if (question.equals(getResources().getString(R.string.multi))) {
                viewText.setText(question);

                r1.setText("0 ");
                r2.setText("1000");
                r3.setText("100");


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
            } else if (question.equals(getResources().getString(R.string.one))) {
                viewText.setText(question);

                r1.setText("1.20");
                r2.setText("1.25");
                r3.setText("1.00");

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
