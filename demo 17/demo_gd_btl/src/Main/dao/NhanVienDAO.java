package Main.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Main.database.jdbc_until;
import Main.model.NhanVien;

public class NhanVienDAO implements Dao_interface<NhanVien>{
	
	public static NhanVienDAO getInstance() {
		return new NhanVienDAO();
	}

	@Override
	public int insert(NhanVien t) {
		int ketQua = 0;
		Connection con = jdbc_until.getConnection();
		try {
			String sql = "INSERT INTO nhanvien (iD_NhanVien, HoTen, GioiTinh ,NamSinh, SDT, DiaChi, iD_CoSo)"
					+ "VALUES (?,?,?,?,?,?,?)";
				
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, t.getID());
			pst.setString(2, t.getHoTen());
			pst.setString(3, t.getGioiTinh());
			pst.setDate(4, (Date) t.getNamSinh());
			pst.setString(5, t.getSDT());
			pst.setString(6, t.getDiaChi());
			pst.setString(7, t.getiD_CoSo());
			//pst.setString(8, t.getID_SDT_KH());
			
			ketQua = pst.executeUpdate();
			
			System.out.println("Bạn đã thực thi: "+ sql);
			System.out.println("Có "+ ketQua+" dòng bị thay đổi!");
			
			jdbc_until.closeConnection(con);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Mã nhân viên "+t.getID()+" đã tồn tại","Thông Báo",1);
			e.printStackTrace();
			
		}
		
		return ketQua;
	}

	@Override
	public int update(NhanVien t, String Condition) {
		int ketQua = 0;
		
		try {
			Connection con = jdbc_until.getConnection();
			
			String sql = "UPDATE nhanvien "+
					" SET " +
					" HoTen=?"+
					", GioiTinh=?"+
					", NamSinh=?"+
					", SDT=?"+
					", DiaChi=?"+
					", iD_CoSo=?"+
					" WHERE iD_NhanVien=?";
			
				
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, t.getHoTen());
			pst.setString(2, t.getGioiTinh());	
			pst.setDate(3, (Date) t.getNamSinh());
			pst.setString(4, t.getSDT());
			pst.setString(5, t.getDiaChi());
			pst.setString(6, t.getiD_CoSo());
			pst.setString(7, t.getID());
				
			ketQua = pst.executeUpdate();
			
			System.out.println("Bạn đã thực thi: "+ sql);
			System.out.println("Có "+ ketQua+" dòng bị thay đổi!");
			JOptionPane.showMessageDialog(null, "Cập nhật thành công nhân viên có mã " + t.getID(), "Thông báo", 1);
			
			jdbc_until.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ketQua;
	}

	@Override
	public int delete(NhanVien t, String condition) {
		int ketQua = 0;
		
		try {
			Connection con = jdbc_until.getConnection();
			
			String sql = "DELETE FROM nhanvien "+
					" WHERE iD_NhanVien=?";
			
				
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, t.getID());
			
			ketQua = pst.executeUpdate();
			
			System.out.println("Bạn đã thực thi: "+ sql);
			System.out.println("Có "+ ketQua+" dòng bị thay đổi!");
			JOptionPane.showMessageDialog(null, "Đã xóa nhân viên có mã " + t.getID(), "Thông báo", 1);
			
			jdbc_until.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ketQua;
	}

	@Override
	public ArrayList<NhanVien> selectALL() {
		ArrayList ketQua = new ArrayList();
		
		try {
			Connection con = jdbc_until.getConnection();
			
			String sql = "SELECT * FROM nhanvien ";
			PreparedStatement pst = con.prepareStatement(sql);
			
			System.out.println("Bạn đã thực thi: "+ sql);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				String ID = rs.getString("iD_NhanVien");
				String HoTen = rs.getString("HoTen");
				String gioiTinh = rs.getString("GioiTinh");
				Date NamSinh = rs.getDate("NamSinh");
				String SDT = rs.getString("SDT");
				String DiaChi = rs.getString("DiaChi");
				
				NhanVien nv = new NhanVien(ID, HoTen, gioiTinh, NamSinh, SDT, DiaChi);
				ketQua.add(nv);
			}
			
			jdbc_until.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ketQua;	
	}

	@Override
	public NhanVien Selectby_id(NhanVien t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<NhanVien> select_by_condition(String condition) {
		ArrayList ketQua = new ArrayList();
		try {
			Connection con = jdbc_until.getConnection();
			
			String sql = "SELECT * FROM nhanvien "+
					" WHERE HoTen like ?";
			
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, "%"+condition+"%");
			
			System.out.println("Bạn đã thực thi: "+ sql);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				String ID = rs.getString("iD_NhanVien");
				String hoTen = rs.getString("HoTen");
				String gioiTinh = rs.getString("GioiTinh");
				Date NamSinh = rs.getDate("NamSinh");
				String SDT = rs.getString("SDT");
				String DiaChi = rs.getString("DiaChi");
				
				NhanVien nv = new NhanVien(ID, hoTen, gioiTinh, NamSinh, SDT, DiaChi);
				ketQua.add(nv);
			}
		
			jdbc_until.closeConnection(con);
		} catch (Exception e) {
			System.out.println("Lỗi tìm !");
		}
		
		return ketQua;
	}


	public ArrayList<NhanVien> SelectNhanVien(String condition) {
		ArrayList ketQua = new ArrayList();
		try {
			Connection con = jdbc_until.getConnection();
			
			String sql = "SELECT * FROM nhanvien "+
					" WHERE " + condition;
			
			PreparedStatement pst = con.prepareStatement(sql);
			//pst.setString(1, condition);
			
			System.out.println("Bạn đã thực thi: "+ sql);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				String ID = rs.getString("iD_NhanVien");
				String hoTen = rs.getString("HoTen");
				String gioiTinh = rs.getString("GioiTinh");
				Date NamSinh = rs.getDate("NamSinh");
				String SDT = rs.getString("SDT");
				String DiaChi = rs.getString("DiaChi");
				
				NhanVien nv = new NhanVien(ID, hoTen, gioiTinh, NamSinh, SDT, DiaChi);
				ketQua.add(nv);
			}
		
			jdbc_until.closeConnection(con);
		} catch (Exception e) {
			System.out.println("Lỗi tìm !");
			e.printStackTrace();
		}
		
		return ketQua;
	}
	
}