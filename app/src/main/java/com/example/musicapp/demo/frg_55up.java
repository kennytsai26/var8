package com.example.musicapp.demo;

/**
 * Created by B7 on 2015/11/2.
 */
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import android.os.Handler;

public class frg_55up extends Fragment {

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
    private  int i=0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        line1_button_left.setOnTouchListener(new Button.OnTouchListener() {

            @Override
            public boolean onTouch(View arg0, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    line1_button_left.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                    line2_button_left.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                    line3_button_left.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                    line4_button_left.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {  //�_�Ӫ��ɭԫ�_�I���P�C��

                }
                return false;
            }
        });

        line2_button_left.setOnTouchListener(new Button.OnTouchListener() {

            @Override
            public boolean onTouch(View arg0, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {  //���U���ɭԧ��ܭI�����C��
                    line1_button_left.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                    line1_button_rightmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                    line2_button_left.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                    line2_button_rightmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                    line3_button_left.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                    line3_button_rightmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                    line4_button_left.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                    line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                    //�񥪨�k2��
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_leftmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line1_button_right.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line2_button_right.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line3_button_leftmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line3_button_right.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line4_button_leftmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line4_button_right.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                        }
                    }, 15);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_mid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line1_button_rightover.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line2_button_mid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line2_button_rightover.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line3_button_mid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line3_button_rightover.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line4_button_mid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line4_button_rightover.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                        }
                    }, 30);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 45);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_right.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 60);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 75);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_left.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line1_button_rightmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line2_button_left.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line2_button_rightmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line3_button_left.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line3_button_rightmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line4_button_left.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                        }
                    }, 90);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_leftmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line1_button_right.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line2_button_right.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line3_button_leftmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line3_button_right.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line4_button_leftmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line4_button_right.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                        }
                    }, 105);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_mid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line1_button_rightover.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line2_button_mid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line2_button_rightover.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line3_button_mid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line3_button_rightover.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line4_button_mid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line4_button_rightover.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                        }
                    }, 120);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 135);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_right.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 150);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 165);
                    //���⥪��k��2��
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_left.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line1_button_rightmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line2_button_left.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line2_button_rightmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line3_button_left.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line3_button_rightmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line4_button_left.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                        }
                    }, 180);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_leftmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line1_button_right.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line2_button_right.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line3_button_leftmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line3_button_right.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line4_button_leftmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line4_button_right.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                        }
                    }, 195);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_mid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line1_button_rightover.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line2_button_mid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line2_button_rightover.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line3_button_mid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line3_button_rightover.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line4_button_mid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line4_button_rightover.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                        }
                    }, 210);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 225);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_right.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 240);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 255);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_left.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line1_button_rightmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line2_button_left.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line2_button_rightmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line3_button_left.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line3_button_rightmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line4_button_left.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                        }
                    }, 270);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_leftmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line1_button_right.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line2_button_right.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line3_button_leftmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line3_button_right.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line4_button_leftmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line4_button_right.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                        }
                    }, 285);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_mid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line1_button_rightover.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line2_button_mid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line2_button_rightover.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line3_button_mid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line3_button_rightover.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line4_button_mid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line4_button_rightover.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                        }
                    }, 300);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 315);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_right.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 330);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 340);
                    //��⥪��k��2��
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_left.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line1_button_rightmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line2_button_left.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line2_button_rightmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line3_button_left.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line3_button_rightmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line4_button_left.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                        }
                    }, 355);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_leftmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line1_button_right.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line2_button_right.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line3_button_leftmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line3_button_right.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line4_button_leftmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line4_button_right.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                        }
                    }, 370);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_mid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line1_button_rightover.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line2_button_mid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line2_button_rightover.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line3_button_mid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line3_button_rightover.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line4_button_mid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line4_button_rightover.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                        }
                    }, 385);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 400);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_right.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 415);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 430);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_left.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line1_button_rightmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line2_button_left.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line2_button_rightmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line3_button_left.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line3_button_rightmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line4_button_left.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                        }
                    }, 445);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_leftmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line1_button_right.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line2_button_right.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line3_button_leftmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line3_button_right.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line4_button_leftmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line4_button_right.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                        }
                    }, 460);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_mid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line1_button_rightover.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line2_button_mid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line2_button_rightover.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line3_button_mid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line3_button_rightover.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line4_button_mid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line4_button_rightover.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                        }
                    }, 475);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 490);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_right.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 505);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 520);
                    //��2��
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_left.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line1_button_rightmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line2_button_left.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line2_button_rightmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line3_button_left.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line3_button_rightmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line4_button_left.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                        }
                    }, 535);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_leftmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line1_button_right.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line2_button_right.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line3_button_leftmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line3_button_right.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line4_button_leftmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line4_button_right.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                        }
                    }, 550);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_mid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line1_button_rightover.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line2_button_mid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line2_button_rightover.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line3_button_mid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line3_button_rightover.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line4_button_mid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line4_button_rightover.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                        }
                    }, 565);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 580);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_right.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 595);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 610);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_left.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line1_button_rightmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line2_button_left.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line2_button_rightmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line3_button_left.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line3_button_rightmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line4_button_left.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                        }
                    }, 625);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_leftmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line1_button_right.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line2_button_right.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line3_button_leftmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line3_button_right.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line4_button_leftmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line4_button_right.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                        }
                    }, 640);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_mid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line1_button_rightover.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line2_button_mid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line2_button_rightover.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line3_button_mid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line3_button_rightover.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line4_button_mid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line4_button_rightover.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                        }
                    }, 655);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 670);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_right.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 685);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 700);
                    //��2��
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_left.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line1_button_rightmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line2_button_left.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line2_button_rightmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line3_button_left.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line3_button_rightmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line4_button_left.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                        }
                    }, 715);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_leftmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line1_button_right.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line2_button_right.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line3_button_leftmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line3_button_right.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line4_button_leftmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line4_button_right.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                        }
                    }, 730);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_mid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line1_button_rightover.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line2_button_mid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line2_button_rightover.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line3_button_mid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line3_button_rightover.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line4_button_mid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line4_button_rightover.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                        }
                    }, 745);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 760);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_right.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 775);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 790);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_left.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line1_button_rightmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line2_button_left.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line2_button_rightmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line3_button_left.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line3_button_rightmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line4_button_left.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                        }
                    }, 805);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_leftmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line1_button_right.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line2_button_right.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line3_button_leftmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line3_button_right.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line4_button_leftmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line4_button_right.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                        }
                    }, 820);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_mid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line1_button_rightover.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line2_button_mid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line2_button_rightover.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line3_button_mid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line3_button_rightover.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line4_button_mid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line4_button_rightover.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                        }
                    }, 835);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 850);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_right.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 865);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 880);
                    //��2��
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_left.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line1_button_rightmid.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line2_button_left.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line2_button_rightmid.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line3_button_left.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line3_button_rightmid.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line4_button_left.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                        }
                    }, 895);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_leftmid.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line1_button_right.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line2_button_right.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line3_button_leftmid.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line3_button_right.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line4_button_leftmid.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line4_button_right.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                        }
                    }, 910);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_mid.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line1_button_rightover.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line2_button_mid.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line2_button_rightover.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line3_button_mid.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line3_button_rightover.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line4_button_mid.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line4_button_rightover.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                        }
                    }, 925);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 940);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_right.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 955);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 970);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_left.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line1_button_rightmid.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line2_button_left.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line2_button_rightmid.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line3_button_left.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line3_button_rightmid.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line4_button_left.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                        }
                    }, 985);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_leftmid.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line1_button_right.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line2_button_right.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line3_button_leftmid.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line3_button_right.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line4_button_leftmid.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line4_button_right.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                        }
                    }, 1000);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_mid.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line1_button_rightover.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line2_button_mid.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line2_button_rightover.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line3_button_mid.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line3_button_rightover.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line4_button_mid.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line4_button_rightover.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                        }
                    }, 1015);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 1030);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_right.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 1045);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 1060);
                    //��2��
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_left.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line1_button_rightmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line2_button_left.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line2_button_rightmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line3_button_left.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line3_button_rightmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line4_button_left.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                        }
                    }, 1075);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_leftmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line1_button_right.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line2_button_right.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line3_button_leftmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line3_button_right.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line4_button_leftmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line4_button_right.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                        }
                    }, 1090);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_mid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line1_button_rightover.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line2_button_mid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line2_button_rightover.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line3_button_mid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line3_button_rightover.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line4_button_mid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line4_button_rightover.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                        }
                    }, 1105);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 1120);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_right.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 1135);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 1150);

                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_left.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line1_button_rightmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line2_button_left.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line2_button_rightmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line3_button_left.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line3_button_rightmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line4_button_left.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                        }
                    }, 1165);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_leftmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line1_button_right.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line2_button_right.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line3_button_leftmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line3_button_right.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line4_button_leftmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line4_button_right.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                        }
                    }, 1180);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_mid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line1_button_rightover.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line2_button_mid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line2_button_rightover.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line3_button_mid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line3_button_rightover.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line4_button_mid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line4_button_rightover.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                        }
                    }, 1195);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 1210);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_right.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 1225);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 1240);
                    //��2��
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_left.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line1_button_rightmid.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line2_button_left.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line2_button_rightmid.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line3_button_left.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line3_button_rightmid.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line4_button_left.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                        }
                    }, 1255);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_leftmid.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line1_button_right.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line2_button_right.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line3_button_leftmid.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line3_button_right.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line4_button_leftmid.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line4_button_right.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                        }
                    }, 1270);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_mid.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line1_button_rightover.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line2_button_mid.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line2_button_rightover.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line3_button_mid.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line3_button_rightover.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line4_button_mid.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line4_button_rightover.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                        }
                    }, 1285);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 1300);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_right.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 1315);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 1330);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_left.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line1_button_rightmid.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line2_button_left.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line2_button_rightmid.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line3_button_left.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line3_button_rightmid.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line4_button_left.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                        }
                    }, 1345);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_leftmid.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line1_button_right.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line2_button_right.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line3_button_leftmid.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line3_button_right.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line4_button_leftmid.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line4_button_right.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                        }
                    }, 1360);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_mid.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line1_button_rightover.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line2_button_mid.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line2_button_rightover.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line3_button_mid.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line3_button_rightover.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line4_button_mid.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line4_button_rightover.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                        }
                    }, 1375);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 1390);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_right.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 1405);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 1420);


                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {  //�_�Ӫ��ɭԫ�_�I���P�C��

                }
                return false;
            }
        });

        line3_button_left.setOnTouchListener(new Button.OnTouchListener() {

            @Override
            public boolean onTouch(View arg0, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {  //���U���ɭԧ��ܭI�����C��
                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {  //�_�Ӫ��ɭԫ�_�I���P�C��

                }
                return false;
            }
        });

        line4_button_left.setOnTouchListener(new Button.OnTouchListener() {

            @Override
            public boolean onTouch(View arg0, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {  //���U���ɭԧ��ܭI�����C��

                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {  //�_�Ӫ��ɭԫ�_�I���P�C��

                }
                return false;
            }
        });

        line1_button_leftmid.setOnTouchListener(new Button.OnTouchListener() {
            @Override
            public boolean onTouch(View arg0, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {  //���U���ɭԧ��ܭI�����C��
                    line1_button_leftmid.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                    line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                    line3_button_leftmid.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                    line4_button_leftmid.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                    line1_button_mid.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                    line2_button_mid.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                    line3_button_mid.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                    line4_button_mid.setBackgroundResource(R.drawable.touchbutton17_ffcc00);

                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {  //�_�Ӫ��ɭԫ�_�I���P�C��
                }
                return false;
            }
        });

        line2_button_leftmid.setOnTouchListener(new Button.OnTouchListener() {
            @Override
            public boolean onTouch(View arg0, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {  //���U���ɭԧ��ܭI�����C��

                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {  //�_�Ӫ��ɭԫ�_�I���P�C��
                }
                return false;
            }
        });

        line3_button_leftmid.setOnTouchListener(new Button.OnTouchListener() {
            @Override
            public boolean onTouch(View arg0, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {  //���U���ɭԧ��ܭI�����C��

                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {  //�_�Ӫ��ɭԫ�_�I���P�C��
                }
                return false;
            }
        });

        line4_button_leftmid.setOnTouchListener(new Button.OnTouchListener() {
            @Override
            public boolean onTouch(View arg0, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {  //���U���ɭԧ��ܭI�����C��

                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {  //�_�Ӫ��ɭԫ�_�I���P�C��
                }
                return false;
            }
        });

        line1_button_mid.setOnTouchListener(new Button.OnTouchListener() {

            @Override
            public boolean onTouch(View arg0, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {  //���U���ɭԧ��ܭI�����C��

                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {  //�_�Ӫ��ɭԫ�_�I���P�C��

                }
                return false;
            }
        });

        line2_button_mid.setOnTouchListener(new Button.OnTouchListener() {

            @Override
            public boolean onTouch(View arg0, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {  //���U���ɭԧ��ܭI�����C��

                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {  //�_�Ӫ��ɭԫ�_�I���P�C��

                }
                return false;
            }
        });

        line3_button_mid.setOnTouchListener(new Button.OnTouchListener() {

            @Override
            public boolean onTouch(View arg0, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {  //���U���ɭԧ��ܭI�����C��

                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {  //�_�Ӫ��ɭԫ�_�I���P�C��

                }
                return false;
            }
        });

        line4_button_mid.setOnTouchListener(new Button.OnTouchListener() {

            @Override
            public boolean onTouch(View arg0, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {  //���U���ɭԧ��ܭI�����C��


                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {  //�_�Ӫ��ɭԫ�_�I���P�C��

                }
                return false;
            }
        });

        line1_button_rightmid.setOnTouchListener(new Button.OnTouchListener() {

            @Override
            public boolean onTouch(View arg0, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {  //���U���ɭԧ��ܭI�����C��
                    line1_button_rightmid.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                    line2_button_rightmid.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                    line3_button_rightmid.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                    line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                    line1_button_right.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                    line2_button_right.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                    line3_button_right.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                    line4_button_right.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {  //�_�Ӫ��ɭԫ�_�I���P�C��

                }
                return false;
            }
        });

        line2_button_rightmid.setOnTouchListener(new Button.OnTouchListener() {

            @Override
            public boolean onTouch(View arg0, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {  //���U���ɭԧ��ܭI�����C��

                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {  //�_�Ӫ��ɭԫ�_�I���P�C��

                }
                return false;
            }
        });

        line3_button_rightmid.setOnTouchListener(new Button.OnTouchListener() {

            @Override
            public boolean onTouch(View arg0, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {  //���U���ɭԧ��ܭI�����C��


                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {  //�_�Ӫ��ɭԫ�_�I���P�C��

                }
                return false;
            }
        });

        line4_button_rightmid.setOnTouchListener(new Button.OnTouchListener() {

            @Override
            public boolean onTouch(View arg0, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {  //���U���ɭԧ��ܭI�����C��

                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {  //�_�Ӫ��ɭԫ�_�I���P�C��

                }
                return false;
            }
        });

        line1_button_right.setOnTouchListener(new Button.OnTouchListener() {

            @Override
            public boolean onTouch(View arg0, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {  //���U���ɭԧ��ܭI�����C��


                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {  //�_�Ӫ��ɭԫ�_�I���P�C��

                }
                return false;
            }
        });

        line2_button_right.setOnTouchListener(new Button.OnTouchListener() {

            @Override
            public boolean onTouch(View arg0, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {  //���U���ɭԧ��ܭI�����C��


                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {  //�_�Ӫ��ɭԫ�_�I���P�C��

                }
                return false;
            }
        });

        line3_button_right.setOnTouchListener(new Button.OnTouchListener() {

            @Override
            public boolean onTouch(View arg0, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {  //���U���ɭԧ��ܭI�����C��

                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {  //�_�Ӫ��ɭԫ�_�I���P�C��

                }
                return false;
            }
        });

        line4_button_right.setOnTouchListener(new Button.OnTouchListener() {

            @Override
            public boolean onTouch(View arg0, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {  //���U���ɭԧ��ܭI�����C��


                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {  //�_�Ӫ��ɭԫ�_�I���P�C��


                }
                return false;
            }
        });

        line1_button_rightover.setOnTouchListener(new Button.OnTouchListener() {

            @Override
            public boolean onTouch(View arg0, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {  //���U���ɭԧ��ܭI�����C��
                    line1_button_rightover.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                    line2_button_rightover.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                    line3_button_rightover.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                    line4_button_rightover.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 1000);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_right.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 1030);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 1060);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_mid.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 1090);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 1120);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_left.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 1150);
                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {  //�_�Ӫ��ɭԫ�_�I���P�C��

                }
                return false;
            }
        });

        line2_button_rightover.setOnTouchListener(new Button.OnTouchListener() {

            @Override
            public boolean onTouch(View arg0, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {  //���U���ɭԧ��ܭI�����C��


                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {  //�_�Ӫ��ɭԫ�_�I���P�C��

                }
                return false;
            }
        });

        line3_button_rightover.setOnTouchListener(new Button.OnTouchListener() {

            @Override
            public boolean onTouch(View arg0, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {  //���U���ɭԧ��ܭI�����C��


                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {  //�_�Ӫ��ɭԫ�_�I���P�C��

                }
                return false;
            }
        });

        line4_button_rightover.setOnTouchListener(new Button.OnTouchListener() {

            @Override
            public boolean onTouch(View arg0, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {  //���U���ɭԧ��ܭI�����C��


                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {  //�_�Ӫ��ɭԫ�_�I���P�C��

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
