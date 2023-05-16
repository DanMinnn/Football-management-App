package Main.model;

import java.sql.Date;

public class NhanVien {
	private int ID;
	private String HoTen;
	private String GioiTinh;
	private Date NamSinh;
	private String SDT;
	private String DiaChi;
	
	
	public NhanVien() {
	}


	public NhanVien(int iD, String hoTen, String gioiTinh, Date namSinh, String sDT, String diaChi) {
		ID = iD;
		HoTen = hoTen;
		GioiTinh = gioiTinh;
		NamSinh = namSinh;
		SDT = sDT;
		DiaChi = diaChi;
	}


	public int getID() {
		return ID;
	}


	public void setID(int iD) {
		ID = iD;
	}


	public String getHoTen() {
		return HoTen;
	}


	public void setHoTen(String hoTen) {
		HoTen = hoTen;
	}


	public String getGioiTinh() {
		return GioiTinh;
	}


	public void setGioiTinh(String gioiTinh) {
		GioiTinh = gioiTinh;
	}


	public Date getNamSinh() {
		return NamSinh;
	}


	public void setNamSinh(Date namSinh) {
		NamSinh = namSinh;
	}


	public String getSDT() {
		return SDT;
	}


	public void setSDT(String sDT) {
		SDT = sDT;
	}


	public String getDiaChi() {
		return DiaChi;
	}


	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}
	
	

	@Override
	public String toString() {
		return "NhanVien [ID=" + ID + ", HoTen=" + HoTen + ", GioiTinh=" + GioiTinh + ", NamSinh=" + NamSinh + ", SDT="
				+ SDT + ", DiaChi=" + DiaChi + "]";
	}

}
