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

import android.widget.Toast;

import java.util.ArrayList;

public class frg_animation_basic extends Fragment {

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
    /******/
    private int click_state_line1 = 0;
    private int click_state_line2 = 0;
    private int click_state_line3 = 0;
    private int click_state_line4 = 0;
    private int it;
    private int item;
    private DatabaseHelper mOpenHelper;
    private SQLiteDatabase db;
    public static final String TABLE_NAME_Recordmusic = "recordmusic";
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
            final Cursor c = db.rawQuery("SELECT * FROM " + TABLE_NAME_Recordmusic + " WHERE fragement = " + 0, null);
            c.moveToFirst();
            for (int i = 0; i < c.getCount(); i++) {
                no.add(c.getInt(1));
                path.add(c.getString(2));
                frg.add(c.getInt(3));
                button.add(c.getInt(4));
                c.moveToNext();
            }
        } catch (Exception e) {

        }
        line1_button_left.setOnClickListener(new Button.OnClickListener() {
            MediaPlayer mp = new MediaPlayer();

            @Override
            public void onClick(View v) {
                if (click_state_line1 == 0) {  //  ���U���ɭԧ��ܭI�����C��

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
                    Toast.makeText(getActivity(), "Song:" + path.get(button.indexOf(0)), Toast.LENGTH_SHORT).show();
                    line1_button_left.setBackgroundResource(R.drawable.touchbutton16_ffff00);

                } else if (click_state_line1 == 1) {  //�_�Ӫ��ɭԫ�_�I���P�C��
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
                if (click_state_line1 > 1) {
                    click_state_line1 = 0;
                }
            }
        });

        line2_button_left.setOnClickListener(new Button.OnClickListener() {
            MediaPlayer mp = new MediaPlayer();

            @Override
            public void onClick(View v) {
                if (click_state_line2 == 0) {

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
                    line2_button_left.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                } else if (click_state_line2 == 1) {  //�_�Ӫ��ɭԫ�_�I���P�C��
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
                if (click_state_line2 > 1) {
                    click_state_line2 = 0;
                }
            }
        });

        line3_button_left.setOnClickListener(new Button.OnClickListener() {
            MediaPlayer mp = new MediaPlayer();

            @Override
            public void onClick(View v) {
                if (click_state_line3 == 0) {
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
                    line3_button_left.setBackgroundResource(R.drawable.touchbutton16_ffff00);//���U���ɭԧ��ܭI�����C��
                } else if (click_state_line3 == 1) {  //�_�Ӫ��ɭԫ�_�I���P�C��
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
                if (click_state_line3 > 1) {
                    click_state_line3 = 0;
                }
            }
        });

        line4_button_left.setOnClickListener(new Button.OnClickListener() {
            MediaPlayer mp = new MediaPlayer();

            @Override
            public void onClick(View v) {
                if (click_state_line4 == 0) {  //���U���ɭԧ��ܭI�����C��
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
                    line4_button_left.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                } else if (click_state_line4 == 1) {  //�_�Ӫ��ɭԫ�_�I���P�C��
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
                if (click_state_line4 > 1) {
                    click_state_line4 = 0;
                }
            }
        });

        line1_button_leftmid.setOnTouchListener(new Button.OnTouchListener() {
            MediaPlayer mp = new MediaPlayer();

            @Override
            public boolean onTouch(View arg0, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {  //���U���ɭԧ��ܭI�����C��
                    if (path.get(button.indexOf(1)).equals("0")) {
                        vpath.add(0, defaultPath);
                        Log.e("aa", "aa =  " + vpath.get(0));
                    }

                    if (vpath.size() == 0) {
                        mp = MediaPlayer.create(getActivity(), Integer.parseInt(path.get(button.indexOf(1))));
                        mp.seekTo(0);
                        mp.start();
                    } else {
                        try {
                            mp.setDataSource(vpath.get(0));
                            mp.setLooping(false);    //?�m�O�_�`?����
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
                    line1_button_leftmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    if (vpath.size() == 0) {
                        mp.stop();
                        mp.reset();
                    } else {
                        mp.stop();
                        mp.reset();
                        vpath.removeAll(vpath);

                    }
                    line1_button_leftmid.setBackgroundResource(R.drawable.touchbutton);//�_�Ӫ��ɭԫ�_�I���P�C��
                }
                return false;
            }
        });

        line2_button_leftmid.setOnTouchListener(new Button.OnTouchListener() {
            MediaPlayer mp = new MediaPlayer();

            @Override
            public boolean onTouch(View arg0, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {  //���U���ɭԧ��ܭI�����C��
                    if (path.get(button.indexOf(7)).equals("0")) {
                        vpath.add(0, defaultPath);
                        Log.e("aa", "aa =  " + vpath.get(0));
                    }

                    if (vpath.size() == 0) {
                        mp = MediaPlayer.create(getActivity(), Integer.parseInt(path.get(button.indexOf(7))));
                        mp.seekTo(0);
                        mp.start();
                    } else {
                        try {
                            mp.setDataSource(vpath.get(0));
                            mp.setLooping(false);    //?�m�O�_�`?����
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
                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {  //�_�Ӫ��ɭԫ�_�I���P�C��
                    if (vpath.size() == 0) {
                        mp.stop();
                        mp.reset();
                    } else {
                        mp.stop();
                        mp.reset();
                        vpath.removeAll(vpath);

                    }
                    line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                }
                return false;
            }
        });

        line3_button_leftmid.setOnTouchListener(new Button.OnTouchListener() {
            MediaPlayer mp = new MediaPlayer();

            @Override
            public boolean onTouch(View arg0, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {  //���U���ɭԧ��ܭI�����C��
                    if (path.get(button.indexOf(13)).equals("0")) {
                        vpath.add(0, defaultPath);
                        Log.e("aa", "aa =  " + vpath.get(0));
                    }

                    if (vpath.size() == 0) {
                        mp = MediaPlayer.create(getActivity(), Integer.parseInt(path.get(button.indexOf(13))));
                        mp.seekTo(0);
                        mp.start();
                    } else {
                        try {
                            mp.setDataSource(vpath.get(0));
                            mp.setLooping(false);    //?�m�O�_�`?����
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
                    line3_button_leftmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {  //�_�Ӫ��ɭԫ�_�I���P�C��
                    if (vpath.size() == 0) {
                        mp.stop();
                        mp.reset();
                    } else {
                        mp.stop();
                        mp.reset();
                        vpath.removeAll(vpath);

                    }
                    line3_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                }
                return false;
            }
        });

        line4_button_leftmid.setOnTouchListener(new Button.OnTouchListener() {
            MediaPlayer mp = new MediaPlayer();

            @Override
            public boolean onTouch(View arg0, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {  //���U���ɭԧ��ܭI�����C��
                    if (path.get(button.indexOf(19)).equals("0")) {
                        vpath.add(0, defaultPath);
                        Log.e("aa", "aa =  " + vpath.get(0));
                    }

                    if (vpath.size() == 0) {
                        mp = MediaPlayer.create(getActivity(), Integer.parseInt(path.get(button.indexOf(19))));
                        mp.seekTo(0);
                        mp.start();
                    } else {
                        try {
                            mp.setDataSource(vpath.get(0));
                            mp.setLooping(false);    //?�m�O�_�`?����
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
                    line4_button_leftmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {  //�_�Ӫ��ɭԫ�_�I���P�C��
                    if (vpath.size() == 0) {
                        mp.stop();
                        mp.reset();
                    } else {
                        mp.stop();
                        mp.reset();
                        vpath.removeAll(vpath);

                    }
                    line4_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                }
                return false;
            }
        });

        line1_button_mid.setOnTouchListener(new Button.OnTouchListener() {
            MediaPlayer mp = new MediaPlayer();

            @Override
            public boolean onTouch(View arg0, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {  //���U���ɭԧ��ܭI�����C��
                    if (path.get(button.indexOf(2)).equals("0")) {
                        vpath.add(0, defaultPath);
                        Log.e("aa", "aa =  " + vpath.get(0));
                    }

                    if (vpath.size() == 0) {
                        mp = MediaPlayer.create(getActivity(), Integer.parseInt(path.get(button.indexOf(2))));
                        mp.seekTo(0);
                        mp.start();
                    } else {
                        try {
                            mp.setDataSource(vpath.get(0));
                            mp.setLooping(false);    //?�m�O�_�`?����
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
                    line1_button_mid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {  //�_�Ӫ��ɭԫ�_�I���P�C��
                    if (vpath.size() == 0) {
                        mp.stop();
                        mp.reset();
                    } else {
                        mp.stop();
                        mp.reset();
                        vpath.removeAll(vpath);

                    }
                    line1_button_mid.setBackgroundResource(R.drawable.touchbutton);
                }
                return false;
            }
        });

        line2_button_mid.setOnTouchListener(new Button.OnTouchListener() {
            MediaPlayer mp = new MediaPlayer();

            @Override
            public boolean onTouch(View arg0, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {  //���U���ɭԧ��ܭI�����C��
                    if (path.get(button.indexOf(8)).equals("0")) {
                        vpath.add(0, defaultPath);
                        Log.e("aa", "aa =  " + vpath.get(0));
                    }

                    if (vpath.size() == 0) {
                        mp = MediaPlayer.create(getActivity(), Integer.parseInt(path.get(button.indexOf(8))));
                        mp.seekTo(0);
                        mp.start();
                    } else {
                        try {
                            mp.setDataSource(vpath.get(0));
                            mp.setLooping(false);    //?�m�O�_�`?����
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
                    line2_button_mid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {  //�_�Ӫ��ɭԫ�_�I���P�C��
                    if (vpath.size() == 0) {
                        mp.stop();
                        mp.reset();
                    } else {
                        mp.stop();
                        mp.reset();
                        vpath.removeAll(vpath);

                    }
                    line2_button_mid.setBackgroundResource(R.drawable.touchbutton);
                }
                return false;
            }
        });

        line3_button_mid.setOnTouchListener(new Button.OnTouchListener() {
            MediaPlayer mp = new MediaPlayer();

            @Override
            public boolean onTouch(View arg0, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {  //���U���ɭԧ��ܭI�����C��
                    if (path.get(button.indexOf(14)).equals("0")) {
                        vpath.add(0, defaultPath);
                        Log.e("aa", "aa =  " + vpath.get(0));
                    }

                    if (vpath.size() == 0) {
                        mp = MediaPlayer.create(getActivity(), Integer.parseInt(path.get(button.indexOf(14))));
                        mp.seekTo(0);
                        mp.start();
                    } else {
                        try {
                            mp.setDataSource(vpath.get(0));
                            mp.setLooping(false);    //?�m�O�_�`?����
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
                    line3_button_mid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {  //�_�Ӫ��ɭԫ�_�I���P�C��
                    if (vpath.size() == 0) {
                        mp.stop();
                        mp.reset();
                    } else {
                        mp.stop();
                        mp.reset();
                        vpath.removeAll(vpath);

                    }
                    line3_button_mid.setBackgroundResource(R.drawable.touchbutton);
                }
                return false;
            }
        });

        line4_button_mid.setOnTouchListener(new Button.OnTouchListener() {
            MediaPlayer mp = new MediaPlayer();

            @Override
            public boolean onTouch(View arg0, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {  //���U���ɭԧ��ܭI�����C��
                    if (path.get(button.indexOf(20)).equals("0")) {
                        vpath.add(0, defaultPath);
                        Log.e("aa", "aa =  " + vpath.get(0));
                    }

                    if (vpath.size() == 0) {
                        mp = MediaPlayer.create(getActivity(), Integer.parseInt(path.get(button.indexOf(20))));
                        mp.seekTo(0);
                        mp.start();
                    } else {
                        try {
                            mp.setDataSource(vpath.get(0));
                            mp.setLooping(false);    //?�m�O�_�`?����
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
                    line4_button_mid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {  //�_�Ӫ��ɭԫ�_�I���P�C��
                    if (vpath.size() == 0) {
                        mp.stop();
                        mp.reset();
                    } else {
                        mp.stop();
                        mp.reset();
                        vpath.removeAll(vpath);

                    }
                    line4_button_mid.setBackgroundResource(R.drawable.touchbutton);
                }
                return false;
            }
        });

        line1_button_rightmid.setOnTouchListener(new Button.OnTouchListener() {
            MediaPlayer mp = new MediaPlayer();

            @Override
            public boolean onTouch(View arg0, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {  //���U���ɭԧ��ܭI�����C��
                    if (path.get(button.indexOf(3)).equals("0")) {
                        vpath.add(0, defaultPath);
                        Log.e("aa", "aa =  " + vpath.get(0));
                    }

                    if (vpath.size() == 0) {
                        mp = MediaPlayer.create(getActivity(), Integer.parseInt(path.get(button.indexOf(3))));
                        mp.seekTo(0);
                        mp.start();
                    } else {
                        try {
                            mp.setDataSource(vpath.get(0));
                            mp.setLooping(false);    //?�m�O�_�`?����
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
                    line1_button_rightmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {  //�_�Ӫ��ɭԫ�_�I���P�C��
                    if (vpath.size() == 0) {
                        mp.stop();
                        mp.reset();
                    } else {
                        mp.stop();
                        mp.reset();
                        vpath.removeAll(vpath);

                    }
                    line1_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                }
                return false;
            }
        });

        line2_button_rightmid.setOnTouchListener(new Button.OnTouchListener() {
            MediaPlayer mp = new MediaPlayer();

            @Override
            public boolean onTouch(View arg0, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {  //���U���ɭԧ��ܭI�����C��
                    if (path.get(button.indexOf(9)).equals("0")) {
                        vpath.add(0, defaultPath);
                        Log.e("aa", "aa =  " + vpath.get(0));
                    }

                    if (vpath.size() == 0) {
                        mp = MediaPlayer.create(getActivity(), Integer.parseInt(path.get(button.indexOf(9))));
                        mp.seekTo(0);
                        mp.start();
                    } else {
                        try {
                            mp.setDataSource(vpath.get(0));
                            mp.setLooping(false);    //?�m�O�_�`?����
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
                    line2_button_rightmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {  //�_�Ӫ��ɭԫ�_�I���P�C��
                    if (vpath.size() == 0) {
                        mp.stop();
                        mp.reset();
                    } else {
                        mp.stop();
                        mp.reset();
                        vpath.removeAll(vpath);

                    }
                    line2_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                }
                return false;
            }
        });

        line3_button_rightmid.setOnTouchListener(new Button.OnTouchListener() {
            MediaPlayer mp = new MediaPlayer();

            @Override
            public boolean onTouch(View arg0, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {  //���U���ɭԧ��ܭI�����C��
                    if (path.get(button.indexOf(15)).equals("0")) {
                        vpath.add(0, defaultPath);
                        Log.e("aa", "aa =  " + vpath.get(0));
                    }

                    if (vpath.size() == 0) {
                        mp = MediaPlayer.create(getActivity(), Integer.parseInt(path.get(button.indexOf(15))));
                        mp.seekTo(0);
                        mp.start();
                    } else {
                        try {
                            mp.setDataSource(vpath.get(0));
                            mp.setLooping(false);    //?�m�O�_�`?����
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
                    line3_button_rightmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {  //�_�Ӫ��ɭԫ�_�I���P�C��
                    if (vpath.size() == 0) {
                        mp.stop();
                        mp.reset();
                    } else {
                        mp.stop();
                        mp.reset();
                        vpath.removeAll(vpath);

                    }
                    line3_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                }
                return false;
            }
        });

        line4_button_rightmid.setOnTouchListener(new Button.OnTouchListener() {
            MediaPlayer mp = new MediaPlayer();

            @Override
            public boolean onTouch(View arg0, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {  //���U���ɭԧ��ܭI�����C��
                    if (path.get(button.indexOf(21)).equals("0")) {
                        vpath.add(0, defaultPath);
                        Log.e("aa", "aa =  " + vpath.get(0));
                    }

                    if (vpath.size() == 0) {
                        mp = MediaPlayer.create(getActivity(), Integer.parseInt(path.get(button.indexOf(21))));
                        mp.seekTo(0);
                        mp.start();
                    } else {
                        try {
                            mp.setDataSource(vpath.get(0));
                            mp.setLooping(false);    //?�m�O�_�`?����
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
                    line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {  //�_�Ӫ��ɭԫ�_�I���P�C��
                    if (vpath.size() == 0) {
                        mp.stop();
                        mp.reset();
                    } else {
                        mp.stop();
                        mp.reset();
                        vpath.removeAll(vpath);

                    }
                    line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                }
                return false;
            }
        });

        line1_button_right.setOnTouchListener(new Button.OnTouchListener() {
            MediaPlayer mp = new MediaPlayer();

            @Override
            public boolean onTouch(View arg0, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {  //���U���ɭԧ��ܭI�����C��
                    /*if (path.get(button.indexOf(4)).equals("0")) {
                        vpath.add(0, defaultPath);
                        Log.e("aa", "aa =  " + vpath.get(0));
                    }

                    if (vpath.size() == 0) {
                        mp = MediaPlayer.create(getActivity(), Integer.parseInt(path.get(button.indexOf(4))));
                        mp.seekTo(0);
                        mp.start();
                    } else {
                        try {
                            mp.setDataSource(vpath.get(0));
                            mp.setLooping(false);    //?�m�O�_�`?����
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
                    line1_button_right.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {  //�_�Ӫ��ɭԫ�_�I���P�C��
                    if (vpath.size() == 0) {
                        mp.stop();
                        mp.reset();
                    } else {
                        mp.stop();
                        mp.reset();
                        vpath.removeAll(vpath);

                    }
                    line1_button_right.setBackgroundResource(R.drawable.touchbutton);
                }
                return false;
            }
        });

        line2_button_right.setOnTouchListener(new Button.OnTouchListener() {
            MediaPlayer mp = new MediaPlayer();

            @Override
            public boolean onTouch(View arg0, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {  //���U���ɭԧ��ܭI�����C��
                    /*if (path.get(button.indexOf(10)).equals("0")) {
                        vpath.add(0, defaultPath);
                        Log.e("aa", "aa =  " + vpath.get(0));
                    }

                    if (vpath.size() == 0) {
                        mp = MediaPlayer.create(getActivity(), Integer.parseInt(path.get(button.indexOf(10))));
                        mp.seekTo(0);
                        mp.start();
                    } else {
                        try {
                            mp.setDataSource(vpath.get(0));
                            mp.setLooping(false);    //?�m�O�_�`?����
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
                    line2_button_right.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {  //�_�Ӫ��ɭԫ�_�I���P�C��
                    if (vpath.size() == 0) {
                        mp.stop();
                        mp.reset();
                    } else {
                        mp.stop();
                        mp.reset();
                        vpath.removeAll(vpath);

                    }*/
                    line2_button_right.setBackgroundResource(R.drawable.touchbutton);
                }
                return false;
            }
        });

        line3_button_right.setOnTouchListener(new Button.OnTouchListener() {
            MediaPlayer mp = new MediaPlayer();

            @Override
            public boolean onTouch(View arg0, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {  //���U���ɭԧ��ܭI�����C��
                    if (path.get(button.indexOf(16)).equals("0")) {
                        vpath.add(0, defaultPath);
                        Log.e("aa", "aa =  " + vpath.get(0));
                    }

                    if (vpath.size() == 0) {
                        mp = MediaPlayer.create(getActivity(), Integer.parseInt(path.get(button.indexOf(16))));
                        mp.seekTo(0);
                        mp.start();
                    } else {
                        try {
                            mp.setDataSource(vpath.get(0));
                            mp.setLooping(false);    //?�m�O�_�`?����
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
                    line3_button_right.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {  //�_�Ӫ��ɭԫ�_�I���P�C��
                    if (vpath.size() == 0) {
                        mp.stop();
                        mp.reset();
                    } else {
                        mp.stop();
                        mp.reset();
                        vpath.removeAll(vpath);

                    }
                    line3_button_right.setBackgroundResource(R.drawable.touchbutton);

                }
                return false;
            }
        });

        line4_button_right.setOnTouchListener(new Button.OnTouchListener() {
            MediaPlayer mp = new MediaPlayer();

            @Override
            public boolean onTouch(View arg0, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {  //���U���ɭԧ��ܭI�����C��
                    if (path.get(button.indexOf(22)).equals("0")) {
                        vpath.add(0, defaultPath);
                        Log.e("aa", "aa =  " + vpath.get(0));
                    }

                    if (vpath.size() == 0) {
                        mp = MediaPlayer.create(getActivity(), Integer.parseInt(path.get(button.indexOf(22))));
                        mp.seekTo(0);
                        mp.start();
                    } else {
                        try {
                            mp.setDataSource(vpath.get(0));
                            mp.setLooping(false);    //?�m�O�_�`?����
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
                    line4_button_right.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {  //�_�Ӫ��ɭԫ�_�I���P�C��
                    if (vpath.size() == 0) {
                        mp.stop();
                        mp.reset();
                    } else {
                        mp.stop();
                        mp.reset();
                        vpath.removeAll(vpath);

                    }
                    line4_button_right.setBackgroundResource(R.drawable.touchbutton);
                }
                return false;
            }
        });

        line1_button_rightover.setOnTouchListener(new Button.OnTouchListener() {
            MediaPlayer mp = new MediaPlayer();

            @Override
            public boolean onTouch(View arg0, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {  //���U���ɭԧ��ܭI�����C��
                    /*if (path.get(button.indexOf(5)).equals("0")) {
                        vpath.add(0, defaultPath);
                        Log.e("aa", "aa =  " + vpath.get(0));
                    }

                    if (vpath.size() == 0) {
                        mp = MediaPlayer.create(getActivity(), Integer.parseInt(path.get(button.indexOf(5))));
                        mp.seekTo(0);
                        mp.start();
                    } else {
                        try {
                            mp.setDataSource(vpath.get(0));
                            mp.setLooping(false);    //?�m�O�_�`?����
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
                    line1_button_rightover.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {  //�_�Ӫ��ɭԫ�_�I���P�C��
                    if (vpath.size() == 0) {
                        mp.stop();
                        mp.reset();
                    } else {
                        mp.stop();
                        mp.reset();
                        vpath.removeAll(vpath);

                    }
                    line1_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                }
                return false;
            }
        });

        line2_button_rightover.setOnTouchListener(new Button.OnTouchListener() {
            MediaPlayer mp = new MediaPlayer();

            @Override
            public boolean onTouch(View arg0, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {  //���U���ɭԧ��ܭI�����C��
                    /*if (path.get(button.indexOf(11)).equals("0")) {
                        vpath.add(0, defaultPath);
                        Log.e("aa", "aa =  " + vpath.get(0));
                    }

                    if (vpath.size() == 0) {
                        mp = MediaPlayer.create(getActivity(), Integer.parseInt(path.get(button.indexOf(11))));
                        mp.seekTo(0);
                        mp.start();
                    } else {
                        try {
                            mp.setDataSource(vpath.get(0));
                            mp.setLooping(false);    //?�m�O�_�`?����
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
                    line2_button_rightover.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {  //�_�Ӫ��ɭԫ�_�I���P�C��
                    if (vpath.size() == 0) {
                        mp.stop();
                        mp.reset();
                    } else {
                        mp.stop();
                        mp.reset();
                        vpath.removeAll(vpath);

                    }
                    line2_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                }
                return false;
            }
        });

        line3_button_rightover.setOnTouchListener(new Button.OnTouchListener() {
            MediaPlayer mp = new MediaPlayer();

            @Override
            public boolean onTouch(View arg0, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {  //���U���ɭԧ��ܭI�����C��
                    if (path.get(button.indexOf(17)).equals("0")) {
                        vpath.add(0, defaultPath);
                        Log.e("aa", "aa =  " + vpath.get(0));
                    }

                    if (vpath.size() == 0) {
                        mp = MediaPlayer.create(getActivity(), Integer.parseInt(path.get(button.indexOf(17))));
                        mp.seekTo(0);
                        mp.start();
                    } else {
                        try {
                            mp.setDataSource(vpath.get(0));
                            mp.setLooping(false);    //?�m�O�_�`?����
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
                    line3_button_rightover.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {  //�_�Ӫ��ɭԫ�_�I���P�C��
                    if (vpath.size() == 0) {
                        mp.stop();
                        mp.reset();
                    } else {
                        mp.stop();
                        mp.reset();
                        vpath.removeAll(vpath);

                    }
                    line3_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                }
                return false;
            }
        });

        line4_button_rightover.setOnTouchListener(new Button.OnTouchListener() {
            MediaPlayer mp = new MediaPlayer();

            @Override
            public boolean onTouch(View arg0, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {  //���U���ɭԧ��ܭI�����C��
                    if (path.get(button.indexOf(23)).equals("0")) {
                        vpath.add(0, defaultPath);
                        Log.e("aa", "aa =  " + vpath.get(0));
                    }

                    if (vpath.size() == 0) {
                        mp = MediaPlayer.create(getActivity(), Integer.parseInt(path.get(button.indexOf(23))));
                        mp.seekTo(0);
                        mp.start();
                    } else {
                        try {
                            mp.setDataSource(vpath.get(0));
                            mp.setLooping(false);    //?�m�O�_�`?����
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
                    line4_button_rightover.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {  //�_�Ӫ��ɭԫ�_�I���P�C��
                    if (vpath.size() == 0) {
                        mp.stop();
                        mp.reset();
                    } else {
                        mp.stop();
                        mp.reset();
                        vpath.removeAll(vpath);

                    }
                    line4_button_rightover.setBackgroundResource(R.drawable.touchbutton);
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
        line1_button_rightmid = (Button) view.findViewById(R.id.line1_button_rightmid); // '��0��img_button
        line1_button_right = (Button) view.findViewById(R.id.line1_button_right); // '��0��img_button
        line1_button_rightover = (Button) view.findViewById(R.id.line1_button_rightover); // '��0��img_button
        line2_button_left = (Button) view.findViewById(R.id.line2_button_left); // '��0��img_button
        line2_button_leftmid = (Button) view.findViewById(R.id.line2_button_leftmid); // '��0��img_button
        line2_button_mid = (Button) view.findViewById(R.id.line2_button_mid); // '��0��img_button
        line2_button_rightmid = (Button) view.findViewById(R.id.line2_button_rightmid); // '��0��img_button
        line2_button_right = (Button) view.findViewById(R.id.line2_button_right); // '��0��img_button
        line2_button_rightover = (Button) view.findViewById(R.id.line2_button_rightover); // '��0��img_button
        line3_button_left = (Button) view.findViewById(R.id.line3_button_left); // '��0��img_button
        line3_button_leftmid = (Button) view.findViewById(R.id.line3_button_leftmid); // '��0��img_button
        line3_button_mid = (Button) view.findViewById(R.id.line3_button_mid); // '��0��img_button
        line3_button_rightmid = (Button) view.findViewById(R.id.line3_button_rightmid); // '��0��img_button
        line3_button_right = (Button) view.findViewById(R.id.line3_button_right); // '��0��img_button
        line3_button_rightover = (Button) view.findViewById(R.id.line3_button_rightover); // '��0��img_button
        line4_button_left = (Button) view.findViewById(R.id.line4_button_left); // '��0��img_button
        line4_button_leftmid = (Button) view.findViewById(R.id.line4_button_leftmid); // '��0��img_button
        line4_button_mid = (Button) view.findViewById(R.id.line4_button_mid); // '��0��img_button
        line4_button_rightmid = (Button) view.findViewById(R.id.line4_button_rightmid); // '��0��img_button
        line4_button_right = (Button) view.findViewById(R.id.line4_button_right); // '��0��img_button
        line4_button_rightover = (Button) view.findViewById(R.id.line4_button_rightover); // '��0��img_button
        Bundle bundle = getArguments();
        if (bundle != null) {
            item = bundle.getInt("id");
            it = item;
            if (it == 2131558503) {
                it = 0;
            } else if (it == 2131558504) {
                it = 1;
            } else if (it == 2131558505) {
                it = 2;
            } else {
                it = 3;
            }
        }
        Log.e("aaa", " i = " + it);
        return view;
    }

}
