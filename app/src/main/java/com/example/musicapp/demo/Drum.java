package com.example.musicapp.demo;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.HashMap;


public class Drum extends AppCompatActivity {

    private PullToZoomListViewEx listView;
    private ImageButton music_play;
    private ImageButton music_add;
    private DatabaseHelper mOpenHelper;
    private SQLiteDatabase db;
    private Cursor cur;
    public static final String TABLE_NAME_DRUM="drum";
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pull_to_zoom_list_view_drum);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        listView = (PullToZoomListViewEx) findViewById(R.id.listview);
        music_play = (ImageButton) findViewById(R.id.img_play);
        music_add = (ImageButton) findViewById(R.id.img_add);
        mOpenHelper = new DatabaseHelper(getApplicationContext());
        //SQLiteDatabase db = mOpenHelper.getWritableDatabase();
        db = mOpenHelper.getReadableDatabase();
        db.delete("drum", "1", null);
        db=mOpenHelper.getWritableDatabase();
        save();
        final ArrayList<String> drumname = new ArrayList<String>();
        final ArrayList<String> no = new ArrayList<String>();
        db=mOpenHelper.getReadableDatabase();

        final Cursor c=db.rawQuery("SELECT * FROM "+ TABLE_NAME_DRUM,null);
        c.moveToFirst();
        for(int i=0;i<c.getCount();i++){
            no.add(c.getString(0));
            drumname.add(c.getString(1));
            c.moveToNext();

        }
        ArrayList<HashMap<String,Object>> list = new ArrayList<HashMap<String,Object>>();
        c.moveToFirst();
        for(int i=0;i<c.getCount();i++){
            HashMap<String,Object> item = new HashMap<String,Object>();
            item.put("no", no.get(i));
            item.put( "name", drumname.get(i));
            //item.put("path", "   "+c.getInt(2) );
            item.put("picture_play", R.drawable.picture_play);
            item.put("picture_add", R.drawable.picture_add);
            list.add(item);

        }
        listView.setAdapter(new lvButtonAdapter(this,list, android.R.layout.simple_list_item_1,  new String[]{"picture_play", "no", "name", "picture_add"}, new int[]{R.id.img_play, R.id.textView1, R.id.textView2, R.id.img_add},"drum"));
        listView.getPullRootView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.e("zhuwenwu", "position = " + position);
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.e("zhuwenwu", "position = " + position);
            }
        });

        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
        int mScreenHeight = localDisplayMetrics.heightPixels;
        int mScreenWidth = localDisplayMetrics.widthPixels;
        AbsListView.LayoutParams localObject = new AbsListView.LayoutParams(mScreenWidth, (int) (9.0F * (mScreenWidth / 16.0F)));
        listView.setHeaderLayoutParams(localObject);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    private void save() {
        SaveOneSong(db,"Baisic_Four_On_The_Floor",R.raw.baisic_four_on_the_floor);
        SaveOneSong(db, "bohopn7", R.raw.bohopn7);
        SaveOneSong(db, "bolopn7", R.raw.bolopn7);
        SaveOneSong(db, "cbm1lg4", R.raw.cbm1lg4);
        SaveOneSong(db, "clap_808", R.raw.clap_808);
        SaveOneSong(db, "clv074", R.raw.clv074);
        SaveOneSong(db, "conopn7", R.raw.conopn7);
        SaveOneSong(db, "consim4", R.raw.consim4);
        SaveOneSong(db, "cow6sh3", R.raw.cow6sh3);
        SaveOneSong(db, "cowbell_808", R.raw.cowbell_808);
        SaveOneSong(db, "crash_808", R.raw.crash_808);
        SaveOneSong(db, "crash_noise", R.raw.crash_noise);
        SaveOneSong(db, "crash_tape", R.raw.crash_tape);
        SaveOneSong(db, "Drumbeat", R.raw.drumbeat);
        SaveOneSong(db, "Drumbeat_3", R.raw.drumbeat_3);


        SaveOneSong(db, "EL_Dark_BD", R.raw.el_dark_bd);
        SaveOneSong(db, "EL_Dark_SD", R.raw.el_dark_sd);
        SaveOneSong(db, "ElectroClap_D", R.raw.electroclap_d);
        SaveOneSong(db, "electrohhopen_a", R.raw.electrohhopen_a);
        SaveOneSong(db, "electroride_d", R.raw.electroride_d);
        SaveOneSong(db, "Fs_musical_1", R.raw.fs_musical_1);
        SaveOneSong(db, "hihat_digital", R.raw.hihat_digital);
        SaveOneSong(db, "hihat_dist01", R.raw.hihat_dist01);
        SaveOneSong(db, "hihat_dist02", R.raw.hihat_dist02);
        SaveOneSong(db, "hihat_electro", R.raw.hihat_electro);
        SaveOneSong(db, "hihat_plain", R.raw.hihat_plain);
        SaveOneSong(db, "hihat_reso", R.raw.hihat_reso);
        SaveOneSong(db, "Rock", R.raw.rock);
        SaveOneSong(db, "tam1ht5", R.raw.tam1ht5);
        SaveOneSong(db, "Rock", R.raw.rock);
        SaveOneSong(db, "tihopn7", R.raw.tihopn7);
        SaveOneSong(db, "tam1ht5", R.raw.tilopn6);
        SaveOneSong(db, "tihopn7", R.raw.tubopn6);
        SaveOneSong(db, "vb1ce21", R.raw.vb1ce21);

    }
    public void SaveOneSong(SQLiteDatabase db, String key, int rid){
        ContentValues cv = new ContentValues();
        cv.put("name", key);
        cv.put("path",rid);
        db=mOpenHelper.getWritableDatabase();
        db.insert("drum", null, cv);
    }

}