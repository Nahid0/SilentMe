package com.placefinder.simon.placefinder;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class SearchActivity2 extends AppCompatActivity {

    RelativeLayout rl;
    LinearLayout saMainLn,saSubLn1,saSubLn2;
    EditText editText;
    Button sabutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //----------- initilization -----------
        rl = (RelativeLayout) findViewById(R.id.SArelativelayout);
        saMainLn = (LinearLayout) findViewById(R.id.SAmainLinear);
        saSubLn1 = (LinearLayout) findViewById(R.id.SAsublinear1);
        saSubLn2 = (LinearLayout) findViewById(R.id.SAsublinear2);

        editText = (EditText) findViewById(R.id.SAeditText);
        sabutton = (Button) findViewById(R.id.SAbutton);

        final GPSTracker1 gps = new GPSTracker1(this);// -------- gps class --------
        final LocationManager manager = (LocationManager) getSystemService( Context.LOCATION_SERVICE );

        //----------- end of initialization -------

        //---------- search button block -----------
        sabutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double lat, lng;
                String textValues = editText.getText().toString();
                Toast.makeText(getBaseContext(), textValues, Toast.LENGTH_LONG).show();

                if (textValues.isEmpty()) {
                    String values = "Please Enetre An address";

                    Toast.makeText(getBaseContext(), values, Toast.LENGTH_LONG).show();

                } else {
                    lat = gps.getLatitude();
                    lng = gps.getLongitude();

                    //String la1 = Double.toString(lat);
                    //String ln1 = Double.toString(lng);

                    if (!manager.isProviderEnabled( LocationManager.GPS_PROVIDER )) {
                        //String str = "pls check connection";
                        //Toast.makeText(getBaseContext(), textValues, Toast.LENGTH_LONG).show();
                        showSettingsAlert();
                    } else {

                        String geoURI = String.format("geo:%f,%f?q=" + textValues, lat, lng);
                        Uri geo = Uri.parse(geoURI);
                        Intent geoMap = new Intent(Intent.ACTION_VIEW, geo);
                        startActivity(geoMap);
                    }
                }
            }
        });

    }


        //----------- Alert method ---------

        public void showSettingsAlert() {
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(
                    SearchActivity2.this);
            alertDialog.setTitle("SETTINGS");
            alertDialog.setMessage("Enable Location Provider! Go to settings menu?");
            alertDialog.setPositiveButton("Settings",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(
                                    Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                            SearchActivity2.this.startActivity(intent);
                        }
                    });
            alertDialog.setNegativeButton("Cancel",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
            alertDialog.show();
        }
        //---------- end ---------------



        //--------- end of search button block ------


}


