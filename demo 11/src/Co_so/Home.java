package Co_so;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.Color;

public class Home extends JPanel {

	/**
	 * Create the panel.
	 */
	public Home() {
		setBackground(new Color(0, 128, 0));
		setBounds(0,0,746,562);
		setLayout(null);
		
		JTextArea txtrChoMngn = new JTextArea();
		txtrChoMngn.setBackground(new Color(192, 192, 192));
		txtrChoMngn.setFont(new Font("Tahoma", Font.PLAIN, 30));
		txtrChoMngn.setText("Chào mừng đến với app quản lý sân bóng \r\n\r\n");
		txtrChoMngn.setBounds(67, 52, 610, 438);
		add(txtrChoMngn);
		setVisible(true);
	}
}
