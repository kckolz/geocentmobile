package kolz.android.activities;

import java.util.ArrayList;

import kolz.android.R;
import kolz.android.adapters.LocationAdapter;
import kolz.android.domain.Location;
import kolz.android.services.LocationService;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

public class LocationActivity extends ListActivity{
	
	private ProgressDialog progressDialog = null;
	private LocationAdapter adapter;
	private Runnable viewJobLocations;
	private LocationService locationService;
	private ArrayList<Location> locations;

	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.locations);

		locations = new ArrayList<Location>();

		this.adapter = new LocationAdapter(this, R.layout.locrow, locations);
		adapter.notifyDataSetChanged();
		this.setListAdapter(adapter);
		
		this.locationService = new LocationService(locations);

		viewJobLocations = new Runnable() {
			@Override
			public void run() {
				getJobLocations();
			}
		};

		Thread thread = new Thread(null, viewJobLocations, "location thread");
		thread.start();
		progressDialog = ProgressDialog.show(LocationActivity.this,
				"Please wait...", "Retrieving data ...", true);

	}

	private void getJobLocations() {
		try {
			this.locations = locationService.getJobLocations();
			//Thread.sleep(2000);
			Log.i("ARRAY", "" + locations.size());
		} catch (Exception e) {
			Log.e("Get Locations", e.toString());
		}
		runOnUiThread(returnLocations);
	}
	

	private Runnable returnLocations = new Runnable() {
		@Override
		public void run() {
			if (locations != null && locations.size() > 0) {
				adapter.notifyDataSetChanged();
				for (int i = 0; i < locations.size(); i++)
					adapter.add(locations.get(i));
			}
			progressDialog.dismiss();
			adapter.notifyDataSetChanged();
		}
	};
	
	@Override
	public void onListItemClick(ListView parent, View v, int position, long id) {
		Location location = (Location) getListView().getItemAtPosition(position);
		Intent intent = new Intent(this, JobActivity.class);
		Bundle bundle = new Bundle();
		bundle.putString("name", location.getName());
		bundle.putString("id", location.getId().toString());
		intent.putExtras(bundle);
		startActivity(intent);
	}
}
