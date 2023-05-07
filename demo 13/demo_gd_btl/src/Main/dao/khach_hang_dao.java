package Main.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Main.database.jdbc_until;
import Main.model.khach_hang;

public class khach_hang_dao implements Dao_interface<khach_hang>{
	@Override
	public int insert(khach_hang t) {
		int ketqua = 0;
		try {
			// tạo kết nối
			Connection connection = jdbc_until.getConnection();
			// thêm câu lệnh
			String sql = "insert into khach_hang (ten_khach_hang, sdt ) values(?,?)";
			// tạo biến PreparedStatement
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getTen());
			pst.setString(2, t.getSo_dien_thoai());
			
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
	public int delete(khach_hang t,String condition) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<khach_hang> selectALL() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public khach_hang Selectby_id(khach_hang t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<khach_hang> select_by_condition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

}
