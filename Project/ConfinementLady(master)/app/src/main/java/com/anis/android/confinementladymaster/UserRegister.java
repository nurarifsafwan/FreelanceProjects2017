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

public class UserRegister extends AppCompatActivity {

    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_register);

        final EditText userUsername = (EditText) findViewById(R.id.etUserUsername);
        final EditText userPassword = (EditText) findViewById(R.id.etUserPassword);
        final EditText userName = (EditText) findViewById(R.id.etUserName);
        final EditText userPhone = (EditText) findViewById(R.id.etUserPhone);
        final EditText userAdress = (EditText) findViewById(R.id.etUserAddress);

        final Button userRegister = (Button) findViewById(R.id.btnUserRegister);

        userRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String useraddUsername = userUsername.getText().toString();
                final String useraddPassword = userPassword.getText().toString();
                final String useraddName = userName.getText().toString();
                final String useraddPhone = userPhone.getText().toString();
                final String useraddAddress = userAdress.getText().toString();


                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");

                            if(success){
                                progressDialog = new ProgressDialog(UserRegister.this);
                                progressDialog.setMessage("Registering into database...");
                                progressDialog.setTitle("Registering");
                                progressDialog.setProgress(500);
                                progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                                progressDialog.show();
                                Intent intent = new Intent(UserRegister.this, UserLogin.class);
                                UserRegister.this.startActivity(intent);
                            }

                        } catch (JSONException e) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(UserRegister.this);
                            builder.setMessage("Registration Failed").setNegativeButton("Retry", null)
                                    .create().show();
                        }

                    }
                };

                UserRegisterRequest userRegisterRequest = new UserRegisterRequest(useraddUsername, useraddPassword, useraddName, useraddPhone, useraddAddress, responseListener);
                RequestQueue queue = Volley.newRequestQueue(UserRegister.this);
                queue.add(userRegisterRequest);
            }
        });
    }
}
