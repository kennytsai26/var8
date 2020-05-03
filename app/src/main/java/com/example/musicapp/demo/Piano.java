package com.example.musicapp.demo;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
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


public class Piano extends AppCompatActivity {

    private PullToZoomListViewEx listView;
    private ImageButton music_play;
    private ImageButton music_add;
    private DatabaseHelper mOpenHelper;
    private SQLiteDatabase db;
    private Cursor cur;
    private MediaPlayer mp;
    public static final String TABLE_NAME_PIANO="piano";
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pull_to_zoom_list_view_piano);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        listView = (PullToZoomListViewEx) findViewById(R.id.listview);
        music_play = (ImageButton) findViewById(R.id.img_play);
        music_add = (ImageButton) findViewById(R.id.img_add);

        mOpenHelper = new DatabaseHelper(getApplicationContext());
        db = mOpenHelper.getReadableDatabase();
        db.delete("piano", "1", null);
        db=mOpenHelper.getWritableDatabase();

        save();


        final ArrayList<String> pianoname = new ArrayList<String>();
        final ArrayList<String> no = new ArrayList<String>();
        db=mOpenHelper.getReadableDatabase();
        final Cursor c=db.rawQuery("SELECT * FROM "+ TABLE_NAME_PIANO,null);
        c.moveToFirst();
        for(int i=0;i<c.getCount();i++){
            no.add(c.getString(0));
            pianoname.add(c.getString(1));
            c.moveToNext();
        }
        ArrayList<HashMap<String,Object>> list = new ArrayList<HashMap<String,Object>>();
        c.moveToFirst();
        for(int i=0;i<c.getCount();i++){
            HashMap<String,Object> item = new HashMap<String,Object>();
            item.put("no", no.get(i));
            item.put( "name", pianoname.get(i));
            //item.put("path", "   "+c.getInt(2) );
            item.put("picture_play", R.drawable.picture_play);
            item.put("picture_add", R.drawable.picture_add);
            list.add(item);

        }

        listView.setAdapter(new lvButtonAdapter(this,list, android.R.layout.simple_list_item_1,  new String[]{"picture_play", "no", "name", "picture_add"}, new int[]{R.id.img_play, R.id.textView1, R.id.textView2, R.id.img_add},"piano"));
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
        SaveOneSong(db, "hat_both_ghost", R.raw.hat_both_ghost);
        SaveOneSong(db, "hat_both_multi", R.raw.hat_both_multi);
        SaveOneSong(db, "hat_both_toms", R.raw.hat_both_toms);
        SaveOneSong(db, "hat_both_toms_2", R.raw.hat_both_toms_2);
        SaveOneSong(db, "hat_both_toms_3", R.raw.hat_both_toms_3);
        SaveOneSong(db, "hat_both_toms_4", R.raw.hat_both_toms_4);
        SaveOneSong(db, "hat_closed_toms", R.raw.hat_closed_toms);
        SaveOneSong(db, "hat_closed_toms_2", R.raw.hat_closed_toms_2);
        SaveOneSong(db, "hat_closed_toms_3", R.raw.hat_closed_toms_3);
        SaveOneSong(db, "hat_open", R.raw.hat_open);
        SaveOneSong(db, "hat_open_cym_2", R.raw.hat_open_cym_2);
        SaveOneSong(db, "hat_open_multi", R.raw.hat_open_multi);
        SaveOneSong(db, "hat_open_toms", R.raw.hat_open_toms);
        SaveOneSong(db, "hat_open_toms_2", R.raw.hat_open_toms_2);
        SaveOneSong(db, "hat_open_toms_3", R.raw.hat_open_toms_3);
        SaveOneSong(db, "Variation", R.raw.variation);
        SaveOneSong(db, "Variation_2", R.raw.variation_2);
        SaveOneSong(db, "Variation_3", R.raw.variation_3);
    }
    public void SaveOneSong(SQLiteDatabase db, String key, int rid){
        ContentValues cv = new ContentValues();
        cv.put("name", key);
        cv.put("path",rid);
        db=mOpenHelper.getWritableDatabase();
        db.insert("piano", null, cv);
    }


}