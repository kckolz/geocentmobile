package kolz.android.activities;

import kolz.android.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class JobDescriptionActivity extends Activity {

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.description);

		final Button button = (Button) findViewById(R.id.mapbutton);
		button.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				startActivity(new Intent(JobDescriptionActivity.this,
						MapViewActivity.class).putExtras(getIntent()
						.getExtras()));
			}
		});

		TextView view = (TextView) findViewById(R.id.descripttext);
		Intent intent = getIntent();
		Bundle bundle = intent.getExtras();
		String jobName = (String) bundle.get("job");
		String description = (String) bundle.get("description");

		view.setText(description);

	}

	private CharSequence getDescription(String jobName) {

		String description = jobName;
		return description;

	}

}
