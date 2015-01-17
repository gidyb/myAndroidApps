package gidy.medappnew.activities;

import gidy.medappnew.R;
import gidy.medappnew.videoActivities.DiabeticVideoActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class DiabeticActivity extends MedicalIssueActivity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTheme(R.style.MedAppTheme);
		setContentView(R.layout.activity_diabetic);
		
		TextView instruction1 = (TextView) findViewById(R.id.instruction1);
		instruction1.setText("\u200Fהגישי לנפגע מאכל או משקה מתוק כלשהו");
		
		TextView instruction2 = (TextView) findViewById(R.id.instruction2);
		instruction2.setText("\u200Fהרגיעי את הנפגע");
		
		TextView instruction3 = (TextView) findViewById(R.id.instruction3);
		instruction3.setText("\u200Fהנפגע אמור להרגיש טוב יותר, אך אם הדבר איננו קורה:");
		
		logger.debug("here");		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.diabetic, menu);
		return true;
	}
	
	public void openDiabeticVideoActivity(View view){
		Intent intent = new Intent(this, DiabeticVideoActivity.class);
		startActivity(intent);
	}
}
