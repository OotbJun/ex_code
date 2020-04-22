package com.ja.freeboard.controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ja.freeboard.model.Memberdao;
import com.ja.freeboard.vo.MemberVo;

public class LoginProcessHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		
		String m_id = request.getParameter("m_id");
		String m_pw = request.getParameter("m_pw");
		
		MemberVo memberVo = new Memberdao().selectByIdAndPw(m_id, m_pw);
		
		if(memberVo != null) {
			//로그인 성공
			//세션에 값을 넣고 메인페이지로 리다이렉트한다.
			request.getSession().setAttribute("sessionUserInfo", memberVo);
			
			return "redirect:./main_page.do";
			//return "/WEB-INF/view/main_page.jsp";  
			//메인페이지 핸들러에서 데이터를 넘겨주고 view 로 보내는 구조이기 때문에 포워딩을 하면 데이터없이 화면이 출력된다. 
			//데이터 구성을 하고 jsp 페이지를 선택할 수 있어야 한다.
			
		}else {
			return "/WEB-INF/view/login_fail.jsp";
		}
			
	
	
	}

}
