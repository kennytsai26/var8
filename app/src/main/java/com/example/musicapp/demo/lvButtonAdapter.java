package com.example.musicapp.demo;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by B7 on 2015/11/24.
 */
public class lvButtonAdapter extends BaseAdapter {
    private class buttonViewHolder {
        TextView no;
        TextView name;
        TextView path;
        ImageButton buttonplay;
        ImageButton buttonadd;
        int position;
    }
    private DatabaseHelper mOpenHelper;
    private SQLiteDatabase db;
    private static final String ARG_POSITION = "position";
    private int mPosition;
    private Cursor cur;
    private main m;

    private ArrayList < HashMap < String , Object > > mAppList;
    private LayoutInflater mInflater;
    private Context mContext;
    private String [ ] keyString;
    private int [ ] valueViewID;
    private int mButtonClickPosition;
    private buttonViewHolder holder;
    private String Table_Name;
    public static final String TABLE_NAME_GUITAR="guitar";
    public lvButtonAdapter( Context c, ArrayList < HashMap < String , Object > > appList, int resource,
                            String [ ] from , int [ ] to,String name) {
        mAppList = appList;
        mContext = c;
        mInflater = ( LayoutInflater) mContext. getSystemService( Context . LAYOUT_INFLATER_SERVICE) ;
        keyString = new String [ from . length ] ;
        valueViewID = new int [ to. length ] ;
        System . arraycopy ( from , 0, keyString, 0, from . length ) ;
        System . arraycopy ( to, 0, valueViewID, 0, to. length ) ;
        Table_Name = name;
    }

    @Override
    public int getCount ( ) {
        return mAppList. size() ;
    }

    @Override
    public Object getItem ( int position ) {
        return mAppList. get(position) ;
    }

    @Override
    public long getItemId( int position ) {
        return position ;
    }

    public void removeItem ( int position ) {
        mAppList. remove ( position ) ;
        this . notifyDataSetChanged( ) ;
    }

    @Override
    public View getView ( int position , View convertView, ViewGroup parent ) {
        if ( convertView != null ) {
            holder = ( buttonViewHolder) convertView. getTag ( ) ;
        } else {
            convertView = mInflater. inflate ( R.layout.simple_list_item, null ) ;
            holder = new buttonViewHolder( ) ;
            holder.buttonplay = ( ImageButton ) convertView.findViewById( valueViewID[ 0] ) ;
            holder.no = ( TextView) convertView.findViewById(valueViewID[1]) ;
            holder.name = ( TextView) convertView.findViewById(valueViewID[2]) ;
//            holder.path = ( TextView) convertView.findViewById( valueViewID[ 3] ) ;
            holder.buttonadd = ( ImageButton) convertView.findViewById(valueViewID[3]) ;
            convertView. setTag( holder) ;
        }
        holder.position = position;
        HashMap < String , Object > appInfo = mAppList.get(position) ;
        if ( appInfo != null ) {
            String no = ( String ) appInfo.get( keyString[ 1] ) ;
            String name = ( String ) appInfo.get(keyString[2]) ;
          //  String path = ( String ) appInfo.get( keyString[ 3] ) ;
            int musicplay = ( Integer ) appInfo.get(keyString[0]) ;
            int musicadd = ( Integer ) appInfo.get(keyString[3]) ;
            holder.no.setText(no) ;
            holder.name.setText(name) ;
           // holder.path.setText(path) ;

            holder.buttonplay.setImageDrawable(holder.buttonplay.getResources().getDrawable(musicplay));
            holder.buttonplay.setOnClickListener(new lvButtonListener(position));

            holder.buttonadd.setImageDrawable(holder.buttonadd.getResources().getDrawable(musicadd));
            holder.buttonadd.setOnClickListener(new lvButtonListener(position));

        }
        return convertView;
    }
    public buttonViewHolder getViewHolder(View v){
        if (v.getTag() == null){
            return getViewHolder((View) v.getParent());
        }
        return (buttonViewHolder ) v.getTag();
    }
   public class lvButtonListener implements View.OnClickListener {
        private int position ;
       MediaPlayer mp = new MediaPlayer();
       public lvButtonListener( ) {

       }
        lvButtonListener( int pos) {
            position = pos;
        }


           @Override
        public void onClick( View v) {
            int vid= v.getId() ;
               buttonViewHolder holder = getViewHolder(v);
               mButtonClickPosition = holder.position;

               mOpenHelper = new DatabaseHelper(mContext);
               db = mOpenHelper.getReadableDatabase();
               final Cursor c=db.rawQuery("SELECT path  FROM "+ Table_Name,null);
               final ArrayList<Integer> path = new ArrayList<Integer>();
               final ArrayList<String> vpath = new ArrayList<String>();

                   c.moveToFirst();
               for(int i=0;i<c.getCount();i++){
                   path.add(c.getInt(0));
                   vpath.add(c.getString(0));
                   c.moveToNext();

               }


               if ( vid == holder.buttonplay.getId() ){
                Log.e("1", "position = " + position);
                Toast.makeText(mContext, "Song:" + (position+1) + " is playing...", Toast.LENGTH_SHORT).show();

                 /*  if (mp!=null) {
                       if (mp.isPlaying()) {
                           mp.stop();
                       }
                       mp.release();
                       mp = null;
                   }*/
                   Log.e("as", "position = " + vpath.get(0));

                   if(Table_Name.equals("vocal") && position == 0){

                       try {
                           if (mp.isPlaying()) {
                               mp.stop();
                               mp.reset();
                           }

                           mp.setDataSource(vpath.get(0));
                           mp.prepare();
                           mp.start();
                           mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                               @Override
                               public void onCompletion(MediaPlayer mp) {
                                   mp.reset();
                               }
                           });

                       } catch (IllegalArgumentException e) {
                           e.printStackTrace();
                       } catch (IllegalStateException e) {
                           e.printStackTrace();
                       } catch (IOException e) {
                           e.printStackTrace();
                       }

                   }else {

                       try {

                           if (mp.isPlaying()) {
                               mp.stop();
                               mp.reset();
                           }

                           mp = MediaPlayer.create(mContext, path.get(mButtonClickPosition));
                           mp.start();
                       } catch (Exception e) {
                       }

                      /* mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                           @Override
                           public void onCompletion(MediaPlayer mp) {
                               mp.release();
                           }
                       });*/
                   }

                   holder.buttonplay.setImageDrawable(holder.buttonplay.getResources().getDrawable(R.drawable.picture_play_touch));





            }

               else if ( vid == holder.buttonadd.getId() ){
                  // db.execSQL("DROP TABLE IF EXISTS " + "inputmusic");
                   db.delete("inputmusic", "1", null);
                   SaveOneSong(db,mButtonClickPosition, path.get(mButtonClickPosition));
                   holder.buttonadd.setImageDrawable(holder.buttonadd.getResources().getDrawable(R.drawable.picture_add_touch));
                   Intent in = new Intent(mContext, MusicChangeActivity.class);
                  // Bundle bundle = new Bundle();
                  // bundle.putInt("ID", path.get(mButtonClickPosition) );
                  // in.putExtras(bundle);
                   in.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                   mContext.startActivity(in);

               }





        }
       public void SaveOneSong(SQLiteDatabase db, int no, int rid) {
           ContentValues cv = new ContentValues();
           cv.put("no", no);
           cv.put("path", rid);
           db = mOpenHelper.getWritableDatabase();
           db.insert("inputmusic", null, cv);
       }

    }








}

