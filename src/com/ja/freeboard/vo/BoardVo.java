package com.ja.freeboard.vo;

import java.util.Date;

public class BoardVo {
	
	private int b_no;
	private int m_no;
	private String b_title;
	private String b_content;
	private Date b_writedate;

	public BoardVo() {
		super();
	}

	public BoardVo(int b_no, int m_no, String b_title, String b_content, Date b_writedate) {
		super();
		this.b_no = b_no;
		this.m_no = m_no;
		this.b_title = b_title;
		this.b_content = b_content;
		this.b_writedate = b_writedate;
	}

	public int getB_no() {
		return b_no;
	}

	public void setB_no(int b_no) {
		this.b_no = b_no;
	}

	public int getM_no() {
		return m_no;
	}

	public void setM_no(int m_no) {
		this.m_no = m_no;
	}

	public String getB_title() {
		return b_title;
	}

	public void setB_title(String b_title) {
		this.b_title = b_title;
	}

	public String getB_content() {
		return b_content;
	}

	public void setB_content(String b_content) {
		this.b_content = b_content;
	}

	public Date getB_writedate() {
		return b_writedate;
	}

	public void setB_writedate(Date b_writedate) {
		this.b_writedate = b_writedate;
	}
	
	

}
