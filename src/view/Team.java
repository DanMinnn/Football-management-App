package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class Team extends JFrame {

	private JPanel contentPane;
	private JTextField JText_ID;
	private JTextField textField_name;
	private JTextField textField_email;
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Team frame = new Team();
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
	public Team() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 736, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(30, 144, 255));
		panel.setBounds(0, 10, 232, 428);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("IIUC App");
		lblNewLabel.setForeground(new Color(240, 255, 255));
		lblNewLabel.setBounds(52, 179, 121, 52);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(260, 56, 28, 13);
		contentPane.add(lblNewLabel_1);
		
		JText_ID = new JTextField();
		JText_ID.setBounds(298, 50, 96, 29);
		contentPane.add(JText_ID);
		JText_ID.setColumns(10);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection con = DriverManager.getConnection("jdbc:mySQL://localhost:3306/universitydb", "root", "123456789");
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery("Select * from teacher where id=" + JText_ID.getText());
					if(rs.next()) {
						String name = rs.getString("name");
						String email = rs.getString("email");
						textField_name.setText(name);
						textField_email.setText(email);
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(457, 50, 96, 29);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("Name");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(260, 155, 58, 22);
		contentPane.add(lblNewLabel_2);
		
		JLabel JLabel_email = new JLabel("Email");
		JLabel_email.setFont(new Font("Tahoma", Font.PLAIN, 18));
		JLabel_email.setBounds(260, 200, 58, 22);
		contentPane.add(JLabel_email);
		
		textField_name = new JTextField();
		textField_name.setColumns(10);
		textField_name.setBounds(328, 148, 167, 29);
		contentPane.add(textField_name);
		
		textField_email = new JTextField();
		textField_email.setColumns(10);
		textField_email.setBounds(328, 193, 167, 29);
		contentPane.add(textField_email);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
