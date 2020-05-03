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


public class Vocal extends AppCompatActivity {

    private PullToZoomListViewEx listView;
    private ImageButton music_play;
    private ImageButton music_add;
    private DatabaseHelper mOpenHelper;
    private SQLiteDatabase db;
    private Cursor cur;
    public static final String TABLE_NAME_VOCAL="vocal";
    public String defaultPath;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pull_to_zoom_list_view_vocal);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        listView = (PullToZoomListViewEx) findViewById(R.id.listview);
        music_play = (ImageButton) findViewById(R.id.img_play);
        music_add = (ImageButton) findViewById(R.id.img_add);
        mOpenHelper = new DatabaseHelper(getApplicationContext());
        db = mOpenHelper.getReadableDatabase();
        db.delete("vocal", "1", null);
        db=mOpenHelper.getWritableDatabase();
        final ArrayList<String> vocalname = new ArrayList<String>();
        final ArrayList<String> no = new ArrayList<String>();
        defaultPath = "android.resource://com.example.kennytsai26.myapplication/" + R.raw.ambient_loop_em;
        save();
        final Cursor c=db.rawQuery("SELECT * FROM "+ TABLE_NAME_VOCAL,null);
        c.moveToFirst();
        for(int i=0;i<c.getCount();i++){
            no.add(c.getString(0));
            vocalname.add(c.getString(1));
            c.moveToNext();

        }
        ArrayList<HashMap<String,Object>> list = new ArrayList<HashMap<String,Object>>();
        c.moveToFirst();
        for(int i=0;i<c.getCount();i++){
            HashMap<String,Object> item = new HashMap<String,Object>();
            item.put("no", "     "+no.get(i)+"  ");
            item.put( "name", "  "+vocalname.get(i)+" ");
            //item.put("path", "   "+c.getInt(2) );
            item.put("picture_play", R.drawable.picture_play);
            item.put("picture_add", R.drawable.picture_add);
            list.add(item);

        }

        listView.setAdapter(new lvButtonAdapter(this,list, android.R.layout.simple_list_item_1,  new String[]{"picture_play", "no", "name", "picture_add"}, new int[]{R.id.img_play, R.id.textView1, R.id.textView2, R.id.img_add},"vocal"));
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

    private void save() {
        SaveOneSong(db,"Record Music",defaultPath);
        saveSong(db, "What Do You Mean", R.raw.what_do_you_mean);
        saveSong(db, "Ruedy Boogie", R.raw.ruedy_boogie);
        saveSong(db, " Love_My Life", R.raw.love_my_life);
        saveSong(db, " Bo Ro Bo Ro Mei", R.raw.bo_ro_bo_ro_mei);
        saveSong(db, " PikaPika", R.raw.pikapika);
    }
    private void SaveOneSong(SQLiteDatabase db, String key, String path){
        ContentValues cv = new ContentValues();
        cv.put("name", key);
        cv.put("path", path);
        db.insert("vocal", null, cv);
    }
    private void saveSong(SQLiteDatabase db, String key, int rid) {
        ContentValues cv = new ContentValues();
        cv.put("name", key);
        cv.put("path",rid);
        db.insert("vocal", null, cv);
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


}