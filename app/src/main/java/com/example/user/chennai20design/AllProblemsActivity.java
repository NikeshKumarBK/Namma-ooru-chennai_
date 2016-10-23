package com.example.user.chennai20design;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import org.apache.http.NameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AllProblemsActivity extends ListActivity {


    private ProgressDialog pDialog;


    JSONParser jParser = new JSONParser();

    ArrayList<HashMap<String, String>> productsList;


    private static String url_all_products = "http://10.0.2.2/Prob/get_all_problem.php";


    private static final String TAG_SUCCESS = "success";
    private static final String TAG_PRODUCTS = "products";
    private static final String TAG_PID = "id";
    private static final String TAG_NAME = "placename";
    private static final String TAG_LANDMARK = "landmark";
    private static final String TAG_PROBLEM = "problem";
    private static final String TAG_ALTROUTE= "altroute";


    JSONArray products = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.all_problems);


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


    class LoadAllProducts extends AsyncTask<String, String, String> {


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(AllProblemsActivity.this);
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


                        HashMap<String, String> map = new HashMap<String, String>();


                        map.put(TAG_PID, id);
                        map.put(TAG_NAME, name);
                        map.put(TAG_LANDMARK, landmark);
                        map.put(TAG_PROBLEM, problem);
                        map.put(TAG_ALTROUTE, altroute);

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
                            AllProblemsActivity.this, productsList,
                            R.layout.list_item, new String[] { TAG_PID,
                            TAG_NAME,TAG_LANDMARK,TAG_PROBLEM,TAG_ALTROUTE},
                            new int[] { R.id.pid, R.id.allPlaceName, R.id.allLandMark,R.id.allProb,R.id.allAltRoute });

                    setListAdapter(adapter);
                }
            });

        }

    }
}