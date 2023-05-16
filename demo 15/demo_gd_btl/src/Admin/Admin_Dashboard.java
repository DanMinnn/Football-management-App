package Admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import Co_so.*;
import Main.model.NhanVien;
import Main.model.sign_in_user;
import sign_in.demo_login_admin;
import sign_in.demo_login_user;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.management.loading.PrivateClassLoader;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Admin_Dashboard extends JFrame {

	private JPanel contentPane;
	private Khach_hang kh;
	private Nhan_vien nv ;
	private San_bong CS;
	
	private Lich_dat ld;
	private JLabel lb_name_admin;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try{
					Admin_Dashboard frame = new Admin_Dashboard();
					frame.setVisible(true);
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Admin_Dashboard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 750);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(58, 105, 56));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		CS = new San_bong();
		nv = new Nhan_vien();
		kh = new Khach_hang();
		ld = new Lich_dat();
		
		JPanel panel_menu = new JPanel();
		panel_menu.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		panel_menu.setBackground(new Color(0, 128, 64));
		panel_menu.setBounds(0, 0, 190, 713);
		contentPane.add(panel_menu);
		panel_menu.setLayout(null);
		
		JLabel lb_icon_admin = new JLabel("");
		Image icon_admin = new ImageIcon(this.getClass().getResource("/admin 94.png")).getImage();
		lb_icon_admin.setIcon(new ImageIcon(icon_admin));
		lb_icon_admin.setBounds(44, 21, 96, 103);
		panel_menu.add(lb_icon_admin);
		Image icon_home = new ImageIcon(this.getClass().getResource("/icon home.png")).getImage();
		
		JPanel panel_Coso = new JPanel();
		panel_Coso.setBorder(new LineBorder(new Color(192, 192, 192)));
		panel_Coso.setBackground(new Color(62, 142, 62));
		panel_Coso.addMouseListener(new PanelButtonMounseAdapter(panel_Coso) {
			@Override
			public void mouseClicked(MouseEvent e) {
			menuClicked(CS);
			}
		});
		panel_Coso.setBounds(0, 170, 190, 60);
		panel_menu.add(panel_Coso);
		panel_Coso.setLayout(null);
		
		JLabel lb_Coso_1 = new JLabel("Sân bóng");
		lb_Coso_1.setHorizontalAlignment(SwingConstants.CENTER);
		lb_Coso_1.setForeground(Color.WHITE);
		lb_Coso_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lb_Coso_1.setBounds(63, 10, 93, 40);
		panel_Coso.add(lb_Coso_1);
		
		JLabel lblNewLabel_2_3 = new JLabel("");
		Image icon_cs = new ImageIcon(this.getClass().getResource("/icon cơ sở.png")).getImage();
		lblNewLabel_2_3.setIcon(new ImageIcon(icon_cs));
		lblNewLabel_2_3.setForeground(Color.WHITE);
		lblNewLabel_2_3.setBounds(20, 10, 45, 40);
		panel_Coso.add(lblNewLabel_2_3);
		
		JPanel panel_add_CS = new JPanel();
		panel_add_CS.setBorder(new LineBorder(new Color(192, 192, 192)));
		panel_add_CS.setBackground(new Color(62, 142, 62));
		panel_add_CS.addMouseListener(new PanelButtonMounseAdapter(panel_add_CS) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(ld);
			}
		});
		panel_add_CS.setBounds(0, 290, 190, 60);
		panel_menu.add(panel_add_CS);
		panel_add_CS.setLayout(null);
		
		JLabel lb_Coso_2 = new JLabel("Lịch đặt sân ");
		lb_Coso_2.setHorizontalAlignment(SwingConstants.CENTER);
		lb_Coso_2.setForeground(Color.WHITE);
		lb_Coso_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lb_Coso_2.setBounds(60, 10, 110, 40);
		panel_add_CS.add(lb_Coso_2);
		
		Image icon_them_cs = new ImageIcon(this.getClass().getResource("/co so.png")).getImage();
		JLabel lblNewLabel_2_2 = new JLabel("");
		lblNewLabel_2_2.setIcon(new ImageIcon(icon_them_cs));
		lblNewLabel_2_2.setForeground(Color.WHITE);
		lblNewLabel_2_2.setBounds(10, 10, 48, 40);
		panel_add_CS.add(lblNewLabel_2_2);
		
		JPanel panel_NV = new JPanel();
		panel_NV.setBorder(new LineBorder(new Color(192, 192, 192)));
		panel_NV.setBackground(new Color(0, 128, 0));
		panel_NV.addMouseListener(new PanelButtonMounseAdapter(panel_NV) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(nv);
			}
		});
		panel_NV.setBounds(0, 230, 190, 60);
		panel_menu.add(panel_NV);
		panel_NV.setLayout(null);
		
		JLabel lb_Coso_3 = new JLabel("Nhân viên");
		lb_Coso_3.setHorizontalAlignment(SwingConstants.CENTER);
		lb_Coso_3.setForeground(Color.WHITE);
		lb_Coso_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lb_Coso_3.setBounds(60, 10, 110, 40);
		panel_NV.add(lb_Coso_3);
		
		Image icon_nv = new ImageIcon(this.getClass().getResource("/nhan vien.png")).getImage();
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setIcon(new ImageIcon(icon_nv));
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setBounds(20, 10, 45, 40);
		panel_NV.add(lblNewLabel_2_1);
		
		JPanel panel_signout = new JPanel();
		panel_signout.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_signout.setBackground(new Color(128, 128, 128));
		panel_signout.addMouseListener(new PanelButtonMounseAdapter(panel_signout));
		panel_signout.setBounds(0, 631, 190, 60);
		panel_menu.add(panel_signout);
		panel_signout.setLayout(null);
		
		//________________SIGN OUT_________________________
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		Image icon_signout = new ImageIcon(this.getClass().getResource("/sign out.png")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(icon_signout));
		lblNewLabel_2.setBounds(20, 10, 38, 40);
		panel_signout.add(lblNewLabel_2);
		
		JLabel lb_exit = new JLabel("SIGN OUT");
		lb_exit.setHorizontalAlignment(SwingConstants.CENTER);
		lb_exit.addMouseListener(new PanelButtonMounseAdapter(panel_signout){
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Bạn muốn đăng xuất?","Xác nhận",JOptionPane.YES_NO_OPTION)== 0) {
					demo_login_admin frame_signin = new demo_login_admin();
					frame_signin.setVisible(true);
					Admin_Dashboard.this.dispose();
				}	
			}
		});
		lb_exit.setForeground(Color.WHITE);
		lb_exit.setFont(new Font("Tahoma", Font.BOLD, 15));
		lb_exit.setBounds(57, 10, 80, 40);
		panel_signout.add(lb_exit);
		
		lb_name_admin = new JLabel("");
		lb_name_admin.setHorizontalAlignment(SwingConstants.CENTER);
		lb_name_admin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lb_name_admin.setForeground(new Color(255, 255, 255));
		lb_name_admin.setBounds(10, 120, 170, 30);
		panel_menu.add(lb_name_admin);
		
		JLabel lb_admin = new JLabel("");
		lb_admin.setBounds(0, 0, 190, 170);
		panel_menu.add(lb_admin);
		
		JPanel panel_KH = new JPanel();
		panel_KH.addMouseListener(new PanelButtonMounseAdapter(panel_KH) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(kh);
			}
		});
		panel_KH.setLayout(null);
		panel_KH.setBorder(new LineBorder(new Color(192, 192, 192)));
		panel_KH.setBackground(new Color(0, 128, 0));
		panel_KH.setBounds(0, 349, 190, 60);
		panel_menu.add(panel_KH);
		
		JLabel lb_Coso_3_1 = new JLabel("Khách hàng");
		lb_Coso_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lb_Coso_3_1.setForeground(Color.WHITE);
		lb_Coso_3_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lb_Coso_3_1.setBounds(60, 10, 110, 40);
		panel_KH.add(lb_Coso_3_1);
		
		JLabel lb_icon_kh = new JLabel("");
		lb_icon_kh.setForeground(Color.WHITE);
		lb_icon_kh.setBounds(20, 10, 45, 40);
		panel_KH.add(lb_icon_kh);
		Image icon_kh = new ImageIcon(this.getClass().getResource("/khach hang.png")).getImage();
		lb_icon_kh.setIcon(new ImageIcon(icon_kh));
		//__________________CONTROLLER____________________
		JPanel panel_Main_content = new JPanel();
		panel_Main_content.setBounds(193, 0, 893, 713);
		contentPane.add(panel_Main_content);
		panel_Main_content.setLayout(null);
        
		
		panel_Main_content.add(CS);
		panel_Main_content.add(kh);
		panel_Main_content.add(ld);
		panel_Main_content.add(nv);
		
		 menuClicked(CS);
	}
	// _______LẤY RA TÊN USERNAME _______________	
	public void set_adminname(String adminname) {
		this.lb_name_admin.setText(adminname);
	}
	
	
	public void menuClicked(JPanel panel) {
		CS.setVisible(false);
		nv.setVisible(false);
	    kh.setVisible(false);
	    ld.setVisible(false);
		panel.setVisible(true);
	}
	
		private class PanelButtonMounseAdapter extends MouseAdapter{
			JPanel panel;
			public	PanelButtonMounseAdapter(JPanel panel) {
				this.panel=panel;
			}							
			@Override
			public void mousePressed(MouseEvent e) {
				panel.setBackground(new Color(112,128,144));
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				panel.setBackground(new Color(44,79,79));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel.setBackground(new Color(62,142,62));
			}
			@Override
			public void  mouseReleased(MouseEvent e) {
				panel.setBackground(new Color(112,128,144));
			}	
	  }
}
