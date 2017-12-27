package com.ina.android.tutortoyoumaster;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class StudentClassesEnroll extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_classes_enroll);

        final TextView link1 = (TextView) findViewById(R.id.textView7);
        final TextView link2 = (TextView) findViewById(R.id.textView6);
        final TextView link3 = (TextView) findViewById(R.id.textView14);
        final TextView link4 = (TextView) findViewById(R.id.textView15);

        link1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudentClassesEnroll.this, StudentBrowseClass.class);
                StudentClassesEnroll.this.startActivity(intent);
            }
        });

        link2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudentClassesEnroll.this, StudentBrowseClass.class);
                StudentClassesEnroll.this.startActivity(intent);
            }
        });

        link3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudentClassesEnroll.this, StudentBrowseClass.class);
                StudentClassesEnroll.this.startActivity(intent);
            }
        });

        link4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudentClassesEnroll.this, StudentBrowseClass.class);
                StudentClassesEnroll.this.startActivity(intent);
            }
        });
    }
}
