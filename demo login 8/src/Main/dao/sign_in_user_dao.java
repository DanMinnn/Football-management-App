package Main.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.cj.xdevapi.PreparableStatement;

import Main.database.*;
import Main.model.*;


public class sign_in_user_dao implements Dao_interface<sign_in_user> {

	
	public static sign_in_user_dao getInterface(){
		return new sign_in_user_dao();
	}
	
	@Override
	public int insert(sign_in_user t) {// THÊM MỘT USER MỚI VÀO sign_in_user
//		int check =0;
//		try {
//			// tạo kết nối
//		Connection connection = jdbc_until.getConnection();
//		// tạo biến statement
//			PreparedStatement pst = connection.prepareStatement(null);
//			// thêm câu lệnh 
//			String sql = "insert into sign_in_user (username, password) values(?,?);";
//			
//			pst.setString(1, t.getUsername());
//			pst.setString(2, t.getPassword());
//			// thực thi câu lệnh
//			 check = st.executeUpdate(sql);
//			if(check>0) {
//				System.out.println("bạn vừa thực hiện câu lênh: "+ sql+" thành công");
//			}else {
//				System.out.println("thực hiện không thành công");
//			}
//			// ngắt kết nối 
//			jdbc_until.closeConnection(connection);
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		return 0;
	}

	@Override
	public int update(sign_in_user t) {
		
		return 0;
	}

	@Override
	public int delete(sign_in_user t) {
		return 0;
	}

	@Override
	public ArrayList<sign_in_user> selectALL(){
		return null;
	}

	@Override
	public sign_in_user Selectby_id(sign_in_user t) {
		return null;
	}

	@Override
	public ArrayList<sign_in_user> select_by_condition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void check() {
		
	}

}
