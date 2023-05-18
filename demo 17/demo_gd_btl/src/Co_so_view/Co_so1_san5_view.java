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

import Main.dao.dat_san_dao;
import Main.dao.KhachHangDAO;
import Main.dao.san_bong_dao;
import Main.database.jdbc_until;
import Main.model.Co_so;
import Main.model.dat_san;
import Main.model.khach_hang;
import Main.model.san_bong;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

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
import java.util.Hashtable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ComboBoxModel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import java.awt.SystemColor;

public class Co_so1_san5_view extends JPanel {

	// ______________
	private JTextField txt_ten_kh;
	private JTextField txt_sdt_kh;
	private JTextField textField_2;
	private JTextField textField_3;
	// __________
	private JDateChooser ngay_da;
	private Date now;
	private JComboBox<String> jcombo_ten_san;
	private JSpinner txt_gio_da;
	private JSpinner txt_gio_nghi;
	// ________
	// private DefaultTableModel model;
	private JTable table;
	private ArrayList<dat_san> list;
	private ArrayList<san_bong> list_sb;
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
		panel_2.setBackground(new Color(128, 128, 0));
		panel_2.setLayout(null);
		panel_2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_2.setBounds(0, 0, 746, 35);
		add(panel_2);

		JLabel lblNewLabel_3 = new JLabel(" DS đặt sân bóng 5 người Cơ sở 1");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(10, 0, 437, 34);
		panel_2.add(lblNewLabel_3);

		list = new ArrayList<dat_san>();

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] {}));
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 35, 746, 170);
		add(scrollPane);
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setColumnIdentifiers(new Object[] { "STT", "Mã sân", "Tên sân", "Ngày đá", "Thời gian" });

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
		panel_1.setBackground(new Color(128, 128, 0));
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
		Image icon_add_kh = new ImageIcon(this.getClass().getResource("/add khach hang.png")).getImage();

		JLabel lb_ten_san = new JLabel("Tên sân:");
		lb_ten_san.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lb_ten_san.setBounds(324, 130, 79, 27);
		panel.add(lb_ten_san);


		list_sb = new ArrayList<>();
		list_sb= san_bong_dao.getInterface().select_by_condition("iD_CoSo = 1 and LoaiSan = '5 người'");
		DefaultComboBoxModel comboModel = new DefaultComboBoxModel();
		for (san_bong sb: list_sb) {
			comboModel.addElement(sb.getTen_san());
		}
		jcombo_ten_san = new JComboBox(comboModel);
		jcombo_ten_san.setFont(new Font("Tahoma", Font.PLAIN, 20));
		jcombo_ten_san.setBounds(413, 126, 146, 30);
		panel.add(jcombo_ten_san);
		
		
		
		JLabel lb_ngay_da = new JLabel("Ngày đá:");
		lb_ngay_da.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lb_ngay_da.setBounds(20, 130, 79, 27);
		panel.add(lb_ngay_da);

		// _________ngày đá________________
		ngay_da = new JDateChooser();
		ngay_da.setBounds(109, 130, 146, 27);
		panel.add(ngay_da);

		JLabel lb_TG_bat_dau = new JLabel("Bắt đầu:");
		lb_TG_bat_dau.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lb_TG_bat_dau.setBounds(20, 167, 79, 27);
		panel.add(lb_TG_bat_dau);

		SpinnerDateModel sm1 = new SpinnerDateModel(now, null, null, Calendar.HOUR_OF_DAY);
		txt_gio_da = new JSpinner(sm1);
		JSpinner.DateEditor de1 = new JSpinner.DateEditor(txt_gio_da, "HH:mm");
		txt_gio_da.setEditor(de1);
		txt_gio_da.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txt_gio_da.setBounds(109, 167, 145, 27);
		panel.add(txt_gio_da);

		JLabel lb_TG_ket_thuc = new JLabel("Kết thúc:");
		lb_TG_ket_thuc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lb_TG_ket_thuc.setBounds(20, 204, 79, 27);
		panel.add(lb_TG_ket_thuc);

		SpinnerDateModel sm2 = new SpinnerDateModel(now, null, null, Calendar.HOUR_OF_DAY);
		txt_gio_nghi = new JSpinner(sm2);
		JSpinner.DateEditor de2 = new JSpinner.DateEditor(txt_gio_nghi, "HH:mm");
		txt_gio_nghi.setEditor(de2);
		txt_gio_nghi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txt_gio_nghi.setBounds(109, 204, 146, 27);
		panel.add(txt_gio_nghi);

		JButton bt_dat_san = new JButton("Đặt sân");
		bt_dat_san.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ngay_da.getDate() == null || txt_ten_kh.getText().equals("") || txt_sdt_kh.equals("")) {
					JOptionPane.showMessageDialog(null, "Vui long nhập đầy đủ thông tin!");
				} else {

					String regex = "^0[98753]{1}\\d{8}$";
					Pattern pt = Pattern.compile(regex);
					Matcher mt = pt.matcher(txt_sdt_kh.getText());

					if (mt.find()) {
						// format ngày đá đã chọn lại thành chuỗi string
						SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd");
						String date_format = sp.format(ngay_da.getDate());

						SimpleDateFormat spf = new SimpleDateFormat("HH:mm");
						Date h_da = (Date) txt_gio_da.getValue();
						String h_Da = spf.format(h_da);
						Date h_nghi = (Date) txt_gio_nghi.getValue();
						String h_Nghi = spf.format(h_nghi);
                        // ngày đá + giờ đá = tg bắt đầu , ngày đá + giờ nghỉ = tg kết thúc 
						SimpleDateFormat spfd = new SimpleDateFormat("yyyy-MM-dd HH:mm");
						Date gio_bat_dau = null;
						Date gio_ket_thuc = null;
						try {
							gio_bat_dau = spfd.parse(date_format + " " + h_Da);
							gio_ket_thuc = spfd.parse(date_format + " " + h_Nghi);
						} catch (ParseException e2) {
							e2.printStackTrace();
						}
						if (gio_bat_dau.before(now)) {
							JOptionPane.showMessageDialog(null, "Ngày đá không được bé hơn ngày hiện tại!");
						} else {
							if (check_thoi_gian_da(gio_bat_dau, gio_ket_thuc) == false) {
							} else {
								if (dat_san_dao.getInterface().check_san(date_format, h_Da, h_Nghi, "1",
										jcombo_ten_san.getItemAt(jcombo_ten_san.getSelectedIndex())) == false) {
									JOptionPane.showMessageDialog(null, "Cơ sở 1 đã hết sân khung giờ " + h_Da + "-"
											+ h_Nghi + " ngày " + date_format);
								} else {
									khach_hang kh = new khach_hang();
									kh.setHoTen(txt_ten_kh.getText());
									kh.setSoDienThoai(txt_sdt_kh.getText());
									KhachHangDAO.getInstance().insert(kh);
									
									dat_san ds = new dat_san();
									ds.setMa_san(dat_san_dao.getInterface().lay_ma_san(date_format, h_Da, h_Nghi, "1",jcombo_ten_san.getItemAt(jcombo_ten_san.getSelectedIndex())));
									ds.setMaCS("1");
									ds.setTen_san(jcombo_ten_san.getItemAt(jcombo_ten_san.getSelectedIndex()));
									ds.setNgay_Da(date_format);
									ds.setGio_bat_dau(h_Da);
									ds.setGio_ket_thuc(h_Nghi);
									ds.setSdt(txt_sdt_kh.getText());
									ds.setLoai_san("5 người");
									dat_san_dao.getInterface().insert(ds);
								}
							}
						}
					} else {
						JOptionPane.showMessageDialog(null, "Số điện thoại không hợp lệ!");
					}
				}
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);
				showTable();
			}
		});
		bt_dat_san.setBackground(new Color(240, 240, 240));
		bt_dat_san.setFont(new Font("Tahoma", Font.PLAIN, 16));
		bt_dat_san.setBounds(380, 260, 97, 46);
		panel.add(bt_dat_san);

		JButton bt_huy_san = new JButton("Huỷ sân");
		bt_huy_san.setBackground(new Color(240, 240, 240));
		bt_huy_san.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(txt_sdt_kh.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Vui lòng nhập Số điện thoại!");
				}else {
					dat_san dt = new dat_san();
					dat_san_dao.getInterface().delete(dt,"ID_SDT_KH = '"+txt_sdt_kh.getText()+"'");
					khach_hang kh= new khach_hang();
					KhachHangDAO.getInstance().delete(kh, txt_sdt_kh.getText());
					JOptionPane.showMessageDialog(null, "Huỷ sân thành công!");
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					model.setRowCount(0);
					showTable();
				}
				
			}
		});
		bt_huy_san.setFont(new Font("Tahoma", Font.PLAIN, 16));
		bt_huy_san.setBounds(487, 260, 97, 46);
		panel.add(bt_huy_san);

		JButton bt_tim_san = new JButton("Tìm sân");
		bt_tim_san.setBackground(new Color(240, 240, 240));
		bt_tim_san.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ngay_da.getDate() == null) {
					JOptionPane.showMessageDialog(null, "Vui long nhập đầy đủ thông tin!");
				} else {
					Date ngay_Da = ngay_da.getDate();
					if (ngay_Da.before(now)) {
						System.out.println(ngay_Da);
						JOptionPane.showMessageDialog(null, "Ngày đá không được bé hơn ngày hiện tại!");
					} else {
					
					SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd");
					String date_format = sp.format(ngay_da.getDate());
					
					SimpleDateFormat spf = new SimpleDateFormat("HH:mm");
					Date h_da = (Date) txt_gio_da.getValue();
					String h_Da = spf.format(h_da);
					Date h_nghi = (Date) txt_gio_nghi.getValue();
					String h_Nghi = spf.format(h_nghi);

					SimpleDateFormat spfd = new SimpleDateFormat("yyyy-MM-dd HH:mm");
					Date gio_bat_dau = null;
					Date gio_ket_thuc = null;
					try {
						gio_bat_dau = spfd.parse(date_format + " " + h_Da);
						gio_ket_thuc = spfd.parse(date_format + " " + h_Nghi);
					} catch (ParseException e2) {
						e2.printStackTrace();
					}
					if (check_thoi_gian_da(gio_bat_dau, gio_ket_thuc) == false) {
					} else {
						if (dat_san_dao.getInterface().check_san(date_format, h_Da, h_Nghi, "1",
								jcombo_ten_san.getItemAt(jcombo_ten_san.getSelectedIndex())) == true) {
								JOptionPane.showMessageDialog(null, "Có sân trống!");
							} else {
								JOptionPane.showMessageDialog(null, "không có sân trống!");
							}
						}
					}
				}

			}
		});
		bt_tim_san.setFont(new Font("Tahoma", Font.PLAIN, 16));
		bt_tim_san.setBounds(264, 260, 106, 46);
		panel.add(bt_tim_san);
		
		JButton btn_thanhToan = new JButton("Thanh toán");
		btn_thanhToan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txt_sdt_kh.getText().length() <= 0)
					return;
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				if(model.getRowCount() <= 0)
					return;
				
				Hashtable map = new Hashtable();
					
				try {
					JasperReport jrp = JasperCompileManager.compileReport("src/Co_so_view/Report_ThanhToan.jrxml");
					map.put("sDT", txt_sdt_kh.getText());
					Connection conn = jdbc_until.getConnection();
					JasperPrint jp = JasperFillManager.fillReport(jrp, map, conn);
					JasperViewer.viewReport(jp, false);
				} catch (JRException e1) {	
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btn_thanhToan.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_thanhToan.setBackground(SystemColor.menu);
		btn_thanhToan.setBounds(594, 260, 142, 46);
		panel.add(btn_thanhToan);
		
	}

	public void showTable() {
		list = dat_san_dao.getInterface().select_by_condition("iD_CoSo = 1 and LoaiSan = '5 người'");
		int i = 1;
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		for (dat_san ds : list) {
			model.addRow(new Object[] { i++, ds.getMa_san(), ds.getTen_san(), ds.getNgay_Da(),
					ds.getGio_bat_dau() + "-" + ds.getGio_ket_thuc()});
		}
	}

	public boolean check_thoi_gian_da(Date h_da, Date h_nghi){
		if (h_da.getHours() < 6 || h_nghi.getHours() < 6 ) {
			JOptionPane.showMessageDialog(null, "Cơ sở bắt đầu mở cửa từ 6 giờ đến 24 giờ trong ngày");
			return false;
		} 
		else if(h_da.before(now)){
			JOptionPane.showMessageDialog(null, "Giờ bắt đầu không hợp lệ!");
			return false;
		}
		else {
		
			try {
				long s_value = h_da.getTime();
				long e_value = h_nghi.getTime();
				long tmp = Math.abs(e_value - s_value);
				float re = (float) tmp / (60 * 60 * 1000);
				// System.out.println(" số h chênh lệch:"+re);
				if (re < 0.5) {
					JOptionPane.showMessageDialog(null, "Thời gian đá phải lớn hơn 30 phút!");
					return false;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return true;
	}
}
