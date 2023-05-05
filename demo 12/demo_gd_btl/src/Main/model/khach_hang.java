package Main.model;

import java.sql.Date;

public class khach_hang {
	private String ten;
	private String so_dien_thoai;
	private String email;
	private Date ngay_sinh;

	public khach_hang(){
	}

	public khach_hang(String ten, String so_dien_thoai, String email, Date ngay_sinh) {
		this.ten = ten;
		this.so_dien_thoai = so_dien_thoai;
		this.email = email;
		this.ngay_sinh = ngay_sinh;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getSo_dien_thoai() {
		return so_dien_thoai;
	}

	public void setSo_dien_thoai(String so_dien_thoai) {
		this.so_dien_thoai = so_dien_thoai;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getNgay_sinh() {
		return ngay_sinh;
	}

	public void setNgay_sinh(Date ngay_sinh) {
		this.ngay_sinh = ngay_sinh;
	}

}
