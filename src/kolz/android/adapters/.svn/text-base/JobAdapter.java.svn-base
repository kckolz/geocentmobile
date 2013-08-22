package kolz.android.adapters;

import java.util.ArrayList;

import kolz.android.R;
import kolz.android.domain.Job;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class JobAdapter extends ArrayAdapter<Job>{
	
	private ArrayList<Job> jobs;

	public JobAdapter(Context context, int textViewResourceId, ArrayList<Job> jobs) {
		super(context, textViewResourceId);
		this.jobs = jobs;
	}
	
	 @Override
     public View getView(int position, View convertView, ViewGroup parent) {
             View view = convertView;
             if (view == null) {
                 LayoutInflater layoutInflator = (LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                 view = layoutInflator.inflate(R.layout.doublerow, null);
             }
             if(jobs.size() > 0) {
            	 Job job = jobs.get(position);
	             if (job != null) {
	                     TextView tt = (TextView) view.findViewById(R.id.toptext);
	                     TextView bt = (TextView) view.findViewById(R.id.bottomtext);
	                     if (tt != null) {
	                           tt.setText("Name: "+job.getName());                            
	                     }
	                     if(bt != null){
	                           bt.setText("Location: "+ job.getLocation().getName());
	                     }
	             }
             }
             return view;
     }
	 

	 
	 

}
