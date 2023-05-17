package Main.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Main.database.jdbc_until;
import Main.model.Co_so;
import Main.model.san_bong;

public class Co_so_dao implements Dao_interface<Co_so>{

	public static Co_so_dao getInterface() {
		return new Co_so_dao();
	}
	
	@Override
	public int insert(Co_so t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Co_so t, String condition) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Co_so t, String condition) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Co_so> selectALL() {
		ArrayList<Co_so> list = new ArrayList<>();
		try {
			// tạo kết nối
			Connection connection = jdbc_until.getConnection();
			// tạo biến statement
			String sql = "	Select * from coso ";
			PreparedStatement pst = connection.prepareStatement(sql);
			// thêm câu lệnh
			// thực thi câu lệnh
			ResultSet rs = pst.executeQuery();
			System.out.println("bạn vừa thực hiện câu lênh: " + sql);
			while (rs.next()) {
				Co_so cs= new Co_so();
				cs.setID_CoSo(rs.getString("iD_CoSo"));
				cs.setTenCS(rs.getString("TenCoSo"));
				cs.setDia_chi(rs.getString("DiaChi"));
				list.add(cs);
			}
			// ngắt kết nối
			jdbc_until.closeConnection(connection);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Co_so Selectby_id(Co_so t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Co_so> select_by_condition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

}
