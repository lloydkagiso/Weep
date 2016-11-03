package com.example.user18.weep;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //getting the Nature TextView from the XML
        TextView numbers = (TextView) findViewById(R.id.numbers);

        //set a OnclickListener
        numbers.setOnClickListener(new View.OnClickListener() {
            @Override
            //setting OnclickListener on TextView Numbers
            public void onClick(View v) {
                //Intent the next screen after clicking numbers TextView
                Intent numberIntent = new Intent(MainActivity.this, Numbers.class);




                //start the intent
                startActivity(numberIntent);
            }
        });

        TextView nature = (TextView) findViewById(R.id.nature);

        //set a clickListener on nature TextVierw
        nature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //next screen when clicking the Nature Textview
                Intent natureIntent = new Intent(MainActivity.this, Nature.class);

                //start the intent Activity
                startActivity(natureIntent);

            }
        });

        TextView presidents = (TextView) findViewById(R.id.presidents);

        //set OnclickListener
        presidents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //what should happen when clicking the President TextView
                Intent presidentIntent = new Intent(MainActivity.this, Presidents.class);

                //start the Activity
                startActivity(presidentIntent);
            }
        });
    }
}
