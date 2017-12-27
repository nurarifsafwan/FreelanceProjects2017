package com.ina.android.tutortoyoumaster;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class TutorClasses extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutor_classes);

        final TextView link1 = (TextView) findViewById(R.id.textView42);
        final TextView link2 = (TextView) findViewById(R.id.textView43);
        final TextView link3 = (TextView) findViewById(R.id.textView48);
        final TextView link4 = (TextView) findViewById(R.id.textView49);

        link1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TutorClasses.this, TutorDeleteClass.class);
                TutorClasses.this.startActivity(intent);
            }
        });

        link2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TutorClasses.this, TutorDeleteClass.class);
                TutorClasses.this.startActivity(intent);
            }
        });

        link3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TutorClasses.this, TutorDeleteClass.class);
                TutorClasses.this.startActivity(intent);
            }
        });

        link4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TutorClasses.this, TutorDeleteClass.class);
                TutorClasses.this.startActivity(intent);
            }
        });
    }
}
