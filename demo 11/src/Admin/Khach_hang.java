package Admin;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.MatteBorder;
import java.awt.Font;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import Main.dao.san_bong_dao;
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
	private JTextField txt_ten_nv;
	
	private JTable table;
	private DefaultTableModel model;
	
	private JTextField txt_SĐT_nv_tk;
	private JTextField txt_id_nv;
	private JTextField txt_sdt_nv;
	/**
	 * Create the panel.
	 */
	public Khach_hang() {
		setBackground(new Color(128, 128, 128));
		setBounds(0, 0, 893, 713);
		setLayout(null);
		
		JPanel panel_main = new JPanel();
		panel_main.setBounds(0, 0, 893, 713);
		add(panel_main);
		panel_main.setLayout(null);
		
		JPanel pn_TT_nv = new JPanel();
		pn_TT_nv.setLayout(null);
		pn_TT_nv.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		pn_TT_nv.setBackground(Color.WHITE);
		pn_TT_nv.setBounds(0, 375, 447, 328);
		panel_main.add(pn_TT_nv);
		
		JLabel lb_hovaten_nv = new JLabel("Họ và tên:");
		lb_hovaten_nv.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lb_hovaten_nv.setBounds(20, 95, 79, 27);
		pn_TT_nv.add(lb_hovaten_nv);
		
		txt_ten_nv = new JTextField();
		txt_ten_nv.setHorizontalAlignment(SwingConstants.LEFT);
		txt_ten_nv.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt_ten_nv.setColumns(10);
		txt_ten_nv.setBounds(99, 95, 166, 27);
		pn_TT_nv.add(txt_ten_nv);
		
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
		
		JButton bt_update_nv = new JButton("Lưu KH");
		bt_update_nv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		bt_update_nv.setFont(new Font("Tahoma", Font.PLAIN, 16));
		bt_update_nv.setBounds(558, 256, 97, 46);
		pn_TT_nv.add(bt_update_nv);
		
		JButton bt_delete_san = new JButton("Xoá KH");
		bt_delete_san.setFont(new Font("Tahoma", Font.PLAIN, 16));
		bt_delete_san.setBounds(665, 256, 97, 46);
		pn_TT_nv.add(bt_delete_san);
		
		JButton bt_add_nv = new JButton("Thêm KH");
		bt_add_nv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){		
			}
		});
		bt_add_nv.setFont(new Font("Tahoma", Font.PLAIN, 16));
		bt_add_nv.setBounds(441, 256, 107, 46);
		pn_TT_nv.add(bt_add_nv);
		
		JLabel lb_ID_nv = new JLabel("ID:");
		lb_ID_nv.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lb_ID_nv.setBounds(20, 58, 39, 27);
		pn_TT_nv.add(lb_ID_nv);
		
		txt_id_nv = new JTextField();
		txt_id_nv.setHorizontalAlignment(SwingConstants.LEFT);
		txt_id_nv.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt_id_nv.setColumns(10);
		txt_id_nv.setBounds(99, 58, 166, 27);
		pn_TT_nv.add(txt_id_nv);
		
		JLabel lb_dia_chi_nv_1 = new JLabel("SĐT:");
		lb_dia_chi_nv_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lb_dia_chi_nv_1.setBounds(20, 132, 39, 27);
		pn_TT_nv.add(lb_dia_chi_nv_1);
		
		txt_sdt_nv = new JTextField();
		txt_sdt_nv.setHorizontalAlignment(SwingConstants.LEFT);
		txt_sdt_nv.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt_sdt_nv.setColumns(10);
		txt_sdt_nv.setBounds(99, 132, 166, 27);
		pn_TT_nv.add(txt_sdt_nv);
		
		JPanel pn_cs = new JPanel();
		pn_cs.setLayout(null);
		pn_cs.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		pn_cs.setBackground(Color.WHITE);
		pn_cs.setBounds(0, 0, 447, 125);
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
		
		txt_SĐT_nv_tk = new JTextField();
		txt_SĐT_nv_tk.setBounds(78, 55, 166, 27);
		pn_cs.add(txt_SĐT_nv_tk);
		txt_SĐT_nv_tk.setHorizontalAlignment(SwingConstants.LEFT);
		txt_SĐT_nv_tk.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt_SĐT_nv_tk.setColumns(10);
		
		JButton bt_tim_nv = new JButton("Tìm KH");
		bt_tim_nv.setBounds(264, 51, 85, 35);
		pn_cs.add(bt_tim_nv);
		bt_tim_nv.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		
		JPanel pn_ds_nv = new JPanel();
		pn_ds_nv.setLayout(null);
		pn_ds_nv.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		pn_ds_nv.setBackground(Color.WHITE);
		pn_ds_nv.setBounds(0, 125, 447, 250);
		panel_main.add(pn_ds_nv);
		
		JPanel panel_1_1_1_1 = new JPanel();
		panel_1_1_1_1.setBackground(new Color(255, 128, 64));
		panel_1_1_1_1.setLayout(null);
		panel_1_1_1_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_1_1_1_1.setBounds(0, 0, 447, 35);
		pn_ds_nv.add(panel_1_1_1_1);
		
		JLabel lblDanhSchSn_1 = new JLabel(" Danh sách nhân viên ");
		lblDanhSchSn_1.setForeground(new Color(0, 0, 0));
		lblDanhSchSn_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDanhSchSn_1.setBackground(Color.LIGHT_GRAY);
		lblDanhSchSn_1.setBounds(1, 1, 299, 35);
		panel_1_1_1_1.add(lblDanhSchSn_1);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			int i = table.getSelectedRow();
			TableModel model_table= table.getModel();
			txt_ten_nv.setText(model_table.getValueAt(i,2).toString());		
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		)); 
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 35, 447, 215);
		pn_ds_nv.add(scrollPane);
		
		 model = (DefaultTableModel) table.getModel();
		 model.setRowCount(0); 
		 model.setColumnIdentifiers(new Object[] {
			"STT","ID","Họ và tên","Số điện thoại" 
		});	
	}
	
	
}
