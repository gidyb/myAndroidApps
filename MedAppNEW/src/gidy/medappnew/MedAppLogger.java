/**
 * @author Gidy Basin
 */

package gidy.medappnew;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import android.os.Environment;
import de.mindpipe.android.logging.log4j.LogConfigurator;


public class MedAppLogger {

	private static final String LOG_LAYOUT_PATTERN = "[%d] [%C{1}].[%M] %m %n";

	private static Logger _logger;

	public static Logger getLogger(){
		if (_logger == null){
			_logger = Logger.getLogger("MedAppGeneric");
			initLogger();
		}

		return _logger;
	}

	private static void initLogger(){

		final LogConfigurator logConfigurator = new LogConfigurator();

		// TODO: CHANGE THESE TWO WHEN NEXUS ARRIVES:
		logConfigurator.setUseFileAppender(true);
		logConfigurator.setFileName(getCurrentLogFileName());

		logConfigurator.setFilePattern(LOG_LAYOUT_PATTERN);
		logConfigurator.setLogCatPattern(LOG_LAYOUT_PATTERN);
		logConfigurator.setRootLevel(Level.DEBUG);
		logConfigurator.configure();
	}


	private static String getCurrentLogFileName(){

		DateFormat df = new SimpleDateFormat("dd_MM_yyyy__HH_mm_ss");
		Date now = Calendar.getInstance().getTime();
		String dateString = df.format(now);

		return Environment.getExternalStorageDirectory().getPath() + File.separator + "MeddAppNEW__" + dateString + ".log";
	}

}
