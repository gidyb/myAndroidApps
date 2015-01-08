/**
 * @author Gidy Basin
 */

package gidy.carpark.utils;

import gidy.carpark.ParkingLocation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LocationUtils {
	
	private static List<ParkingLocation> _locations = new ArrayList<>();
	private static ParkingLocation _curLocation;

	static{
		try {
			initParkingLocations();
		} catch (IOException | JSONException e) {
			// TOO BAD :(
		}
	}
	
	public static void addLocationAndSetCurrent(ParkingLocation loc) throws IOException, JSONException{
		_locations.add(loc);
		setCurrentLocation(loc);
	}
	
	public static List<ParkingLocation> getLocations(){
		return _locations;
	}
	
	public static void initParkingLocations() throws IOException, JSONException{
		
		try(FileInputStream fis = new FileInputStream(FileUtils.getLocationsFile())){
			
			FileChannel fc = fis.getChannel();
		    MappedByteBuffer bb = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size());
            String locJsonStr = Charset.defaultCharset().decode(bb).toString();
            
            JSONObject allLoc = new JSONObject(locJsonStr);
            
            JSONArray locArray = allLoc.getJSONArray("locations");
            
            ParkingLocation curLoc;
            
            // Add all the locations in the array
            for (int i=0; i<locArray.length(); i++){            	
            	curLoc = new ParkingLocation(locArray.getJSONObject(i));
            	_locations.add(curLoc);
            	if (curLoc.getIsCurrent()){
            		setCurrentLocation(curLoc);
            	}
            }
		}
		catch(FileNotFoundException exc){
			// If there is no file yet - do nothing - that's ok
			return; 
		}
	}
	
	public static void setCurrentLocation(ParkingLocation loc) throws IOException, JSONException{
		
		if (_curLocation != null){
			_curLocation.removeCurrentFlag();
		}
		
		loc.setCurrentParking();
		_curLocation = loc;
	}
	
	public static void setCurrentLocation(String locStr) throws IOException, JSONException{
		for (ParkingLocation loc : _locations){
			if (loc.getLocationString().equals(locStr)){
				setCurrentLocation(loc);
				break;
			}
		}
	}
	
	public static ParkingLocation getCurrentLocation(){
		return _curLocation;
	}
	
	
	public static void saveLocationsToDisk() throws IOException, JSONException{
		if (_locations.size() > 0){
			FileWriter fw = new FileWriter(FileUtils.getLocationsFile(), false);
			fw.write(getLocationsJSons());
			fw.close();
		}
	}
	
	private static String getLocationsJSons() throws JSONException{
		
		JSONObject locationsObj = new JSONObject();
		JSONArray locationsArray = new JSONArray();
		
		for (ParkingLocation loc : _locations){
			locationsArray.put(loc.getJsonObj());
		}
		
		locationsObj.put("locations", locationsArray);
		
		return locationsObj.toString();
	}
	
	public static void removeLocation(int position){
		if (_curLocation == _locations.get(position)){
			_curLocation = null;
		}
		
		_locations.remove(position);		
	}
}
