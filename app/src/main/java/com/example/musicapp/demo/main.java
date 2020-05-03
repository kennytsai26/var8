package com.example.musicapp.demo;

import android.animation.ObjectAnimator;

import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by kennytsai26 on 2015/8/10.
 */
public class main extends FragmentActivity {

    private FragmentManager fm;
    private Fragment curFragment;
    private frg1 frg1Fragment;
    private frg2 frg2Fragment;
    private frg3 frg3Fragment;
    private frg4 frg4Fragment;
    private frg_animation_beta frg_a_b;
    private frg_animation_mega frg_m_g;
    private frg_animation_basic frg_b_s;
    private frg_animation_refla frg_r_f;
    private frg_animation_tida frg_t_d;
    private frg_6up frg_6up;
    private frg_6down frg_6down;
    private frg_28up frg_28up;
    private frg_28down frg_28down;
    private frg_55up frg_55up;
    private frg_55down frg_55down;
    private frg_58up frg_58up;
    private frg_58down frg_58down;
    private GridMenuFragment mGridMenuFragment;
    private ShimmerFrameLayout mShimmerViewContainer;
    private MediaRecorder mr = null;
    private  MaterialDialog mMaterialDialog;
    private int mListPos;
    public int select_animation = 0;
    private int select_animation_up = 0;
    private int select_animation_left = 0;
    private int select_animation_down = 0;
    private int select_animation_right = 0;
    private int  default_count = 0;
    private int  click_state=0;

    private ImageButton img0;
    private ImageButton img1;
    private ImageButton img2;
    private ImageButton img3;

    private  ImageButton music_img;
    private  ImageButton color_img;
    private ImageButton record_img;
    private  ImageButton setting_img;
private  Button done_button;
    private ImageButton curFragmentTag = null, lastFragmentTag = null;
    private ImageView imgv;
    private  String recordpath = "/sdcard/audio01.3gp";
    private int id = R.id.imageButtonRight;
    private DatabaseHelper mOpenHelper;
    private Cursor cur;
    private MediaPlayer mPlayer;
   // private int i=0;

    private List<GridMenu> menus;
 //   private GridMenuFragment mGridMenuFragment;

    public main() {
    }

    //private
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fm = getSupportFragmentManager();
        frg1Fragment = new frg1();
        frg2Fragment = new frg2();
        frg3Fragment = new frg3();
        frg4Fragment = new frg4();
        frg_a_b = new frg_animation_beta();
        frg_m_g = new frg_animation_mega();
        frg_b_s = new frg_animation_basic();
        frg_r_f = new frg_animation_refla();
        frg_t_d = new frg_animation_tida();
        frg_6up = new frg_6up();
        frg_6down = new frg_6down();
        frg_28up = new frg_28up();
        frg_28down = new frg_28down();
        frg_55up = new frg_55up();
        frg_55down = new frg_55down();
        frg_58up = new frg_58up();
        frg_58down = new frg_58down();

        img0 = (ImageButton) findViewById(R.id.imageButtonRight); // ��0��img_button
        img1 = (ImageButton) findViewById(R.id.imageButtonRight1); // ��1��img_button
        img2 = (ImageButton) findViewById(R.id.imageButtonRight2); // ��2��img_button
        img3 = (ImageButton) findViewById(R.id.imageButtonRight3); // ��3��img_button
        record_img = (ImageButton) findViewById(R.id.recordButton);
        setting_img = (ImageButton)findViewById(R.id.settingButton);
        music_img = (ImageButton)findViewById(R.id.musicbutton);
        color_img = (ImageButton)findViewById(R.id.colorbutton);
      //  record_img.setOnTouchListener(recordaction);
        record_img.setOnTouchListener(recordaction);
        setting_img.setOnTouchListener(settingaction);
        music_img.setOnClickListener(musicaction);
        color_img.setOnTouchListener(change4action);
        img0.setOnTouchListener(showfrg);
        img1.setOnTouchListener(showfrg);
        img2.setOnTouchListener(showfrg);
        img3.setOnTouchListener(showfrg);


        //db
//       init();

        //musicbutton.setOnTouchListener(showchoose);



        mShimmerViewContainer = (ShimmerFrameLayout) findViewById(R.id.shimmer_view_container);
        mShimmerViewContainer.startShimmerAnimation();
        // Save the state of the animation
        boolean isPlaying = mShimmerViewContainer.isAnimationStarted();

        mShimmerViewContainer.setDuration(5000);
        mShimmerViewContainer.setRepeatMode(ObjectAnimator.REVERSE);

        // Setting a value on the shimmer layout stops the animation. Restart it, if necessary.
        if (isPlaying) {
            mShimmerViewContainer.startShimmerAnimation();
        }



    }
/*
    public void init(){
        mOpenHelper = new DatabaseHelper(this);
        SQLiteDatabase db = mOpenHelper.getWritableDatabase();
        //-----------------------------------




        //-----------------------------------
        String  sql = "create table mySong("
                + "song_no text not null, "
                + "song_mp3 blob );";

            db.execSQL(sql);




        //---------------------------------
        SaveOneSong(db, "s01", R.raw.sound1);
    }

    public void SaveOneSong(SQLiteDatabase db, String key, int rid){
        ContentValues cv = new ContentValues();
        cv.put("song_no", key);

        InputStream is = getResources().openRawResource(rid);
        int bufSize = 63*1024;
        byte[] buffer  = new byte[bufSize];
        try {
            int size = is.read(buffer);
            while(size >= 0){
                ByteArrayOutputStream out = new ByteArrayOutputStream(size);
                out.write(buffer, 0, size);
                out.flush();
                out.close();
                cv.put("song_mp3", out.toByteArray());
                db.insert("mySong", null, cv);
                size = is.read(buffer);
            }
        } catch (IOException e) {
            Log.e("ERROR", e.toString());
        }
    }

    public void play(String cond){
        FileOutputStream os = null;
        try{
            os = openFileOutput("song.mp3", MODE_WORLD_READABLE);
        } catch(FileNotFoundException e){
            Log.e("ERROR", e.toString());
        }
        byte[] red_buf;
        //----------------------------------------
        mOpenHelper = new DatabaseHelper(this);
        SQLiteDatabase db = mOpenHelper.getReadableDatabase();
        String col[] = {"song_no", "song_mp3" };
        cur = db.query("mySong", col, cond, null, null, null, null);
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
        }

        String path = "/data/data/com.misoo.SQ01/files/song.mp3";
        mPlayer = new MediaPlayer();
        try {
            mPlayer.setDataSource(path);
            mPlayer.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
        mPlayer.start();
    }

*/
    private void setupGridMenu() {
        menus = new ArrayList<>();
        menus.add(new GridMenu("Guitar", R.drawable.guitar));
        menus.add(new GridMenu("Drum", R.drawable.drum));
        menus.add(new GridMenu("Piano", R.drawable.piano));
        menus.add(new GridMenu("Electropop", R.drawable.electropop));
        menus.add(new GridMenu("Vocal", R.drawable.vocal));

        mGridMenuFragment.setupMenu(menus);




    }

    @Override
    public void onBackPressed() {
        if (0 == getSupportFragmentManager().getBackStackEntryCount()) {
            super.onBackPressed();
        } else {
            getSupportFragmentManager().popBackStack();
        }
    }

    public OnTouchListener change4action = new OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {

            if (event.getAction() == MotionEvent.ACTION_DOWN) {   //按下
                color_img.setImageDrawable(getResources().getDrawable(R.drawable.colorbutton_down));

                //animation_value = animation_array[select_animation];
                //Intent intent = new Intent(main.this, run_service.class);
               // startService(intent);


                switch (id){
                    case R.id.imageButtonRight:
                        select_animation_up++;

                        if(select_animation_up>4){
                            select_animation_up =0;
                        }
                        switch_animation(select_animation_up,R.id.imageButtonRight);
                        break;
                    case R.id.imageButtonRight1:
                        select_animation_left++;

                        if(select_animation_left>4) {
                            select_animation_left = 0;
                        }
                        switch_animation(select_animation_left,R.id.imageButtonRight1);
                        break;
                    case R.id.imageButtonRight2:
                        select_animation_down++;

                        if(select_animation_down>4) {
                            select_animation_down = 0;
                        }
                        switch_animation(select_animation_down,R.id.imageButtonRight2);
                        break;
                    case R.id.imageButtonRight3:
                        select_animation_right++;

                        if(select_animation_right>4) {
                            select_animation_right = 0;
                        }
                        switch_animation(select_animation_right,R.id.imageButtonRight3);
                        break;
                    default:
                        select_animation_up++;

                        if(select_animation_up>4){
                            select_animation_up =0;
                        }
                        switch_animation(select_animation_up,R.id.imageButtonRight);
                }




            }

            else if (event.getAction() == MotionEvent.ACTION_UP) {   //放開
                color_img.setImageDrawable(getResources().getDrawable(R.drawable.colorbutton));

                //Intent intent = new Intent(main.this, run_service.class);
                //stopService(intent);
            }

            return false;
        }
    };


    private void switch_animation (int id,int chid){
        FragmentTransaction tx = getSupportFragmentManager().beginTransaction();

        if(id==0){

            tx.replace(R.id.viewtotalfrg, frg_b_s);
         /*   Bundle bundle = new Bundle();
            bundle.putInt("id", chid);
            frg_b_s.setArguments(bundle);*/
           tx.addToBackStack(null);
            tx.commit();
        }
        else if(id==1){
            tx.replace(R.id.viewtotalfrg,frg_a_b);
            tx.addToBackStack(null);
            tx.commit();
        }
       else if(id==2){
            tx.replace(R.id.viewtotalfrg,frg_m_g);
            tx.addToBackStack(null);
            tx.commit();
        }
       else if(id==3){
            tx.replace(R.id.viewtotalfrg,frg_r_f);
            tx.addToBackStack(null);
            tx.commit();
        }
        else if(id==4){
            tx.replace(R.id.viewtotalfrg,frg_t_d);
            tx.addToBackStack(null);
            tx.commit();
        }
          /*else if(id==3){
            tx.replace(R.id.viewtotalfrg,frg_6up);
            tx.addToBackStack(null);
            tx.commit();
        }
        else if(id==4){
            tx.replace(R.id.viewtotalfrg,frg_28up);
            tx.addToBackStack(null);
            tx.commit();
        }
        else if(id==5){
            tx.replace(R.id.viewtotalfrg,frg_6down);
            tx.addToBackStack(null);
            tx.commit();
        }
        else if(id==6){
            tx.replace(R.id.viewtotalfrg,frg_28down);
            tx.addToBackStack(null);
            tx.commit();
        }
        else if(id==7){
            tx.replace(R.id.viewtotalfrg,frg_55up);
            tx.addToBackStack(null);
            tx.commit();
        }
        else if(id==8){
            tx.replace(R.id.viewtotalfrg,frg_55down);
            tx.addToBackStack(null);
            tx.commit();
        }
        else if(id==9){
            tx.replace(R.id.viewtotalfrg,frg_58up);
            tx.addToBackStack(null);
            tx.commit();
        }
        else if(id==10){
            tx.replace(R.id.viewtotalfrg,frg_58down);
            tx.addToBackStack(null);
            tx.commit();
        }*/
    }


    public OnTouchListener recordaction = new OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {

            if (event.getAction() == MotionEvent.ACTION_DOWN) {   //按下recordbutton開始錄音

                record_img.setImageDrawable(getResources().getDrawable(R.drawable.micbutton_down));
                if(!isSDExist()){
                    Toast.makeText(main.this, "SDcard does not exist! ", Toast.LENGTH_LONG);

                }

                record_img.setEnabled(true);
               //recordAudio();
            }
            else if (event.getAction() == MotionEvent.ACTION_UP) {   //放開recordbutton停止錄音
                record_img.setImageDrawable(getResources().getDrawable(R.drawable.micbutton));
                /*if(mr != null){
                    mr.stop();
                    mr.release();
                    mr = null;
                    record_img.setEnabled(true);
                }*/
            }
            return false;
        }
    };

    private void recordAudio (){
        if(mr == null){
            mr = new MediaRecorder();
        }
        else{
            mr.reset();
        }
        try{
            mr.setAudioSource(MediaRecorder.AudioSource.MIC);
            mr.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
            mr.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
          //  i++;
            mr.setOutputFile(recordpath);
            mr.prepare();
            mr.start();
        }
        catch (Exception e){
            Log.e("Error!",e.toString());
        }
       // tvInfo.setText(R.string.recording);
    }

    private  boolean isSDExist() {
        String state = Environment.getExternalStorageState();
        if(state.equals(Environment.MEDIA_MOUNTED)){
            return  true;
        }
        else{
            return false;
        }
    }

    public View.OnClickListener musicaction = new View.OnClickListener() {
        @Override
        //按下Button事件時會進入這個 function
        public void onClick(View v) {
            if(click_state==0){
                music_img.setImageDrawable(getResources().getDrawable(R.drawable.musicbutton_down));
                FragmentTransaction tx = getSupportFragmentManager().beginTransaction();
                mGridMenuFragment = GridMenuFragment.newInstance(R.drawable.back);

                setupGridMenu();

                mGridMenuFragment.setOnClickMenuListener(new GridMenuFragment.OnClickMenuListener() {
                    @Override
                    public void onClickMenu(GridMenu gridMenu, int position) {
                        Toast.makeText(main.this, "Title:" + gridMenu.getTitle() + ", Position:" + position,
                                Toast.LENGTH_SHORT).show();
                        if (position == 0) {
                            startActivity(new Intent(main.this, Guitar.class));
                        } else if (position == 1) {
                            startActivity(new Intent(main.this, Drum.class));
                        } else if (position == 2) {
                            startActivity(new Intent(main.this, Piano.class));
                        } else if (position == 3){
                            startActivity(new Intent(main.this, Electropop.class));
                        } else if(position ==4) {
                            startActivity(new Intent(main.this, Vocal.class));
                        }
                    }
                });
                //tx.attach(mGridMenuFragment);
                tx.replace(R.id.viewtotalfrg, mGridMenuFragment);
                tx.addToBackStack(null);
                tx.commit();
            }
            else if(click_state==1){
                music_img.setImageDrawable(getResources().getDrawable(R.drawable.musicbutton));
                FragmentTransaction tx = getSupportFragmentManager().beginTransaction();
               //tx.detach(mGridMenuFragment);
                tx.addToBackStack(null);
                tx.commit();
                changeFragments(id);
                //  Intent intent = new Intent(main.this, DBtest.class);
                // startActivity(intent);  //startActivity觸發換頁
            }
            click_state++;
            if(click_state>1){
                click_state = 0;
            }
        }
    };


    public OnTouchListener settingaction = new OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {

            if (event.getAction() == MotionEvent.ACTION_DOWN) {   //按下
                setting_img.setImageDrawable(getResources().getDrawable(R.drawable.questionbutton_down));
                final Dialog  dialog = new Dialog(main.this, R.style.dialog);
                LayoutInflater inflater = LayoutInflater.from(main.this);
                final View vi = inflater.inflate(R.layout.test_dialog, null);
                dialog.setContentView(R.layout.test_dialog);
                dialog.setCancelable(true);
                WindowManager m = getWindowManager();
                Window dialogWindow = dialog.getWindow();
                WindowManager.LayoutParams lp = dialogWindow.getAttributes();
                dialogWindow.setGravity(Gravity.LEFT | Gravity.TOP);
                //lp.x = 0; // 新位置X坐标
                //lp.y = 0; // 新位置Y坐标
                //lp.width = ViewGroup.LayoutParams.WRAP_CONTENT; // 宽度
                //lp.height = ViewGroup.LayoutParams.MATCH_PARENT; // 高度
                dialog.onWindowAttributesChanged(lp);

                dialog.show();



            }
            else if (event.getAction() == MotionEvent.ACTION_UP) {   //放開
                setting_img.setImageDrawable(getResources().getDrawable(R.drawable.questionbutton));
              /*  if (mPlayer != null) {
                    mPlayer.stop();
                    mPlayer.release();
                    mPlayer = null;
                }
                finish();*/
            }
            return false;
        }
    };

    private OnTouchListener showfrg = new OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {


            id = v.getId();
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                if (curFragmentTag != null) {
                    lastFragmentTag = curFragmentTag;
                    lastFragmentTag.setSelected(false);
                    //lastFragmentTag.setBackgroundResource(R.drawable.setting_stateimages);
                    img0.setBackgroundResource(R.drawable.trianglebutton_upbright);
                    img1.setBackgroundResource(R.drawable.trianglebutton_left);
                    img2.setBackgroundResource(R.drawable.trianglebutton_down);
                    img3.setBackgroundResource(R.drawable.trianglebutton_right);
                }
                curFragmentTag = (ImageButton) v;
                curFragmentTag.setSelected(true);
                //v.setBackgroundResource(R.drawable.setting_stateimages);
                switch (id) {
                    case R.id.imageButtonRight:
                        img0.setBackgroundResource(R.drawable.trianglebutton_upbright);
                        img1.setBackgroundResource(R.drawable.trianglebutton_left);
                        img2.setBackgroundResource(R.drawable.trianglebutton_down);
                        img3.setBackgroundResource(R.drawable.trianglebutton_right);
                        showFragment(R.id.frg0);
                        break;
                    case R.id.imageButtonRight1:
                        img0.setBackgroundResource(R.drawable.trianglebutton_up);
                        img1.setBackgroundResource(R.drawable.trianglebutton_leftbright);
                        img2.setBackgroundResource(R.drawable.trianglebutton_down);
                        img3.setBackgroundResource(R.drawable.trianglebutton_right);
                        showFragment(R.id.frg1);
                        break;
                    case R.id.imageButtonRight2:
                        img0.setBackgroundResource(R.drawable.trianglebutton_up);
                        img1.setBackgroundResource(R.drawable.trianglebutton_left);
                        img2.setBackgroundResource(R.drawable.trianglebutton_downbright);
                        img3.setBackgroundResource(R.drawable.trianglebutton_right);
                        showFragment(R.id.frg2);
                        break;
                    case R.id.imageButtonRight3:
                        img0.setBackgroundResource(R.drawable.trianglebutton_up);
                        img1.setBackgroundResource(R.drawable.trianglebutton_left);
                        img2.setBackgroundResource(R.drawable.trianglebutton_down);
                        img3.setBackgroundResource(R.drawable.trianglebutton_rightbright);
                        showFragment(R.id.frg3);
                        break;
                }



            } else if (event.getAction() == MotionEvent.ACTION_UP) {
               /* switch (id) {
                    case R.id.imageButtonRight:
                        v.setBackgroundResource(R.drawable.trianglebutton_downbright);
                        showFragment(R.id.frg0);
                        break;
                    case R.id.imageButtonRight1:
                        v.setBackgroundResource(R.drawable.trianglebutton_downbright);
                        showFragment(R.id.frg1);
                        break;
                    case R.id.imageButtonRight2:
                        v.setBackgroundResource(R.drawable.trianglebutton_downbright);
                        showFragment(R.id.frg2);
                        break;
                    case R.id.imageButtonRight3:
                        v.setBackgroundResource(R.drawable.trianglebutton_downbright);
                        showFragment(R.id.frg3);
                        break;
                }*/
                // v.setBackgroundResource(R.drawable.setting_stateimages);

            }
            return false;
        }
    };

    private void showFragment(int resId) {
        FragmentTransaction transaction = fm.beginTransaction();
        frg1Fragment = new frg1();
        frg2Fragment = new frg2();
        frg3Fragment = new frg3();
        frg4Fragment = new frg4();
        //transaction.addToBackStack(null);
        hideFragments(id);
        changeFragments(id);
        curFragment = fm.findFragmentById(resId);
        transaction.show(curFragment);
        transaction.commit();
    }

    private void changeFragments(int chid) {
        if (chid == R.id.imageButtonRight) {
            switch_animation(select_animation_up,R.id.imageButtonRight);
        } else if (chid == R.id.imageButtonRight1) {
            switch_animation(select_animation_left,R.id.imageButtonRight1);
        } else if (chid == R.id.imageButtonRight2) {
            switch_animation(select_animation_down,R.id.imageButtonRight2);
        } else if (chid == R.id.imageButtonRight3) {
            switch_animation(select_animation_right,R.id.imageButtonRight3);
        }
    }

    private void hideFragments(int cid) {
        if (cid == R.id.imageButtonRight) {
            findViewById(R.id.frg0).setVisibility(View.VISIBLE);
            findViewById(R.id.frg1).setVisibility(View.GONE);
            findViewById(R.id.frg2).setVisibility(View.GONE);
            findViewById(R.id.frg3).setVisibility(View.GONE);
        } else if (cid == R.id.imageButtonRight1) {
            findViewById(R.id.frg0).setVisibility(View.GONE);
            findViewById(R.id.frg1).setVisibility(View.VISIBLE);
            findViewById(R.id.frg2).setVisibility(View.GONE);
            findViewById(R.id.frg3).setVisibility(View.GONE);
        } else if (cid == R.id.imageButtonRight2) {
            findViewById(R.id.frg0).setVisibility(View.GONE);
            findViewById(R.id.frg1).setVisibility(View.GONE);
            findViewById(R.id.frg2).setVisibility(View.VISIBLE);
            findViewById(R.id.frg3).setVisibility(View.GONE);
        } else if (cid == R.id.imageButtonRight3) {
            findViewById(R.id.frg0).setVisibility(View.GONE);
            findViewById(R.id.frg1).setVisibility(View.GONE);
            findViewById(R.id.frg2).setVisibility(View.GONE);
            findViewById(R.id.frg3).setVisibility(View.VISIBLE);
        }
    }




}
