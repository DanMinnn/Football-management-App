package Co_so;

import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.Box;
import javax.swing.border.LineBorder;

import Co_so_view.Co_so1_san5_view;
import Co_so_view.Co_so1_san7_view;
import Co_so_view.Nhan_vien_cs1_view;

import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Label;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JScrollBar;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.Choice;
import java.awt.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Co_so_1 extends JPanel {
	
		
	//private Image img_s = new ImageIcon(Co_so_1.class.getResource("img_/icon cơ sở.png")).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
	
	private Co_so1_san5_view cs1_s5;
	private Co_so1_san7_view cs1_s7;
	private Nhan_vien_cs1_view nv_cs1;
	/**
	 * Create the panel.
	 */
	public Co_so_1() {
		
		setBounds(0,0,710,550);
		setLayout(null);
		
		setVisible(true);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Segoe UI", Font.BOLD, 15));
		menuBar.setBackground(new Color(255, 255, 255));
		menuBar.setBounds(0, 0, 710, 36);
		this.add(menuBar);
		
		
		cs1_s5= new Co_so1_san5_view();
		cs1_s5.setBounds(0, 0, 710, 503);
		cs1_s7= new Co_so1_san7_view();
		nv_cs1 = new Nhan_vien_cs1_view();
		
		JMenu Menu_san = new JMenu("Sân bóng");
		//Menu_san.setIcon(new ImageIcon(img_s));
		Menu_san.setIcon(new ImageIcon("D:\\JAVA\\icon\\icon cơ sở.png"));
		Menu_san.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(Menu_san);
		
		JMenuItem item_san7 = new JMenuItem("Sân 7");
		item_san7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuClicked_cs1(cs1_s7);
			}
		});
		item_san7.setIcon(new ImageIcon("D:\\JAVA\\icon\\icon cơ sở.png"));
		Menu_san.add(item_san7);
		
		JMenuItem item_san5 = new JMenuItem("Sân 5");
		item_san5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuClicked_cs1(cs1_s5);
			}
		});
		
		item_san5.setIcon(new ImageIcon("D:\\JAVA\\icon\\icon cơ sở.png"));
		Menu_san.add(item_san5);
		
		JMenu menu_nv = new JMenu("Nhân viên");
		menu_nv.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked_cs1(nv_cs1);
			}
		});
//		menu_nv.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				menuClicked_cs1(nv_cs1);
//			}
//		});
		menu_nv.setIcon(new ImageIcon("D:\\JAVA\\icon\\Iconshock-Real-Vista-Jobs-Asian.32.png"));
		menuBar.add(menu_nv);
		
		JPanel panel_thong_tin = new JPanel();
		panel_thong_tin.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_thong_tin.setBounds(0, 37, 710, 503);
		this.add(panel_thong_tin);
		panel_thong_tin.setLayout(null);
		panel_thong_tin.add(cs1_s5);
		panel_thong_tin.add(cs1_s7);
		panel_thong_tin.add(nv_cs1);
		
		menuClicked_cs1(cs1_s7);
		
	}
	
	public void menuClicked_cs1(JPanel panel) {
		cs1_s5.setVisible(false);
		cs1_s7.setVisible(false);
		nv_cs1.setVisible(false);
		
		panel.setVisible(true);
	}
	
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
