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

public class TutorRegister extends AppCompatActivity {

    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutor_register);

        final EditText TutorUsername = (EditText) findViewById(R.id.etTutorUsername);
        final EditText TutorPassword = (EditText) findViewById(R.id.etTutorPassword);
        final EditText TutorName = (EditText) findViewById(R.id.etTutorName);
        final EditText TutorEmail = (EditText) findViewById(R.id.etTutorEmail);
        final EditText TutorPhone = (EditText) findViewById(R.id.etTutorPhone);

        final Button btnTutorRegister = (Button) findViewById(R.id.btnTutorRegister);

        btnTutorRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String tutorUsername = TutorUsername.getText().toString();
                final String tutorPassword = TutorPassword.getText().toString();
                final String tutorName = TutorName.getText().toString();
                final String tutorEmail = TutorEmail.getText().toString();
                final String tutorPhone = TutorPhone.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");

                            if(success){
                                progressDialog = new ProgressDialog(TutorRegister.this);
                                progressDialog.setMessage("Registering data...");
                                progressDialog.setTitle("Registering");
                                progressDialog.setProgress(500);
                                progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                                progressDialog.show();
                                Intent intent = new Intent(TutorRegister.this, TutorLogin.class);
                                TutorRegister.this.startActivity(intent);
                            }

                        } catch (JSONException e) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(TutorRegister.this);
                            builder.setMessage("Registration Failed").setNegativeButton("Retry", null)
                                    .create().show();
                        }

                    }
                };

                TutorRegisterRequest tutorRegisterRequest = new TutorRegisterRequest(tutorUsername, tutorPassword, tutorName, tutorEmail, tutorPhone, responseListener);
                RequestQueue queue = Volley.newRequestQueue(TutorRegister.this);
                queue.add(tutorRegisterRequest);

            }
        });
    }
}
