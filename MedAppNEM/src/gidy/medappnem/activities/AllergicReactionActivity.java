package gidy.medappnem.activities;

import gidy.medappnem.R;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

public class AllergicReactionActivity extends MedicalIssueActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTheme(R.style.MedAppTheme);
		setContentView(R.layout.activity_allergic_reaction);
		
		TextView instruction1 = (TextView) findViewById(R.id.instruction1);
		instruction1.setText("\u200Fהנפגע עלול לפתח פריחה, לחוש עקצוץ או נפיחות בידיו, רגליו או פניו. נשימתו עלולה להאט");
		
		TextView instruction2 = (TextView) findViewById(R.id.instruction2);
		instruction2.setText("\u200Fאם וכאשר הנך מבחין בתסמינים אלו:");
		
		TextView instruction3 = (TextView) findViewById(R.id.instruction3);
		instruction3.setText("\u200Fבמידה והנפגע סובל מאלרגיה ידועה וקיים ברשותו תכשיר טיפולי, עזור לו להשתמש בו או השתמש בו בעצמך על פי הוראות השימוש");
		
		TextView instruction4 = (TextView) findViewById(R.id.instruction4);
		instruction4.setText("\u200Fהרגע את הנפגע עד להגעת האמבולנס");
		
		logger.debug("here");	

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.allergic_reaction, menu);
		return true;
	}
}
