package com.ina.android.tutortoyoumaster;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class TutorHome extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutor_home);

        final TextView welcome = (TextView) findViewById(R.id.tvWelcome2);

        final EditText tutorID = (EditText) findViewById(R.id.etTutorId);
        final EditText tutorName = (EditText) findViewById(R.id.etTutorName);
        final EditText tutorEmail = (EditText) findViewById(R.id.etTutorEmail);
        final EditText tutorNumber = (EditText) findViewById(R.id.etTutorNumber);

        final Button tutorManage = (Button) findViewById(R.id.btnManageTutor);
        final Button tutorAddClass = (Button) findViewById(R.id.btnAddClass);
        final Button tutorClasses = (Button) findViewById(R.id.btnMyClass);

        Intent intent = getIntent();
        int idtutor = intent.getIntExtra("idtutor", -1);
        String username = intent.getStringExtra("username");
        String name = intent.getStringExtra("name");
        String email = intent.getStringExtra("email");
        String phone = intent.getStringExtra("phone");

        welcome.setText(username + "! Welcome.");

        tutorID.setText(idtutor + "");
        tutorID.setEnabled(false);
        tutorID.setFocusable(false);

        tutorName.setText(name);
        tutorName.setFocusable(false);
        tutorName.setEnabled(false);

        tutorEmail.setText(email);
        tutorEmail.setEnabled(false);
        tutorEmail.setFocusable(false);

        tutorNumber.setText(phone);
        tutorNumber.setEnabled(false);
        tutorNumber.setFocusable(false);

        tutorManage.setOnClickListener(this);

        tutorAddClass.setOnClickListener(this);

        tutorClasses.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.btnManageTutor) {
            final EditText hometutorId = (EditText) findViewById(R.id.etTutorId);
            final EditText hometutorEmail = (EditText) findViewById(R.id.etTutorEmail);
            final EditText hometutorPhone = (EditText) findViewById(R.id.etTutorNumber);

            final String tutorId = hometutorId.getText().toString();
            final String tutorEmail = hometutorEmail.getText().toString();
            final String tutorPhone = hometutorPhone.getText().toString();

            Intent manageTutorIntent = new Intent(TutorHome.this, TutorManageCred.class);
            manageTutorIntent.putExtra("tutorid", tutorId);
            manageTutorIntent.putExtra("email", tutorEmail);
            manageTutorIntent.putExtra("phone", tutorPhone);
            TutorHome.this.startActivity(manageTutorIntent);

        }else if(v.getId()== R.id.btnAddClass){

            final EditText addtutorId = (EditText) findViewById(R.id.etTutorId);
            final EditText addtutorPhone = (EditText) findViewById(R.id.etTutorNumber);

            final String tutorId = addtutorId.getText().toString();
            final String tutorPhone = addtutorPhone.getText().toString();

            Intent addClassIntent = new Intent(TutorHome.this, TutorInsertClass.class);
            addClassIntent.putExtra("tutorid", tutorId);
            addClassIntent.putExtra("phone", tutorPhone);
            TutorHome.this.startActivity(addClassIntent);


        }else if(v.getId()== R.id.btnMyClass){

            Intent intent = new Intent(TutorHome.this, TutorClasses.class);
            TutorHome.this.startActivity(intent);

        }

    }
}
