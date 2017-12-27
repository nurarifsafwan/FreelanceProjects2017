package com.anis.android.confinementladymaster;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class LadyInsertPackage extends AppCompatActivity implements View.OnClickListener {

    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lady_insert_package);

        final EditText packageName = (EditText) findViewById(R.id.etPackageName);
        final EditText packageDesc = (EditText) findViewById(R.id.etPackageDesc);
        final EditText packageRegion = (EditText) findViewById(R.id.etPackageRegion);

        final EditText ladyId = (EditText) findViewById(R.id.etLadyId);
        final EditText ladyPhone = (EditText) findViewById(R.id.etLadyPhoneNumber);

        final Button packageInsert = (Button) findViewById(R.id.btnInsertPackage);

        Intent intent = getIntent();
        int idlady = intent.getIntExtra("idlady", + 1);
        String phone = intent.getStringExtra("phone");

        ladyId.setText(idlady + "");
        ladyId.setEnabled(false);
        ladyId.setFocusable(false);

        ladyPhone.setText(phone);
        ladyPhone.setEnabled(false);
        ladyPhone.setFocusable(false);

        packageInsert.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        final EditText ladyAddPackage = (EditText) findViewById(R.id.etPackageName);
        final EditText ladyAddDesc = (EditText) findViewById(R.id.etPackageDesc);
        final EditText ladyAddRegion = (EditText) findViewById(R.id.etPackageRegion);
        final EditText ladyId = (EditText) findViewById(R.id.etLadyId);
        final EditText ladyPhone = (EditText) findViewById(R.id.etLadyPhoneNumber);

        final String newPackage = ladyAddPackage.getText().toString();
        final String newDesc = ladyAddDesc.getText().toString();
        final String newRegion = ladyAddRegion.getText().toString();
        final int idlady = Integer.parseInt(ladyId.getText().toString());
        final String idphone = ladyPhone.getText().toString();

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");

                    if(success){
                        Toast.makeText(LadyInsertPackage.this, "Class has been inserted", Toast.LENGTH_SHORT).show();
                    }

                } catch (JSONException e) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(LadyInsertPackage.this);
                    builder.setMessage("Insertion Failed").setNegativeButton("Retry", null)
                            .create().show();
                }

            }
        };

        LadyInsertRequest ladyInsertRequest = new LadyInsertRequest(newPackage, newDesc, idlady, newRegion, idphone, responseListener);
        RequestQueue queue = Volley.newRequestQueue(LadyInsertPackage.this);
        queue.add(ladyInsertRequest);

    }
}
