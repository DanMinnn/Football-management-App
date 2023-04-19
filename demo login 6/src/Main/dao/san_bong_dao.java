package Main.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Main.database.*;
import Main.model.san_bong;

public class san_bong_dao implements Dao_interface<san_bong> {

	public static san_bong_dao getInterface() {
		return new san_bong_dao();
	}

	@Override
	public int insert(san_bong t) {
		try {
			// tạo kết nối
		Connection connection = jdbc_until.getConnection();
		// tạo biến statement
			Statement st= connection.createStatement();
			// thêm câu lệnh 
			String sql = "insert into san_bong ( maS, san_so, loai_san, trang_thai ) values('" +t.getMaS()+ "', '" +t.getSo_san()+ "', '" +t.getLoai_san()+ "', '" +t.getTrang_thai_san()+ "');";
			
			// thực thi câu lệnh
			int check = st.executeUpdate(sql);
			if(check>0) {
				System.out.println("bạn vừa thực hiện câu lênh: "+ sql+" thành công");
			}else {
				System.out.println("thực hiện không thành công");
			}
			// ngắt kết nối 
			jdbc_until.closeConnection(connection);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return 0;
	}

	@Override
	public int update(san_bong t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(san_bong t) {
		try {
			// tạo kết nối
		Connection connection = jdbc_until.getConnection();
		// tạo biến statement
			Statement st= connection.createStatement();
			// thêm câu lệnh 
			String sql = "	DELETE from san_bong"+
						   " where maS="+ t.getMaS()+";";
			
			// thực thi câu lệnh
			int check = st.executeUpdate(sql);
	
				System.out.println("bạn vừa thực hiện câu lênh: "+ sql);
				System.out.println("có "+check+" dòng thay đổi");
	
			// ngắt kết nối 
			jdbc_until.closeConnection(connection);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public ArrayList<san_bong> selectALL() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public san_bong Selectby_id(san_bong t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<san_bong> select_by_condition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

}
