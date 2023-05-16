package Test;

import javax.swing.UIManager;
import sign_in.demo_login_user;


public class Test {
	public static void main(String[] args) {
		try {
			 UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			 demo_login_user user = new demo_login_user();
				user.setVisible(true);		
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
