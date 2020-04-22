package com.ja.freeboard.controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ja.freeboard.model.Boarddao;
import com.ja.freeboard.vo.MemberVo;

public class WriteContentProcessHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		
		String b_title = request.getParameter("b_title");
		String b_content = request.getParameter("b_content");
		MemberVo memberVo = (MemberVo) request.getSession().getAttribute("sessionUserInfo"); 
								//MemberVo 형태로 받기 때문에 캐스팅 해준다.
		int m_no = memberVo.getM_no();
		
		new Boarddao().insert(m_no, b_title, b_content);
		
		return "redirect:./main_page.do";
	}
}
