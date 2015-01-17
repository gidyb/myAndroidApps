package gidy.medappnew.activities;

import gidy.medappnew.R;
import gidy.medappnew.videoActivities.EpilepsyVideoActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class EpilepsyActivity extends MedicalIssueActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTheme(R.style.MedAppTheme);
		setContentView(R.layout.activity_epilepsy);
		
		TextView instruction1 = (TextView) findViewById(R.id.instruction1);
		instruction1.setText("\u200Fאל תקבעי את הנפגע אך הגני על ראשו על ידי שמיכה או פרט לבוש");
		
		TextView instruction2 = (TextView) findViewById(R.id.instruction2);
		instruction2.setText("\u200Fלאחר ההתקף עזרי לנפגע לנוח על צידו עם ראשו מוטה לאחור");
		
		TextView instruction3 = (TextView) findViewById(R.id.instruction3);
		instruction3.setText("\u200Fבמידת הצורך:");
		
		logger.debug("here");		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.epilepsy, menu);
		return true;
	}
	
	public void openEpilepsyVideoActivity(View view){
		Intent intent = new Intent(this, EpilepsyVideoActivity.class);
		startActivity(intent);
	}
}
