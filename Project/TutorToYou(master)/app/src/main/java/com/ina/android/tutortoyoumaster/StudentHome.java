package com.ina.android.tutortoyoumaster;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class StudentHome extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        final TextView tvWelcome = (TextView) findViewById(R.id.tvWelcome);

        final EditText StudentId = (EditText) findViewById(R.id.etStudentId);
        final EditText StudentName = (EditText) findViewById(R.id.etStudentName);
        final EditText StudentEmail = (EditText) findViewById(R.id.etStudentEmail);
        final EditText StudentPhone = (EditText) findViewById(R.id.etStudentPhone);

        Intent intent = getIntent();
        int idstudent = intent.getIntExtra("idstudent", -1);
        String username = intent.getStringExtra("username");
        String name = intent.getStringExtra("name");
        String email = intent.getStringExtra("email");
        String phone = intent.getStringExtra("phone");

        tvWelcome.setText(username + "! Welcome.");
        StudentId.setText(idstudent + "");
        StudentId.setEnabled(false);
        StudentId.setFocusable(false);

        StudentName.setText(name);
        StudentName.setEnabled(false);
        StudentName.setFocusable(false);

        StudentEmail.setText(email);
        StudentEmail.setEnabled(false);
        StudentEmail.setFocusable(false);

        StudentPhone.setText(phone);
        StudentPhone.setEnabled(false);
        StudentPhone.setFocusable(false);



    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.student_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            Intent intentAboutApp = new Intent(StudentHome.this, AboutApp.class);
            StudentHome.this.startActivity(intentAboutApp);

        }else if (id == R.id.sign_out){
            Intent intentSignOut = new Intent(StudentHome.this, StudentLogin.class);
            StudentHome.this.startActivity(intentSignOut);
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_browse) {

            Intent intent = new Intent(StudentHome.this, StudentBrowseClass.class);
            StudentHome.this.startActivity(intent);

        } else if (id == R.id.nav_classes) {

        } else if (id == R.id.nav_profile) {

            final EditText homeStudentId = (EditText) findViewById(R.id.etStudentId);
            final EditText homeStudentEmail = (EditText) findViewById(R.id.etStudentEmail);
            final EditText homeStudentPhone = (EditText) findViewById(R.id.etStudentPhone);

            final String studentId = homeStudentId.getText().toString();
            final String studentEmail = homeStudentEmail.getText().toString();
            final String studentPhone = homeStudentPhone.getText().toString();

            Intent manageStudentIntent = new Intent(StudentHome.this, StudentManageCred.class);
            manageStudentIntent.putExtra("studentid", studentId);
            manageStudentIntent.putExtra("email", studentEmail);
            manageStudentIntent.putExtra("phone", studentPhone);
            StudentHome.this.startActivity(manageStudentIntent);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
