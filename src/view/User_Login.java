package view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class User_Login extends JFrame {
	

	private JPanel contentPane;
	private JTextField txtUsername;
	private JTextField txtPassword;
	
	/**
	 * Launch the application.
	 */
	
	public User_Login() {
		initComponent();
		addPlaceholderStyle(txtUsername);
		addPlaceholderStyle(txtPassword);
	}
	
	
	public void addPlaceholderStyle (JTextField textField) {
		Font font = textField.getFont();
		font = font.deriveFont(Font.ITALIC);
		textField.setFont(font);
		textField.setForeground(Color.GRAY);
	}
	
	public void removePlaceholderStyle (JTextField textField) {
		Font font = textField.getFont();
		font = font.deriveFont(Font.PLAIN|Font.BOLD);
		textField.setFont(font);
		textField.setForeground(Color.BLACK);
	}
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User_Login frame = new User_Login();
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
	public void initComponent () {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 661, 451);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtUsername = new JTextField();
		txtUsername.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtUsername.getText().equals("Username")) {
					txtUsername.setText(null);
					txtUsername.requestFocus();
					removePlaceholderStyle(txtUsername);
				}
			}
			
			
			@Override
			public void focusLost(FocusEvent e) {
				if(txtUsername.getText().length() == 0) {
					addPlaceholderStyle(txtUsername);
					txtUsername.setText("Username");
				}
			}
		});
		
		

		txtUsername.setForeground(new Color(169, 169, 169));
		txtUsername.setFont(new Font("Tahoma", Font.ITALIC, 18));
		txtUsername.setText("Username");
		txtUsername.setBounds(211, 108, 202, 38);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JTextField();
		
		txtPassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtPassword.getText().equals("Password")) {
					txtPassword.setText(null);
					txtPassword.requestFocus();
					
					removePlaceholderStyle(txtPassword);
				}
			}
			
			@Override
			public void focusLost(FocusEvent e) {
				if(txtPassword.getText().length() == 0) {
					addPlaceholderStyle(txtPassword);
					txtPassword.setText("Password");
				}
			}
		});
		
		
		txtPassword.setForeground(new Color(169, 169, 169));
		txtPassword.setFont(new Font("Tahoma", Font.ITALIC, 18));
		txtPassword.setText("Password");
		txtPassword.setColumns(10);
		txtPassword.setBounds(211, 206, 202, 38);
		contentPane.add(txtPassword);
		
	}
}
