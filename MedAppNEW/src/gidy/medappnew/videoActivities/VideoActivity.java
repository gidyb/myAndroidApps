/**
* @author Gidy Basin
*/

package gidy.medappnew.videoActivities;

import gidy.medappnew.MedAppLogger;

import org.apache.log4j.Logger;

import android.app.Activity;

public class VideoActivity extends Activity {

	protected static final Logger logger = MedAppLogger.getLogger();
	
	@Override
	public void onBackPressed() {
		
		logger.debug("here");		
		super.onBackPressed();
	}
}
