package Admin;

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
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.SimpleTimeZone;
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
import javax.swing.JSpinner.DateEditor;

public class San_bong extends JPanel {

	
	
	
	private JTable table;
	private DefaultTableModel model;

	private JTextField txt_ten_san;
    
	private JComboBox<String> jcombo_CS;
	private JComboBox<String> jcombo_ma_cs;
	private JComboBox<String> jcombo_ls;

	private JDateChooser ngay_da;

	private Date now;

	private JSpinner txt_gio_da;
	private JSpinner txt_gio_nghi;

	private ArrayList<san_bong> list;

	public San_bong() {
		setBackground(new Color(128, 128, 128));
		setBounds(0, 0, 893, 713);
		setLayout(null);

		JPanel panel_main = new JPanel();
		panel_main.setBounds(0, 0, 893, 713);
		add(panel_main);
		panel_main.setLayout(null);

		JPanel pn_TT_san = new JPanel();
		pn_TT_san.setLayout(null);
		pn_TT_san.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		pn_TT_san.setBackground(Color.WHITE);
		pn_TT_san.setBounds(0, 375, 893, 328);
		panel_main.add(pn_TT_san);

		JLabel lb_maCS = new JLabel("Mã cơ sở:");
		lb_maCS.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lb_maCS.setBounds(20, 50, 69, 27);
		pn_TT_san.add(lb_maCS);

		DefaultComboBoxModel comboModel_maCS = new DefaultComboBoxModel();
		comboModel_maCS.addElement("1");
		comboModel_maCS.addElement("2");
		comboModel_maCS.addElement("3");

		jcombo_ma_cs = new JComboBox(comboModel_maCS);
		jcombo_ma_cs.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jcombo_ma_cs.setBounds(110, 50, 97, 27);
		pn_TT_san.add(jcombo_ma_cs);

		JLabel lb_Ten_san = new JLabel("Tên sân:");
		lb_Ten_san.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lb_Ten_san.setBounds(20, 90, 69, 27);
		pn_TT_san.add(lb_Ten_san);

		txt_ten_san = new JTextField();
		txt_ten_san.setHorizontalAlignment(SwingConstants.LEFT);
		txt_ten_san.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txt_ten_san.setColumns(10);
		txt_ten_san.setBounds(110, 90, 144, 27);
		pn_TT_san.add(txt_ten_san);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(192, 192, 192));
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_1_1.setBounds(0, 0, 893, 35);
		pn_TT_san.add(panel_1_1);

		JLabel lblNewLabel = new JLabel(" Thông tin sân bóng");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBackground(new Color(0, 128, 0));
		lblNewLabel.setBounds(1, 1, 299, 35);
		panel_1_1.add(lblNewLabel);

		JLabel lb_ngay_da = new JLabel("Ngày đá:");
		lb_ngay_da.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lb_ngay_da.setBounds(20, 130, 69, 27);
		pn_TT_san.add(lb_ngay_da);

		// Ngày đá
		now = new Date();
		ngay_da = new JDateChooser();
		ngay_da.getCalendarButton().setFont(new Font("Tahoma", Font.PLAIN, 16));
		ngay_da.setBounds(110, 130, 144, 27);
		pn_TT_san.add(ngay_da);

		JLabel lb_TG_bat_dau = new JLabel("Bắt đầu:");
		lb_TG_bat_dau.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lb_TG_bat_dau.setBounds(20, 170, 69, 27);
		pn_TT_san.add(lb_TG_bat_dau);

		JLabel lb_TG_ket_thua = new JLabel("kết thúc:");
		lb_TG_ket_thua.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lb_TG_ket_thua.setBounds(20, 210, 69, 27);
		pn_TT_san.add(lb_TG_ket_thua);

		SpinnerDateModel sm1 = new SpinnerDateModel(now, null, null, Calendar.HOUR_OF_DAY);
		txt_gio_da = new JSpinner(sm1);
		DateEditor de1 = new DateEditor(txt_gio_da, " HH:mm");
		txt_gio_da.setEditor(de1);
		txt_gio_da.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txt_gio_da.setBounds(110, 172, 133, 27);
		pn_TT_san.add(txt_gio_da);

		SpinnerDateModel sm2 = new SpinnerDateModel(now, null, null, Calendar.HOUR_OF_DAY);
		txt_gio_nghi = new JSpinner(sm2);
		DateEditor de2 = new DateEditor(txt_gio_nghi, " HH:mm");
		txt_gio_nghi.setEditor(de2);
		txt_gio_nghi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txt_gio_nghi.setBounds(110, 212, 133, 27);
		pn_TT_san.add(txt_gio_nghi);

		JButton bt_update_san = new JButton("Lưu ");
		bt_update_san.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				int row =table.getSelectedRow();
				String value = table.getModel().getValueAt(row, 1).toString();
				// _____________________________________________________________
				     san_bong sb = new san_bong();
					sb.setMa_cs(jcombo_ma_cs.getItemAt(jcombo_ma_cs.getSelectedIndex()));
					sb.setMa_San(jcombo_ma_cs.getItemAt(jcombo_ma_cs.getSelectedIndex()),txt_ten_san.getText());
					sb.setTen_san(txt_ten_san.getText());
					//String ls = Integer.parseInt(jcombo_ls.getItemAt(jcombo_ls.getSelectedIndex()));
					sb.setLoai_san(jcombo_ls.getItemAt(jcombo_ls.getSelectedIndex())+" người");
					san_bong_dao.getInterface().update(sb, value);
			
				model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);
				showTable();
				
			}
		});
		bt_update_san.setFont(new Font("Tahoma", Font.PLAIN, 16));
		bt_update_san.setBounds(613, 233, 97, 46);
		pn_TT_san.add(bt_update_san);

		JButton bt_delete_san = new JButton("Bỏ sân");
		bt_delete_san.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row =table.getSelectedRow();
				String value = table.getModel().getValueAt(row, 1).toString();
				san_bong sb = new san_bong();
				san_bong_dao.getInterface().delete(sb, value);
			}
		});
		bt_delete_san.setFont(new Font("Tahoma", Font.PLAIN, 16));
		bt_delete_san.setBounds(720, 233, 97, 46);
		pn_TT_san.add(bt_delete_san);

		JButton bt_add_san = new JButton("Thêm sân");
		bt_add_san.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				san_bong sb = new san_bong();
//				// format ngày đá đã chọn lại thành chuỗi string
//				SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//			    Date h_da = (Date)txt_gio_da.getValue();
//			    String date_format = sp.format(h_da);
//				//_____________________________________________________________
//				if (h_da.before(now)) {
//					JOptionPane.showMessageDialog(null, "Ngày đá không được bé hơn ngày hiện tại!");
//				}
//				else {
//					sb.setMa_San(jcombo_ma_san.getItemAt(jcombo_ma_san.getSelectedIndex()));
//					sb.setTen_san(txt_ten_san.getText());
//					int ls = Integer.parseInt(jcombo_ls.getItemAt(jcombo_ls.getSelectedIndex()));
//					sb.setLoai_san(ls);
//					sb.setNgay_da(date_format);
//					sb.setTrang_thai_san(jcombo_trang_thai.getItemAt(jcombo_trang_thai.getSelectedIndex()));
//					san_bong_dao.getInterface().insert(sb);
//				}
				
				// format ngày đá đã chọn lại thành chuỗi string
//				SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//				SimpleDateFormat spf = new SimpleDateFormat("HH:mm");
//				String date_format = sp.format(ngay_da.getDate());
//				Date h_da = (Date) txt_gio_da.getValue();
//				String h_Da = spf.format(h_da);
//				Date h_nghi = (Date) txt_gio_nghi.getValue();
//				String h_Nghi = spf.format(h_nghi);
//				Date ngay_Da = ngay_da.getDate();
				// _____________________________________________________________
				//if (ngay_Da.before(now)) {
				//	JOptionPane.showMessageDialog(null, "Ngày đá không được bé hơn ngày hiện tại!");
				//} else {
					san_bong sb = new san_bong();
					sb.setMa_cs(jcombo_ma_cs.getItemAt(jcombo_ma_cs.getSelectedIndex()));
					sb.setMa_San(jcombo_ma_cs.getItemAt(jcombo_ma_cs.getSelectedIndex()),txt_ten_san.getText());
					sb.setTen_san(txt_ten_san.getText());
					//int ls = Integer.parseInt(jcombo_ls.getItemAt(jcombo_ls.getSelectedIndex()));
					sb.setLoai_san(jcombo_ls.getItemAt(jcombo_ls.getSelectedIndex())+" người");
					//sb.setNgay_da(date_format);
					//sb.setThoi_gian_da(h_Da + "-" + h_Nghi);
					san_bong_dao.getInterface().insert(sb);
				//}
				model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);
				showTable();
			}
		});
		bt_add_san.setFont(new Font("Tahoma", Font.PLAIN, 16));
		bt_add_san.setBounds(496, 233, 107, 46);
		pn_TT_san.add(bt_add_san);

		JLabel lb_loai_san = new JLabel("Loại sân:");
		lb_loai_san.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lb_loai_san.setBounds(324, 48, 79, 27);
		pn_TT_san.add(lb_loai_san);

		DefaultComboBoxModel comboModel_ls = new DefaultComboBoxModel();
		comboModel_ls.addElement("5");
		comboModel_ls.addElement("7");
		comboModel_ls.addElement("11");

		jcombo_ls = new JComboBox(comboModel_ls);
		jcombo_ls.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jcombo_ls.setBounds(403, 48, 107, 27);
		pn_TT_san.add(jcombo_ls);

		DefaultComboBoxModel comboModel_tt = new DefaultComboBoxModel();
		comboModel_tt.addElement("Trống");
		comboModel_tt.addElement("Bận");

		JPanel pn_cs = new JPanel();
		pn_cs.setLayout(null);
		pn_cs.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		pn_cs.setBackground(Color.WHITE);
		pn_cs.setBounds(0, 0, 893, 125);
		panel_main.add(pn_cs);

		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setBackground(new Color(192, 192, 192));
		panel_1_1_1.setLayout(null);
		panel_1_1_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_1_1_1.setBounds(0, 0, 893, 35);
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

		DefaultComboBoxModel comboModel = new DefaultComboBoxModel();
		comboModel.addElement("1");
		comboModel.addElement("2");
		comboModel.addElement("3");

		jcombo_CS = new JComboBox(comboModel);
		jcombo_CS.setFont(new Font("Tahoma", Font.PLAIN, 20));
		jcombo_CS.setBounds(110, 48, 102, 41);
		pn_cs.add(jcombo_CS);

		JButton btnNewButton = new JButton("Xem danh sách");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				list = san_bong_dao.getInterface()
						.select_by_condition("maCS='" + jcombo_CS.getItemAt(jcombo_CS.getSelectedIndex()) + "'");
				model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);
				showTable();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(234, 51, 129, 38);
		pn_cs.add(btnNewButton);

		JPanel pn_ds_san = new JPanel();
		pn_ds_san.setLayout(null);
		pn_ds_san.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		pn_ds_san.setBackground(Color.WHITE);
		pn_ds_san.setBounds(0, 125, 893, 250);
		panel_main.add(pn_ds_san);

		JPanel panel_1_1_1_1 = new JPanel();
		panel_1_1_1_1.setBackground(new Color(192, 192, 192));
		panel_1_1_1_1.setLayout(null);
		panel_1_1_1_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_1_1_1_1.setBounds(0, 0, 893, 35);
		pn_ds_san.add(panel_1_1_1_1);

		JLabel lblDanhSchSn_1 = new JLabel(" Danh sách sân bóng ");
		lblDanhSchSn_1.setForeground(Color.BLACK);
		lblDanhSchSn_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDanhSchSn_1.setBackground(Color.LIGHT_GRAY);
		lblDanhSchSn_1.setBounds(1, 1, 299, 35);
		panel_1_1_1_1.add(lblDanhSchSn_1);

		table = new JTable();
		table.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		table.setFont(new Font("Tahoma", Font.PLAIN, 16));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				TableModel model_table = table.getModel();

				String co_so = model_table.getValueAt(i, 1).toString();

				switch (co_so) {
				case "1":
					jcombo_ma_cs.setSelectedIndex(0);
					break;
				case "2":
					jcombo_ma_cs.setSelectedIndex(1);
					break;
				case "3":
					jcombo_ma_cs.setSelectedIndex(2);
					break;

				}
				txt_ten_san.setText(model_table.getValueAt(i, 2).toString());
				String loai_san = model_table.getValueAt(i, 3).toString();

				switch (loai_san) {
				case "5":
					jcombo_ls.setSelectedIndex(0);
					break;
				case "7":
					jcombo_ls.setSelectedIndex(1);
					break;
				case "11":
					jcombo_ls.setSelectedIndex(2);
					break;
				}
			}
		});
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] {}));
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 35, 893, 215);
		pn_ds_san.add(scrollPane);

		model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		model.setColumnIdentifiers(
				new Object[] { "STT", "Mã sân", "Tên sân", "Loại sân"});
	}

	public void showTable() {
		int i = 1;
		for (san_bong sb : list) {
			model.addRow(new Object[] { i++, sb.getMa_San(), sb.getTen_san(), sb.getLoai_san()
					});
		}
	}

	public boolean check_thoi_gian_Da(Date h_da, Date h_nghi) {
		return true;
	}

}
