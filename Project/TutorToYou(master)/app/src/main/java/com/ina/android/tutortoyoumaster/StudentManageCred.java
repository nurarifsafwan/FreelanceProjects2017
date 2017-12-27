package com.ina.android.tutortoyoumaster;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.kosalgeek.genasync12.AsyncResponse;
import com.kosalgeek.genasync12.PostResponseAsyncTask;

import java.util.HashMap;

public class StudentManageCred extends AppCompatActivity implements View.OnClickListener {

    Button btnUpdateStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_manage_cred);

        final EditText StudentId = (EditText) findViewById(R.id.etStudentId);
        final EditText StudentEmail = (EditText) findViewById(R.id.etStudentEmail);
        final EditText StudentPhone = (EditText) findViewById(R.id.etStudentPhone);

        Intent intent = getIntent();
        int idstudent = intent.getIntExtra("idstudent", + 1);
        String email = intent.getStringExtra("email");
        String phone = intent.getStringExtra("phone");

        StudentId.setText(idstudent + "");
        StudentId.setEnabled(false);
        StudentId.setFocusable(false);

        StudentEmail.setText(email);
        StudentPhone.setText(phone);

        btnUpdateStudent = (Button) findViewById(R.id.btnUpdateStudent);
        btnUpdateStudent.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        final EditText StudentId = (EditText) findViewById(R.id.etStudentId);
        final EditText StudentEmail = (EditText) findViewById(R.id.etStudentEmail);
        final EditText StudentPhone = (EditText) findViewById(R.id.etStudentPhone);

        HashMap postData = new HashMap();
        postData.put("idstudent", StudentId.getText().toString());
        postData.put("email", StudentEmail.getText().toString());
        postData.put("phone", StudentPhone.getText().toString());
        postData.put("mobile", "android");

        PostResponseAsyncTask taskUpdate = new PostResponseAsyncTask(StudentManageCred.this, postData, new AsyncResponse() {
            @Override
            public void processFinish(String s) {
                if(s.contains("success")){
                    Toast.makeText(StudentManageCred.this, "Successfully Updated", Toast.LENGTH_LONG).show();
                }
            }
        });
        taskUpdate.execute("http://10.0.2.2/tutortoyou/UpdateStudent.php");
    }
}
