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
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JScrollBar;
import javax.swing.JSlider;
import java.awt.List;
import java.awt.Choice;
import com.jgoodies.forms.factories.DefaultComponentFactory;

import Main.model.san_bong;

import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Co_so1_san7_view extends JPanel {
	private JTable table;
	private JTextField txt_ten_kh;
	private JTextField txt_sdt_kh;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	private ArrayList<san_bong> list;
	/**
	 * Create the panel.
	 */
	public Co_so1_san7_view() {
		setBackground(new Color(128, 128, 128));
			setBounds(0,0,710,503);
			setLayout(null);
			
			table = new JTable();
			table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"STT", "T\u00EAn s\u00E2n", "Ng\u00E0y \u0111\u00E1", "Th\u1EDDi gian", "Tr\u1EA1ng th\u00E1i"
				}
			));
			JScrollPane scrollPane = new JScrollPane(table);
			scrollPane.setBounds(0, 35, 710, 164);
			add(scrollPane);
			
		
			
			
			JPanel panel_2 = new JPanel();
			panel_2.setLayout(null);
			panel_2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
			panel_2.setBounds(0, 0, 710, 35);
			add(panel_2);
			
			JLabel lblNewLabel_3 = new JLabel("Dánh sách sân bóng");
			lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblNewLabel_3.setBounds(10, 0, 185, 34);
			panel_2.add(lblNewLabel_3);
			
			JPanel panel = new JPanel();
			panel.setLayout(null);
			panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
			panel.setBackground(Color.WHITE);
			panel.setBounds(0, 198, 710, 305);
			add(panel);
			
			JLabel lb_ten_khach_hang = new JLabel("Tên khách hàng:");
			lb_ten_khach_hang.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lb_ten_khach_hang.setBounds(20, 48, 115, 27);
			panel.add(lb_ten_khach_hang);
			
			txt_ten_kh = new JTextField();
			txt_ten_kh.setFont(new Font("Tahoma", Font.PLAIN, 15));
			txt_ten_kh.setColumns(10);
			txt_ten_kh.setBounds(150, 50, 258, 27);
			panel.add(txt_ten_kh);
			
			JLabel lb_sdt = new JLabel("SĐT khách hàng:");
			lb_sdt.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lb_sdt.setBounds(20, 85, 125, 27);
			panel.add(lb_sdt);
			
			txt_sdt_kh = new JTextField();
			txt_sdt_kh.setFont(new Font("Tahoma", Font.PLAIN, 15));
			txt_sdt_kh.setColumns(10);
			txt_sdt_kh.setBounds(150, 87, 258, 27);
			panel.add(txt_sdt_kh);
			
			JPanel panel_1 = new JPanel();
			panel_1.setLayout(null);
			panel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
			panel_1.setBounds(0, 0, 710, 35);
			panel.add(panel_1);
			
			JLabel lblNewLabel = new JLabel(" Thông tin khách hàng đặt");
			lblNewLabel.setForeground(Color.BLACK);
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblNewLabel.setBackground(Color.LIGHT_GRAY);
			lblNewLabel.setBounds(1, 1, 711, 35);
			panel_1.add(lblNewLabel);
			
			JPanel panel_add_khach_hang = new JPanel();
			panel_add_khach_hang.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
				}
			});
			panel_add_khach_hang.setLayout(null);
			panel_add_khach_hang.setBounds(462, 48, 209, 57);
			panel.add(panel_add_khach_hang);
			
			JLabel lblNewLabel_2 = new JLabel("Thêm mới khách hàng");
			lblNewLabel_2.setBounds(10, 5, 192, 47);
			panel_add_khach_hang.add(lblNewLabel_2);
			lblNewLabel_2.setIcon(new ImageIcon("D:\\JAVA\\icon\\Custom-Icon-Design-Pretty-Office-3-Add-Male-User.32.png"));
			lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
			
			JLabel lb_ngay_nhan = new JLabel("Ngày nhận:");
			lb_ngay_nhan.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lb_ngay_nhan.setBounds(20, 131, 82, 27);
			panel.add(lb_ngay_nhan);
			
			JLabel lb_ngay_tra = new JLabel("Ngày trả:");
			lb_ngay_tra.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lb_ngay_tra.setBounds(312, 131, 79, 27);
			panel.add(lb_ngay_tra);
			
			textField_2 = new JTextField();
			textField_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
			textField_2.setColumns(10);
			textField_2.setBounds(110, 132, 157, 27);
			panel.add(textField_2);
			
			textField_3 = new JTextField();
			textField_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
			textField_3.setColumns(10);
			textField_3.setBounds(393, 131, 157, 27);
			panel.add(textField_3);
			
			JLabel lb_TG_bat_dau = new JLabel("Bắt đầu:");
			lb_TG_bat_dau.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lb_TG_bat_dau.setBounds(20, 180, 79, 27);
			panel.add(lb_TG_bat_dau);
			
			textField_4 = new JTextField();
			textField_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
			textField_4.setColumns(10);
			textField_4.setBounds(110, 180, 157, 27);
			panel.add(textField_4);
			
			JLabel lb_TG_ket_thua = new JLabel("kết thúc:");
			lb_TG_ket_thua.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lb_TG_ket_thua.setBounds(312, 180, 79, 27);
			panel.add(lb_TG_ket_thua);
			
			textField_5 = new JTextField();
			textField_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
			textField_5.setColumns(10);
			textField_5.setBounds(393, 180, 157, 27);
			panel.add(textField_5);
			
			JButton bt_dat_san = new JButton("Đặt sân");
			bt_dat_san.setFont(new Font("Tahoma", Font.PLAIN, 16));
			bt_dat_san.setBounds(470, 233, 97, 46);
			panel.add(bt_dat_san);
			
			JButton bt_huy_san = new JButton("Huỷ sân");
			bt_huy_san.setFont(new Font("Tahoma", Font.PLAIN, 16));
			bt_huy_san.setBounds(584, 233, 97, 46);
			panel.add(bt_huy_san);
			
			JLabel lb_gia_tien = new JLabel("Giá sân:");
			lb_gia_tien.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lb_gia_tien.setBounds(20, 233, 79, 27);
			panel.add(lb_gia_tien);
			
			JLabel lblNewLabel_4 = new JLabel("");
			lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblNewLabel_4.setBounds(110, 233, 157, 27);
			panel.add(lblNewLabel_4);
			
			JButton bt_dat_san_1 = new JButton("Tìm kiếm");
			bt_dat_san_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
			bt_dat_san_1.setBounds(346, 233, 107, 46);
			panel.add(bt_dat_san_1);
	}
}
