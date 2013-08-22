package kolz.android.activities;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import kolz.android.R;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class AboutActivity extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.about);

		TextView aboutText = (TextView) findViewById(R.id.abouttext);
		String text = readTxt();
		aboutText.setText(text);
	}

	private String readTxt() {

		InputStream inputStream = getResources().openRawResource(R.raw.about);

		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

		int i;
		try {
			i = inputStream.read();
			while (i != -1) {
				byteArrayOutputStream.write(i);
				i = inputStream.read();
			}
			inputStream.close();
		} catch (IOException e) {
			Log.e("Error reading text file",e.toString());
		}
		return byteArrayOutputStream.toString();
	}

}
