package Co_so;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

public class Home extends JPanel {

	/**
	 * Create the panel.
	 */
	public Home() {
		setBounds(0,0,710,550);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ADU MAN");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblNewLabel.setBounds(51, 70, 495, 360);
		add(lblNewLabel);
		setVisible(true);
	}
}
