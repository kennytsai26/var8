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

public class frg_6down extends Fragment {

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
                    line1_button_leftmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                    line1_button_mid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                    line2_button_mid.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line2_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                        }
                    }, 60);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_left.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                        }
                    }, 120);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line2_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_mid.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                        }
                    }, 180);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line2_button_mid.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 240);
                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {  //�_�Ӫ��ɭԫ�_�I���P�C��
                    //mp.pause();
                }
                return false;
            }
        });

        line2_button_left.setOnTouchListener(new Button.OnTouchListener() {
            @Override
            public boolean onTouch(View arg0, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {  //���U���ɭԧ��ܭI�����C��

                    line2_button_left.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                    line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                    line2_button_mid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                    line3_button_mid.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line3_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_leftmid.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                        }
                    }, 60);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line3_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_left.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                        }
                    }, 120);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line3_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_mid.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                        }
                    }, 180);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line3_button_mid.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 240);

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
                    line3_button_left.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                    line3_button_leftmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                    line3_button_mid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                    line4_button_mid.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line4_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_leftmid.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                        }
                    }, 60);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line4_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_left.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                        }
                    },120);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line4_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_mid.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                        }
                    },180);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line4_button_mid.setBackgroundResource(R.drawable.touchbutton);
                        }
                    },240);

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

                    line4_button_left.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                    line4_button_leftmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                    line4_button_mid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
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
                    line4_button_mid.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                    line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton21_ff0000);
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
                    line1_button_rightmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                    line2_button_rightmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                    line3_button_rightmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                    line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                    line1_button_right.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                    line2_button_right.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                    line3_button_right.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                    line4_button_right.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                    line1_button_rightover.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                    line2_button_rightover.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                    line3_button_rightover.setBackgroundResource(R.drawable.touchbutton9_00ff66);
                    line4_button_rightover.setBackgroundResource(R.drawable.touchbutton9_00ff66);
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

                    line1_button_mid.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                    line1_button_rightover.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_leftmid.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                            line1_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_right.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                        }
                    }, 60);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_left.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                            line1_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_rightmid.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                        }
                    }, 120);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_mid.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                            line1_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_rightover.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                        }
                    }, 180);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 240);
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

                    line1_button_rightover.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                    line2_button_rightover.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                    line3_button_rightover.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                    line4_button_rightover.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                    line1_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                    line2_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                    line3_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                    line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                    line1_button_right.setBackgroundResource(R.drawable.touchbutton);
                    line2_button_right.setBackgroundResource(R.drawable.touchbutton);
                    line3_button_right.setBackgroundResource(R.drawable.touchbutton);
                    line4_button_right.setBackgroundResource(R.drawable.touchbutton);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_right.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line2_button_right.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line3_button_right.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line4_button_right.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line1_button_leftmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line3_button_leftmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line4_button_leftmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                        }
                    }, 30);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_mid.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_rightmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line2_button_rightmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line3_button_rightmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line1_button_left.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line2_button_left.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line3_button_left.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                            line4_button_left.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                        }
                    }, 60);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_leftmid.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_right.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 90);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line1_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line1_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_left.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_left.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 120);
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

                    line1_button_mid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                    line2_button_mid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                    line3_button_mid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                    line4_button_mid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                    line1_button_leftmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                    line2_button_leftmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                    line3_button_leftmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                    line4_button_leftmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
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

        line1_button_rightover.setOnTouchListener(new Button.OnTouchListener() {
            @Override
            public boolean onTouch(View arg0, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {  //���U���ɭԧ��ܭI�����C��

                    line1_button_rightmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                    line1_button_right.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                    line1_button_rightover.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                    line2_button_rightover.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line2_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_right.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                        }
                    }, 60);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line2_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_rightmid.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                        }
                    }, 120);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line2_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line2_button_rightover.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                        }
                    }, 180);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line2_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 240);
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

                    line2_button_rightmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                    line2_button_right.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                    line2_button_rightover.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                    line3_button_rightover.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line3_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_right.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                        }
                    }, 60);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line3_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_rightmid.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                        }
                    }, 120);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line3_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line3_button_rightover.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                        }
                    }, 180);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line3_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 240);
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

                    line3_button_rightmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                    line3_button_right.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                    line3_button_rightover.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                    line4_button_rightover.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line4_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_right.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                        }
                    }, 60);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line4_button_right.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                        }
                    }, 120);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton);
                            line4_button_rightover.setBackgroundResource(R.drawable.touchbutton21_ff0000);
                        }
                    }, 180);
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            line4_button_rightover.setBackgroundResource(R.drawable.touchbutton);
                        }
                    }, 240);
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

                    line4_button_rightmid.setBackgroundResource(R.drawable.touchbutton16_ffff00);
                    line4_button_right.setBackgroundResource(R.drawable.touchbutton16_ffff00);
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
