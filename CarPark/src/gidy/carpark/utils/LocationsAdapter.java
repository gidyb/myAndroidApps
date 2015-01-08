/**
* @author Gidy Basin
*/

package gidy.carpark.utils;

import gidy.carpark.ParkingLocation;
import gidy.carpark.R;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;

public class LocationsAdapter extends ArrayAdapter<ParkingLocation> {

	private List<ParkingLocation> locations;
	private int layoutResourceId;
	private Context context;

	public LocationsAdapter(Context context, int layoutResourceId, List<ParkingLocation> items) {
		super(context, layoutResourceId, items);
		this.layoutResourceId = layoutResourceId;
		this.context = context;
		this.locations = items;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View row = convertView;
		LocationHolder holder = null;

		LayoutInflater inflater = ((Activity) context).getLayoutInflater();
		row = inflater.inflate(layoutResourceId, parent, false);

		holder = new LocationHolder();
		holder.parkingLocation = locations.get(position);
		holder.locationButton = (Button)row.findViewById(R.id.locationButton);
		
		setupItem(holder);		

		row.setTag(holder);
		
		return row;
	}

	private void setupItem(LocationHolder holder) {
		
		String locationStr = holder.parkingLocation.getLocationString();
		
		if (!holder.parkingLocation.hasLocation()){
			locationStr += " (ללא נ.צ.)";
		}
		
		holder.locationButton.setText(locationStr);
	}

	public static class LocationHolder {
		ParkingLocation parkingLocation;
		Button locationButton;
	}
}
