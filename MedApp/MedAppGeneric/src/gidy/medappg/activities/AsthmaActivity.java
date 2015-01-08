package gidy.medappg.activities;

import gidy.medappg.R;
import gidy.medappg.videoActivities.AsthmaVideoActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class AsthmaActivity extends MedicalIssueActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTheme(R.style.MedAppTheme);
		setContentView(R.layout.activity_asthma);
		
		TextView instruction1 = (TextView) findViewById(R.id.instruction1);
		instruction1.setText("\u200Fעזור לנפגע לשבת בתנוחה נוחה ולהשתמש בתכשיר הרפואי שברשותו");
		
		TextView instruction2 = (TextView) findViewById(R.id.instruction2);
		instruction2.setText("\u200Fהרגע את הנפגע");
		
		TextView instruction3 = (TextView) findViewById(R.id.instruction3);
		instruction3.setText("\u200Fבמידה וההתקף הופך לחמור או במידה ואין בידי הנפגע תכשיר רפואי מתאים:");
		
		logger.debug("here");		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.choke, menu);
		return true;
	}
	
	public void openAsthmaVideoActivity(View view){
		Intent intent = new Intent(this, AsthmaVideoActivity.class);
		startActivity(intent);
	}
}
