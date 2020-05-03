package com.example.musicapp.demo;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;

import java.util.ArrayList;
import java.util.Arrays;

public class SampleListFragment extends ScrollTabHolderFragment{

	private static final String ARG_POSITION = "position";
	public static final String TABLE_NAME_INPUTMUSIC="inputmusic";
	public static final String buttonnume_cloumn="buttonname";
	public static final String frg_cloumn="fragement";
	public static final String id_cloumn="_id";
	private ArrayList<String> mListItems;
	private MusicChangeActivity m;
	private int array[] = new int[120];
	private int mPosition;
	private DynamicGridView gridView;
	private DatabaseHelper mOpenHelper;
	private SQLiteDatabase db;
	public static Fragment newInstance(int position) {
		SampleListFragment f = new SampleListFragment();
		Bundle b = new Bundle();
		b.putInt(ARG_POSITION, position);
		f.setArguments(b);
		return f;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mPosition = getArguments().getInt(ARG_POSITION);

		mListItems = new ArrayList<String>();

		for (int i = 1; i <= 100; i++) {
			mListItems.add(i + ". item - currnet page: " + (mPosition + 1));
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.activity_music_grid, null);
		gridView = (DynamicGridView) v.findViewById(R.id.dynamic_grid);


		View placeHolderView = inflater.inflate(R.layout.view_header_placeholder,null);
		placeHolderView.setBackgroundColor(0xFFFFFFFF);
		gridView.addHeaderView(placeHolderView);

		return v;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		mOpenHelper = new DatabaseHelper(getActivity());
		db = mOpenHelper.getReadableDatabase();
		final ArrayList<String> no = new ArrayList<String>();
		final ArrayList<String> path = new ArrayList<String>();
		final Cursor c=db.rawQuery("SELECT * FROM "+ TABLE_NAME_INPUTMUSIC,null);
		c.moveToFirst();
		for(int i=0;i<c.getCount();i++){
			no.add(c.getString(1));
			path.add(c.getString(2));
			c.moveToNext();
		}

		gridView.setOnScrollListener(new OnScroll());
		//mListView.setAdapter(new ArrayAdapter<String>(getActivity(), R.layout.item_grid, R.id.item_all, mListItems));
		gridView.setAdapter(new CheeseDynamicAdapter(getActivity(),
				new ArrayList<String>(Arrays.asList(Cheeses.sCheeseStrings)),
				getResources().getInteger(R.integer.column_count)));

		db = mOpenHelper.getWritableDatabase();
		m = new MusicChangeActivity();

		gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
				//gridView.startWobbleAnimation();
				//db.delete("recordmusic","1",null);

					//SaveOneSong(db,Integer.parseInt(no.get(0)),Integer.parseInt(path.get(0)),String.valueOf(mPosition),String.valueOf(position) );
				/*for(int i=0;i<24;i++){
					SaveOneSong(db,Integer.parseInt(no.get(0)),Integer.parseInt(path.get(0)),String.valueOf(0),String.valueOf(i) );}
				for(int i=0;i<24;i++){
					SaveOneSong(db,Integer.parseInt(no.get(0)),Integer.parseInt(path.get(0)),String.valueOf(1),String.valueOf(i) );}
				for(int i=0;i<24;i++){
					SaveOneSong(db,Integer.parseInt(no.get(0)),Integer.parseInt(path.get(0)),String.valueOf(2),String.valueOf(i) );}
				for(int i=0;i<24;i++){
					SaveOneSong(db,Integer.parseInt(no.get(0)),Integer.parseInt(path.get(0)),String.valueOf(3),String.valueOf(i) );}
				for(int i=0;i<24;i++){
					SaveOneSong(db,Integer.parseInt(no.get(0)),Integer.parseInt(path.get(0)),String.valueOf(4),String.valueOf(i) );}*/
				update(db,Integer.parseInt(no.get(0)),Integer.parseInt(path.get(0)),String.valueOf(mPosition),String.valueOf(position));
				Log.e("qw", "no = " + Integer.parseInt(no.get(0)) + " path = " + Integer.parseInt(path.get(0)) + " frg = " + mPosition + " button = " + (position));



			}
		});

		gridView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
			@Override
			public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
				//gridView.startWobbleAnimation();
				//gridView.stopWobble(true);
				return true;
			}
		});

		if(MusicChangeActivity.NEEDS_PROXY){//in my moto phone(android 2.1),setOnScrollListener do not work well
			gridView.setOnTouchListener(new OnTouchListener() {
				@Override
				public boolean onTouch(View v, MotionEvent event) {
					if (mScrollTabHolder != null)
						mScrollTabHolder.onScroll(gridView, 0, 0, 0, mPosition);
					return false;
				}
			});
		}
	}

	@Override
	public void adjustScroll(int scrollHeight) {
		if (scrollHeight == 0 && gridView.getFirstVisiblePosition() >= 1) {
			return;
		}

		//gridView.setSelectionFromTop(1, scrollHeight);

	}
	
	public class OnScroll implements OnScrollListener {

		@Override
		public void onScrollStateChanged(AbsListView view, int scrollState) {
			
		}

		@Override
		public void onScroll(AbsListView view, int firstVisibleItem,
				int visibleItemCount, int totalItemCount) {
			if (mScrollTabHolder != null)
				mScrollTabHolder.onScroll(view, firstVisibleItem, visibleItemCount, totalItemCount, mPosition);
		}
		
	}


	@Override
	public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount, int pagePosition) {
	}
	public void SaveOneSong(SQLiteDatabase db, int no, int rid,String f ,String b) {
		ContentValues cv = new ContentValues();
		cv.put("no", no);
		cv.put("path", rid);
		cv.put("fragement", f);
		cv.put("buttonname", b);
		db = mOpenHelper.getWritableDatabase();
		db.insert("recordmusic", null, cv);
	}
	public void update(SQLiteDatabase db, int no, int rid,String f ,String b) {
		ContentValues cv = new ContentValues();
		cv.put("no", no);
		cv.put("path", rid);
		cv.put("fragement", f);
		cv.put("buttonname", b);
		db = mOpenHelper.getWritableDatabase();

		for(int i=0;i<120;i++){
			array[i] = i+1;
		}
		if(f.equals("0"))
			db.update("recordmusic", cv, id_cloumn + "=" + array[Integer.parseInt(b)], null);

		else if(f.equals("1")){
			db.update("recordmusic", cv, id_cloumn + "=" + array[Integer.parseInt(b)+24], null);
		}
		else if(f.equals("2")){
			db.update("recordmusic", cv, id_cloumn + "=" + array[Integer.parseInt(b)+48], null);
		}
		else if(f.equals("3")){
			db.update("recordmusic", cv, id_cloumn + "=" + array[Integer.parseInt(b)+72], null);
		}
		else if(f.equals("4")){
			db.update("recordmusic", cv, id_cloumn + "=" + array[Integer.parseInt(b)+96], null);
		}

		//db.update("recordmusic", cv, buttonnume_cloumn + "=" + b, null);
		Log.e("qqq","id_cloumn = "+id_cloumn+ " frg = " +f +" button = "+array[Integer.parseInt(b)]);
	}
}