package sign_in;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

public class panel_CS3 extends JPanel {

	/**
	 * Create the panel.
	 */
	public panel_CS3() {
		setBounds(0,0,515,450);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("đây là cơ sở 3");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel.setBounds(36, 70, 418, 212);
		add(lblNewLabel);
	}

}
