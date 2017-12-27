package com.anis.android.confinementladymaster;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
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

public class UserBrowse extends AppCompatActivity implements AsyncResponse, AdapterView.OnItemClickListener {

    private ArrayList<Product> userList;
    private ListView lvPackage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_browse);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        PostResponseAsyncTask taskRead = new PostResponseAsyncTask(UserBrowse.this, this);

        taskRead.execute("http://10.0.2.2/confinement/Package.php");

    }

    @Override
    public void processFinish(String s) {
        userList = new JsonConverter<Product>().toArrayList(s, Product.class);

        BindDictionary<Product> dict = new BindDictionary<Product>();
        dict.addStringField(R.id.tvPackageName, new StringExtractor<Product>() {
            @Override
            public String getStringValue(Product product, int position) {
                return product.name;
            }
        });

        dict.addStringField(R.id.tvPackageDesc, new StringExtractor<Product>() {
            @Override
            public String getStringValue(Product product, int position) {
                return product.description;
            }
        });

        dict.addStringField(R.id.tvRegion, new StringExtractor<Product>() {
            @Override
            public String getStringValue(Product product, int position) {
                return product.region;
            }
        });

        dict.addStringField(R.id.tvPhone, new StringExtractor<Product>() {
            @Override
            public String getStringValue(Product product, int position) {
                return product.phone;
            }
        });

        dict.addStringField(R.id.tvLadyId, new StringExtractor<Product>() {
            @Override
            public String getStringValue(Product product, int position) {
                return "" + product.idlady;
            }
        });

        FunDapter<Product> adapter = new FunDapter<>(UserBrowse.this, userList, R.layout.layout_list, dict);

        lvPackage = (ListView) findViewById(R.id.lvPackage);
        lvPackage.setAdapter(adapter);
        lvPackage.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Product selectedProduct = userList.get(position);
        Intent in = new Intent (UserBrowse.this, UserPackageDetail.class);
        in.putExtra("product", (Serializable) selectedProduct);
        startActivity(in);
    }
}
