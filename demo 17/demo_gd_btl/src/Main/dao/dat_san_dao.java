package Main.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import Main.database.jdbc_until;
import Main.model.dat_san;
import Main.model.khach_hang;
import Main.model.san_bong;

public class dat_san_dao implements Dao_interface<dat_san> {
	
	@Override
	public int insert(dat_san t) {
		int ketqua = 0;
		try {
			// tạo kết nối
			Connection connection = jdbc_until.getConnection();
			// thêm câu lệnh
			String sql = "insert into lichdat (iD_CoSo,iD_SanBong,TenSan, LoaiSan, NgayDa,tgBatDau ,tgKetThuc,ID_SDT_KH) values(?,?,?,?,?,?,?,?)";
			// tạo biến PreparedStatement
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaCS());
			pst.setString(2, t.getMa_san());
			pst.setString(3, t.getTen_san());
			pst.setString(4, t.getLoai_san());
			pst.setString(5, t.getNgay_Da());
			pst.setString(6, t.getGio_bat_dau());
			pst.setString(7, t.getGio_ket_thuc());
			pst.setString(8, t.getSdt());
			
			// thực thi câu lệnh
			ketqua = pst.executeUpdate();
			if (ketqua > 0) {
				System.out.println("bạn vừa thực hiện câu lênh: " + sql + " thành công");
			} else {
				System.out.println("thực hiện không thành công");
			}
			// ngắt kết nối
			JOptionPane.showMessageDialog(null, "Đặt sân bóng mới thành công!");
			jdbc_until.closeConnection(connection);

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}
		return ketqua;
	}

	@Override
	public int update(dat_san t, String condition) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(dat_san t, String condition) {
		int ketqua = 0;
		try {
			// tạo kết nối
			Connection connection = jdbc_until.getConnection();
			// thêm câu lệnh
			String sql = "DELETE FROM lichdat WHERE " +condition;
			// tạo biến PreparedStatement
			PreparedStatement pst = connection.prepareStatement(sql);
			// thực thi câu lệnh
			ketqua = pst.executeUpdate();
			if (ketqua > 0) {
				System.out.println("bạn vừa thực hiện câu lênh: " + sql + " thành công");
			}
			// ngắt kết nối
			//JOptionPane.showMessageDialog(null, "Huỷ sân bóng thành công!");
			jdbc_until.closeConnection(connection);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}
		return ketqua;
	}

	@Override
	public ArrayList<dat_san> selectALL() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public dat_san Selectby_id(dat_san t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<dat_san> select_by_condition(String condition) {
		ArrayList<dat_san> list = new ArrayList<>();
		try {
			// tạo kết nối
			Connection connection = jdbc_until.getConnection();
			// thêm câu lệnh
			String sql = "	Select * from lichdat where " + condition;
			// tạo biến statement
			PreparedStatement pst = connection.prepareStatement(sql);
			//pst.setInt(1, t.getMa_San());
			// thực thi câu lệnh
			ResultSet rs = pst.executeQuery();
            
			System.out.println("bạn vừa thực hiện câu lênh: " + sql);

			while (rs.next()) {
				dat_san dt= new dat_san();
				dt.setMa_san(rs.getString("iD_SanBong"));
				dt.setTen_san(rs.getString("TenSan"));
				dt.setLoai_san(rs.getString("LoaiSan"));
				dt.setNgay_Da(rs.getString("NgayDa"));
				dt.setGio_bat_dau(rs.getString("tgBatDau"));
				dt.setGio_ket_thuc(rs.getString("tgKetThuc"));
				dt.setSdt(rs.getString("ID_SDT_KH"));
				list.add(dt);
			}
			// ngắt kết nối
			jdbc_until.closeConnection(connection);
             return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;	
	}

	public boolean check_san(String ngay_da, String gio_da, String gio_nghi, String ma_cs,String ten_san){
		//int ket_qua=0;
		try {
			// tạo kết nối
			Connection connection = jdbc_until.getConnection();
			// thêm câu lệnh
			String sql ="select sb.iD_SanBong, sb.TenSan, sb.iD_CoSo, ld.NgayDa, ld.tgBatDau, ld.tgKetThuc\r\n"
					+ "from lichdat ld\r\n"
					+ "right join sanbong sb on ld.iD_SanBong = sb.iD_SanBong";
			// tạo biến PreparedStatement
			PreparedStatement pst = connection.prepareStatement(sql);
			// thực thi câu lệnh
				System.out.println("bạn vừa thực hiện câu lênh: " + sql + " thành công");
				ResultSet rs = pst.executeQuery();
				while (rs.next()){
					if(rs.getString("sb.TenSan").equals(ten_san)&&rs.getString("sb.iD_CoSo").equals(ma_cs)){
						if(rs.getString("ld.tgBatDau")!=null&&rs.getString("ld.tgKetThuc")!=null&&rs.getString("ld.NgayDa")!=null){
							if(check_gio_Da(gio_da, gio_nghi, ngay_da, rs.getString("ld.tgBatDau"),rs.getString("ld.tgKetThuc"), rs.getString("ld.NgayDa"))==false) {
								return false;
							} 
							else {
								if(rs.getString("ld.tgBatDau").equals(gio_da)&&rs.getString("ld.tgKetThuc").equals(gio_nghi)&&rs.getString("ld.NgayDa").equals(ngay_da)){
									return false;
							    }else{
							    	continue;
								} 
							}
					}
					else{
						JOptionPane.showMessageDialog(null, "Có sân trống trong khung giờ "+gio_da+"-"+gio_nghi+" ngày "+ngay_da+" mã sân "+ rs.getString("sb.iD_SanBong"));
						return true;
						}
					} 
					}
			// ngắt kết nối
			jdbc_until.closeConnection(connection);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}
		return true;
	}

	public String lay_ma_san(String ngay_da, String gio_da, String gio_nghi, String maCS,String ten_san){
		String ma_san = null;
		try {
			// tạo kết nối
			Connection connection = jdbc_until.getConnection();
			// thêm câu lệnh
			String sql ="select sb.iD_SanBong, sb.TenSan, sb.iD_CoSo, ld.NgayDa, ld.tgBatDau, ld.tgKetThuc\r\n"
					+ "from lichdat ld\r\n"
					+ "right join sanbong sb on ld.iD_SanBong = sb.iD_SanBong";
			// tạo biến PreparedStatement
			PreparedStatement pst = connection.prepareStatement(sql);
			// thực thi câu lệnh
				System.out.println("bạn vừa thực hiện câu lênh: " + sql + " thành công");
				ResultSet rs = pst.executeQuery();
				while (rs.next()){
					if(rs.getString("sb.TenSan").equals(ten_san)&&rs.getString("sb.iD_CoSo").equals(maCS)){
						if(rs.getString("ld.tgBatDau")==null && rs.getString("ld.tgKetThuc")==null && rs.getString("ld.NgayDa")==null) {
							return ma_san = rs.getString("sb.iD_SanBong") ;
						}
						else{
							if(rs.getString("ld.tgBatDau").equals(gio_da)&&rs.getString("ld.tgKetThuc").equals(gio_nghi)&&rs.getString("ld.NgayDa").equals(ngay_da)) {
								continue;
						    }else{
								return ma_san = rs.getString("sb.iD_SanBong") ;
							}
						} 
					}
				}
			// ngắt kết nối
			jdbc_until.closeConnection(connection);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}
		return ma_san;
	}
		
	public boolean check_gio_Da(String h_da, String h_nghi, String ngay_da, String tg_bd , String tg_kt , String lichdat){
		try {
			SimpleDateFormat spf =  new SimpleDateFormat("yyyy-MM-dd HH:mm");
			//thoi gian da trong ds
			Date gio_da = spf.parse( ngay_da +" "+ h_da);
			Date gio_nghi = spf.parse( ngay_da +" "+ h_nghi);
			//thoi gian đá chọn bạn đã chọn
			Date tg_batdau = spf.parse( lichdat +" "+ tg_bd);
			Date tg_ketthuc = spf.parse( lichdat +" "+ tg_kt);
			if(gio_da.before(tg_ketthuc) && gio_da.after(tg_batdau)||gio_nghi.before(tg_ketthuc) && gio_nghi.after(tg_batdau)||gio_da.before(tg_batdau) && gio_nghi.after(tg_ketthuc)){
				JOptionPane.showMessageDialog(null, "Ngày "+lichdat+" đã có sân từ "+tg_bd+"-"+tg_kt);
				return false;	
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	
	public void xoa_lich_qua_han() {
		try {
			// tạo kết nối
			Connection connection = jdbc_until.getConnection();
			// thêm câu lệnh
			String sql = "	Select * from lichdat ";
			// tạo biến statement
			PreparedStatement pst = connection.prepareStatement(sql);
			//pst.setInt(1, t.getMa_San());
			// thực thi câu lệnh
			ResultSet rs = pst.executeQuery(); 
			System.out.println("bạn vừa thực hiện câu lênh: " + sql);
			Date now = new Date();	
			SimpleDateFormat spf =  new SimpleDateFormat("yyyy-MM-dd HH:mm");
			//thoi gian da trong ds
			while (rs.next()) {
				dat_san dt = new dat_san();
				khach_hang kh = new khach_hang();
				try {
					Date gio_nghi = spf.parse( rs.getString("NgayDa") +" "+  rs.getString("tgKetThuc"));
					if(gio_nghi.before(now)) {
						delete(dt,"NgayDa = '"+ rs.getString("NgayDa") + "' and tgKetThuc ='"+rs.getString("tgKetThuc")+"'");
						KhachHangDAO.getInstance().delete(kh, rs.getString("ID_SDT_KH"));
					}
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
			// ngắt kết nối
			jdbc_until.closeConnection(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<dat_san> select_by_condition_2(String condition) {
		ArrayList<dat_san> list = new ArrayList<>();
		try {
			// tạo kết nối
			Connection connection = jdbc_until.getConnection();
			// thêm câu lệnh
			String sql ="SELECT *\r\n"
					+ "from lichdat ld\r\n"
					+ "right join khachhang kh on ld.ID_SDT_KH = kh.ID_SDT_KH\r\n"
					+ "where "+ condition;
			// tạo biến statement
			PreparedStatement pst = connection.prepareStatement(sql);
			//pst.setInt(1, t.getMa_San());
			// thực thi câu lệnh
			ResultSet rs = pst.executeQuery();
            
			System.out.println("bạn vừa thực hiện câu lênh: " + sql);

			while (rs.next()) {
				dat_san dt= new dat_san();
				dt.setMa_san(rs.getString("ld.iD_SanBong"));
				dt.setTen_san(rs.getString("ld.TenSan"));
				dt.setLoai_san(rs.getString("ld.LoaiSan"));
				dt.setNgay_Da(rs.getString("ld.NgayDa"));
				dt.setGio_bat_dau(rs.getString("ld.tgBatDau"));
				dt.setGio_ket_thuc(rs.getString("ld.tgKetThuc"));
				dt.setSdt(rs.getString("kh.ID_SDT_KH"));
				dt.setTen_kh(rs.getString("kh.HoTen"));
				list.add(dt);
			}
			// ngắt kết nối
			jdbc_until.closeConnection(connection);
             return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;	
	}
	
	
	
	
	public static dat_san_dao getInterface() {
		return new dat_san_dao();
	}
}
