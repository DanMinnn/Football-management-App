package sign_in;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;

public class Home extends JPanel {

	/**
	 * Create the panel.
	 */
	public Home() {
	 //setSize(515,450);
		setBounds(0,0,515,450);
	 setLayout(null);
	
	 setVisible(true);
	 JLabel lblNewLabel = new JLabel("home nè");
	 lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	 lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
	 lblNewLabel.setBounds(22, 70, 466, 282);
	 add(lblNewLabel);
	}
}
