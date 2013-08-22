package kolz.android.services;

import java.io.IOException;
import java.net.URL;

import kolz.android.domain.Credentials;
import kolz.android.network.NTLMSchemeFactory;

import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.AuthenticationException;
import org.apache.http.auth.NTCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

import android.util.Log;

public class AuthenticationService {

	private URL url;

	public AuthenticationService(URL url) {
		this.url = url;
	}

	public HttpResponse getHttpResponse() throws AuthenticationException {
		DefaultHttpClient httpclient = new DefaultHttpClient();
		HttpResponse response = null;
		Credentials creds = Credentials.getInstance();
		httpclient.getAuthSchemes().register("ntlm", new NTLMSchemeFactory());
		httpclient.getCredentialsProvider().setCredentials(
				new AuthScope(AuthScope.ANY_HOST, -1),
				new NTCredentials(creds.getUsername(), creds.getPassword(),
						"android", "geocent.com"));
		HttpGet httpget = new HttpGet(url.toString());
		try {
			response = httpclient.execute(httpget);
		} catch (ClientProtocolException ex) {
			String message = "Could not get response from server";
			Log.e("AuthenticationService", message);
		} catch (IOException e) {
			String message = "Could not get response from server";
			Log.e("AuthenticationService", message);
		} finally {
			httpclient.getConnectionManager().shutdown();
		}

		if (null != response) {
			if (response.getStatusLine().getStatusCode() != 200) {
				Log.e("AuthenticationService", "Invalid Credentials");
				throw new AuthenticationException();
			}
		}

		return response;
	}

	public boolean loginValid() {
		
		HttpParams httpParams = new BasicHttpParams();
		HttpConnectionParams.setConnectionTimeout(httpParams, 5000);
		HttpConnectionParams.setSoTimeout(httpParams, 5000);
		DefaultHttpClient httpclient = new DefaultHttpClient(httpParams);
		HttpResponse response = null;
		Credentials creds = Credentials.getInstance();
		httpclient.getAuthSchemes().register("ntlm", new NTLMSchemeFactory());
		httpclient.getCredentialsProvider().setCredentials(
				new AuthScope(AuthScope.ANY_HOST, -1),
				new NTCredentials(creds.getUsername(), creds.getPassword(),
						"android", "geocent.com"));
		HttpGet httpget = new HttpGet(url.toString());
		try {
			response = httpclient.execute(httpget);
		} catch (ClientProtocolException ex) {
			String message = "Could not get response from server";
			Log.e("AuthenticationService", message);
			return false;
		} catch (IOException e) {
			String message = "Could not get response from server";
			Log.e("AuthenticationService", message);
			return false;
		} finally {
			httpclient.getConnectionManager().shutdown();
		}

		if (null != response) {
			if (response.getStatusLine().getStatusCode() != 200) {
				Log.e("AuthenticationService", "Invalid Credentials");
				return false;
			} else
				return true;
		}
		return false;
	}
}
