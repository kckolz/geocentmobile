package kolz.android.adapters;

import java.util.ArrayList;

import kolz.android.R;
import kolz.android.domain.Location;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class LocationAdapter extends ArrayAdapter<Location>{
	
	private ArrayList<Location> locations;

	public LocationAdapter(Context context, int textViewResourceId, ArrayList<Location> locations) {
		super(context, textViewResourceId);
		this.locations = locations;
	}
	
	 @Override
     public View getView(int position, View convertView, ViewGroup parent) {
             View view = convertView;
             if (view == null) {
                 LayoutInflater layoutInflator = (LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                 view = layoutInflator.inflate(R.layout.locrow, null);
             }
             if(locations.size() > 0) {
            	 Location location = locations.get(position);
	             if (location != null) {
	                     TextView textView = (TextView) view.findViewById(R.id.loctext);
	                 
	                     if (textView != null) {
	                           textView.setText(location.getName());                            
	                     }
	             }
             }
             return view;
     }
	 

	 
	 

}