package Main.model;

import java.sql.Date;
import java.time.DateTimeException;

public class san_bong {
	
	private int ma_San;
	private String ten_san;
	private int loai_san;
	
	private Date ngay_da;
	private Date thoi_gian_da;
	
	private boolean check;
	private String trang_thai_san;
	
	
	public san_bong() {

	}
	
	public san_bong(int ma_San, String ten_san, int loai_san, Date ngay_da, Date thoi_gian_da, boolean check,
			String trang_thai_san, int maS) {
		this.ma_San = ma_San;
		this.ten_san = ten_san;
		this.loai_san = loai_san;
		this.ngay_da = ngay_da;
		this.thoi_gian_da = thoi_gian_da;
		this.check = check;
		this.trang_thai_san = trang_thai_san;
		this.maS = maS;
	}

	public String getTen_san() {
		return ten_san;
	}

	public void setTen_san(String ten_san) {
		this.ten_san = ten_san;
	}

	public Date getThoi_gian_da() {
		return thoi_gian_da;
	}

	public void setThoi_gian_da(Date thoi_gian_da) {
		this.thoi_gian_da = thoi_gian_da;
	}

	private int maS;
	
	public Date getNgay_da() {
		return ngay_da;
	}

	public void setNgay_da(Date ngay_da) {
		this.ngay_da = ngay_da;
	}

	
	public int getMa_San() {
		return ma_San;
	}

	public void setMa_San(int ma_San) {
		this.ma_San = ma_San;
	}
	
	public int getLoai_san() {
		return loai_san;
	}

	public void setLoai_san(int loai_san) {
		this.loai_san = loai_san;
	}
	public boolean isCheck() {
		return check;
	}

	public void setCheck(boolean check) {
		this.check = check;
	}

	public String getTrang_thai_san() {
		return trang_thai_san;
	}

	public void setTrang_thai_san(String trang_thai_san) {
			this.trang_thai_san = trang_thai_san;
	}

}
