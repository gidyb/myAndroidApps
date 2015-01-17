package gidy.medappnew.videoActivities;

import gidy.medappnew.R;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.widget.VideoView;

public class BurnVideoActivity extends VideoActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTheme(R.style.MedAppTheme);
		setContentView(R.layout.activity_burn_video);
		
		logger.debug("here");
		
		VideoView v =(VideoView) findViewById(R.id.BurnVideoView);
		String fileName = "android.resource://" + getPackageName() + "/" + R.raw.burns;
		v.setVideoURI(Uri.parse(fileName));
		v.start();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		return true;
	}

}
