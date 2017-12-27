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

public class TutorLogin extends AppCompatActivity {

    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutor_login);

        final EditText TutorUsername = (EditText) findViewById(R.id.etTutorUsername);
        final EditText TutorPassword = (EditText) findViewById(R.id.etTutorPassword);

        final Button TutorLogin = (Button) findViewById(R.id.btnTutorLogin);

        final TextView tvLinkTutorRegister = (TextView) findViewById(R.id.tvLink3);

        TutorLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String tutorUsername = TutorUsername.getText().toString();
                final String tutorPassword = TutorPassword.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");

                            if(success){

                                int idtutor = jsonResponse.getInt("idtutor");
                                String name = jsonResponse.getString("name");
                                String email = jsonResponse.getString("email");
                                String phone = jsonResponse.getString("phone");

                                Intent intent = new Intent(TutorLogin.this, TutorHome.class);
                                intent.putExtra("idtutor", idtutor);
                                intent.putExtra("username", tutorUsername);
                                intent.putExtra("password", tutorPassword);
                                intent.putExtra("name", name);
                                intent.putExtra("email", email);
                                intent.putExtra("phone", phone);

                                progressDialog = new ProgressDialog(TutorLogin.this);
                                progressDialog.setMessage("Authenticating data...");
                                progressDialog.setTitle("Logging in");
                                progressDialog.setProgress(500);
                                progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                                progressDialog.show();

                                TutorLogin.this.startActivity(intent);

                            }else{
                                AlertDialog.Builder builder = new AlertDialog.Builder(TutorLogin.this);
                                builder.setMessage("Log In Failed").setNegativeButton("Retry", null)
                                        .create().show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                };

                TutorLoginRequest tutorLoginRequest = new TutorLoginRequest(tutorUsername, tutorPassword, responseListener);
                RequestQueue queue = Volley.newRequestQueue(TutorLogin.this);
                queue.add(tutorLoginRequest);

            }
        });

        tvLinkTutorRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tutorRegisterIntent = new Intent (TutorLogin.this, TutorRegister.class);
                TutorLogin.this.startActivity(tutorRegisterIntent);
            }
        });
    }
}
