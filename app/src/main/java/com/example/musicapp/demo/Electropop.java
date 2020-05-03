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


public class Electropop extends AppCompatActivity {

    private PullToZoomListViewEx listView;
    private DatabaseHelper mOpenHelper;
    private SQLiteDatabase db;
    private Cursor cur;
    private MediaPlayer mp;
    private ImageButton music_play;
    private  ImageButton music_add;
    public static final String TABLE_NAME_ELECTROPOP="electropop";
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pull_to_zoom_list_view_electropop);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        listView = (PullToZoomListViewEx) findViewById(R.id.listview);
        music_play = (ImageButton) findViewById(R.id.img_play);
        music_add = (ImageButton) findViewById(R.id.img_add);


        mOpenHelper = new DatabaseHelper(getApplicationContext());
        mOpenHelper = new DatabaseHelper(getApplicationContext());
        //SQLiteDatabase db = mOpenHelper.getWritableDatabase();
        db = mOpenHelper.getReadableDatabase();
        db.delete("electropop", "1", null);
        db=mOpenHelper.getWritableDatabase();
        //insertdata();
        final ArrayList<String> name = new ArrayList<String>();
        final ArrayList<String> no = new ArrayList<String>();
        ArrayList<HashMap<String,Object>> list = new ArrayList<HashMap<String,Object>>();
       // String[] adapterData = new String[]{"Activity", "Service"};
        insertdata();
        final Cursor c=db.rawQuery("SELECT * FROM "+ TABLE_NAME_ELECTROPOP,null);
        c.moveToFirst();
        for(int i=0;i<c.getCount();i++){
            no.add(c.getString(0));
            name.add(c.getString(1));
            c.moveToNext();

        }

        c.moveToFirst();
        for(int i=0;i<c.getCount();i++){
            HashMap<String,Object> item = new HashMap<String,Object>();
            item.put("no", no.get(i));
            item.put( "name",name.get(i));
            //item.put("path", "   "+c.getInt(2) );
            item.put("picture_play", R.drawable.picture_play);
            item.put("picture_add", R.drawable.picture_add);
            list.add(item);

        }
        listView.setAdapter(new lvButtonAdapter(this, list, R.layout.simple_list_item, new String[]{"picture_play", "no", "name", "picture_add"}, new int[]{R.id.img_play, R.id.textView1, R.id.textView2, R.id.img_add},"electropop"));
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

    private void insertdata() {

        saveSong(db,"Blipped Reso",R.raw.blipped_reso);

        saveSong(db,"DJ01 Ambient01",R.raw.dj_puzzle_s01_ambient_01);
        saveSong(db,"DJ01 Ambient02",R.raw.dj_puzzle_s02_ambient_01);
        saveSong(db,"DJ01 Ambient03",R.raw.dj_puzzle_s04_ambient);
        saveSong(db,"DJ01 Ambient04",R.raw.dj_puzzle_s06_ambient);
        saveSong(db,"DJ01 Bass01",R.raw.dj_puzzle_s01_bass_01);
        saveSong(db,"DJ01 Bass02",R.raw.dj_puzzle_s01_bass_02);
        saveSong(db,"DJ01 Bass03",R.raw.dj_puzzle_s02_bass_01);
        saveSong(db,"DJ01 Bass04",R.raw.dj_puzzle_s02_bass_02);
        saveSong(db,"DJ01 Bass05",R.raw.dj_puzzle_s01_bass_03);
        saveSong(db,"DJ01 Bass06",R.raw.dj_puzzle_s04_bass_01);
        saveSong(db,"DJ01 Bass07",R.raw.dj_puzzle_s04_bass_03);
        saveSong(db,"DJ01 Bass08",R.raw.dj_puzzle_s05_bass);
        saveSong(db,"DJ01 Bass09",R.raw.dj_puzzle_s06_bass);
        saveSong(db,"DJ01 Bass10",R.raw.dj_puzzle_s06_bass_02);
        saveSong(db,"DJ01 Bass11",R.raw.dj_puzzle_s06_bass_03);
        saveSong(db,"DJ01 Bass12",R.raw.dj_puzzle_s06_bass_04);
        saveSong(db,"DJ01 Bass13",R.raw.dj_puzzle_s06_bass_05);
        saveSong(db,"DJ01 Bass14",R.raw.dj_puzzle_s06_bass_06);
        saveSong(db,"DJ01 Bass15",R.raw.dj_puzzle_s06_bass_07);
        saveSong(db,"DJ01 Bass16",R.raw.dj_puzzle_s06_bass_08);
        saveSong(db,"DJ01 Bass17",R.raw.dj_puzzle_s06_bass_09);
        saveSong(db,"DJ01 Bass18",R.raw.dj_puzzle_s06_bass_10);
        saveSong(db,"DJ01 Bass19",R.raw.dj_puzzle_s06_bass_11);
        saveSong(db,"DJ01 Bass20",R.raw.dj_puzzle_s06_bass_12);
        saveSong(db,"DJ01 Bass21",R.raw.dj_puzzle_s06_bass_13);
        saveSong(db,"DJ10 Bass22",R.raw.dj_puzzle_s07_bass);
        saveSong(db,"DJ10 Bass23",R.raw.dj_puzzle_s07_bass_02);
        saveSong(db,"DJ10 Bass24",R.raw.dj_puzzle_s07_bass_03);
        saveSong(db,"DJ10 Bass25",R.raw.dj_puzzle_s07_bass_04);
        saveSong(db,"DJ10 Bass26",R.raw.dj_puzzle_s07_bit_bass);
        saveSong(db,"DJ01 Bell",R.raw.dj_puzzle_s02_bell);
        saveSong(db,"DJ01 Blippy",R.raw.dj_puzzle_s06_blippy);
        saveSong(db,"DJ01 Brass",R.raw.dj_puzzle_s04_brass);
        saveSong(db,"DJ01 Chord01",R.raw.dj_puzzle_s02_chord);
        saveSong(db,"DJ01 Chord02",R.raw.dj_puzzle_s03_prog_chords_01);
        saveSong(db,"DJ01 Chord03",R.raw.dj_puzzle_s05_dub_chords);
        saveSong(db,"DJ01 Glitch",R.raw.dj_puzzle_s03_perc_glitch);
        saveSong(db,"DJ01 Lead01",R.raw.dj_puzzle_s01_lead_01);
        saveSong(db,"DJ01 Lead02",R.raw.dj_puzzle_s01_lead_02);
        saveSong(db,"DJ01 Lead03",R.raw.dj_puzzle_s03_lead_01);
        saveSong(db,"DJ01 Lead04",R.raw.dj_puzzle_s03_lead_02);
        saveSong(db,"DJ01 Lead05",R.raw.dj_puzzle_s03_lead_03);
        saveSong(db,"DJ01 Lead06",R.raw.dj_puzzle_s04_softlead);
        saveSong(db,"DJ01 Lead07",R.raw.dj_puzzle_s04_softlead_02);
        saveSong(db,"DJ01 Lead08",R.raw.dj_puzzle_s06_lead_01);
        saveSong(db,"DJ01 Lead09",R.raw.dj_puzzle_s06_lead_02);
        saveSong(db,"DJ01 Lead10",R.raw.dj_puzzle_s06_lead_04);
        saveSong(db,"DJ10 Lead11",R.raw.dj_puzzle_s07_euro_lead_01);
        saveSong(db,"DJ10 Lead12",R.raw.dj_puzzle_s07_euro_lead_02);
        saveSong(db,"DJ10 Lead13",R.raw.dj_puzzle_s07_euro_lead_03);
        saveSong(db,"DJ10 Lead14",R.raw.dj_puzzle_s07_euro_lead_04);
        saveSong(db,"DJ10 Lead15",R.raw.dj_puzzle_s07_square_lead_01);
        saveSong(db,"DJ10 Lead16",R.raw.dj_puzzle_s07_square_lead_02);
        saveSong(db,"DJ10 Lead17",R.raw.dj_puzzle_s07_trance_chords);
        saveSong(db,"DJ01 Lfo01",R.raw.dj_puzzle_s03_lfo_fx_01);
        saveSong(db,"DJ01 Lfo02",R.raw.dj_puzzle_s03_lfo_fx_02);
        saveSong(db,"DJ01 Lfo03",R.raw.dj_puzzle_s03_lfo_fx_03);
        saveSong(db,"DJ01 Lfo04",R.raw.dj_puzzle_s03_lfo_fx_04);
        saveSong(db,"DJ01 Mysterious",R.raw.dj_puzzle_s05_mysterious);
        saveSong(db,"DJ01 Pads01",R.raw.dj_puzzle_s01_pads_01);
        saveSong(db,"DJ01 Pads02",R.raw.dj_puzzle_s01_pads_02);
        saveSong(db,"DJ01 Pads03",R.raw.dj_puzzle_s02_pad);
        saveSong(db,"DJ01 Pads04",R.raw.dj_puzzle_s03_trance_pad_01);
        saveSong(db,"DJ01 Pads05",R.raw.dj_puzzle_s04_pad);
        saveSong(db,"DJ01 Pads06",R.raw.dj_puzzle_s04_hardpad);
        saveSong(db,"DJ01 Perc01",R.raw.dj_puzzle_s02_mixed_perc);
        saveSong(db,"DJ01 Perc02",R.raw.dj_puzzle_s04_perc);
        saveSong(db,"DJ01 Phaser",R.raw.dj_puzzle_s06_phaser);
        saveSong(db,"DJ01 Plucky01",R.raw.dj_puzzle_s04_plucky);
        saveSong(db,"DJ01 Plucky02",R.raw.dj_puzzle_s05_plucky);
        saveSong(db,"DJ01 Scary",R.raw.dj_puzzle_s05_scary);
        saveSong(db,"DJ01 Sfx01",R.raw.dj_puzzle_s01_sfx_01);
        saveSong(db,"DJ01 Sfx02",R.raw.dj_puzzle_s02_sfx_01);
        saveSong(db,"DJ01 Sfx03",R.raw.dj_puzzle_s02_sfx_02);
        saveSong(db,"DJ01 Sfx04",R.raw.dj_puzzle_s02_sfx_03);
        saveSong(db,"DJ01 Sfx05",R.raw.dj_puzzle_s03_sfx_02);
        saveSong(db,"DJ01 Sfx06",R.raw.dj_puzzle_s04_sfx);
        saveSong(db,"DJ01 Sfx07",R.raw.dj_puzzle_s05_sfx);
        saveSong(db,"DJ01 Sfx08",R.raw.dj_puzzle_s06_sfx);
        saveSong(db,"DJ01 Sfx09",R.raw.dj_puzzle_s06_sfx_02);
        saveSong(db,"DJ10 Sfx10",R.raw.dj_puzzle_s07_sfx);
        saveSong(db,"DJ01 SingleNote01",R.raw.dj_puzzle_s01_single_note);
        saveSong(db,"DJ01 SingleNote02",R.raw.dj_puzzle_s03_single_note_donk);
        saveSong(db,"DJ01 Slippery",R.raw.dj_puzzle_s02_slippery);
        saveSong(db,"DJ01 Synth01",R.raw.dj_puzzle_s03_synth_strings_01);
        saveSong(db,"DJ01 Synth02",R.raw.dj_puzzle_s04_weird_synth);
        saveSong(db,"DJ01 TranceArpegg01",R.raw.dj_puzzle_s03_trance_arpegg_01);
        saveSong(db,"DJ01 TranceArpegg02",R.raw.dj_puzzle_s03_trance_arpegg_02);
        saveSong(db,"DJ01 TranceArpegg03",R.raw.dj_puzzle_s03_trance_arpegg_03);
        saveSong(db,"DJ01 TranceArpegg04",R.raw.dj_puzzle_s03_trance_arpegg_04);
        saveSong(db,"DJ01 TranceArpegg05",R.raw.dj_puzzle_s03_trance_arpegg_05);











        saveSong(db,"DJ10_TrancePiano",R.raw.dj_puzzle_s10_trance_piano);



        saveSong(db,"Drumbeat",R.raw.drumbeat_2);


        saveSong(db,"ElectroCrash3_G2",R.raw.electrocrash3_g2);
        saveSong(db,"Electrofied_Bass01",R.raw. plp_electrofied_bass08);
        saveSong(db,"Electrofied_Bass02",R.raw. plp_electrofied_bass09);
        saveSong(db,"Electrofied_Bass03",R.raw. plp_electrofied_bass10);
        saveSong(db,"Electrofied_Bass04",R.raw. plp_electrofied_bass01);
        saveSong(db,"Electrofied_Bass05",R.raw. plp_electrofied_bass03);
        saveSong(db,"Electrofied_Bass06",R.raw. plp_electrofied_bass07);

        saveSong(db,"electrolaser_f2",R.raw.electrolaser_f2);

        saveSong(db,"electroStart_e2",R.raw.electrostart_e2);

        saveSong(db,"Percussion",R.raw.percussion);
        saveSong(db,"Risebang_Fx",R.raw.risebang_fx);
        saveSong(db,"Scratch_Beatscratch01",R.raw.scratch_beatscratch01);
        saveSong(db,"Scratch_Beatscratch02",R.raw.scratch_beatscratch02);

        saveSong(db,"Scratch_Bitscratch01",R.raw.scratch_bitscratch01);
        saveSong(db,"Scratch_Bitscratch02",R.raw.scratch_bitscratch02);
        saveSong(db,"Scratch_Bitscratch03",R.raw.scratch_bitscratch03);
        saveSong(db,"Scratch_Bitscratch04",R.raw.scratch_bitscratch04);
        saveSong(db,"Scratch_Bitscratch05",R.raw.scratch_bitscratch05);
        saveSong(db,"Scratch_Bitscratch06",R.raw.scratch_bitscratch07);

        saveSong(db,"Scratch_Eastern01",R.raw.scratch_eastern01);
        saveSong(db,"Scratch_Eastern02",R.raw.scratch_eastern02);
        saveSong(db,"Scratch_Epiano01",R.raw.scratch_epiano01);
        saveSong(db,"Scratch_Epiano02",R.raw.scratch_epiano02);


        saveSong(db,"Scratch_Hit01",R.raw.scratch_hit_01);
        saveSong(db,"Scratch_Hit02",R.raw.scratch_hit_02);
        saveSong(db,"Scratch_Hit03",R.raw.scratch_hit_03);
        saveSong(db,"Scratch_Hit04",R.raw.scratch_hit_04);

        saveSong(db,"Scratch_Hitscratch01",R.raw.scratch_hitscratch_g_02);
        saveSong(db,"Scratch_Hitscratch02",R.raw.scratch_hitscratch_g_02_plp);
        saveSong(db,"Scratch_Hitscratch03",R.raw.scratch_hitscratch_g_03);
        saveSong(db,"Scratch_Hitscratch04",R.raw.scratch_hitscratch_g_03_plp);
        saveSong(db,"Scratch_Hitscratch05",R.raw.scratch_hitscratch_g_04);
        saveSong(db,"Scratch_Hitscratch06",R.raw.scratch_hitscratch_g_01);
        saveSong(db,"Scratch_Hitscratch07",R.raw.scratch_hitscratch_d);
        saveSong(db,"Scratch_Hitscratch08",R.raw.scratch_hitscratch_d_plp);

        saveSong(db,"Scratch_Kickscratch",R.raw.scratch_kickscratch);

        saveSong(db,"Scratch_Moogscratch",R.raw.scratch_moogscratch);

        saveSong(db,"Scratch_Percscratch01",R.raw.scratch_percscratch01);
        saveSong(db,"Scratch_Percscratch02",R.raw.scratch_percscratch03);
        saveSong(db,"Scratch_Percscratch03",R.raw.scratch_percscratch06);
        saveSong(db,"Scratch_Percscratch04",R.raw.scratch_percscratch07);
        saveSong(db,"Scratch_Percscratch05",R.raw.scratch_percscratch08);


        saveSong(db,"Scratch_Snarescratch01",R.raw.scratch_snarescratch02);
        saveSong(db,"Scratch_Snarescratch02",R.raw.scratch_snarescratch03);

        saveSong(db,"Scratch_Synth",R.raw.scratch_synth);



        saveSong(db,"Scratch_Voxscratch01",R.raw.scratch_voxscratch01);
        saveSong(db,"Scratch_Voxscratch02",R.raw.scratch_voxscratch03);
        saveSong(db,"Scratch_Voxscratch03",R.raw.scratch_voxscratch04);
        saveSong(db,"Scratch_Voxscratch04",R.raw.scratch_voxscratch04_plp);
        saveSong(db,"Scratch_Voxscratch05",R.raw.scratch_voxscratch06);
        saveSong(db,"Scratch_Voxscratch06",R.raw.scratch_voxscratch08);
        saveSong(db,"Scratch_Voxscratch07",R.raw.scratch_voxscratch09);
        saveSong(db,"Scratch_Voxscratch08",R.raw.scratch_voxscratch10);

        saveSong(db,"Tb_ upper",R.raw.tb_upper);
        saveSong(db,"Weapon 01",R.raw.weapon_01);
        saveSong(db,"Weapon 02",R.raw.weapon_02);
        saveSong(db,"Weapon 03",R.raw.weapon_03);
        saveSong(db,"Weapon 04",R.raw.weapon_04);
        saveSong(db,"Weapon 05",R.raw.weapon_05);
        saveSong(db,"Weapon 06",R.raw.weapon_06);
        saveSong(db,"Weapon 07",R.raw.weapon_07);
        saveSong(db,"Weapon 08",R.raw.weapon_08);
        saveSong(db,"Weapon 09",R.raw.weapon_09);
        saveSong(db,"Weapon 10",R.raw.weapon_10);
        saveSong(db,"Weapon 11",R.raw.weapon_11);
        saveSong(db,"Weapon 12",R.raw.weapon_12);
        saveSong(db,"Weapon 13",R.raw.weapon_13);
        saveSong(db,"Weapon 14",R.raw.weapon_14);
        saveSong(db,"Weapon 15",R.raw.weapon_15);
        saveSong(db,"Weapon 16",R.raw.weapon_16);
        saveSong(db,"Weapon 17",R.raw.weapon_17);
        saveSong(db,"Weapon 18",R.raw.weapon_18);
        saveSong(db,"Weapon 19",R.raw.weapon_19);
        saveSong(db,"Weapon 20",R.raw.weapon_20);
        saveSong(db,"Weapon 21",R.raw.weapon_21);
        saveSong(db,"Weapon 22",R.raw.weapon_22);
        saveSong(db,"Weapon 23",R.raw.weapon_23);
        saveSong(db,"Weapon 24",R.raw.weapon_24);
        saveSong(db,"Weapon 25",R.raw.weapon_25);
        saveSong(db,"Weapon 26",R.raw.weapon_26);
        saveSong(db,"Weapon 27",R.raw.weapon_27);
        saveSong(db,"Weapon 28",R.raw.weapon_28);
        saveSong(db,"Weapon 29",R.raw.weapon_29);
        saveSong(db,"Weapon 30",R.raw.weapon_30);
        saveSong(db,"Weapon 31",R.raw.weapon_31);
        saveSong(db,"Weapon 32",R.raw.weapon_32);
        saveSong(db,"Weapon 33",R.raw.weapon_33);
        saveSong(db,"Weapon 34",R.raw.weapon_34);
        saveSong(db,"Weapon 35",R.raw.weapon_35);
        saveSong(db,"Weapon 36",R.raw.weapon_36);


    }

    private void saveSong(SQLiteDatabase db, String key, int rid) {
        ContentValues cv = new ContentValues();
        cv.put("name", key);
        cv.put("path",rid);
        db.insert("electropop", null, cv);
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