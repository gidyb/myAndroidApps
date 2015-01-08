package gidy.medappnem.activities;

import gidy.medappnem.MedAppLogger;
import gidy.medappnem.R;
import gidy.medappnem.videoActivities.PoisoningVideoActivity;

import org.apache.log4j.Logger;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class PoisoningActivity extends MedicalIssueActivity {
	
	private static final Logger logger = MedAppLogger.getLogger();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTheme(R.style.MedAppTheme);
		setContentView(R.layout.activity_poisoning);
		
		TextView instruction1 = (TextView) findViewById(R.id.instruction1);
		instruction1.setText("\u200Fנסה לקבוע מה הנפגע צרך, מתי ובאיזו כמות");
		
		TextView instruction2 = (TextView) findViewById(R.id.instruction2);
		instruction2.setText("\u200Fאל תגרום לנפגע להקיא!");
		
		logger.debug("here");		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.poisoning, menu);
		return true;
	}

	public void openPoisoningVideoActivity(View view){
		Intent intent = new Intent(this, PoisoningVideoActivity.class);
		startActivity(intent);
	}
}
