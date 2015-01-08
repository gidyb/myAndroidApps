package gidy.medappnem.videoActivities;

import gidy.medappnem.R;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.widget.VideoView;

public class ChokeActivityVideo extends VideoActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTheme(R.style.MedAppTheme);
		setContentView(R.layout.activity_choke_video);
		
		logger.debug("here");
		
		VideoView v =(VideoView) findViewById(R.id.ChokeVideoView);
		String fileName = "android.resource://" + getPackageName() + "/" + R.raw.choking;
		v.setVideoURI(Uri.parse(fileName));
		v.start();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		return true;
	}

}
