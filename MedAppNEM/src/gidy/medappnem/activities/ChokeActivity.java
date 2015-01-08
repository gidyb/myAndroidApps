package gidy.medappnem.activities;

import gidy.medappnem.R;
import gidy.medappnem.videoActivities.ChokeActivityVideo;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class ChokeActivity extends MedicalIssueActivity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTheme(R.style.MedAppTheme);
		setContentView(R.layout.activity_choke);
		
		logger.debug("here");		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.choke, menu);
		return true;
	}
	
	public void openChokeVideoActivity(View view){
		Intent intent = new Intent(this, ChokeActivityVideo.class);
		startActivity(intent);
	}

}
