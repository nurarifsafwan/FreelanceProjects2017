package com.ina.android.tutortoyoumaster;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class StudentRegister extends AppCompatActivity {

    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_register);

        final EditText etStudentUsername = (EditText) findViewById(R.id.etStudentUsername);
        final EditText etStudentPassword = (EditText) findViewById(R.id.etStudentPassword);
        final EditText etStudentFullName = (EditText) findViewById(R.id.etStudentName);
        final EditText etStudentFullEmail = (EditText) findViewById(R.id.etStudentEmail);
        final EditText etStudentPhoneNumber = (EditText) findViewById(R.id.etStudentPhone);

        final Button btnStudentRegister = (Button) findViewById(R.id.btnStudentRegister);

        btnStudentRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String studentUsername = etStudentUsername.getText().toString();
                final String studentPassword = etStudentPassword.getText().toString();
                final String etStudentName = etStudentFullName.getText().toString();
                final String etStudentEmail = etStudentFullEmail.getText().toString();
                final String etStudentPhone = etStudentPhoneNumber.getText().toString();


                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");

                            if(success){

                                progressDialog = new ProgressDialog(StudentRegister.this);
                                progressDialog.setMessage("Registering data...");
                                progressDialog.setTitle("Registering");
                                progressDialog.setProgress(500);
                                progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                                progressDialog.show();
                                Intent intent = new Intent(StudentRegister.this, StudentLogin.class);
                                StudentRegister.this.startActivity(intent);
                            }

                        } catch (JSONException e) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(StudentRegister.this);
                            builder.setMessage("Registration Failed").setNegativeButton("Retry", null)
                                    .create().show();
                        }

                    }
                };

                StudentRegisterRequest studentRegisterRequest = new StudentRegisterRequest(studentUsername, studentPassword, etStudentName, etStudentEmail, etStudentPhone, responseListener);
                RequestQueue queue = Volley.newRequestQueue(StudentRegister.this);
                queue.add(studentRegisterRequest);

            }
        });

    }
}
