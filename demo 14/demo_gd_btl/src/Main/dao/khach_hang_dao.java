package Main.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Main.database.jdbc_until;
import Main.model.khach_hang;
import Main.model.san_bong;

public class khach_hang_dao implements Dao_interface<khach_hang> {

	public static khach_hang_dao getInterface() {
		return new khach_hang_dao();
	}
	
	
	@Override
	public int insert(khach_hang t) {
		int ketqua = 0;
		try {
			// tạo kết nối
			Connection connection = jdbc_until.getConnection();
			// thêm câu lệnh
			String sql = "insert into khachhang (ID_SDT_KH, HoTen) values(?,?)";
			// tạo biến PreparedStatement
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getSo_dien_thoai());
			pst.setString(2, t.getTen());
			// thực thi câu lệnh
			ketqua = pst.executeUpdate();
			if (ketqua > 0) {
				System.out.println("bạn vừa thực hiện câu lênh: " + sql + " thành công");
			} else {
				System.out.println("thực hiện không thành công");
			}
			// ngắt kết nối
			JOptionPane.showMessageDialog(null, "Thêm khách hàng mới thành công!");
			jdbc_until.closeConnection(connection);

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Khách hàng đã tồn tại thành công!");
			JOptionPane.showMessageDialog(null, e);
		}
		return ketqua;
	}

	@Override
	public int update(khach_hang t, String condition) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(khach_hang t, String condition) {
		int ketqua = 0;
		try {
			// tạo kết nối
			Connection connection = jdbc_until.getConnection();
			// thêm câu lệnh
			String sql = "Delete from khachhang where ID_SDT_KH="+condition;
			// tạo biến PreparedStatement
			PreparedStatement pst = connection.prepareStatement(sql);
			// thực thi câu lệnh
			ketqua = pst.executeUpdate();
			if (ketqua > 0) {
				System.out.println("bạn vừa thực hiện câu lênh: " + sql + " thành công");
			} else {
				System.out.println("thực hiện không thành công");
			}
			// ngắt kết nối
			JOptionPane.showMessageDialog(null, "Xoá khách hàng thành công!");
			jdbc_until.closeConnection(connection);

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}
		return ketqua;
	}

	@Override
	public ArrayList<khach_hang> selectALL() {
		ArrayList<khach_hang> list = new ArrayList<>();
		try {
			// tạo kết nối
			Connection connection = jdbc_until.getConnection();
			// tạo biến statement
			String sql = "	Select * from khachhang ";
			PreparedStatement pst = connection.prepareStatement(sql);
			// thực thi câu lệnh
			ResultSet rs = pst.executeQuery();

			System.out.println("bạn vừa thực hiện câu lênh: " + sql);

			while (rs.next()) {
				khach_hang kh = new khach_hang();
				kh.setTen(rs.getString("HoTen"));
				kh.setSo_dien_thoai(rs.getString("ID_SDT_KH"));	
				list.add(kh);
			}
			// ngắt kết nối
			jdbc_until.closeConnection(connection);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public khach_hang Selectby_id(khach_hang t) {
		khach_hang kh = null;
		try {
			// tạo kết nối
			Connection connection = jdbc_until.getConnection();
			// tạo biến statement
			String sql = " Select * from khachhang where ID_SDT_KH = ?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getSo_dien_thoai());
			// thêm câu lệnh
			System.out.println("bạn vừa thực hiện câu lênh: " + sql);
			// thực thi câu lệnh
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				kh = new khach_hang();
				kh.setTen(rs.getString("HoTen"));
				kh.setSo_dien_thoai(rs.getString("ID_SDT_KH"));	
			}
			// ngắt kết nối
			jdbc_until.closeConnection(connection);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kh;
	}

	@Override
	public ArrayList<khach_hang> select_by_condition(String condition) {
//		ArrayList<khach_hang> list = new ArrayList<>();
//		try {
//			// tạo kết nối
//			Connection connection = jdbc_until.getConnection();
//			// tạo biến statement
//			String sql = "	Select * from khachhang ";
//			PreparedStatement pst = connection.prepareStatement(sql);
//			// thực thi câu lệnh
//			ResultSet rs = pst.executeQuery();
//
//			System.out.println("bạn vừa thực hiện câu lênh: " + sql);
//
//			while (rs.next()) {
//				khach_hang kh = new khach_hang();
//				kh.setTen(rs.getString("HoTen"));
//				kh.setSo_dien_thoai(rs.getString("ID_SDT_KH"));	
//				list.add(kh);
//			}
//			// ngắt kết nối
//			jdbc_until.closeConnection(connection);
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
// list;
		return null;
	}

	
}
