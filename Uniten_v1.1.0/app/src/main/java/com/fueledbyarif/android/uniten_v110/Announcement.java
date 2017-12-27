package com.fueledbyarif.android.uniten_v110;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.amigold.fundapter.BindDictionary;
import com.amigold.fundapter.FunDapter;
import com.amigold.fundapter.extractors.StringExtractor;
import com.kosalgeek.android.json.JsonConverter;
import com.kosalgeek.genasync12.AsyncResponse;
import com.kosalgeek.genasync12.PostResponseAsyncTask;

import java.util.ArrayList;

public class Announcement extends AppCompatActivity implements AsyncResponse {

    private ArrayList<Announce> announceList;
    private ListView lvAnnounce;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_announcement);

        PostResponseAsyncTask taskRead = new PostResponseAsyncTask(Announcement.this, this);

        taskRead.execute("http://10.0.2.2/unitendb/Announce.php");
    }

    @Override
    public void processFinish(String s) {
        announceList = new JsonConverter<Announce>().toArrayList(s, Announce.class);

        BindDictionary<Announce> dict = new BindDictionary<Announce>();
        dict.addStringField(R.id.tvTitle, new StringExtractor<Announce>() {
            @Override
            public String getStringValue(Announce announce, int position) {
                return announce.title;
            }
        });

        dict.addStringField(R.id.tvDesc, new StringExtractor<Announce>() {
            @Override
            public String getStringValue(Announce announce, int position) {
                return announce.description;
            }
        });

        FunDapter<Announce> adapter = new FunDapter<>(Announcement.this, announceList, R.layout.layout_list, dict);

        lvAnnounce = (ListView) findViewById(R.id.lvAnnounce);
        lvAnnounce.setAdapter(adapter);
    }
}
