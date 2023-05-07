package Main.model;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.util.ArrayList;

import com.toedter.calendar.JDateChooser;

public class san_bong {
	
	
	private String ma_cs;
	private String ma_San;
	private String ten_san;
	private String loai_san;
	private String ngay_da;
	private String thoi_gian_da;
		
	public san_bong() {
	}
	

	public String getTen_san() {
		return ten_san;
	}

	public void setTen_san(String ten_san) {
		this.ten_san = ten_san;
	}

	public String getThoi_gian_da() {
		return thoi_gian_da;
	}

	public void setThoi_gian_da(String thoi_gian_da) {
		this.thoi_gian_da = thoi_gian_da;
	}
	
	public String getNgay_da() {
		return ngay_da;
	}
	
	public void setNgay_da(String ngay_da) {
		this.ngay_da = ngay_da;
	}

	public String getMa_San() {
		return ma_San;
	}

	public void setMa_San(String ma_cs,String ten_san) {
		this.ma_San = ma_cs +"."+ ten_san;
	}
	public void setMa_San(String ma_san) {
		this.ma_San = ma_san;
	}
	
	
	public String getLoai_san() {
		return loai_san;
	}

	public void setLoai_san(String loai_san) {
		this.loai_san = loai_san;
	}
	
	public String getMa_cs() {
		return ma_cs;
	}

	public void setMa_cs(String ma_cs) {
		this.ma_cs = ma_cs;
	}

}
