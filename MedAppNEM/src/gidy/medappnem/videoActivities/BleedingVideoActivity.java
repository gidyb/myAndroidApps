package gidy.medappnem.videoActivities;

import gidy.medappnem.R;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.widget.VideoView;

public class BleedingVideoActivity extends VideoActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTheme(R.style.MedAppTheme);
		setContentView(R.layout.activity_bleeding_video);
		
		logger.debug("here");
		
		VideoView v =(VideoView) findViewById(R.id.BleedingVideoView);
		String fileName = "android.resource://" + getPackageName() + "/" + R.raw.bleeding;
		v.setVideoURI(Uri.parse(fileName));
		v.start();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		return true;
	}

}
