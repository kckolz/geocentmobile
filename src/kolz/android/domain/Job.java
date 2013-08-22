package kolz.android.domain;


public class Job {

	private String name;
	private Location location;
	private Coordinate coordinate;
	private String description;
	private String id;
	
	public Job(String name, Location location, String description, String id) {
		this.name = name;
		this.location = location;
		this.description = description;
		this.id = id;
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Coordinate getCoordinate() {
		return coordinate;
	}
	public void setCoordinate(Coordinate coordinate) {
		this.coordinate = coordinate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	
	
}
