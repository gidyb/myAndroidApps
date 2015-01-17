package gidy.medappnew;

import gidy.medappnew.R;

import org.apache.log4j.Logger;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class CallAmbulanceActivity extends Activity {
	
	protected static final Logger logger = MedAppLogger.getLogger();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTheme(R.style.MedAppTheme);
		setContentView(R.layout.activity_call_ambulance);
		
		logger.debug("here");
	}
	
	public void goBack(View view){
		logger.debug("here");	
		finish();
	}
	
	@Override
	public void onBackPressed() {
		
		logger.debug("here");			
		super.onBackPressed();
	}

}
