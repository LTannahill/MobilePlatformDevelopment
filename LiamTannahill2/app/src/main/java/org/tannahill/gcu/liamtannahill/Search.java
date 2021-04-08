//Student Name:Liam Tannahill
//Student ID: 200702799
package org.tannahill.gcu.liamtannahill;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Search extends AppCompatActivity implements View.OnClickListener {

    private ArrayList<PullParser> listSearch;
    private TextView startDate;
    private TextView endDate;
    private Button searchButton;
    private LinearLayout resultList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        listSearch = (ArrayList<PullParser>) getIntent().getExtras().getSerializable("Items");
        startDate = (TextView) findViewById(R.id.startDate);
        endDate = (TextView) findViewById(R.id.endDate);
        searchButton = (Button) findViewById(R.id.searchButton);
        searchButton.setOnClickListener(this);
        resultList = (LinearLayout) findViewById(R.id.resultList);
    }


    @Override
    public void onClick(View v) {
        if (v == searchButton) {
            searchFunction();
        }
    }

    private void searchFunction() {
        SimpleDateFormat enterDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat PullParserDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss");
        ArrayList<PullParser> inPull = new ArrayList();

        try {
            Date startDateString = enterDateFormat.parse(startDate.getText().toString());
            Date endDateDateString = enterDateFormat.parse(endDate.getText().toString());

            for (int i = 0; i < listSearch.size(); i++) {
                try {
                    Date currDate = PullParserDateFormat.parse(listSearch.get(i).getPubDate());
                    if (currDate.after(startDateString) && currDate.before(endDateDateString)) {
                        inPull.add(listSearch.get(i));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            PullParser east = null;
            PullParser west = null;
            PullParser north = null;
            PullParser south = null;
            PullParser magnitude = null;
            PullParser deep = null;
            PullParser shallow = null;


            for (int f = 0; f < inPull.size(); f++) {

                if (f == 0) {
                    north = inPull.get(0);
                    south = inPull.get(0);
                    west = inPull.get(0);
                    east = inPull.get(0);
                    deep = inPull.get(0);
                    shallow = inPull.get(0);


                    //Find the most extreme cardinal locations by comparing longitude and latitude values.
                } else {
                    if (Float.parseFloat(inPull.get(f).getLatitude()) > Float.parseFloat(north.getLatitude())) {
                        north = inPull.get(f);
                    } else if (Float.parseFloat(inPull.get(f).getLatitude()) < Float.parseFloat(south.getLatitude())) {
                        south = inPull.get(f);
                    } else if (Float.parseFloat(inPull.get(f).getLongitude()) < Float.parseFloat(west.getLongitude())) {
                        west = inPull.get(f);
                    } else if (Float.parseFloat(inPull.get(f).getLongitude()) > Float.parseFloat(east.getLongitude())) {
                        east = inPull.get(f);
                    }
                }

                //Find the strongest Earthquake in the data range specified
                if (f == 0) {
                    magnitude = inPull.get(0);
                } else if (Float.parseFloat(inPull.get(f).getMagnitude()) > Float.parseFloat(magnitude.getMagnitude())) {
                    magnitude = inPull.get(f);
                }

                //find the shallowest quake
                if (f == 0) {
                    shallow = inPull.get(0);
                } else if (Float.parseFloat(inPull.get(f).getDepth()) < Float.parseFloat(shallow.getDepth())) {
                    shallow = inPull.get(f);
                }

                //find the deepest quake
                if (f == 0) {
                    deep = inPull.get(0);
                } else if (Float.parseFloat(inPull.get(f).getDepth()) > Float.parseFloat(deep.getDepth())) {
                    deep = inPull.get(f);

                }
            }

            //Add each individual piece of information to its own textview, setting the color so that it
            //is easily distinguished from the background of the applicaiton and an appropriate size.
            TextView northText = new TextView(Search.this);
            northText.setText("North: " + north.getLocation());
            northText.setTextColor((getColor(R.color.white)));
            northText.setTextSize(20);
            TextView southText = new TextView(Search.this);
            southText.setText("South: " + south.getLocation());
            southText.setTextColor((getColor(R.color.white)));
            southText.setTextSize(20);
            TextView westText = new TextView(Search.this);
            westText.setText("West: " + west.getLocation());
            westText.setTextSize(20);
            westText.setTextColor((getColor(R.color.white)));
            TextView eastText = new TextView(Search.this);
            eastText.setText("East: " + east.getLocation());
            eastText.setTextColor((getColor(R.color.white)));
            eastText.setTextSize(20);
            TextView magnitudeText = new TextView(Search.this);
            magnitudeText.setText("Magnitude: " + magnitude.getMagnitude());
            magnitudeText.setTextColor((getColor(R.color.white)));
            magnitudeText.setTextSize(20);
            TextView deepText = new TextView(Search.this);
            deepText.setTextColor((getColor(R.color.white)));
            deepText.setTextSize(20);
            deepText.setText("Deepest Quake: " + deep.getDepth() + "Kilometers");
            TextView shallowText = new TextView(Search.this);
            shallowText.setTextColor((getColor(R.color.white)));
            shallowText.setTextSize(20);
            shallowText.setText("Shallowest Quake: " + shallow.getDepth() + "Kilometers");

            //Display each of the text views in a list.
            resultList.addView(northText);
            resultList.addView(eastText);
            resultList.addView(westText);
            resultList.addView(southText);
            resultList.addView(magnitudeText);
            resultList.addView(deepText);
            resultList.addView(shallowText);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
