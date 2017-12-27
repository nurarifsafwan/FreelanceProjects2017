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

public class UserLogin extends AppCompatActivity {

    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);

        final EditText userUsername = (EditText) findViewById(R.id.etUserUsername);
        final EditText userPassword = (EditText) findViewById(R.id.etUserPassword);

        final Button userLogin = (Button) findViewById(R.id.btnUserLogin);

        final TextView userRegister = (TextView) findViewById(R.id.tvUserRegistration);
        final TextView userLadyLink = (TextView) findViewById(R.id.tvUserLadyLink);

        userLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String useraddUsername = userUsername.getText().toString();
                final String useraddPassword = userPassword.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");

                            if(success){

                                int iduser = jsonResponse.getInt("iduser");
                                String name = jsonResponse.getString("name");
                                String phone = jsonResponse.getString("phone");
                                String address = jsonResponse.getString("address");

                                Intent intent = new Intent(UserLogin.this, UserHome.class);
                                intent.putExtra("iduser", iduser);
                                intent.putExtra("username", useraddUsername);
                                intent.putExtra("password", useraddPassword);
                                intent.putExtra("name", name);
                                intent.putExtra("phone", phone);
                                intent.putExtra("address", address);

                                progressDialog = new ProgressDialog(UserLogin.this);
                                progressDialog.setMessage("Authenticating Account...");
                                progressDialog.setTitle("Logging You In");
                                progressDialog.setProgress(500);
                                progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                                progressDialog.show();
                                UserLogin.this.startActivity(intent);

                            }else{
                                AlertDialog.Builder builder = new AlertDialog.Builder(UserLogin.this);
                                builder.setMessage("Log In Failed").setNegativeButton("Retry", null)
                                        .create().show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                };

                UserLoginRequest userLoginRequest = new UserLoginRequest(useraddUsername, useraddPassword, responseListener);
                RequestQueue queue = Volley.newRequestQueue(UserLogin.this);
                queue.add(userLoginRequest);
            }
        });

        userRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent (UserLogin.this, UserRegister.class);
                UserLogin.this.startActivity(registerIntent);
            }
        });

        userLadyLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ladyIntent = new Intent (UserLogin.this, LadyLoginActivity.class);
                UserLogin.this.startActivity(ladyIntent);
            }
        });

    }
}
