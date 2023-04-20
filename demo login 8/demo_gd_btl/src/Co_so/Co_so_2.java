package Co_so;

import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.Box;
import javax.swing.border.LineBorder;

import Co_so_view.*;

import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Label;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Co_so_2 extends JPanel {

	private Co_so2_san5_view cs2_s5;
	private Co_so2_san7_view cs2_s7;
	private Nhan_vien_cs2_view nv_cs2;

	/**
	 * Create the panel.
	 */
	public Co_so_2() {
		setBounds(0, 0, 710, 550);
		setLayout(null);
		setVisible(true);

		cs2_s5 = new Co_so2_san5_view();
		cs2_s7 = new Co_so2_san7_view();
		nv_cs2 = new Nhan_vien_cs2_view();

		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Segoe UI", Font.BOLD, 15));
		menuBar.setBackground(new Color(255, 255, 255));
		menuBar.setBounds(0, 0, 710, 36);
		add(menuBar);

		JMenu Menu_san = new JMenu("Sân bóng");
		Image icon_menu_san = new ImageIcon(this.getClass().getResource("/icon cơ sở.png")).getImage();
		Menu_san.setIcon(new ImageIcon(icon_menu_san));
		Menu_san.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(Menu_san);

		JMenuItem item_san7 = new JMenuItem("Sân 7");
		item_san7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuClicked_cs2(cs2_s7);
			}
		});
		item_san7.setIcon(new ImageIcon(icon_menu_san));
		Menu_san.add(item_san7);

		JMenuItem item_san5 = new JMenuItem("Sân 5");
		item_san5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuClicked_cs2(cs2_s5);
			}
		});

		item_san5.setIcon(new ImageIcon(icon_menu_san));
		Menu_san.add(item_san5);

		JMenu menu_nv = new JMenu("Nhân viên");
		menu_nv.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked_cs2(nv_cs2);
			}
		});
		Image icon_nv = new ImageIcon(this.getClass().getResource("/nhan vien.png")).getImage();
		menu_nv.setIcon(new ImageIcon(icon_nv));
		menuBar.add(menu_nv);

		JPanel panel_thong_tin = new JPanel();
		panel_thong_tin.setBounds(0, 34, 710, 506);
		add(panel_thong_tin);
		panel_thong_tin.setLayout(null);
		panel_thong_tin.add(cs2_s5);
		panel_thong_tin.add(cs2_s7);
		panel_thong_tin.add(nv_cs2);
		menuClicked_cs2(cs2_s7);

	}

	public void menuClicked_cs2(JPanel panel) {
		cs2_s5.setVisible(false);
		cs2_s7.setVisible(false);
		nv_cs2.setVisible(false);

		panel.setVisible(true);
	}

}
