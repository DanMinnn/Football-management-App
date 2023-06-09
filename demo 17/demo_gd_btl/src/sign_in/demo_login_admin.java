package sign_in;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import Admin.Admin_Dashboard;

import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class demo_login_admin extends JFrame {

	private JPanel contentPane;
	private JTextField txtAdminname;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					demo_login_admin frame = new demo_login_admin();
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
	public demo_login_admin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 204, 153));
		contentPane.setBorder(new LineBorder(new Color(192, 192, 192), 3));
		ImageIcon img = new ImageIcon(this.getClass().getResource("/icon_app.png"));
		setIconImage(img.getImage());
		setLocationRelativeTo(null);
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(284, 40, 70, 70);
		contentPane.add(lblNewLabel);
		Image icon_admin = new ImageIcon(this.getClass().getResource("/admin 64.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(icon_admin));
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(154, 78, 330, 290);
		contentPane.add(panel_1);
		
		txtAdminname = new JTextField();
		txtAdminname.setText("Admin_name");
		txtAdminname.setForeground(new Color(169, 169, 169));
		txtAdminname.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtAdminname.getText().equals("Admin_name")) {
					txtAdminname.setText("");
				} else {
					txtAdminname.selectAll();
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtAdminname.getText().equals("")) {
					txtAdminname.setText("Admin_name");
				}
			}
		});
		txtAdminname.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtAdminname.setColumns(10);
		txtAdminname.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		txtAdminname.setBounds(27, 94, 270, 36);
		panel_1.add(txtAdminname);
		
		
		JLabel lb_message = new JLabel("Mời bạn đăng nhập");
		lb_message.setHorizontalAlignment(SwingConstants.LEFT);
		lb_message.setForeground(new Color(112, 128, 144));
		lb_message.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lb_message.setBounds(27, 204, 254, 32);
		panel_1.add(lb_message);
		
		JButton btnSignIn = new JButton("SIGN IN");
		btnSignIn.setForeground(new Color(0, 0, 0));
		btnSignIn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSignIn.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		btnSignIn.setBackground(new Color(46, 139, 87));
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSignIn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (txtAdminname.getText().equals("Admin") && passwordField.getText().equals("12345")) {
					
					lb_message.setText("");
					JOptionPane.showMessageDialog( null,"Chào mừng "+txtAdminname.getText()+"!");
					Admin_Dashboard admin_dashboard = new Admin_Dashboard();
					admin_dashboard.set_adminname(txtAdminname.getText());
					admin_dashboard.setVisible(true);
					demo_login_admin.this.dispose();
				}
				else if(txtAdminname.getText().equals("") || passwordField.getText().equals("")) {
					lb_message.setText("Vui lòng nhập đầy đủ email và mật khẩu!");
				}
				else {
					lb_message.setText("Vui lòng nhập đúng email và mật khẩu!");
				}
			}
		});
		btnSignIn.setBounds(165, 254, 165, 36);
		panel_1.add(btnSignIn);
		
		passwordField = new JPasswordField();
		passwordField.setText("Password");
		passwordField.setForeground(new Color(169, 169, 169));
		passwordField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (passwordField.getText().equals("Password")) {
					passwordField.setEchoChar('●');
					passwordField.setText("");
				} else {
					passwordField.selectAll();
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (passwordField.getText().equals("")) {
					passwordField.setText("Password");
					passwordField.setEchoChar((char) 0);
				}
			}
		});
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		passwordField.setEchoChar(' ');
		passwordField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		passwordField.setBounds(27, 155, 270, 32);
		panel_1.add(passwordField);
		
		JLabel lb_Title = new JLabel("Login Admin");
		lb_Title.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lb_Title.setBounds(27, 26, 139, 49);
		panel_1.add(lb_Title);
		
		JPanel lg_user = new JPanel();
		lg_user.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				demo_login_user user_lg = new demo_login_user();
				user_lg.setVisible(true);
				demo_login_admin.this.dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lg_user.setBackground(new Color(192,192,192));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lg_user.setBackground(new Color(240,240,240));
			}
		});
		lg_user.setLayout(null);
		lg_user.setBounds(10, 10, 91, 92);
		contentPane.add(lg_user);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		Image icon_user = new ImageIcon(this.getClass().getResource("/user 64.png")).getImage();
		lblNewLabel_1_1.setIcon(new ImageIcon(icon_user));
		lblNewLabel_1_1.setBounds(10, 5, 71, 64);
		lg_user.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_3 = new JLabel("User");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(10, 65, 71, 25);
		lg_user.add(lblNewLabel_3);
		
		
	}

}
