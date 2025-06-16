package membertest.DTO;

public class memberDTO {
	// 계정 객체 담당
	// 필드
	private int mno;
	private String name;
	private String id;
	private String pw;
	//보드객체담당
	private int bno;
	private String btitle 	;
	private String bcontent ;
	private String bwriter ;
	
	
	
	
	
	
	//게터세터
	
	public int getBno() {
		return bno;
	}

	public String getBtitle() {
		return btitle;
	}

	public String getBcontent() {
		return bcontent;
	}

	public String getBwriter() {
		return bwriter;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}

	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}

	public void setBwriter(String bwriter) {
		this.bwriter = bwriter;
	}

	// 메서드 게터(출력)세터(입력)
	public int getMno() {
		return mno;
	}

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

	public String getPw() {
		return pw;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

}
