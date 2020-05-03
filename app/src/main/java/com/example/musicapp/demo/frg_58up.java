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

public class frg_58up extends Fragment {

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
                    line1_button_right.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                    line1_button_mid.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                    line2_button_right.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                    line2_button_mid.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                    line3_button_right.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                    line3_button_mid.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                    line4_button_right.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                    line4_button_mid.setBackgroundResource(R.drawable.touchbutton21_ff0000);

                    line1_button_rightmid.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                    line2_button_rightmid.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                    line3_button_rightmid.setBackgroundResource(R.drawable.touchbutton21_ff0000);

                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                        }
                    }, 20);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line2_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_rightover.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                        }
                    }, 40);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line3_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_rightover.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                        }
                    }, 60);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_rightover.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                        }
                    }, 80);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_rightover.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                            line4_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 100);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_rightover.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                        }
                    }, 120);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line2_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                        }
                    }, 140);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line3_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_rightmid.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                        }
                    }, 160);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line4_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_rightmid.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                        }
                    }, 180);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_rightmid.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                            line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 200);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                        }
                    }, 220);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line2_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_rightover.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                        }
                    }, 240);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line3_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_rightover.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                        }
                    }, 260);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_rightover.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                        }
                    }, 280);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_rightover.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                            line4_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 300);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_rightover.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                        }
                    }, 320);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line2_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                        }
                    }, 340);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line3_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_rightmid.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                        }
                    }, 360);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line4_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_rightmid.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                        }
                    }, 380);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_rightmid.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                            line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 400);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_left.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                            line2_button_left.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                            line3_button_left.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                            line4_button_left.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                            line1_button_mid.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                            line2_button_mid.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                            line3_button_mid.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                            line4_button_mid.setBackgroundResource(R.drawable.touchbutton21_ff0000);

                            line1_button_leftmid.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                            line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                            line3_button_leftmid.setBackgroundResource(R.drawable.touchbutton21_ff0000);


                        }
                    }, 420);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_leftmid.setBackgroundResource(R.drawable.touchbutton21_ff0000);

                        }
                    }, 440);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton21_ff0000);

                        }
                    }, 460);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line3_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_rightmid.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                        }
                    }, 480);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line4_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_rightmid.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                        }
                    }, 500);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_rightmid.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                            line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 520);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                        }
                    }, 540);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line2_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_leftmid.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                        }
                    }, 560);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line3_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_leftmid.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                        }
                    }, 580);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                        }
                    }, 600);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_leftmid.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                            line4_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 620);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_leftmid.setBackgroundResource(R.drawable.touchbutton21_ff0000);

                        }
                    }, 640);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton21_ff0000);

                        }
                    }, 660);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line3_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_rightmid.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                        }
                    }, 680);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line4_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_rightmid.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                        }
                    }, 700);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_rightmid.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                            line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 720);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                        }
                    }, 740);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line2_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_leftmid.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                        }
                    }, 760);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line3_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_leftmid.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                        }
                    }, 780);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                        }
                    }, 800);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_leftmid.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                            line4_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 820);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_rightmid.setBackgroundResource(R.drawable.touchbutton);

                            line1_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_mid.setBackgroundResource(R.drawable.touchbutton);

                        }
                    }, 840);

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
                    line1_button_left.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                    line1_button_mid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                    line2_button_left.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                    line2_button_mid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                    line3_button_left.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                    line3_button_mid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                    line4_button_left.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                    line4_button_mid.setBackgroundResource(R.drawable.touchbutton16_ffff00);

                    line1_button_leftmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                    line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                    line3_button_leftmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_leftmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);

                        }
                    }, 20);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);

                        }
                    }, 40);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line3_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_rightmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                        }
                    }, 60);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line4_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_rightmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                        }
                    }, 80);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_rightmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 100);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                        }
                    }, 120);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line2_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_leftmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                        }
                    }, 140);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line3_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_leftmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                        }
                    }, 160);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                        }
                    }, 180);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_leftmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line4_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 200);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_leftmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);

                        }
                    }, 220);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);

                        }
                    }, 240);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line3_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_rightmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                        }
                    },260);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line4_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_rightmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                        }
                    }, 280);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_rightmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 300);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                        }
                    }, 320);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line2_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_leftmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                        }
                    }, 340);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line3_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_leftmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                        }
                    }, 360);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                        }
                    }, 380);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_leftmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line4_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 400);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_left.setBackgroundResource(R.drawable.touchbutton);

                            line1_button_right.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line2_button_right.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line3_button_right.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line4_button_right.setBackgroundResource(R.drawable.touchbutton16_ffff00);

                            line1_button_rightmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line2_button_rightmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line3_button_rightmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);

                            line1_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_leftmid.setBackgroundResource(R.drawable.touchbutton);

                        }
                    }, 420);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                        }
                    }, 440);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line2_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_rightover.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                        }
                    }, 460);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line3_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_rightover.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                        }
                    }, 480);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_rightover.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                        }
                    }, 500);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_rightover.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line4_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 520);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_rightover.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                        }
                    }, 540);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line2_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                        }
                    }, 560);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line3_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_rightmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                        }
                    }, 580);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line4_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_rightmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                        }
                    }, 600);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_rightmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 620);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                        }
                    }, 640);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line2_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_rightover.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                        }
                    }, 660);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line3_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_rightover.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                        }
                    }, 680);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_rightover.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                        }
                    }, 700);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_rightover.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line4_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 720);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_rightover.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                        }
                    }, 740);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line2_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                        }
                    }, 760);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line3_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_rightmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                        }
                    }, 780);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line4_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_rightmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                        }
                    }, 800);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_rightmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 820);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_right.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 840);

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


                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line4_button_mid.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                            line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton21_ff0000);

                        }
                    }, 120);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                           line4_button_leftmid.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line4_button_right.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line3_button_mid.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                            line3_button_rightmid.setBackgroundResource(R.drawable.touchbutton21_ff0000);

                        }
                    }, 150);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line4_button_leftmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line4_button_right.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line3_button_leftmid.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line3_button_right.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line2_button_mid.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                            line2_button_rightmid.setBackgroundResource(R.drawable.touchbutton21_ff0000);

                        }
                    }, 180);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line4_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_leftmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line3_button_right.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line2_button_right.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line1_button_mid.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                            line1_button_rightmid.setBackgroundResource(R.drawable.touchbutton21_ff0000);

                        }
                    }, 210);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line4_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line2_button_right.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line1_button_leftmid.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line1_button_right.setBackgroundResource(R.drawable.touchbutton17_ffcc00);


                        }
                    }, 240);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line3_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_leftmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line1_button_right.setBackgroundResource(R.drawable.touchbutton16_ffff00);

                        }
                    }, 270);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_rightmid.setBackgroundResource(R.drawable.touchbutton);

                        }
                    }, 300);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_right.setBackgroundResource(R.drawable.touchbutton);

                        }
                    }, 330);
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
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line4_button_mid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);

                        }
                    }, 120);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line4_button_leftmid.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line4_button_right.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line3_button_mid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line3_button_rightmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);

                        }
                    }, 150);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line4_button_leftmid.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line4_button_right.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line3_button_leftmid.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line3_button_right.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line2_button_mid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line2_button_rightmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);

                        }
                    }, 180);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line4_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_leftmid.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line3_button_right.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line2_button_right.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line1_button_mid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line1_button_rightmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);

                        }
                    }, 210);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line4_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line2_button_right.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line1_button_leftmid.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line1_button_right.setBackgroundResource(R.drawable.touchbutton17_ffcc00);


                        }
                    }, 240);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line3_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_leftmid.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line1_button_right.setBackgroundResource(R.drawable.touchbutton17_ffcc00);

                        }
                    }, 270);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_rightmid.setBackgroundResource(R.drawable.touchbutton);

                        }
                    }, 300);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_right.setBackgroundResource(R.drawable.touchbutton);

                        }
                    }, 330);
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
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line4_button_mid.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                            line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton21_ff0000);

                        }
                    }, 120);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line4_button_leftmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line4_button_right.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line3_button_mid.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                            line3_button_rightmid.setBackgroundResource(R.drawable.touchbutton21_ff0000);

                        }
                    }, 150);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line4_button_leftmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line4_button_right.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line3_button_leftmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line3_button_right.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line2_button_mid.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                            line2_button_rightmid.setBackgroundResource(R.drawable.touchbutton21_ff0000);

                        }
                    }, 180);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line4_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_leftmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line3_button_right.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line2_button_right.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line1_button_mid.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                            line1_button_rightmid.setBackgroundResource(R.drawable.touchbutton21_ff0000);

                        }
                    }, 210);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line4_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line2_button_right.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line1_button_leftmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line1_button_right.setBackgroundResource(R.drawable.touchbutton9_00ff66);


                        }
                    }, 240);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line3_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_leftmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line1_button_right.setBackgroundResource(R.drawable.touchbutton9_00ff66);

                        }
                    }, 270);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_rightmid.setBackgroundResource(R.drawable.touchbutton);

                        }
                    }, 300);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_right.setBackgroundResource(R.drawable.touchbutton);

                        }
                    }, 330);
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

                    line1_button_left.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                    line1_button_leftmid.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                    line1_button_mid.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                    line2_button_left.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                    line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                    line2_button_mid.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                    line3_button_left.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                    line3_button_leftmid.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                    line3_button_mid.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                    line4_button_left.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                    line4_button_leftmid.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                    line4_button_mid.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_rightmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line1_button_right.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line1_button_rightover.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line2_button_rightmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line2_button_right.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line2_button_rightover.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line3_button_rightmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line3_button_right.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line3_button_rightover.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line4_button_right.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line4_button_rightover.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                        }
                    }, 60);

                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {  //�_�Ӫ��ɭԫ�_�I���P�C��
                    line1_button_left.setBackgroundResource(R.drawable.touchbutton);
                    line1_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                    line1_button_mid.setBackgroundResource(R.drawable.touchbutton);
                    line2_button_left.setBackgroundResource(R.drawable.touchbutton);
                    line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                    line2_button_mid.setBackgroundResource(R.drawable.touchbutton);
                    line3_button_left.setBackgroundResource(R.drawable.touchbutton);
                    line3_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                    line3_button_mid.setBackgroundResource(R.drawable.touchbutton);
                    line4_button_left.setBackgroundResource(R.drawable.touchbutton);
                    line4_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                    line4_button_mid.setBackgroundResource(R.drawable.touchbutton);

                    line1_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                    line1_button_right.setBackgroundResource(R.drawable.touchbutton);
                    line1_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                    line2_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                    line2_button_right.setBackgroundResource(R.drawable.touchbutton);
                    line2_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                    line3_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                    line3_button_right.setBackgroundResource(R.drawable.touchbutton);
                    line3_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                    line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                    line4_button_right.setBackgroundResource(R.drawable.touchbutton);
                    line4_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                }
                return false;
            }
        });

        line1_button_rightmid.setOnTouchListener(new Button.OnTouchListener() {

            @Override
            public boolean onTouch(View arg0, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {  //���U���ɭԧ��ܭI�����C��

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
                    line1_button_left.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                    line1_button_leftmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                    line1_button_mid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                    line2_button_left.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                    line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                    line2_button_mid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                    line3_button_left.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                    line3_button_leftmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                    line3_button_mid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                    line4_button_left.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                    line4_button_leftmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                    line4_button_mid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_rightmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line1_button_right.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line1_button_rightover.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line2_button_rightmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line2_button_right.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line2_button_rightover.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line3_button_rightmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line3_button_right.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line3_button_rightover.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line4_button_right.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line4_button_rightover.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                        }
                    }, 120);
                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {  //�_�Ӫ��ɭԫ�_�I���P�C��
                    line1_button_left.setBackgroundResource(R.drawable.touchbutton);
                    line1_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                    line1_button_mid.setBackgroundResource(R.drawable.touchbutton);
                    line2_button_left.setBackgroundResource(R.drawable.touchbutton);
                    line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                    line2_button_mid.setBackgroundResource(R.drawable.touchbutton);
                    line3_button_left.setBackgroundResource(R.drawable.touchbutton);
                    line3_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                    line3_button_mid.setBackgroundResource(R.drawable.touchbutton);
                    line4_button_left.setBackgroundResource(R.drawable.touchbutton);
                    line4_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                    line4_button_mid.setBackgroundResource(R.drawable.touchbutton);

                    line1_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                    line1_button_right.setBackgroundResource(R.drawable.touchbutton);
                    line1_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                    line2_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                    line2_button_right.setBackgroundResource(R.drawable.touchbutton);
                    line2_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                    line3_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                    line3_button_right.setBackgroundResource(R.drawable.touchbutton);
                    line3_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                    line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                    line4_button_right.setBackgroundResource(R.drawable.touchbutton);
                    line4_button_rightover.setBackgroundResource(R.drawable.touchbutton);
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
                    line1_button_left.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                    line1_button_leftmid.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                    line1_button_mid.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                    line2_button_left.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                    line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                    line2_button_mid.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                    line3_button_left.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                    line3_button_leftmid.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                    line3_button_mid.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                    line4_button_left.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                    line4_button_leftmid.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                    line4_button_mid.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_rightmid.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line1_button_right.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line1_button_rightover.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line2_button_rightmid.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line2_button_right.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line2_button_rightover.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line3_button_rightmid.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line3_button_right.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line3_button_rightover.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line4_button_right.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line4_button_rightover.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                        }
                    }, 120);

                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {  //�_�Ӫ��ɭԫ�_�I���P�C��
                    line1_button_left.setBackgroundResource(R.drawable.touchbutton);
                    line1_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                    line1_button_mid.setBackgroundResource(R.drawable.touchbutton);
                    line2_button_left.setBackgroundResource(R.drawable.touchbutton);
                    line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                    line2_button_mid.setBackgroundResource(R.drawable.touchbutton);
                    line3_button_left.setBackgroundResource(R.drawable.touchbutton);
                    line3_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                    line3_button_mid.setBackgroundResource(R.drawable.touchbutton);
                    line4_button_left.setBackgroundResource(R.drawable.touchbutton);
                    line4_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                    line4_button_mid.setBackgroundResource(R.drawable.touchbutton);

                    line1_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                    line1_button_right.setBackgroundResource(R.drawable.touchbutton);
                    line1_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                    line2_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                    line2_button_right.setBackgroundResource(R.drawable.touchbutton);
                    line2_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                    line3_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                    line3_button_right.setBackgroundResource(R.drawable.touchbutton);
                    line3_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                    line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                    line4_button_right.setBackgroundResource(R.drawable.touchbutton);
                    line4_button_rightover.setBackgroundResource(R.drawable.touchbutton);

                }
                return false;
            }
        });

        line1_button_rightover.setOnTouchListener(new Button.OnTouchListener() {

            @Override
            public boolean onTouch(View arg0, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {  //���U���ɭԧ��ܭI�����C��

                    line1_button_left.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                    line1_button_leftmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                    line1_button_mid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                    line1_button_right.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                    line1_button_rightmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                    line1_button_rightover.setBackgroundResource(R.drawable.touchbutton9_00ff66);

                    line2_button_left.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                    line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                    line2_button_mid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                    line2_button_right.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                    line2_button_rightmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                    line2_button_rightover.setBackgroundResource(R.drawable.touchbutton9_00ff66);
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
                    line4_button_mid.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                    line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton21_ff0000);

                    line1_button_left.setBackgroundResource(R.drawable.touchbutton);
                    line1_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                    line1_button_mid.setBackgroundResource(R.drawable.touchbutton);
                    line1_button_right.setBackgroundResource(R.drawable.touchbutton);
                    line1_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                    line1_button_rightover.setBackgroundResource(R.drawable.touchbutton);

                    line2_button_left.setBackgroundResource(R.drawable.touchbutton);
                    line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                    line2_button_mid.setBackgroundResource(R.drawable.touchbutton);
                    line2_button_right.setBackgroundResource(R.drawable.touchbutton);
                    line2_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                    line2_button_rightover.setBackgroundResource(R.drawable.touchbutton);

                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {  //�_�Ӫ��ɭԫ�_�I���P�C��
                    line4_button_mid.setBackgroundResource(R.drawable.touchbutton);
                    line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
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
