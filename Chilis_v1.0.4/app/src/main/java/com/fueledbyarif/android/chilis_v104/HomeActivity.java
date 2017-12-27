package com.fueledbyarif.android.chilis_v104;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Response;

import org.w3c.dom.Text;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        final EditText etUsername = (EditText) findViewById(R.id.etUsername);
        final EditText etName = (EditText) findViewById(R.id.etName);
        final EditText etEmail = (EditText) findViewById(R.id.etEmail);
        final EditText etPhone = (EditText) findViewById(R.id.etPhone);
        final TextView welcomeMessage = (TextView) findViewById(R.id.tvWelcome);

        final Button bMenu = (Button) findViewById(R.id.bMenu);
        final Button bReservation = (Button) findViewById(R.id.bReservation);

        bMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent menuIntent = new Intent(HomeActivity.this, ListActivity.class);
                HomeActivity.this.startActivity(menuIntent);
            }
        });

        bReservation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent reserveIntent = new Intent(HomeActivity.this, ReservationActivity.class);
                HomeActivity.this.startActivity(reserveIntent);
            }
        });

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String username = intent.getStringExtra("username");
        String email = intent.getStringExtra("email");
        String phonenumber = intent.getStringExtra("phonenumber");

        String message = "Hello " + name + "!" + ", Welcome to Chilis";
        welcomeMessage.setText(message);
        etUsername.setText(username);
        etEmail.setText(email);
        etPhone.setText(phonenumber);

    }
}
