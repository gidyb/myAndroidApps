/**
* @author Gidy Basin
*/

package gidy.carpark.utils;

import java.io.File;

import android.os.Environment;

public class FileUtils {

	private static final String LOCATIONS_FILE_DIR = 
			Environment.getExternalStorageDirectory().getPath() + File.separator + "CarPark";
	
	private static final String LOCATIONS_FILE_NAME = 
			Environment.getExternalStorageDirectory().getPath() + File.separator + "CarPark" + File.separator + "CarParkLocations.dat";

	
	public static File getLocationsFile(){
		File folder = new File(LOCATIONS_FILE_DIR);
		
		if (!folder.exists()){
			folder.mkdir();
		}
		
		return new File(LOCATIONS_FILE_NAME);
	}
	

}
