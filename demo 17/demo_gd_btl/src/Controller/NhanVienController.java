package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import Admin.Nhan_vien;
import Main.model.NhanVien;

public class NhanVienController implements ActionListener{
	public Nhan_vien nv;
	
	
	
	public NhanVienController(Nhan_vien nv) {
		this.nv = nv;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		String cm = e.getActionCommand();
		//JOptionPane.showMessageDialog(nv, "Bạn vừa nhấn vào " + cm);
		if(cm.equals("Thêm")) {
			this.nv.xoaForm();
		} else if(cm.equals("Lưu")) {
			try {
				String ID = this.nv.txt_ID.getText();
				String HoTen = this.nv.txt_hoTen.getText();
				String gioiTinh = (String) this.nv.comboBox_gioiTinh.getSelectedItem();
				String s_namSinh =  this.nv.txt_NamSinh.getText();
				Date namSinh = Date.valueOf(s_namSinh);
				String sDT = this.nv.txt_SĐT.getText();
				String diaChi = this.nv.txt_diaChi.getText();
				
				String regexPhoneNumber = "^0[35789]{1}\\d{8}$";
				Pattern p = Pattern.compile(regexPhoneNumber);
				Matcher m = p.matcher(sDT);
				if(m.find()) {
					NhanVien nv = new NhanVien(ID, HoTen, gioiTinh, namSinh, sDT, diaChi);
					
					this.nv.themNhanVienVaoBang(nv);
				}else {
					JOptionPane.showMessageDialog(nv, "Số điện thoại không hợp lệ !");
				}
			
			} catch (NumberFormatException e1) {
				e1.printStackTrace();
			}
		} else if(cm.equals("Cập nhật")) {
			this.nv.capNhatThongTinNhanVien();
		} else if(cm.equals("Xóa")) {
			this.nv.xoaNhanVien();
		} else if(cm.equals("Tìm")) {
			this.nv.Tim();
		}
		
	}
	
}