package Co_so;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

public class Home extends JPanel {

	/**
	 * Create the panel.
	 */
	public Home() {
		setBackground(UIManager.getColor("CheckBox.light"));
		setBounds(0,0,746,562);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 153, 0));
		panel.setBounds(0, 0, 746, 562);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(this.getClass().getResource("/home_page_1.jpg")));
		lblNewLabel.setBounds(0, 160, 746, 402);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cơ sở 1 - Minh: Nguyễn Xiển, Long Thạnh Mỹ, Quận 9");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(23, 10, 511, 34);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Cơ sở 2 - Kha: Đình Phong Phú, Tăng Nhơn Phú B, Quận 9");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(23, 54, 534, 34);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Cơ sở 3 - Lợi Anh: Võ Văn Ngân, Linh Chiểu, Thủ Đức");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3.setBounds(23, 98, 534, 34);
		panel.add(lblNewLabel_3);
		setVisible(true);
	}
}
