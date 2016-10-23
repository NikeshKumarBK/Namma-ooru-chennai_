package com.example.user.chennai20design;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

public class FirstScreen extends AppCompatActivity {

    CarouselView carouselView;
    Button btnFor,btnTo,btnBy;
    ImageButton imgMonu,imgNat,imgSpi;

    int[] sampleImages = {R.drawable.aerial1, R.drawable.broken, R.drawable.kathipara, R.drawable.skyscrapper, R.drawable.aerial2,R.drawable.broken2, R.drawable.monuments, R.drawable.kathipara2, R.drawable.city, R.drawable.gandhica};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        btnFor=(Button)findViewById(R.id.btnFor);
        btnTo=(Button)findViewById(R.id.btnTo);
        btnBy=(Button)findViewById(R.id.btnBy);


        carouselView = (CarouselView) findViewById(R.id.carouselView);
        carouselView.setPageCount(sampleImages.length);

        carouselView.setImageListener(imageListener);

        btnFor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstScreen.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btnBy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Not yet completed!! Building!!",Toast.LENGTH_LONG).show();
            }
        });


        btnTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog alertDialog = new Dialog(FirstScreen.this);
                alertDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                alertDialog.setContentView(R.layout.places);
                alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                alertDialog.show();

                imgMonu=(ImageButton)alertDialog.findViewById(R.id.imageButton3);
                imgNat=(ImageButton)alertDialog.findViewById(R.id.imageButton);
                imgSpi=(ImageButton)alertDialog.findViewById(R.id.imageButton2);

                imgMonu.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(FirstScreen.this,MonumentsNavDrawer.class);
                        startActivity(intent);
                        finish();
                    }
                });

                imgSpi.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(FirstScreen.this,SpiritualNavDrawer.class);
                        startActivity(intent);
                        finish();
                    }
                });

                imgNat.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(FirstScreen.this,NatParkNavDrawer.class);
                        startActivity(intent);
                        finish();
                    }
                });
            }
        });



    }

    boolean doubleBackToExitPressedOnce = false;
    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(sampleImages[position]);
        }
    };

}
