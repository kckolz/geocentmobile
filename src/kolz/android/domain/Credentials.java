package kolz.android.domain;


public class Credentials {
	
	private String username;
	private String password;
	private boolean loggedIn;
	private static Credentials instance = null;
	
	protected Credentials() {}
	
	public static Credentials getInstance() {
	      if(instance == null) {
	         instance = new Credentials();
	      }
	      return instance;
	   }
	
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	
	public void setUsername(String un) {
		this.username = un;
	}
	public void setPassword(String pw) {
		this.password = pw;
	}
	
	public boolean isLoggedIn() {
		return loggedIn;
	}
	
	public void setLoggedIn(boolean status) {
		this.loggedIn = status;
	}
	
	
	
}
