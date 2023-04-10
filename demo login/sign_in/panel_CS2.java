package sign_in;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class panel_CS2 extends JPanel {

	/**
	 * Create the panel.
	 */
	public panel_CS2() {
		setBounds(0,0,515,450);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ĐÂY LÀ CƠ SỞ 2");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(53, 120, 380, 224);
		add(lblNewLabel);
	}

}
