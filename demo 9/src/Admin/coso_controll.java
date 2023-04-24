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

public class coso_controll extends JPanel {
	private JTextField txt_CS;
	private JTextField txt_ten_san;
	
	private JTextField txt_tg_batdau;
	private JTextField txt_tg_ketthuc;
	
	private JComboBox<String> jcombo_CS;
	private JTextField txt_loai_san;
	private JTextField txt_trang_thai;
	private JDateChooser ngay_da;
	
	private JTable table;
	private DefaultTableModel model;
	
	private ArrayList<san_bong> list;
	
	/**
	 * Create the panel.
	 */
	public coso_controll() {
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
		
		txt_CS = new JTextField();
		txt_CS.setHorizontalAlignment(SwingConstants.LEFT);
		txt_CS.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt_CS.setColumns(10);
		txt_CS.setBounds(110, 53, 166, 27);
		pn_TT_san.add(txt_CS);
		
		JLabel lb_Ten_san = new JLabel("Tên sân:");
		lb_Ten_san.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lb_Ten_san.setBounds(20, 90, 79, 27);
		pn_TT_san.add(lb_Ten_san);
		
		txt_ten_san = new JTextField();
		txt_ten_san.setHorizontalAlignment(SwingConstants.LEFT);
		txt_ten_san.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt_ten_san.setColumns(10);
		txt_ten_san.setBounds(110, 90, 166, 27);
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
		lb_ngay_da.setBounds(20, 130, 79, 27);
		pn_TT_san.add(lb_ngay_da);
		
		// Ngày đá
		 ngay_da = new JDateChooser();
		ngay_da.setBounds(110, 130, 166, 27);
		pn_TT_san.add(ngay_da);
		
		JLabel lb_TG_bat_dau = new JLabel("Bắt đầu:");
		lb_TG_bat_dau.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lb_TG_bat_dau.setBounds(20, 170, 79, 27);
		pn_TT_san.add(lb_TG_bat_dau);
		
		txt_tg_batdau = new JTextField();
		txt_tg_batdau.setHorizontalAlignment(SwingConstants.CENTER);
		txt_tg_batdau.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt_tg_batdau.setColumns(10);
		txt_tg_batdau.setBounds(110, 167, 166, 27);
		pn_TT_san.add(txt_tg_batdau);
		
		JLabel lb_TG_ket_thua = new JLabel("kết thúc:");
		lb_TG_ket_thua.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lb_TG_ket_thua.setBounds(20, 210, 79, 27);
		pn_TT_san.add(lb_TG_ket_thua);
		
		txt_tg_ketthuc = new JTextField();
		txt_tg_ketthuc.setHorizontalAlignment(SwingConstants.CENTER);
		txt_tg_ketthuc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt_tg_ketthuc.setColumns(10);
		txt_tg_ketthuc.setBounds(110, 210, 166, 27);
		pn_TT_san.add(txt_tg_ketthuc);
		
		JButton bt_update_san = new JButton("Lưu ");
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
		
		JLabel lb_trang_thai = new JLabel("Trạng thái");
		lb_trang_thai.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lb_trang_thai.setBounds(324, 90, 79, 27);
		pn_TT_san.add(lb_trang_thai);
		
		JButton bt_add_san = new JButton("Thêm sân");
		bt_add_san.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){		
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
		txt_loai_san.setHorizontalAlignment(SwingConstants.CENTER);
		txt_loai_san.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt_loai_san.setColumns(10);
		txt_loai_san.setBounds(403, 48, 71, 27);
		pn_TT_san.add(txt_loai_san);
		
		txt_trang_thai = new JTextField();
		txt_trang_thai.setHorizontalAlignment(SwingConstants.CENTER);
		txt_trang_thai.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt_trang_thai.setColumns(10);
		txt_trang_thai.setBounds(403, 90, 69, 27);
		pn_TT_san.add(txt_trang_thai);
		
		JButton bt_tim_san = new JButton("Tìm sân");
		bt_tim_san.setFont(new Font("Tahoma", Font.PLAIN, 16));
		bt_tim_san.setBounds(379, 233, 107, 46);
		pn_TT_san.add(bt_tim_san);
		
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
				list = san_bong_dao.getInterface().select_by_condition("maCS ='"+jcombo_CS.getItemAt(jcombo_CS.getSelectedIndex())+"'");
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
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			int i = table.getSelectedRow();
			TableModel model_table= table.getModel();
			txt_CS.setText(model_table.getValueAt(i,1).toString());
			txt_ten_san.setText(model_table.getValueAt(i,2).toString());
			txt_loai_san.setText(model_table.getValueAt(i,3).toString());
			//txt_tg_batdau.setText(model_table.getValueAt(i,4).toString());
			//txt_tg_ketthuc.setText(model_table.getValueAt(i,5).toString());
			txt_trang_thai.setText(model_table.getValueAt(i, 6).toString());			
			try {
				int srow = table.getSelectedRow();
				Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String)model_table.getValueAt(srow, 4));
				ngay_da.setDate(date);
			} catch (Exception e2) {
				 JOptionPane.showMessageDialog(null, e2);
			}
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		)); 
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 35, 893, 215);
		pn_ds_san.add(scrollPane);
		
		 model = (DefaultTableModel) table.getModel();
		 model.setRowCount(0); 
		 model.setColumnIdentifiers(new Object[] {
			"STT","Mã cơ sở", "Tên sân","Loại sân", "Ngày đá", "Thời gian", "Trạng thái"	 
		});	
	}
	int i = 1;
	public void showTable() {
		for(san_bong sb : list) {
			model.addRow(new Object[] {
					i++,
					sb.getMa_San(),
					sb.getTen_san(),
					sb.getLoai_san(),
					sb.getNgay_da(),
					sb.getThoi_gian_da(),
					sb.getTrang_thai_san()	
				});
		}
	}
}
