package gidy.medappnem.activities;

import gidy.medappnem.MedAppLogger;
import gidy.medappnem.R;
import gidy.medappnem.videoActivities.StrokeVideoActivity;

import org.apache.log4j.Logger;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class StrokeActivity extends MedicalIssueActivity {
	
	private static final Logger logger = MedAppLogger.getLogger();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTheme(R.style.MedAppTheme);
		setContentView(R.layout.activity_stroke);
		
		TextView instruction1 = (TextView) findViewById(R.id.instruction1);
		instruction1.setText("\u200Fבדוק האם יש לנפגע חולשה בצד אחד של הפנים");
		
		TextView instruction2 = (TextView) findViewById(R.id.instruction2);
		instruction2.setText("\u200Fבדוק האם הנפגע יכול להרים את שתי ידיו");
		
		TextView instruction3 = (TextView) findViewById(R.id.instruction3);
		instruction3.setText("\u200Fבדוק האם דיבורו של הנפגע מובן");
		
		TextView instruction4 = (TextView) findViewById(R.id.instruction4);
		instruction4.setText("\u200Fבמידה והנך מזהה תסמינים אלה:");
		
		TextView instruction5 = (TextView) findViewById(R.id.instruction5);
		instruction5.setText("\u200Fדבר עם הנפגע על מנת להרגיעו עד להגעת האמבולנס");
		
		logger.debug("here");		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.stroke, menu);
		return true;
	}
	
	public void openStrokeVideoActivity(View view){
		Intent intent = new Intent(this, StrokeVideoActivity.class);
		startActivity(intent);
	}
}
