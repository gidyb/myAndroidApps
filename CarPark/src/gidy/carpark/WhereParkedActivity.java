package gidy.carpark;

import gidy.carpark.utils.GPSTracker;
import gidy.carpark.utils.LocationUtils;
import android.app.Activity;
import android.location.Location;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class WhereParkedActivity extends Activity {

	private GPSTracker _gpsTracker;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_where_parked);
		
		_gpsTracker = new GPSTracker(WhereParkedActivity.this);

		TextView tv = (TextView)findViewById(R.id.whereParkedText);

		String parkedAtStr = "לא נקבע מקום חניה";

		ParkingLocation curParkLoc = LocationUtils.getCurrentLocation();

		if (curParkLoc != null){
			
			parkedAtStr = "חנית ב" + LocationUtils.getCurrentLocation().getLocationString();

			if (curParkLoc.hasLocation() && _gpsTracker.canGetLocation()){
				float distance = getDistance(curParkLoc);

				if (distance < 1000){
					 parkedAtStr += ", במרחק " + Math.round(distance) +  " מ" + "\'";
				}
				else{
					parkedAtStr += ", במרחק " + String.format("%.02f", (distance/1000)) + " ק" + "\"" + "מ";
				}
			}
		}

		tv.setText(parkedAtStr);
	}

	private float getDistance(ParkingLocation curParkLoc) {
		double parkingLat = curParkLoc.getLat();
		double parkingLong = curParkLoc.getLong();

		double curLong = _gpsTracker.getLongitude();
		double curLat = _gpsTracker.getLatitude();

		float results[] = new float[1];

		Location.distanceBetween(parkingLat, parkingLong, curLat, curLong, results);
		
		return results[0];
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.where_parked, menu);
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
	
	@Override
	public void onStop(){
		_gpsTracker.stopUsingGPS();
		super.onStop();
	}
}
