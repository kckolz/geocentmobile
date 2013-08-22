package kolz.android.services;

import kolz.android.enums.RequestMethod;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import android.util.Log;

public class CoordinateService {
	
	private static final String URL = "http://maps.googleapis.com/maps/api/geocode/json";
	private RestClient restClient;
	

	
	public CoordinateService() {
		this.restClient = new RestClient(URL);
	}
	
	public double[] getCoordinates(String address) {
		
		double[] coordinates = new double[2];
		
		this.restClient.addParam("address", address);
		this.restClient.addParam("sensor", "false");
		
		try {
		    restClient.execute(RequestMethod.GET);
		} catch (Exception e) {
		    e.printStackTrace();
		}
		
		String response = restClient.getResponse();
		try {
			JSONObject jsonResponse = (JSONObject) new JSONTokener(response).nextValue();
			JSONArray resultsArray = jsonResponse.getJSONArray("results");
			JSONObject results = resultsArray.getJSONObject(0);
			JSONObject geometry = results.getJSONObject("geometry");
			JSONObject location = geometry.getJSONObject("location");
			String lat = location.getString("lat");
			String lng = location.getString("lng");
			Log.i("Lattitude = ",lat);
			Log.i("Longitude = ",lng);
			coordinates[0] = Double.valueOf(lat);
			coordinates[1] = Double.valueOf(lng);	
		} catch (JSONException e) {
			Log.e("Restclient parse json",e.toString());
		}

		
		return coordinates;
	}
	
}
