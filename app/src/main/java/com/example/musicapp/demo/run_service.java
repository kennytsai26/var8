package com.example.musicapp.demo;
import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import java.util.Date;
/**
 * Created by B7 on 2015/11/5.
 */
public class run_service extends Service {
    private Handler handler = new Handler();
    private  int select_animation = 0;
    public String[] animation_array = {"frg1","frg_animation_beta"};
    public String value = "";
    private run_service r_s;
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onStart(Intent intent, int startId) {
        handler.postDelayed(showTime, 1000);
        super.onStart(intent, startId);
    }

    @Override
    public void onDestroy() {
        handler.removeCallbacks(showTime);
        super.onDestroy();
    }

    public Runnable showTime = new Runnable() {
        public void run() {

            Log.i("time:", new Date().toString());
            r_s = new run_service();
            r_s.getString(new run_service.Callback() {

                @Override
                public void getString(String msg) {
                    // TODO Auto-generated method stub
                    value = msg;
                }
            });

            handler.postDelayed(this, 1000);
        }
    };
    public void getString(Callback callback) {

                String msg = animation_array[select_animation];
                select_animation++;
                if (select_animation > 1) {
                    select_animation = 0;
                }

                callback.getString(msg);


    }
    //�Ыؤ���
    public interface Callback {
        public void getString(String msg);
    }
}