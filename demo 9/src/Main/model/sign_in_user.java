package Main.model;

import javax.swing.JTextField;

public class sign_in_user {
	private String username;
	private String password;

	public sign_in_user() {

	}

	public sign_in_user(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String txt_username) {
		this.username = txt_username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
