package kolz.android.mapoverlays;

import java.util.ArrayList;

import android.graphics.drawable.Drawable;

import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.OverlayItem;


public class JobsItemizedOverlay extends ItemizedOverlay<OverlayItem> {
	

	private ArrayList<OverlayItem> overlays;
	
	public JobsItemizedOverlay(Drawable defaultMarker) {
		super(boundCenterBottom(defaultMarker));

		overlays = new ArrayList<OverlayItem>();
	}

	
	public void addOverlay(OverlayItem overlay) {
	    overlays.add(overlay);
	    populate();
	}

	@Override
	protected OverlayItem createItem(int i) {
		return overlays.get(i);
	}

	@Override
	public int size() {
		return overlays.size();
	}

}
