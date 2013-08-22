package kolz.android.enums;

public enum City {

	NEWORLEANS (29.932,-90.074),
	CHARLESTON (32.78,-79.937),
	BATONROUGE (30.407,-91.147),
	COVINGTON (30.488,-90.096);
	
	private final double x;
	private final double y;
	
	City(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public double x() {
		return x;
	}
	
	public double y() {
		return y;
	}
}
