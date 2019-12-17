package name.boyle.chris.keytest;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.TextView;

public class KeyTest extends Activity {

	TextView text;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.main);
		text = (TextView) findViewById(R.id.text);
	}

	@Override
	public boolean dispatchKeyEvent(final KeyEvent event) {
		writeLog("dispatchKeyEvent: " + event.toString());
		return false;
	}

	@Override
	public boolean onGenericMotionEvent(MotionEvent event) {
		writeLog("onGenericMotionEvent: " + event.toString());
		return super.onGenericMotionEvent(event);
	}

	private void writeLog(String logEvent) {
		Log.i("KeyTest", logEvent);
		if(text != null) {
			text.setText(logEvent + "\n" + text.getText());
		}
	}
}


