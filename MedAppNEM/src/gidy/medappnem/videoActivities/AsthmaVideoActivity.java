package gidy.medappnem.videoActivities;

import gidy.medappnem.R;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.widget.VideoView;

public class AsthmaVideoActivity extends VideoActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTheme(R.style.MedAppTheme);
		setContentView(R.layout.activity_asthma_video);
		
		logger.debug("here");
		
		VideoView v =(VideoView) findViewById(R.id.AsthmaVideoView);
		String fileName = "android.resource://" + getPackageName() + "/" + R.raw.asthma;
		v.setVideoURI(Uri.parse(fileName));
		v.start();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		return true;
	}

}
