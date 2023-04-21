import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelStaff extends JPanel {
	
	DefaultTableModel model;
	private JTable table;
	private JTextField luong;
	private JTextField sodienthoai;
	private JTextField hoten;
	
	/**
	 * Create the panel.
	 */
	public PanelStaff() {
		setBounds(0,0, 1118, 605);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(248, 248, 255));
		panel.setBounds(0, 0, 1118, 605);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Họ tên:");
		lblNewLabel.setBounds(77, 10, 155, 29);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(lblNewLabel);
		
		JLabel lblLoiSn = new JLabel("Số điện thoại:");
		lblLoiSn.setBounds(77, 49, 155, 29);
		lblLoiSn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(lblLoiSn);
		
		JButton btnNewButton = new JButton("Th\u00EAm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(hoten.getText().equals("") || sodienthoai.getText().equals("") || sodienthoai.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Hãy nhập đầy đủ thông tin");
				}
				else
				{
					DefaultTableModel model = (DefaultTableModel)table.getModel();
					model.addRow(new Object [] {(hoten.getText()),Integer.parseInt(sodienthoai.getText()),Integer.parseInt(luong.getText())});
					hoten.setText("");
					sodienthoai.setText("");
					luong.setText("");
					JOptionPane.showMessageDialog(null, "Đã thêm");
				}
			}
		});
		btnNewButton.setBounds(59, 141, 142, 29);
		panel.add(btnNewButton);
		
		JButton btnSa = new JButton("S\u1EEDa");
		btnSa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				if(i>=0) {
					DefaultTableModel model = (DefaultTableModel)table.getModel();
					model.setValueAt(hoten.getText(), i, 0);
					model.setValueAt(sodienthoai.getText(), i, 1);
					model.setValueAt(luong.getText(), i, 2);
					JOptionPane.showMessageDialog(null, "Đã sửa");
				}
				else {
					JOptionPane.showMessageDialog(null, "Chọn nhân viên cần sửa");
				}
			}
		});
		btnSa.setBounds(272, 141, 142, 29);
		panel.add(btnSa);
		
		JButton btnXa = new JButton("X\u00F3a");
		btnXa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i=table.getSelectedRow();
				if(i>=0) {
					DefaultTableModel model = (DefaultTableModel)table.getModel();
					model.removeRow(i);
					JOptionPane.showMessageDialog(null, "Đã xóa");
					hoten.setText("");
					sodienthoai.setText("");
					luong.setText("");
				}
				else {
					JOptionPane.showMessageDialog(null, "Chọn nhân viên cần xóa");
				}
			}
		});
		btnXa.setBounds(482, 141, 142, 29);
		panel.add(btnXa);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 182, 1118, 423);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(255, 255, 255));
		

		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i=table.getSelectedRow();
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				hoten.setText(model.getValueAt(i, 0).toString());
				sodienthoai.setText(model.getValueAt(i, 1).toString());
				luong.setText(model.getValueAt(i, 2).toString());
			}
		});
		table.setForeground(new Color(0, 0, 0));
		table.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"H\u1ECD t\u00EAn", "S\u1ED1 \u0111i\u1EC7n tho\u1EA1i", "L\u01B0\u01A1ng"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Integer.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(266);
		table.getColumnModel().getColumn(1).setPreferredWidth(125);
		table.getColumnModel().getColumn(2).setPreferredWidth(136);
		
		
		scrollPane.setViewportView(table);
		
		JLabel lblLng = new JLabel("Lương:");
		lblLng.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLng.setBounds(77, 88, 155, 29);
		panel.add(lblLng);
		
		luong = new JTextField();
		luong.setColumns(10);
		luong.setBounds(210, 88, 277, 31);
		panel.add(luong);
		
		sodienthoai = new JTextField();
		sodienthoai.setColumns(10);
		sodienthoai.setBounds(210, 49, 277, 31);
		panel.add(sodienthoai);
		
		hoten = new JTextField();
		hoten.setColumns(10);
		hoten.setBounds(210, 10, 277, 31);
		panel.add(hoten);
		setVisible(true);
	}
}

