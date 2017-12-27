package com.ina.android.tutortoyoumaster;

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

public class TutorInsertClass extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutor_insert_class);

        final EditText addTutorClass = (EditText) findViewById(R.id.etAddClassName);
        final EditText addTutorDesc = (EditText) findViewById(R.id.etAddClassDesc);
        final EditText addTutorRegion = (EditText) findViewById(R.id.etAddClassRegion);

        final EditText addTutorId = (EditText) findViewById(R.id.etTutorId);
        final EditText addTutorPhone = (EditText) findViewById(R.id.etTutorPhone);

        final Button tutorAddClass = (Button) findViewById(R.id.btnAddClass);

        Intent intent = getIntent();
        int idtutor = intent.getIntExtra("idtutor", + 1);
        String phone = intent.getStringExtra("phone");

        addTutorId.setText(idtutor + "");
        addTutorId.setEnabled(false);
        addTutorId.setFocusable(false);

        addTutorPhone.setText(phone);
        addTutorPhone.setEnabled(false);
        addTutorPhone.setFocusable(false);

        //addTutorClass.setFocusable(false);
        //addTutorDesc.setFocusable(false);
        //addTutorRegion.setFocusable(false);

        tutorAddClass.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        final EditText tutorAddClass = (EditText) findViewById(R.id.etAddClassName);
        final EditText tutorAddDesc = (EditText) findViewById(R.id.etAddClassDesc);
        final EditText tutorAddRegion = (EditText) findViewById(R.id.etAddClassRegion);
        final EditText tutorAddId = (EditText) findViewById(R.id.etTutorId);
        final EditText tutorAddPhone = (EditText) findViewById(R.id.etTutorPhone);

        final String newClass = tutorAddClass.getText().toString();
        final String newDesc = tutorAddDesc.getText().toString();
        final String newRegion = tutorAddRegion.getText().toString();
        final int tutorId = Integer.parseInt(tutorAddId.getText().toString());
        final String tutorPhone = tutorAddPhone.getText().toString();

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");

                    if(success){
                        Toast.makeText(TutorInsertClass.this, "Class has been inserted", Toast.LENGTH_SHORT).show();
                    }

                } catch (JSONException e) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(TutorInsertClass.this);
                    builder.setMessage("Insertion Failed").setNegativeButton("Retry", null)
                            .create().show();
                }

            }
        };

        InsertClass insertClass = new InsertClass(newClass, newDesc, tutorId, newRegion, tutorPhone, responseListener);
        RequestQueue queue = Volley.newRequestQueue(TutorInsertClass.this);
        queue.add(insertClass);

    }
}
