/**
 * @author Gidy Basin
 */

package gidy.carpark;

import gidy.carpark.utils.GPSTracker;

import org.json.JSONException;
import org.json.JSONObject;

public class ParkingLocation {

	private String _locationStr;
	private int _numParks;
	private boolean _isCurrent;
	private Double _locLat;
	private Double _locLong;	
	
	public static boolean isOkPressed = false;

	public ParkingLocation(String location, GPSTracker gpsTracker){
		_locationStr = location;
		_numParks = 0;
		_isCurrent = false;

		// Handle location
		if (!gpsTracker.canGetLocation()){
			_locLat = null;
			_locLong = null;
		}
		else{
			_locLat = gpsTracker.getLatitude();
			_locLong = gpsTracker.getLongitude();
		}
	}

	public void waitForOk(){
		while (!isOkPressed){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// Too Bad :(
			}
		}
	}
	
	public ParkingLocation(JSONObject jsonLoc) throws JSONException{
		_locationStr = jsonLoc.getString("location");
		_numParks = jsonLoc.getInt("numParks");
		_isCurrent = jsonLoc.getBoolean("isCurrent");
	
		if (jsonLoc.has("locLatitude") && jsonLoc.has("locLongitude")){
			_locLat = jsonLoc.getDouble("locLatitude");
			_locLong = jsonLoc.getDouble("locLongitude");
		}
		else{
			_locLat = null;
			_locLong = null;
		}
	}

	public String getLocationString(){
		return _locationStr;
	}

	public int getNumParks(){
		return _numParks;
	}

	public boolean getIsCurrent(){
		return _isCurrent;
	}
	
	public Double getLong(){
		return _locLong;
	}
	
	public Double getLat(){
		return _locLat;
	}

	public void setCurrentParking(){
		_isCurrent = true;
		_numParks ++ ;
	}
	
	public boolean hasLocation(){
		return (_locLat != null && _locLong != null);
	}

	public void removeCurrentFlag(){
		_isCurrent = false;
	}

	public JSONObject getJsonObj() throws JSONException{

		JSONObject jsonLoc = new JSONObject();

		jsonLoc.put("location", _locationStr);
		jsonLoc.put("numParks", _numParks);
		jsonLoc.put("isCurrent", _isCurrent);
		jsonLoc.put("locLongitude", _locLong);
		jsonLoc.put("locLatitude", _locLat);

		return jsonLoc;
	}
}
