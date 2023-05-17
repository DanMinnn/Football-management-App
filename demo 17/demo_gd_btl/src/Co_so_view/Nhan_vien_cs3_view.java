package Co_so_view;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.border.MatteBorder;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Main.dao.NhanVienDAO;
import Main.model.NhanVien;

public class Nhan_vien_cs3_view extends JPanel {
	private JTable table;
	private ArrayList<NhanVien> nv ;
	/**
	 * Create the panel.
	 */
	public Nhan_vien_cs3_view() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(new Color(255, 255, 255));
		setBounds(0,0,746,562);
		setLayout(null);
		
		nv = new ArrayList<>();
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 128, 0));
		panel.setLayout(null);
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel.setBounds(0, 0, 746, 34);
		add(panel);
		
		JLabel lblDanhSchNhn = new JLabel("Danh sách nhân viên");
		lblDanhSchNhn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDanhSchNhn.setBounds(10, 0, 207, 34);
		panel.add(lblDanhSchNhn);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setColumnIdentifiers(new Object[] { "STT", "Mã Nhân viên", "Tên Nhân viên","Giới tính"});
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 34, 746, 528);
		add(scrollPane);
	
	}
	public void showTable() {
		nv = NhanVienDAO.getInstance().select_by_condition("iD_CoSo = 2");
		int i = 1;
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		for (NhanVien ds : nv) {
			model.addRow(new Object[] { i++, ds.getID(),ds.getHoTen(),ds.getGioiTinh()});
		}
	}

}
