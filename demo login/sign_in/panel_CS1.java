package sign_in;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class panel_CS1 extends JPanel {

	/**
	 * Create the panel.
	 */
	public panel_CS1() {
		setBounds(0,0,515,450);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("đây là cơ sở 1");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(83, 344, 312, 25);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\khavo\\OneDrive\\Hình ảnh\\z4139465996049_d89577389e0aadef29fa0402ad85a7a6.jpg"));
		lblNewLabel_1.setBounds(33, 30, 452, 410);
		add(lblNewLabel_1);
	}

}
