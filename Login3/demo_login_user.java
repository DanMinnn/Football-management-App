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
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JPasswordField;

public class demo_login_user extends JFrame {

	private JPanel contentPane;
	private JTextField txtEmail;
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
		setUndecorated(true);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 600, 450);
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

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				select_Login s_login = new select_Login();
				s_login.setVisible(true);
				demo_login_user.this.dispose();
			}
		});
		lblNewLabel_1.setBackground(new Color(55, 149, 81));
		// tìm ảnh trong file
		lblNewLabel_1.setIcon(new ImageIcon("D:\\JAVA\\icon\\return.png"));
		lblNewLabel_1.setBounds(10, 403, 53, 27);
		PA.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(261, 36, 64, 64);
		PA.add(lblNewLabel_2);
		// tìm ảnh trong file
		lblNewLabel_2.setIcon(new ImageIcon("D:\\JAVA\\icon\\user 64.png"));

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		panel_1.setBounds(130, 70, 330, 290);
		PA.add(panel_1);
		panel_1.setLayout(null);

		JLabel lb_Title = new JLabel(" User Login");
		lb_Title.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lb_Title.setBounds(25, 25, 140, 49);
		panel_1.add(lb_Title);

		txtEmail = new JTextField();
		txtEmail.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtEmail.getText().equals("Username")) {
					txtEmail.setText("");
				} else {
					txtEmail.selectAll();
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtEmail.getText().equals("")) {
					txtEmail.setText("Username");
				}
			}
		});
		txtEmail.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		txtEmail.setForeground(new Color(169, 169, 169));
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtEmail.setText("Username");
		txtEmail.setBounds(27, 90, 270, 36);
		panel_1.add(txtEmail);

		txtEmail.setColumns(10);

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
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSignIn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (txtEmail.getText().equals("khadeptrai123") && pwdPassword.getText().equals("123lol456")) {
					// if user inputs are correct
					lb_message.setText("");
					JOptionPane.showMessageDialog(null, "Login Successful!");
					Dashboard dashboard = new Dashboard();
					dashboard.setVisible(true);
					demo_login_user.this.dispose();
				} else if (txtEmail.getText().equals("") || pwdPassword.getText().equals("")) {
					lb_message.setText("Vui lòng nhập đầy đủ email và mật khẩu!");
				} else {
					lb_message.setText("Vui lòng nhập đúng email và mật khẩu!");
				}
			}
		});
		btnSignIn.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		btnSignIn.setBackground(new Color(46, 139, 87));
		btnSignIn.setForeground(new Color(255, 255, 255));
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

		JLabel label_exit = new JLabel("X");
		label_exit.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Bạn có muốn đóng chương trình? ", "Xác nhận",
						JOptionPane.YES_NO_OPTION) == 0) {
					demo_login_user.this.dispose();
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
		label_exit.setBounds(570, 0, 20, 27);
		PA.add(label_exit);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(407, 70, 53, 27);
		PA.add(lblNewLabel);

	}
}
