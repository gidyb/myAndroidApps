/**
* @author Gidy Basin
*/

package gidy.medappg.activities;

import gidy.medappg.CallAmbulanceActivity;
import gidy.medappg.MedAppLogger;

import org.apache.log4j.Logger;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

public class MedicalIssueActivity extends Activity {

	protected static final Logger logger = MedAppLogger.getLogger();
	
	@Override
	public void onBackPressed() {
		
		logger.debug("here");				
		super.onBackPressed();
	}
	
	public void startCallAmbulanceActivity(View view){
		Intent intent = new Intent(this, CallAmbulanceActivity.class);
		startActivity(intent);
	}
	
}
