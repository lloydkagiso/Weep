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

public class Presidents extends AppCompatActivity {

    TextView viewText;
    Button btnNext;
    RadioGroup rg;
    RadioButton r1, r2,r3;
    ArrayList<String> listQuestions = new ArrayList<>();
   // Random randomQuestion = new Random();
    int score = 0;
    int index = 0;
    String question = "";
    Button  scores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_presidents);


        viewText = (TextView)findViewById(R.id.viewQuestion);
        btnNext = (Button)findViewById(R.id.next);
        rg = (RadioGroup)findViewById(R.id.groupRadioButtons);
        r1 = (RadioButton)findViewById(R.id.rb1);
        r2 = (RadioButton)findViewById(R.id.rb2);
        r3 = (RadioButton)findViewById(R.id.rb3);
        scores =(Button) findViewById(R.id.scores);

        /*
        *populating array list with values
         */

        listQuestions.add(getResources().getString(R.string.vice_president));
        listQuestions.add(getResources(). getString(R.string.first_president));
        listQuestions.add(getResources().getString(R.string.age));
        listQuestions.add(getResources().getString(R.string.zimbabwe));
        listQuestions.add(getResources().getString(R.string.un));


        //Collections.shuffle(listQuestions);
        question = listQuestions.get(index);
        if (question.equals(getResources().getString(R.string.vice_president))) {



            viewText.setText(question);
            r1.setText("Jacob Zuma");
            r2.setText("Kgalema Mothlante");
            r3.setText("Nelson Mandela");

            rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {

                    if(checkedId == R.id.rb1)
                    {

                        score += 0;
                    }else if(checkedId == R.id.rb2)
                    {

                        score += 1;
                    }else if(checkedId == R.id.rb3)
                    {

                        score += 0;
                    }

                }
            });

            index++;
        }

       // scores.setVisibility(View.GONE);
    }




    public void buttonNext(View view)
    {
        btnNext.setText("Next");


        if (index < listQuestions.size() ) {

            question = listQuestions.get(index);
            Log.i("Ygritte",question+index);
            if (question.equals(getResources().getString(R.string.first_president))) {

                viewText.setText(question);
                r1.setText("Nelson Mandela");
                r2.setText("Steve Biko");
                r3.setText("John L Dube");

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

                            score += 1;
                        }

                    }
                });


            } else if (question.equals(getResources().getString(R.string.zimbabwe))) {
                viewText.setText(question);

                r1.setText("Robert Mogabe");
                r2.setText("Mahomed Gadaffi");
                r3.setText("Mogane Changarai");


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
            } else if (question.equals(getResources().getString(R.string.un))) {
                viewText.setText(question);

                r1.setText("Thabo Mbeki");
                r2.setText("Nkosikazi Zuma");
                r3.setText("Robert Mogabe");

                rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {

                        if (checkedId == R.id.rb1) {

                            score += 0;
                        } else if (checkedId == R.id.rb2) {

                            score += 0;
                        } else if (checkedId == R.id.rb3) {

                            score += 1;
                        }

                    }
                });


            }

            index++;
            if (index > 4){
                scores.setVisibility(View.VISIBLE);

                btnNext.setVisibility(View.GONE);
            }
        }



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
