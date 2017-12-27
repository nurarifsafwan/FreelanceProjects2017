package com.fueledbyarif.android.uniten_v110;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Ledger extends AppCompatActivity {

    //final TextView tvLedger = (TextView) findViewById(R.id.tvLedger);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ledger);

        //Intent intent = getIntent();
        //String ledger_balance = intent.getStringExtra("ledger_balance");

        //tvLedger.setText(ledger_balance);
    }
}
