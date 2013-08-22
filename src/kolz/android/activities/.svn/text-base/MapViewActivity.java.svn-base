package kolz.android.activities;

import java.util.List;

import kolz.android.R;
import kolz.android.mapoverlays.JobsItemizedOverlay;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;

public class MapViewActivity extends MapActivity {

	MapView mapView;
	MapController mapController;
	LinearLayout linearLayout;
	List<Overlay> mapOverlays;
	Drawable drawable;
	JobsItemizedOverlay itemizedOverlay;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.map);

		mapView = (MapView) findViewById(R.id.mapview);
		mapController = mapView.getController();

		mapView.setBuiltInZoomControls(true);
		mapOverlays = mapView.getOverlays();
		drawable = this.getResources().getDrawable(R.drawable.geocentlogo);
		itemizedOverlay = new JobsItemizedOverlay(drawable);
		double[] coordinates = new double[2];
		coordinates = getIntent().getExtras().getDoubleArray("coordinates");
		GeoPoint point = new GeoPoint((int) (coordinates[0] * 1E6),
				(int) (coordinates[1] * 1E6));
		OverlayItem overlayitem = new OverlayItem(point, "", "");

		itemizedOverlay.addOverlay(overlayitem);
		mapOverlays.add(itemizedOverlay);

		mapController.animateTo(point);
		mapController.setZoom(17);
	}

	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}

}
