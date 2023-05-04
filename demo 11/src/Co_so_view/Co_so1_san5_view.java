package Co_so_view;

import java.awt.Image;
//
import javax.swing.ImageIcon;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.MatteBorder;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;

import com.toedter.calendar.JDateChooser;

import Main.dao.san_bong_dao;
import Main.model.san_bong;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ComboBoxModel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;

public class Co_so1_san5_view extends JPanel {

	// ______________
	private JTextField txt_ten_kh;
	private JTextField txt_sdt_kh;
	private JTextField textField_2;
	private JTextField textField_3;
	// __________
	private JDateChooser ngay_da;
	private Date now;
	private JSpinner txt_gio_da;
	private JSpinner txt_gio_nghi;
	// ________
	private DefaultTableModel model;
	private JTable table;
	private ArrayList<san_bong> list;

	/**
	 * Create the panel.
	 */
	public Co_so1_san5_view() {
		setBackground(new Color(128, 128, 128));
		setBounds(0, 0, 746, 526);
		setLayout(null);
		//// ________________________________________

		now = new Date();

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 206, 0));
		panel_2.setLayout(null);
		panel_2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_2.setBounds(0, 0, 746, 35);
		add(panel_2);

		JLabel lblNewLabel_3 = new JLabel(" Danh sách sân bóng 5 người cơ sở 1");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(10, 0, 350, 34);
		panel_2.add(lblNewLabel_3);

		list = san_bong_dao.getInterface().select_by_condition("ma_san = 1 and loai_san= 5");

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] {}));
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 35, 746, 170);
		add(scrollPane);

		model = (DefaultTableModel) table.getModel();
		model.setColumnIdentifiers(new Object[] { "STT", "Tên sân", "Ngày đá", "Thời gian", "Trạng thái" });
		showTable();
		//// ________________________________________

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 205, 746, 321);
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
		lb_sdt.setBounds(20, 85, 120, 27);
		panel.add(lb_sdt);

		txt_sdt_kh = new JTextField();
		txt_sdt_kh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt_sdt_kh.setColumns(10);
		txt_sdt_kh.setBounds(150, 87, 258, 27);
		panel.add(txt_sdt_kh);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 189, 0));
		panel_1.setLayout(null);
		panel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_1.setBounds(0, 0, 746, 35);
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

			@Override
			public void mousePressed(MouseEvent e) {
				panel_add_khach_hang.setBackground(new Color(112, 128, 144));
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
			public void mouseReleased(MouseEvent e) {
				panel_add_khach_hang.setBackground(new Color(112, 128, 144));
			}

		});
		panel_add_khach_hang.setLayout(null);
		panel_add_khach_hang.setBounds(462, 48, 209, 57);
		panel.add(panel_add_khach_hang);

		JLabel lb_add_kh = new JLabel("Thêm mới khách hàng");
		lb_add_kh.setBounds(10, 5, 192, 47);
		panel_add_khach_hang.add(lb_add_kh);
		Image icon_add_kh = new ImageIcon(this.getClass().getResource("/add khach hang.png")).getImage();
		lb_add_kh.setIcon(new ImageIcon(icon_add_kh));
		lb_add_kh.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JLabel lb_ngay_tra = new JLabel("Ngày đá:");
		lb_ngay_tra.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lb_ngay_tra.setBounds(20, 135, 79, 27);
		panel.add(lb_ngay_tra);

		// _________ngày đá________________
		ngay_da = new JDateChooser();
		ngay_da.setBounds(109, 135, 168, 27);
		panel.add(ngay_da);

		JLabel lb_TG_bat_dau = new JLabel("Bắt đầu:");
		lb_TG_bat_dau.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lb_TG_bat_dau.setBounds(20, 180, 79, 27);
		panel.add(lb_TG_bat_dau);

		JLabel lb_TG_ket_thuc = new JLabel("Kết thúc:");
		lb_TG_ket_thuc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lb_TG_ket_thuc.setBounds(20, 210, 79, 27);
		panel.add(lb_TG_ket_thuc);

		JButton bt_dat_san = new JButton("Đặt sân");
		bt_dat_san.setBackground(new Color(240, 240, 240));
		bt_dat_san.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		bt_dat_san.setFont(new Font("Tahoma", Font.PLAIN, 16));
		bt_dat_san.setBounds(514, 260, 97, 46);
		panel.add(bt_dat_san);

		JButton bt_huy_san = new JButton("Huỷ sân");
		bt_huy_san.setBackground(new Color(240, 240, 240));
		bt_huy_san.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		bt_huy_san.setFont(new Font("Tahoma", Font.PLAIN, 16));
		bt_huy_san.setBounds(621, 260, 97, 46);
		panel.add(bt_huy_san);

		JButton bt_tim_san = new JButton("Tìm sân");
		bt_tim_san.setBackground(new Color(240, 240, 240));
		bt_tim_san.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		bt_tim_san.setFont(new Font("Tahoma", Font.PLAIN, 16));
		bt_tim_san.setBounds(398, 260, 106, 46);
		panel.add(bt_tim_san);

		JButton bt_tim_san_trong = new JButton("Danh sách sân trống");
		bt_tim_san_trong.setFont(new Font("Tahoma", Font.PLAIN, 16));
		bt_tim_san_trong.setBounds(287, 130, 191, 35);
		panel.add(bt_tim_san_trong);

		SpinnerDateModel sm1 = new SpinnerDateModel(now, null, null, Calendar.HOUR_OF_DAY);
		txt_gio_da = new JSpinner(sm1);
		JSpinner.DateEditor de1 = new JSpinner.DateEditor(txt_gio_da, "HH:mm:ss");
		txt_gio_da.setEditor(de1);
		txt_gio_da.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txt_gio_da.setBounds(110, 180, 144, 27);
		panel.add(txt_gio_da);
		
		SpinnerDateModel sm2 = new SpinnerDateModel(now, null, null, Calendar.HOUR_OF_DAY);
		txt_gio_nghi = new JSpinner(sm2);
		JSpinner.DateEditor de2 = new JSpinner.DateEditor(txt_gio_nghi, "HH:mm:ss");
		txt_gio_nghi.setEditor(de2);
		txt_gio_nghi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txt_gio_nghi.setBounds(110, 210, 144, 27);
		panel.add(txt_gio_nghi);

	}

	int i = 1;

	public void showTable() {
		for (san_bong sb : list) {
			model.addRow(new Object[] { i++, sb.getTen_san(), sb.getNgay_da(), sb.getThoi_gian_da(),
					sb.getTrang_thai_san() });
		}

	}
}
