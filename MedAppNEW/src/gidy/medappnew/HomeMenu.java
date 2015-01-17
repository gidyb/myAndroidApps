package gidy.medappnew;

import org.apache.log4j.Logger;

import gidy.medappnew.HomeMenu2Activity;
import gidy.medappnew.R;
import gidy.medappnew.activities.AllergicReactionActivity;
import gidy.medappnew.activities.AsthmaActivity;
import gidy.medappnew.activities.BleedingActivity;
import gidy.medappnew.activities.BrokenBoneActivity;
import gidy.medappnew.activities.BurnActivity;
import gidy.medappnew.activities.ChokeActivity;
import gidy.medappnew.activities.DiabeticActivity;
import gidy.medappnew.activities.DistressActivity;
import gidy.medappnew.activities.EpilepsyActivity;
import gidy.medappnew.activities.HeadInjuryActivity;
import gidy.medappnew.activities.HeartAttackActivity;
import gidy.medappnew.activities.HypothermiaActivity;
import gidy.medappnew.activities.MeningitisActivity;
import gidy.medappnew.activities.PoisoningActivity;
import gidy.medappnew.activities.StrokeActivity;
import gidy.medappnew.activities.UnconsciousBreatingActivity;
import gidy.medappnew.activities.UnconsciousNotBreathingActivity;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class HomeMenu extends Activity {

	private static final Logger logger = MedAppLogger.getLogger();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home_menu);
		
		init();
		
		logger.debug("here we go!");		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home_menu, menu);
		return true;
	}
	
	public void toHomeMenu2(View view){
		Intent intent = new Intent(this, HomeMenu2Activity.class);
		startActivity(intent);
	}
	
	public void startChokeActivity(View view){
		Intent intent = new Intent(this, ChokeActivity.class);
		startActivity(intent);
	}
	
	public void startAllergicReactionActivity(View view){
		Intent intent = new Intent(this, AllergicReactionActivity.class);
		startActivity(intent);
	}
	
	public void startAsthmaActivity(View view){
		Intent intent = new Intent(this, AsthmaActivity.class);
		startActivity(intent);
	}
	
	public void startBleedingActivity(View view){
		Intent intent = new Intent(this, BleedingActivity.class);
		startActivity(intent);
	}
	
	public void startBrokenBoneActivity(View view){
		Intent intent = new Intent(this, BrokenBoneActivity.class);
		startActivity(intent);
	}
	
	public void startBurnActivity(View view){
		Intent intent = new Intent(this, BurnActivity.class);
		startActivity(intent);
	}
	
	public void startDiabeticActivity(View view){
		Intent intent = new Intent(this, DiabeticActivity.class);
		startActivity(intent);
	}
	
	public void startDistressActivity(View view){
		Intent intent = new Intent(this, DistressActivity.class);
		startActivity(intent);
	}
	
	public void startEpilepsyActivity(View view){
		Intent intent = new Intent(this, EpilepsyActivity.class);
		startActivity(intent);
	}
	
	public void startHeadInjuryActivity(View view){
		Intent intent = new Intent(this, HeadInjuryActivity.class);
		startActivity(intent);
	}
	
	public void startHeartAttackActivity(View view){
		Intent intent = new Intent(this, HeartAttackActivity.class);
		startActivity(intent);
	}
	
	public void startHypothermiaActivity(View view){
		Intent intent = new Intent(this, HypothermiaActivity.class);
		startActivity(intent);
	}
	
	public void startMeningitisActivity(View view){
		Intent intent = new Intent(this, MeningitisActivity.class);
		startActivity(intent);
	}
	
	public void startPoisoningActivity(View view){
		Intent intent = new Intent(this, PoisoningActivity.class);
		startActivity(intent);
	}
	
	public void startStrokeActivity(View view){
		Intent intent = new Intent(this, StrokeActivity.class);
		startActivity(intent);
	}
	
	public void startUnconsciousBreathingActivity(View view){
		Intent intent = new Intent(this, UnconsciousBreatingActivity.class);
		startActivity(intent);
	}
	
	public void startUnconsciousNotBreathingActivity(View view){
		Intent intent = new Intent(this, UnconsciousNotBreathingActivity.class);
		startActivity(intent);
	}
	
	private void init(){
		TextView medAppTextView = (TextView)findViewById(R.id.MedAppCaptionTextView);
		Typeface medAppTypeface = Typeface.createFromAsset(getAssets(), "fonts/ambulance_font.ttf");
		medAppTextView.setTypeface(medAppTypeface);
	}
	
	@Override
	public void onBackPressed() {
		
		logger.debug("here - Exiting ");		
		
		super.onBackPressed();
	}

}
