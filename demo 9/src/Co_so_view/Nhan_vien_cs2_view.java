package Co_so_view;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.MatteBorder;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Nhan_vien_cs2_view extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public Nhan_vien_cs2_view() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(new Color(255, 255, 255));
		setBounds(0,0,746,562);
		setLayout(null);
		
		JPanel panel = new JPanel();
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
				"STT", "MaNV", "TenNV", "GioiTinh", "ChucVu"
			}
		));
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 34, 746, 528);
		add(scrollPane);
		
		
		
	}

}
