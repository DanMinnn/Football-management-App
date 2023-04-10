package sign_in;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;

public class select_Login extends JFrame {
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					select_Login frame = new select_Login();
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
	public select_Login() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 104, 47));
		contentPane.setBorder(new LineBorder(new Color(192, 192, 192), 3));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label_exit = new JLabel("X");
		label_exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			if(JOptionPane.showConfirmDialog(null, "Bạn muốn đóng chương trình?", "Xác nhận", JOptionPane.YES_NO_OPTION)==0) {
				select_Login.this.dispose();
			}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				label_exit.setForeground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				label_exit.setForeground(Color.white);
			}
		});
		
		label_exit.setForeground(new Color(248, 248, 255));
		label_exit.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_exit.setBounds(580, 0, 20, 27);
		contentPane.add(label_exit);
		
		JPanel panel_OptionLogin = new JPanel();
		panel_OptionLogin.setBackground(new Color(255, 255, 255));
		panel_OptionLogin.setBounds(100, 50, 400, 350);
		
		contentPane.add(panel_OptionLogin);
		panel_OptionLogin.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Chọn phương thức đăng nhập");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(57, 239, 293, 62);
		panel_OptionLogin.add(lblNewLabel_2);
		
		
		
		JPanel panel_login_user = new JPanel();
		panel_login_user.setBackground(new Color(240, 240, 240));
		panel_login_user.setBounds(222, 64, 135, 150);
		panel_login_user.addMouseListener(new PanelButtonMounseAdapter(panel_login_user) {
			@Override
			public void mouseClicked(MouseEvent e) {
				demo_login_user login = new demo_login_user();
				login.setVisible(true);
				select_Login.this.dispose();
			}
		});
		panel_OptionLogin.add(panel_login_user);
		panel_login_user.setLayout(null);
		
		JLabel lblUser = new JLabel("USER");
		lblUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblUser.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUser.setBounds(28, 113, 80, 30);
		panel_login_user.add(lblUser);
		
		JLabel lb_icon_User = new JLabel("");
		lb_icon_User.setIcon(new ImageIcon("D:\\JAVA\\icon\\user 94.png"));
		lb_icon_User.setHorizontalAlignment(SwingConstants.CENTER);
		lb_icon_User.setBounds(10, 1, 115, 102);
		panel_login_user.add(lb_icon_User);
		
		
			
		
		JPanel panel_login_admin = new JPanel();
		panel_login_admin.setBackground(new Color(240, 240, 240));
		panel_login_admin.setBounds(43, 64, 135, 150);
		panel_login_admin.addMouseListener(new PanelButtonMounseAdapter(panel_login_admin) {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				demo_login_admin login_admin = new demo_login_admin();
				login_admin.setVisible(true);
				select_Login.this.dispose();
			}
		});
		panel_OptionLogin.add(panel_login_admin);
		panel_login_admin.setLayout(null);
		
		JLabel lb_admin = new JLabel("ADMIN");
		lb_admin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lb_admin.setHorizontalAlignment(SwingConstants.CENTER);
		lb_admin.setBounds(21, 112, 80, 30);
		panel_login_admin.add(lb_admin);
		
		JLabel lb_icon_Admin = new JLabel("");
		lb_icon_Admin.setHorizontalAlignment(SwingConstants.CENTER);
		lb_icon_Admin.setIcon(new ImageIcon("D:\\JAVA\\icon\\admin 94.png"));
		lb_icon_Admin.setBounds(10, 0, 115, 102);
		panel_login_admin.add(lb_icon_Admin);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel.setBounds(10, 10, 112, 30);
		panel_OptionLogin.add(lblNewLabel);
		
		
	}
	
	private class PanelButtonMounseAdapter extends MouseAdapter{
		JPanel panel;
		public	PanelButtonMounseAdapter(JPanel panel) {
			this.panel=panel;
		}							
		@Override
		public void mousePressed(MouseEvent e) {
			panel.setBackground(new Color(51, 104, 47));
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			panel.setBackground(new Color(51,104,104));
		}
		@Override
		public void mouseExited(MouseEvent e) {
			panel.setBackground(new Color(240,240,240));
		}
		@Override
		public void  mouseReleased(MouseEvent e) {
			panel.setBackground(new Color(51, 104, 47));
		}	
  }
}
