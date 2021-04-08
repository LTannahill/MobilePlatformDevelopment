//Student Name:Liam Tannahill
//Student ID: 200702799

package org.tannahill.gcu.liamtannahill;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ExtraInfo extends AppCompatActivity implements View.OnClickListener {


    LinearLayout ExtraData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extra);
        ExtraData = (LinearLayout) findViewById(R.id.ExtraData);
        Bundle bundle = getIntent().getExtras();

        //The below code has been commented out as it dumped the un-split description, it was
        //determined to be more beneficial to instead the individual tags so appropriate spacing
        //and padding could be applied to each block of text.

        //TextView descriptionView = new TextView(ExtraInfo.this);
        //String Description = bundle.getString("Description");
        //descriptionView.setText(Description);
        //ExtraData.addView(descriptionView);

        //The location of the earthquake with be included with the extended information, a font
        //size of 20, with some padding at the top and bottom of the has been applied to make it
        //look good visually.

        TextView locationView = new TextView(ExtraInfo.this);
        String locString = "Earthquake Location: " + "\n" + bundle.getString("location");
        locationView.setText(locString);
        locationView.setTextColor((getColor(R.color.white)));
        locationView.setTextSize(20);
        locationView.setPadding(0, 15, 0, 15);
        ExtraData.addView(locationView);

        //The date which the earthquake was publisihed on the API, with the same designs
        //applied

        TextView dateView = new TextView(ExtraInfo.this);
        String dateString = "Date of Earthquake: " + "\n" + bundle.getString("date");
        dateView.setText(dateString);
        dateView.setTextColor((getColor(R.color.white)));
        dateView.setTextSize(20);
        dateView.setPadding(0, 15, 0, 15);
        ExtraData.addView(dateView);

        //The latitude coordinate of the earthquake.

        TextView latView = new TextView(ExtraInfo.this);
        String latString = "Latitude: " + bundle.getString("geoLat");
        latView.setText(latString);
        latView.setTextColor((getColor(R.color.white)));
        latView.setTextSize(20);
        latView.setPadding(0, 15, 0, 15);
        ExtraData.addView(latView);

        //The longitude of the earthquake.

        TextView longView = new TextView(ExtraInfo.this);
        String longString = "Longitude: " + bundle.getString("geoLong");
        longView.setText(longString);
        longView.setTextColor((getColor(R.color.white)));
        longView.setTextSize(20);
        longView.setPadding(0, 15, 0, 15);
        ExtraData.addView(longView);

        //category was ommited as it has the same value for every quake.
        //TextView categoryView = new TextView(ExtraInfo.this);
        //String categoryString = "Category " + bundle.getString("categoryLong");
        //categoryView.setText(categoryString);
        //ExtraData.addView(categoryView);

        //The depth of the quake.
        TextView depthView = new TextView(ExtraInfo.this);
        String depthString = "Depth of Earthquake: " + bundle.getString("depth") + "KM";
        depthView.setText(depthString);
        depthView.setTextColor((getColor(R.color.white)));
        depthView.setTextSize(20);
        depthView.setPadding(0, 15, 0, 15);
        ExtraData.addView(depthView);

        //The strength quake.
        TextView magnitudeView = new TextView(ExtraInfo.this);
        String magnitudeString = "Magnitude of Earthquake: " + bundle.getString("magnitude");
        magnitudeView.setText(magnitudeString);
        magnitudeView.setTextColor((getColor(R.color.white)));
        magnitudeView.setTextSize(20);
        magnitudeView.setPadding(0, 15, 0, 15);
        ExtraData.addView(magnitudeView);


    }


    @Override
    public void onClick(View v) {

    }


}
