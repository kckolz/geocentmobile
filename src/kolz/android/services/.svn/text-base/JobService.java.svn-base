package kolz.android.services;

import java.util.ArrayList;
import java.util.UUID;

import kolz.android.domain.Coordinate;
import kolz.android.domain.Job;
import kolz.android.domain.Location;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import android.util.Log;

public class JobService {
	
       
    private static final String NAMESPACE = "http://www.geocent.com/services";
    private static final String URL = "http://jobsservice.geocent.com:8080/JobsService.asmx";
    private String soapAction;
    private String methodName;
    private HttpTransportSE httpTransport;
    private SoapSerializationEnvelope soapEnvelope;
    private ArrayList<Job> jobs;
    private CoordinateService coordinateService;


    public JobService(ArrayList<Job> jobs) {   
        this.soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        soapEnvelope.dotNet = true;
        this.httpTransport = new HttpTransportSE(URL);
        this.jobs = jobs;
    }
    
    
    public ArrayList<Job> getJobs(String id) throws Exception{

        soapAction = "http://www.geocent.com/services/GetJobsByLocation";
        methodName = "GetJobsByLocation";
           	
    	SoapObject request = new SoapObject(NAMESPACE, methodName);
        request.addProperty("locationId", id);
        soapEnvelope.setOutputSoapObject(request);
		httpTransport.call(soapAction, soapEnvelope);
		
		SoapObject results = (SoapObject)soapEnvelope.getResponse();
		int propCount = results.getPropertyCount();
		if(propCount > 0) {
			this.coordinateService = new CoordinateService();
			for(int i = 0; i< propCount; i++) {
				SoapObject result = (SoapObject) results.getProperty(i);
				Job job = new Job(result.getProperty("Name").toString(),new Location(result.getProperty("LocationName").toString(),id), result.getProperty("Description").toString(),result.getProperty("Id").toString());
				
				Coordinate coordinate = new Coordinate(coordinateService.getCoordinates(result.getProperty("LocationName").toString()));
				job.setCoordinate(coordinate);
				
				jobs.add(job);
	    		Log.i("Jobs by Location WS Call",result.getProperty(i).toString());
			}
		}
		return jobs;
        
    }
}
