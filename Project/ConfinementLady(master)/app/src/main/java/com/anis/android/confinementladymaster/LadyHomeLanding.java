package com.anis.android.confinementladymaster;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LadyHomeLanding extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lady_home_landing);

        final TextView ladyWelcome = (TextView) findViewById(R.id.tvLadyWelcome);

        final EditText ladyId = (EditText) findViewById(R.id.etLadyId);
        final EditText ladyName = (EditText) findViewById(R.id.etLadyName);
        final EditText ladyPhone = (EditText) findViewById(R.id.etLadyPhone);
        final EditText ladyAddress = (EditText) findViewById(R.id.etLadyAddress);

        final Button ladyManage = (Button) findViewById(R.id.btnLadyManage);
        final Button ladyAddPackage = (Button) findViewById(R.id.btnLadyAddPackage);
        final Button ladyOrders = (Button) findViewById(R.id.btnLadyOrders);

        Intent intent = getIntent();
        int idlady = intent.getIntExtra("idlady", -1);
        String username = intent.getStringExtra("username");
        String name = intent.getStringExtra("name");
        String phone = intent.getStringExtra("phone");
        String address = intent.getStringExtra("address");

        ladyWelcome.setText(username + "! Welcome.");
        ladyId.setText(idlady + "");
        ladyId.setEnabled(false);
        ladyId.setFocusable(false);

        ladyName.setText(name);
        ladyName.setEnabled(false);
        ladyName.setFocusable(false);

        ladyPhone.setText(phone);
        ladyPhone.setEnabled(false);
        ladyPhone.setFocusable(false);

        ladyAddress.setText(address);
        ladyAddress.setEnabled(false);
        ladyAddress.setFocusable(false);

        ladyManage.setOnClickListener(this);
        ladyAddPackage.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.btnLadyManage) {

            final EditText homeLadyId = (EditText) findViewById(R.id.etLadyId);
            final EditText homeLadyPhone = (EditText) findViewById(R.id.etLadyPhone);
            final EditText homeLadyAddress = (EditText) findViewById(R.id.etLadyAddress);

            final String idLady = homeLadyId.getText().toString();
            final String ladyPhone = homeLadyPhone.getText().toString();
            final String ladyAddress = homeLadyAddress.getText().toString();

            Intent manageStudentIntent = new Intent(LadyHomeLanding.this, LadyManageInfo.class);
            manageStudentIntent.putExtra("idlady", idLady);
            manageStudentIntent.putExtra("phome", ladyPhone);
            manageStudentIntent.putExtra("address", ladyAddress);
            LadyHomeLanding.this.startActivity(manageStudentIntent);

        }else if(v.getId() == R.id.btnLadyAddPackage) {

            final EditText addLadyId = (EditText) findViewById(R.id.etLadyId);
            final EditText addLadyPhone = (EditText) findViewById(R.id.etLadyPhone);

            final String ladyId = addLadyId.getText().toString();
            final String ladyPhone = addLadyPhone.getText().toString();

            Intent addClassIntent = new Intent(LadyHomeLanding.this, LadyInsertPackage.class);
            addClassIntent.putExtra("idlady", ladyId);
            addClassIntent.putExtra("phone", ladyPhone);
            LadyHomeLanding.this.startActivity(addClassIntent);

        }
    }
}
