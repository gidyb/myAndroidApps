package gidy.medappnew.activities;

import gidy.medappnew.R;
import gidy.medappnew.videoActivities.UnconsciousNotBreathingVideoActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class UnconsciousNotBreathingActivity extends MedicalIssueActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTheme(R.style.MedAppTheme);
		setContentView(R.layout.activity_unconscious_not_breathing);
		
		TextView instruction1 = (TextView) findViewById(R.id.instruction1);
		instruction1.setText("\u200Fדחפי חזק את מרכז החזה של הנפגע כלפי מטה ושחרר");
		
		TextView instruction2 = (TextView) findViewById(R.id.instruction2);
		instruction2.setText("\u200Fדחפי בקצב של 100 דחיפות בדקה על להגעת האמבולנס");
		
		logger.debug("here");		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.unconscious_not_breathing, menu);
		return true;
	}
	
	public void openUnconsciousNotBreathingVideoActivity(View view){
		Intent intent = new Intent(this, UnconsciousNotBreathingVideoActivity.class);
		startActivity(intent);
	}
}
