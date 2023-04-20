package Main.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import com.mysql.cj.xdevapi.PreparableStatement;

import Main.database.*;
import Main.model.san_bong;

public class san_bong_dao implements Dao_interface<san_bong> {

	public static san_bong_dao getInterface() {
		return new san_bong_dao();
	}

	@Override
	public int insert(san_bong t) {
//		try {
//			// tạo kết nối
//		Connection connection = jdbc_until.getConnection();
//		// tạo biến statement
//			Statement st= connection.createStatement();
//			// thêm câu lệnh 
//			String sql = "insert into san_bong ( maS, san_so, loai_san, trang_thai ) values('" +t.getMaS()+ "', '" +t.getSo_san()+ "', '" +t.getLoai_san()+ "', '" +t.getTrang_thai_san()+ "');";
//			
//			// thực thi câu lệnh
//			int check = st.executeUpdate(sql);
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
	public int update(san_bong t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(san_bong t) {
		return 0;
	}

	@Override
	public ArrayList<san_bong> selectALL() {
		ArrayList<san_bong> list = new ArrayList<>();
		
		try {
			// tạo kết nối
		Connection connection = jdbc_until.getConnection();
		// tạo biến statement
			Statement st= connection.createStatement();
			// thêm câu lệnh 
			String sql = "	Select * from san_bong ";
			
			// thực thi câu lệnh
			ResultSet rs  = st.executeQuery(sql);
	        
			System.out.println("bạn vừa thực hiện câu lênh: "+ sql);
	        
			while(rs.next()) {
				san_bong sb = new san_bong();
				sb.setMa_San(rs.getInt("maCS"));
				sb.setTen_san(rs.getString("ten_san"));
				sb.setLoai_san(rs.getInt("loai_san"));
				sb.setNgay_da(rs.getDate("ngay_Da"));
				sb.setThoi_gian_da(rs.getDate("thoi_gian"));
				sb.setTrang_thai_san(rs.getString("trang_thai"));
				
				list.add(sb);
			}
			// ngắt kết nối 
			jdbc_until.closeConnection(connection);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public san_bong Selectby_id(san_bong t) {
		san_bong sb = null; 
		try {
			// tạo kết nối
		Connection connection = jdbc_until.getConnection();
		// tạo biến statement
			Statement st= connection.createStatement();
			// thêm câu lệnh 
			String sql = "	Select * from san_bong where maCS ='"+t.getMa_San()+"';";
			System.out.println("bạn vừa thực hiện câu lênh: "+ sql);
			// thực thi câu lệnh
			ResultSet rs  = st.executeQuery(sql);
			while(rs.next()) {
				 sb = new san_bong();
				sb.setMa_San(rs.getInt("maCS"));
				sb.setTen_san(rs.getString("ten_san"));
				sb.setLoai_san(rs.getInt("loai_san"));
				sb.setNgay_da(rs.getDate("ngay_Da"));
				sb.setThoi_gian_da(rs.getDate("thoi_gian"));
				sb.setTrang_thai_san(rs.getString("trang_thai"));
		
			}
			// ngắt kết nối 
			jdbc_until.closeConnection(connection);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sb;
	}

	@Override
	public ArrayList<san_bong> select_by_condition(String condition) {
        ArrayList<san_bong> list = new ArrayList<>();
		
		try {
			// tạo kết nối
		Connection connection = jdbc_until.getConnection();
		// tạo biến statement
			Statement st= connection.createStatement();
			// thêm câu lệnh 
			String sql = "	Select * from san_bong where "+ condition;
			
			// thực thi câu lệnh
			ResultSet rs  = st.executeQuery(sql);
	        
			System.out.println("bạn vừa thực hiện câu lênh: "+ sql);
	        
			while(rs.next()) {
				san_bong sb = new san_bong();
				sb.setMa_San(rs.getInt("maCS"));
				sb.setTen_san(rs.getString("ten_san"));
				sb.setLoai_san(rs.getInt("loai_san"));
				sb.setNgay_da(rs.getDate("ngay_Da"));
				sb.setThoi_gian_da(rs.getDate("thoi_gian"));
				sb.setTrang_thai_san(rs.getString("trang_thai"));
				
				list.add(sb);
			}
			// ngắt kết nối 
			jdbc_until.closeConnection(connection);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
