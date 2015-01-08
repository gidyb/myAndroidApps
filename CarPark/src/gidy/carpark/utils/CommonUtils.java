/**
 * @author Gidy Basin
 */

package gidy.carpark.utils;

import android.app.Activity;
import android.graphics.Typeface;
import android.widget.Button;
import android.widget.TextView;

public class CommonUtils {
	public static void initHebrewText(Activity activity, TextView textView){

		Typeface whereParkedTypeface = Typeface.createFromAsset(activity.getAssets(), "fonts/heb_font.ttf");
		textView.setTypeface(whereParkedTypeface,Typeface.BOLD);
		textView.setTextSize(30);
	}

	public static void initHebrewText(Activity activity, Button button){

		Typeface whereParkedTypeface = Typeface.createFromAsset(activity.getAssets(), "fonts/heb_font.ttf");
		button.setTypeface(whereParkedTypeface,Typeface.BOLD);
		button.setTextSize(30);
	}	
}
