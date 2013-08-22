package kolz.android.adapters;

import java.util.List;

import kolz.android.R;
import kolz.android.domain.Message;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class NewsAdapter extends ArrayAdapter<Message>{
	
	private List<Message> messages;

	public NewsAdapter(Context context, int textViewResourceId, List<Message> messages) {
		super(context, textViewResourceId);
		this.messages = messages;
	}
	
	 @Override
     public View getView(int position, View convertView, ViewGroup parent) {
             View view = convertView;
             if (view == null) {
                 LayoutInflater layoutInflator = (LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                 view = layoutInflator.inflate(R.layout.doublerow, null);
             }
             if(messages.size() > 0) {
            	 Message message = messages.get(position);
	             if (message != null) {
	                     TextView tt = (TextView) view.findViewById(R.id.toptext);
	                     TextView bt = (TextView) view.findViewById(R.id.bottomtext);
	                     if (tt != null) {
	                           tt.setText("Title: "+message.getTitle());                            
	                     }
	                     if(bt != null){
	                           bt.setText("Date: "+ message.getDate());
	                     }
	             }
             }
             return view;
     }

}
