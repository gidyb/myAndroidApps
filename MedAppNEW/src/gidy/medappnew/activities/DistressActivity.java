package gidy.medappnew.activities;

import gidy.medappnew.R;
import gidy.medappnew.videoActivities.DistressVideoActivity;
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
		instruction1.setText("\u200Fהראי לנפגע שאת מקשיבה לו ושאלי אותו בצורה רגועה כיצד תוכלי לעזור");
		
		TextView instruction2 = (TextView) findViewById(R.id.instruction2);
		instruction2.setText("\u200Fהתחשבי במתרחש סביב הנפגע ובצרכיו");
		
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
