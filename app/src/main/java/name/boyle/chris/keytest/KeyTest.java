package name.boyle.chris.keytest;

import android.app.Activity;
import android.content.Context;
import android.hardware.input.InputManager;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.TextView;

public class KeyTest extends Activity implements InputManager.InputDeviceListener {

	private InputManager mInputManager;
	TextView text;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.main);
		text = (TextView) findViewById(R.id.text);

		mInputManager = (InputManager)getSystemService(Context.INPUT_SERVICE);
	}

	@Override
	protected void onResume() {
		super.onResume();
		writeLog("onResume");
		mInputManager.registerInputDeviceListener(this, null);
	}

	@Override
	protected void onPause() {
		super.onPause();
		writeLog("onPause");
		mInputManager.unregisterInputDeviceListener(this);
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

	@Override
	public void onInputDeviceAdded(int i) {
		writeLog("onInputDeviceAdded: " + mInputManager.getInputDevice(i));
	}

	@Override
	public void onInputDeviceRemoved(int i) {
		writeLog("onInputDeviceRemoved: " + i);
	}

	@Override
	public void onInputDeviceChanged(int i) {
		writeLog("onInputDeviceChanged: " + i);
	}

	@Override
	public void onBackPressed() {
		writeLog("onBackPressed");
		// Suppress back button behaviour by not calling overridden method
	}

	private void writeLog(String logEvent) {
		Log.i("KeyTest", logEvent);
		if(text != null) {
			text.setText(logEvent + "\n" + text.getText());
		}
	}
}


