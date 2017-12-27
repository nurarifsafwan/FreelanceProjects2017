package com.fueledbyarif.android.chilis_v104;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.amigold.fundapter.BindDictionary;
import com.amigold.fundapter.FunDapter;
import com.amigold.fundapter.extractors.StringExtractor;
import com.amigold.fundapter.interfaces.DynamicImageLoader;
import com.kosalgeek.android.json.JsonConverter;
import com.kosalgeek.genasync12.AsyncResponse;
import com.kosalgeek.genasync12.PostResponseAsyncTask;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity implements AsyncResponse, AdapterView.OnItemClickListener {

    private ArrayList<Menu> menuList;
    private ListView lvMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ImageLoader.getInstance().init(UILConfig.config(ListActivity.this));

        PostResponseAsyncTask taskRead = new PostResponseAsyncTask(ListActivity.this, this);

        taskRead.execute("http://10.0.2.2/customer/Menu.php");
    }

    @Override
    public void processFinish(String s) {
        menuList = new JsonConverter<Menu>().toArrayList(s, Menu.class);

        BindDictionary<Menu> dict = new BindDictionary<Menu>();
        dict.addStringField(R.id.tvName, new StringExtractor<Menu>() {
            @Override
            public String getStringValue(Menu menu, int position) {
                return menu.name;
            }
        });

        dict.addDynamicImageField(R.id.ivImage, new StringExtractor<Menu>() {
            @Override
            public String getStringValue(Menu menu, int position) {
                return menu.image_url;
            }
        }, new DynamicImageLoader() {
            @Override
            public void loadImage(String url, ImageView imageView) {
//                Picasso.with(ListActivity.this)
//                        .load(url)
//                        .placeholder(android.R.drawable.star_big_on)
 //                       .error(android.R.drawable.stat_sys_download)
//                        .into(imageView);

                ImageLoader.getInstance().displayImage(url, imageView);
            }
        });

        FunDapter<Menu> adapter = new FunDapter<>(ListActivity.this, menuList, R.layout.layout_list, dict);

        lvMenu = (ListView) findViewById(R.id.lvMenu);
        lvMenu.setAdapter(adapter);
        lvMenu.setOnItemClickListener(this);


    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Menu selectedMenu = menuList.get(i);
        Intent in = new Intent(ListActivity.this, DetailsActivity.class);
        in.putExtra("menu", (Serializable) selectedMenu);
        startActivity(in);
    }
}
