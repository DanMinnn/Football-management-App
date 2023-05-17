package Main.model;


public class khach_hang {
	
	private String hoTen;
	private String soDienThoai;

	public khach_hang(){
	}
	
	
	public khach_hang(String hoTen, String soDienThoai) {
		this.hoTen = hoTen;
		this.soDienThoai = soDienThoai;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

}
