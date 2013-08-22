package kolz.android.activities;

import java.util.ArrayList;
import java.util.List;

import kolz.android.MainActivity;
import kolz.android.R;
import kolz.android.adapters.JobAdapter;
import kolz.android.adapters.NewsAdapter;
import kolz.android.domain.Credentials;
import kolz.android.domain.Job;
import kolz.android.domain.Message;
import kolz.android.rss.AndroidSaxFeedParser;
import kolz.android.rss.FeedParser;
import kolz.android.services.JobService;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

public class NewsActivity extends ListActivity {

	private FeedParser rssParser;
	private SharedPreferences preferences;
	private List<Message> rssMessages;
	private NewsAdapter adapter;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.news);

		rssParser = new AndroidSaxFeedParser(getString(R.string.feed_url));
		rssMessages = rssParser.parse();
		
		this.adapter = new NewsAdapter(this, R.layout.doublerow, rssMessages);
		adapter.notifyDataSetChanged();
		this.setListAdapter(adapter);
	}
		

	@Override
	public void onListItemClick(ListView parent, View v, int position, long id) {
		Message message = (Message) getListView().getItemAtPosition(position);
		Intent intent = new Intent(this, JobDescriptionActivity.class);
		Bundle bundle = new Bundle();
		bundle.putString("title", message.getTitle());
		bundle.putString("link", message.getLink().toString());
		bundle.putString("description", message.getDescription());
		bundle.putString("date", message.getDate());
		bundle.putString("author", message.getAuthor());
		intent.putExtras(bundle);
		startActivity(intent);
	}
		
	
}
