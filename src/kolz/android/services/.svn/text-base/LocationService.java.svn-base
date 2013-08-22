package kolz.android.services;

import java.util.ArrayList;

import kolz.android.domain.Location;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import android.util.Log;

public class LocationService {

    private static final String NAMESPACE = "http://www.geocent.com/services";
    private static final String URL = "http://jobsservice.geocent.com:8080/JobsService.asmx";
    private String soapAction;
    private String methodName;
    private HttpTransportSE httpTransport;
    private SoapSerializationEnvelope soapEnvelope;
    private ArrayList<Location> locations;

    
    public LocationService(ArrayList<Location> locations) {   
        this.soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        soapEnvelope.dotNet = true;
        this.httpTransport = new HttpTransportSE(URL);
        this.locations = locations;
    }
    
    public ArrayList<Location> getJobLocations() throws Exception {
    	
    	soapAction = "http://www.geocent.com/services/GetJobLocations";
        methodName = "GetJobLocations";
        
    	
    	SoapObject request = new SoapObject(NAMESPACE, methodName);
        soapEnvelope.setOutputSoapObject(request);
		httpTransport.call(soapAction, soapEnvelope);
		
		SoapObject results = (SoapObject)soapEnvelope.getResponse();
		int propCount = results.getPropertyCount();
		if(propCount > 0) {
			for(int i = 0; i< propCount; i++) {
				SoapObject result = (SoapObject) results.getProperty(i);
				Location location = new Location(result.getProperty("Name").toString(),result.getProperty("Id").toString());
				locations.add(location);
	    		Log.i("Job Location WS Call",result.getProperty("Name").toString());
			}
		}
		return locations;
    }

}
