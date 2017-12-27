package com.ina.android.tutortoyoumaster;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class TutorManageCred extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutor_manage_cred);

        final EditText manageTutorId = (EditText) findViewById(R.id.etTutorId);
        final EditText manageTutorEmail = (EditText) findViewById(R.id.etTutorEmail);
        final EditText manageTutorPhone = (EditText) findViewById(R.id.etTutorPhone);

        Intent intent = getIntent();
        int idtutor = intent.getIntExtra("idtutor", + 1);
        String email = intent.getStringExtra("email");
        String phone = intent.getStringExtra("phone");

        manageTutorId.setText(idtutor + "");
        manageTutorId.setFocusable(false);
        manageTutorId.setEnabled(false);

        manageTutorEmail.setText(email);
        manageTutorEmail.setFocusable(false);

        manageTutorPhone.setText(phone);
        manageTutorPhone.setFocusable(false);
    }
}
