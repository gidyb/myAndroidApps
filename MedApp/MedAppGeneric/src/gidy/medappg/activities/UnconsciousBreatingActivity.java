package gidy.medappg.activities;

import gidy.medappg.MedAppLogger;
import gidy.medappg.R;
import gidy.medappg.videoActivities.UnconsciousBreatingVideoActivity;

import org.apache.log4j.Logger;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class UnconsciousBreatingActivity extends MedicalIssueActivity{
	
	private static final Logger logger = MedAppLogger.getLogger();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTheme(R.style.MedAppTheme);
		setContentView(R.layout.activity_unconscious_breating);
		
		TextView instruction1 = (TextView) findViewById(R.id.instruction1);
		instruction1.setText("\u200Fהשכב את הנפגע על צידו והטה ראשו לאחור");
		
		TextView instruction2 = (TextView) findViewById(R.id.instruction2);
		instruction2.setText("\u200Fהמשך לעקוב אחרי הנפגע עד להגעת האמבולנס");
		
		logger.debug("here");		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.unconsious_breating, menu);
		return true;
	}
	
	public void openUnconsciousBreathingVideoActivity(View view){
		Intent intent = new Intent(this, UnconsciousBreatingVideoActivity.class);
		startActivity(intent);
	}
}
