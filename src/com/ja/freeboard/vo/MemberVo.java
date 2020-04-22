package com.ja.freeboard.vo;

import java.util.Date;

//데이터테이블의 컬럼명을 그대로 써서 작성한다.
//데이터테이블의 데이터 타입을 그대로 작성해도 된다.
public class MemberVo {

	private int m_no;
	private String m_id;
	private String m_pw;
	private String m_nick;
	private String m_phone;
	private Date m_joindate;
	
	//기본생성자를 쓰지 않지만 spring 프레임워크 할때는 쓴다.
	public MemberVo() {
		super();
	}

	public MemberVo(int m_no, String m_id, String m_pw, String m_nick, String m_phone, Date m_joindate) {
		super();
		this.m_no = m_no;
		this.m_id = m_id;
		this.m_pw = m_pw;
		this.m_nick = m_nick;
		this.m_phone = m_phone;
		this.m_joindate = m_joindate;
	}

	public int getM_no() {
		return m_no;
	}

	public void setM_no(int m_no) {
		this.m_no = m_no;
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public String getM_pw() {
		return m_pw;
	}

	public void setM_pw(String m_pw) {
		this.m_pw = m_pw;
	}

	public String getM_nick() {
		return m_nick;
	}

	public void setM_nick(String m_nick) {
		this.m_nick = m_nick;
	}

	public String getM_phone() {
		return m_phone;
	}

	public void setM_phone(String m_phone) {
		this.m_phone = m_phone;
	}

	public Date getM_joindate() {
		return m_joindate;
	}

	public void setM_joindate(Date m_joindate) {
		this.m_joindate = m_joindate;
	}
		
	

	
	
}



