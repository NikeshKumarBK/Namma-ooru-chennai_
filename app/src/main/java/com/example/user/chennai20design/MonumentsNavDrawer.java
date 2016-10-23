package com.example.user.chennai20design;

import android.content.Intent;
import android.os.Bundle;
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
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MonumentsNavDrawer extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    String[] android_versions={"Anna Memorial","Birla Planaturium","Chennai Turtle Walk"
            ,"Chokhi Dhani","Egmore Museum","Gandhi Statue","Light House","Labour Statue","Bharathiar Statue","Kannagi Statue","Netaji Subhas Chandra Bose Statue","Thiruvalluvar Statue","G U Pope Statue","Bharathidasan Statue","Avvaiyar Statue","Veeramamunivar Statue","MGR Memorial"};

    public static final Integer[] images={R.drawable.anna,R.drawable.birla,R.drawable.walk,
            R.drawable.chokhi,R.drawable.egmore,R.drawable.gandhi,R.drawable.lighthouse,R.drawable.statuemarinabeach,R.drawable.e,R.drawable.yy,R.drawable.ooo,R.drawable.dd,R.drawable.gu,R.drawable.k,R.drawable.a,R.drawable.v,R.drawable.memorial};

    ListView listView;
    ArrayAdapter<String> adapter;
    List<RowItem> rowItems;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places_nav_drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        rowItems = new ArrayList<RowItem>();
        for (int i = 0; i < android_versions.length; i++) {
            RowItem item = new RowItem(images[i], android_versions[i]);
            rowItems.add(item);
        }

        listView=(ListView)findViewById(R.id.listView);

        CustomListViewAdapter adapter = new CustomListViewAdapter(this,
                R.layout.single_list_row, rowItems);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                Intent intent = new Intent(MonumentsNavDrawer.this, PlaceDesc.class);
                long pos = parent.getItemIdAtPosition(position);
                intent.putExtra("id", pos);
                Log.e("Check", String.valueOf(pos));

                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            Intent intent=new Intent(MonumentsNavDrawer.this,FirstScreen.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.places_nav_drawer, menu);
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
            Intent intent=new Intent(MonumentsNavDrawer.this,FirstScreen.class);
            startActivity(intent);
            finish();
        } else if (id == R.id.nav_gallery) {
            Intent intent=new Intent(MonumentsNavDrawer.this,NatParkNavDrawer.class);
            startActivity(intent);
            finish();
        } else if (id == R.id.nav_slideshow) {
            Intent intent=new Intent(MonumentsNavDrawer.this,SpiritualNavDrawer.class);
            startActivity(intent);
            finish();
        } else if (id == R.id.nav_share) {
            Intent intent=new Intent(MonumentsNavDrawer.this,MainActivity.class);
            startActivity(intent);
            finish();
        }else if (id == R.id.nav_probs) {
            Intent intent=new Intent(MonumentsNavDrawer.this,Problems.class);
            startActivity(intent);
            finish();
        }else if (id == R.id.nav_about) {
            Intent intent=new Intent(MonumentsNavDrawer.this,About.class);
            startActivity(intent);
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
