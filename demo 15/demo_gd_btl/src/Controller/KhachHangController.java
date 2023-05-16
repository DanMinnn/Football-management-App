package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import Admin.Khach_hang;
import Main.model.khach_hang;

public class KhachHangController implements ActionListener {
	public Khach_hang kh;
	
	
	public KhachHangController(Khach_hang kh) {
		this.kh = kh;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String cm = e.getActionCommand();
		if(cm.equals("Thêm")) {
			this.kh.xoaForm();
		} else if(cm.equals("Lưu")) {
			try {
				String HoTen = this.kh.txt_hoTenKH.getText();
				String sID = this.kh.txt_ID_sDT_KH.getText();
				String regexPhoneNumber = "^0[35789]{1}\\d{8}$";
				Pattern p = Pattern.compile(regexPhoneNumber);
				Matcher m = p.matcher(sID);
				if(m.find()) {
					
					khach_hang kh = new khach_hang(HoTen, sID);
					
					this.kh.themKhachHang(kh);
				}else {
					JOptionPane.showMessageDialog(kh, "Số điện thoại không hợp lệ !");
				}
			} catch (NumberFormatException e1) {
				e1.printStackTrace();
			}
		} else if(cm.equals("Cập nhật")) {
			this.kh.capNhatKhachHang();
		} else if(cm.equals("Xóa")) {
			this.kh.xoaKhachHang();
		} else if(cm.equals("Find")) {
			this.kh.TimKhachHang();
		}
			
	}

}