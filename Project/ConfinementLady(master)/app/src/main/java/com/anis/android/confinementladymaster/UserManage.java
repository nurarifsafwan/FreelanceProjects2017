package com.anis.android.confinementladymaster;

import android.app.ProgressDialog;
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

public class UserManage extends AppCompatActivity implements View.OnClickListener {

    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_manage);

        final EditText userId = (EditText) findViewById(R.id.etUserId);
        final EditText userPhone = (EditText) findViewById(R.id.etUserPhoneNumber);
        final EditText userAddress = (EditText) findViewById(R.id.etUserAddress);

        final Button userUpdate = (Button) findViewById(R.id.btnUserManage);

        Intent intent = getIntent();
        int iduser = intent.getIntExtra("iduser", + 1);
        String phone = intent.getStringExtra("phone");
        String address = intent.getStringExtra("address");

        userId.setText(iduser + "");
        userId.setEnabled(false);
        userId.setFocusable(false);

        userPhone.setText(phone);
        userAddress.setText(address);

        userUpdate.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        final EditText userId = (EditText) findViewById(R.id.etUserId);
        final EditText userPhone = (EditText) findViewById(R.id.etUserPhoneNumber);
        final EditText userAddress = (EditText) findViewById(R.id.etUserAddress);

        HashMap postData = new HashMap();
        postData.put("iduser", userId.getText().toString());
        postData.put("phone", userPhone.getText().toString());
        postData.put("address", userAddress.getText().toString());
        postData.put("mobile", "android");

        PostResponseAsyncTask taskUpdate = new PostResponseAsyncTask(UserManage.this, postData, new AsyncResponse() {
            @Override
            public void processFinish(String s) {
                if(s.contains("success")){
                    Toast.makeText(UserManage.this, "Successfully UpdatedM Credentials!", Toast.LENGTH_LONG).show();
                }
            }
        });
        taskUpdate.execute("http://10.0.2.2/confinement/updateuser.php");
    }
}
