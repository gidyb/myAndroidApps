package gidy.medappnem.activities;

import gidy.medappnem.R;
import gidy.medappnem.videoActivities.HeartAttackVideoActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class HeartAttackActivity extends MedicalIssueActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTheme(R.style.MedAppTheme);
		setContentView(R.layout.activity_heart_attack);
		
		TextView instruction1 = (TextView) findViewById(R.id.instruction1);
		instruction1.setText("\u200Fהנפגע עלול לחוש כאב ועקצוץ מתמיד באזור החזה, שעלול להתפשט לאזור הידיים, הצוואר, הלסת, הגב או הבטן");
		
		TextView instruction2 = (TextView) findViewById(R.id.instruction2);
		instruction2.setText("\u200Fודא כי הנפגע נמצא בתנוחה נוחה עבורו ונשען על משהו");
		
		TextView instruction3 = (TextView) findViewById(R.id.instruction3);
		instruction3.setText("\u200Fהרגע את הנפגע באופן מתמיד עד להגעת האמבולנס");
		
		logger.debug("here");		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.heart_attack, menu);
		return true;
	}
	
	public void openHeartAttackVideoActivity(View view){
		Intent intent = new Intent(this, HeartAttackVideoActivity.class);
		startActivity(intent);
	}
}
