package Admin;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.border.MatteBorder;
import java.awt.Font;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class coso_controll extends JPanel {
	private JTextField txt_CS;
	private JTextField txt_ten_san;
	private JTextField txt_tg_batdau;
	private JTextField txt_tg_ketthuc;
	private JTextField txt_cs;
	private JTextField txt_loai_san;
	private JTextField txt_gia_tien;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public coso_controll() {
		setBackground(new Color(128, 128, 128));
		setBounds(0, 0, 864, 703);
		setLayout(null);
		
		JPanel panel_main = new JPanel();
		panel_main.setBounds(0, 0, 864, 703);
		add(panel_main);
		panel_main.setLayout(null);
		
		JPanel pn_TT_san = new JPanel();
		pn_TT_san.setLayout(null);
		pn_TT_san.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		pn_TT_san.setBackground(Color.WHITE);
		pn_TT_san.setBounds(0, 375, 864, 328);
		panel_main.add(pn_TT_san);
		
		JLabel lb_maCS = new JLabel("Mã cơ sở:");
		lb_maCS.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lb_maCS.setBounds(20, 50, 69, 27);
		pn_TT_san.add(lb_maCS);
		
		txt_CS = new JTextField();
		txt_CS.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt_CS.setColumns(10);
		txt_CS.setBounds(110, 50, 166, 27);
		pn_TT_san.add(txt_CS);
		
		JLabel lb_Ten_san = new JLabel("Tên sân:");
		lb_Ten_san.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lb_Ten_san.setBounds(20, 90, 79, 27);
		pn_TT_san.add(lb_Ten_san);
		
		txt_ten_san = new JTextField();
		txt_ten_san.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt_ten_san.setColumns(10);
		txt_ten_san.setBounds(110, 90, 166, 27);
		pn_TT_san.add(txt_ten_san);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_1_1.setBounds(0, 0, 864, 35);
		pn_TT_san.add(panel_1_1);
		
		JLabel lblNewLabel = new JLabel(" Thông tin sân bóng");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBackground(Color.LIGHT_GRAY);
		lblNewLabel.setBounds(1, 1, 299, 35);
		panel_1_1.add(lblNewLabel);
		
		JLabel lb_ngay_da = new JLabel("Ngày đá:");
		lb_ngay_da.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lb_ngay_da.setBounds(20, 130, 79, 27);
		pn_TT_san.add(lb_ngay_da);
		
		JDateChooser ngay_da = new JDateChooser();
		ngay_da.setBounds(110, 130, 166, 27);
		pn_TT_san.add(ngay_da);
		
		JLabel lb_TG_bat_dau = new JLabel("Bắt đầu:");
		lb_TG_bat_dau.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lb_TG_bat_dau.setBounds(20, 170, 79, 27);
		pn_TT_san.add(lb_TG_bat_dau);
		
		txt_tg_batdau = new JTextField();
		txt_tg_batdau.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt_tg_batdau.setColumns(10);
		txt_tg_batdau.setBounds(110, 170, 166, 27);
		pn_TT_san.add(txt_tg_batdau);
		
		JLabel lb_TG_ket_thua = new JLabel("kết thúc:");
		lb_TG_ket_thua.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lb_TG_ket_thua.setBounds(20, 210, 79, 27);
		pn_TT_san.add(lb_TG_ket_thua);
		
		txt_tg_ketthuc = new JTextField();
		txt_tg_ketthuc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt_tg_ketthuc.setColumns(10);
		txt_tg_ketthuc.setBounds(110, 210, 166, 27);
		pn_TT_san.add(txt_tg_ketthuc);
		
		JButton bt_update_san = new JButton("Thay đổi");
		bt_update_san.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		bt_update_san.setFont(new Font("Tahoma", Font.PLAIN, 16));
		bt_update_san.setBounds(613, 233, 97, 46);
		pn_TT_san.add(bt_update_san);
		
		JButton bt_delete_san = new JButton("Bỏ sân");
		bt_delete_san.setFont(new Font("Tahoma", Font.PLAIN, 16));
		bt_delete_san.setBounds(720, 233, 97, 46);
		pn_TT_san.add(bt_delete_san);
		
		JLabel lb_gia_tien = new JLabel("Giá sân:");
		lb_gia_tien.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lb_gia_tien.setBounds(324, 90, 69, 27);
		pn_TT_san.add(lb_gia_tien);
		
		JButton bt_add_san = new JButton("Thêm sân");
		bt_add_san.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		bt_add_san.setFont(new Font("Tahoma", Font.PLAIN, 16));
		bt_add_san.setBounds(496, 233, 107, 46);
		pn_TT_san.add(bt_add_san);
		
		JLabel lb_loai_san = new JLabel("Loại sân:");
		lb_loai_san.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lb_loai_san.setBounds(324, 48, 79, 27);
		pn_TT_san.add(lb_loai_san);
		
		txt_loai_san = new JTextField();
		txt_loai_san.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt_loai_san.setColumns(10);
		txt_loai_san.setBounds(403, 48, 163, 27);
		pn_TT_san.add(txt_loai_san);
		
		txt_gia_tien = new JTextField();
		txt_gia_tien.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt_gia_tien.setColumns(10);
		txt_gia_tien.setBounds(403, 90, 163, 27);
		pn_TT_san.add(txt_gia_tien);
		
		JPanel pn_cs = new JPanel();
		pn_cs.setLayout(null);
		pn_cs.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		pn_cs.setBackground(Color.WHITE);
		pn_cs.setBounds(0, 0, 864, 125);
		panel_main.add(pn_cs);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setLayout(null);
		panel_1_1_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_1_1_1.setBounds(0, 0, 864, 35);
		pn_cs.add(panel_1_1_1);
		
		JLabel lblDanhSchSn = new JLabel("Cơ sở");
		lblDanhSchSn.setForeground(Color.BLACK);
		lblDanhSchSn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDanhSchSn.setBackground(Color.LIGHT_GRAY);
		lblDanhSchSn.setBounds(10, 0, 84, 35);
		panel_1_1_1.add(lblDanhSchSn);
		
		JLabel lblNewLabel_4_1 = new JLabel("");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4_1.setBounds(110, 233, 157, 27);
		pn_cs.add(lblNewLabel_4_1);
		
		JLabel lb_cs = new JLabel("Cơ sở:");
		lb_cs.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lb_cs.setBounds(48, 51, 60, 35);
		pn_cs.add(lb_cs);
		
		txt_cs = new JTextField();
		txt_cs.setBounds(110, 50, 157, 41);
		pn_cs.add(txt_cs);
		txt_cs.setColumns(10);
		
		JLabel lb_mess = new JLabel("");
		lb_mess.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lb_mess.setBounds(277, 50, 207, 36);
		pn_cs.add(lb_mess);
		
		JPanel pn_ds_san = new JPanel();
		pn_ds_san.setLayout(null);
		pn_ds_san.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		pn_ds_san.setBackground(Color.WHITE);
		pn_ds_san.setBounds(0, 125, 864, 250);
		panel_main.add(pn_ds_san);
		
		JPanel panel_1_1_1_1 = new JPanel();
		panel_1_1_1_1.setLayout(null);
		panel_1_1_1_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_1_1_1_1.setBounds(0, 0, 864, 35);
		pn_ds_san.add(panel_1_1_1_1);
		
		JLabel lblDanhSchSn_1 = new JLabel(" Danh sách sân bóng ");
		lblDanhSchSn_1.setForeground(Color.BLACK);
		lblDanhSchSn_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDanhSchSn_1.setBackground(Color.LIGHT_GRAY);
		lblDanhSchSn_1.setBounds(1, 1, 299, 35);
		panel_1_1_1_1.add(lblDanhSchSn_1);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("");
		lblNewLabel_4_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4_1_1.setBounds(110, 233, 157, 27);
		pn_ds_san.add(lblNewLabel_4_1_1);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 35, 864, 215);
		pn_ds_san.add(scrollPane);
		
		
		
	}
}
