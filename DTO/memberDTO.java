package membertest.DTO;

public class memberDTO {
	// ���� ��ü ���
	// �ʵ�
	private int mno;
	private String name;
	private String id;
	private String pw;
	//���尴ü���
	private int bno;
	private String btitle 	;
	private String bcontent ;
	private String bwriter ;
	
	
	
	
	
	
	//���ͼ���
	
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

	// �޼��� ����(���)����(�Է�)
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
