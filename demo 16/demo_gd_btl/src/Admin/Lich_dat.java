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

import Main.dao.Co_so_dao;
import Main.dao.dat_san_dao;
import Main.dao.san_bong_dao;
import Main.model.Co_so;
import Main.model.dat_san;
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
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Lich_dat extends JPanel {

	
	
	
	private JTable table;
	private DefaultTableModel model;
    
	private JComboBox<String> jcombo_CS;

	private Date now;
    private JDateChooser ngay_da;
	private ArrayList<dat_san> list;
	private ArrayList<Co_so> id_cs;
	private JTextField txt_tim_sdt;

	public Lich_dat() {
		setBackground(new Color(128, 128, 128));
		setBounds(0, 0, 893, 713);
		setLayout(null);
		id_cs = new ArrayList<>();	
		list = new ArrayList<>();
		
		JPanel panel_main = new JPanel();
		panel_main.setBounds(0, 0, 893, 713);
		add(panel_main);
		panel_main.setLayout(null);

		JPanel pn_TT_san = new JPanel();
		pn_TT_san.setLayout(null);
		pn_TT_san.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		pn_TT_san.setBackground(Color.WHITE);
		pn_TT_san.setBounds(0, 500, 893, 211);
		panel_main.add(pn_TT_san);

		
		id_cs = Co_so_dao.getInterface().selectALL();
		DefaultComboBoxModel comboModel_maCS = new DefaultComboBoxModel();
		for (Co_so cs : id_cs) {
			comboModel_maCS.addElement(cs.getID_CoSo());
		}

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(192, 192, 192));
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_1_1.setBounds(0, 0, 893, 35);
		pn_TT_san.add(panel_1_1);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBackground(new Color(0, 128, 0));
		lblNewLabel.setBounds(1, 1, 299, 35);
		panel_1_1.add(lblNewLabel);

		// Ngày đá
		now = new Date();

		JButton bt_delete_san = new JButton("Huỷ sân");
		bt_delete_san.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd");
//				String date_format = sp.format(ngay_da.getDate());	
//				list = dat_san_dao.getInterface()
//						.select_by_condition_2("iD_CoSo='" + jcombo_CS.getItemAt(jcombo_CS.getSelectedIndex()) + "' and NgayDa = '"+date_format+"'" );
				dat_san dt = new dat_san();
				dat_san_dao.getInterface().delete(dt,"ID_SDT_KH = '"+txt_tim_sdt.getText()+"'");
				model = (DefaultTableModel) table.getModel();
			    model.setRowCount(0);
			    showTable();
			}
		});
		bt_delete_san.setFont(new Font("Tahoma", Font.PLAIN, 16));
		bt_delete_san.setBounds(584, 70, 97, 46);
		pn_TT_san.add(bt_delete_san);
		
		txt_tim_sdt = new JTextField();
		txt_tim_sdt.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txt_tim_sdt.getText().equals(" Số điện thoại khách hàng")) {
					txt_tim_sdt.setText("");
				}else {
					txt_tim_sdt.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txt_tim_sdt.getText().equals("")){
					txt_tim_sdt.setText(" Số điện thoại khách hàng");
				}
			}
		});
		txt_tim_sdt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txt_tim_sdt.setText(" Số điện thoại khách hàng");
		txt_tim_sdt.setBounds(109, 69, 278, 46);
		pn_TT_san.add(txt_tim_sdt);
		txt_tim_sdt.setColumns(10);
		
		JButton bt_tim_san = new JButton("Tìm sân");
		bt_tim_san.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				list = dat_san_dao.getInterface()
						.select_by_condition_2("ld.ID_SDT_KH = '"+txt_tim_sdt.getText()+"'");
				model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);
				showTable();
			}
		});
		bt_tim_san.setFont(new Font("Tahoma", Font.PLAIN, 16));
		bt_tim_san.setBounds(441, 70, 97, 46);
		pn_TT_san.add(bt_tim_san);

		DefaultComboBoxModel comboModel_ls = new DefaultComboBoxModel();
		comboModel_ls.addElement("5");
		comboModel_ls.addElement("7");

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

		JLabel lblDanhSchSn = new JLabel("Lịch đặt sân theo ngày");
		lblDanhSchSn.setForeground(Color.BLACK);
		lblDanhSchSn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDanhSchSn.setBackground(Color.LIGHT_GRAY);
		lblDanhSchSn.setBounds(10, 0, 247, 35);
		panel_1_1_1.add(lblDanhSchSn);

		JLabel lblNewLabel_4_1 = new JLabel("");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4_1.setBounds(110, 233, 157, 27);
		pn_cs.add(lblNewLabel_4_1);

		JLabel lb_cs = new JLabel("Cơ sở:");
		lb_cs.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lb_cs.setBounds(48, 60, 60, 35);
		pn_cs.add(lb_cs);

		DefaultComboBoxModel comboModel = new DefaultComboBoxModel();
		for (Co_so cs : id_cs) {
			comboModel.addElement(cs.getID_CoSo());
		}
		jcombo_CS = new JComboBox(comboModel);
		jcombo_CS.setFont(new Font("Tahoma", Font.PLAIN, 20));
		jcombo_CS.setBounds(110, 55, 100, 40);
		pn_cs.add(jcombo_CS);	

		JButton btnNewButton = new JButton("Xem danh sách");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ngay_da.getDate()==null) {
					JOptionPane.showMessageDialog(null, "Vui long nhập đầy đủ thông tin!");
				}
				else {
					SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd");
					String date_format = sp.format(ngay_da.getDate());	
					list = dat_san_dao.getInterface()
							.select_by_condition_2("iD_CoSo='" + jcombo_CS.getItemAt(jcombo_CS.getSelectedIndex()) + "' and NgayDa = '"+date_format+"'" );
					model = (DefaultTableModel) table.getModel();
					model.setRowCount(0);
					showTable();
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(480, 57, 151, 40);
		pn_cs.add(btnNewButton);
		
		ngay_da = new JDateChooser();
		ngay_da.setBounds(307, 55, 146, 40);
		pn_cs.add(ngay_da);
		
		JLabel lb_maCS_1 = new JLabel("Ngày:");
		lb_maCS_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lb_maCS_1.setBounds(253, 60, 60, 27);
		pn_cs.add(lb_maCS_1);

		JPanel pn_ds_san = new JPanel();
		pn_ds_san.setLayout(null);
		pn_ds_san.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		pn_ds_san.setBackground(Color.WHITE);
		pn_ds_san.setBounds(0, 125, 893, 377);
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
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] {}));
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 35, 893, 342);
		pn_ds_san.add(scrollPane);

		model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		model.setColumnIdentifiers(
				new Object[] { "STT", "Mã sân", "Tên sân", "Loại sân" ,"Giờ đá","Khách hàng", "SĐT"});
	}

	public void showTable() {
		int i = 1;
		for (dat_san dt : list) {
			model.addRow(new Object[] { i++, dt.getMa_san(), dt.getTen_san(),dt.getLoai_san(),dt.getGio_bat_dau(),dt.getTen_kh(),dt.getSdt()
					});
		}
	}

	public boolean check_thoi_gian_Da(Date h_da, Date h_nghi) {
		return true;
	}
}
