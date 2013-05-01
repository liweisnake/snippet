package org.levi.reusable.jaas;

public class LoginEntity {

	private String userName;

	private String password;

	private String capture;

	public LoginEntity(String userName, String password, String capture) {
		super();
		this.userName = userName;
		this.password = password;
		this.capture = capture;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCapture() {
		return capture;
	}

	public void setCapture(String capture) {
		this.capture = capture;
	}

}
