package Test;

import javax.swing.UIManager;

import Main.dao.dat_san_dao;
import sign_in.demo_login_user;


public class Test {
	public static void main(String[] args) {
		try {
			 UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			 demo_login_user user = new demo_login_user();
			 dat_san_dao.getInterface().xoa_lich_qua_han();
				user.setVisible(true);		
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
