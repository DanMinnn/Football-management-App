package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Admin extends JFrame {

	private JPanel contentPane;
	private JTextField textField_ID;
	//PlaceholderTextField pTF = new PlaceholderTextField();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin frame = new Admin();
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
	public Admin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 757, 433);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Label_ID = new JLabel("ID");
		Label_ID.setForeground(new Color(0, 0, 0));
		Label_ID.setFont(new Font("Tahoma", Font.PLAIN, 24));
		Label_ID.setBounds(172, 163, 50, 47);
		contentPane.add(Label_ID);
		
		textField_ID = new JTextField();
		textField_ID.setBounds(225, 163, 208, 47);
		contentPane.add(textField_ID);
		textField_ID.setColumns(10);
//		final PlaceholderTextField tf = new PlaceholderTextField("");
//		tf.setColumns(20);
//		tf.setPlaceholder("Enter your ID");
//		Font f = tf.getFont();
//		tf.setFont(new Font(f.getName(), f.getStyle(), 30));
//		JOptionPane.showMessageDialog(null, tf);
		
		JButton button_LoginAd = new JButton("Login");
		button_LoginAd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_LoginAd.setFont(new Font("Tahoma", Font.BOLD, 24));
		button_LoginAd.setBounds(273, 254, 122, 47);
		contentPane.add(button_LoginAd);
		
		JLabel bg_Admin = new JLabel("");
		bg_Admin.setBounds(0, 0, 743, 396);
		contentPane.add(bg_Admin);
		
		this.setVisible(true);
	}
}
