package Main.model;

import java.sql.Date;

public class NhanVien {
	private String ID;
	private String HoTen;
	private String GioiTinh;
	private Date NamSinh;
	private String SDT;
	private String DiaChi;
	
	private String iD_CoSo;
	private String ID_SDT_KH;
	
	public NhanVien() {
	}


	public NhanVien(String iD, String hoTen, String gioiTinh, Date namSinh, String sDT, String diaChi) {
		ID = iD;
		HoTen = hoTen;
		GioiTinh = gioiTinh;
		NamSinh = namSinh;
		SDT = sDT;
		DiaChi = diaChi;
	}

	
	
	public NhanVien(String iD, String hoTen, String gioiTinh, Date namSinh, String sDT, String diaChi, String iD_CoSo) {
		ID = iD;
		HoTen = hoTen;
		GioiTinh = gioiTinh;
		NamSinh = namSinh;
		SDT = sDT;
		DiaChi = diaChi;
		this.iD_CoSo = iD_CoSo;
	}


	public String getID() {
		return ID;
	}


	public void setID(String iD) {
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


	public String getiD_CoSo() {
		return iD_CoSo;
	}


	public void setiD_CoSo(String iD_CoSo) {
		this.iD_CoSo = iD_CoSo;
	}


	public String getID_SDT_KH() {
		return ID_SDT_KH;
	}


	public void setID_SDT_KH(String iD_SDT_KH) {
		ID_SDT_KH = iD_SDT_KH;
	}


	@Override
	public String toString() {
		return "NhanVien [ID=" + ID + ", HoTen=" + HoTen + ", GioiTinh=" + GioiTinh + ", NamSinh=" + NamSinh + ", SDT="
				+ SDT + ", DiaChi=" + DiaChi + ", iD_CoSo=" + iD_CoSo + ", ID_SDT_KH=" + ID_SDT_KH + "]";
	}
	
	
}