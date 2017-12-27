package com.fueledbyarif.android.uniten_v110;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText etUsername = (EditText) findViewById(R.id.etUsername);
        final EditText etPassword = (EditText) findViewById(R.id.etPassword);

        final Button bLogin = (Button) findViewById(R.id.bLogin);

        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String studentId = etUsername.getText().toString();
                final String studentpassword = etPassword.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");

                            if(success){
                                String studentname = jsonResponse.getString("studentname");
                                String lecturer_name = jsonResponse.getString("lecturer_name");
                                String program_name = jsonResponse.getString("program_name");
                                String studentnumber = jsonResponse.getString("studentnumber");
                                String studentemail = jsonResponse.getString("studentemail");
                                String ledger_balance = jsonResponse.getString("ledger_balance");
                                String studentresult = jsonResponse.getString("studentresult");

                                Intent intent = new Intent(getApplicationContext(), Home.class);
                                intent.putExtra("studentname", studentname);
                                intent.putExtra("studentId", studentId);
                                intent.putExtra("lecturer_name", lecturer_name);
                                intent.putExtra("program_name", program_name);
                                intent.putExtra("studentnumber", studentnumber);
                                intent.putExtra("studentemail", studentemail);
                                intent.putExtra("ledger_balance", ledger_balance);
                                intent.putExtra("studentresult", studentresult);

                                //Login.this.startActivity(intent);
                                startActivity(intent);
                            }else{
                                AlertDialog.Builder builder = new AlertDialog.Builder(Login.this);
                                builder.setMessage("Network error or wrong credentials entered")
                                        .setNegativeButton("Retry", null)
                                        .create()
                                        .show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                };

                LoginRequest loginRequest = new LoginRequest(studentId, studentpassword, responseListener);
                RequestQueue queue = Volley.newRequestQueue(Login.this);
                queue.add(loginRequest);

            }
        });
    }
}
