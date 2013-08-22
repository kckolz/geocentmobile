package kolz.android.activities;

import java.util.ArrayList;
import java.util.UUID;

import kolz.android.R;
import kolz.android.adapters.JobAdapter;
import kolz.android.domain.Job;
import kolz.android.domain.Location;
import kolz.android.services.JobService;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

public class JobActivity extends ListActivity {

	private ProgressDialog progressDialog = null;
	private ArrayList<Job> jobs = null;
	private JobAdapter adapter;
	private Runnable viewJobs;
	private JobService jobService;
	private String locationId;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.jobs);

		jobs = new ArrayList<Job>();

		this.adapter = new JobAdapter(this, R.layout.doublerow, jobs);
		adapter.notifyDataSetChanged();
		this.setListAdapter(adapter);
		
		this.jobService = new JobService(jobs);
		
		Intent intent = getIntent();
		Bundle bundle = intent.getExtras();
		locationId = (String)bundle.get("id");

		viewJobs = new Runnable() {
			@Override
			public void run() {
				getJobs();
			}
		};

		Thread thread = new Thread(null, viewJobs, "job thread");
		thread.start();
		progressDialog = ProgressDialog.show(JobActivity.this,
				"Please wait...", "Retrieving data ...", true);

	}

	
	private void getJobs() {
		try {
			this.jobs = jobService.getJobs(locationId);
			//Thread.sleep(2000);
			Log.i("ARRAY", "" + jobs.size());
		} catch (Exception e) {
			Log.e("Get Jobs", e.toString());
		}
		runOnUiThread(returnRes);
	}

	private Runnable returnRes = new Runnable() {
		@Override
		public void run() {
			if (jobs != null && jobs.size() > 0) {
				adapter.notifyDataSetChanged();
				for (int i = 0; i < jobs.size(); i++)
					adapter.add(jobs.get(i));
			}
			progressDialog.dismiss();
			adapter.notifyDataSetChanged();
		}
	};

	@Override
	public void onListItemClick(ListView parent, View v, int position, long id) {
		Job job = (Job) getListView().getItemAtPosition(position);
		Intent intent = new Intent(this, JobDescriptionActivity.class);
		Bundle bundle = new Bundle();
		bundle.putString("job", job.getName());
		bundle.putString("location", job.getLocation().getName());
		bundle.putString("description", job.getDescription());
		double[] coordinates = new double[2];
		coordinates[0] = job.getCoordinate().getX();
		coordinates[1] = job.getCoordinate().getY();
		bundle.putDoubleArray("coordinates", coordinates);
		intent.putExtras(bundle);
		startActivity(intent);
	}
}
