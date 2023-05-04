package Co_so_view;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import Main.dao.san_bong_dao;
import Main.model.san_bong;

import javax.swing.JButton;
import java.awt.SystemColor;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;
import javax.swing.JSpinner;

public class Coso1_san5_view extends JPanel {
	//
	private JTextField txt_ten_kh;
	private JTextField txt_sdt_kh;
	//
	private JSpinner txt_h_da;
	//
	private DefaultTableModel model;
	private JTable table;
	
	private ArrayList<san_bong> list;

	/**
	 * Create the panel.
	 */
	public Coso1_san5_view() {
		setBackground(new Color(128, 128, 128));
		setBounds(0, 0, 746, 526);
		setLayout(null);
		
		JPanel panel_ds = new JPanel();
		panel_ds.setBounds(0, 0, 746, 205);
		add(panel_ds);
		panel_ds.setLayout(null);
		
		JPanel panel_t1 = new JPanel();
		panel_t1.setLayout(null);
		panel_t1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_t1.setBackground(new Color(0, 206, 0));
		panel_t1.setBounds(0, 0, 746, 35);
		panel_ds.add(panel_t1);
		
		JLabel lb_ds_san_bong = new JLabel(" Danh sách sân bóng 5 người cơ sở 1");
		lb_ds_san_bong.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lb_ds_san_bong.setBounds(0, 0, 350, 34);
		panel_t1.add(lb_ds_san_bong);
		
		
		list = san_bong_dao.getInterface().select_by_condition("ma_san=1 and loai_san = 5");
		
		table = new JTable();
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 35, 746, 170);
		panel_ds.add(scrollPane);
			
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] {}));
	
		model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		model.setColumnIdentifiers(new Object[] { "STT","Tên sân", "Loại sân", "Thời gian", "Trạng thái" });
		
		showTable();
		JPanel panel_thongtin_san = new JPanel();
		panel_thongtin_san.setBounds(0, 205, 746, 320);
		add(panel_thongtin_san);
		panel_thongtin_san.setLayout(null);
		
		JPanel panel_t2 = new JPanel();
		panel_t2.setLayout(null);
		panel_t2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_t2.setBackground(new Color(0, 189, 0));
		panel_t2.setBounds(0, 0, 746, 35);
		panel_thongtin_san.add(panel_t2);
		
		JLabel lb_thongtin = new JLabel(" Thông tin đặt sân");
		lb_thongtin.setForeground(Color.BLACK);
		lb_thongtin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lb_thongtin.setBackground(Color.LIGHT_GRAY);
		lb_thongtin.setBounds(0, 0, 299, 35);
		panel_t2.add(lb_thongtin);
		
		JLabel lb_ten_khach_hang = new JLabel("Tên khách hàng:");
		lb_ten_khach_hang.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lb_ten_khach_hang.setBounds(21, 57, 115, 27);
		panel_thongtin_san.add(lb_ten_khach_hang);
		
		JLabel lb_sdt = new JLabel("SĐT khách hàng:");
		lb_sdt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lb_sdt.setBounds(21, 94, 120, 27);
		panel_thongtin_san.add(lb_sdt);
		
		txt_ten_kh = new JTextField();
		txt_ten_kh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt_ten_kh.setColumns(10);
		txt_ten_kh.setBounds(151, 59, 258, 27);
		panel_thongtin_san.add(txt_ten_kh);
		
		txt_sdt_kh = new JTextField();
		txt_sdt_kh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt_sdt_kh.setColumns(10);
		txt_sdt_kh.setBounds(151, 96, 258, 27);
		panel_thongtin_san.add(txt_sdt_kh);
		
		JPanel panel_add_khach_hang = new JPanel();
		panel_add_khach_hang.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_add_khach_hang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_add_khach_hang.setBackground(new Color(190, 190, 190));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_add_khach_hang.setBackground(new Color(240, 240, 240));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				panel_add_khach_hang.setBackground(new Color(112, 128, 144));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				panel_add_khach_hang.setBackground(new Color(112, 128, 144));
			}
		});
		panel_add_khach_hang.setLayout(null);
		panel_add_khach_hang.setBounds(462, 64, 209, 57);
		panel_thongtin_san.add(panel_add_khach_hang);
		
		Image icon_add_kh = new ImageIcon(this.getClass().getResource("/add khach hang.png")).getImage();
		
		JLabel lb_add_kh = new JLabel("Thêm mới khách hàng");
		lb_add_kh.setIcon(new ImageIcon(icon_add_kh));
		lb_add_kh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lb_add_kh.setBounds(10, 5, 192, 47);
		panel_add_khach_hang.add(lb_add_kh);
		
		JLabel lb_ngay_tra = new JLabel("Ngày đá:");
		lb_ngay_tra.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lb_ngay_tra.setBounds(21, 138, 79, 27);
		panel_thongtin_san.add(lb_ngay_tra);
		
		JDateChooser ngay_da = new JDateChooser();
		ngay_da.setBounds(110, 138, 168, 27);
		panel_thongtin_san.add(ngay_da);
		
		JButton bt_tim_san_trong = new JButton("Danh sách sân trống");
		bt_tim_san_trong.setFont(new Font("Tahoma", Font.PLAIN, 16));
		bt_tim_san_trong.setBounds(288, 133, 191, 35);
		panel_thongtin_san.add(bt_tim_san_trong);
		
		JLabel lb_TG_bat_dau = new JLabel("Bắt đầu:");
		lb_TG_bat_dau.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lb_TG_bat_dau.setBounds(21, 183, 79, 27);
		panel_thongtin_san.add(lb_TG_bat_dau);
		
		JLabel lb_TG_ket_thuc = new JLabel("kết thúc:");
		lb_TG_ket_thuc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lb_TG_ket_thuc.setBounds(21, 213, 79, 27);
		panel_thongtin_san.add(lb_TG_ket_thuc);
		
		JButton bt_tim_san = new JButton("Tìm sân");
		bt_tim_san.setFont(new Font("Tahoma", Font.PLAIN, 16));
		bt_tim_san.setBackground(SystemColor.menu);
		bt_tim_san.setBounds(399, 263, 106, 46);
		panel_thongtin_san.add(bt_tim_san);
		
		JButton bt_dat_san = new JButton("Đặt sân");
		bt_dat_san.setFont(new Font("Tahoma", Font.PLAIN, 16));
		bt_dat_san.setBackground(SystemColor.menu);
		bt_dat_san.setBounds(515, 263, 97, 46);
		panel_thongtin_san.add(bt_dat_san);
		
		JButton bt_huy_san = new JButton("Huỷ sân");
		bt_huy_san.setFont(new Font("Tahoma", Font.PLAIN, 16));
		bt_huy_san.setBackground(SystemColor.menu);
		bt_huy_san.setBounds(622, 263, 97, 46);
		panel_thongtin_san.add(bt_huy_san);
		
		
		 txt_h_da = new JSpinner();
		txt_h_da.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txt_h_da.setBounds(110, 175, 115, 27);
		panel_thongtin_san.add(txt_h_da);
	}
	
	public void showTable() {
		int i = 1;
		for (san_bong sb : list) {
			model.addRow(new Object[] { i++,sb.getTen_san(), sb.getNgay_da(),
					sb.getThoi_gian_da(), sb.getTrang_thai_san() });
	    }
	}
	
}
