package administration.beans;

public class Administrator {
	private long ID;
	private String login;
	private String password;
	public long getID() {
		return ID;
	}
	public void setID(long iD) {
		ID = iD;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Administrator [ID=" + ID + ", login=" + login + ", password=" + password + "]";
	}
	
}
