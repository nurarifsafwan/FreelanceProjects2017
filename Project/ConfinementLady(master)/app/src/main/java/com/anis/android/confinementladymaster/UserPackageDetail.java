package com.anis.android.confinementladymaster;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
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

public class UserPackageDetail extends AppCompatActivity implements View.OnClickListener {

    TextView tvName, tvDesc, tvRegion, tvLadyPhone, tvLadyId;
    EditText userId;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_package_detail);

        Product product = (Product) getIntent().getSerializableExtra("product");

        tvName = (TextView) findViewById(R.id.tvDetailPackageName);
        tvDesc = (TextView) findViewById(R.id.tvDetailPackageDesc);
        tvRegion = (TextView) findViewById(R.id.tvDetailPackageRegion);
        tvLadyPhone = (TextView) findViewById(R.id.tvDetailPackagePhone);
        tvLadyId = (TextView) findViewById(R.id.tvDetailPackageLadyId);

        final Button addOrder = (Button) findViewById(R.id.btnOrder);

        userId = (EditText) findViewById(R.id.etUserId);

        if (product != null) {
            tvName.setText(product.name);
            tvDesc.setText(product.description);
            tvRegion.setText(product.region);
            tvLadyPhone.setText(product.phone);
            tvLadyId.setText("" + product.idlady);
        }

        tvLadyPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:" + tvLadyPhone.getText().toString().trim()));
                if (ActivityCompat.checkSelfPermission(UserPackageDetail.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(callIntent);
            }
        });

        addOrder.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        final TextView useraddName = (TextView) findViewById(R.id.tvDetailPackageName);
        final TextView useraddDesc = (TextView) findViewById(R.id.tvDetailPackageDesc);
        final TextView useraddRegion = (TextView) findViewById(R.id.tvDetailPackageRegion);
        final TextView useraddPhone = (TextView) findViewById(R.id.tvDetailPackagePhone);
        final TextView useraddLadyId = (TextView) findViewById(R.id.tvDetailPackageLadyId);

        final EditText userId = (EditText) findViewById(R.id.etUserId);

        final String newName = useraddName.getText().toString();
        final String newDesc = useraddDesc.getText().toString();
        final String newRegion = useraddRegion.getText().toString();
        final String newPhone = useraddPhone.getText().toString();
        final int newLadyId = Integer.parseInt(useraddLadyId.getText().toString());
        final int newUserId = Integer.parseInt(userId.getText().toString());

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");

                    if(success){
                        Toast.makeText(UserPackageDetail.this, "Package Has Been Ordered!", Toast.LENGTH_SHORT).show();
                    }

                } catch (JSONException e) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(UserPackageDetail.this);
                    builder.setMessage("Order Failed").setNegativeButton("Retry", null)
                            .create().show();
                }

            }
        };

        UserInsertRequest userInsertRequest = new UserInsertRequest(newName, newDesc, newRegion, newLadyId, newUserId, newPhone, responseListener);
        RequestQueue queue = Volley.newRequestQueue(UserPackageDetail.this);
        queue.add(userInsertRequest);

    }
}
