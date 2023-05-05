package sign_in;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import Main.database.jdbc_until;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JPasswordField;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class demo_login_user extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField pwdPassword;
	private JLabel lb_message = new JLabel("Mời bạn đăng nhập");

	// sign in
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					demo_login_user frame = new demo_login_user();
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
	public demo_login_user() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 650, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setLocationRelativeTo(null);
		setContentPane(contentPane);

		JPanel PA = new JPanel();
		PA.setFont(new Font("Tahoma", Font.PLAIN, 20));
		PA.setBackground(new Color(51, 104, 47));
		contentPane.add(PA, BorderLayout.CENTER);
		PA.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(273, 41, 64, 64);
		PA.add(lblNewLabel_2);
		// tìm ảnh trong file
		Image icon_user = new ImageIcon(this.getClass().getResource("/user 64.png")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(icon_user));

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		panel_1.setBounds(142, 75, 330, 290);
		PA.add(panel_1);
		panel_1.setLayout(null);

		JLabel lb_Title = new JLabel(" User Login");
		lb_Title.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lb_Title.setBounds(25, 25, 140, 49);
		panel_1.add(lb_Title);

		txtUsername = new JTextField();
		txtUsername.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtUsername.getText().equals("Username")) {
					txtUsername.setText("");
				} else {
					txtUsername.selectAll();
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtUsername.getText().equals("")) {
					txtUsername.setText("Username");
				}
			}
		});
		txtUsername.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		txtUsername.setForeground(new Color(169, 169, 169));
		txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtUsername.setText("Username");
		txtUsername.setBounds(27, 90, 270, 36);
		panel_1.add(txtUsername);

		txtUsername.setColumns(10);

		JButton btnRegister = new JButton("REGISTER");
		btnRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Register dk = new Register();
				dk.setVisible(true);
				demo_login_user.this.dispose();
			}
		});
		btnRegister.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		btnRegister.setBackground(new Color(211, 211, 211));
		btnRegister.setForeground(new Color(169, 169, 169));
		btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnRegister.setBounds(0, 253, 167, 36);
		panel_1.add(btnRegister);

		JButton btnSignIn = new JButton("SIGN IN");
		// ___________________KIỂM TRA CÓ USER TRONG "sign_in_user"
		// KO____________________________
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtUsername.getText().equals("") || txtUsername.getText().equals("Username")
						|| pwdPassword.getText().equals("") || pwdPassword.getText().equals("Password")) {
					lb_message.setText("Vui lòng nhập đầy đủ email và mật khẩu!");
				} else {
					try {
						// tạo kết nối
						Connection connection = jdbc_until.getConnection();
						// tạo biến statement
						Statement st = connection.createStatement();

						// thêm câu lệnh
						String sql = "	Select * from sign_in_user where username = '" + txtUsername.getText()
								+ "' and password = '" + pwdPassword.getText() + "';";
						ResultSet rs = st.executeQuery(sql);
						// kiểm tra dữ liệu

						if (rs.next()) {
							System.out.println("bạn vừa thực hiện câu lênh: " + sql + " thành công");
							lb_message.setText("");
							JOptionPane.showMessageDialog(null, "Login Successful!");
							Dashboard dashboard = new Dashboard();
							dashboard.setusername(txtUsername.getText());// GÁN USERNAME
							dashboard.setVisible(true);
							demo_login_user.this.dispose();
						} else {
							lb_message.setText("Vui lòng nhập đúng email và mật khẩu!");
							System.out.println("thực hiện không thành công");
						}
						// ngắt kết nối
						jdbc_until.closeConnection(connection);

					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}

			}
		});

		btnSignIn.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		btnSignIn.setBackground(new Color(46, 139, 87));
		btnSignIn.setForeground(new Color(255, 255, 255));
		btnSignIn.setOpaque(true);
		btnSignIn.setBorderPainted(false);
		
		btnSignIn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSignIn.setBounds(166, 253, 165, 36);
		panel_1.add(btnSignIn);

		pwdPassword = new JPasswordField();
		pwdPassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (pwdPassword.getText().equals("Password")) {
					pwdPassword.setEchoChar('●');
					pwdPassword.setText("");
				} else {
					pwdPassword.selectAll();
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (pwdPassword.getText().equals("")) {
					pwdPassword.setText("Password");
					pwdPassword.setEchoChar((char) 0);
				}
			}
		});
		pwdPassword.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		pwdPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pwdPassword.setEchoChar((char) 0);
		pwdPassword.setForeground(new Color(169, 169, 169));
		pwdPassword.setText("Password");
		pwdPassword.setBounds(27, 150, 270, 32);
		panel_1.add(pwdPassword);

		lb_message.setHorizontalAlignment(SwingConstants.LEFT);
		lb_message.setForeground(new Color(112, 128, 144));
		lb_message.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lb_message.setBounds(27, 204, 254, 32);
		panel_1.add(lb_message);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(407, 70, 53, 27);
		PA.add(lblNewLabel);

		JPanel lg_admin = new JPanel();
		lg_admin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				demo_login_admin login_admin = new demo_login_admin();
				login_admin.setVisible(true);
				demo_login_user.this.dispose();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lg_admin.setBackground(new Color(192, 192, 192));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lg_admin.setBackground(new Color(240, 240, 240));
			}
		});
		lg_admin.setBounds(10, 10, 91, 90);
		PA.add(lg_admin);
		lg_admin.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("");
		Image icon_admin = new ImageIcon(this.getClass().getResource("/admin 64.png")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(icon_admin));
		lblNewLabel_1.setBounds(10, 0, 71, 64);
		lg_admin.add(lblNewLabel_1);

		JLabel lblNewLabel_3 = new JLabel("Admin");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(10, 62, 71, 25);
		lg_admin.add(lblNewLabel_3);

	}
}
