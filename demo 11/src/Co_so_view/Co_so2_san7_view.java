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
import javax.swing.SpinnerDateModel;
import javax.swing.JScrollBar;
import javax.swing.JSlider;
import javax.swing.JSpinner;

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
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import javax.swing.SpinnerModel;

public class Co_so2_san7_view extends JPanel {

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
	public Co_so2_san7_view() {
		setBackground(new Color(128, 128, 128));
		setBounds(0, 0, 742, 526);
		setLayout(null);
		//// ________________________________________
		now = new Date();
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 200, 0));
		panel_2.setLayout(null);
		panel_2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_2.setBounds(0, 0, 742, 35);
		add(panel_2);

		JLabel lblNewLabel_3 = new JLabel(" Danh sách sân bóng 7 người cơ sở 1");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(10, 0, 355, 34);
		panel_2.add(lblNewLabel_3);

		list = san_bong_dao.getInterface().select_by_condition("ma_san = 1 and loai_san = 7");

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] {}));
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 35, 742, 170);
		add(scrollPane);

		model = (DefaultTableModel) table.getModel();
		model.setColumnIdentifiers(new Object[] { "STT", "Tên sân", "Ngày đá", "Thời gian", "Trạng thái" });
		showTable();
		//// ________________________________________

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 206, 742, 320);
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
		panel_1.setBackground(new Color(0, 200, 0));
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
		panel_add_khach_hang.setBorder(new LineBorder(new Color(0, 0, 0)));
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

		JLabel lblNewLabel_2 = new JLabel("Thêm mới khách hàng");
		lblNewLabel_2.setBounds(10, 5, 192, 47);
		panel_add_khach_hang.add(lblNewLabel_2);
		Image icon_add_kh = new ImageIcon(this.getClass().getResource("/add khach hang.png")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(icon_add_kh));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JLabel lb_ngay_tra = new JLabel("Ngày đá:");
		lb_ngay_tra.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lb_ngay_tra.setBounds(20, 135, 79, 27);
		panel.add(lb_ngay_tra);

		// _________ngày đá________________
		ngay_da = new JDateChooser();
		ngay_da.setBounds(107, 135, 157, 27);
		panel.add(ngay_da);

		JLabel lb_TG_bat_dau = new JLabel("Bắt đầu:");
		lb_TG_bat_dau.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lb_TG_bat_dau.setBounds(20, 180, 79, 27);
		panel.add(lb_TG_bat_dau);

		JLabel lb_TG_ket_thua = new JLabel("kết thúc:");
		lb_TG_ket_thua.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lb_TG_ket_thua.setBounds(20, 210, 79, 27);
		panel.add(lb_TG_ket_thua);

		JButton bt_dat_san = new JButton("Đặt sân");
		bt_dat_san.setBackground(new Color(240, 240, 240));
		bt_dat_san.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		bt_dat_san.setFont(new Font("Tahoma", Font.PLAIN, 16));
		bt_dat_san.setBounds(498, 260, 97, 46);
		panel.add(bt_dat_san);

		JButton bt_huy_san = new JButton("Huỷ sân");
		bt_huy_san.setBackground(new Color(240, 240, 240));
		bt_huy_san.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		bt_huy_san.setFont(new Font("Tahoma", Font.PLAIN, 16));
		bt_huy_san.setBounds(605, 260, 97, 46);
		panel.add(bt_huy_san);

		JButton bt_dat_san_1 = new JButton("Tìm kiếm");
		bt_dat_san_1.setBackground(new Color(240, 240, 240));
		bt_dat_san_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		bt_dat_san_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		bt_dat_san_1.setBounds(381, 260, 107, 46);
		panel.add(bt_dat_san_1);

		JButton bt_dat_san_1_1 = new JButton("Danh sách sân trống");
		bt_dat_san_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		bt_dat_san_1_1.setBackground(SystemColor.menu);
		bt_dat_san_1_1.setBounds(274, 135, 179, 35);
		panel.add(bt_dat_san_1_1);

		SpinnerDateModel sm2 = new SpinnerDateModel(now, null, null, Calendar.HOUR_OF_DAY);
		txt_gio_da = new JSpinner(sm2);
		JSpinner.DateEditor de1 = new JSpinner.DateEditor(txt_gio_da, "HH:mm:ss");
		txt_gio_da.setEditor(de1);
		txt_gio_da.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txt_gio_da.setBounds(106, 180, 144, 27);
		panel.add(txt_gio_da);

		SpinnerDateModel sm1 = new SpinnerDateModel(now, null, null, Calendar.HOUR_OF_DAY);
		txt_gio_nghi = new JSpinner(sm1);
		JSpinner.DateEditor de2 = new JSpinner.DateEditor(txt_gio_nghi, "HH:mm:ss");
		txt_gio_nghi.setEditor(de2);
		txt_gio_nghi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txt_gio_nghi.setBounds(106, 210, 144, 27);
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
