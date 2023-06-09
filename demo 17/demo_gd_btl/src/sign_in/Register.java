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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField txt_username;
	private JPasswordField txt_password;
	private JPasswordField txt_ConfimPassword;
	// KHAI BÁO ĐỐI TƯỢNG USER
	private sign_in_user signin_user;
	private JTextField txt_sdt;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 650, 550);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 104, 47));
		contentPane.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(192, 192, 192)));
		ImageIcon img = new ImageIcon(this.getClass().getResource("/icon_app.png"));
		setIconImage(img.getImage());
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(150, 35, 330, 408);
		contentPane.add(panel_1);

		JLabel lb_Title = new JLabel("Đăng ký ");
		lb_Title.setFont(new Font("Tahoma", Font.BOLD, 24));
		lb_Title.setBounds(27, 10, 110, 36);
		panel_1.add(lb_Title);

		txt_username = new JTextField();
		txt_username.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txt_username.getText().equals("Tên đăng nhập")) {
					txt_username.setText("");
				} else {
					txt_username.selectAll();
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txt_username.getText().equals("")) {
					txt_username.setText("Tên đăng nhập");
				}
			}
		});
		txt_username.setText("Tên đăng nhập");
		txt_username.setForeground(new Color(169, 169, 169));
		txt_username.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txt_username.setColumns(10);
		txt_username.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		txt_username.setBounds(27, 70, 270, 36);
		panel_1.add(txt_username);

		JButton btnRegister = new JButton("Đăng ký");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String password = new String(txt_password.getPassword());
				String confirm_password = new String(txt_ConfimPassword.getPassword());
				String regex ="^0[98753]{1}\\d{8}$";
				Pattern pt = Pattern.compile(regex);
				Matcher mt = pt.matcher(txt_sdt.getText());
				
			if(txt_username.getText().equals("") || txt_username.getText().equals("Tên đăng nhập")
						|| password.equals("")
						|| confirm_password.equals("")
						|| txt_sdt.getText().equals("") || txt_sdt.getText().equals("Số điện thoại")) {
					JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin!");
				} 
			else{
				 if(mt.find()){
					if(sign_in_user_dao.getInterface().check_username(txt_username.getText(),txt_sdt.getText()) == true){
						JOptionPane.showMessageDialog(null, "Username hoặc số điện thoại đã tồn tại!");
					} 
					else {
						if (!password.equals(confirm_password)) {
							JOptionPane.showMessageDialog(null, "Mật khẩu không khớp!");
						}
						else{
							JOptionPane.showMessageDialog(null, "Đăng ký thành công!");
							demo_login_user user_login = new demo_login_user();
							// ___________________KẾT NỐI TẠO TÀI KHOẢN MỚI_____________________________
							signin_user = new sign_in_user();
							signin_user.setUsername(txt_username.getText());
							signin_user.setPassword(password);
							signin_user.setSdt(txt_sdt.getText());
							sign_in_user_dao.getInterface().insert(signin_user);
							
							// ____________________CHUYỂN ĐỔI MÀN HÌNH HIỂN THỊ__________________________
							user_login.setVisible(true);
							Register.this.dispose();
						}
					}
				}
				else {
					 JOptionPane.showMessageDialog(null, "Số điện thoại không hợp lệ!");
				}
				
			}	
			}

		});
		btnRegister.setForeground(new Color(255, 255, 255));
		btnRegister.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnRegister.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		btnRegister.setBackground(new Color(46, 139, 87));
		btnRegister.setBounds(27, 307, 270, 36);
		panel_1.add(btnRegister);

		JLabel lblNewLabel = new JLabel("Bạn đã có tài khoản?");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(49, 351, 150, 25);
		panel_1.add(lblNewLabel);

		JLabel lb_login = new JLabel("Login");
		lb_login.setForeground(new Color(255, 51, 51));
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
		lb_login.setFont(new Font("Tahoma", Font.BOLD, 14));
		lb_login.setBounds(209, 353, 63, 21);
		panel_1.add(lb_login);

		txt_password = new JPasswordField();
		txt_password.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txt_password.getText().equals("Mật khẩu")) {
					txt_password.setText("");
				} else {
					txt_password.selectAll();
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txt_password.getText().equals("")) {
					txt_password.setText("Mật khẩu");
				}
			}
		});
		txt_password.setText("Mật khẩu");
		txt_password.setForeground(new Color(169, 169, 169));
		txt_password.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txt_password.setEchoChar(' ');
		txt_password.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		txt_password.setBounds(27, 196, 270, 32);
		panel_1.add(txt_password);

		txt_ConfimPassword = new JPasswordField();
		txt_ConfimPassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txt_ConfimPassword.getText().equals("Xác nhận mật khẩu")) {
					txt_ConfimPassword.setText("");
				} else {
					txt_ConfimPassword.selectAll();
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txt_ConfimPassword.getText().equals("")) {
					txt_ConfimPassword.setText("Xác nhận mật khẩu");
				}
			}
		});
		txt_ConfimPassword.setText("Xác nhận mật khẩu");
		txt_ConfimPassword.setForeground(new Color(169, 169, 169));
		txt_ConfimPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txt_ConfimPassword.setEchoChar(' ');
		txt_ConfimPassword.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		txt_ConfimPassword.setBounds(27, 254, 270, 32);
		panel_1.add(txt_ConfimPassword);
		
		txt_sdt = new JTextField();
		txt_sdt.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txt_sdt.getText().equals("Số điện thoại")) {
					txt_sdt.setText("");
				} else {
					txt_sdt.selectAll();
				}
			  }
			@Override
			public void focusLost(FocusEvent e) {
				if (txt_sdt.getText().equals("")) {
					txt_sdt.setText("Số điện thoại");
				}
			}
		});
		txt_sdt.setText("Số điện thoại");
		txt_sdt.setForeground(new Color(169, 169, 169));
		txt_sdt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txt_sdt.setColumns(10);
		txt_sdt.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		txt_sdt.setBounds(27, 132, 270, 36);
		panel_1.add(txt_sdt);
	}
}
