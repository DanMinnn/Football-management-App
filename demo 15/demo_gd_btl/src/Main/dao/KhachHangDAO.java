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

public class KhachHangDAO implements Dao_interface<khach_hang> {

	public static KhachHangDAO getInstance() {
		return new KhachHangDAO();
	}
	
	
	@Override
	public int insert(khach_hang t) {
		int ketqua = 0;
		try {
			// tạo kết nối
			Connection connection = jdbc_until.getConnection();
			// thêm câu lệnh
			String sql = "insert into khachhang (HoTen, ID_SDT_KH) values(?,?)";
			// tạo biến PreparedStatement
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getHoTen());
			pst.setString(2, t.getSoDienThoai());
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
	public int update(khach_hang t,String condition) {
		int ketQua = 0;
		
		try {
			Connection con = jdbc_until.getConnection();
			
			String sql = "UPDATE khachhang "+
					" SET " +
					" HoTen=?"+
					" WHERE ID_SDT_KH=?";
			
				
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, t.getHoTen());
			pst.setString(2, t.getSoDienThoai());
			
			ketQua = pst.executeUpdate();
			
			System.out.println("Bạn đã thực thi: "+ sql);
			System.out.println("Có "+ ketQua+" dòng bị thay đổi!");
			JOptionPane.showMessageDialog(null, "Cập nhật thành công khách hàng có mã ", "Thông báo", 1);
			
			jdbc_until.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ketQua;
	}

	@Override
	public int delete(khach_hang t, String condition) {
		int ketqua = 0;
		try {
			// tạo kết nối
			Connection con = jdbc_until.getConnection();
			// thêm câu lệnh
			String sql = "Delete from khachhang where ID_SDT_KH=?" ;
			// tạo biến PreparedStatement
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, t.getSoDienThoai());
			// thực thi câu lệnh
			ketqua = pst.executeUpdate();
			if (ketqua > 0) {
				System.out.println("bạn vừa thực hiện câu lênh: " + sql + " thành công");
			} else {
				System.out.println("thực hiện không thành công");
			}
			// ngắt kết nối
			
			JOptionPane.showMessageDialog(null, "Xoá khách hàng thành công!");
			
			jdbc_until.closeConnection(con);

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
				kh.setHoTen(rs.getString("HoTen"));
				kh.setSoDienThoai(rs.getString("ID_SDT_KH"));	
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
			pst.setString(1, t.getSoDienThoai());
			// thêm câu lệnh
			System.out.println("bạn vừa thực hiện câu lênh: " + sql);
			// thực thi câu lệnh
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				kh = new khach_hang();
				kh.setHoTen(rs.getString("HoTen"));
				kh.setSoDienThoai(rs.getString("ID_SDT_KH"));	
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
		ArrayList ketQua = new ArrayList();
		
		try {
			Connection con = jdbc_until.getConnection();
			
			String sql = "SELECT * FROM khachhang WHERE ID_SDT_KH = ?";
			
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, condition);
			
			System.out.println("Bạn đã thực thi: "+ sql);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				String hoTen = rs.getString("HoTen");
				String iD_SDT = rs.getString("ID_SDT_KH");
				
				khach_hang kh = new khach_hang(iD_SDT, hoTen);
				ketQua.add(kh);
			}
	
			jdbc_until.closeConnection(con);
		} catch (Exception e) {
			System.out.println("Lỗi tìm !");
			e.printStackTrace();
		}
		
		return ketQua;
	}

	
}
