package com.example.user.chennai20design;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class NewProblemActivity extends Activity {


    private ProgressDialog pDialog;

    JSONParser jsonParser = new JSONParser();
    EditText edtPlaceName,edtLandMark,edtProblem,edtAltRoute;
    Button btnAdd;


    private static String url_create_product = "http://10.0.2.2/Prob/create_problem.php";


    private static final String TAG_SUCCESS = "success";

    CarouselView carouselView;
    int[] sampleImages = {R.drawable.aerial1, R.drawable.broken, R.drawable.kathipara, R.drawable.skyscrapper, R.drawable.aerial2,R.drawable.broken2, R.drawable.monuments, R.drawable.kathipara2, R.drawable.city, R.drawable.gandhica};


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_problem);


        edtPlaceName = (EditText) findViewById(R.id.placename);
        edtLandMark = (EditText) findViewById(R.id.landmark);
        edtProblem = (EditText) findViewById(R.id.problem);
        edtAltRoute = (EditText) findViewById(R.id.altroute);

        carouselView = (CarouselView) findViewById(R.id.carouselViewProb);
        carouselView.setPageCount(sampleImages.length);

        carouselView.setImageListener(imageListener);



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.btngo);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new CreateNewProblem().execute();
            }
        });

    }

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(NewProblemActivity.this,FirstScreen.class);
        startActivity(intent);
        finish();
    }

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(sampleImages[position]);
        }
    };

    class CreateNewProblem extends AsyncTask<String, String, String> {


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(NewProblemActivity.this);
            pDialog.setMessage("Creating Problem..");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();
        }

            protected String doInBackground(String... args) {

            String placename = edtPlaceName.getText().toString();
            String landmark = edtLandMark.getText().toString();
            String problem= edtProblem.getText().toString();
            String altRoute= edtAltRoute.getText().toString();


            List<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("placename", placename));
            params.add(new BasicNameValuePair("landmark", landmark));
            params.add(new BasicNameValuePair("problem", problem));
            params.add(new BasicNameValuePair("altroute", altRoute));


            JSONObject json = jsonParser.makeHttpRequest(url_create_product,
                    "POST", params);


            Log.d("Create Response", json.toString());


            try {
                int success = json.getInt(TAG_SUCCESS);

                if (success == 1) {



                } else {

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }


        protected void onPostExecute(String file_url) {

            pDialog.dismiss();

        }

    }
}