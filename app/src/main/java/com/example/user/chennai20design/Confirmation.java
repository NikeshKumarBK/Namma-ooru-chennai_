package com.example.user.chennai20design;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Confirmation extends ListActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    private ProgressDialog pDialog;


    JSONParser jParser = new JSONParser();

    ArrayList<HashMap<String, String>> productsList;


    private static String url_all_products = "http://10.0.2.2/Prob/get_all_prob_confirm.php";


    private static String url_update_product = "http://10.0.2.2/Prob/update_problem.php";


    private static final String TAG_SUCCESS = "success";
    private static final String TAG_PRODUCTS = "products";
    private static final String TAG_PID = "id";
    private static final String TAG_NAME = "placename";
    private static final String TAG_LANDMARK = "landmark";
    private static final String TAG_PROBLEM = "problem";
    private static final String TAG_ALTROUTE= "altroute";
    private static final String TAG_SOLVED= "solved";

    String row_id,solved;
    int inter;


    JSONArray products = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);



        productsList = new ArrayList<HashMap<String, String>>();


        new LoadAllProducts().execute();


        ListView lv = getListView();


        lv.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                String pid = ((TextView) view.findViewById(R.id.pid)).getText()
                        .toString();




            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);




    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == 100) {

            Intent intent = getIntent();
            finish();
            startActivity(intent);
        }

    }

    public void btnClickProbSolved(View v)
    {


        LinearLayout vwParentRow = (LinearLayout)v.getParent();

        TextView child = (TextView)vwParentRow.getChildAt(0);
        TextView solve= (TextView)vwParentRow.getChildAt(5);
        ImageButton btnChild = (ImageButton)vwParentRow.getChildAt(6);


        row_id=child.getText().toString();
        solved=solve.getText().toString();
        inter= Integer.parseInt(solved)+1;
        solved= String.valueOf(inter);
        vwParentRow.refreshDrawableState();

        new SaveProductDetails().execute();


    }

    class SaveProductDetails extends AsyncTask<String, String, String> {


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(Confirmation.this);
            pDialog.setMessage("Saving product ...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();
        }




        protected String doInBackground(String... args) {




            List<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair(TAG_PID, row_id));
            params.add(new BasicNameValuePair(TAG_SOLVED, solved));


                JSONObject json = jParser.makeHttpRequest(url_update_product,
                    "POST", params);


            try {
                int success = json.getInt(TAG_SUCCESS);

                if (success == 1) {

                    Intent i = getIntent();

                    setResult(100, i);
                    finish();
                } else {

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }


        protected void onPostExecute(String file_url) {

            pDialog.dismiss();
            Intent intent=new Intent(Confirmation.this,Confirmation.class);
            startActivity(intent);
            finish();
        }
    }



    class LoadAllProducts extends AsyncTask<String, String, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(Confirmation.this);
            pDialog.setMessage("Loading products. Please wait...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(false);
            pDialog.show();
        }


        protected String doInBackground(String... args) {

            List<NameValuePair> params = new ArrayList<NameValuePair>();

            JSONObject json = jParser.makeHttpRequest(url_all_products, "GET", params);


            Log.d("All Products: ", json.toString());

            try {

                int success = json.getInt(TAG_SUCCESS);

                if (success == 1) {

                    products = json.getJSONArray(TAG_PRODUCTS);


                    for (int i = 0; i < products.length(); i++) {
                        JSONObject c = products.getJSONObject(i);


                        String id = c.getString(TAG_PID);
                        String name = c.getString(TAG_NAME);
                        String landmark=c.getString(TAG_LANDMARK);
                        String problem=c.getString(TAG_PROBLEM);
                        String altroute=c.getString(TAG_ALTROUTE);
                        String solved=c.getString(TAG_SOLVED);


                        HashMap<String, String> map = new HashMap<String, String>();


                        map.put(TAG_PID, id);
                        map.put(TAG_NAME, name);
                        map.put(TAG_LANDMARK, landmark);
                        map.put(TAG_PROBLEM, problem);
                        map.put(TAG_ALTROUTE, altroute);
                        map.put(TAG_SOLVED, solved);


                        productsList.add(map);
                    }
                } else {

                    Intent i = new Intent(getApplicationContext(),
                            NewProblemActivity.class);

                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(i);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }


        protected void onPostExecute(String file_url) {

            pDialog.dismiss();

            runOnUiThread(new Runnable() {
                public void run() {

                    ListAdapter adapter = new SimpleAdapter(
                            Confirmation.this, productsList,
                            R.layout.list_item, new String[] { TAG_PID,
                            TAG_NAME,TAG_LANDMARK,TAG_PROBLEM,TAG_ALTROUTE,TAG_SOLVED},
                            new int[] { R.id.pid, R.id.allPlaceName, R.id.allLandMark,R.id.allProb,R.id.allAltRoute ,R.id.allSolved});

                    setListAdapter(adapter);
                }
            });

        }

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.problems, menu);
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

        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
