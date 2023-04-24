package Co_so_view;

import javax.swing.JPanel;
import javax.swing.Box;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

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
import com.toedter.calendar.JDateChooser;

import Main.dao.san_bong_dao;
import Main.model.san_bong;

import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Co_so1_san7_view extends JPanel {
	
	
	//______________
	private JTextField txt_ten_kh;
	private JTextField txt_sdt_kh;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	//__________
	private JDateChooser ngay_da;
	//________
	private DefaultTableModel model;
	private JTable table;
	private ArrayList<san_bong> list;
	/**
	 * Create the panel.
	 */
	public Co_so1_san7_view() {
		setBackground(new Color(128, 128, 128));
			setBounds(0,0,742,562);
			setLayout(null);
		  //// ________________________________________
			JPanel panel_2 = new JPanel();
			panel_2.setLayout(null);
			panel_2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
			panel_2.setBounds(0, 0, 742, 35);
			add(panel_2);
			
			JLabel lblNewLabel_3 = new JLabel(" Danh sách sân bóng 7 người cơ sở 1");
			lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblNewLabel_3.setBounds(10, 0, 355, 34);
			panel_2.add(lblNewLabel_3);
            
			list = san_bong_dao.getInterface().select_by_condition("maCS = 1 and loai_san = 7");
			
			table = new JTable();
			table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
				}
			));
			table.setFont(new Font("Tahoma", Font.PLAIN, 12));
			JScrollPane scrollPane = new JScrollPane(table);
			scrollPane.setBounds(0, 35, 742, 194);
			add(scrollPane);
			
			 model = (DefaultTableModel) table.getModel();
			 model.setColumnIdentifiers(new Object[] {
						"STT", "Tên sân", "Ngày đá", "Thời gian", "Trạng thái"	 
			});
			 showTable();
			  //// ________________________________________
			 
			JPanel panel = new JPanel();
			panel.setLayout(null);
			panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
			panel.setBackground(Color.WHITE);
			panel.setBounds(0, 228, 742, 334);
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
			panel_1.setBounds(0, 0, 742, 35);
			panel.add(panel_1);
			
			JLabel lblNewLabel = new JLabel(" Thông tin đặt sân");
			lblNewLabel.setForeground(Color.BLACK);
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblNewLabel.setBackground(Color.LIGHT_GRAY);
			lblNewLabel.setBounds(1, 1, 299, 35);
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
			Image icon_add_kh = new ImageIcon(this.getClass().getResource("/add khach hang.png")).getImage();
			lblNewLabel_2.setIcon(new ImageIcon(icon_add_kh));
			lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
			
			JLabel lb_ngay_tra = new JLabel("Ngày đá:");
			lb_ngay_tra.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lb_ngay_tra.setBounds(20, 131, 79, 27);
			panel.add(lb_ngay_tra);
			
			//_________ngày đá________________
			ngay_da = new JDateChooser();
			ngay_da.setBounds(110, 131, 157, 27);
			panel.add(ngay_da);
			
			
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
			bt_dat_san.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
				}
			});
			bt_dat_san.setFont(new Font("Tahoma", Font.PLAIN, 16));
			bt_dat_san.setBounds(470, 233, 97, 46);
			panel.add(bt_dat_san);
			
			JButton bt_huy_san = new JButton("Huỷ sân");
			bt_huy_san.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
				}
			});
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
			bt_dat_san_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			bt_dat_san_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
			bt_dat_san_1.setBounds(346, 233, 107, 46);
			panel.add(bt_dat_san_1);
	}
	int i = 1;
	public void showTable() {
		for(san_bong sb : list) {
			model.addRow(new Object[] {
					i++, 
					sb.getTen_san(), 
					sb.getNgay_da(),
					sb.getThoi_gian_da(),
					sb.getTrang_thai_san()	
				});
		}
		
	}
	
}
