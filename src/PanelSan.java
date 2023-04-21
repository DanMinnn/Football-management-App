import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.MatteBorder;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import javax.swing.DebugGraphics;
import javax.swing.DropMode;
import java.awt.Component;
import javax.swing.ScrollPaneConstants;

public class PanelSan extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField coso;
	private JTextField loaisan;
	
	DefaultTableModel model;
	private JTable table;
	
	/**
	 * Create the panel.
	 */
	public PanelSan() {
		setBounds(0,0, 1118, 605);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(248, 248, 255));
		panel.setBounds(0, 0, 1118, 605);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("C\u01A1 s\u1EDF:");
		lblNewLabel.setBounds(77, 37, 155, 29);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(lblNewLabel);
		
		JLabel lblLoiSn = new JLabel("Lo\u1EA1i s\u00E2n:");
		lblLoiSn.setBounds(77, 81, 155, 29);
		lblLoiSn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(lblLoiSn);
		
		coso = new JTextField();
		coso.setBounds(176, 37, 277, 29);
		panel.add(coso);
		coso.setColumns(10);
		
		loaisan = new JTextField();
		loaisan.setBounds(176, 81, 277, 29);
		loaisan.setColumns(10);
		panel.add(loaisan);
		
		JButton btnNewButton = new JButton("Th\u00EAm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(coso.getText().equals("") || loaisan.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Hãy nhập đầy đủ thông tin");
				}
				else
				{
					DefaultTableModel model = (DefaultTableModel)table.getModel();
					model.addRow(new Object [] {(coso.getText()),(loaisan.getText())});
					
					coso.setText("");
					loaisan.setText("");
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
					model.setValueAt(coso.getText(), i, 0);
					model.setValueAt(loaisan.getText(), i, 1);
					JOptionPane.showMessageDialog(null, "Đã sửa");
				}
				else {
					JOptionPane.showMessageDialog(null, "Chọn sân cần sửa");
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
					coso.setText("");
					loaisan.setText("");
				}
				else {
					JOptionPane.showMessageDialog(null, "Chọn sân cần xóa");
				}
			}
		});
		btnXa.setBounds(482, 141, 142, 29);
		panel.add(btnXa);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 182, 1118, 423);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		table.setBackground(new Color(255, 255, 255));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i=table.getSelectedRow();
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				coso.setText(model.getValueAt(i, 0).toString());
				loaisan.setText(model.getValueAt(i, 1).toString());
			}
		});
		table.setForeground(new Color(0, 0, 0));
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));

		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u01A1 s\u1EDF", "Lo\u1EA1i s\u00E2n"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		JTableHeader Theader = table.getTableHeader();
		Theader.setBackground(Color.ORANGE);
		Theader.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		
		
		scrollPane.setViewportView(table);
		setVisible(true);
	}
}
