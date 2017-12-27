package com.fueledbyarif.android.uniten_v110;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        final TextView tvStudentId = (TextView) findViewById(R.id.tvStudentId);
        final TextView tvName = (TextView) findViewById(R.id.tvName);
        final TextView tvLecturer = (TextView) findViewById(R.id.tvLecturer);
        final TextView tvProgram = (TextView) findViewById(R.id.tvProgram);
        final TextView tvNumber = (TextView) findViewById(R.id.tvNumber);
        final TextView tvEmail = (TextView) findViewById(R.id.tvEmail);

        final EditText etLedger = (EditText) findViewById(R.id.etLedger);
        final EditText etResult = (EditText) findViewById(R.id.etResult);


        final Button bLedger = (Button) findViewById(R.id.bLedger);
        final Button bResult = (Button) findViewById(R.id.bResult);
        final Button bTimetable = (Button) findViewById(R.id.bTimetable);
        final Button bAnnounce = (Button) findViewById(R.id.bAnnounce);


        Intent intent = getIntent();
        String studentId = intent.getStringExtra("studentId");
        String studentname = intent.getStringExtra("studentname");
        String lecturer_name = intent.getStringExtra("lecturer_name");
        String program_name = intent.getStringExtra("program_name");
        String studentnumber = intent.getStringExtra("studentnumber");
        String studentemail = intent.getStringExtra("studentemail");
        String ledger_balance = intent.getStringExtra("ledger_balance");
        String studentresult = intent.getStringExtra("studentresult");

        tvStudentId.setText(studentId);
        tvName.setText(studentname);
        tvLecturer.setText(lecturer_name);
        tvProgram.setText(program_name);
        tvNumber.setText(studentnumber);
        tvEmail.setText(studentemail);
        etLedger.setText(ledger_balance);
        etResult.setText(studentresult);

        //SharedPreferences settings = getSharedPreferences(PREFS_LEDGER, Context.MODE_PRIVATE);
        //SharedPreferences.Editor editor = settings.edit();
        //editor.putString("ledger_balance", ledger_balance);
        //editor.commit();

        bLedger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //String ledger_balance = etLedger.getText().toString();

                Intent intent = new Intent(Home.this, Ledger.class);
                //intent.putExtra("ledger_balance", ledger_balance);
                startActivity(intent);
                //SharedPreferences settings = getSharedPreferences(PREFS_LEDGER, Context.MODE_PRIVATE);
                //SharedPreferences.Editor editor = settings.edit();
                //editor.putString("ledger_balance", ledger_balance);
                //editor.commit();

                //Intent intent = new Intent(getApplicationContext(), Ledger.class);
                //startActivity(intent);

            }
        });

        bResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, Results.class);
                startActivity(intent);
            }
        });

        bTimetable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, Timetable.class);
                startActivity(intent);
            }
        });

        bAnnounce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, Announcement.class);
                startActivity(intent);
            }
        });
    }
}
