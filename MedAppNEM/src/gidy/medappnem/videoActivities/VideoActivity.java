/**
* @author Gidy Basin
*/

package gidy.medappnem.videoActivities;

import gidy.medappnem.MedAppLogger;

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
