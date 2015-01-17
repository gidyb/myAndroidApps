package gidy.medappnew.activities;

import gidy.medappnew.R;
import gidy.medappnew.videoActivities.BleedingVideoActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class BleedingActivity extends MedicalIssueActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTheme(R.style.MedAppTheme);
		setContentView(R.layout.activity_bleeding);
		
		TextView instruction1 = (TextView) findViewById(R.id.instruction1);
		instruction1.setText("\u200Fהפעילי לחץ על אזור הדימום באמצעות כל חפץ שתוכלי למצוא בהישג יד על מנת לעצור או לפחות להאט את זרימת הדם");
		
		TextView instruction2 = (TextView) findViewById(R.id.instruction2);
		instruction2.setText("\u200Fהמשיכי להפעיל לחץ על אזור הדימום עד להגעת האמבולנס");
		
		logger.debug("here");		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.bleeding, menu);
		return true;
	}
	
	public void openBleedingVideoActivity(View view){
		Intent intent = new Intent(this, BleedingVideoActivity.class);
		startActivity(intent);
	}
}
