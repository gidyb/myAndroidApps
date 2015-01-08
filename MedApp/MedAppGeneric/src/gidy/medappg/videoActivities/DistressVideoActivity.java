package gidy.medappg.videoActivities;

import gidy.medappg.R;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.widget.VideoView;

public class DistressVideoActivity extends VideoActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTheme(R.style.MedAppTheme);
		setContentView(R.layout.activity_distress_video);
		
		logger.debug("here");
		
		VideoView v =(VideoView) findViewById(R.id.DistressVideoView);
		String fileName = "android.resource://" + getPackageName() + "/" + R.raw.distress;
		v.setVideoURI(Uri.parse(fileName));
		v.start();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.distress_video, menu);
		return true;
	}

}
