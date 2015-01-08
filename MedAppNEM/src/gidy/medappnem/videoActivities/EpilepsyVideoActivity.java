package gidy.medappnem.videoActivities;

import gidy.medappnem.R;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.widget.VideoView;

public class EpilepsyVideoActivity extends VideoActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTheme(R.style.MedAppTheme);
		setContentView(R.layout.activity_epilepsy_video);
		
		logger.debug("here");
		
		VideoView v =(VideoView) findViewById(R.id.EpilepsyVideoView);
		String fileName = "android.resource://" + getPackageName() + "/" + R.raw.epilepsy;
		v.setVideoURI(Uri.parse(fileName));
		v.start();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.epilepsy_video, menu);
		return true;
	}

}
