package com.example.user.chennai20design;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Spinner from,to;
    String selecttime,txtFrom,txtTo;
    TimePicker timePick;
    int fromtxt,totxt;
    String[] fromArr={"Tambaram","Tambaram Sanatorium","Chrompet","Pallavaram","Thirusulam","Minambakkam","Palavanthangal","St.Thomas Mount","Guindy","Saidapet","Mambalam","Kodambakkam","Nungambakkam","Chetpet","Chennai Egmore","Chennai Park","Chennai Fort","Chennai Beach"};
    String[] toArr={"Tambaram","Tambaram Sanatorium","Chrompet","Pallavaram","Thirusulam","Minambakkam","Palavanthangal","St.Thomas Mount","Guindy","Saidapet","Mambalam","Kodambakkam","Nungambakkam","Chetpet","Chennai Egmore","Chennai Park","Chennai Fort","Chennai Beach"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, TrainList.class);

                fromtxt=from.getSelectedItemPosition();
                totxt=to.getSelectedItemPosition();

                txtFrom= (String) from.getItemAtPosition(fromtxt);
                txtTo= (String) to.getItemAtPosition(totxt);
                Log.e("check", String.valueOf(txtFrom));

                Log.e("check", String.valueOf(fromtxt));
                Log.e("check", String.valueOf(totxt));

                intent.putExtra("src", String.valueOf(fromtxt));
                intent.putExtra("dest", String.valueOf(totxt));
                intent.putExtra("srctxt", String.valueOf(txtFrom));
                intent.putExtra("desttxt",String.valueOf(txtTo));


                SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");


                int hour = timePick.getCurrentHour();
                int min = timePick.getCurrentMinute();

                if (hour==0 || hour== 1 ||hour==2 || hour== 3 ||hour==4 || hour== 5 ||hour==6 || hour== 7 ||hour==8 || hour== 9 )
                {
                    if (min==0 || min== 1 ||min==2 || min== 3 ||min==4 || min== 5 ||min==6 || min== 7 ||min==8 || min== 9 )
                    {
                        selecttime = String.valueOf("0"+hour + ":0" + min+":00");
                    }
                    else   {
                        selecttime = String.valueOf("0"+hour + ":" + min+":00");
                    }
                }
                else if (min==0 || min== 1 ||min==2 || min== 3 ||min==4 || min== 5 ||min==6 || min== 7 ||min==8 || min== 9)
                {
                        selecttime = String.valueOf(hour + ":0" + min + ":00");
                }

                else  {
                    selecttime = String.valueOf(hour + ":" + min+":00");
                }

                Log.e("check", selecttime);
                intent.putExtra("time", selecttime);
                startActivity(intent);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        from=(Spinner)findViewById(R.id.from);
        to=(Spinner)findViewById(R.id.to);
        timePick=(TimePicker)findViewById(R.id.timePick);

        ArrayAdapter<String> fromArray=new ArrayAdapter<String>(MainActivity.this,R.layout.spinner_item,fromArr);
        from.setAdapter(fromArray);

        ArrayAdapter<String> toArray=new ArrayAdapter<String>(MainActivity.this,R.layout.spinner_item,toArr);
        to.setAdapter(toArray);

        timePick.setIs24HourView(true);
        Log.e("check", timePick.toString());




        from.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {



            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        to.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            Intent intent=new Intent(MainActivity.this,FirstScreen.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        int id = item.getItemId();


        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.nav_camera) {

            Intent intent=new Intent(MainActivity.this,FirstScreen.class);
            startActivity(intent);
            finish();
        } else if (id == R.id.nav_gallery) {
            Intent intent=new Intent(MainActivity.this,MonumentsNavDrawer.class);
            startActivity(intent);
            finish();

        } else if (id == R.id.nav_slideshow) {
            Intent intent=new Intent(MainActivity.this,NatParkNavDrawer.class);
            startActivity(intent);
            finish();
        } else if (id == R.id.nav_manage) {
            Intent intent=new Intent(MainActivity.this,SpiritualNavDrawer.class);
            startActivity(intent);
            finish();
        } else if (id == R.id.nav_probs) {
            Intent intent=new Intent(MainActivity.this,Problems.class);
            startActivity(intent);
            finish();
        }else if (id == R.id.nav_about) {
            Intent intent=new Intent(MainActivity.this,About.class);
            startActivity(intent);
            finish();
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
