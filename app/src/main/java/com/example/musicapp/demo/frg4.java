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

import android.widget.Toast;

import java.util.ArrayList;

public class frg4 extends Fragment {

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
    private int i = 0;
    private DatabaseHelper mOpenHelper;
    private SQLiteDatabase db;
    public static final String TABLE_NAME_Recordmusic = "recordmusic";

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
        final ArrayList<Integer> path = new ArrayList<Integer>();
        final ArrayList<Integer> frg = new ArrayList<Integer>();
        final ArrayList<Integer> button = new ArrayList<Integer>();

        try {
            final Cursor c = db.rawQuery("SELECT * FROM " + TABLE_NAME_Recordmusic + " WHERE fragement = '3' ", null);
            c.moveToFirst();
            for (int i = 0; i < c.getCount(); i++) {
                no.add(c.getInt(1));
                path.add(c.getInt(2));
                frg.add(c.getInt(3));
                button.add(c.getInt(4));
                Log.e("qq4", "id_cloumn = " + c.getInt(0));
                c.moveToNext();
            }
        } catch (Exception e) {


        }
        line1_button_left.setOnTouchListener(new Button.OnTouchListener() {


            //  MediaPlayer mp = MediaPlayer.create(getActivity(), path.get(button.indexOf(0)));

            @Override
            public boolean onTouch(View arg0, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    //   mp.seekTo(0);
                    //  mp.start();
                    Toast.makeText(getActivity(), "Song:" + path.get(button.indexOf(0)), Toast.LENGTH_SHORT).show();

                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    // mp.pause();

                }
                return false;
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.framechoose_1, container, false);
        line1_button_left = (Button) view.findViewById(R.id.line1_button_left);
        line1_button_leftmid = (Button) view.findViewById(R.id.line1_button_leftmid);
        line1_button_mid = (Button) view.findViewById(R.id.line1_button_mid);
        line1_button_rightmid = (Button) view.findViewById(R.id.line1_button_rightmid);
        line1_button_right = (Button) view.findViewById(R.id.line1_button_right);
        line1_button_rightover = (Button) view.findViewById(R.id.line1_button_rightover);
        line2_button_left = (Button) view.findViewById(R.id.line2_button_left);
        line2_button_leftmid = (Button) view.findViewById(R.id.line2_button_leftmid);
        line2_button_mid = (Button) view.findViewById(R.id.line2_button_mid);
        line2_button_rightmid = (Button) view.findViewById(R.id.line2_button_rightmid);
        line2_button_right = (Button) view.findViewById(R.id.line2_button_right);
        line2_button_rightover = (Button) view.findViewById(R.id.line2_button_rightover);
        line3_button_left = (Button) view.findViewById(R.id.line3_button_left);
        line3_button_leftmid = (Button) view.findViewById(R.id.line3_button_leftmid);
        line3_button_mid = (Button) view.findViewById(R.id.line3_button_mid);
        line3_button_rightmid = (Button) view.findViewById(R.id.line3_button_rightmid);
        line3_button_right = (Button) view.findViewById(R.id.line3_button_right);
        line3_button_rightover = (Button) view.findViewById(R.id.line3_button_rightover);
        line4_button_left = (Button) view.findViewById(R.id.line4_button_left);
        line4_button_leftmid = (Button) view.findViewById(R.id.line4_button_leftmid);
        line4_button_mid = (Button) view.findViewById(R.id.line4_button_mid);
        line4_button_rightmid = (Button) view.findViewById(R.id.line4_button_rightmid);
        line4_button_right = (Button) view.findViewById(R.id.line4_button_right);
        line4_button_rightover = (Button) view.findViewById(R.id.line4_button_rightover);
        return view;
    }

}
