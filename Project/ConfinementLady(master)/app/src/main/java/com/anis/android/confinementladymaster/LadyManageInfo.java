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

public class LadyManageInfo extends AppCompatActivity implements View.OnClickListener {

    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lady_manage_info);

        final EditText ladyId = (EditText) findViewById(R.id.etLadyId);
        final EditText ladyPhone = (EditText) findViewById(R.id.etLadyPhoneNumber);
        final EditText ladyAddress = (EditText) findViewById(R.id.etLadyAddress);

        final Button ladyUpdate = (Button) findViewById(R.id.btnLadyManage);

        Intent intent = getIntent();
        int idlady = intent.getIntExtra("idlady", + 1);
        String phone = intent.getStringExtra("phone");
        String address = intent.getStringExtra("address");

        ladyId.setText(idlady + "");
        ladyId.setEnabled(false);
        ladyId.setFocusable(false);

        ladyPhone.setText(phone);
        ladyAddress.setText(address);

        ladyUpdate.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        final EditText ladyId = (EditText) findViewById(R.id.etLadyId);
        final EditText ladyPhone = (EditText) findViewById(R.id.etLadyPhoneNumber);
        final EditText ladyAddress = (EditText) findViewById(R.id.etLadyAddress);

        HashMap postData = new HashMap();
        postData.put("idlady", ladyId.getText().toString());
        postData.put("phone", ladyPhone.getText().toString());
        postData.put("address", ladyAddress.getText().toString());
        postData.put("mobile", "android");

        PostResponseAsyncTask taskUpdate = new PostResponseAsyncTask(LadyManageInfo.this, postData, new AsyncResponse() {
            @Override
            public void processFinish(String s) {
                if(s.contains("success")){
                    Toast.makeText(LadyManageInfo.this, "Successfully Updated Credentials!", Toast.LENGTH_LONG).show();
                }
            }
        });
        taskUpdate.execute("http://10.0.2.2/confinement/updatelady.php");
    }
}
