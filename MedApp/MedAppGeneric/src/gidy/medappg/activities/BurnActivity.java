package gidy.medappg.activities;

import gidy.medappg.R;
import gidy.medappg.videoActivities.BurnVideoActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class BurnActivity extends MedicalIssueActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTheme(R.style.MedAppTheme);
		setContentView(R.layout.activity_burn);
		
		TextView instruction1 = (TextView) findViewById(R.id.instruction1);
		instruction1.setText("\u200Fהחזק את אזור הכוויה מתחת למים קרים זורמים למשך 10 דקןת לפחות");
		
		TextView instruction2 = (TextView) findViewById(R.id.instruction2);
		instruction2.setText("\u200Fכסה את אזור הכוויה באמצעות שקית פלסטיק באופן רופף");
		
		logger.debug("here");		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.bleeding, menu);
		return true;
	}
	
	public void openBurnVideoActivity(View view){
		Intent intent = new Intent(this, BurnVideoActivity.class);
		startActivity(intent);
	}
}
