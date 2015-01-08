package gidy.medappnem.activities;

import gidy.medappnem.R;
import gidy.medappnem.videoActivities.BrokenBoneVideoActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class BrokenBoneActivity extends MedicalIssueActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTheme(R.style.MedAppTheme);
		setContentView(R.layout.activity_broken_bone);
		
		TextView instruction1 = (TextView) findViewById(R.id.instruction1);
		instruction1.setText("\u200Fעודד את הנפגע לתמוך בידו באזור הפגוע, או השתמש בכרית או בפרט לבוש על מנת למנוע תנועות לא הכרחיות");
		
		TextView instruction2 = (TextView) findViewById(R.id.instruction2);
		instruction2.setText("\u200Fוודא כי האזור הפגוע נתמך עד להגעת האמבולנס");
		
		logger.debug("here");		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.bleeding, menu);
		return true;
	}
	
	public void openBrokenBoneVideoActivity(View view){
		Intent intent = new Intent(this, BrokenBoneVideoActivity.class);
		startActivity(intent);
	}
}
