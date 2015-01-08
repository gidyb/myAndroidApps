package gidy.medappg.videoActivities;

import gidy.medappg.R;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.widget.VideoView;

public class BrokenBoneVideoActivity extends VideoActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTheme(R.style.MedAppTheme);
		setContentView(R.layout.activity_broken_bone_video);
		
		logger.debug("here");
		
		VideoView v =(VideoView) findViewById(R.id.BrokenBoneVideoView);
		String fileName = "android.resource://" + getPackageName() + "/" + R.raw.brokenbones;
		v.setVideoURI(Uri.parse(fileName));
		v.start();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		return true;
	}
}
