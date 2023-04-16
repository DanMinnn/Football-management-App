package Main.model;

import javax.swing.JTextField;

public class sign_in_user {
	private String username;
	private String password;
	private String sdt;
	
	
	public sign_in_user(String username, String password, String sdt) {
		this.username = username;
		this.password = password;
		this.sdt = sdt;
	}
	
	
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public sign_in_user() {
	
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
