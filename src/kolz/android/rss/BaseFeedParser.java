package kolz.android.rss;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import kolz.android.MainActivity;
import kolz.android.R;
import kolz.android.activities.NewsActivity;
import kolz.android.domain.Credentials;
import kolz.android.network.NTLMSchemeFactory;
import kolz.android.services.AuthenticationService;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.AuthenticationException;
import org.apache.http.auth.NTCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.util.Log;
import android.widget.Toast;


public abstract class BaseFeedParser implements FeedParser {

    // names of the XML tags
	static final String ROOT = "rss";
	static final String CHANNEL = "channel";
    static final String PUB_DATE = "pubDate";
    static final  String DESCRIPTION = "description";
    static final  String LINK = "link";
    static final  String TITLE = "title";
    static final  String ITEM = "item";
    static final String AUTHOR = "author";
    private AuthenticationService authService;
    
    final URL feedUrl;

    protected BaseFeedParser(String feedUrl){
        try {
            this.feedUrl = new URL(feedUrl);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    protected InputStream getInputStream() throws AuthenticationException {
    	InputStream is = null; 	
        try {
        	authService = new AuthenticationService(this.feedUrl);
            HttpResponse response = authService.getHttpResponse();
            HttpEntity entity = response.getEntity();
            if (entity != null) {      
                is = entity.getContent();
            }

        } catch (ClientProtocolException e) {
        	Log.e("BaseFeedParser.java", "Error connecting to server");
		} catch (IOException e) {
			Log.e("BaseFeedParser.java", "Error connecting to server");
		} 
        return is;
  
    }
}
