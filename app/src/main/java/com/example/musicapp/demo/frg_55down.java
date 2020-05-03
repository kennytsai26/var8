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

public class frg_55down extends Fragment {

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
                    line1_button_left.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                    line2_button_left.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                    line3_button_left.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                    line4_button_left.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 30);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_right.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 60);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 90);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_mid.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 120);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 150);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_left.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 180);
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
                    line1_button_mid.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                    line2_button_mid.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                    line3_button_mid.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                    line4_button_mid.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                    line1_button_leftmid.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                    line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                    line3_button_leftmid.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                    line4_button_leftmid.setBackgroundResource(R.drawable.touchbutton17_ffcc00);

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
                    line1_button_right.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                    line2_button_right.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                    line3_button_right.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                    line4_button_right.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                    line1_button_rightmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                    line2_button_rightmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                    line3_button_rightmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                    line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
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

                    line1_button_mid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                    line1_button_rightover.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                    line2_button_mid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                    line2_button_rightover.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                    line3_button_mid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                    line3_button_rightover.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                    line4_button_mid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                    line4_button_rightover.setBackgroundResource(R.drawable.touchbutton9_00ff66);
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
                            line1_button_left.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line1_button_rightmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line2_button_left.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line2_button_rightmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line3_button_left.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line3_button_rightmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line4_button_left.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                        }
                    }, 30);
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
                            line1_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 75);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_mid.setBackgroundResource(R.drawable.touchbutton9_00ff66);   //���2
                            line1_button_rightover.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line2_button_mid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line2_button_rightover.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line3_button_mid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line3_button_rightover.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line4_button_mid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line4_button_rightover.setBackgroundResource(R.drawable.touchbutton9_00ff66);
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
                            line1_button_left.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line1_button_rightmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line2_button_left.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line2_button_rightmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line3_button_left.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line3_button_rightmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line4_button_left.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                        }
                    }, 130);
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
                    }, 145);
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
                    }, 160);
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
                    }, 175);

                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_mid.setBackgroundResource(R.drawable.touchbutton16_ffff00);   //����
                            line1_button_rightover.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line2_button_mid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line2_button_rightover.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line3_button_mid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line3_button_rightover.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line4_button_mid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line4_button_rightover.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                        }
                    },190);
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
                    }, 205);
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
                    }, 220);
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
                    }, 235);
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
                    }, 250);
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
                    }, 265);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_left.setBackgroundResource(R.drawable.touchbutton16_ffff00);//���ꢱ
                            line1_button_rightmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line2_button_left.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line2_button_rightmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line3_button_left.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line3_button_rightmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line4_button_left.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                        }
                    },280);
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
                    },295);
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
                    }, 310);
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
                    }, 325);
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
                    }, 355);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_left.setBackgroundResource(R.drawable.touchbutton9_00ff66);//���1
                            line1_button_rightmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line2_button_left.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line2_button_rightmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line3_button_left.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line3_button_rightmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line4_button_left.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
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
                            line1_button_leftmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line1_button_right.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line2_button_right.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line3_button_leftmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line3_button_right.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line4_button_leftmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line4_button_right.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                        }
                    }, 400);
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
                            line1_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_right.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 445);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_left.setBackgroundResource(R.drawable.touchbutton9_00ff66);//���2
                            line1_button_rightmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line2_button_left.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line2_button_rightmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line3_button_left.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line3_button_rightmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line4_button_left.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
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
                            line1_button_leftmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line1_button_right.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line2_button_right.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line3_button_leftmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line3_button_right.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line4_button_leftmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line4_button_right.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                        }
                    }, 490);
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
                    }, 535);
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
                    }, 550);
                    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                    new Handler().postDelayed(new Runnable() {//����2-1
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
                            line1_button_leftmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line1_button_right.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line2_button_right.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line3_button_leftmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line3_button_right.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line4_button_leftmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line4_button_right.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                        }
                    }, 580);
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
                            line1_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_right.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 625);
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
                    }, 640);

                    new Handler().postDelayed(new Runnable() {//����2-2
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
                            line1_button_leftmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line1_button_right.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line2_button_right.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line3_button_leftmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line3_button_right.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line4_button_leftmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line4_button_right.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                        }
                    }, 670);
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
                    },685 );
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
                    }, 715);
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
                    }, 730);

                    new Handler().postDelayed(new Runnable() {//���3-1
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
                            line1_button_leftmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line1_button_right.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line2_button_right.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line3_button_leftmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line3_button_right.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line4_button_leftmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line4_button_right.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                        }
                    }, 760);
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
                            line1_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_right.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 805);
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
                    }, 820);

                    new Handler().postDelayed(new Runnable() {//���3-2
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
                    }, 935);
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
                    }, 850);
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
                    }, 895);
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
                    }, 910);
                    new Handler().postDelayed(new Runnable() {//���1
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
                            line1_button_leftmid.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line1_button_right.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line2_button_right.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line3_button_leftmid.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line3_button_right.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line4_button_leftmid.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line4_button_right.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                        }
                    }, 940);
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
                            line1_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_right.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 985);
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
                    }, 1000);
                    new Handler().postDelayed(new Runnable() {//���2
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
                            line1_button_leftmid.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line1_button_right.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line2_button_right.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line3_button_leftmid.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line3_button_right.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line4_button_leftmid.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line4_button_right.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                        }
                    }, 1030);
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
                    }, 1075);
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
                    }, 1090);

                    new Handler().postDelayed(new Runnable() {//���4-1
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
                            line1_button_leftmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line1_button_right.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line2_button_right.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line3_button_leftmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line3_button_right.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line4_button_leftmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line4_button_right.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                        }
                    }, 1120);
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
                            line1_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_right.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 1165);
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
                    }, 1180);
                    new Handler().postDelayed(new Runnable() {//���4-2
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
                            line1_button_leftmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line1_button_right.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line2_button_right.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line3_button_leftmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line3_button_right.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line4_button_leftmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                            line4_button_right.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                        }
                    }, 1210);
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
                    }, 1255);
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
                    }, 1270);

                    new Handler().postDelayed(new Runnable() {//���2-1
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
                            line1_button_leftmid.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line1_button_right.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line2_button_right.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line3_button_leftmid.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line3_button_right.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line4_button_leftmid.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line4_button_right.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                        }
                    }, 1300);
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
                            line1_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_right.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 1345);
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
                    }, 1360);
                    new Handler().postDelayed(new Runnable() {//���2-2
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
                            line1_button_leftmid.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line1_button_right.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line2_button_right.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line3_button_leftmid.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line3_button_right.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line4_button_leftmid.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                            line4_button_right.setBackgroundResource(R.drawable.touchbutton17_ffcc00);
                        }
                    }, 1390);
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
                    }, 1435);
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
                    }, 1450);
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
                    line1_button_rightover.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                    line2_button_rightover.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                    line3_button_rightover.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                    line4_button_rightover.setBackgroundResource(R.drawable.touchbutton16_ffff00);
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
