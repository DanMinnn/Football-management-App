package Main.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.cj.xdevapi.PreparableStatement;

import Main.database.*;
import Main.model.*;


public class sign_in_user_dao implements Dao_interface<sign_in_user> {

	
	public static sign_in_user_dao getInterface(){
		return new sign_in_user_dao();
	}
	@Override
	public int insert(sign_in_user t) {// THÊM MỘT USER MỚI VÀO sign_in_user
		int check =0;
		try {
			// tạo kết nối
		Connection connection = jdbc_until.getConnection();
		// thêm câu lệnh 
			String sql = "insert signin_user (username, password,sdt) values(?,?,?)";
		// tạo biến statement
			PreparedStatement pst = connection.prepareStatement(sql);
			// thực thi câu lệnh
				pst.setString(1, t.getUsername());
				pst.setString(2, t.getPassword());
				pst.setString(3, t.getSdt());
				 check = pst.executeUpdate();
					if(check>0) {
						System.out.println("bạn vừa thực hiện câu lênh: "+ sql+" thành công");
					}else {
						System.out.println("thực hiện không thành công");
					}
			// ngắt kết nối 
			jdbc_until.closeConnection(connection);
		} catch (SQLException e){ e.printStackTrace(); }
		return check;
	}
	public boolean check_username(String t) {
		try {
			// tạo kết nối
			Connection connection = jdbc_until.getConnection();
			// tạo biến statement
			String sql = " Select * from user;";
			PreparedStatement pst = connection.prepareStatement(sql);
			// thêm câu lệnh
			System.out.println("bạn vừa thực hiện câu lênh: " + sql);
			// thực thi câu lệnh
			ResultSet rs = pst.executeQuery();
			while (rs.next()){
				if(rs.getString("username").equals(t)) {
					return true;
				}
			}
			// ngắt kết nối
			jdbc_until.closeConnection(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public int delete(sign_in_user t,String condition) {
		int check =0;
		try {
			// tạo kết nối
		Connection connection = jdbc_until.getConnection();
		// thêm câu lệnh 
			String sql = "delete from user where sdt ="+condition;
		// tạo biến statement
			PreparedStatement pst = connection.prepareStatement(sql);
			// thực thi câu lệnh
				 check = pst.executeUpdate();
					if(check>0) {
						System.out.println("bạn vừa thực hiện câu lênh: "+ sql+" thành công");
					}else {
						System.out.println("thực hiện không thành công");
					}
			// ngắt kết nối 
			jdbc_until.closeConnection(connection);
		} catch (SQLException e){ e.printStackTrace(); }
		return check;	
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

	@Override
	public int update(sign_in_user t, String condition) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
