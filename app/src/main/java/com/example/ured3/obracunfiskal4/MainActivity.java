package com.example.ured3.obracunfiskal4;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    LinearLayout ImgPrijava;
    ImageView ImgArtikl;
    LinearLayout ImgPregled;
    ImageView ImgKupac;
    ImageView ImgNalog;
    ImageView ImgPregledArtikla;
    TextView textGrid;
    LinearLayout ImgPregledNaloga;
    Typeface tf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Calendar calendar = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance().format(calendar.getTime());

        TextView date= findViewById(R.id.tv_date);
        date.setText(currentDate);

        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    while (!isInterrupted()) {
                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {

                                TextView tdate = (TextView) findViewById(R.id.textGrid);
                                long date = System.currentTimeMillis();
                                SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
                                String dateString = sdf.format(date);
                                tdate.setText(dateString);


                            }

                        });
                    }
                } catch (InterruptedException e) {
                }
            }
        };
        t.start();


        textGrid = (TextView) findViewById(R.id.textGrid);
        ImgPrijava = (LinearLayout) findViewById(R.id.ImgPrijava);

        ImgPrijava.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,PrijavaArtikla.class);
                startActivity(intent);
            }
        });


    }}
