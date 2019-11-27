package name.boyle.chris.keytest;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.TextView;

public class KeyTest extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		text = (TextView) findViewById(R.id.text);
	}

	TextView text;

	@Override
	public boolean dispatchKeyEvent(final KeyEvent event) {
		text.setText("KeyEvent: " + event.toString() + "\n" + text.getText());
		return false;
	}

	@Override
	public boolean dispatchGenericMotionEvent(MotionEvent ev) {
		text.setText("MotionEvent: " + ev.toString() + "\n" + text.getText());
		return false;
	}
}
