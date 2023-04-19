package Co_so_view;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTable;
import javax.swing.JSeparator;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import javax.swing.JTextField;
import javax.swing.ImageIcon;

public class Co_so1_san5_view extends JPanel {
	private JTable table_san_bong;
	private JTextField textField;
	private JTextField textField_1; 
	/**
	 * Create the panel.
	 */
	public Co_so1_san5_view() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(new Color(255, 255, 255));
		setBounds(0,0,710,503);
		setLayout(null);
		
		
		table_san_bong = new JTable();
		table_san_bong.setFont(new Font("Tahoma", Font.PLAIN, 20));
		table_san_bong.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"STT", "T\u00EAn s\u00E2n", "Ng\u00E0y \u0111\u00E1", "Th\u1EDDi gian", "Tr\u1EA1ng th\u00E1i", ""
			}
		));
		
		
		JScrollPane scrollPane = new JScrollPane(table_san_bong);
		scrollPane.setBounds(0, 171, 710, 332);
		add(scrollPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel.setBounds(0, 138, 710, 34);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Dánh sách sân bóng");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 0, 185, 34);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 0, 710, 140);
		add(panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("Tên khách hàng:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(22, 48, 115, 27);
		panel_1.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setColumns(10);
		textField.setBounds(157, 50, 258, 27);
		panel_1.add(textField);
		
		JLabel lblNewLabel_1_1 = new JLabel("SĐT khách hàng:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(22, 85, 125, 27);
		panel_1.add(lblNewLabel_1_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_1.setColumns(10);
		textField_1.setBounds(157, 87, 258, 27);
		panel_1.add(textField_1);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_1_1.setBounds(0, 0, 710, 32);
		panel_1.add(panel_1_1);
		
		JLabel lblNewLabel_2 = new JLabel(" Thông tin khách hàng đặt");
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_2.setBounds(0, 0, 711, 32);
		panel_1_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Thêm mới khách hàng");
		Image icon_add_kh = new ImageIcon(this.getClass().getResource("/add khach hang.png")).getImage();
		lblNewLabel_2_1.setIcon(new ImageIcon(icon_add_kh));
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1.setBounds(471, 61, 200, 47);
		panel_1.add(lblNewLabel_2_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBounds(462, 61, 209, 47);
		panel_1.add(panel_3);
		
		
		 
	}
}
