package gidy.medappnew.activities;

import gidy.medappnew.R;
import gidy.medappnew.videoActivities.HeadInjuryVideoActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class HeadInjuryActivity extends MedicalIssueActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTheme(R.style.MedAppTheme);
		setContentView(R.layout.activity_head_injury);
		
		TextView instruction1 = (TextView) findViewById(R.id.instruction1);
		instruction1.setText("\u200Fבקשי מהנפגע לנוח והצמידי חפץ קר כלשהו למקום הפגיעה");
		
		TextView instruction2 = (TextView) findViewById(R.id.instruction2);
		instruction2.setText("\u200Fבמידה והנפגע חש סחרור או מקיא:");
		
		logger.debug("here");		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.head_injury, menu);
		return true;
	}
	
	public void openHeadInjuryVideoActivity(View view){
		Intent intent = new Intent(this, HeadInjuryVideoActivity.class);
		startActivity(intent);
	}
}
