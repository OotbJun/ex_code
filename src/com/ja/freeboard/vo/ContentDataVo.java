package com.ja.freeboard.vo;

public class ContentDataVo {
	private MemberVo memberVo;
	private BoardVo boardVo;

	public ContentDataVo() {
		super();
	}
	public ContentDataVo(MemberVo memberVo, BoardVo boardVo) {
		super();
		this.memberVo = memberVo;
		this.boardVo = boardVo;
	}
	public MemberVo getMemberVo() {
		return memberVo;
	}
	public void setMemberVo(MemberVo memberVo) {
		this.memberVo = memberVo;
	}
	public BoardVo getBoardVo() {
		return boardVo;
	}
	public void setBoardVo(BoardVo boardVo) {
		this.boardVo = boardVo;
	}
	
	

}
