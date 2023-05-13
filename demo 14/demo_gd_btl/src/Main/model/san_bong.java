package Main.model;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.util.ArrayList;

import com.toedter.calendar.JDateChooser;

public class san_bong {
	
	
	private String id_CS;
	private String id_San;
	private String ten_san;
	private float gia_tien;
	private String loai_san;
		
	public san_bong() {
	}
	

	public String getTen_san() {
		return ten_san;
	}

	public void setTen_san(String ten_san) {
		this.ten_san = ten_san;
	}

	public String getID_San() {
		return id_San;
	}

	public void setID_San(String id_cs,String ten_san) {
		this.id_San = id_cs +"."+ ten_san;
	}
	
	public void setID_San(String ma_san) {
		this.id_San = ma_san;
	}
	public float getGia_tien() {
		return gia_tien;
	}


	public void setGia_tien(float gia_tien) {
		this.gia_tien = gia_tien;
	}


	public String getLoai_san() {
		return loai_san;
	}

	public void setLoai_san(String loai_san) {
		this.loai_san = loai_san;
	}
	
	public String getID_cs() {
		return id_CS;
	}

	public void setID_cs(String ma_cs) {
		this.id_CS = ma_cs;
	}

}
