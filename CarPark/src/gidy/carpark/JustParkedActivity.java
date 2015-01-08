package gidy.carpark;

import gidy.carpark.utils.CommonUtils;
import gidy.carpark.utils.GPSTracker;
import gidy.carpark.utils.LocationUtils;
import gidy.carpark.utils.LocationsAdapter;

import java.io.IOException;

import org.json.JSONException;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

public class JustParkedActivity extends Activity {

	private static LocationsAdapter adapter;

	private GPSTracker _gpsTracker;
	
	private static String newLoc;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_just_parked);

		_gpsTracker = new GPSTracker(JustParkedActivity.this);

		CommonUtils.initHebrewText(this,(TextView)findViewById(R.id.whereParkedText));

		// Handle locations list
		// Fill the list with locations
		adapter = new LocationsAdapter(this, R.layout.location_button_layout, LocationUtils.getLocations());
		ListView locationsListView = (ListView)findViewById(R.id.locationsList);
		locationsListView.setAdapter(adapter);

		// Handle deleting locations
		locationsListView.setLongClickable(true);
		locationsListView.setOnItemLongClickListener(new OnItemLongClickListener() {
			@Override
			public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
					int position, long arg3) {

				removeParkingLocation(position);		

				return true;
			}
		});


		// Handle NewLocation text box
		EditText newLocationEditText = (EditText) findViewById(R.id.newLocation);
		newLocationEditText.setOnEditorActionListener(new OnEditorActionListener() {
			@Override
			public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {		    	
				boolean handled = false;
				if (actionId == EditorInfo.IME_ACTION_DONE) {
					newLoc = v.getText().toString();
					if (!newLoc.isEmpty()){

						try{
							addNewLocation();
						}
						catch(Exception e){
							// Too Bad :(
						}
					}
					handled = true;
				}
				return handled;
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.just_parked, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	public void setParking(View view) throws IOException, JSONException{

		String locStr = clearLocStrIfNeeded(((Button)view).getText().toString()); 

		LocationUtils.setCurrentLocation(locStr);
		backToHomeScreen();
	}

	private String clearLocStrIfNeeded(String locStr) {

		if (locStr.endsWith(" (ללא נ.צ.)")){
			locStr = locStr.substring(0, locStr.length() - 11);
		}

		return locStr;
	}

	private void backToHomeScreen(){
		super.finish();
	}

	private void addNewLocation() throws IOException, JSONException{

		if (!_gpsTracker.canGetLocation()){
			showNoGpsAlert();
		}
		else{
			addNewLocationInner(newLoc);
		}
	}

	private void addNewLocationInner(String newLoc) throws IOException, JSONException{
		ParkingLocation loc = new ParkingLocation(newLoc, _gpsTracker);
		LocationUtils.addLocationAndSetCurrent(loc);
		backToHomeScreen();
	}

	@Override
	public void onStop(){
		try{
			LocationUtils.saveLocationsToDisk();	
			_gpsTracker.stopUsingGPS();
		}catch (Exception e){
			// TOO BAD :(
		}

		super.onStop();
	}

	private void removeParkingLocation(int position){

		final int deletePosition = position;

		AlertDialog.Builder alert = new AlertDialog.Builder(this);

		alert.setTitle("מחיקת מיקום");
		alert.setMessage("באמת למחוק?");
		alert.setPositiveButton("כן", new OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				LocationUtils.removeLocation(deletePosition);
				adapter.notifyDataSetChanged();
				adapter.notifyDataSetInvalidated();					}
		});

		alert.setNegativeButton("בטל", new OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.dismiss();
			}
		});

		alert.show();
	}

	private void showNoGpsAlert(){

		AlertDialog.Builder builder = new AlertDialog.Builder(this);

		builder.setTitle("שמירת מיקום")
		.setMessage("שירות המיקום איננו מופעל" + "\n" + "האם ברצונך להפעילו?") 
		.setPositiveButton("כן", new OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));
				backToHomeScreen();
			}
		})
		.setNegativeButton("לא", new OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				try {
					addNewLocationInner(newLoc);
				} catch (Exception e) {
					// Too Bad :(
				} 
			}			
		});	
	

		AlertDialog alert = builder.create();
		alert.show();	
	}
}
