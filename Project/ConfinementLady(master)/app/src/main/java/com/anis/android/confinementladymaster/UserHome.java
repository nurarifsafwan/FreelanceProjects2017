package com.anis.android.confinementladymaster;

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

public class UserHome extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        final TextView userWelcome = (TextView) findViewById(R.id.tvUserWelcome);

        final EditText userId = (EditText) findViewById(R.id.etUserId);
        final EditText userName = (EditText) findViewById(R.id.etUserName);
        final EditText userPhone = (EditText) findViewById(R.id.etUserPhone);
        final EditText userAddress = (EditText) findViewById(R.id.etUserAddress);

        Intent intent = getIntent();
        int idstudent = intent.getIntExtra("iduser", -1);
        String username = intent.getStringExtra("username");
        String name = intent.getStringExtra("name");
        String phone = intent.getStringExtra("phone");
        String address = intent.getStringExtra("address");

        userWelcome.setText(username + "! Welcome.");
        userId.setText(idstudent + "");
        userId.setEnabled(false);
        userId.setFocusable(false);

        userName.setText(name);
        userName.setEnabled(false);
        userName.setFocusable(false);

        userPhone.setText(phone);
        userPhone.setEnabled(false);
        userPhone.setFocusable(false);

        userAddress.setText(address);
        userAddress.setEnabled(false);
        userAddress.setFocusable(false);

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
        getMenuInflater().inflate(R.menu.user_home, menu);
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

            Intent intentAbout = new Intent (UserHome.this, About.class);
            startActivity(intentAbout);

        }

        else if(id == R.id.action_signout){

            Intent intentSignout = new Intent (UserHome.this, UserLogin.class);
            startActivity(intentSignout);
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.nav_browse) {

            Intent intentBrowse = new Intent(UserHome.this, UserBrowse.class);
            startActivity(intentBrowse);

        } else if (id == R.id.nav_orders) {

            Intent intentOrders = new Intent(UserHome.this, UserClasses.class);
            startActivity(intentOrders);

        } else if (id == R.id.nav_profile) {
            final EditText homeUserId = (EditText) findViewById(R.id.etUserId);
            final EditText homeUserPhone = (EditText) findViewById(R.id.etUserPhone);
            final EditText homeUserAddress = (EditText) findViewById(R.id.etUserAddress);

            final String userId = homeUserId.getText().toString();
            final String userPhone = homeUserPhone.getText().toString();
            final String userAddress = homeUserAddress.getText().toString();

            Intent manageStudentIntent = new Intent(UserHome.this, UserManage.class);
            manageStudentIntent.putExtra("iduser", userId);
            manageStudentIntent.putExtra("phone", userPhone);
            manageStudentIntent.putExtra("address", userAddress);
            UserHome.this.startActivity(manageStudentIntent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
