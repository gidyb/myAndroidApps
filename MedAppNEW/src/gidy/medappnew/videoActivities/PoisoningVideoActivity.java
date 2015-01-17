package gidy.medappnew.videoActivities;

import gidy.medappnew.R;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.widget.VideoView;

public class PoisoningVideoActivity extends VideoActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTheme(R.style.MedAppTheme);
		setContentView(R.layout.activity_poisoning_video);
		
		logger.debug("here");
		
		VideoView v =(VideoView) findViewById(R.id.PoisoningVideoView);
		String fileName = "android.resource://" + getPackageName() + "/" + R.raw.poisoning;
		v.setVideoURI(Uri.parse(fileName));
		v.start();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.poisoning_video, menu);
		return true;
	}

}
