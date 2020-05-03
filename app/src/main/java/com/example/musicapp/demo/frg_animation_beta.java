package com.example.musicapp.demo;

/**
 * Created by B7 on 2015/11/2.
 */
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import android.media.MediaPlayer;

import java.io.IOException;
import android.os.Handler;

import java.util.ArrayList;

public class frg_animation_beta extends Fragment {

    final static String ARG_POSITION = "id";
    private Button line1_button_left;
    private Button line1_button_leftmid;
    private Button line1_button_mid;
    private Button line1_button_rightmid;
    private Button line1_button_right;
    private Button line1_button_rightover;
    private Button line2_button_left;
    private Button line2_button_leftmid;
    private Button line2_button_mid;
    private Button line2_button_rightmid;
    private Button line2_button_right;
    private Button line2_button_rightover;
    private Button line3_button_left;
    private Button line3_button_leftmid;
    private Button line3_button_mid;
    private Button line3_button_rightmid;
    private Button line3_button_right;
    private Button line3_button_rightover;
    private Button line4_button_left;
    private Button line4_button_leftmid;
    private Button line4_button_mid;
    private Button line4_button_rightmid;
    private Button line4_button_right;
    private Button line4_button_rightover;
    private MediaPlayer mp;
    /******/
    private int  click_state_line1=0;
    private int  click_state_line2=0;
    private int  click_state_line3=0;
    private int  click_state_line4=0;
    private  int i=0;
    private  int it;
    private String  item;
    private DatabaseHelper mOpenHelper;
    private SQLiteDatabase db;
    public static final String TABLE_NAME_Recordmusic="recordmusic";
    private String defaultPath;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mOpenHelper = new DatabaseHelper(getActivity());
        db = mOpenHelper.getReadableDatabase();
        final ArrayList<Integer> no = new ArrayList<Integer>();
        final ArrayList<String> path = new ArrayList<String>();
        final ArrayList<String> vpath = new ArrayList<String>();
        final ArrayList<Integer> frg = new ArrayList<Integer>();
        final ArrayList<Integer> button = new ArrayList<Integer>();

        defaultPath = "android.resource://com.example.kennytsai26.myapplication/" + R.raw.ambient_loop_em;

       try {
           final Cursor c=db.rawQuery("SELECT * FROM "+ TABLE_NAME_Recordmusic+" WHERE fragement = "+1,null);
           c.moveToFirst();
           for(int i=0;i<c.getCount();i++){
               no.add(c.getInt(1));
               path.add(c.getString(2));
               frg.add(c.getInt(3));
               button.add(c.getInt(4));
               Log.e("qq1", "id_cloumn = " + c.getInt(4));
               c.moveToNext();
           }
       } catch(Exception e) {

       }
        line1_button_left.setOnClickListener(new Button.OnClickListener() {
            MediaPlayer mp = new MediaPlayer();

            @Override
            public void onClick(View v) {
                if (click_state_line1==0) {  //  ���U���ɭԧ��ܭI�����C��

                    if (path.get(button.indexOf(0)).equals("0")) {
                        vpath.add(0, defaultPath);
                        Log.e("aa", "aa =  " + vpath.get(0));
                    }

                    if (vpath.size() == 0) {
                        mp = MediaPlayer.create(getActivity(), Integer.parseInt(path.get(button.indexOf(0))));
                        mp.seekTo(0);
                        mp.setLooping(true);
                        mp.start();
                    } else {
                        try {
                            mp.setDataSource(vpath.get(0));
                            mp.setLooping(true);    //?�m�O�_�`?����
                            mp.prepare();
                            mp.start();

                        } catch (IllegalArgumentException e) {
                            e.printStackTrace();
                        } catch (IllegalStateException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    line1_button_left.setBackgroundResource(R.drawable.touchbuttonbright);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line2_button_leftmid.setBackgroundResource(R.drawable.touchbuttonbright);
                        }
                    }, 60);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line3_button_mid.setBackgroundResource(R.drawable.touchbuttonbright);
                        }
                    }, 120);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line4_button_rightmid.setBackgroundResource(R.drawable.touchbuttonbright);
                            line1_button_left.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 180);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line3_button_right.setBackgroundResource(R.drawable.touchbuttonbright);
                            line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 240);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line2_button_rightover.setBackgroundResource(R.drawable.touchbuttonbright);
                            line3_button_mid.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 300);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 360);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line3_button_right.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 420);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line2_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 480);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_left.setBackgroundResource(R.drawable.touchbuttonbright);
                        }
                    }, 540);

                }
                else if(click_state_line1==1) {  //�_�Ӫ��ɭԫ�_�I���P�C��
                    if (vpath.size() == 0) {
                        mp.stop();
                        mp.reset();
                    } else {
                        mp.stop();
                        mp.reset();
                        vpath.removeAll(vpath);

                    }
                    line1_button_left.setBackgroundResource(R.drawable.touchbutton);
                }
                click_state_line1++;
                if(click_state_line1>1){
                    click_state_line1 = 0;
                }
            }
        });

        line2_button_left.setOnClickListener(new Button.OnClickListener() {
            MediaPlayer mp = new MediaPlayer();

            @Override
            public void onClick(View v) {
                if (click_state_line2==0) {  //���U���ɭԧ��ܭI�����C��

                    if (path.get(button.indexOf(6)).equals("0")) {
                        vpath.add(0, defaultPath);
                        Log.e("bb", "aa =  " + vpath.get(0));
                    }

                    if (vpath.size() == 0) {
                        mp = MediaPlayer.create(getActivity(), Integer.parseInt(path.get(button.indexOf(6))));
                        mp.setLooping(true);
                        mp.seekTo(0);
                        mp.start();
                    } else {
                        try {
                            mp.setDataSource(vpath.get(0));
                            mp.setLooping(true);    //?�m�O�_�`?����
                            mp.prepare();
                            mp.start();

                        } catch (IllegalArgumentException e) {
                            e.printStackTrace();
                        } catch (IllegalStateException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    line2_button_left.setBackgroundResource(R.drawable.touchbutton20_ff3300);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_leftmid.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                            line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                            line3_button_leftmid.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                        }
                    }, 60);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line2_button_mid.setBackgroundResource(R.drawable.touchbutton22_ff0033);
                            line3_button_mid.setBackgroundResource(R.drawable.touchbutton22_ff0033);
                            line4_button_mid.setBackgroundResource(R.drawable.touchbutton22_ff0033);
                        }
                    }, 120);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_rightmid.setBackgroundResource(R.drawable.touchbutton23_ff0066);
                            line2_button_rightmid.setBackgroundResource(R.drawable.touchbutton23_ff0066);
                            line3_button_rightmid.setBackgroundResource(R.drawable.touchbutton23_ff0066);
                        }
                    }, 180);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line2_button_right.setBackgroundResource(R.drawable.touchbutton24_ff0099);
                        }
                    }, 240);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line2_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_right.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 540);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line2_button_left.setBackgroundResource(R.drawable.touchbutton20_ff3300);
                        }
                    }, 600);
                }
                else if (click_state_line2==1) {  //�_�Ӫ��ɭԫ�_�I���P�C��
                    if (vpath.size() == 0) {
                        mp.stop();
                        mp.reset();
                    } else {
                        mp.stop();
                        mp.reset();
                        vpath.removeAll(vpath);

                    }
                    line2_button_left.setBackgroundResource(R.drawable.touchbutton);
                }
                click_state_line2++;
                if(click_state_line2>1){
                    click_state_line2 = 0;
                }
            }
        });

        line3_button_left.setOnClickListener(new Button.OnClickListener() {
            MediaPlayer mp = new MediaPlayer();

            @Override
            public void onClick(View v) {
                if (click_state_line3==0) {
                    if (path.get(button.indexOf(12)).equals("0")) {
                        vpath.add(0, defaultPath);
                        Log.e("aa", "aa =  " + vpath.get(0));
                    }

                    if (vpath.size() == 0) {
                        mp = MediaPlayer.create(getActivity(), Integer.parseInt(path.get(button.indexOf(12))));
                        mp.setLooping(true);
                        mp.seekTo(0);
                        mp.start();
                    } else {
                        try {
                            mp.setDataSource(vpath.get(0));
                            mp.setLooping(true);    //?�m�O�_�`?����
                            mp.prepare();
                            mp.start();

                        } catch (IllegalArgumentException e) {
                            e.printStackTrace();
                        } catch (IllegalStateException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    line3_button_left.setBackgroundResource(R.drawable.touchbutton2_0033ff);
                    line3_button_leftmid.setBackgroundResource(R.drawable.touchbutton2_0033ff);
                    line3_button_mid.setBackgroundResource(R.drawable.touchbutton2_0033ff);
                    line2_button_mid.setBackgroundResource(R.drawable.touchbutton3_0066ff);
                    line1_button_mid.setBackgroundResource(R.drawable.touchbutton4_0099ff);
                    line1_button_leftmid.setBackgroundResource(R.drawable.touchbutton5_00ccff);
                    line2_button_left.setBackgroundResource(R.drawable.touchbutton6_00ffff);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line3_button_rightmid.setBackgroundResource(R.drawable.touchbutton3_0066ff);
                            line2_button_rightmid.setBackgroundResource(R.drawable.touchbutton4_0099ff);
                            line1_button_mid.setBackgroundResource(R.drawable.touchbutton5_00ccff);
                            line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton6_00ffff);
                            line1_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_left.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 60);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line3_button_right.setBackgroundResource(R.drawable.touchbutton4_0099ff);
                            line2_button_right.setBackgroundResource(R.drawable.touchbutton5_00ccff);
                            line1_button_rightmid.setBackgroundResource(R.drawable.touchbutton6_00ffff);
                            line2_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 120);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line3_button_rightover.setBackgroundResource(R.drawable.touchbutton5_00ccff);
                            line2_button_rightover.setBackgroundResource(R.drawable.touchbutton6_00ffff);
                            line2_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 180);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line3_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_right.setBackgroundResource(R.drawable.touchbutton5_00ccff);
                            line1_button_rightmid.setBackgroundResource(R.drawable.touchbutton6_00ffff);
                        }
                    }, 300);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line3_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_rightmid.setBackgroundResource(R.drawable.touchbutton4_0099ff);
                            line1_button_mid.setBackgroundResource(R.drawable.touchbutton5_00ccff);
                            line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton6_00ffff);
                        }
                    }, 360);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line3_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_mid.setBackgroundResource(R.drawable.touchbutton3_0066ff);
                            line1_button_mid.setBackgroundResource(R.drawable.touchbutton4_0099ff);
                            line1_button_leftmid.setBackgroundResource(R.drawable.touchbutton5_00ccff);
                            line2_button_left.setBackgroundResource(R.drawable.touchbutton6_00ffff);
                        }
                    }, 420);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_left.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 630);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line3_button_left.setBackgroundResource(R.drawable.touchbutton2_0033ff);
                        }
                    }, 690);
                }
                else if (click_state_line3==1) {  //�_�Ӫ��ɭԫ�_�I���P�C��
                    if (vpath.size() == 0) {
                        mp.stop();
                        mp.reset();
                    } else {
                        mp.stop();
                        mp.reset();
                        vpath.removeAll(vpath);

                    }
                    line3_button_left.setBackgroundResource(R.drawable.touchbutton);
                }
                click_state_line3++;
                if(click_state_line3>1){
                    click_state_line3 = 0;
                }
            }
        });

        line4_button_left.setOnClickListener(new Button.OnClickListener() {
            MediaPlayer mp = new MediaPlayer();

            @Override
            public void onClick(View v) {
                if (click_state_line4==0) {  //���U���ɭԧ��ܭI�����C��
                    if (path.get(button.indexOf(18)).equals("0")) {
                        vpath.add(0, defaultPath);
                        Log.e("aa", "aa =  " + vpath.get(0));
                    }

                    if (vpath.size() == 0) {
                        mp = MediaPlayer.create(getActivity(), Integer.parseInt(path.get(button.indexOf(18))));
                        mp.setLooping(true);
                        mp.seekTo(0);
                        mp.start();
                    } else {
                        try {
                            mp.setDataSource(vpath.get(0));
                            mp.setLooping(true);    //?�m�O�_�`?����
                            mp.prepare();
                            mp.start();

                        } catch (IllegalArgumentException e) {
                            e.printStackTrace();
                        } catch (IllegalStateException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    line4_button_left.setBackgroundResource(R.drawable.touchbuttonbright);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line3_button_leftmid.setBackgroundResource(R.drawable.touchbuttonbright);
                        }
                    }, 60);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line2_button_mid.setBackgroundResource(R.drawable.touchbuttonbright);
                        }
                    }, 120);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_rightmid.setBackgroundResource(R.drawable.touchbuttonbright);
                            line4_button_left.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 180);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line2_button_right.setBackgroundResource(R.drawable.touchbuttonbright);
                            line3_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 240);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line3_button_rightover.setBackgroundResource(R.drawable.touchbuttonbright);
                            line2_button_mid.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 300);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 360);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line2_button_right.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 420);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line3_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 480);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line4_button_left.setBackgroundResource(R.drawable.touchbuttonbright);
                        }
                    }, 540);
                }
                else if (click_state_line4==1) {  //�_�Ӫ��ɭԫ�_�I���P�C��
                    if (vpath.size() == 0) {
                        mp.stop();
                        mp.reset();
                    } else {
                        mp.stop();
                        mp.reset();
                        vpath.removeAll(vpath);

                    }
                    line4_button_left.setBackgroundResource(R.drawable.touchbutton);
                }
                click_state_line4++;
                if(click_state_line4>1){
                    click_state_line4 = 0;
                }
            }
        });

        line1_button_leftmid.setOnTouchListener(new Button.OnTouchListener() {
            MediaPlayer mp = new MediaPlayer();
            @Override
            public boolean onTouch(View arg0, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {  //���U���ɭԧ��ܭI�����C��
                    if(path.get(button.indexOf(1)).equals("0")){
                        vpath.add(0,defaultPath);
                        Log.e("aa", "aa =  " + vpath.get(0));
                    }

                    if(vpath.size()==0) {
                        mp = MediaPlayer.create(getActivity(), Integer.parseInt(path.get(button.indexOf(1))));
                        mp.seekTo(0);
                        mp.start();
                    }
                    else{
                        try {
                            mp.setDataSource(vpath.get(0));
                            mp.setLooping(false);	//?�m�O�_�`?����
                            mp.prepare();
                            mp.start();

                        } catch (IllegalArgumentException e) {
                            e.printStackTrace();
                        } catch (IllegalStateException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    line1_button_leftmid.setBackgroundResource(R.drawable.touchbutton26_ff00ff);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_left.setBackgroundResource(R.drawable.touchbutton27_cc00ff);
                            line1_button_mid.setBackgroundResource(R.drawable.touchbutton27_cc00ff);
                        }
                    }, 180);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_mid.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 360);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_left.setBackgroundResource(R.drawable.touchbutton27_cc00ff);
                            line1_button_leftmid.setBackgroundResource(R.drawable.touchbutton26_ff00ff);
                            line1_button_mid.setBackgroundResource(R.drawable.touchbutton27_cc00ff);
                            line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton27_cc00ff);
                        }
                    }, 540);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 720);
                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    if(vpath.size()==0) {
                        mp.stop();
                        mp.reset();
                    }
                    else{
                        mp.stop();
                        mp.reset();
                        vpath.removeAll(vpath);

                    }

                }
                return false;
            }
        });

        line2_button_leftmid.setOnTouchListener(new Button.OnTouchListener() {
            MediaPlayer mp = new MediaPlayer();
            @Override
            public boolean onTouch(View arg0, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {  //���U���ɭԧ��ܭI�����C��
                    if(path.get(button.indexOf(7)).equals("0")){
                        vpath.add(0,defaultPath);
                        Log.e("aa", "aa =  " + vpath.get(0));
                    }

                    if(vpath.size()==0) {
                        mp = MediaPlayer.create(getActivity(), Integer.parseInt(path.get(button.indexOf(7))));
                        mp.seekTo(0);
                        mp.start();
                    }
                    else{
                        try {
                            mp.setDataSource(vpath.get(0));
                            mp.setLooping(false);	//?�m�O�_�`?����
                            mp.prepare();
                            mp.start();

                        } catch (IllegalArgumentException e) {
                            e.printStackTrace();
                        } catch (IllegalStateException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line2_button_left.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                        }
                    }, 60);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_left.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                        }
                    }, 120);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_leftmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                        }
                    }, 180);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_mid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                        }
                    }, 240);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line2_button_mid.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                        }
                    }, 300);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line3_button_mid.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                        }
                    }, 360);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line3_button_leftmid.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                        }
                    }, 420);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line3_button_left.setBackgroundResource(R.drawable.touchbutton18_ff9900);
                        }
                    }, 480);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_mid.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 630);
                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {  //�_�Ӫ��ɭԫ�_�I���P�C��
                    if(vpath.size()==0) {
                        mp.stop();
                        mp.reset();
                    }
                    else{
                        mp.stop();
                        mp.reset();
                        vpath.removeAll(vpath);

                    }

                }
                return false;
            }
        });

        line3_button_leftmid.setOnTouchListener(new Button.OnTouchListener() {
            MediaPlayer mp = new MediaPlayer();
            @Override
            public boolean onTouch(View arg0, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {  //���U���ɭԧ��ܭI�����C��
                    if(path.get(button.indexOf(13)).equals("0")){
                        vpath.add(0,defaultPath);
                        Log.e("aa", "aa =  " + vpath.get(0));
                    }

                    if(vpath.size()==0) {
                        mp = MediaPlayer.create(getActivity(), Integer.parseInt(path.get(button.indexOf(13))));
                        mp.seekTo(0);
                        mp.start();
                    }
                    else{
                        try {
                            mp.setDataSource(vpath.get(0));
                            mp.setLooping(false);	//?�m�O�_�`?����
                            mp.prepare();
                            mp.start();

                        } catch (IllegalArgumentException e) {
                            e.printStackTrace();
                        } catch (IllegalStateException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    line3_button_leftmid.setBackgroundResource(R.drawable.touchbutton6_00ffff);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton7_00ffcc);
                            line4_button_leftmid.setBackgroundResource(R.drawable.touchbutton7_00ffcc);
                            line3_button_left.setBackgroundResource(R.drawable.touchbutton7_00ffcc);
                            line3_button_mid.setBackgroundResource(R.drawable.touchbutton7_00ffcc);
                        }
                    }, 60);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_leftmid.setBackgroundResource(R.drawable.touchbutton7_00ffcc);
                            line3_button_rightmid.setBackgroundResource(R.drawable.touchbutton7_00ffcc);
                        }
                    }, 120);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line3_button_right.setBackgroundResource(R.drawable.touchbutton8_00ff99);
                        }
                    }, 180);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line3_button_rightover.setBackgroundResource(R.drawable.touchbutton8_00ff99);
                        }
                    }, 240);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line3_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 540);
                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {  //�_�Ӫ��ɭԫ�_�I���P�C��
                    if(vpath.size()==0) {
                        mp.stop();
                        mp.reset();
                    }
                    else{
                        mp.stop();
                        mp.reset();
                        vpath.removeAll(vpath);

                    }

                }
                return false;
            }
        });

        line4_button_leftmid.setOnTouchListener(new Button.OnTouchListener() {
            MediaPlayer mp = new MediaPlayer();
            @Override
            public boolean onTouch(View arg0, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {  //���U���ɭԧ��ܭI�����C��
                    if(path.get(button.indexOf(19)).equals("0")){
                        vpath.add(0,defaultPath);
                        Log.e("aa", "aa =  " + vpath.get(0));
                    }

                    if(vpath.size()==0) {
                        mp = MediaPlayer.create(getActivity(), Integer.parseInt(path.get(button.indexOf(19))));
                        mp.seekTo(0);
                        mp.start();
                    }
                    else{
                        try {
                            mp.setDataSource(vpath.get(0));
                            mp.setLooping(false);	//?�m�O�_�`?����
                            mp.prepare();
                            mp.start();

                        } catch (IllegalArgumentException e) {
                            e.printStackTrace();
                        } catch (IllegalStateException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    line4_button_leftmid.setBackgroundResource(R.drawable.touchbutton20_ff3300);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line3_button_mid.setBackgroundResource(R.drawable.touchbutton19_ff6600);
                        }
                    }, 60);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line2_button_rightmid.setBackgroundResource(R.drawable.touchbutton18_ff9900);
                        }
                    }, 120);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_right.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                        }
                    }, 180);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_rightmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line2_button_right.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                        }
                    }, 240);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_mid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line3_button_right.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                        }
                    }, 300);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line4_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_right.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 540);
                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {  //�_�Ӫ��ɭԫ�_�I���P�C��
                    if(vpath.size()==0) {
                        mp.stop();
                        mp.reset();
                    }
                    else{
                        mp.stop();
                        mp.reset();
                        vpath.removeAll(vpath);

                    }

                }
                return false;
            }
        });

        line1_button_mid.setOnTouchListener(new Button.OnTouchListener() {
            MediaPlayer mp = new MediaPlayer();
            @Override
            public boolean onTouch(View arg0, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {  //���U���ɭԧ��ܭI�����C��
                    if(path.get(button.indexOf(2)).equals("0")){
                        vpath.add(0,defaultPath);
                        Log.e("aa", "aa =  " + vpath.get(0));
                    }

                    if(vpath.size()==0) {
                        mp = MediaPlayer.create(getActivity(), Integer.parseInt(path.get(button.indexOf(2))));
                        mp.seekTo(0);
                        mp.start();
                    }
                    else{
                        try {
                            mp.setDataSource(vpath.get(0));
                            mp.setLooping(false);	//?�m�O�_�`?����
                            mp.prepare();
                            mp.start();

                        } catch (IllegalArgumentException e) {
                            e.printStackTrace();
                        } catch (IllegalStateException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    line1_button_mid.setBackgroundResource(R.drawable.touchbutton26_ff00ff);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line2_button_mid.setBackgroundResource(R.drawable.touchbutton25_ff00cc);
                        }
                    }, 60);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line3_button_mid.setBackgroundResource(R.drawable.touchbutton24_ff0099);
                        }
                    }, 120);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line4_button_mid.setBackgroundResource(R.drawable.touchbutton23_ff0066);
                        }
                    }, 180);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line3_button_leftmid.setBackgroundResource(R.drawable.touchbutton22_ff0033);
                            line3_button_rightmid.setBackgroundResource(R.drawable.touchbutton22_ff0033);
                        }
                    }, 240);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line2_button_left.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                            line2_button_right.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                        }
                    }, 300);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line2_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_right.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 540);
                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {  //�_�Ӫ��ɭԫ�_�I���P�C��
                    if(vpath.size()==0) {
                        mp.stop();
                        mp.reset();
                    }
                    else{
                        mp.stop();
                        mp.reset();
                        vpath.removeAll(vpath);

                    }

                }
                return false;
            }
        });

        line2_button_mid.setOnTouchListener(new Button.OnTouchListener() {
            MediaPlayer mp = new MediaPlayer();
            @Override
            public boolean onTouch(View arg0, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {  //���U���ɭԧ��ܭI�����C��
                    if(path.get(button.indexOf(8)).equals("0")){
                        vpath.add(0,defaultPath);
                        Log.e("aa", "aa =  " + vpath.get(0));
                    }

                    if(vpath.size()==0) {
                        mp = MediaPlayer.create(getActivity(), Integer.parseInt(path.get(button.indexOf(8))));
                        mp.seekTo(0);
                        mp.start();
                    }
                    else{
                        try {
                            mp.setDataSource(vpath.get(0));
                            mp.setLooping(false);	//?�m�O�_�`?����
                            mp.prepare();
                            mp.start();

                        } catch (IllegalArgumentException e) {
                            e.printStackTrace();
                        } catch (IllegalStateException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    line2_button_mid.setBackgroundResource(R.drawable.touchbutton29_6600ff);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton29_6600ff);
                            line3_button_mid.setBackgroundResource(R.drawable.touchbutton30_3300ff);
                            line2_button_rightmid.setBackgroundResource(R.drawable.touchbutton29_6600ff);
                        }
                    }, 60);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line2_button_left.setBackgroundResource(R.drawable.touchbutton29_6600ff);
                            line2_button_right.setBackgroundResource(R.drawable.touchbutton29_6600ff);
                            line4_button_mid.setBackgroundResource(R.drawable.touchbutton1_0000ff);
                        }
                    }, 120);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line3_button_left.setBackgroundResource(R.drawable.touchbutton30_3300ff);
                            line3_button_right.setBackgroundResource(R.drawable.touchbutton30_3300ff);
                        }
                    }, 180);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line4_button_left.setBackgroundResource(R.drawable.touchbutton1_0000ff);
                            line4_button_right.setBackgroundResource(R.drawable.touchbutton1_0000ff);
                        }
                    }, 240);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line2_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_right.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 540);
                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {  //�_�Ӫ��ɭԫ�_�I���P�C��
                    if(vpath.size()==0) {
                        mp.stop();
                        mp.reset();
                    }
                    else{
                        mp.stop();
                        mp.reset();
                        vpath.removeAll(vpath);

                    }

                }
                return false;
            }
        });

        line3_button_mid.setOnTouchListener(new Button.OnTouchListener() {
            MediaPlayer mp = new MediaPlayer();
            @Override
            public boolean onTouch(View arg0, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {  //���U���ɭԧ��ܭI�����C��
                    if(path.get(button.indexOf(14)).equals("0")){
                        vpath.add(0,defaultPath);
                        Log.e("aa", "aa =  " + vpath.get(0));
                    }

                    if(vpath.size()==0) {
                        mp = MediaPlayer.create(getActivity(), Integer.parseInt(path.get(button.indexOf(14))));
                        mp.seekTo(0);
                        mp.start();
                    }
                    else{
                        try {
                            mp.setDataSource(vpath.get(0));
                            mp.setLooping(false);	//?�m�O�_�`?����
                            mp.prepare();
                            mp.start();

                        } catch (IllegalArgumentException e) {
                            e.printStackTrace();
                        } catch (IllegalStateException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    line3_button_mid.setBackgroundResource(R.drawable.touchbutton12_33ff00);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton13_66ff00);
                            line2_button_rightmid.setBackgroundResource(R.drawable.touchbutton13_66ff00);
                            line4_button_leftmid.setBackgroundResource(R.drawable.touchbutton13_66ff00);
                            line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton13_66ff00);
                        }
                    }, 90);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_left.setBackgroundResource(R.drawable.touchbutton14_99ff00);
                            line1_button_right.setBackgroundResource(R.drawable.touchbutton14_99ff00);
                        }
                    }, 180);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line3_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_right.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 450);
                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {  //�_�Ӫ��ɭԫ�_�I���P�C��
                    if(vpath.size()==0) {
                        mp.stop();
                        mp.reset();
                    }
                    else{
                        mp.stop();
                        mp.reset();
                        vpath.removeAll(vpath);

                    }

                }
                return false;
            }
        });

        line4_button_mid.setOnTouchListener(new Button.OnTouchListener() {
            MediaPlayer mp = new MediaPlayer();
            @Override
            public boolean onTouch(View arg0, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {  //���U���ɭԧ��ܭI�����C��
                    if(path.get(button.indexOf(20)).equals("0")){
                        vpath.add(0,defaultPath);
                        Log.e("aa", "aa =  " + vpath.get(0));
                    }

                    if(vpath.size()==0) {
                        mp = MediaPlayer.create(getActivity(), Integer.parseInt(path.get(button.indexOf(20))));
                        mp.seekTo(0);
                        mp.start();
                    }
                    else{
                        try {
                            mp.setDataSource(vpath.get(0));
                            mp.setLooping(false);	//?�m�O�_�`?����
                            mp.prepare();
                            mp.start();

                        } catch (IllegalArgumentException e) {
                            e.printStackTrace();
                        } catch (IllegalStateException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    line4_button_mid.setBackgroundResource(R.drawable.touchbutton18_ff9900);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line3_button_left.setBackgroundResource(R.drawable.touchbutton11_00ff00);
                            line3_button_leftmid.setBackgroundResource(R.drawable.touchbutton11_00ff00);
                            line3_button_mid.setBackgroundResource(R.drawable.touchbutton11_00ff00);
                            line3_button_rightmid.setBackgroundResource(R.drawable.touchbutton11_00ff00);
                            line3_button_right.setBackgroundResource(R.drawable.touchbutton11_00ff00);

                            line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton11_00ff00);
                            line2_button_mid.setBackgroundResource(R.drawable.touchbutton11_00ff00);
                            line2_button_rightmid.setBackgroundResource(R.drawable.touchbutton11_00ff00);

                            line1_button_mid.setBackgroundResource(R.drawable.touchbutton11_00ff00);
                        }
                    }, 60);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_rightmid.setBackgroundResource(R.drawable.touchbutton);

                            line1_button_mid.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 270);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton11_00ff00);
                            line2_button_mid.setBackgroundResource(R.drawable.touchbutton11_00ff00);
                            line2_button_rightmid.setBackgroundResource(R.drawable.touchbutton11_00ff00);
                        }
                    }, 360);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_mid.setBackgroundResource(R.drawable.touchbutton11_00ff00);
                        }
                    }, 450);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line4_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_mid.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 720);
                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {  //�_�Ӫ��ɭԫ�_�I���P�C��
                    if(vpath.size()==0) {
                        mp.stop();
                        mp.reset();
                    }
                    else{
                        mp.stop();
                        mp.reset();
                        vpath.removeAll(vpath);

                    }

                }
                return false;
            }
        });

        line1_button_rightmid.setOnTouchListener(new Button.OnTouchListener() {
            MediaPlayer mp = new MediaPlayer();
            @Override
            public boolean onTouch(View arg0, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {  //���U���ɭԧ��ܭI�����C��
                    if(path.get(button.indexOf(3)).equals("0")){
                        vpath.add(0,defaultPath);
                        Log.e("aa", "aa =  " + vpath.get(0));
                    }

                    if(vpath.size()==0) {
                        mp = MediaPlayer.create(getActivity(), Integer.parseInt(path.get(button.indexOf(3))));
                        mp.seekTo(0);
                        mp.start();
                    }
                    else{
                        try {
                            mp.setDataSource(vpath.get(0));
                            mp.setLooping(false);	//?�m�O�_�`?����
                            mp.prepare();
                            mp.start();

                        } catch (IllegalArgumentException e) {
                            e.printStackTrace();
                        } catch (IllegalStateException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    line1_button_rightmid.setBackgroundResource(R.drawable.touchbutton24_ff0099);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line2_button_right.setBackgroundResource(R.drawable.touchbutton24_ff0099);
                        }
                    }, 30);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line3_button_rightover.setBackgroundResource(R.drawable.touchbutton24_ff0099);
                        }
                    }, 60);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_leftmid.setBackgroundResource(R.drawable.touchbutton24_ff0099);
                        }
                    }, 90);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line2_button_mid.setBackgroundResource(R.drawable.touchbutton24_ff0099);
                        }
                    }, 120);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line3_button_rightmid.setBackgroundResource(R.drawable.touchbutton24_ff0099);
                        }
                    }, 150);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line4_button_right.setBackgroundResource(R.drawable.touchbutton24_ff0099);
                        }
                    }, 180);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line2_button_left.setBackgroundResource(R.drawable.touchbutton24_ff0099);
                        }
                    }, 210);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line3_button_leftmid.setBackgroundResource(R.drawable.touchbutton24_ff0099);
                        }
                    }, 240);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line4_button_mid.setBackgroundResource(R.drawable.touchbutton24_ff0099);
                        }
                    }, 270);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_mid.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 540);
                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {  //�_�Ӫ��ɭԫ�_�I���P�C��
                    if(vpath.size()==0) {
                        mp.stop();
                        mp.reset();
                    }
                    else{
                        mp.stop();
                        mp.reset();
                        vpath.removeAll(vpath);

                    }

                }
                return false;
            }
        });

        line2_button_rightmid.setOnTouchListener(new Button.OnTouchListener() {
            MediaPlayer mp = new MediaPlayer();
            @Override
            public boolean onTouch(View arg0, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {  //���U���ɭԧ��ܭI�����C��
                    if(path.get(button.indexOf(9)).equals("0")){
                        vpath.add(0,defaultPath);
                        Log.e("aa", "aa =  " + vpath.get(0));
                    }

                    if(vpath.size()==0) {
                        mp = MediaPlayer.create(getActivity(), Integer.parseInt(path.get(button.indexOf(9))));
                        mp.seekTo(0);
                        mp.start();
                    }
                    else{
                        try {
                            mp.setDataSource(vpath.get(0));
                            mp.setLooping(false);	//?�m�O�_�`?����
                            mp.prepare();
                            mp.start();

                        } catch (IllegalArgumentException e) {
                            e.printStackTrace();
                        } catch (IllegalStateException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    line2_button_rightmid.setBackgroundResource(R.drawable.touchbutton18_ff9900);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_mid.setBackgroundResource(R.drawable.touchbutton18_ff9900);
                            line1_button_rightmid.setBackgroundResource(R.drawable.touchbutton18_ff9900);
                            line1_button_right.setBackgroundResource(R.drawable.touchbutton18_ff9900);
                            line2_button_mid.setBackgroundResource(R.drawable.touchbutton18_ff9900);
                            line2_button_right.setBackgroundResource(R.drawable.touchbutton18_ff9900);
                            line3_button_mid.setBackgroundResource(R.drawable.touchbutton18_ff9900);
                            line3_button_rightmid.setBackgroundResource(R.drawable.touchbutton18_ff9900);
                            line3_button_right.setBackgroundResource(R.drawable.touchbutton18_ff9900);
                        }
                    }, 90);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_leftmid.setBackgroundResource(R.drawable.touchbutton19_ff6600);
                            line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton19_ff6600);
                            line3_button_leftmid.setBackgroundResource(R.drawable.touchbutton19_ff6600);
                            line4_button_leftmid.setBackgroundResource(R.drawable.touchbutton19_ff6600);
                            line4_button_mid.setBackgroundResource(R.drawable.touchbutton19_ff6600);
                            line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton19_ff6600);
                            line4_button_right.setBackgroundResource(R.drawable.touchbutton19_ff6600);
                            line1_button_rightover.setBackgroundResource(R.drawable.touchbutton19_ff6600);
                            line2_button_rightover.setBackgroundResource(R.drawable.touchbutton19_ff6600);
                            line3_button_rightover.setBackgroundResource(R.drawable.touchbutton19_ff6600);
                            line4_button_rightover.setBackgroundResource(R.drawable.touchbutton19_ff6600);
                        }
                    }, 180);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_left.setBackgroundResource(R.drawable.touchbutton20_ff3300);
                            line2_button_left.setBackgroundResource(R.drawable.touchbutton20_ff3300);
                            line3_button_left.setBackgroundResource(R.drawable.touchbutton20_ff3300);
                            line4_button_left.setBackgroundResource(R.drawable.touchbutton20_ff3300);
                        }
                    }, 270);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 540);
                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {  //�_�Ӫ��ɭԫ�_�I���P�C��
                    if(vpath.size()==0) {
                        mp.stop();
                        mp.reset();
                    }
                    else{
                        mp.stop();
                        mp.reset();
                        vpath.removeAll(vpath);

                    }

                }
                return false;
            }
        });

        line3_button_rightmid.setOnTouchListener(new Button.OnTouchListener() {
            MediaPlayer mp = new MediaPlayer();
            @Override
            public boolean onTouch(View arg0, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {  //���U���ɭԧ��ܭI�����C��
                    if(path.get(button.indexOf(15)).equals("0")){
                        vpath.add(0,defaultPath);
                        Log.e("aa", "aa =  " + vpath.get(0));
                    }

                    if(vpath.size()==0) {
                        mp = MediaPlayer.create(getActivity(), Integer.parseInt(path.get(button.indexOf(15))));
                        mp.seekTo(0);
                        mp.start();
                    }
                    else{
                        try {
                            mp.setDataSource(vpath.get(0));
                            mp.setLooping(false);	//?�m�O�_�`?����
                            mp.prepare();
                            mp.start();

                        } catch (IllegalArgumentException e) {
                            e.printStackTrace();
                        } catch (IllegalStateException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    line3_button_rightmid.setBackgroundResource(R.drawable.touchbutton2_0033ff);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line2_button_rightmid.setBackgroundResource(R.drawable.touchbutton3_0066ff);
                            line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton3_0066ff);
                        }
                    }, 60);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_rightmid.setBackgroundResource(R.drawable.touchbutton4_0099ff);
                        }
                    }, 120);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line3_button_mid.setBackgroundResource(R.drawable.touchbutton2_0033ff);
                            line3_button_right.setBackgroundResource(R.drawable.touchbutton2_0033ff);
                        }
                    }, 180);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line2_button_mid.setBackgroundResource(R.drawable.touchbutton3_0066ff);
                            line2_button_right.setBackgroundResource(R.drawable.touchbutton3_0066ff);
                            line4_button_mid.setBackgroundResource(R.drawable.touchbutton3_0066ff);
                            line4_button_right.setBackgroundResource(R.drawable.touchbutton3_0066ff);
                        }
                    }, 240);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_mid.setBackgroundResource(R.drawable.touchbutton4_0099ff);
                            line1_button_right.setBackgroundResource(R.drawable.touchbutton4_0099ff);
                        }
                    }, 300);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_right.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 540);
                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {  //�_�Ӫ��ɭԫ�_�I���P�C��
                    if(vpath.size()==0) {
                        mp.stop();
                        mp.reset();
                    }
                    else{
                        mp.stop();
                        mp.reset();
                        vpath.removeAll(vpath);

                    }

                }
                return false;
            }
        });

        line4_button_rightmid.setOnTouchListener(new Button.OnTouchListener() {
            MediaPlayer mp = new MediaPlayer();
            @Override
            public boolean onTouch(View arg0, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {  //���U���ɭԧ��ܭI�����C��
                    if(path.get(button.indexOf(21)).equals("0")){
                        vpath.add(0,defaultPath);
                        Log.e("aa", "aa =  " + vpath.get(0));
                    }

                    if(vpath.size()==0) {
                        mp = MediaPlayer.create(getActivity(), Integer.parseInt(path.get(button.indexOf(21))));
                        mp.seekTo(0);
                        mp.start();
                    }
                    else{
                        try {
                            mp.setDataSource(vpath.get(0));
                            mp.setLooping(false);	//?�m�O�_�`?����
                            mp.prepare();
                            mp.start();

                        } catch (IllegalArgumentException e) {
                            e.printStackTrace();
                        } catch (IllegalStateException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton23_ff0066);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_left.setBackgroundResource(R.drawable.touchbutton23_ff0066);
                            line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton23_ff0066);
                            line3_button_mid.setBackgroundResource(R.drawable.touchbutton23_ff0066);
                            line3_button_right.setBackgroundResource(R.drawable.touchbutton23_ff0066);
                            line2_button_rightover.setBackgroundResource(R.drawable.touchbutton23_ff0066);
                        }
                    }, 90);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line2_button_left.setBackgroundResource(R.drawable.touchbutton24_ff0099);
                            line3_button_leftmid.setBackgroundResource(R.drawable.touchbutton24_ff0099);
                            line4_button_mid.setBackgroundResource(R.drawable.touchbutton24_ff0099);
                            line4_button_right.setBackgroundResource(R.drawable.touchbutton24_ff0099);
                            line3_button_rightover.setBackgroundResource(R.drawable.touchbutton24_ff0099);
                        }
                    }, 180);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line3_button_left.setBackgroundResource(R.drawable.touchbutton25_ff00cc);
                            line4_button_leftmid.setBackgroundResource(R.drawable.touchbutton25_ff00cc);
                            line4_button_rightover.setBackgroundResource(R.drawable.touchbutton25_ff00cc);
                        }
                    }, 270);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line4_button_left.setBackgroundResource(R.drawable.touchbutton26_ff00ff);
                        }
                    }, 360);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_left.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 630);
                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {  //�_�Ӫ��ɭԫ�_�I���P�C��
                    if(vpath.size()==0) {
                        mp.stop();
                        mp.reset();
                    }
                    else{
                        mp.stop();
                        mp.reset();
                        vpath.removeAll(vpath);

                    }

                }
                return false;
            }
        });

        line1_button_right.setOnTouchListener(new Button.OnTouchListener() {
            MediaPlayer mp = new MediaPlayer();
            @Override
            public boolean onTouch(View arg0, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {  //���U���ɭԧ��ܭI�����C��
                    if(path.get(button.indexOf(4)).equals("0")){
                        vpath.add(0,defaultPath);
                        Log.e("aa", "aa =  " + vpath.get(0));
                    }

                    if(vpath.size()==0) {
                        mp = MediaPlayer.create(getActivity(), Integer.parseInt(path.get(button.indexOf(4))));
                        mp.seekTo(0);
                        mp.start();
                    }
                    else{
                        try {
                            mp.setDataSource(vpath.get(0));
                            mp.setLooping(false);	//?�m�O�_�`?����
                            mp.prepare();
                            mp.start();

                        } catch (IllegalArgumentException e) {
                            e.printStackTrace();
                        } catch (IllegalStateException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    line1_button_right.setBackgroundResource(R.drawable.touchbutton14_99ff00);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_rightmid.setBackgroundResource(R.drawable.touchbutton14_99ff00);
                        }
                    }, 30);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_mid.setBackgroundResource(R.drawable.touchbutton14_99ff00);
                        }
                    }, 60);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_leftmid.setBackgroundResource(R.drawable.touchbutton14_99ff00);
                        }
                    }, 90);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_left.setBackgroundResource(R.drawable.touchbutton14_99ff00);
                        }
                    }, 120);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line2_button_left.setBackgroundResource(R.drawable.touchbutton14_99ff00);
                        }
                    }, 150);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line3_button_left.setBackgroundResource(R.drawable.touchbutton14_99ff00);
                        }
                    }, 180);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line4_button_left.setBackgroundResource(R.drawable.touchbutton15_ccff00);
                        }
                    }, 210);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line4_button_leftmid.setBackgroundResource(R.drawable.touchbutton15_ccff00);
                        }
                    }, 240);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line4_button_mid.setBackgroundResource(R.drawable.touchbutton15_ccff00);
                        }
                    }, 270);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton15_ccff00);
                        }
                    }, 300);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line4_button_right.setBackgroundResource(R.drawable.touchbutton15_ccff00);
                        }
                    }, 330);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line4_button_rightover.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                        }
                    }, 360);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line3_button_rightover.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                        }
                    }, 390);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line2_button_rightover.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                        }
                    }, 420);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_rightover.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                        }
                    }, 450);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 530);
                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {  //�_�Ӫ��ɭԫ�_�I���P�C��
                    if(vpath.size()==0) {
                        mp.stop();
                        mp.reset();
                    }
                    else{
                        mp.stop();
                        mp.reset();
                        vpath.removeAll(vpath);

                    }

                }
                return false;
            }
        });

        line2_button_right.setOnTouchListener(new Button.OnTouchListener() {
            MediaPlayer mp = new MediaPlayer();
            @Override
            public boolean onTouch(View arg0, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {  //���U���ɭԧ��ܭI�����C��
                    if(path.get(button.indexOf(10)).equals("0")){
                        vpath.add(0,defaultPath);
                        Log.e("aa", "aa =  " + vpath.get(0));
                    }

                    if(vpath.size()==0) {
                        mp = MediaPlayer.create(getActivity(), Integer.parseInt(path.get(button.indexOf(10))));
                        mp.seekTo(0);
                        mp.start();
                    }
                    else{
                        try {
                            mp.setDataSource(vpath.get(0));
                            mp.setLooping(false);	//?�m�O�_�`?����
                            mp.prepare();
                            mp.start();

                        } catch (IllegalArgumentException e) {
                            e.printStackTrace();
                        } catch (IllegalStateException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    line2_button_right.setBackgroundResource(R.drawable.touchbutton26_ff00ff);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_right.setBackgroundResource(R.drawable.touchbutton26_ff00ff);
                            line2_button_rightmid.setBackgroundResource(R.drawable.touchbutton26_ff00ff);
                            line2_button_rightover.setBackgroundResource(R.drawable.touchbutton26_ff00ff);
                            line3_button_right.setBackgroundResource(R.drawable.touchbutton26_ff00ff);
                        }
                    }, 90);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line2_button_mid.setBackgroundResource(R.drawable.touchbutton27_cc00ff);
                        }
                    }, 180);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_mid.setBackgroundResource(R.drawable.touchbutton27_cc00ff);
                            line3_button_mid.setBackgroundResource(R.drawable.touchbutton27_cc00ff);
                            line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton27_cc00ff);
                        }
                    }, 270);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 540);
                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {  //�_�Ӫ��ɭԫ�_�I���P�C��
                    if(vpath.size()==0) {
                        mp.stop();
                        mp.reset();
                    }
                    else{
                        mp.stop();
                        mp.reset();
                        vpath.removeAll(vpath);

                    }

                }
                return false;
            }
        });

        line3_button_right.setOnTouchListener(new Button.OnTouchListener() {
            MediaPlayer mp =new MediaPlayer();
            @Override
            public boolean onTouch(View arg0, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {  //���U���ɭԧ��ܭI�����C��
                    if(path.get(button.indexOf(16)).equals("0")){
                        vpath.add(0,defaultPath);
                        Log.e("aa", "aa =  " + vpath.get(0));
                    }

                    if(vpath.size()==0) {
                        mp = MediaPlayer.create(getActivity(), Integer.parseInt(path.get(button.indexOf(16))));
                        mp.seekTo(0);
                        mp.start();
                    }
                    else{
                        try {
                            mp.setDataSource(vpath.get(0));
                            mp.setLooping(false);	//?�m�O�_�`?����
                            mp.prepare();
                            mp.start();

                        } catch (IllegalArgumentException e) {
                            e.printStackTrace();
                        } catch (IllegalStateException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    line3_button_right.setBackgroundResource(R.drawable.touchbutton7_00ffcc);
                    line3_button_rightmid.setBackgroundResource(R.drawable.touchbutton7_00ffcc);
                    line3_button_rightover.setBackgroundResource(R.drawable.touchbutton7_00ffcc);
                    line2_button_right.setBackgroundResource(R.drawable.touchbutton7_00ffcc);
                    line2_button_rightmid.setBackgroundResource(R.drawable.touchbutton7_00ffcc);
                    line2_button_rightover.setBackgroundResource(R.drawable.touchbutton7_00ffcc);
                    line4_button_right.setBackgroundResource(R.drawable.touchbutton7_00ffcc);
                    line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton7_00ffcc);
                    line4_button_rightover.setBackgroundResource(R.drawable.touchbutton7_00ffcc);
                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {  //�_�Ӫ��ɭԫ�_�I���P�C��
                    if(vpath.size()==0) {
                        mp.stop();
                        mp.reset();
                    }
                    else{
                        mp.stop();
                        mp.reset();
                        vpath.removeAll(vpath);

                    }
                    line3_button_right.setBackgroundResource(R.drawable.touchbutton);
                    line3_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                    line3_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                    line2_button_right.setBackgroundResource(R.drawable.touchbutton);
                    line2_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                    line2_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                    line4_button_right.setBackgroundResource(R.drawable.touchbutton);
                    line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                    line4_button_rightover.setBackgroundResource(R.drawable.touchbutton);

                }
                return false;
            }
        });

        line4_button_right.setOnTouchListener(new Button.OnTouchListener() {
            MediaPlayer mp = new MediaPlayer();
            @Override
            public boolean onTouch(View arg0, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {  //���U���ɭԧ��ܭI�����C��
                    if(path.get(button.indexOf(22)).equals("0")){
                        vpath.add(0,defaultPath);
                        Log.e("aa", "aa =  " + vpath.get(0));
                    }

                    if(vpath.size()==0) {
                        mp = MediaPlayer.create(getActivity(), Integer.parseInt(path.get(button.indexOf(22))));
                        mp.seekTo(0);
                        mp.start();
                    }
                    else{
                        try {
                            mp.setDataSource(vpath.get(0));
                            mp.setLooping(false);	//?�m�O�_�`?����
                            mp.prepare();
                            mp.start();

                        } catch (IllegalArgumentException e) {
                            e.printStackTrace();
                        } catch (IllegalStateException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    line4_button_right.setBackgroundResource(R.drawable.touchbutton6_00ffff);
                    line2_button_left.setBackgroundResource(R.drawable.touchbutton6_00ffff);
                    line4_button_left.setBackgroundResource(R.drawable.touchbutton6_00ffff);
                    line1_button_leftmid.setBackgroundResource(R.drawable.touchbutton6_00ffff);
                    line3_button_leftmid.setBackgroundResource(R.drawable.touchbutton6_00ffff);
                    line2_button_mid.setBackgroundResource(R.drawable.touchbutton6_00ffff);
                    line4_button_mid.setBackgroundResource(R.drawable.touchbutton6_00ffff);
                    line1_button_rightmid.setBackgroundResource(R.drawable.touchbutton6_00ffff);
                    line3_button_rightmid.setBackgroundResource(R.drawable.touchbutton6_00ffff);
                    line2_button_right.setBackgroundResource(R.drawable.touchbutton6_00ffff);
                    line1_button_rightover.setBackgroundResource(R.drawable.touchbutton6_00ffff);
                    line3_button_rightover.setBackgroundResource(R.drawable.touchbutton6_00ffff);
                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {  //�_�Ӫ��ɭԫ�_�I���P�C��
                    if(vpath.size()==0) {
                        mp.stop();
                        mp.reset();
                    }
                    else{
                        mp.stop();
                        mp.reset();
                        vpath.removeAll(vpath);

                    }
                    line2_button_left.setBackgroundResource(R.drawable.touchbutton);
                    line4_button_left.setBackgroundResource(R.drawable.touchbutton);
                    line1_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                    line3_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                    line2_button_mid.setBackgroundResource(R.drawable.touchbutton);
                    line4_button_mid.setBackgroundResource(R.drawable.touchbutton);
                    line1_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                    line3_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                    line2_button_right.setBackgroundResource(R.drawable.touchbutton);
                    line4_button_right.setBackgroundResource(R.drawable.touchbutton);
                    line1_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                    line3_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                }
                return false;
            }
        });

        line1_button_rightover.setOnTouchListener(new Button.OnTouchListener() {
            MediaPlayer mp = new MediaPlayer();
            @Override
            public boolean onTouch(View arg0, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {  //���U���ɭԧ��ܭI�����C��
                    /*if(path.get(button.indexOf(5)).equals("0")){
                        vpath.add(0,defaultPath);
                        Log.e("aa", "aa =  " + vpath.get(0));
                    }

                    if(vpath.size()==0) {
                        mp = MediaPlayer.create(getActivity(), Integer.parseInt(path.get(button.indexOf(5))));
                        mp.seekTo(0);
                        mp.start();
                    }
                    else{
                        try {
                            mp.setDataSource(vpath.get(0));
                            mp.setLooping(false);	//?�m�O�_�`?����
                            mp.prepare();
                            mp.start();

                        } catch (IllegalArgumentException e) {
                            e.printStackTrace();
                        } catch (IllegalStateException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }*/
                    line1_button_rightover.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                    //�ŧi�@��Handler
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_right.setBackgroundResource(R.drawable.touchbutton24_ff0099);
                            line2_button_rightover.setBackgroundResource(R.drawable.touchbutton24_ff0099);
                        }
                    }, 30);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_rightmid.setBackgroundResource(R.drawable.touchbutton26_ff00ff);
                            line2_button_right.setBackgroundResource(R.drawable.touchbutton26_ff00ff);
                            line3_button_rightover.setBackgroundResource(R.drawable.touchbutton26_ff00ff);
                        }
                    }, 60);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_mid.setBackgroundResource(R.drawable.touchbutton28_9900ff);
                            line2_button_rightmid.setBackgroundResource(R.drawable.touchbutton28_9900ff);
                            line3_button_right.setBackgroundResource(R.drawable.touchbutton28_9900ff);
                            line4_button_rightover.setBackgroundResource(R.drawable.touchbutton28_9900ff);
                        }
                    }, 90);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_leftmid.setBackgroundResource(R.drawable.touchbutton1_0000ff);
                            line2_button_mid.setBackgroundResource(R.drawable.touchbutton1_0000ff);
                            line3_button_rightmid.setBackgroundResource(R.drawable.touchbutton1_0000ff);
                            line4_button_right.setBackgroundResource(R.drawable.touchbutton1_0000ff);
                        }
                    }, 120);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_left.setBackgroundResource(R.drawable.touchbutton4_0099ff);
                            line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton4_0099ff);
                            line3_button_mid.setBackgroundResource(R.drawable.touchbutton4_0099ff);
                            line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton4_0099ff);
                        }
                    }, 150);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line2_button_left.setBackgroundResource(R.drawable.touchbutton6_00ffff);
                            line3_button_leftmid.setBackgroundResource(R.drawable.touchbutton6_00ffff);
                            line4_button_mid.setBackgroundResource(R.drawable.touchbutton6_00ffff);
                        }
                    }, 180);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line3_button_left.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line4_button_leftmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                        }
                    }, 210);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line4_button_left.setBackgroundResource(R.drawable.touchbutton12_33ff00);
                        }
                    }, 240);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 540);
                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {  //�_�Ӫ��ɭԫ�_�I���P�C��
                    if(vpath.size()==0) {
                        mp.stop();
                        mp.reset();
                    }
                    else{
                        mp.stop();
                        mp.reset();
                        vpath.removeAll(vpath);

                    }

                }
                return false;
            }
        });

        line2_button_rightover.setOnTouchListener(new Button.OnTouchListener() {
            MediaPlayer mp = new MediaPlayer();
            @Override
            public boolean onTouch(View arg0, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {  //���U���ɭԧ��ܭI�����C��
                    if(path.get(button.indexOf(11)).equals("0")){
                        vpath.add(0,defaultPath);
                        Log.e("aa", "aa =  " + vpath.get(0));
                    }

                    if(vpath.size()==0) {
                        mp = MediaPlayer.create(getActivity(), Integer.parseInt(path.get(button.indexOf(11))));
                        mp.seekTo(0);
                        mp.start();
                    }
                    else{
                        try {
                            mp.setDataSource(vpath.get(0));
                            mp.setLooping(false);	//?�m�O�_�`?����
                            mp.prepare();
                            mp.start();

                        } catch (IllegalArgumentException e) {
                            e.printStackTrace();
                        } catch (IllegalStateException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    line2_button_rightover.setBackgroundResource(R.drawable.touchbutton6_00ffff);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line2_button_right.setBackgroundResource(R.drawable.touchbutton6_00ffff);
                        }
                    }, 30);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line2_button_rightmid.setBackgroundResource(R.drawable.touchbutton6_00ffff);
                        }
                    }, 60);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line2_button_mid.setBackgroundResource(R.drawable.touchbutton7_00ffcc);
                        }
                    }, 90);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton7_00ffcc);
                        }
                    }, 120);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line2_button_left.setBackgroundResource(R.drawable.touchbutton7_00ffcc);
                        }
                    }, 150);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line2_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 180);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line2_button_right.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 210);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line2_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 240);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line2_button_mid.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 270);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 300);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line2_button_left.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 330);
                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {  //�_�Ӫ��ɭԫ�_�I���P�C��
                    if(vpath.size()==0) {
                        mp.stop();
                        mp.reset();
                    }
                    else{
                        mp.stop();
                        mp.reset();
                        vpath.removeAll(vpath);

                    }

                }
                return false;
            }
        });

        line3_button_rightover.setOnTouchListener(new Button.OnTouchListener() {
            MediaPlayer mp = new MediaPlayer();
            @Override
            public boolean onTouch(View arg0, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {  //���U���ɭԧ��ܭI�����C��
                    if(path.get(button.indexOf(17)).equals("0")){
                        vpath.add(0,defaultPath);
                        Log.e("aa", "aa =  " + vpath.get(0));
                    }

                    if(vpath.size()==0) {
                        mp = MediaPlayer.create(getActivity(), Integer.parseInt(path.get(button.indexOf(17))));
                        mp.seekTo(0);
                        mp.start();
                    }
                    else{
                        try {
                            mp.setDataSource(vpath.get(0));
                            mp.setLooping(false);	//?�m�O�_�`?����
                            mp.prepare();
                            mp.start();

                        } catch (IllegalArgumentException e) {
                            e.printStackTrace();
                        } catch (IllegalStateException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    line3_button_rightover.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line3_button_right.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                        }
                    }, 30);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line3_button_rightmid.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                        }
                    }, 60);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line3_button_mid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                        }
                    }, 90);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line3_button_leftmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                        }
                    }, 120);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line3_button_left.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                        }
                    }, 150);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line3_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 180);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line3_button_right.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 210);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line3_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 240);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line3_button_mid.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 270);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line3_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 300);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line3_button_left.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 330);
                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {  //�_�Ӫ��ɭԫ�_�I���P�C��
                    if(vpath.size()==0) {
                        mp.stop();
                        mp.reset();
                    }
                    else{
                        mp.stop();
                        mp.reset();
                        vpath.removeAll(vpath);

                    }

                }
                return false;
            }
        });

        line4_button_rightover.setOnTouchListener(new Button.OnTouchListener() {
            MediaPlayer mp = new MediaPlayer();
            @Override
            public boolean onTouch(View arg0, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {  //���U���ɭԧ��ܭI�����C��
                    if(path.get(button.indexOf(23)).equals("0")){
                        vpath.add(0,defaultPath);
                        Log.e("aa", "aa =  " + vpath.get(0));
                    }

                    if(vpath.size()==0) {
                        mp = MediaPlayer.create(getActivity(), Integer.parseInt(path.get(button.indexOf(23))));
                        mp.seekTo(0);
                        mp.start();
                    }
                    else{
                        try {
                            mp.setDataSource(vpath.get(0));
                            mp.setLooping(false);	//?�m�O�_�`?����
                            mp.prepare();
                            mp.start();

                        } catch (IllegalArgumentException e) {
                            e.printStackTrace();
                        } catch (IllegalStateException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    line4_button_rightover.setBackgroundResource(R.drawable.touchbutton25_ff00cc);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line4_button_right.setBackgroundResource(R.drawable.touchbutton25_ff00cc);
                        }
                    }, 30);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton25_ff00cc);
                        }
                    }, 60);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line4_button_mid.setBackgroundResource(R.drawable.touchbutton26_ff00ff);
                        }
                    }, 90);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line4_button_leftmid.setBackgroundResource(R.drawable.touchbutton26_ff00ff);
                        }
                    }, 120);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line4_button_left.setBackgroundResource(R.drawable.touchbutton26_ff00ff);
                        }
                    }, 150);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line4_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 180);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line4_button_right.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 210);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 240);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line4_button_mid.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 270);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line4_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 300);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line4_button_left.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 330);
                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {  //�_�Ӫ��ɭԫ�_�I���P�C��
                    if(vpath.size()==0) {
                        mp.stop();
                        mp.reset();
                    }
                    else{
                        mp.stop();
                        mp.reset();
                        vpath.removeAll(vpath);

                    }

                }
                return false;
            }
        });
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.framechoose_1, container, false);
        line1_button_left = (Button) view.findViewById(R.id.line1_button_left); // '��0��img_button
        line1_button_leftmid = (Button) view.findViewById(R.id.line1_button_leftmid); // '��0��img_button
        line1_button_mid = (Button) view.findViewById(R.id.line1_button_mid); // '��0��img_button
        line1_button_rightmid = (Button) view.findViewById(R.id. line1_button_rightmid); // '��0��img_button
        line1_button_right = (Button) view.findViewById(R.id. line1_button_right); // '��0��img_button
        line1_button_rightover = (Button) view.findViewById(R.id. line1_button_rightover); // '��0��img_button
        line2_button_left = (Button) view.findViewById(R.id.line2_button_left); // '��0��img_button
        line2_button_leftmid = (Button) view.findViewById(R.id.line2_button_leftmid); // '��0��img_button
        line2_button_mid = (Button) view.findViewById(R.id.line2_button_mid); // '��0��img_button
        line2_button_rightmid = (Button) view.findViewById(R.id. line2_button_rightmid); // '��0��img_button
        line2_button_right = (Button) view.findViewById(R.id. line2_button_right); // '��0��img_button
        line2_button_rightover = (Button) view.findViewById(R.id. line2_button_rightover); // '��0��img_button
        line3_button_left = (Button) view.findViewById(R.id.line3_button_left); // '��0��img_button
        line3_button_leftmid = (Button) view.findViewById(R.id.line3_button_leftmid); // '��0��img_button
        line3_button_mid = (Button) view.findViewById(R.id.line3_button_mid); // '��0��img_button
        line3_button_rightmid = (Button) view.findViewById(R.id. line3_button_rightmid); // '��0��img_button
        line3_button_right = (Button) view.findViewById(R.id. line3_button_right); // '��0��img_button
        line3_button_rightover = (Button) view.findViewById(R.id. line3_button_rightover); // '��0��img_button
        line4_button_left = (Button) view.findViewById(R.id.line4_button_left); // '��0��img_button
        line4_button_leftmid = (Button) view.findViewById(R.id.line4_button_leftmid); // '��0��img_button
        line4_button_mid = (Button) view.findViewById(R.id.line4_button_mid); // '��0��img_button
        line4_button_rightmid = (Button) view.findViewById(R.id. line4_button_rightmid); // '��0��img_button
        line4_button_right = (Button) view.findViewById(R.id. line4_button_right); // '��0��img_button
        line4_button_rightover = (Button) view.findViewById(R.id. line4_button_rightover); // '��0��img_button

        return view;
    }

}
