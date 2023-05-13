package Main.database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class jdbc_until {
	// phương thức
	public static Connection getConnection() {

		Connection c = null;

		// tao driver
		// com.mysql.cj.jdbc.Driver driver= new com.mysql.cj.jdbc.Driver();
		try {
			// ĐĂNG KÝ MY SQL DRIVER VỚI DRIVERMANAGER
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			
			// thông số 
			String url = "jdbc:mySQL://localhost:3306/ungdungsanbong";// đường dẫn đến mySQL
			String username = "root";// ten người dùng
			String password = "12345";// mật khẩu

			// tạo kết nối
			c = DriverManager.getConnection(url, username, password);

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return c;

	}

	public static void closeConnection(Connection c) {
		try {
			if (c != null) {
				c.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void printInfo(Connection c) {

		try {
			if (c != null) {
				DatabaseMetaData mttd = c.getMetaData();
				System.out.println(mttd.getDatabaseProductName());
				System.out.println(mttd.getDatabaseProductVersion());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
