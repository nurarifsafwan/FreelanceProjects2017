package com.fueledbyarif.android.chilis_v104;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

public class DetailsActivity extends AppCompatActivity {

    TextView tvName, tvPrice, tvDescription, etImage;
    ImageView ivImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        //getIntent().getSerializableExtra("menu");

        ImageLoader.getInstance().init(UILConfig.config(DetailsActivity.this));

        Menu menu = (Menu) getIntent().getSerializableExtra("menu");

//        etName = (EditText)findViewById(R.id.etName);
//        etPrice = (EditText)findViewById(R.id.etPrice);
//        etDescription = (EditText)findViewById(R.id.etDescription);

        tvName = (TextView)findViewById(R.id.tvName);
        tvPrice = (TextView)findViewById(R.id.tvPrice);
        tvDescription = (TextView)findViewById(R.id.tvDescription);

        ivImage = (ImageView)findViewById(R.id.ivImage);

        if(menu != null){
            tvName.setText(menu.name);
            tvPrice.setText( "RM " + menu.price);
            tvDescription.setText(menu.description);

            ImageLoader.getInstance().displayImage(menu.image_url, ivImage);
        }


    }
}
