package com.example.musicapp.demo;

import android.content.ContentValues;
import android.content.Intent;
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

/**
 * Author:    ZhuWenWu
 * Version    V1.0
 * Date:      2014/9/4  17:11.
 * Description:
 * Modification  History:
 * Date         	Author        		Version        	Description
 * -----------------------------------------------------------------------------------
 * 2014/9/4        ZhuWenWu            1.0                    1.0
 * Why & What is modified:
 */
public class Guitar extends AppCompatActivity {
    /***********/
    private static final int[] mPics=new int[]{R.drawable.touchbutton};
    private ImageButton music_play;
    private ImageButton music_add;
    private DatabaseHelper mOpenHelper;
    private SQLiteDatabase db;
    private Cursor cur;

    private MediaPlayer mp;
    /*******/
    private PullToZoomListViewEx listView;
    public static final String TABLE_NAME_GUITAR="guitar";
    public static final String TABLE_NAME_DRUM="drum";
    public static final String TABLE_NAME_PIANO="piano";
    public static final String TABLE_NAME_ELECTROPOP="electropop";
    public static final String TABLE_NAME_VOCAL="vocal";
    public static final String id_cloumn="_id";
    public static final String name_cloumn="name";
    public static final String path_cloumn="path";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pull_to_zoom_list_view_guitar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        listView = (PullToZoomListViewEx) findViewById(R.id.listview);
        music_play = (ImageButton) findViewById(R.id.img_play);
        music_add = (ImageButton) findViewById(R.id.img_add);



       mOpenHelper = new DatabaseHelper(getApplicationContext());
        //SQLiteDatabase db = mOpenHelper.getWritableDatabase();
        db = mOpenHelper.getReadableDatabase();
        db.delete("guitar", "1", null);
        db=mOpenHelper.getWritableDatabase();

        //db.execSQL(Guitar_Table_SQL);
        //db.execSQL(Drum_Table_SQL);
       // db.execSQL(Piano_Table_SQL);
        //db.execSQL(Electropop_Table_SQL);
        //db.execSQL(Vocal_Table_SQL);
       /* FileOutputStream os = null;
        try{
            os = openFileOutput("song.mp3", MODE_WORLD_READABLE);
        } catch(FileNotFoundException e){
            Log.e("ERROR", e.toString());
        }
        byte[] red_buf;

        String col[] = {"name_cloumn", "path_cloumn" };
        cur = db.query("guitar", col, "path_cloumn", null, null, null, null);
        int k =0;
        cur.moveToFirst();
        try{
            while(!cur.isAfterLast()){
                red_buf = cur.getBlob(1);
                os.write(red_buf);
                k++;
                cur.moveToNext();
            }
            os.flush();
            os.close();

        }catch(Exception e){
            Log.e("ERROR", e.toString());
            return;
        }*/
        /*
        mOpenHelper.insert_guitar("arcade", R.raw.arcade);
        Cursor cursor= mOpenHelper.getAll_Guitar();
        cursor.moveToFirst();
         String [] adapterData=new String[1];
        adapterData[0]=cursor.getString(0);
*/
        /*final String[] adapterData = new String[]{"Activity", "Service", "Content Provider", "Intent", "BroadcastReceiver", "ADT", "Sqlite3", "HttpClient",
                "DDMS", "Android Studio", "Fragment", "Loader", "Activity", "Service", "Content Provider", "Intent",
                "BroadcastReceiver", "ADT", "Sqlite3", "HttpClient", "Activity", "Service", "Content Provider", "Intent",
                "BroadcastReceiver", "ADT", "Sqlite3", "HttpClient"};*/
//11/18
        save();


        final ArrayList<String> adapterData = new ArrayList<String>();
        final ArrayList<String> no = new ArrayList<String>();
        final  int[] picture = new int[1];
/*
        ContentValues cv = new ContentValues();
        cv.put("path", R.raw.arcade);
        cv.put("name", "arcade.mp3");
        db.insert("guitar", null, cv);*/

        db=mOpenHelper.getReadableDatabase();

       final Cursor c=db.rawQuery("SELECT * FROM "+ TABLE_NAME_GUITAR,null);
        c.moveToFirst();
       /* while (c.moveToNext()){
            no.add(c.getString(0));
            adapterData.add(c.getString(1));

        }*/
for(int i=0;i<c.getCount();i++){
    no.add(c.getString(0));
    adapterData.add(c.getString(1));
    c.moveToNext();

}
        picture[0] = R.drawable.music_logo;

        ArrayList<HashMap<String,Object>> list = new ArrayList<HashMap<String,Object>>();
       //int i=0;

        /*
        while (c.moveToNext()){
            HashMap<String,Object> item = new HashMap<String,Object>();
            item.put("no", "   "+no.get(i));
            item.put( "name", "  "+adapterData.get(i));
            //item.put("path", "   "+c.getInt(2) );
            item.put("picture_play", R.drawable.touchbutton);
            item.put("picture_add", R.drawable.music_logo);
            list.add(item);
            i++;
        }*/c.moveToFirst();
        for(int i=0;i<c.getCount();i++){
            HashMap<String,Object> item = new HashMap<String,Object>();
            item.put("no", no.get(i));
            item.put( "name",adapterData.get(i));
            //item.put("path", "   "+c.getInt(2) );
            item.put("picture_play", R.drawable.picture_play);
            item.put("picture_add", R.drawable.picture_add);
            list.add(item);

        }

        // Cursor c = db.rawQuery("select * from " + "guitar", null);
      //          c.moveToFirst();
        //Cursor c = mOpenHelper.getAll_Guitar();
      //  c.moveToFirst();
       // String [] adapterData=new String[1];
        //adapterData[0]=c.getString(1);
                // int columnsSize = c.getColumnCount();
        /*ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
        for (int i = 0; i < c.getColumnCount(); i++) {

            c.moveToNext();
        }*/


        listView.setAdapter(new lvButtonAdapter(this, list, R.layout.simple_list_item, new String[]{"picture_play", "no", "name", "picture_add"}, new int[]{R.id.img_play, R.id.textView1, R.id.textView2, R.id.img_add},"guitar"));
        listView.getPullRootView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.e("zhuwenwu", "position = " + position);

            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.e("zhuwenwu1", "position = " + position);


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
        SaveOneSong(db, "dr", R.raw.dr);
        SaveOneSong(db, "dry_a_d_rock_100", R.raw.dry_a_d_rock_100);
        SaveOneSong(db, "cdry_a_g_c_100", R.raw.dry_a_g_c_100);
        SaveOneSong(db, "dry_a_g_rock_100", R.raw.dry_a_g_rock_100);
        SaveOneSong(db, "dry_b_100", R.raw.dry_b_100);
        SaveOneSong(db, "dry_b_rock_100", R.raw.dry_b_rock_100);
        SaveOneSong(db, "dry_bmin_100", R.raw.dry_bmin_100);
        SaveOneSong(db, "dry_c_d_100", R.raw.dry_c_d_100);
        SaveOneSong(db, "dry_d_100", R.raw.dry_d_100);
        SaveOneSong(db, "dry_d_c_power", R.raw.dry_d_c_power);
        SaveOneSong(db, "dry_e_add_9_100", R.raw.dry_e_add_9_100);
        SaveOneSong(db, "dry_e_power", R.raw.dry_e_power);
        SaveOneSong(db, "dry_e_rock_100", R.raw.dry_e_rock_100);
        SaveOneSong(db, "drya_brock100", R.raw.drya_brock100);
        SaveOneSong(db, "drya_g", R.raw.drya_g);
        SaveOneSong(db, "drya100", R.raw.drya100);
        SaveOneSong(db, "drya100_01", R.raw.drya100_01);
        SaveOneSong(db, "drya100_1", R.raw.drya100_1);
        SaveOneSong(db, "drye_c_badd_9_100_01", R.raw.drye_c_badd_9_100_01);
        SaveOneSong(db, "dryemin100", R.raw.dryemin100);
        SaveOneSong(db, "Fs_musical", R.raw.fs_musical);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            Intent i = new Intent(this,main.class);
            startActivity(i);
            //finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

   //11/17
 // public void SaveOneSong(DatabaseHelper db, String key, int rid){
        public void SaveOneSong(SQLiteDatabase db, String key, int rid){
        ContentValues cv = new ContentValues();
        cv.put("name", key);
        cv.put("path",rid);
        db=mOpenHelper.getWritableDatabase();
        db.insert("guitar", null, cv);
       // InputStream is = getResources().openRawResource(rid);
       // int bufSize = 63*1024;
        //byte[] buffer  = new byte[bufSize];
        //try {
         //   int size = is.read(buffer);
          //  while(size >= 0){
           //     ByteArrayOutputStream out = new ByteArrayOutputStream(size);
            //    out.write(buffer, 0, size);
             //   out.flush();
              //  out.close();
               // cv.put("path", out.toByteArray());

               //11/17
              // db.insert_guitar(cv);

                //size = is.read(buffer);
          //  }
       // } catch (IOException e) {
           // Log.e("ERROR", e.toString());
      //  }
    }
}

