package ex03.model;

// VO  : value Object( new )
// DTO : data transfer Object (old)

// 우편번호 테이블 - 레코드
public class PostVo {
	// Fields
	private  String  zipcode;
	private  String  sido;
	private  String  gugun;
	private  String  dong;
	private  String  bunji;
	private  int     seq;	
	
	// Constructor
	public PostVo() {}
	
	public PostVo(String zipcode, String sido, String gugun, String dong, String bunji, int seq) {
		this.zipcode = zipcode;
		this.sido = sido;
		this.gugun = gugun;
		this.dong = dong;
		this.bunji = bunji;
		this.seq = seq;
	}
	
	// Getter / Setter
	public String getZipcode() {
		return zipcode;
	}
	public String getSido() {
		return sido;
	}
	public String getGugun() {
		return gugun;
	}
	public String getDong() {
		return dong;
	}
	public String getBunji() {
		return bunji;
	}
	public int getSeq() {
		return seq;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public void setSido(String sido) {
		this.sido = sido;
	}
	public void setGugun(String gugun) {
		this.gugun = gugun;
	}
	public void setDong(String dong) {
		this.dong = dong;
	}
	public void setBunji(String bunji) {
		this.bunji = bunji;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	
	// toString
	@Override
	public String toString() {
		return "PostVo [zipcode=" + zipcode + ", sido=" + sido + ", gugun=" + gugun + ", dong=" + dong + ", bunji="
				+ bunji + ", seq=" + seq + "]";
	}
	
}
