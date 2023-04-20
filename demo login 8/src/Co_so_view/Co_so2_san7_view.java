package Co_so_view;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.JTextField;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Co_so2_san7_view extends JPanel {
	private JTextField txt_ten_kh;
	private JTextField txt_sdt_kh;
	private JTextField txt_ngay_nhan;
	private JTextField txt_ngay_tra;
	private JTextField txt_h_batdau;
	private JTextField txt_h_ketthuc;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public Co_so2_san7_view() {
		setBackground(new Color(128, 128, 128));
		setBounds(0,0,710,503);
		setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_2.setBounds(0, 0, 710, 35);
		add(panel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Dánh sách sân bóng");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(10, 0, 185, 34);
		panel_2.add(lblNewLabel_3);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "TÊN SÂN", "NGÀY ĐÁ", "THỜI GIAN", "TRẠNG THÁI"
			}
		));
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 35, 710, 164);
		add(scrollPane);
		
		
		
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
		
		JPanel panel_add_khach_hang = new JPanel();
		panel_add_khach_hang.setLayout(null);
		panel_add_khach_hang.setBounds(462, 48, 209, 57);
		panel.add(panel_add_khach_hang);
		
		JLabel lblNewLabel_2 = new JLabel("Thêm mới khách hàng");
		Image icon_add_kh = new ImageIcon(this.getClass().getResource("/add khach hang.png")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(icon_add_kh));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(10, 5, 192, 47);
		panel_add_khach_hang.add(lblNewLabel_2);
		
		JLabel lb_ngay_nhan = new JLabel("Ngày nhận:");
		lb_ngay_nhan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lb_ngay_nhan.setBounds(20, 131, 82, 27);
		panel.add(lb_ngay_nhan);
		
		JLabel lb_ngay_tra = new JLabel("Ngày trả:");
		lb_ngay_tra.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lb_ngay_tra.setBounds(312, 131, 79, 27);
		panel.add(lb_ngay_tra);
		
		txt_ngay_nhan = new JTextField();
		txt_ngay_nhan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt_ngay_nhan.setColumns(10);
		txt_ngay_nhan.setBounds(110, 132, 157, 27);
		panel.add(txt_ngay_nhan);
		
		txt_ngay_tra = new JTextField();
		txt_ngay_tra.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt_ngay_tra.setColumns(10);
		txt_ngay_tra.setBounds(393, 131, 157, 27);
		panel.add(txt_ngay_tra);
		
		JLabel lb_TG_bat_dau = new JLabel("Bắt đầu:");
		lb_TG_bat_dau.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lb_TG_bat_dau.setBounds(20, 180, 79, 27);
		panel.add(lb_TG_bat_dau);
		
		txt_h_batdau = new JTextField();
		txt_h_batdau.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt_h_batdau.setColumns(10);
		txt_h_batdau.setBounds(110, 180, 157, 27);
		panel.add(txt_h_batdau);
		
		JLabel lb_TG_ket_thua = new JLabel("kết thúc:");
		lb_TG_ket_thua.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lb_TG_ket_thua.setBounds(312, 180, 79, 27);
		panel.add(lb_TG_ket_thua);
		
		txt_h_ketthuc = new JTextField();
		txt_h_ketthuc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt_h_ketthuc.setColumns(10);
		txt_h_ketthuc.setBounds(393, 180, 157, 27);
		panel.add(txt_h_ketthuc);
		
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
		
		JLabel txt_gia_san = new JLabel("");
		txt_gia_san.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt_gia_san.setBounds(110, 233, 157, 27);
		panel.add(txt_gia_san);
		
		JButton bt_dat_san_1 = new JButton("Tìm kiếm");
		bt_dat_san_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		bt_dat_san_1.setBounds(346, 233, 107, 46);
		panel.add(bt_dat_san_1);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBounds(0, 0, 710, 35);
		panel.add(panel_2_1);
		panel_2_1.setLayout(null);
		panel_2_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		
		JLabel lblNewLabel_3_1 = new JLabel("Thông tin đặt sân");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3_1.setBounds(10, 0, 185, 34);
		panel_2_1.add(lblNewLabel_3_1);
	}
}
