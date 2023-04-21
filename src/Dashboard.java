import java.awt.EventQueue;

import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;


import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Dashboard extends JFrame {

	private Image img_logo = new ImageIcon(Dashboard.class.getResource("res/logo1.jpg")).getImage().getScaledInstance(197, 187, Image.SCALE_SMOOTH);
	private Image img_logo_ds = new ImageIcon(Dashboard.class.getResource("res/logo_datsan.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
	private Image img_staff = new ImageIcon(Dashboard.class.getResource("res/staff.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
	private Image img_support = new ImageIcon(Dashboard.class.getResource("res/support.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
	private Image img_account = new ImageIcon(Dashboard.class.getResource("res/account.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
	private Image img_logout = new ImageIcon(Dashboard.class.getResource("res/logout.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);

	
	private JPanel contentPane;
	
	private PanelSan panelSan;
	private PanelStaff panelStaff;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard frame = new Dashboard();
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
	public Dashboard() {
		setBackground(new Color(224, 255, 255));
		//setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1350, 642);
		//setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelSan = new PanelSan();
		panelStaff = new PanelStaff();
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(0, 0, 217, 800);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel Logo = new JLabel("");
		Logo.setBounds(10, 0, 207, 208);
		panel.add(Logo);
		Logo.setIcon(new ImageIcon(img_logo));
		
		JPanel pSan = new JPanel();
		pSan.addMouseListener(new PanelButtonMouseAdapter(pSan) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelSan);
			}
		});
		pSan.setBackground(Color.LIGHT_GRAY);
		pSan.setBounds(0, 207, 217, 74);
		panel.add(pSan);
		pSan.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("S\u00E2n b\u00F3ng");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel.setBounds(80, 24, 137, 26);
		pSan.add(lblNewLabel);
		
		JLabel ds_logo = new JLabel("");
		ds_logo.setBounds(31, 0, 40, 74);
		pSan.add(ds_logo);
		ds_logo.setIcon(new ImageIcon(img_logo_ds));	
		
		JPanel pStaff = new JPanel();
		pStaff.addMouseListener(new PanelButtonMouseAdapter(pStaff) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelStaff);
			}
		});
		pStaff.setBackground(Color.LIGHT_GRAY);
		pStaff.setBounds(0, 291, 217, 74);
		panel.add(pStaff);
		pStaff.setLayout(null);
		
		JLabel lblNhnVin = new JLabel("Nh\u00E2n vi\u00EAn");
		lblNhnVin.setForeground(Color.WHITE);
		lblNhnVin.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNhnVin.setBounds(80, 24, 137, 26);
		pStaff.add(lblNhnVin);
		
		JLabel logo_staff = new JLabel("");
		logo_staff.setBounds(30, 0, 40, 74);
		pStaff.add(logo_staff);
		logo_staff.setIcon(new ImageIcon(img_staff));
		
		JPanel pLogout = new JPanel();
		pLogout.addMouseListener(new PanelButtonMouseAdapter(pLogout));
		pLogout.setLayout(null);
		pLogout.setBackground(Color.LIGHT_GRAY);
		pLogout.setBounds(0, 375, 217, 74);
		panel.add(pLogout);
		
		JLabel lblngXut = new JLabel("\u0110\u0103ng xu\u1EA5t");
		lblngXut.setForeground(Color.WHITE);
		lblngXut.setFont(new Font("Dialog", Font.BOLD, 20));
		lblngXut.setBounds(80, 23, 137, 26);
		pLogout.add(lblngXut);
		
		JLabel logo_logout = new JLabel("");
		logo_logout.setBounds(31, 0, 40, 74);
		pLogout.add(logo_logout);
		logo_logout.setIcon(new ImageIcon(img_logout));
		
		JPanel panelMain = new JPanel();
		panelMain.setBounds(218, 0, 1118, 605);
		contentPane.add(panelMain);
		panelMain.setLayout(null);
		
		panelMain.add(panelSan);
		panelMain.add(panelStaff);
		
		menuClicked(panelSan);
	}
	
	public void menuClicked(JPanel panel) {
		panelSan.setVisible(false);
		panelStaff.setVisible(false);
		
		panel.setVisible(true);
	}
	
	private class PanelButtonMouseAdapter extends MouseAdapter{
		
		JPanel panel;
		public PanelButtonMouseAdapter(JPanel panel){
			this.panel = panel;
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
			panel.setBackground(new Color(112, 128, 144));
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
			panel.setBackground(Color.LIGHT_GRAY);
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			panel.setBackground(new Color(60, 179, 113));
		}
		
		@Override
		public void mouseReleased(MouseEvent e) {
			panel.setBackground(new Color(112, 128, 144));
		}
	}
}
