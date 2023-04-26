package sign_in;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import Co_so.*;
import Main.model.sign_in_user;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.management.loading.PrivateClassLoader;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Dashboard extends JFrame {

	private JPanel contentPane;
	private Home home;
	private Co_so_1 CS1;
	private Co_so_2 CS2;
	private Co_so_3 CS3;
	private JLabel lb_name_user;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard frame = new Dashboard();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Dashboard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 600);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(58, 105, 56));
		contentPane.setBorder(new LineBorder(new Color(192, 192, 192), 3));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		home = new Home();
		home.setSize(746, 562);
		CS1 = new Co_so_1();
		CS1.setSize(746, 562);
		CS2 = new Co_so_2();
		CS2.setSize(746, 562);
		CS3 = new Co_so_3();
		CS3.setSize(746, 562);
		
		JPanel panel_menu = new JPanel();
		panel_menu.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(192, 192, 192)));
		panel_menu.setBackground(new Color(43, 81, 45));
		panel_menu.setBounds(0, 0, 190, 563);
		contentPane.add(panel_menu);
		panel_menu.setLayout(null);
		
		JLabel lb_icon_user = new JLabel("");
		Image icon_user = new ImageIcon(this.getClass().getResource("/user 94.png")).getImage();
		lb_icon_user.setIcon(new ImageIcon(icon_user));
		
		lb_icon_user.setBounds(44, 21, 96, 103);
		panel_menu.add(lb_icon_user);
		
		JPanel panel_home = new JPanel();
		panel_home.setBorder(new LineBorder(new Color(192, 192, 192)));
		panel_home.setBackground(new Color(62, 142, 62));
		panel_home.addMouseListener(new PanelButtonMounseAdapter(panel_home) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(home);
			}
		});
			
		panel_home.setBounds(0, 180, 190, 60);
		panel_menu.add(panel_home);
		panel_home.setLayout(null);
		
		JLabel lb_home = new JLabel("HOME");
		lb_home.setForeground(new Color(255, 255, 255));
		lb_home.setHorizontalAlignment(SwingConstants.CENTER);
		lb_home.setFont(new Font("Tahoma", Font.BOLD, 15));
		lb_home.setBounds(70, 10, 60, 40);
		panel_home.add(lb_home);
		
		JLabel lblNewLabel_2_4 = new JLabel("");
		Image icon_home = new ImageIcon(this.getClass().getResource("/icon home.png")).getImage();
		lblNewLabel_2_4.setIcon(new ImageIcon(icon_home));
		lblNewLabel_2_4.setForeground(Color.WHITE);
		lblNewLabel_2_4.setBounds(20, 10, 45, 40);
		panel_home.add(lblNewLabel_2_4);
		
		JPanel panel_Coso1 = new JPanel();
		panel_Coso1.setBorder(new LineBorder(new Color(192, 192, 192)));
		panel_Coso1.setBackground(new Color(62, 142, 62));
		panel_Coso1.addMouseListener(new PanelButtonMounseAdapter(panel_Coso1) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(CS1);
			}
		});
		panel_Coso1.setBounds(0, 240, 190, 60);
		panel_menu.add(panel_Coso1);
		panel_Coso1.setLayout(null);
		
		JLabel lb_Coso_1 = new JLabel("CƠ SỞ 1");
		lb_Coso_1.setHorizontalAlignment(SwingConstants.CENTER);
		lb_Coso_1.setForeground(Color.WHITE);
		lb_Coso_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lb_Coso_1.setBounds(70, 10, 70, 40);
		panel_Coso1.add(lb_Coso_1);
		
		JLabel lblNewLabel_2_3 = new JLabel("");
		Image icon_cs = new ImageIcon(this.getClass().getResource("/icon cơ sở.png")).getImage();
		lblNewLabel_2_3.setIcon(new ImageIcon(icon_cs));
		lblNewLabel_2_3.setForeground(Color.WHITE);
		lblNewLabel_2_3.setBounds(20, 10, 45, 40);
		panel_Coso1.add(lblNewLabel_2_3);
		
		JPanel panel_Coso2 = new JPanel();
		panel_Coso2.setBorder(new LineBorder(new Color(192, 192, 192)));
		panel_Coso2.setBackground(new Color(62, 142, 62));
		panel_Coso2.addMouseListener(new PanelButtonMounseAdapter(panel_Coso2) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(CS2);
			}
		});
		panel_Coso2.setBounds(0, 300, 190, 60);
		panel_menu.add(panel_Coso2);
		panel_Coso2.setLayout(null);
		
		JLabel lb_Coso_2 = new JLabel("CƠ SỞ 2");
		lb_Coso_2.setHorizontalAlignment(SwingConstants.CENTER);
		lb_Coso_2.setForeground(Color.WHITE);
		lb_Coso_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lb_Coso_2.setBounds(70, 10, 70, 40);
		panel_Coso2.add(lb_Coso_2);
		
		JLabel lblNewLabel_2_2 = new JLabel("");
		
		lblNewLabel_2_2.setIcon(new ImageIcon(icon_cs));
		lblNewLabel_2_2.setForeground(Color.WHITE);
		lblNewLabel_2_2.setBounds(20, 10, 45, 40);
		panel_Coso2.add(lblNewLabel_2_2);
		
		JPanel panel_Coso3 = new JPanel();
		panel_Coso3.setBorder(new LineBorder(new Color(192, 192, 192)));
		panel_Coso3.setBackground(new Color(62, 142, 62));
		panel_Coso3.addMouseListener(new PanelButtonMounseAdapter(panel_Coso3) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(CS3);
			}
		});
		panel_Coso3.setBounds(0, 360, 190, 60);
		panel_menu.add(panel_Coso3);
		panel_Coso3.setLayout(null);
		
		JLabel lb_Coso_3 = new JLabel("CƠ SỞ 3");
		lb_Coso_3.setHorizontalAlignment(SwingConstants.CENTER);
		lb_Coso_3.setForeground(Color.WHITE);
		lb_Coso_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lb_Coso_3.setBounds(70, 10, 70, 40);
		panel_Coso3.add(lb_Coso_3);
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setIcon(new ImageIcon(icon_cs));
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setBounds(20, 10, 45, 40);
		panel_Coso3.add(lblNewLabel_2_1);
		
		JPanel panel_signout = new JPanel();
		panel_signout.setBorder(new LineBorder(new Color(192, 192, 192)));
		panel_signout.setBackground(new Color(62, 142, 62));
		panel_signout.addMouseListener(new PanelButtonMounseAdapter(panel_signout));
		panel_signout.setBounds(0, 467, 190, 60);
		panel_menu.add(panel_signout);
		panel_signout.setLayout(null);
																
		JLabel lb_exit = new JLabel("SIGN OUT");
		lb_exit.setHorizontalAlignment(SwingConstants.CENTER);
		lb_exit.addMouseListener(new PanelButtonMounseAdapter(panel_signout){
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Bạn muốn đăng xuất?")== 0) {
					demo_login_user frame_signin = new demo_login_user();
					frame_signin.setVisible(true);
					Dashboard.this.dispose();
				}
				
			}
		});
		lb_exit.setForeground(Color.WHITE);
		lb_exit.setFont(new Font("Tahoma", Font.BOLD, 15));
		lb_exit.setBounds(70, 10, 80, 40);
		panel_signout.add(lb_exit);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		Image icon_signout = new ImageIcon(this.getClass().getResource("/sign out.png")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(icon_signout));
		lblNewLabel_2.setBounds(20, 10, 38, 40);
		panel_signout.add(lblNewLabel_2);
		
		
		 lb_name_user = new JLabel("");
		lb_name_user.setHorizontalAlignment(SwingConstants.CENTER);
		lb_name_user.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lb_name_user.setForeground(new Color(255, 255, 255));
		lb_name_user.setBounds(10, 120, 170, 30);
		panel_menu.add(lb_name_user);
		
		JLabel lb_user = new JLabel("");
		lb_user.setBounds(0, 0, 190, 170);
		panel_menu.add(lb_user);
		
		JPanel panel_Main_content = new JPanel();
		panel_Main_content.setBounds(190, 0, 746, 562);
		contentPane.add(panel_Main_content);
		panel_Main_content.setLayout(null);
		panel_Main_content.add(home);
		panel_Main_content.add(CS1);
		panel_Main_content.add(CS2);
		panel_Main_content.add(CS3);
		
		menuClicked(home);
		
	}
	// _______LẤY RA TÊN USERNAME _______________	
	public void setusername(String username) {
		this.lb_name_user.setText(username);
	}
	
	
	public void menuClicked(JPanel panel) {
		CS1.setVisible(false);
		CS2.setVisible(false);
		CS3.setVisible(false);
		home.setVisible(false);
		
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
