package com.ina.android.tutortoyoumaster;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

public class StudentEnroll extends AppCompatActivity implements View.OnClickListener {

    TextView tvClassName, tvClassDesc, tvPhoneNumber, tvRegionClass, tvTutorId;
    EditText etStudentId;
    Button btnEnroll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_enroll);

        EnrollClass enrollClass = (EnrollClass) getIntent().getSerializableExtra("enrollclass");

        tvClassName = (TextView) findViewById(R.id.tvClassName);
        tvClassDesc = (TextView) findViewById(R.id.tvClassDesc);
        tvPhoneNumber = (TextView) findViewById(R.id.tvPhoneNumber);
        tvRegionClass = (TextView) findViewById(R.id.tvRegionCLass);
        tvTutorId = (TextView) findViewById(R.id.tvTutorId);

        etStudentId = (EditText) findViewById(R.id.etStudentId);

        btnEnroll = (Button) findViewById(R.id.btnEnrollClass);

        if(enrollClass != null){
            tvClassName.setText(enrollClass.name);
            tvClassDesc.setText(enrollClass.description);
            tvPhoneNumber.setText(enrollClass.phone);
            tvTutorId.setText(""+ enrollClass.idtutor);
            tvRegionClass.setText(enrollClass.region);
        }

        btnEnroll.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        final TextView newClass = (TextView) findViewById(R.id.tvClassName);
        final TextView newDesc = (TextView) findViewById(R.id.tvClassDesc);
        final TextView newPhone = (TextView) findViewById(R.id.tvPhoneNumber);
        final TextView newRegion = (TextView) findViewById(R.id.tvRegionCLass);
        final TextView newTutorId = (TextView) findViewById(R.id.tvTutorId);

        final EditText newStudentId = (EditText) findViewById(R.id.etStudentId);

        final String addClassName = newClass.getText().toString();
        final String addClassDesc = newDesc.getText().toString();
        final String addClassPhone = newPhone.getText().toString();
        final String addClassRegion = newRegion.getText().toString();
        final int addNewTutor = Integer.parseInt(newTutorId.getText().toString());
        final int addNewStudent = Integer.parseInt(newStudentId.getText().toString());

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");

                    if(success){
                        Toast.makeText(StudentEnroll.this, "Enrollment Successful!", Toast.LENGTH_SHORT).show();
                    }

                } catch (JSONException e) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(StudentEnroll.this);
                    builder.setMessage("Enrollment Failed").setNegativeButton("Retry", null)
                            .create().show();
                }

            }
        };

        StudentInsertClass studentInsertClass = new StudentInsertClass(addClassName, addClassDesc, addClassPhone, addClassRegion, addNewTutor, addNewStudent, responseListener);
        RequestQueue queue = Volley.newRequestQueue(StudentEnroll.this);
        queue.add(studentInsertClass);

    }
}
