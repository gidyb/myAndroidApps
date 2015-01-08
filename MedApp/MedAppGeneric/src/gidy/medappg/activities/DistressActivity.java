package gidy.medappg.activities;

import gidy.medappg.R;
import gidy.medappg.videoActivities.DistressVideoActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class DistressActivity extends MedicalIssueActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTheme(R.style.MedAppTheme);
		setContentView(R.layout.activity_distress);
		
		TextView instruction1 = (TextView) findViewById(R.id.instruction1);
		instruction1.setText("\u200Fהראה לנפגע שאתה מקשיב לו ושאל אותו בצורה רגועה כיצד תוכל לעזור");
		
		TextView instruction2 = (TextView) findViewById(R.id.instruction2);
		instruction2.setText("\u200Fהתחשב במתרחש סביב הנפגע ובצרכיו");
		
		logger.debug("here");		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.distress, menu);
		return true;
	}
	
	public void openDistressVideoActivity(View view){
		Intent intent = new Intent(this, DistressVideoActivity.class);
		startActivity(intent);
	}
}
