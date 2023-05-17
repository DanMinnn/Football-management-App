package Admin;

import java.awt.Button;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.MatteBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.Font;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import Controller.NhanVienController;
import Main.dao.Co_so_dao;
import Main.dao.NhanVienDAO;
import Main.dao.san_bong_dao;
import Main.model.Co_so;
import Main.model.NhanVien;
import Main.model.QLNV;
import Main.model.san_bong;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JScrollPane;


import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.sql.Date;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Nhan_vien extends JPanel {
	
	public 	QLNV model;
	private JComboBox<String> jcombo_CS;
	private JComboBox<String> jcombo_CS_nv;
	
	public JTable table_NhanVien;
	DefaultTableModel tableModel;
	
	public JTextField txt_hoTen;
	public JTextField txt_timTen;
	public JTextField txt_ID;
	public JTextField txt_SĐT;
	public JTextField txt_diaChi;
	public JTextField txt_NamSinh;
	public JComboBox<String> comboBox_gioiTinh;
	
	private ArrayList<NhanVien> nhanVienList = new ArrayList();
	private ArrayList<Co_so> id_cs;

	
	/**
	 * Create the panel.
	 */
	
	public Nhan_vien() {
		initComponents();
		tableModel = (DefaultTableModel) table_NhanVien.getModel();	
		
		showNV();
	}
	
	public void LoadData() {
		
		tableModel = (DefaultTableModel) table_NhanVien.getModel();	
		tableModel.setRowCount(0);
		
		nhanVienList.forEach((nhanvien) -> {
			tableModel.addRow(new Object[] {nhanvien.getID(), nhanvien.getHoTen(),
					 nhanvien.getGioiTinh(), nhanvien.getNamSinh(), nhanvien.getSDT(), nhanvien.getDiaChi()});
		});
	}
	
	private void showNV() {	
		nhanVienList = NhanVienDAO.getInstance().selectALL();
		
		LoadData();
		
}

	public void initComponents() {
		setBackground(new Color(128, 128, 128));
		setBounds(0, 0, 893, 713);
		setLayout(null);
		
		ActionListener action = new NhanVienController(this);
		id_cs = new ArrayList<>();
		
		
		JPanel panel_main = new JPanel();
		panel_main.setBounds(0, 0, 893, 713);
		add(panel_main);
		panel_main.setLayout(null);
		
		JPanel pn_TT_nv = new JPanel();
		pn_TT_nv.setLayout(null);
		pn_TT_nv.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		pn_TT_nv.setBackground(Color.WHITE);
		pn_TT_nv.setBounds(0, 375, 893, 328);
		panel_main.add(pn_TT_nv);
		
		JLabel lb_maCS = new JLabel("Mã cơ sở:");
		lb_maCS.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lb_maCS.setBounds(20, 63, 69, 27);
		pn_TT_nv.add(lb_maCS);
		
		JLabel lb_hovaten_nv = new JLabel("Họ và tên:");
		lb_hovaten_nv.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lb_hovaten_nv.setBounds(20, 141, 79, 27);
		pn_TT_nv.add(lb_hovaten_nv);
		
		txt_hoTen = new JTextField();
		txt_hoTen.setHorizontalAlignment(SwingConstants.LEFT);
		txt_hoTen.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt_hoTen.setColumns(10);
		txt_hoTen.setBounds(99, 141, 166, 27);
		pn_TT_nv.add(txt_hoTen);
		
		JLabel lb_ID_nv = new JLabel("ID:");
		lb_ID_nv.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lb_ID_nv.setBounds(20, 104, 39, 27);
		pn_TT_nv.add(lb_ID_nv);
		
		txt_ID = new JTextField();
		txt_ID.setHorizontalAlignment(SwingConstants.LEFT);
		txt_ID.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt_ID.setColumns(10);
		txt_ID.setBounds(99, 100, 166, 27);
		pn_TT_nv.add(txt_ID);
		
		JLabel lb_dia_chi_nv_1 = new JLabel("SĐT:");
		lb_dia_chi_nv_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lb_dia_chi_nv_1.setBounds(397, 141, 39, 27);
		pn_TT_nv.add(lb_dia_chi_nv_1);
		
		txt_SĐT = new JTextField();
		txt_SĐT.setHorizontalAlignment(SwingConstants.LEFT);
		txt_SĐT.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt_SĐT.setColumns(10);
		txt_SĐT.setBounds(486, 141, 166, 27);
		pn_TT_nv.add(txt_SĐT);
		
		JLabel txt_gender = new JLabel("Phái:");
		txt_gender.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt_gender.setBounds(20, 180, 54, 27);
		pn_TT_nv.add(txt_gender);
		
		comboBox_gioiTinh = new JComboBox<String>();
		comboBox_gioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBox_gioiTinh.setBounds(99, 181, 87, 28);
		pn_TT_nv.add(comboBox_gioiTinh);
		
		comboBox_gioiTinh.addItem("Nam");
		comboBox_gioiTinh.addItem("Nữ");
		
		JLabel lb_diaChi = new JLabel("Địa chỉ");
		lb_diaChi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lb_diaChi.setBounds(397, 186, 79, 27);
		pn_TT_nv.add(lb_diaChi);
		
		txt_diaChi = new JTextField();
		txt_diaChi.setHorizontalAlignment(SwingConstants.LEFT);
		txt_diaChi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt_diaChi.setColumns(10);
		txt_diaChi.setBounds(486, 186, 298, 27);
		pn_TT_nv.add(txt_diaChi);
		
		txt_NamSinh = new JTextField();
		txt_NamSinh.setHorizontalAlignment(SwingConstants.LEFT);
		txt_NamSinh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt_NamSinh.setColumns(10);
		txt_NamSinh.setBounds(486, 100, 166, 27);
		pn_TT_nv.add(txt_NamSinh);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(255, 128, 64));
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_1_1.setBounds(0, 0, 893, 35);
		pn_TT_nv.add(panel_1_1);
		
		JLabel lblNewLabel = new JLabel(" Thông tin nhân viên");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBackground(Color.LIGHT_GRAY);
		lblNewLabel.setBounds(1, 1, 299, 35);
		panel_1_1.add(lblNewLabel);
		
		JLabel lb_date = new JLabel("Năm sinh:");
		lb_date.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lb_date.setBounds(397, 100, 79, 27);
		pn_TT_nv.add(lb_date);
		
		JButton bt_add_nv = new JButton("Thêm");
		bt_add_nv.addActionListener(action);
		bt_add_nv.setFont(new Font("Tahoma", Font.PLAIN, 16));
		bt_add_nv.setBounds(265, 256, 107, 46);
		pn_TT_nv.add(bt_add_nv);
		
		JButton bt_CapNhat = new JButton("Cập nhật");
		bt_CapNhat.addActionListener(action);
		bt_CapNhat.setFont(new Font("Tahoma", Font.PLAIN, 16));
		bt_CapNhat.setBounds(413, 256, 107, 46);
		pn_TT_nv.add(bt_CapNhat);
		
		JButton bt_Luu = new JButton("Lưu");
		bt_Luu.addActionListener(action);
		bt_Luu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		bt_Luu.setBounds(565, 256, 97, 46);
		pn_TT_nv.add(bt_Luu);
		
		JButton bt_delete_san = new JButton("Xóa");
		bt_delete_san.addActionListener(action);
		bt_delete_san.setFont(new Font("Tahoma", Font.PLAIN, 16));
		bt_delete_san.setBounds(706, 256, 97, 46);
		pn_TT_nv.add(bt_delete_san);
		
		id_cs = Co_so_dao.getInterface().selectALL();
		DefaultComboBoxModel comboModel = new DefaultComboBoxModel();
		for (Co_so cs : id_cs) {
			comboModel.addElement(cs.getID_CoSo());
		}	
		jcombo_CS_nv = new JComboBox(comboModel);
		jcombo_CS_nv.setFont(new Font("Tahoma", Font.PLAIN, 15));
     	jcombo_CS_nv.setBounds(99, 63, 102, 27);
		pn_TT_nv.add(jcombo_CS_nv);
		
		JPanel pn_cs = new JPanel();
		pn_cs.setLayout(null);
		pn_cs.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		pn_cs.setBackground(Color.WHITE);
		pn_cs.setBounds(0, 10, 893, 125);
		panel_main.add(pn_cs);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setBackground(new Color(255, 128, 64));
		panel_1_1_1.setLayout(null);
		panel_1_1_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_1_1_1.setBounds(0, 0, 893, 35);
		pn_cs.add(panel_1_1_1);
		
		JLabel lblDanhSchSn = new JLabel("Nhân viên");
		lblDanhSchSn.setForeground(Color.BLACK);
		lblDanhSchSn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDanhSchSn.setBackground(Color.LIGHT_GRAY);
		lblDanhSchSn.setBounds(10, 0, 112, 35);
		panel_1_1_1.add(lblDanhSchSn);
		
		JLabel lblNewLabel_4_1 = new JLabel("");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4_1.setBounds(110, 233, 157, 27);
		pn_cs.add(lblNewLabel_4_1);
		
		JLabel lb_cs = new JLabel("Cơ sở:");
		lb_cs.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lb_cs.setBounds(48, 51, 60, 35);
		pn_cs.add(lb_cs);
		
		DefaultComboBoxModel comboModel_maCS = new DefaultComboBoxModel();
		for (Co_so cs : id_cs) {
			comboModel_maCS.addElement(cs.getID_CoSo());
		}
		 jcombo_CS = new JComboBox(comboModel_maCS);
		 jcombo_CS.setFont(new Font("Tahoma", Font.PLAIN, 20));
		 jcombo_CS.setBounds(110, 48, 102, 41);
		 pn_cs.add(jcombo_CS);
		
		JLabel lb_ID_TK = new JLabel("Tên:");
		lb_ID_TK.setBounds(437, 55, 39, 27);
		pn_cs.add(lb_ID_TK);
		lb_ID_TK.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		txt_timTen = new JTextField();
		txt_timTen.setBounds(472, 55, 166, 27);
		pn_cs.add(txt_timTen);
		txt_timTen.setHorizontalAlignment(SwingConstants.LEFT);
		txt_timTen.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt_timTen.setColumns(10);
		
		JButton bt_tim_nv = new JButton("Tìm");
		bt_tim_nv.addActionListener(action);
		bt_tim_nv.setBounds(648, 51, 85, 35);
		pn_cs.add(bt_tim_nv);
		bt_tim_nv.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton bt_xem_ds = new JButton("Xem");
		bt_xem_ds.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				NhanVien nv = new NhanVien();
				NhanVienDAO.getInstance().SelectNhanVien("iD_CoSo = "+jcombo_CS_nv.getItemAt(jcombo_CS_nv.getSelectedIndex()));
				LoadData();
			}
		});
		bt_xem_ds.setFont(new Font("Tahoma", Font.PLAIN, 16));
		bt_xem_ds.setBounds(231, 50, 85, 35);
		pn_cs.add(bt_xem_ds);
		
		JPanel pn_ds_nv = new JPanel();
		pn_ds_nv.setLayout(null);
		pn_ds_nv.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		pn_ds_nv.setBackground(Color.WHITE);
		pn_ds_nv.setBounds(0, 125, 893, 250);
		panel_main.add(pn_ds_nv);
		
		JPanel panel_1_1_1_1 = new JPanel();
		panel_1_1_1_1.setBackground(new Color(255, 128, 64));
		panel_1_1_1_1.setLayout(null);
		panel_1_1_1_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_1_1_1_1.setBounds(0, 0, 893, 35);
		pn_ds_nv.add(panel_1_1_1_1);
		
		JLabel lblDanhSchSn_1 = new JLabel(" Danh sách nhân viên ");
		lblDanhSchSn_1.setForeground(new Color(0, 0, 0));
		lblDanhSchSn_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDanhSchSn_1.setBackground(Color.LIGHT_GRAY);
		lblDanhSchSn_1.setBounds(1, 1, 299, 35);
		panel_1_1_1_1.add(lblDanhSchSn_1);
		
		table_NhanVien = new JTable();
		table_NhanVien.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		)); 
		JScrollPane scrollPane = new JScrollPane(table_NhanVien);
		scrollPane.setBounds(0, 35, 893, 215);
		pn_ds_nv.add(scrollPane);
		
		 tableModel = (DefaultTableModel) table_NhanVien.getModel();
		 tableModel.setRowCount(0); 
		 tableModel.setColumnIdentifiers(new Object[] {
			"Mã nhân viên","Họ và tên","Phái", "Ngày sinh", "Số điện thoại",  "Địa chỉ"  
		});	
		 
		 
		table_NhanVien.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if(table_NhanVien.getSelectedRow() >= 0) {
					String gioiTinh;
					gioiTinh = comboBox_gioiTinh.getSelectedItem().toString();	
					txt_ID.setText(table_NhanVien.getValueAt(table_NhanVien.getSelectedRow(), 0) + "");
					txt_hoTen.setText(table_NhanVien.getValueAt(table_NhanVien.getSelectedRow(), 1) + "");
					String getGioiTinh = (table_NhanVien.getValueAt(table_NhanVien.getSelectedRow(), 2).toString());
					switch (getGioiTinh) {
					case "Nam": {
						comboBox_gioiTinh.setSelectedIndex(0);
						break;
					}
					case "Nữ": {
						comboBox_gioiTinh.setSelectedIndex(1);
						break;
					}
				}
					txt_NamSinh.setText(table_NhanVien.getValueAt(table_NhanVien.getSelectedRow(), 3) + "");
					txt_SĐT.setText(table_NhanVien.getValueAt(table_NhanVien.getSelectedRow(), 4) + "");
					txt_diaChi.setText(table_NhanVien.getValueAt(table_NhanVien.getSelectedRow(), 5) + "");
					txt_ID.setEnabled(false);
				}  				  
			}
		});
	}

	public void xoaForm() {
		txt_ID.setText("");
		txt_hoTen.setText("");
		txt_NamSinh.setText("");
		txt_SĐT.setText("");
		txt_diaChi.setText("");
		comboBox_gioiTinh.setSelectedItem("Nam");
		txt_ID.setEnabled(true);
	}

	public NhanVien getNhanVienDangChon() {
		DefaultTableModel model_table = (DefaultTableModel) table_NhanVien.getModel();
		int i_row = table_NhanVien.getSelectedRow();
		
		int ID = Integer.valueOf(model_table.getValueAt(i_row, 0)+"");
		String hoTen = model_table.getValueAt(i_row, 1)+"";
		String textGioiTinh = model_table.getValueAt(i_row, 2)+"";
		String s_namSinh = model_table.getValueAt(i_row, 3)+"";
		Date namSinh = Date.valueOf(s_namSinh);
		String sDT = model_table.getValueAt(i_row, 4)+"";
		String diaChi = model_table.getValueAt(i_row, 5)+"";
		
		NhanVien nv = new NhanVien(ID, hoTen, textGioiTinh, namSinh, sDT, diaChi);
		return nv;
	}
	
	public void themNhanVienVaoBang(NhanVien nv) {
		NhanVienDAO.getInstance().insert(nv);
		
		showNV();
	}
	
	public void capNhatThongTinNhanVien() {	
		int iD = Integer.valueOf(txt_ID.getText());
		String HoTen = txt_hoTen.getText();
		String gioiTinh = (String) comboBox_gioiTinh.getSelectedItem();
		String S_namSinh =  txt_NamSinh.getText();
		Date NamSinh = Date.valueOf(S_namSinh);
		String SDT = txt_SĐT.getText();
		String DiaChi = txt_diaChi.getText();
		
		NhanVien nv = new NhanVien(iD, HoTen, gioiTinh, NamSinh, SDT, DiaChi);
		
		NhanVienDAO.getInstance().update(nv,HoTen);
		
		showNV();
	}

	public void xoaNhanVien() {
		DefaultTableModel model_table = (DefaultTableModel) table_NhanVien.getModel();
		int i_row = table_NhanVien.getSelectedRow();
		
		int option = JOptionPane.showConfirmDialog(this, "Bạn có chắn chắn xóa dòng đang chọn ?");
		if(option == JOptionPane.YES_OPTION) {
			NhanVien nv = getNhanVienDangChon();
			NhanVienDAO.getInstance().delete(nv, null);
			model_table.removeRow(i_row);
		}
		
	}
	
	public void Tim() {
		String hoTen = txt_timTen.getText();
		
		if(hoTen != null && hoTen.length() > 0) {
			nhanVienList = NhanVienDAO.getInstance().select_by_condition(hoTen);
			
			LoadData();
			
		}else {
			showNV();
		}
	}
}