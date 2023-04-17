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
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import Main.dao.sign_in_user_dao;
import Main.model.sign_in_user;

import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField txt_username;
	private JPasswordField txt_password;
	private JPasswordField txt_ConfimPassword;
	private JTextField txtYourPhoneNumber;
	// KHAI BÁO ĐỐI TƯỢNG USER
	private sign_in_user signin_user;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
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
	public Register() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 600, 450);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 104, 47));
		contentPane.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(192, 192, 192)));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(130, 31, 330, 394);
		contentPane.add(panel_1);

		JLabel lb_Title = new JLabel("Register");
		lb_Title.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lb_Title.setBounds(27, 27, 110, 36);
		panel_1.add(lb_Title);

		txt_username = new JTextField();
		txt_username.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txt_username.getText().equals("Username")) {
					txt_username.setText("");
				} else {
					txt_username.selectAll();
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txt_username.getText().equals("")) {
					txt_username.setText("Username");
				}
			}
		});
		txt_username.setText("Username");
		txt_username.setForeground(new Color(169, 169, 169));
		txt_username.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txt_username.setColumns(10);
		txt_username.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		txt_username.setBounds(27, 70, 270, 36);
		panel_1.add(txt_username);

		JButton btnRegister = new JButton("Register");
		btnRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String password = new String(txt_password.getPassword());
				String confirm_password = new String(txt_ConfimPassword.getPassword());
				// ________CHECK sdt có hợp lệ hay không
				String regex = "^0[98753]{1}\\d{8}$";
				Pattern pattern = Pattern.compile(regex);
				Matcher matcher = pattern.matcher(txtYourPhoneNumber.getText());

				if (txt_username.getText().equals("") || txt_username.getText().equals("Username")
						|| txtYourPhoneNumber.getText().equals("")
						|| txtYourPhoneNumber.getText().equals("Phone Number") 
						|| password.equals("")
						|| confirm_password.equals("")) {
					JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin!");
				} 
				else if (!matcher.find()) {
						JOptionPane.showMessageDialog(null, "Số điện thoại không hợp lệ!");
					}

				else if (!password.equals(confirm_password)) {
						JOptionPane.showMessageDialog(null, "Mật khẩu không khớp!");
					}

					else {

						JOptionPane.showMessageDialog(null, "Đăng ký thành công!");
						demo_login_user user_login = new demo_login_user();

						// ___________________KẾT NỐI TẠO TÀI KHOẢN MỚI_____________________________
						signin_user = new sign_in_user(txt_username.getText(), txtYourPhoneNumber.getText(), password);
						sign_in_user_dao.getInterface().insert(signin_user);
						// ____________________CHUYỂN ĐỔI MÀN HÌNH HIỂN THỊ__________________________
						user_login.setVisible(true);
						Register.this.dispose();
					}
				}

		});
		btnRegister.setForeground(Color.WHITE);
		btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnRegister.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		btnRegister.setBackground(new Color(46, 139, 87));
		btnRegister.setBounds(27, 300, 270, 36);
		panel_1.add(btnRegister);

		JLabel lblNewLabel = new JLabel("Already have an account?");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(52, 345, 162, 25);
		panel_1.add(lblNewLabel);

		JLabel lb_login = new JLabel("Login");
		lb_login.setForeground(new Color(0, 0, 255));
		lb_login.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				demo_login_user loginuser = new demo_login_user();
				loginuser.setVisible(true);
				Register.this.dispose();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lb_login.setForeground(Color.RED);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lb_login.setForeground(Color.blue);
			}
		});
		lb_login.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lb_login.setBounds(217, 345, 63, 21);
		panel_1.add(lb_login);

		txt_password = new JPasswordField();
		txt_password.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txt_password.getText().equals("Password")) {
					txt_password.setText("");
				} else {
					txt_password.selectAll();
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txt_password.getText().equals("")) {
					txt_password.setText("Password");
				}
			}
		});
		txt_password.setText("Password");
		txt_password.setForeground(new Color(169, 169, 169));
		txt_password.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txt_password.setEchoChar(' ');
		txt_password.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		txt_password.setBounds(27, 190, 270, 32);
		panel_1.add(txt_password);

		txt_ConfimPassword = new JPasswordField();
		txt_ConfimPassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txt_ConfimPassword.getText().equals("Confirm Password")) {
					txt_ConfimPassword.setText("");
				} else {
					txt_ConfimPassword.selectAll();
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txt_ConfimPassword.getText().equals("")) {
					txt_ConfimPassword.setText("Confirm Password");
				}
			}
		});
		txt_ConfimPassword.setText("Confirm Password");
		txt_ConfimPassword.setForeground(new Color(169, 169, 169));
		txt_ConfimPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txt_ConfimPassword.setEchoChar(' ');
		txt_ConfimPassword.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		txt_ConfimPassword.setBounds(27, 250, 270, 32);
		panel_1.add(txt_ConfimPassword);

		txtYourPhoneNumber = new JTextField();
		txtYourPhoneNumber.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtYourPhoneNumber.getText().equals("Phone Number")) {
					txtYourPhoneNumber.setText("");
				} else {
					txtYourPhoneNumber.selectAll();
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtYourPhoneNumber.getText().equals("")) {
					txtYourPhoneNumber.setText("Phone Number");
				}
			}
		});
		txtYourPhoneNumber.setText("Phone Number");
		txtYourPhoneNumber.setForeground(new Color(169, 169, 169));
		txtYourPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtYourPhoneNumber.setColumns(10);
		txtYourPhoneNumber.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		txtYourPhoneNumber.setBounds(27, 130, 270, 36);
		panel_1.add(txtYourPhoneNumber);

		JLabel lb_exit = new JLabel("X");
		lb_exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Bạn có muốn đóng chương trình? ", "Xác nhận",
						JOptionPane.YES_NO_OPTION) == 0) {
					Register.this.dispose();
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lb_exit.setForeground(Color.RED);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lb_exit.setForeground(Color.white);
			}
		});
		lb_exit.setForeground(new Color(255, 255, 255));
		lb_exit.setFont(new Font("Tahoma", Font.BOLD, 20));
		lb_exit.setBounds(579, 0, 21, 27);
		contentPane.add(lb_exit);
	}
}
