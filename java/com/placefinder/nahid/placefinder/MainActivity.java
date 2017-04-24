package com.placefinder.simon.placefinder;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //------------- initial codes -----------

    GridView grid;
    String[] web = {
            "Hospitals",
            "PoliceStation",
            "Pharmacy",
            "School",
            "College",
            "University",
            "Bank",
            "ATM Both",
            "Resturant",
            "Hotel",
            "Search"


    } ;
    int[] imageId = {
            R.drawable.hospital1,
            R.drawable.policestation1,
            R.drawable.pharmacy1,
            R.drawable.school2,
            R.drawable.college1,
            R.drawable.university1,
            R.drawable.bank1,
            R.drawable.atm2,
            R.drawable.resturant1,
            R.drawable.hotel,
            R.drawable.search


    };



    double lat=0.0,lng=0.0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final GPSTracker1 gps = new GPSTracker1(this);
       //---------- Custom GridView Implementation -------------

        CustomGrid adapter = new CustomGrid(MainActivity.this, web, imageId);

        grid=(GridView)findViewById(R.id.grid);
        grid.setAdapter(adapter);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(MainActivity.this, "You Clicked at " + web[+position], Toast.LENGTH_SHORT).show();

               //------------Hospital blocks -------------------
                if(web[+position]=="Hospitals"){


                    lat = gps.getLatitude();
                    lng = gps.getLongitude();
                    String lat1 = Double.toString(lat);
                    String lng1 = Double.toString(lng);

                    if(lat1==""&&lng1==""){

                        //String str = "pls check connection";
                        //Toast.makeText(getBaseContext(), str, Toast.LENGTH_LONG).show();
                        showSettingsAlert();
                    }

                    else {

                        String geoURI = String.format("geo:%f,%f?q=hospital", lat, lng);
                        Uri geo = Uri.parse(geoURI);
                        Intent geoMap = new Intent(Intent.ACTION_VIEW, geo);
                        startActivity(geoMap);
                    }


                }
                //----------- end of hospital block ----------------

                //------------ police station blocks -------------------
               else if(web[+position]=="PoliceStation"){


                    lat = gps.getLatitude();
                    lng = gps.getLongitude();

                    if(lat==0.0&&lng==0.0){
                        String str = "pls check connection";
                        Toast.makeText(getBaseContext(), str, Toast.LENGTH_LONG).show();
                    }

                    else {

                        String geoURI = String.format("geo:%f,%f?q=police station", lat, lng);
                        Uri geo = Uri.parse(geoURI);
                        Intent geoMap = new Intent(Intent.ACTION_VIEW, geo);
                        startActivity(geoMap);
                    }


                }
                //----------- end of police station block ----------------

                //------------ pharmacy blocks -------------------
                else if(web[+position]=="Pharmacy"){


                    lat = gps.getLatitude();
                    lng = gps.getLongitude();

                    if(lat==0.0&&lng==0.0){
                        String str = "pls check connection";
                        Toast.makeText(getBaseContext(), str, Toast.LENGTH_LONG).show();
                    }

                    else {

                        String geoURI = String.format("geo:%f,%f?q=Pharmacy", lat, lng);
                        Uri geo = Uri.parse(geoURI);
                        Intent geoMap = new Intent(Intent.ACTION_VIEW, geo);
                        startActivity(geoMap);
                    }


                }
                //----------- end of pharmacy block ----------------



                //------------ School blocks -------------------
                else if(web[+position]=="School"){


                    lat = gps.getLatitude();
                    lng = gps.getLongitude();

                    if(lat==0.0&&lng==0.0){
                        String str = "pls check connection";
                        Toast.makeText(getBaseContext(), str, Toast.LENGTH_LONG).show();
                    }

                    else {

                        String geoURI = String.format("geo:%f,%f?q=School", lat, lng);
                        Uri geo = Uri.parse(geoURI);
                        Intent geoMap = new Intent(Intent.ACTION_VIEW, geo);
                        startActivity(geoMap);
                    }


                }
                //----------- end of School block ----------------


                //------------ College blocks -------------------
                else if(web[+position]=="College"){


                    lat = gps.getLatitude();
                    lng = gps.getLongitude();

                    if(lat==0.0&&lng==0.0){
                        String str = "pls check connection";
                        Toast.makeText(getBaseContext(), str, Toast.LENGTH_LONG).show();
                    }

                    else {

                        String geoURI = String.format("geo:%f,%f?q=College", lat, lng);
                        Uri geo = Uri.parse(geoURI);
                        Intent geoMap = new Intent(Intent.ACTION_VIEW, geo);
                        startActivity(geoMap);
                    }


                }
                //----------- end of College block ----------------


                //------------ University blocks -------------------
                else if(web[+position]=="University"){


                    lat = gps.getLatitude();
                    lng = gps.getLongitude();

                    if(lat==0.0&&lng==0.0){
                        String str = "pls check connection";
                        Toast.makeText(getBaseContext(), str, Toast.LENGTH_LONG).show();
                    }

                    else {

                        String geoURI = String.format("geo:%f,%f?q=University", lat, lng);
                        Uri geo = Uri.parse(geoURI);
                        Intent geoMap = new Intent(Intent.ACTION_VIEW, geo);
                        startActivity(geoMap);
                    }


                }
                //----------- end of University block ----------------

                //------------ Bank blocks -------------------
                else if(web[+position]=="Bank"){


                    lat = gps.getLatitude();
                    lng = gps.getLongitude();

                    if(lat==0.0&&lng==0.0){
                        String str = "pls check connection";
                        Toast.makeText(getBaseContext(), str, Toast.LENGTH_LONG).show();
                    }

                    else {

                        String geoURI = String.format("geo:%f,%f?q=Bank", lat, lng);
                        Uri geo = Uri.parse(geoURI);
                        Intent geoMap = new Intent(Intent.ACTION_VIEW, geo);
                        startActivity(geoMap);
                    }


                }
                //----------- end of Bank block ----------------

                //------------ ATM Both blocks -------------------
                else if(web[+position]=="ATM Both"){


                    lat = gps.getLatitude();
                    lng = gps.getLongitude();

                    if(lat==0.0&&lng==0.0){
                        String str = "pls check connection";
                        Toast.makeText(getBaseContext(), str, Toast.LENGTH_LONG).show();
                    }

                    else {

                        String geoURI = String.format("geo:%f,%f?q=ATM Both", lat, lng);
                        Uri geo = Uri.parse(geoURI);
                        Intent geoMap = new Intent(Intent.ACTION_VIEW, geo);
                        startActivity(geoMap);
                    }


                }
                //----------- end of ATM Both block ----------------

                //------------ Resturant Both blocks -------------------
                else if(web[+position]=="Resturant"){


                    lat = gps.getLatitude();
                    lng = gps.getLongitude();

                    if(lat==0.0&&lng==0.0){
                        String str = "pls check connection";
                        Toast.makeText(getBaseContext(), str, Toast.LENGTH_LONG).show();
                    }

                    else {

                        String geoURI = String.format("geo:%f,%f?q=Resturant", lat, lng);
                        Uri geo = Uri.parse(geoURI);
                        Intent geoMap = new Intent(Intent.ACTION_VIEW, geo);
                        startActivity(geoMap);
                    }


                }
                //----------- end of Resturant Both block ----------------

                //------------ Hotel Both blocks -------------------
                else if(web[+position]=="Hotel"){


                    lat = gps.getLatitude();
                    lng = gps.getLongitude();

                    if(lat==0.0&&lng==0.0){
                        String str = "pls check connection";
                        Toast.makeText(getBaseContext(), str, Toast.LENGTH_LONG).show();
                    }

                    else {

                        String geoURI = String.format("geo:%f,%f?q=Hotel", lat, lng);
                        Uri geo = Uri.parse(geoURI);
                        Intent geoMap = new Intent(Intent.ACTION_VIEW, geo);
                        startActivity(geoMap);
                    }


                }
                //----------- end of Search block ----------------

                else if(web[+position]=="Search"){
                    Toast.makeText(MainActivity.this, "You Clicked at " + web[+position], Toast.LENGTH_SHORT).show();
                    Intent intent;
                    intent = new Intent(MainActivity.this,SearchActivity2.class);
                   startActivity(intent);

                }
                //----------- end of Search block ----------------



            }
        });


    }


    //----------- Alert method ---------

    public void showSettingsAlert() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(
                MainActivity.this);
        alertDialog.setTitle("SETTINGS");
        alertDialog.setMessage("Enable Location Provider! Go to settings menu?");
        alertDialog.setPositiveButton("Settings",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(
                                Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                        MainActivity.this.startActivity(intent);
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



    //----------------- default code---------------------
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //--------- end of default code--------------
}
