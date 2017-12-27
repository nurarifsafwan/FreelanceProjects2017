package com.ina.android.tutortoyoumaster;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class StudentLogin extends AppCompatActivity {

    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);

        final EditText etStudentUsername = (EditText) findViewById(R.id.etStudentUsername);
        final EditText etStudentPassword = (EditText) findViewById(R.id.etStudentPassword);

        final Button btnStudentLogin = (Button) findViewById(R.id.btnStudentLogin);

        final TextView tvLinkRegister = (TextView) findViewById(R.id.tvLink1);
        final TextView tvLinkTutor = (TextView) findViewById(R.id.tvLink2);

        btnStudentLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String studentUsername = etStudentUsername.getText().toString();
                final String studentPassword = etStudentPassword.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");

                            if(success){

                                int idstudent = jsonResponse.getInt("idstudent");
                                String name = jsonResponse.getString("name");
                                String email = jsonResponse.getString("email");
                                String phone = jsonResponse.getString("phone");

                                Intent intent = new Intent(StudentLogin.this, StudentHome.class);
                                intent.putExtra("idstudent", idstudent);
                                intent.putExtra("username", studentUsername);
                                intent.putExtra("password", studentPassword);
                                intent.putExtra("name", name);
                                intent.putExtra("email", email);
                                intent.putExtra("phone", phone);

                                progressDialog = new ProgressDialog(StudentLogin.this);
                                progressDialog.setMessage("Authenticating data...");
                                progressDialog.setTitle("Logging in");
                                progressDialog.setProgress(500);
                                progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                                progressDialog.show();

                                StudentLogin.this.startActivity(intent);

                            }else{
                                AlertDialog.Builder builder = new AlertDialog.Builder(StudentLogin.this);
                                builder.setMessage("Log In Failed").setNegativeButton("Retry", null)
                                        .create().show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                };

                StudentLoginRequest studentLoginRequest = new StudentLoginRequest(studentUsername, studentPassword, responseListener);
                RequestQueue queue = Volley.newRequestQueue(StudentLogin.this);
                queue.add(studentLoginRequest);
            }
        });

        tvLinkRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent (StudentLogin.this, StudentRegister.class);
                StudentLogin.this.startActivity(registerIntent);
            }
        });

        tvLinkTutor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tutorLoginIntent = new Intent (StudentLogin.this, TutorLogin.class);
                StudentLogin.this.startActivity(tutorLoginIntent);
            }
        });

    }
}
