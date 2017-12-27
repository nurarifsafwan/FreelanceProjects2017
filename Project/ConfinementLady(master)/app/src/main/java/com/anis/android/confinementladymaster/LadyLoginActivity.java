package com.anis.android.confinementladymaster;

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

public class LadyLoginActivity extends AppCompatActivity {

    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lady_login2);

        final EditText ladyUsername = (EditText) findViewById(R.id.etLadyUsername);
        final EditText ladyPassword = (EditText) findViewById(R.id.etLadyPassword);

        final Button ladyLogin = (Button) findViewById(R.id.btnLadyLogin);

        final TextView ladyRegister = (TextView) findViewById(R.id.tvLadyLogin3);
        final TextView ladyUserLink = (TextView) findViewById(R.id.tvLadyLogin4);

        ladyLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String ladyaddUsername = ladyUsername.getText().toString();
                final String ladyaddPassword = ladyPassword.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");

                            if(success){

                                int idlady = jsonResponse.getInt("idlady");
                                String name = jsonResponse.getString("name");
                                String phone = jsonResponse.getString("phone");
                                String address = jsonResponse.getString("address");

                                Intent intent = new Intent(LadyLoginActivity.this, LadyHomeLanding.class);
                                intent.putExtra("idlady", idlady);
                                intent.putExtra("username", ladyaddUsername);
                                intent.putExtra("password", ladyaddPassword);
                                intent.putExtra("name", name);
                                intent.putExtra("phone", phone);
                                intent.putExtra("address", address);

                                progressDialog = new ProgressDialog(LadyLoginActivity.this);
                                progressDialog.setMessage("Authenticating data...");
                                progressDialog.setTitle("Logging in");
                                progressDialog.setProgress(500);
                                progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                                progressDialog.show();
                                LadyLoginActivity.this.startActivity(intent);

                            }else{
                                AlertDialog.Builder builder = new AlertDialog.Builder(LadyLoginActivity.this);
                                builder.setMessage("Log In Failed").setNegativeButton("Retry", null)
                                        .create().show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                };

                LadyLoginRequest ladyLoginRequest = new LadyLoginRequest(ladyaddUsername, ladyaddPassword, responseListener);
                RequestQueue queue = Volley.newRequestQueue(LadyLoginActivity.this);
                queue.add(ladyLoginRequest);
            }
        });

        ladyRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent (LadyLoginActivity.this, LadyRegister.class);
                LadyLoginActivity.this.startActivity(registerIntent);
            }
        });

        ladyUserLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent userIntent = new Intent (LadyLoginActivity.this, UserLogin.class);
                LadyLoginActivity.this.startActivity(userIntent);
            }
        });

    }
}
