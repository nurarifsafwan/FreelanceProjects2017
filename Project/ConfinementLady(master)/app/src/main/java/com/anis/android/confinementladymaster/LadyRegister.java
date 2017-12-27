package com.anis.android.confinementladymaster;

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

public class LadyRegister extends AppCompatActivity {

    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lady_register);

        final EditText ladyUsername = (EditText) findViewById(R.id.etLadyUsername);
        final EditText ladyPassword = (EditText) findViewById(R.id.etLadyPassword);
        final EditText ladyName = (EditText) findViewById(R.id.etLadyName);
        final EditText ladyPhone = (EditText) findViewById(R.id.etLadyPhone);
        final EditText ladyAddress = (EditText) findViewById(R.id.etLadyAddress);

        final Button ladyRegister = (Button) findViewById(R.id.btnLadyRegister);

        ladyRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String ladyaddUsername = ladyUsername.getText().toString();
                final String ladyaddPassword = ladyPassword.getText().toString();
                final String ladyaddName = ladyName.getText().toString();
                final String ladyaddPhone = ladyPhone.getText().toString();
                final String ladyaddAddress = ladyAddress.getText().toString();


                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");

                            if(success){
                                progressDialog = new ProgressDialog(LadyRegister.this);
                                progressDialog.setMessage("Registering into database...");
                                progressDialog.setTitle("Registering");
                                progressDialog.setProgress(500);
                                progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                                progressDialog.show();
                                Intent intent = new Intent(LadyRegister.this, LadyLoginActivity.class);
                                LadyRegister.this.startActivity(intent);
                            }

                        } catch (JSONException e) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(LadyRegister.this);
                            builder.setMessage("Registration Failed").setNegativeButton("Retry", null)
                                    .create().show();
                        }

                    }
                };

                LadyRegisterReguest ladyRegisterReguest = new LadyRegisterReguest(ladyaddUsername, ladyaddPassword, ladyaddName, ladyaddPhone, ladyaddAddress, responseListener);
                RequestQueue queue = Volley.newRequestQueue(LadyRegister.this);
                queue.add(ladyRegisterReguest);
            }
        });

    }
}
