package Main.model;

import java.util.ArrayList;

public class QLNV {
	
	private ArrayList<NhanVien> dsNhanVien;

	public QLNV() {
		
	}

	public QLNV(ArrayList<NhanVien> dsNhanVien) {
		this.dsNhanVien = dsNhanVien;
	}

	public ArrayList<NhanVien> getDsNhanVien() {
		return dsNhanVien;
	}

	public void setDsNhanVien(ArrayList<NhanVien> dsNhanVien) {
		this.dsNhanVien = dsNhanVien;
	}	
}