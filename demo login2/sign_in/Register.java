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
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField txt_username;
	private JTextField txtPassword;
	private JTextField txtRepeatPassword;

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
		contentPane.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(255, 255, 255)));
		setLocationRelativeTo(null);
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(130, 39, 330, 346);
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
		txt_username.setBounds(27, 80, 270, 36);
		panel_1.add(txt_username);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (txt_username.getText().equals("vominhkha123") && txtRepeatPassword.getText().equals(txtPassword)) {
					// if  user inputs  are correct
					JOptionPane.showMessageDialog( null,"Register Successful!");
					demo_login_user login_user =new demo_login_user();
					login_user.setVisible(true);
					Register.this.dispose();
				}
				else if(txt_username.getText().equals("")|| txt_username.getText().equals("Username")||
						txtPassword.getText().equals("")||txtRepeatPassword.getText().equals("")) {
					JOptionPane.showMessageDialog( null,"Vui lòng nhập đầy đủ thông tin!");
				}
				else {
					JOptionPane.showMessageDialog( null,"Mật khẩu không khớp!");
				}
			}
		});
		btnRegister.setForeground(Color.WHITE);
		btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnRegister.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		btnRegister.setBackground(new Color(46, 139, 87));
		btnRegister.setBounds(27, 252, 270, 36);
		panel_1.add(btnRegister);
		
		JLabel lb_message = new JLabel("");
		lb_message.setHorizontalAlignment(SwingConstants.LEFT);
		lb_message.setForeground(new Color(112, 128, 144));
		lb_message.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lb_message.setBounds(25, 241, 254, 32);
		panel_1.add(lb_message);
		
		JLabel lblNewLabel = new JLabel("Already have an account?");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(52, 298, 162, 25);
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
		lb_login.setBounds(217, 300, 63, 21);
		panel_1.add(lb_login);
		
		txtPassword = new JTextField();
		txtPassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtPassword.getText().equals("Password")) {
					txtPassword.setText("");
				} else {
					txtPassword.selectAll();
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtPassword.getText().equals("")) {
					txtPassword.setText("Password");
				}
			}
		});
		txtPassword.setText("Password");
		txtPassword.setForeground(new Color(169, 169, 169));
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtPassword.setColumns(10);
		txtPassword.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		txtPassword.setBounds(27, 140, 270, 36);
		panel_1.add(txtPassword);
		
		txtRepeatPassword = new JTextField();
		txtRepeatPassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtRepeatPassword.getText().equals("Repeat Password")) {
					txtRepeatPassword.setText("");
				} else {
					txtRepeatPassword.selectAll();
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtRepeatPassword.getText().equals("")) {
					txtRepeatPassword.setText("Repeat Password");
				}
			}
		});
		txtRepeatPassword.setText("Repeat Password");
		txtRepeatPassword.setForeground(new Color(169, 169, 169));
		txtRepeatPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtRepeatPassword.setColumns(10);
		txtRepeatPassword.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		txtRepeatPassword.setBounds(27, 200, 270, 36);
		panel_1.add(txtRepeatPassword);
		
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
