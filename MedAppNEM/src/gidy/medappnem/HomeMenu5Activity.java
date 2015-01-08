package gidy.medappnem;

import org.apache.log4j.Logger;

import gidy.medappnem.activities.AllergicReactionActivity;
import gidy.medappnem.activities.AsthmaActivity;
import gidy.medappnem.activities.BleedingActivity;
import gidy.medappnem.activities.BrokenBoneActivity;
import gidy.medappnem.activities.BurnActivity;
import gidy.medappnem.activities.ChokeActivity;
import gidy.medappnem.activities.DiabeticActivity;
import gidy.medappnem.activities.DistressActivity;
import gidy.medappnem.activities.EpilepsyActivity;
import gidy.medappnem.activities.HeadInjuryActivity;
import gidy.medappnem.activities.HeartAttackActivity;
import gidy.medappnem.activities.HypothermiaActivity;
import gidy.medappnem.activities.MeningitisActivity;
import gidy.medappnem.activities.PoisoningActivity;
import gidy.medappnem.activities.StrokeActivity;
import gidy.medappnem.activities.UnconsciousBreatingActivity;
import gidy.medappnem.activities.UnconsciousNotBreathingActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class HomeMenu5Activity extends Activity {

	private static final Logger logger = MedAppLogger.getLogger();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home_menu5);
		
		init();
		
		logger.debug("here");		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home_menu5, menu);
		return true;
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
		
		logger.debug("here");		
		
		super.onBackPressed();
	}
}
