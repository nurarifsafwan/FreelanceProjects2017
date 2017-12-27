package com.anis.android.confinementladymaster;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class UserClasses extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_classes);

        final TextView tvLinkDelete = (TextView) findViewById(R.id.textView42);
        final TextView tvLinkDelete2 = (TextView) findViewById(R.id.textView43);

        tvLinkDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentDelete = new Intent(UserClasses.this, UserDeletePackage.class);
                UserClasses.this.startActivity(intentDelete);
            }
        });

        tvLinkDelete2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentDelete = new Intent(UserClasses.this, UserDeletePackage.class);
                UserClasses.this.startActivity(intentDelete);
            }
        });
    }
}
