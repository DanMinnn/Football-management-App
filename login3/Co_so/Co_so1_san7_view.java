package Co_so;

import javax.swing.JPanel;
import javax.swing.Box;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JCheckBox;
import javax.swing.JTextPane;
import javax.swing.JScrollBar;
import javax.swing.JSlider;
import java.awt.List;
import java.awt.Choice;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Co_so1_san7_view extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public Co_so1_san7_view() {
		setBackground(new Color(128, 128, 128));
			setBounds(0,0,710,503);
			setLayout(null);
			
			JPanel panel = new JPanel();
			panel.setBackground(new Color(255, 255, 255));
			panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
			panel.setBounds(0, 0, 710, 140);
			add(panel);
			panel.setLayout(null);
			
			JLabel lblNewLabel_1 = new JLabel("Tên khách hàng:");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblNewLabel_1.setBounds(22, 48, 115, 27);
			panel.add(lblNewLabel_1);
			
			textField = new JTextField();
			textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
			textField.setBounds(157, 50, 258, 27);
			panel.add(textField);
			textField.setColumns(10);
			
			JLabel lblNewLabel_1_1 = new JLabel("SĐT khách hàng:");
			lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblNewLabel_1_1.setBounds(22, 85, 125, 27);
			panel.add(lblNewLabel_1_1);
			
			textField_1 = new JTextField();
			textField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
			textField_1.setColumns(10);
			textField_1.setBounds(157, 87, 258, 27);
			panel.add(textField_1);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
			panel_1.setBounds(0, 0, 710, 32);
			panel.add(panel_1);
			panel_1.setLayout(null);
			
			JLabel lblNewLabel = new JLabel(" Thông tin khách hàng đặt");
			lblNewLabel.setForeground(Color.BLACK);
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblNewLabel.setBackground(Color.LIGHT_GRAY);
			lblNewLabel.setBounds(0, 0, 711, 32);
			panel_1.add(lblNewLabel);
			
			JLabel lblNewLabel_2 = new JLabel("Thêm mới khách hàng");
			lblNewLabel_2.setBounds(471, 61, 200, 47);
			panel.add(lblNewLabel_2);
			lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblNewLabel_2.setIcon(new ImageIcon("D:\\JAVA\\icon\\Custom-Icon-Design-Pretty-Office-3-Add-Male-User.32.png"));
			
			JPanel panel_3 = new JPanel();
			panel_3.setBounds(462, 61, 209, 47);
			panel.add(panel_3);
			panel_3.setLayout(null);
			
			table = new JTable();
			table.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
				},
				new String[] {
					"STT", "T\u00EAn s\u00E2n", "Ng\u00E0y \u0111\u00E1", "Th\u1EDDi gian", "Tr\u1EA1ng th\u00E1i", ""
				}
			));
			JScrollPane scrollPane = new JScrollPane(table);
			scrollPane.setBounds(0, 171, 710, 332);
			add(scrollPane);
			
		
			
			
			JPanel panel_2 = new JPanel();
			panel_2.setLayout(null);
			panel_2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
			panel_2.setBounds(0, 138, 710, 34);
			add(panel_2);
			
			JLabel lblNewLabel_3 = new JLabel("Dánh sách sân bóng");
			lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblNewLabel_3.setBounds(10, 0, 185, 34);
			panel_2.add(lblNewLabel_3);
	}
}
