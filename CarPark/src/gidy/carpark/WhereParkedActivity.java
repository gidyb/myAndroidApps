package gidy.carpark;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;

import gidy.carpark.utils.GPSTracker;
import gidy.carpark.utils.GoogleMapsUtils;
import gidy.carpark.utils.LocationUtils;
import android.app.Activity;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Location;
import android.net.http.AndroidHttpClient;
import android.opengl.Visibility;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class WhereParkedActivity extends Activity implements SensorEventListener{

	// Used to indicate an error with calculating distance
	// (Even though the GPS is ON)
	private static final float IRRELEVANT_DISTANCE = 0;

	private boolean _isGeoRelevant = false;
	private float _lastDistanceToParking = IRRELEVANT_DISTANCE;

	private Location curParkingLocationLoc = new Location("");
	private ParkingLocation _curParkingLoc;

	// Used for getting GPS location
	private GPSTracker _gpsTracker;

	// Used for compass
	final float alpha = 0.97f;

	private SensorManager _sensorManager;
	private float _currentAzimuth = 0f;
	private float _azimuth = 0f;
	private float[] _gravityMatrix = new float[3]; 
	private float[] _magneticsMatrix = new float[3]; 

	private ImageView arrowImage;
	private Button showOnMapButton;
	private TextView drivingTimeText;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_where_parked);

		_gpsTracker = new GPSTracker(WhereParkedActivity.this);

		arrowImage = (ImageView) findViewById(R.id.arrowImage);
		showOnMapButton  = (Button) findViewById(R.id.ShowOnMapButton);
		drivingTimeText = (TextView) findViewById(R.id.drivingTimeText);
		drivingTimeText.setVisibility(View.INVISIBLE);
		
		_sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

		initGeo();

		setText();

		if (_isGeoRelevant){
			_sensorManager.registerListener(this, 
					_sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD), 
					SensorManager.SENSOR_DELAY_GAME); 
			_sensorManager.registerListener(this, 
					_sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), 
					SensorManager.SENSOR_DELAY_GAME);
			_sensorManager.registerListener(this,
					_sensorManager.getDefaultSensor(Sensor.TYPE_SIGNIFICANT_MOTION),
					SensorManager.SENSOR_DELAY_GAME);
		}
		else{
			arrowImage.setVisibility(View.GONE);
			showOnMapButton.setVisibility(View.GONE);
		}
	}


	private void initGeo(){

		_curParkingLoc = LocationUtils.getCurrentLocation();

		if (_curParkingLoc != null){

			if (_curParkingLoc.hasLocation() && _gpsTracker.canGetLocation()){
				_isGeoRelevant = true;

				curParkingLocationLoc.setLatitude(_curParkingLoc.getLat());
				curParkingLocationLoc.setLongitude(_curParkingLoc.getLong());
			}
		}
	}

	private void setText() {
		TextView tv = (TextView)findViewById(R.id.whereParkedText);

		String parkedAtStr = "לא נקבע מקום חניה";

		ParkingLocation curParkLoc = LocationUtils.getCurrentLocation();

		if (curParkLoc != null){

			parkedAtStr = "חנית ב" + LocationUtils.getCurrentLocation().getLocationString();

			if (_isGeoRelevant){

				float distance = getDistanceToParking();

				if (distance != IRRELEVANT_DISTANCE){
					if (distance < 1000){
						parkedAtStr += ", במרחק " + Math.round(distance) +  " מ" + "\'";
					}
					else{
						parkedAtStr += ", במרחק " + String.format("%.02f", (distance/1000)) + " ק" + "\"" + "מ";
					}
					
					new GetDrivingTimeTask().execute();					
				}				

				_lastDistanceToParking = distance;
			}
		}

		tv.setText(parkedAtStr);
	}

	private float getDistanceToParking() {

		Location curLocation = _gpsTracker.getLocation();

		if (curLocation != null){
			return curLocation.distanceTo(curParkingLocationLoc);
		}
		else{
			return IRRELEVANT_DISTANCE;
		}
	}


	private float getBearingToParking(){

		Location currentLocation = new Location("");
		currentLocation.setLatitude(_gpsTracker.getLatitude());
		currentLocation.setLongitude(_gpsTracker.getLongitude());		

		return currentLocation.bearingTo(curParkingLocationLoc);
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
		_sensorManager.unregisterListener(this);
		super.onStop();
	}

	@Override
	public void onSensorChanged(SensorEvent event){

		if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {

			_gravityMatrix[0] = alpha * _gravityMatrix[0] + (1 - alpha)
					* event.values[0];
			_gravityMatrix[1] = alpha * _gravityMatrix[1] + (1 - alpha)
					* event.values[1];
			_gravityMatrix[2] = alpha * _gravityMatrix[2] + (1 - alpha)
					* event.values[2];
		}
		if (event.sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD) {
			_magneticsMatrix[0] = alpha * _magneticsMatrix[0] + (1 - alpha)
					* event.values[0];
			_magneticsMatrix[1] = alpha * _magneticsMatrix[1] + (1 - alpha)
					* event.values[1];
			_magneticsMatrix[2] = alpha * _magneticsMatrix[2] + (1 - alpha)
					* event.values[2];
		}

		float R[] = new float[9];
		float I[] = new float[9];

		boolean success = SensorManager.getRotationMatrix(R, I, _gravityMatrix,	_magneticsMatrix);
		if (success) {
			// Compute Azimuth
			float orientation[] = new float[3];
			SensorManager.getOrientation(R, orientation);
			_azimuth = (float) Math.toDegrees(orientation[0]); 
			_azimuth = (_azimuth + 360) % 360;

			// Compute Bearing
			float bearing = getBearingToParking(); 

			// Change bearing from (-180)-180 to 0-360
			bearing = (bearing + 360) % 360;		

			// Point to the lcoation instead of North
			_azimuth += 360 - bearing;

			_azimuth = _azimuth % 360;

			adjustArrow();

			float distance = getDistanceToParking(); 
			if (distance != IRRELEVANT_DISTANCE && 
					Math.abs(distance - _lastDistanceToParking) > 10){

				setText();
			}
		}
	}


	private void adjustArrow(){

		float azimuthDiff = Math.abs(_azimuth - _currentAzimuth); 

		if (azimuthDiff > 10){

			Animation an = new RotateAnimation(-_currentAzimuth, -_azimuth,
					Animation.RELATIVE_TO_SELF, 0.5f, 
					Animation.RELATIVE_TO_SELF, 0.5f);

			_currentAzimuth = _azimuth;

			an.setDuration(500);
			an.setFillAfter(true);

			arrowImage.startAnimation(an);
		}
	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// do nothing
	}

	@Override
	protected void onResume(){
		_sensorManager.registerListener(this, 
				_sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD), 
				SensorManager.SENSOR_DELAY_UI); 
		_sensorManager.registerListener(this, 
				_sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), 
				SensorManager.SENSOR_DELAY_UI); 
		_sensorManager.registerListener(this,
				_sensorManager.getDefaultSensor(Sensor.TYPE_SIGNIFICANT_MOTION),
				SensorManager.SENSOR_DELAY_GAME);
		_gpsTracker.getLocation();
		super.onResume();
	}

	@Override
	protected void onPause(){
		_sensorManager.unregisterListener(this);
		_gpsTracker.stopUsingGPS();
		super.onPause();
	}

	public void showOnMap(View view){

		Intent googleMapsActivity = GoogleMapsUtils.getMapActivityToDest(
				_curParkingLoc.getLat(),
				_curParkingLoc.getLong(),
				_curParkingLoc.getLocationString());

		startActivity(googleMapsActivity);
	}

	/**
	 * Returns the driving time from current location to parking location in minutes.
	 * This operation needs to connect GoogleMaps site, so it is implemented as a separate
	 * AsyncTask
	 */
	private class GetDrivingTimeTask extends AsyncTask<Void, Void, String>{

		@Override
		protected String doInBackground(Void... objs) {

			return GoogleMapsUtils.getDrivingTimeMins(
						_gpsTracker.getLocation().getLatitude(),
						_gpsTracker.getLocation().getLongitude(),
						_curParkingLoc.getLat(),
						_curParkingLoc.getLong());
		}

		@Override
		protected void onPostExecute(String drivingTimeStr) {
			
			String drivingTimeFullStr = "זמן נסיעה: " + drivingTimeStr;
			
			drivingTimeText.setText(drivingTimeFullStr);
			drivingTimeText.setVisibility(View.VISIBLE);
		}
	}
}
