package Main.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import com.mysql.cj.xdevapi.PreparableStatement;
import com.toedter.calendar.JCalendar;

import Main.database.*;
import Main.model.san_bong;

public class san_bong_dao implements Dao_interface<san_bong> {

	public static san_bong_dao getInterface() {
		return new san_bong_dao();
	}

	@Override
	public int insert(san_bong t) {
		int ketqua = 0;
		try {
			// tạo kết nối
			Connection connection = jdbc_until.getConnection();
			// thêm câu lệnh
			String sql = "insert into san_bong (ma_san, ten_san, loai_san, maCS ) values(?,?,?,?)";
			// tạo biến PreparedStatement
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMa_San());
			pst.setString(2, t.getTen_san());
			pst.setString(3, t.getLoai_san());
			pst.setString(4, t.getMa_cs());
			// thực thi câu lệnh
			
			ketqua = pst.executeUpdate();
			if (ketqua > 0) {
				System.out.println("bạn vừa thực hiện câu lênh: " + sql + " thành công");
			} else {
				System.out.println("thực hiện không thành công");
			}
			// ngắt kết nối
			JOptionPane.showMessageDialog(null, "Thêm sân bóng mới thành công!");
			jdbc_until.closeConnection(connection);

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}
		return ketqua;
	}

	@Override
	public int update(san_bong t,String condition) {
		int ketqua = 0;
		try {
			// tạo kết nối
			Connection connection = jdbc_until.getConnection();
			// thêm câu lệnh
			String sql = "update san_bong set ma_san=?, ten_san=?, loai_san=?, maCS=? where ma_san="+condition;
			// tạo biến PreparedStatement
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMa_San());
			pst.setString(2, t.getTen_san());
			pst.setString(3, t.getLoai_san());
			pst.setString(4, t.getMa_cs());
			// thực thi câu lệnh
			
			ketqua = pst.executeUpdate();
			if (ketqua > 0) {
				System.out.println("bạn vừa thực hiện câu lênh: " + sql + " thành công");
			} else {
				System.out.println("thực hiện không thành công");
			}
			// ngắt kết nối
			JOptionPane.showMessageDialog(null, "Lưu thay đổi thành công!");
			jdbc_until.closeConnection(connection);

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}
		return ketqua;
	}

	@Override
	public int delete(san_bong t,String condition) {
		int ketqua = 0;
		try {
			// tạo kết nối
			Connection connection = jdbc_until.getConnection();
			// thêm câu lệnh
			String sql = "Delete from san_bong where ma_san="+condition;
			// tạo biến PreparedStatement
				PreparedStatement pst = connection.prepareStatement(sql);
				pst.executeUpdate();
			// thực thi câu lệnh
			ketqua = pst.executeUpdate();
			if (ketqua > 0) {
				System.out.println("bạn vừa thực hiện câu lênh: " + sql + " thành công");
			} else {
				System.out.println("thực hiện không thành công");
			}
			// ngắt kết nối
			JOptionPane.showMessageDialog(null, "Xoá sân bóng thành công!");
			jdbc_until.closeConnection(connection);

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}
		return ketqua;
	}

	@Override
	public ArrayList<san_bong> selectALL() {
		ArrayList<san_bong> list = new ArrayList<>();

		try {
			// tạo kết nối
			Connection connection = jdbc_until.getConnection();
			// tạo biến statement
			String sql = "	Select * from san_bong ";
			PreparedStatement pst = connection.prepareStatement(sql);
			// thêm câu lệnh
			// thực thi câu lệnh
			ResultSet rs = pst.executeQuery();

			System.out.println("bạn vừa thực hiện câu lênh: " + sql);

			while (rs.next()) {
				san_bong sb = new san_bong();
				sb.setMa_cs(rs.getString("maCS"));
				sb.setMa_San(rs.getString("ma_san"));
				sb.setTen_san(rs.getString("ten_san"));
				sb.setLoai_san(rs.getString("loai_san"));
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
			String sql = " Select * from san_bong where maCS = ?;";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMa_San());
			// thêm câu lệnh
			System.out.println("bạn vừa thực hiện câu lênh: " + sql);
			// thực thi câu lệnh
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				sb = new san_bong();
				sb.setMa_cs(rs.getString("maCS"));
				sb.setMa_San(rs.getString("ma_san"),rs.getString("maCS"));
				sb.setTen_san(rs.getString("ten_san"));
				sb.setLoai_san(rs.getString("loai_san"));
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
			
			// thêm câu lệnh
			String sql = "	Select * from san_bong where " + condition;
			// tạo biến statement
			PreparedStatement pst = connection.prepareStatement(sql);
			//pst.setInt(1, t.getMa_San());
			
			// thực thi câu lệnh
			ResultSet rs = pst.executeQuery();

			System.out.println("bạn vừa thực hiện câu lênh: " + sql);

			while (rs.next()) {
				san_bong sb = new san_bong();
				sb.setMa_San(rs.getString("ma_san"));
				sb.setTen_san(rs.getString("ten_san"));
				sb.setLoai_san(rs.getString("loai_san"));
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
