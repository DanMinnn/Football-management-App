package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JToggleButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Admin_User extends JFrame {

	private JPanel contentPane;
	
	NoScalingIcon nsI = new NoScalingIcon(null);
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_User frame = new Admin_User();
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
	public Admin_User() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 747, 506);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		this.setTitle("Phần mềm quản lý sân bóng");
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 733, 469);
		contentPane.add(panel);
		panel.setLayout(null);
		ImageIcon img = new ImageIcon("football_bg.jpg");
		
		JLabel Label_Admin = new JLabel("Admin");
		Label_Admin.setForeground(new Color(255, 255, 255));
		Label_Admin.setBackground(new Color(255, 255, 255));
		Label_Admin.setFont(new Font("Arial", Font.BOLD, 24));
		Label_Admin.setBounds(164, 285, 100, 29);
		panel.add(Label_Admin);
		
		//Icon icon = new ImageIcon("Admin.png");
		JButton Button_Admin = new JButton( new NoScalingIcon(new ImageIcon("E:\\DownLoads\\admin96px.png")));
		Button_Admin.setForeground(new Color(0, 0, 0));
		Button_Admin.setBackground(new Color(0, 206, 209));
		Button_Admin.setBounds(154, 175, 110, 100);
		panel.add(Button_Admin);
		
		JLabel Label_user = new JLabel("User");
		Label_user.setForeground(new Color(255, 255, 255));
		Label_user.setFont(new Font("Arial", Font.BOLD, 24));
		Label_user.setBounds(510, 285, 78, 29);
		panel.add(Label_user);
		
		JButton Button_User = new JButton(new NoScalingIcon (new ImageIcon("E:\\DownLoads\\user_96.png")));
		Button_User.setForeground(Color.BLACK);
		Button_User.setBackground(new Color(0, 206, 209));
		Button_User.setBounds(478, 175, 110, 100);
		panel.add(Button_User);
		
		JLabel Label_bg = new JLabel("");
		Label_bg.setIcon(new NoScalingIcon (new ImageIcon("E:\\DownLoads\\football_bg (1).jpg")));
		Label_bg.setBounds(0, 0, 733, 469);
		panel.add(Label_bg);
		
		this.setVisible(true);
	}
}
