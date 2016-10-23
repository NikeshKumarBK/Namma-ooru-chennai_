package com.example.user.chennai20design;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;


public class TrainList extends ListActivity {

    int train_no;
    String src,dest,time,delay,strFrom,strTo;
    TextView txtFrom,txtTo;
    ListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.time_list);

        SqlCommands repo=new SqlCommands(this);

        Intent intent=getIntent();
        src=intent.getStringExtra("src");
        dest=intent.getStringExtra("dest");
        time=intent.getStringExtra("time");
        strFrom=intent.getStringExtra("srctxt");
        strTo=intent.getStringExtra("desttxt");


        txtFrom=(TextView)findViewById(R.id.txtFrom);
        txtTo=(TextView)findViewById(R.id.txtTo);

        txtFrom.setText(strFrom);
        txtTo.setText(strTo);

        delay=repo.getTimeDelay(src);
        train_no=repo.getTrainNo(src,time,delay);

        Log.e("check", "" + train_no + " " + src + " " + dest);

        ArrayList<HashMap<String,String>> timeList=repo.getTrainList(String.valueOf(train_no),src,dest);

        if (timeList.size()!=0){
            ListView lv= getListView();

            adapter=new SimpleAdapter(TrainList.this,timeList,R.layout.view_train_time,new String[]{"station_name","train_no"},new int[]{R.id.station_name,R.id.station_time});
            setListAdapter(adapter);
        }else {
            Toast.makeText(this, "No trains Available", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(TrainList.this,FirstScreen.class);
        startActivity(intent);
        finish();
    }
}
