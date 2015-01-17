package gidy.medappnew.activities;

import gidy.medappnew.R;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

public class MeningitisActivity extends MedicalIssueActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTheme(R.style.MedAppTheme);
		setContentView(R.layout.activity_meningitis);
		
		TextView instruction1 = (TextView) findViewById(R.id.instruction1);
		instruction1.setText("\u200Fהנפגע עלול לסבול מתופעות הדומות לשפעת - כאב ראש וחום גבוה ");
		
		TextView instruction2 = (TextView) findViewById(R.id.instruction2);
		instruction2.setText("\u200Fהנפגע עלול להתלונן על צוואר תפוס ורגישות לאור");
		
		TextView instruction3 = (TextView) findViewById(R.id.instruction3);
		instruction3.setText("\u200Fעלולה להופיע פריחה");
		
		TextView instruction4 = (TextView) findViewById(R.id.instruction4);
		instruction4.setText("\u200Fכאשר הנך מבחינה בתסמינים אלו:");
		
		TextView instruction5 = (TextView) findViewById(R.id.instruction5);
		instruction5.setText("\u200Fהרגיעי את הנפגע באופן מתמיד עד להגעת האמבולנס");
		
		logger.debug("Meningitis entered");		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.meningitis, menu);
		return true;
	}	
}
