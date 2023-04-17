package Main.model;

import java.sql.Date;
import java.time.DateTimeException;

public class san_bong {
	private int so_san;
	private int loai_san;
	private boolean check;
	private String trang_thai_san;
	private Date ngay_da;
	private int maS;
	
	public Date getNgay_da() {
		return ngay_da;
	}

	public void setNgay_da(Date ngay_da) {
		this.ngay_da = ngay_da;
	}

	public DateTimeException getThoi_gian() {
		return thoi_gian;
	}

	public void setThoi_gian(DateTimeException thoi_gian) {
		this.thoi_gian = thoi_gian;
	}

	public san_bong(int so_san, int loai_san, boolean check, String trang_thai_san, Date ngay_da, int maS,
			DateTimeException thoi_gian) {
		this.so_san = so_san;
		this.loai_san = loai_san;
		this.check = check;
		this.trang_thai_san = trang_thai_san;
		this.ngay_da = ngay_da;
		this.maS = maS;
		this.thoi_gian = thoi_gian;
	}

	private DateTimeException thoi_gian;

	public san_bong() {

	}

	public san_bong(int so_san, int loai_san, boolean check, int maS) {
		super();
		this.so_san = so_san;
		this.loai_san = loai_san;
		this.check = check;
		this.maS = maS;
	}

	public int getMaS() {
		return maS;
	}

	public void setMaS(int maS) {
		this.maS = maS;
	}

	public int getSo_san() {
		return so_san;
	}

	public void setSo_san(int so_san) {
		this.so_san = so_san;
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
		this.setTrang_thai_san();
		return trang_thai_san;
	}

	public void setTrang_thai_san() {
		if(this.isCheck()==true) {
			this.trang_thai_san = "bận";
		}
		else {
			this.trang_thai_san ="trống";
		}
	}

}
