package gidy.medappnem.activities;

import gidy.medappnem.R;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

public class HypothermiaActivity extends MedicalIssueActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTheme(R.style.MedAppTheme);
		setContentView(R.layout.activity_hypothermia);
		
		TextView instruction1 = (TextView) findViewById(R.id.instruction1);
		instruction1.setText("\u200F������ ���. ����� ���� �����, ����� ����� ��� ����. ����� ������ �� ����� �� ���� �������");
		
		TextView instruction2 = (TextView) findViewById(R.id.instruction2);
		instruction2.setText("\u200F��� �� ����� ������, ���� �� ������ ���� ������� ���� ������, ����� ������");
		
		logger.debug("here");		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.hypothermia, menu);
		return true;
	}
}
