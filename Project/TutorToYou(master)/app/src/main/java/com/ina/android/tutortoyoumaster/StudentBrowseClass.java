package com.ina.android.tutortoyoumaster;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.amigold.fundapter.BindDictionary;
import com.amigold.fundapter.FunDapter;
import com.amigold.fundapter.extractors.StringExtractor;
import com.kosalgeek.android.json.JsonConverter;
import com.kosalgeek.genasync12.AsyncResponse;
import com.kosalgeek.genasync12.PostResponseAsyncTask;

import java.io.Serializable;
import java.util.ArrayList;

public class StudentBrowseClass extends AppCompatActivity implements AsyncResponse, AdapterView.OnItemClickListener {

    private ArrayList<EnrollClass> enrollList;
    private ListView lvEnrollClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_browse_class);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        PostResponseAsyncTask taskRead = new PostResponseAsyncTask(StudentBrowseClass.this, this);

        taskRead.execute("http://10.0.2.2/tutortoyou/Class.php");

    }

    @Override
    public void processFinish(String s) {

        enrollList = new JsonConverter<EnrollClass>().toArrayList(s, EnrollClass.class);

        BindDictionary<EnrollClass> dict = new BindDictionary<EnrollClass>();

        dict.addStringField(R.id.tvClassName, new StringExtractor<EnrollClass>() {
            @Override
            public String getStringValue(EnrollClass enrollclass, int position) {
                return enrollclass.name;
            }
        });

        dict.addStringField(R.id.tvClassDesc, new StringExtractor<EnrollClass>() {
            @Override
            public String getStringValue(EnrollClass enrollclass, int position) {
                return enrollclass.description;
            }
        });

        dict.addStringField(R.id.tvTutorId, new StringExtractor<EnrollClass>() {
            @Override
            public String getStringValue(EnrollClass enrollclass, int position) {
                return "" + enrollclass.idtutor;
            }
        });

        dict.addStringField(R.id.tvLayout1, new StringExtractor<EnrollClass>() {
            @Override
            public String getStringValue(EnrollClass enrollclass, int position) {
                return enrollclass.region;
            }
        });

        dict.addStringField(R.id.tvClassPhone, new StringExtractor<EnrollClass>() {
            @Override
            public String getStringValue(EnrollClass enrollclass, int position) {
                return enrollclass.phone;
            }
        });

        FunDapter<EnrollClass> adapter = new FunDapter<>(StudentBrowseClass.this, enrollList, R.layout.layout_list, dict);
        lvEnrollClass = (ListView) findViewById(R.id.lvEnrollClass);
        lvEnrollClass.setAdapter(adapter);
        lvEnrollClass.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        EnrollClass selectedEnrollClass = enrollList.get(position);
        Intent in = new Intent(StudentBrowseClass.this, StudentEnroll.class);
        in.putExtra("enrollclass", selectedEnrollClass);
        startActivity(in);
    }
}
