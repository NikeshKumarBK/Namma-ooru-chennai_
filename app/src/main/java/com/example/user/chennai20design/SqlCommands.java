package com.example.user.chennai20design;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;


public class SqlCommands {
    private DBHelper dbHelper;

    public SqlCommands(Context context) {
        dbHelper = new DBHelper(context);
    }

    public String getTimeDelay(String src)
    {
        SQLiteDatabase db=dbHelper.getReadableDatabase();
        String query_time="SELECT `time_fwd` FROM `station_phase1` WHERE `station_id`="+src+"";

        Cursor c = db.rawQuery(query_time, null);
        c.moveToFirst();
        String i = c.getString(0);
        Log.e("Check", i);
        return i;
    }

    public int getTrainNo(String src,String time,String delay)
    {

        SQLiteDatabase db=dbHelper.getReadableDatabase();

        String query="select train_no from train_no where start_time>(time(julianday('"+time+"') - julianday('"+delay+"') - .5)) order by start_time asc limit 1";





        Cursor c = db.rawQuery(query, null);
        c.moveToFirst();
        int i = c.getInt(0);
        return i;
    }

    public ArrayList<HashMap<String,String>> getTrainList(String train_no,String src,String dest) {



        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String selectQuery="SELECT `"+train_no+"` as train_no,`station_name` FROM `fwdphase1` WHERE `station_id`>"+src+" and `station_id`<"+dest+"";

        String selectQuery1 =  "SELECT '" +
                train_no+ "' as trainNo," +
                Train.STATION_NAME +
                " FROM " + Train.TABLE_STATION_1+" WHERE "+ Train.STATION_ID+">? AND "+Train.STATION_ID+"<?";


        ArrayList<HashMap<String, String>> trainTimeList = new ArrayList<HashMap<String, String>>();

        Cursor cursor = db.rawQuery(selectQuery,null);



        Log.e("Booking", "after query execution");
        if (cursor.moveToFirst()) {
            do {
                HashMap<String, String> time = new HashMap<String, String>();
                time.put("station_name", cursor.getString(cursor.getColumnIndex(Train.STATION_NAME)));
                time.put("train_no", cursor.getString(cursor.getColumnIndex("train_no")));

                trainTimeList.add(time);

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return trainTimeList;

    }

}
