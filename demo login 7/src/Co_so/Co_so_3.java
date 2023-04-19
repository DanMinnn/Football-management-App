package Co_so;

import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.Box;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Label;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Co_so_3 extends JPanel {

	/**
	 * Create the panel.
	 */
	public Co_so_3() {
		setBounds(0,0,710,550);
		setLayout(null);
		
		setVisible(true);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Segoe UI", Font.BOLD, 15));
		menuBar.setBackground(new Color(255, 255, 255));
		menuBar.setBounds(0, 0, 710, 36);
		add(menuBar);
		
		JMenu Menu_san = new JMenu("Sân bóng");
		Menu_san.setIcon(new ImageIcon("D:\\JAVA\\icon\\icon cơ sở.png"));
		Menu_san.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(Menu_san);
		
		JMenuItem item_san7 = new JMenuItem("Sân 7");
		item_san7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		item_san7.setIcon(new ImageIcon("D:\\JAVA\\icon\\icon cơ sở.png"));
		Menu_san.add(item_san7);
		
		JMenuItem item_san5 = new JMenuItem("Sân 5");
		item_san5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		item_san5.setIcon(new ImageIcon("D:\\JAVA\\icon\\icon cơ sở.png"));
		Menu_san.add(item_san5);
		
		JMenu menu_nv = new JMenu("Nhân viên");
		menu_nv.setIcon(new ImageIcon("D:\\JAVA\\icon\\Iconshock-Real-Vista-Jobs-Asian.32.png"));
		menuBar.add(menu_nv);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Thu ngân");
		mntmNewMenuItem_2.setIcon(new ImageIcon("D:\\JAVA\\icon\\Iconshock-Real-Vista-Jobs-Priest.32.png"));
		menu_nv.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Phục vụ");
		mntmNewMenuItem_3.setIcon(new ImageIcon("D:\\JAVA\\icon\\Iconshock-Real-Vista-Jobs-Asian.32.png"));
		menu_nv.add(mntmNewMenuItem_3);
		
		JPanel panel_thong_tin = new JPanel();
		panel_thong_tin.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_thong_tin.setBounds(10, 46, 690, 491);
		add(panel_thong_tin);
		panel_thong_tin.setLayout(null);
		
	}
}
