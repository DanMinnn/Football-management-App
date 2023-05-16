package Admin;

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

import Controller.KhachHangController;
import Main.dao.NhanVienDAO;
import Main.dao.KhachHangDAO;
import Main.dao.san_bong_dao;
import Main.model.NhanVien;
import Main.model.khach_hang;
import Main.model.san_bong;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import javax.swing.JRadioButton;

public class Khach_hang extends JPanel {
	
	
	public JTable table_KH;
	DefaultTableModel model_tabel;
	
	public JTextField txt_hoTenKH;
	public JTextField txt_ID_sDT_KH;
	
	/**
	 * Create the panel.
	 */
	ArrayList<khach_hang> khachHangList = new ArrayList();
	private JTextField txt_timSDT;
	
	
	public Khach_hang() {
		initKhachHang();
		model_tabel = (DefaultTableModel) table_KH.getModel();
		
		showKhachHang();
	}
	

	public void LoadData() {
		model_tabel = (DefaultTableModel) table_KH.getModel();
		model_tabel.setRowCount(0);
		
		for (khach_hang khach_hang : khachHangList) {
			model_tabel.addRow(new Object[] {model_tabel.getRowCount() + 1, khach_hang.getHoTen(), khach_hang.getSoDienThoai()});
		}
	}
	
	private void showKhachHang() {	
		khachHangList = KhachHangDAO.getInstance().selectALL();
		
		LoadData();
		
//		model_tabel.setRowCount(0);
//		
//		khachHangList.forEach((khachhang) -> {
//			model_tabel.addRow(new Object[] {khachhang.getMaKhachHang(), khachhang.getTen(),
//					 khachhang.getSDT(), khachhang.getGioiTinh()});
//		});
}	
	public void initKhachHang() {
		setBackground(new Color(128, 128, 128));
		setBounds(0, 0, 893, 713);
		setLayout(null);
		
		ActionListener action = new KhachHangController(this);
		
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
		
		JLabel label_hoTenKH = new JLabel("Họ và tên:");
		label_hoTenKH.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_hoTenKH.setBounds(20, 74, 79, 27);
		pn_TT_nv.add(label_hoTenKH);
		
		txt_hoTenKH = new JTextField();
		txt_hoTenKH.setHorizontalAlignment(SwingConstants.LEFT);
		txt_hoTenKH.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt_hoTenKH.setColumns(10);
		txt_hoTenKH.setBounds(99, 74, 166, 27);
		pn_TT_nv.add(txt_hoTenKH);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(255, 128, 64));
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_1_1.setBounds(0, 0, 893, 35);
		pn_TT_nv.add(panel_1_1);
		
		JLabel lblNewLabel = new JLabel(" Thông tin khách hàng");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBackground(Color.LIGHT_GRAY);
		lblNewLabel.setBounds(1, 1, 299, 35);
		panel_1_1.add(lblNewLabel);
		
		JButton Button_ThemKH = new JButton("Thêm");
		Button_ThemKH.addActionListener(action);
		Button_ThemKH.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Button_ThemKH.setBounds(292, 256, 107, 46);
		pn_TT_nv.add(Button_ThemKH);
		
		JButton Button_CapNhat = new JButton("Cập nhật");
		Button_CapNhat.addActionListener(action);
		Button_CapNhat.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Button_CapNhat.setBounds(433, 256, 107, 46);
		pn_TT_nv.add(Button_CapNhat);
		
		JButton btnSave = new JButton("Lưu");
		btnSave.addActionListener(action);
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSave.setBounds(574, 256, 97, 46);
		pn_TT_nv.add(btnSave);
		
		JButton btnDelete = new JButton("Xóa");
		btnDelete.addActionListener(action);
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDelete.setBounds(701, 256, 97, 46);
		pn_TT_nv.add(btnDelete);
		
		JLabel label_SDT_KH = new JLabel("SĐT:");
		label_SDT_KH.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_SDT_KH.setBounds(50, 132, 39, 27);
		pn_TT_nv.add(label_SDT_KH);
		
		txt_ID_sDT_KH = new JTextField();
		txt_ID_sDT_KH.setHorizontalAlignment(SwingConstants.LEFT);
		txt_ID_sDT_KH.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt_ID_sDT_KH.setColumns(10);
		txt_ID_sDT_KH.setBounds(99, 132, 166, 27);
		pn_TT_nv.add(txt_ID_sDT_KH);
		
		JPanel pn_cs = new JPanel();
		pn_cs.setLayout(null);
		pn_cs.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		pn_cs.setBackground(Color.WHITE);
		pn_cs.setBounds(0, 0, 893, 125);
		panel_main.add(pn_cs);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setBackground(new Color(255, 128, 64));
		panel_1_1_1.setLayout(null);
		panel_1_1_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_1_1_1.setBounds(0, 0, 893, 35);
		pn_cs.add(panel_1_1_1);
		
		JLabel lblDanhSchSn = new JLabel("Khách hàng");
		lblDanhSchSn.setForeground(Color.BLACK);
		lblDanhSchSn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDanhSchSn.setBackground(Color.LIGHT_GRAY);
		lblDanhSchSn.setBounds(10, 0, 112, 35);
		panel_1_1_1.add(lblDanhSchSn);
		
		JLabel lblNewLabel_4_1 = new JLabel("");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4_1.setBounds(110, 233, 157, 27);
		pn_cs.add(lblNewLabel_4_1);
			
		JLabel lb_SĐT_TK = new JLabel("SĐT:");
		lb_SĐT_TK.setBounds(42, 55, 39, 27);
		pn_cs.add(lb_SĐT_TK);
		lb_SĐT_TK.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton btnFind = new JButton("Find");
		btnFind.addActionListener(action);
		btnFind.setBounds(264, 51, 85, 35);
		pn_cs.add(btnFind);
		btnFind.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		txt_timSDT = new JTextField();
		txt_timSDT.setBounds(84, 55, 138, 25);
		pn_cs.add(txt_timSDT);
		txt_timSDT.setColumns(10);
		
		
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
		
		JLabel lblDanhSchSn_1 = new JLabel(" Danh sách khách hàng ");
		lblDanhSchSn_1.setForeground(new Color(0, 0, 0));
		lblDanhSchSn_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDanhSchSn_1.setBackground(Color.LIGHT_GRAY);
		lblDanhSchSn_1.setBounds(1, 1, 299, 35);
		panel_1_1_1_1.add(lblDanhSchSn_1);
		
		table_KH = new JTable();
		table_KH.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		)); 
		JScrollPane scrollPane = new JScrollPane(table_KH);
		scrollPane.setBounds(0, 35, 893, 215);
		pn_ds_nv.add(scrollPane);
		
		 model_tabel = (DefaultTableModel) table_KH.getModel();
		 model_tabel.setRowCount(0); 
		 model_tabel.setColumnIdentifiers(new Object[] {
			"STT","Họ và tên","Số điện thoại"
		});	
		 
		table_KH.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (table_KH.getSelectedRow() >= 0) {
					txt_hoTenKH.setText(table_KH.getValueAt(table_KH.getSelectedRow(), 1) + "");
					txt_ID_sDT_KH.setText(table_KH.getValueAt(table_KH.getSelectedRow(), 2) + "");
				}

			}
		});
	}


	public void xoaForm() {
		txt_hoTenKH.setText("");
		txt_ID_sDT_KH.setText("");
	}

	public khach_hang getKhachHangDangChon() {
		DefaultTableModel model_table = (DefaultTableModel) table_KH.getModel();
		int i_row = table_KH.getSelectedRow();
		
		String hoTen = model_table.getValueAt(i_row, 1)+"";
		String ID_sDT = model_table.getValueAt(i_row, 2)+"";

		khach_hang kh = new khach_hang(hoTen, ID_sDT);
		return kh;
	}
	
	public void themKhachHang(khach_hang kh) {
		KhachHangDAO.getInstance().insert(kh);
		
		showKhachHang();
	}


	public void capNhatKhachHang() {
		String iD_SDT = txt_ID_sDT_KH.getText();
		String hoTen = txt_hoTenKH.getText();
		
		khach_hang kh = new khach_hang(iD_SDT, hoTen);
		
		KhachHangDAO.getInstance().update(kh,hoTen);
		
		showKhachHang();
		
	}


	public void xoaKhachHang() {
		DefaultTableModel model_table = (DefaultTableModel) table_KH.getModel();
		int i_row = table_KH.getSelectedRow();
		
		int option = JOptionPane.showConfirmDialog(this, "Bạn có chắn chắn xóa khách hàng này ?");
		if(option == JOptionPane.YES_OPTION) {
			khach_hang kh = getKhachHangDangChon();
			KhachHangDAO.getInstance().delete(kh, null);
			model_table.removeRow(i_row);
		}
		
	}


	public void TimKhachHang() {
		String sDT = txt_timSDT.getText();
		if(sDT != null && sDT.length() > 0) {
			
			khachHangList = KhachHangDAO.getInstance().select_by_condition(sDT);
			
			LoadData();
			
		}else {
			showKhachHang();
		}
		
	}
}
