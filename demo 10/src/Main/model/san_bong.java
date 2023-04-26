package Main.model;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;

import com.toedter.calendar.JDateChooser;

public class san_bong {
	
	//private khach_hang kh;
	
	private String ma_San;
	private String ten_san;
	private int loai_san;
	private int Stt;
	
	public int getStt() {
		return Stt;
	}

	public void setStt(int stt) {
		Stt = stt;
	}

	//private String ngay_da;
	private String ngay_da;
	private String thoi_gian_da;

	//private boolean check;
	private String trang_thai_san;
	
	
	public san_bong() {
	}
	
	public san_bong(String ma_San, String ten_san, int loai_san, String ngay_da, String thoi_gian_da,
			String trang_thai_san) {
		this.ma_San = ma_San;
		this.ten_san = ten_san;
		this.loai_san = loai_san;
		this.ngay_da = ngay_da;
		this.thoi_gian_da = thoi_gian_da;
		this.trang_thai_san = trang_thai_san;
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

	public void setMa_San(String ma_San) {
		this.ma_San = ma_San;
	}
	
	public int getLoai_san() {
		return loai_san;
	}

	public void setLoai_san(int loai_san) {
		this.loai_san = loai_san;
	}
	
	public String getTrang_thai_san() {
		return trang_thai_san;
	}

	public void setTrang_thai_san(String trang_thai_san) {
			this.trang_thai_san = trang_thai_san;
	}


}
